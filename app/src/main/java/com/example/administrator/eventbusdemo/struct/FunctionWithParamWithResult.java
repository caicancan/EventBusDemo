package com.example.administrator.eventbusdemo.struct;

/**
 * Created by Administrator on 2019/1/15 0015.
 * 有参有返回值
 */

public abstract class FunctionWithParamWithResult<Result,Param> extends Function {
    public FunctionWithParamWithResult(String funName) {
        super(funName);
    }
    public abstract Result function(Param param);
}
