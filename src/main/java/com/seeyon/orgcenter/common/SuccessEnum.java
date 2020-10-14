package com.seeyon.orgcenter.common;

public enum SuccessEnum implements BaseSuccessInfoInterface{

    SUCCESS("2000", "业务处理成功!",null);

    /** 错误码 */
    private final String code;

    private final String msg;

    private final Object data;



    SuccessEnum(String Code, String Msg,Object Data) {
        this.code = Code;
        this.msg = Msg;
        this.data = Data;
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

    /**
     * 数据
     *
     * @return
     */
    @Override
    public Object getData() {
        return this.data;
    }
}
