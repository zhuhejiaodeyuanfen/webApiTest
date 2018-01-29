package com.vivian.sql.model;

import java.sql.Timestamp;

/**
 * 首页
 */
public class LivePhotoDetailModel {

    private int livePostId;//帖子id
    private String postTitle;//帖子标题
    private String postBackColor;//帖子背景颜色
    private String postParentId;//帖子所属父版块id
    private String postSonId;//帖子所属子版块id
    private String postAdmin;//发帖者姓名
    private Timestamp postCreateTime;//发帖时间
    private String postContent;//帖子内容
    private int postGoodCount;//帖子的好评数
    private int postBadCount;//帖子的坏评数
    private int postCommentCount;//帖子的评论数
    private int rePostCount;//帖子的转发数

    public int getLivePostId() {
        return livePostId;
    }

    public void setLivePostId(int livePostId) {
        this.livePostId = livePostId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBackColor() {
        return postBackColor;
    }

    public void setPostBackColor(String postBackColor) {
        this.postBackColor = postBackColor;
    }

    public String getPostParentId() {
        return postParentId;
    }

    public void setPostParentId(String postParentId) {
        this.postParentId = postParentId;
    }

    public String getPostSonId() {
        return postSonId;
    }

    public void setPostSonId(String postSonId) {
        this.postSonId = postSonId;
    }

    public String getPostAdmin() {
        return postAdmin;
    }

    public void setPostAdmin(String postAdmin) {
        this.postAdmin = postAdmin;
    }

    public Timestamp getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(Timestamp postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getPostGoodCount() {
        return postGoodCount;
    }

    public void setPostGoodCount(int postGoodCount) {
        this.postGoodCount = postGoodCount;
    }

    public int getPostBadCount() {
        return postBadCount;
    }

    public void setPostBadCount(int postBadCount) {
        this.postBadCount = postBadCount;
    }

    public int getPostCommentCount() {
        return postCommentCount;
    }

    public void setPostCommentCount(int postCommentCount) {
        this.postCommentCount = postCommentCount;
    }

    public int getRePostCount() {
        return rePostCount;
    }

    public void setRePostCount(int rePostCount) {
        this.rePostCount = rePostCount;
    }
}
