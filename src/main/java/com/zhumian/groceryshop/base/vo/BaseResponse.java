package com.zhumian.groceryshop.base.vo;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private boolean success;
    private T data;
    private String msg;

    public BaseResponse(boolean success, T data, String msg) {
        this.success = success;
        this.data = data;
        this.msg = msg;
    }

    public BaseResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public BaseResponse(T data) {
        this.data = data;
    }

    public BaseResponse(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }


    public BaseResponse(boolean success) {
        this.success = success;
    }

    public BaseResponse() {
        this.success = true;
        this.msg = "操作成功";
    }
}
