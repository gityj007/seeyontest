package com.seeyon.orgcenter.common;

public interface BaseErrorInfoInterface {
    /** 状态*/
	 String getCode();
	
	/** 描述*/
	 String getMsg();

	String getError_Code();

	String getError_Msg();
}