package com.wyx.isisystem.entity;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-11:46
 */
public class ContentResult {
    // 自定义响应状态码
    /**
     * 登录：1-登录成功，-1登陆失败
     * 委托方新增：1-新增成功，-1新增失败
     * 委托方查询：1-查询成功，-1查询失败
     * 项目创建：1-创建成功，-1创建失败
     * 项目编辑：1-编辑成功，-1编辑失败，-2无法编辑
     * 项目删除：1-删除成功，-1删除失败，-2无法删除
     * 合同创建：1-创建成功，-1创建失败
     * 合同编辑：
     * 合同删除：
     */
    private int code;
    // 响应信息
    private String content;
    // 负载
    private Object payload;

    public ContentResult(int code) {
        this.code = code;
    }

    public ContentResult(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public ContentResult(int code, String content, Object payload) {
        this.code = code;
        this.content = content;
        this.payload = payload;
    }

    public ContentResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getObject() {
        return payload;
    }

    public void setObject(Object payload) {
        this.payload = payload;
    }
}
