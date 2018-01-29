package com.vivian.sql.model;

import java.sql.Timestamp;

/**
 * 评论模型
 */
public class CommentModel {

    private String userComment;
    private String userIcon;
    private int commentId;
    private String userName;
    private Timestamp updateTime;

    public Timestamp getSysCurrentTime() {
        return sysCurrentTime;
    }

    public void setSysCurrentTime(Timestamp sysCurrentTime) {
        this.sysCurrentTime = sysCurrentTime;
    }

    private Timestamp sysCurrentTime;

    private Timestamp commentTime;

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
