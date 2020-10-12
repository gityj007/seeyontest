package com.seeyon.orgcenter.common;

public class ResultBody {
	/**
	 * 响应代码
	 */
	private String code;

	/**
	 * 响应消息
	 */
	private String msg;


	/**
	 * 错误代码
	 */
	private String err_code;

	/**
	 * 错误消息
	 */
	private String err_msg;





	/**
	 * 响应结果
	 */
	private Object data;

	public ResultBody() {
	}

	public ResultBody(BaseErrorInfoInterface errorInfo) {
		this.code = errorInfo.getCode();
		this.msg = errorInfo.getMsg();
		this.err_code = errorInfo.getError_Code();
		this.err_msg = errorInfo.getError_Msg();
	}

	public ResultBody(BaseSuccessInfoInterface successInfo) {
		this.code = successInfo.getCode();
		this.msg = successInfo.getMsg();
		this.data = successInfo.getData();
	}






	/**
	 * 成功
	 * 
	 * @return
	 */
	public static ResultBody success() {
		return success(null);
	}

	/**
	 * 成功
	 * @param data
	 * @return
	 */
	public static ResultBody success(Object data) {
		ResultBody rb = new ResultBody();
		rb.setCode(SuccessEnum.SUCCESS.getCode());
		rb.setMsg(SuccessEnum.SUCCESS.getMsg());
		rb.setData(data);
		return rb;
	}

	/**
	 * 失败
	 */
	public static ResultBody error(BaseErrorInfoInterface errorInfo) {
		ResultBody rb = new ResultBody();
		rb.setCode(errorInfo.getCode());
		rb.setMsg(errorInfo.getMsg());
		rb.setErr_code(errorInfo.getError_Code());
		rb.setErr_msg(errorInfo.getError_Msg());
		return rb;
	}

	/**
	 * 失败
	 */
	public static ResultBody error(String ErrCode, String ErrMsg) {
		ResultBody rb = new ResultBody();
		rb.setCode("5000");
		rb.setMsg("业务处理失败");
		rb.setErr_code(ErrCode);
		rb.setErr_msg(ErrMsg);
		return rb;
	}

	/**
	 * 失败
	 */
	public static ResultBody error( String ErrMsg) {
		ResultBody rb = new ResultBody();
		rb.setCode("5000");
		rb.setMsg("业务处理失败");
		rb.setErr_msg(ErrMsg);
		return rb;
	}




	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


}