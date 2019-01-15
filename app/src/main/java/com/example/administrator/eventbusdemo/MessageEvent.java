package com.example.administrator.eventbusdemo;

/**
 * Created by Administrator on 2019/1/15 0015.
 * 定义消息事件类
 */

public class MessageEvent {
    private String message;
    public  MessageEvent(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
