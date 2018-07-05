package com.myGWTLightBox.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MyGWTLightBoxService")
public interface MyGWTLightBoxService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use MyGWTLightBoxService.App.getInstance() to access static instance of MyGWTLightBoxServiceAsync
     */
    public static class App {
        private static MyGWTLightBoxServiceAsync ourInstance = GWT.create(MyGWTLightBoxService.class);

        public static synchronized MyGWTLightBoxServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
