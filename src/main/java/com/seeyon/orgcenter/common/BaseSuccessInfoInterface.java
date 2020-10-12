package com.seeyon.orgcenter.common;

public interface BaseSuccessInfoInterface {

    /** 状态*/
    String getCode();

    /** 描述*/
    String getMsg();

    /**
     * 数据
     * @return
     */
    Object getData();

}
