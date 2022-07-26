package com.aabbcc.Resp;

import java.util.List;

public class GroupMessage {
    String type;
    Sender sender;
    List<MessageType> messageChain;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public List<MessageType> getMessageChain() {
        return messageChain;
    }

    public void setMessageChain(List<MessageType> messageChain) {
        this.messageChain = messageChain;
    }
}
