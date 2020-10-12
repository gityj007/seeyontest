package com.seeyon.orgcenter.common;

/**
 * @author yangjian
 */

public enum ErrorEnum implements BaseErrorInfoInterface {
	// 数据操作错误定义
	SYSTEM_ERROR("5000", "业务处理失败","SP.SYSTEM_ERROR","系统错误，稍后重试"),
	FATAL_ERROR("5000", "业务处理失败","SP.FATAL_ERROR","致命错误，请联系管理员"),
	INVALID_PARAMETER("5000", "业务处理失败","SP.INVALID_PARAMETER","无效请求参数"),
	NOT_EXISTS("5000", "业务处理失败","SP.NOT_EXISTS","记录不存在"),
	PERMISSION_INSUFFICIENT("5000", "业务处理失败","SP.PERMISSION_INSUFFICIENT","用户权限不足"),
	INVALID_SIGN("5000", "业务处理失败","SP.INVALID_SIGN","无效的签名");

	/** 错误码 */
	private String code;

	private String msg;

	private String err_code;

	/** 错误描述 */
	private String err_msg;

	ErrorEnum(String Code, String Msg,String ErrCode, String ErrMsg) {
		this.code = Code;
		this.msg = Msg;
		this.err_code = ErrCode;
		this.err_msg = ErrMsg;
	}


	/**
	 * 状态
	 */
	@Override
	public String getCode() {
		return this.code;
	}

	/**
	 * 描述
	 */
	@Override
	public String getMsg() {
		return this.msg;
	}

	@Override
	public String getError_Code() {
		return this.err_code;
	}

	@Override
	public String getError_Msg() {
		return this.err_msg;
	}
}
