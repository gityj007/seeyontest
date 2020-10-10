package com.seeyon.orgcenter.util;



/**
 * @Author 勾瑜
 * @Description: Api接口返回通用信息
 * @Date 2020-10-10
 */
public class PageResult<T> extends BaseDomain {

    /**
     * 是否成功
     */
    private boolean flag;

    private Integer code;

    private String msg;

    private String err_code;

    private String err_msg;

    /**
     * 如果失败，报错信息  
     */
    private String message;

    private T entity;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public PageResult() {
        this.flag = true;
    }

    public void setError(String message){
        this.flag = false;
        this.message = message;
    }

    public void setSuccess(String message){
        this.flag = true;
        this.message = message;
        this.code = 2000;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
