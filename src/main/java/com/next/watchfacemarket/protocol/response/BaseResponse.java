package com.next.watchfacemarket.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 2:15 下午
 */
public class BaseResponse<T> {

    private T data;

    @JSONField(name = "err_code")
    private int errCode;

    @JSONField(name = "err_msg")
    private String errMsg;

    public BaseResponse() {
    }

    public BaseResponse(T data, int errCode, String errMsg) {
        this.data = data;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
