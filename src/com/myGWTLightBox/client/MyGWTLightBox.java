package com.myGWTLightBox.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Frame;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MyGWTLightBox implements EntryPoint {


    private static class MyDialog extends DialogBox {

        public MyDialog() {
            // Set the dialog box's caption.
            setText("My First Dialog");

            // Enable animation.
            setAnimationEnabled(true);

            // Enable glass background.
            setGlassEnabled(true);

            // DialogBox is a SimplePanel, so you have to set its widget property to
            // whatever you want its contents to be.
            Button ok = new Button("OK");
            ok.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    MyDialog.this.hide();
                }
            });
            //Label label = new Label("This is a simple dialog box.");
            HTML html = new HTML("<div id='root'></div>");
            //Frame frame = new Frame("http://www.google.com/");
            VerticalPanel panel = new VerticalPanel();
            panel.setHeight("100");
            panel.setWidth("300");
            panel.setSpacing(10);
            panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
           // panel.add(frame);
            panel.add(ok);

            FlowPanel fp = new FlowPanel();
            Frame frame = new Frame("http://localhost:3000/");
            frame.setHeight("500");
            frame.setWidth("500");
            fp.add(frame);
            fp.add(ok);
            setWidget(fp);
           // setWidget(ok);
        }
    }

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final Button button = new Button("Click me");
        //final Label label = new Label();

//        Element head = Document.get().getElementsByTagName("head").getItem(0);
//        ScriptElement sce = Document.get().createScriptElement();
//        sce.setType("text/javascript");
//        sce.setSrc("./com/myGWTLightBox/build/static/js/main.43fdbc98.js");
//        //../src/com/myGWTLightBox/build/static/js/main.43fdbc98.js
//        head.appendChild(sce);

        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                // Instantiate the dialog box and show it.
                MyDialog myDialog = new MyDialog();

                int left = Window.getClientWidth()/ 2;
                int top = Window.getClientHeight()/ 2;
                myDialog.setPopupPosition(left, top);
                myDialog.show();
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("slot1").add(button);
       // RootPanel.get("slot2").add(label);
    }

//    public void onClick(Widget sender) {
//        // Instantiate the dialog box and show it.
//        new MyDialog().show();
//    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
