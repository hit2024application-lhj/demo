package org.example.myapp.enums;

public enum HttpCode {

    SUUCCESS(200,"成功"),
    ERROR(-1,"请求失败"),
    SYSTEMERROR(500,"系统错误"),
    TOLONIN(501,"重新登录");
    private Integer code;
    private String msg;

    HttpCode(Integer code,String msg)
    {
        this.code=code;
        this.msg=msg;
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
}
