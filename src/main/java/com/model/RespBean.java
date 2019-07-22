package com.model;

/**
 * @author duanbochao
 * @creat 2019/7/17
 */
public class RespBean {

    private Integer status;
    private String msg;
    private Object data;

    //成功响应
    public static  RespBean ok(Object data) {
        return new RespBean(200,"success",data);
    }

    //失败响应
    public static  RespBean error() {
        return new RespBean(500,"error",null);
    }

    public RespBean(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
