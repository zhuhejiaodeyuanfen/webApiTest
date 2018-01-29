package com.vivian.sql.model;

/**
 * 父版块的信息实体类
 */
public class BigBoardModel {
    private int bigBoId;//父版块id
    private String bigBoTitle;//父版块的名称
    private String bigBoAdmin;//父版块的卤煮

    public int getBigBoId() {
        return bigBoId;
    }

    public void setBigBoId(int bigBoId) {
        this.bigBoId = bigBoId;
    }

    public String getBigBoTitle() {
        return bigBoTitle;
    }

    public void setBigBoTitle(String bigBoTitle) {
        this.bigBoTitle = bigBoTitle;
    }

    public String getBigBoAdmin() {
        return bigBoAdmin;
    }

    public void setBigBoAdmin(String bigBoAdmin) {
        this.bigBoAdmin = bigBoAdmin;
    }
}
