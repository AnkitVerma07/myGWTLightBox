package com.myGWTLightBox.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myGWTLightBox.client.MyGWTLightBoxService;

public class MyGWTLightBoxServiceImpl extends RemoteServiceServlet implements MyGWTLightBoxService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}