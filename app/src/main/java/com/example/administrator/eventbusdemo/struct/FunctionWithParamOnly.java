package com.example.administrator.eventbusdemo.struct;

/**
 * Created by Administrator on 2019/1/15 0015.
 * 有参无返回值
 */

public abstract class FunctionWithParamOnly<Param> extends Function{
    public FunctionWithParamOnly(String funName) {
        super(funName);
    }
    public abstract void function(Param param);
}
