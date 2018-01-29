package com.vivian.sql.model;

import java.sql.Timestamp;

public class TypeBeanModel {
    private int beanId;
    private String beanTitle;
    private String beanIntro;
    private Timestamp beanCreateTime;
    private int beanCreateUserId;
    private String beanIcon;

    public int getBeanId() {
        return beanId;
    }

    public void setBeanId(int beanId) {
        this.beanId = beanId;
    }

    public String getBeanTitle() {
        return beanTitle;
    }

    public void setBeanTitle(String beanTitle) {
        this.beanTitle = beanTitle;
    }

    public String getBeanIntro() {
        return beanIntro;
    }

    public void setBeanIntro(String beanIntro) {
        this.beanIntro = beanIntro;
    }

    public Timestamp getBeanCreateTime() {
        return beanCreateTime;
    }

    public void setBeanCreateTime(Timestamp beanCreateTime) {
        this.beanCreateTime = beanCreateTime;
    }

    public int getBeanCreateUserId() {
        return beanCreateUserId;
    }

    public void setBeanCreateUserId(int beanCreateUserId) {
        this.beanCreateUserId = beanCreateUserId;
    }

    public String getBeanIcon() {
        return beanIcon;
    }

    public void setBeanIcon(String beanIcon) {
        this.beanIcon = beanIcon;
    }
}
