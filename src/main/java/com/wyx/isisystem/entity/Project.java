package com.wyx.isisystem.entity;

import java.sql.Timestamp;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-21:15
 *
 * 项目创建时处于未开始状态，此时对项目的变动（删除，编辑）都是可以的
 * 如果项目已经正在进行或者完成，即合同已经签订，是不允许修改的
 */
public class Project {
    // 项目id
    private int id;
    // 项目名称
    private String name;
    // 项目描述
    private String description;
    // 项目负责人
    private String owner;
    // 项目负责人电话
    private String ownerPhone;
    // 项目状态，0-未开始，1-进行中，2-已完成
    private int state;
    // 项目风险值，按权重计算得，0-100，数值越大越危险
    private int riskValue;
    // 项目创建时间
    private Timestamp createTime;
    // 检查小组id
    private int groupId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRiskValue() {
        return riskValue;
    }

    public void setRiskValue(int riskValue) {
        this.riskValue = riskValue;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
