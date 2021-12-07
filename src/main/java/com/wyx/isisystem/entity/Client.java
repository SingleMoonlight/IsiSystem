package com.wyx.isisystem.entity;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-20:53
 */
public class Client {
    // 委托方id
    private int id;
    // 委托方名称
    private String name;
    // 委托方描述
    private String description;

    public int getClientId() {
        return id;
    }

    public void setClientId(int clientId) {
        this.id = clientId;
    }

    public String getClientName() {
        return name;
    }

    public void setClientName(String clientName) {
        this.name = clientName;
    }

    public String getClientDescription() {
        return description;
    }

    public void setClientDescription(String clientDescription) {
        this.description = clientDescription;
    }
}
