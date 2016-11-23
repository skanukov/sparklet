package com.github.skanukov.sparklet;

import com.github.skanukov.sparklet.apps.web.WebRouter;
import com.github.skanukov.sparklet.core.config.SettingsFactory;
import com.github.skanukov.sparklet.core.route.Dispatcher;
import com.github.skanukov.sparklet.core.route.StaticFilesRouter;

/**
 * Handles all routes for applications.
 */
public final class ApplicationDispatcher implements Dispatcher {
    /**
     * Defines mount points for applications.
     */
    @Override
    public void dispatch() {
        // Handle static files for development mode
        if (SettingsFactory.getSettings().get("isDebug").getAsBoolean()) {
            StaticFilesRouter.handleStaticFiles();
        }

        new WebRouter().route();
    }
}