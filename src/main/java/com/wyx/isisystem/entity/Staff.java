package com.wyx.isisystem.entity;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-21:11
 */
public class Staff {
    // 员工id
    private int id;
    // 员工姓名
    private String name;
    // 员工性别
    private String gender;
    // 员工电话
    private String phone;
    // 员工所属小组id
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
