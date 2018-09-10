package com.yukari.dydanmuapi.model;

import java.io.Serializable;

/**
 * Created by zuofeng on 2018/4/17.
 */
public class BaseEntity implements Serializable {

    private Integer code;

    private String msg = "";
    private Object data = "";

    public BaseEntity() {

    }

    public BaseEntity(String msg) {
        this.msg = msg;
    }

    public BaseEntity(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseEntity(Integer code, Object data){

        this.code = code;
        this.data = data;
    }

    public BaseEntity(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "code:" + code +
                ", msg:'" + msg + '\'' +
                ", data:" + data +
                '}';
    }
}
