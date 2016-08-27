package com.github.skanukov.sparklet.config;

import com.github.skanukov.sparklet.apps.api.config.ApiRouter;
import com.github.skanukov.sparklet.apps.web.config.WebRouter;
import com.github.skanukov.sparklet.core.config.SettingsFactory;
import com.github.skanukov.sparklet.core.routing.Dispatcher;
import com.github.skanukov.sparklet.core.routing.StaticFilesRouter;

/**
 * Handles all routes for applications.
 */
public final class RouteDispatcher implements Dispatcher {
    /**
     * Defines mount points for applications.
     */
    @Override
    public void dispatch() {
        // Handle static files for development mode
        if (SettingsFactory.getSettings().get("debug").getAsBoolean()) {
            StaticFilesRouter.handleStaticFiles();
        }

        new WebRouter().route();
        new ApiRouter("/api").route();
    }
}
