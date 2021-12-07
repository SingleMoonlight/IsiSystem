package com.wyx.isisystem.entity;

import java.sql.Timestamp;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-21:24
 */
public class Contract {
    // 合同id
    private int id;
    // 委托方id
    private int clientId;
    // 项目id
    private int projectId;
    // 合同创建时间
    private Timestamp createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
