package com.example.administrator.eventbusdemo.struct;

/**
 * Created by Administrator on 2019/1/15 0015.
 * 无参有返回值
 */

public abstract class FunctionWithResultOnly<Result> extends Function{
    public FunctionWithResultOnly(String funName) {
        super(funName);
    }
    public abstract Result function();
}
