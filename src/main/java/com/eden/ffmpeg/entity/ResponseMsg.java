package com.eden.ffmpeg.entity;

import org.springframework.http.HttpStatus;

/**
 * @created by eden
 * @since 2019-03-27 上午 9:52:20
 */

public class ResponseMsg {

    private Object data;

    private Integer statusCode;

    private String msg;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ResponseMsg success(Object data) {
        ResponseMsg msg = new ResponseMsg();
        msg.setData(data);
        msg.setStatusCode(HttpStatus.OK.value());
        msg.setMsg(HttpStatus.OK.getReasonPhrase());
        return msg;
    }
}
