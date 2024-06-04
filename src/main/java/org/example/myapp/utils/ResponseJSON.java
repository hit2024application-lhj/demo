package org.example.myapp.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.myapp.enums.HttpCode;

@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseJSON {
    private Integer code;
    private String msg;
    private Object data;

    public static ResponseJSON getOK()
    {
        return new ResponseJSON(HttpCode.SUUCCESS.getCode(), HttpCode.SUUCCESS.getMsg(), null);
    }

    public static ResponseJSON getOK(String msg)
    {
        return new ResponseJSON(HttpCode.SUUCCESS.getCode(), msg,null);
    }

    public static ResponseJSON getOK(String msg,Object obj)
    {
        return new ResponseJSON(HttpCode.SUUCCESS.getCode(),msg,obj);
    }

    public static ResponseJSON getOK(Object ob)
    {
        return new ResponseJSON(HttpCode.SUUCCESS.getCode(), HttpCode.SUUCCESS.getMsg(), ob);
    }

    public static ResponseJSON getERROR()
    {
        return new ResponseJSON(HttpCode.ERROR.getCode(), HttpCode.ERROR.getMsg(),null );
    }

    public static ResponseJSON getERROR(String msg)
    {
        return new ResponseJSON(HttpCode.ERROR.getCode(), msg,null);
    }

    public static ResponseJSON getResponseJSON(HttpCode httpCode) {
        return new ResponseJSON(httpCode.getCode(),httpCode.getMsg(),null);
    }
}
