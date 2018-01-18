package com.lin.lcchat.utils;

import java.util.HashMap;

/**
 * @author: chong.lin
 * @date: 2018/1/17 下午2:33
 * @company: 易宝支付(YeePay)
 */
public class Result extends HashMap {
    public static final int SUCCESS = 0;
    public static final int ERROR = -1;

    public Result(int _result, String _msg){
        this.put("result", _result);
        this.put("msg", _msg);
    }

    public static Result success(String _msg){
        return new Result(SUCCESS, _msg);
    }

    public static Result error(String _msg){
        return new Result(ERROR, _msg);
    }
}
