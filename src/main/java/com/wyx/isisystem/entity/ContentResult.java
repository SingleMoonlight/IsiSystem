package com.wyx.isisystem.entity;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-11:46
 */
public class ContentResult {
    private int code;
    private String content;

    public ContentResult(int code) {
        this.code = code;
    }

    public ContentResult(int code, String content) {
        this.code = code;
        this.content = content;
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
}
