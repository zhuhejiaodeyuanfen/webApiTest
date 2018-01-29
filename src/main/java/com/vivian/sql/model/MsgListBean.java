package com.vivian.sql.model;

public class MsgListBean {
    private int msgListId;
    private int msgFromId;
    private int msgToId;
    private int msgCount;
    private int lastUpdateId;

    public int getMsgListId() {
        return msgListId;
    }

    public void setMsgListId(int msgListId) {
        this.msgListId = msgListId;
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

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }

    public int getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(int lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }
}
