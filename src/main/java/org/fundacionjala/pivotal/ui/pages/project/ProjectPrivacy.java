package org.fundacionjala.pivotal.ui.pages.project;

/**
 * Created by Administrator on 10/13/2016.
 */
public enum ProjectPrivacy {
    PRIVATE,
    PUBLIC;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
