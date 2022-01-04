package com.pojo;


/*
 * 与前端交互的返回对象
 * */


public class Result<T> {

    private static final long serialVersionUID = -8713837118340960775L;

    /** 成功*/
    private static final Integer SUCCESS = 200;
    /** 警告*/
    private static final Integer WARN = 1;
    /** 异常 失败*/
    private static final Integer FAIL = 500;

    private Integer code;

    private String msg;

    private Object data;

    public Result(Integer code) {
        this.code = code;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 失败并返回数据
     * @param data
     * @return
     */
    public static Result error(Object data) {
        return new Result(FAIL, data);
    }

    /**
     * 警告并返回数据
     * @param data
     * @return
     */
    public static Result warn(Object data) {
        return new Result(WARN, data);
    }

    /**
     * 成功并返回数据
     * @param msg
     * @param data
     * @return
     */
    public static Result ok(String msg, Object data) {
        return new Result(SUCCESS, msg, data);
    }

    /**
     * 带数据
     * @param data
     * @return
     */
    public static Result ok(Object data) {
        return new Result(SUCCESS,data);
    }

    /**
     * 成功返回通用数据
     * @return
     */
    public static Result ok() {
        return new Result(SUCCESS, "操作成功");
    }

    public static Result error() {
        return Result.error("");
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static Integer getSUCCESS() {
        return SUCCESS;
    }

    public static Integer getWARN() {
        return WARN;
    }

    public static Integer getFAIL() {
        return FAIL;
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
}