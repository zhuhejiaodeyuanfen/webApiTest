package com.vivian.sql.model;

import java.sql.Timestamp;

public class MsgModel {

    private int msgId;
    private int msgFromId;
    private int msgToId;
    private int msgType;
    private int isUserReply;
    private String msgContent;
    private Timestamp msgTime;

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public int getMsgFromId() {
        return msgFromId;
    }

    public void setMsgFromId(int msgFromId) {
        this.msgFromId = msgFromId;
    }

    public int getMsgToId() {
        return msgToId;
    }

    public void setMsgToId(int msgToId) {
        this.msgToId = msgToId;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public int getIsUserReply() {
        return isUserReply;
    }

    public void setIsUserReply(int isUserReply) {
        this.isUserReply = isUserReply;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Timestamp getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Timestamp msgTime) {
        this.msgTime = msgTime;
    }
}
