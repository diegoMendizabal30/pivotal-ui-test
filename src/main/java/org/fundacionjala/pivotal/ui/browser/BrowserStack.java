package org.fundacionjala.pivotal.ui.browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.pivotal.utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class initialize the Remote Selenium Web Driver.
 */
class BrowserStack implements Driver {

    private static final Logger LOGGER = LogManager.getLogger(BrowserStack.class);

    private static final Environment ENVIRONMENT = Environment.getInstance();

    private static final String HTTPS_PROXY_HOST = "https.proxyHost";

    private static final String HTTPS_PROXY_PORT = "https.proxyPort";

    private static final String BROWSER = "browser";

    private static final String BROWSER_STACK_DEBUG = "browserstack.debug";

    private static final String BROWSER_VERSION = "browser_version";

    private static final String OS = "os";

    private static final String OS_VERSION = "os_version";

    private static final String RESOLUTION = "resolution";

    private static final String VALUE = "true";

    private static final String FIRST_BUILD = "First build";

    private static final String BUILD = "build";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        final String url = String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub",
                ENVIRONMENT.getRemoteUserName(),
                ENVIRONMENT.getRemoteKey());
        DesiredCapabilities caps = new DesiredCapabilities();
        //Setting proxy.
        if (!ENVIRONMENT.getProxy().isEmpty()) {
            System.getProperties().put(HTTPS_PROXY_HOST, ENVIRONMENT.getHost());
            System.getProperties().put(HTTPS_PROXY_PORT, ENVIRONMENT.getPort());
        }
        caps.setCapability(BROWSER, ENVIRONMENT.getRemoteBrowser());
        caps.setCapability(BROWSER_VERSION, ENVIRONMENT.getRemoteBrowserVersion());
        caps.setCapability(OS, ENVIRONMENT.getRemotePlatform());
        caps.setCapability(OS_VERSION, ENVIRONMENT.getRemotePlatformVersion());
        caps.setCapability(RESOLUTION, ENVIRONMENT.getRemoteResolution());
        caps.setCapability(BROWSER_STACK_DEBUG, VALUE);
        caps.setCapability(BUILD, FIRST_BUILD);
        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(url), caps);
        } catch (MalformedURLException e) {
            LOGGER.warn(e.getMessage(), e);
            throw new RuntimeException();
        }
        return remoteWebDriver;
    }
}
