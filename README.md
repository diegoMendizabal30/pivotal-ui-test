#PIVOTAL TRACKER FRAMEWORK

WHAT IS IT?
------------

Pivotal UI project has as main objective to automate acceptance test cases of Pivotal Tracker web application
and its main characteristics by using Selenium and Cucumber technology.

FEATURES TESTED
---------------

The following features are the main that are implemented in this framework.

   Acceptance tests.

   - Login
   - Project
   - Task
   - Workspace


REQUIREMENTS AND SET CONFIGURATIONS
-----------------------------------

To set the configuration of this framework is required the following:

   - IntelliJ idea IDE.
   - Download Gradle 3.0 or superior: https://gradle.org/gradle-download/
   - Clone/download the project from GitHub repository: https://github.com/AT-01/pivotal-ui-test.git

 Once those requirements are done, follow these steps:

   - Open the project downloaded with the IntelliJ IDE.
   - Open the Gradle properties file e.g. gradle.properties file
   - Set the required parameters:
       * user= Is the user account name of Pivotal Tracker.
       * password= Is the Password of the user in Pivotal Tracker.
       * proxy= Is the proxy configuration for pivotal api.(Set only if proxy is required)
       * token= Is the token of the service. (Pivotal Tracker Token).
       * host= Is the proxy host configuration for Pivotal Tracker.(Set only if proxy is required)
       * port= Is the proxy port configuration for Pivotal Tracker.(Set only if proxy is required)
       * browser= Is the browser where the test are going to be executed, it could have 3 values: Chrome, Firefox, Browserstack or Saucelabs.
          In case to fill with Browserstack or Saucelabs to remote execution, the following variables should have a configured value:
          - remoteUserName= Is the username of Saucelabs or Browserstack.
          - remoteKey= Is the key provided by your account on Saucelabs or Browserstack.
          - remoteBrowser= Is the browser that you want to execute your test remotely. (e.g. Chrome)
          - remoteBrowserVersion= Is the version of the browser wrote before ^. (e.g. 54.0)
          - remotePlatform= Is the OS where you want to execute your test. (e.g. Windows)
          - remotePlatformVersion= Is the OS version. (e.g. 8.1)
          - remoteResolution= Is the resolution of the screen. (e.g. 1920x1080)
   - After executing those steps the frame should be executed (In progress).
   - To execute by command line you can use the following: use proxy param if it is necessary and remote variables too.

       ```javascript

           gradle clean check executeFeatures -Ptoken=TOKEN
           -Pproxy=PROXY -Phost=HOST -Pport=PORT -Puser=PIVOTAL TRACKER USER -Ppassword=PIVOTAL TRACKER PASSWORD
           -PremoteUserName=REMOTE USERNAME -PremoteKey=REMOTE KEY -Pbrowser=BROWSER(COULD BE REMOTE AS BROWSERSTACK OR SAUCELABS)
           -PremoteBrowser=REMOTE BROWSER -PremoteBrowserVersion=REMOTE BROWSER VERSION
           -PremotePlatformVersion=OS VERSION -PremotePlatform=OS -PremoteResolution=RESOLUTION
       ```



CONTACTS
--------

   - If you want to be informed about new code releases, bug fixes,
     security fixes, general news and information about the Pivotal Tracker UI project
     check to the GitHub repository
     https://github.com/AT-01/pivotal-ui-test.git

CONTRIBUTORS
------------

Current contributors:

   - Lourdes Villca (lourdesVillca) - https://github.com/lourdesVillca
   - Ericka Viraca (ErickaViraca) - https://github.com/ErickaViraca
   - Angela Valdez (angy113) - https://github.com/angy113
   - Juana Rodriguez (JuanaRodriguez) - https://github.com/JuanaRodriguez
   - Aldo Balderrama (mabalderramav) - https://github.com/mabalderramav
   - Bruno Vasquez (brunovasquez) - https://github.com/brunovasquez
   - Jimmy Romero S. (JimmyRomero) - https://github.com/JimmyRomero
   - Alvaro Daza (AlvaroDazaQuiroga) - https://github.com/AlvaroDazaQuiroga
   - Carlos Gonzales (carledriss) - https://github.com/carledriss