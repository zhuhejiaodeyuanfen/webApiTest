package com.vivian.sql.model;

import java.sql.Timestamp;

/**
 * 照片墙model
 */
public class LiveBoardModel {
    private int liveBoardModelId;//子版块的id
    private String liveBoardTitle;//子版块的名称
    private String liveBoardContent;//子版块的内容
    private Timestamp createTime;//发布时间
    private String liveIcon;//帖子头像
    private int inCount;//帖子讨论人数

    public int getInCount() {
        return inCount;
    }

    public void setInCount(int inCount) {
        this.inCount = inCount;
    }

    public String getLiveIcon() {
        return liveIcon;
    }

    public void setLiveIcon(String liveIcon) {
        this.liveIcon = liveIcon;
    }

    public int getLiveBoardModelId() {
        return liveBoardModelId;
    }

    public void setLiveBoardModelId(int liveBoardModelId) {
        this.liveBoardModelId = liveBoardModelId;
    }

    public String getLiveBoardTitle() {
        return liveBoardTitle;
    }

    public void setLiveBoardTitle(String liveBoardTitle) {
        this.liveBoardTitle = liveBoardTitle;
    }

    public String getLiveBoardContent() {
        return liveBoardContent;
    }

    public void setLiveBoardContent(String liveBoardContent) {
        this.liveBoardContent = liveBoardContent;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
