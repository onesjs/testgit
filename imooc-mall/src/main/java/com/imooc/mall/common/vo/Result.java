package com.imooc.mall.common.vo;

/**
 * @author sjs
 * @date 2020/11/11 9:57
 */
public class Result {
    private int status;
    private String msg;
    private Object data;

    public Result(int status, String message, Object data) {
        this.status =status;
        this.data =data;
        this.msg =message;
    }
    public Result(){

    }

    public static Result success(int status,String msg, Object data) {
        Result m = new Result();
        m.setStatus(status);
        m.setData(data);
        m.setMsg(msg);
        return m;
    }
    public static Result error(int status,String mess, Object data) {
        Result m = new Result();
        m.setStatus(status);
        m.setData(data);
        m.setMsg(mess);
        return m;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
