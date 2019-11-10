package com.next.watchfacemarket.consts;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 2:21 下午
 */
public enum ErrorInfoEnum {
    /**
     * 全局异常
     */
    REQUEST_PARAM_INVALID(-3, "request params is invalid", "请求参数错误"),
    DB_OPERATOR_FAIL(-2, "Db operator fail", "数据库异常"),
    SYSTEM_ERROR(-1, "System error", "系统内部异常"),
    SUCCESS(0, "SUCCESS", "成功");

    private int errCode;

    private String errMsg;

    private String errMsgCn;

    ErrorInfoEnum() {
    }

    ErrorInfoEnum(int errCode, String errMsg, String errMsgCn) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errMsgCn = errMsgCn;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public String getErrMsgCn() {
        return errMsgCn;
    }
}
