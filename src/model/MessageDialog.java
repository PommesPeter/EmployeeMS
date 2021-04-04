package model;

import javax.swing.*;

public class MessageDialog {

    String type;
    String title;
    Integer messageType;
    String content;
    public MessageDialog(String type, Integer messageTypeString, String title, String content) {
        this.type = type;
        this.title = title;
        this.messageType = messageTypeString;
        this.content = content;
    }

    public void show() {
        if (this.type.equals("message")) {
            JOptionPane.showMessageDialog(null, this.title, this.content, this.messageType);
        }
    }

}
