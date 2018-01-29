package com.vivian.sql.model;

/**
 * 子版块信息实体类
 */
public class SmallBoardModel {
    private int smaBoId;//子版块的id
    private String smaBoTitle;//子版块的名称
    private String smaBoAdmin;//子版块的卤煮
    private String smaBoParentId;//子版块所属的父版块id

    public int getSmaBoId() {
        return smaBoId;
    }

    public void setSmaBoId(int smaBoId) {
        this.smaBoId = smaBoId;
    }

    public String getSmaBoTitle() {
        return smaBoTitle;
    }

    public void setSmaBoTitle(String smaBoTitle) {
        this.smaBoTitle = smaBoTitle;
    }

    public String getSmaBoAdmin() {
        return smaBoAdmin;
    }

    public void setSmaBoAdmin(String smaBoAdmin) {
        this.smaBoAdmin = smaBoAdmin;
    }

    public String getSmaBoParentId() {
        return smaBoParentId;
    }

    public void setSmaBoParentId(String smaBoParentId) {
        this.smaBoParentId = smaBoParentId;
    }
}
