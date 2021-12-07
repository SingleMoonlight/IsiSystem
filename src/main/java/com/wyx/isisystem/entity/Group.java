package com.wyx.isisystem.entity;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-21:35
 */
public class Group {
    // 小组id
    private int id;
    // 小组名称
    private String name;
    // 小组组长id
    private int leaderId;

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

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }
}
