package com.wyx.isisystem.entity;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-21:31
 *
 * 检查体系为树状结构，分为两级。例如，第一级为安全检查，下分消防安全、
 * 卫生安全、人身安全等。规定第一级 id 的前置 id 为 0.
 */
public class CheckSystem {
    // 当前检查体系id
    private int curCheckId;
    // 前置检查体系id
    private int preCheckId;

    public int getCurCheckId() {
        return curCheckId;
    }

    public void setCurCheckId(int curCheckId) {
        this.curCheckId = curCheckId;
    }

    public int getPreCheckId() {
        return preCheckId;
    }

    public void setPreCheckId(int preCheckId) {
        this.preCheckId = preCheckId;
    }
}
