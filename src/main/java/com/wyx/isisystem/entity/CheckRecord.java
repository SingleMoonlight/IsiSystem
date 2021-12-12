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
    // 风险等级，0-无风险，1-轻度风险，2-一般风险，3-高危风险
    private int riskLevel;
    // 检查现场图片url
    private String pictureUrl;
    // 问题描述
    private String description;
    // 检查时间
    private Timestamp checkTime;
    // 检查记录状态，0：待审核，1：审核通过，2：审核不通过
    private int checkState;


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

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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

    public int getCheckState() {
        return checkState;
    }

    public void setCheckState(int checkState) {
        this.checkState = checkState;
    }
}
