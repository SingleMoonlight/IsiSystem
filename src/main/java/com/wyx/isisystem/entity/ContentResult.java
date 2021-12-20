package com.wyx.isisystem.entity;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-11:46
 */
public class ContentResult {
    // 自定义响应状态码
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

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
