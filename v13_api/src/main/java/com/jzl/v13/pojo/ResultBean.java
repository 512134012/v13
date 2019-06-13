package com.jzl.v13.pojo;

/**
 * 项目名：v13
 * HAPPY JAVA ！
 * Create by jiangzonglin on 2019-06-12 下午 9:15
 */
public class ResultBean<T> {

    private String statusCode;

    private T data;

    public ResultBean() {
    }

    public ResultBean(String statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
