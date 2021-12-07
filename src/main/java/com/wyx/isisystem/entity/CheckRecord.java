package com.wyx.isisystem.entity;

import java.sql.Timestamp;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-21:26
 */
public class CheckRecord {
    // 检查记录id
    private int id;
    // 项目id
    private int projectId;
    // 检查人员id
    private int staffId;
    // 第一级id
    private int firstId;
    // 第二级id
    private int secondId;
    // 问题描述
    private String description;
    // 检查时间
    private Timestamp checkTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }
}
