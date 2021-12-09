package com.wyx.isisystem.entity;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-21:53
 *
 * 租户即系统的使用者，受委托方委托派检查人员检查
 */
public class Tenant {
    // 租户id
    private int id;
    // 租户名称
    private String name;

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
}
