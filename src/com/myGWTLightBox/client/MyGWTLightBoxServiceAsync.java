package com.myGWTLightBox.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MyGWTLightBoxServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
