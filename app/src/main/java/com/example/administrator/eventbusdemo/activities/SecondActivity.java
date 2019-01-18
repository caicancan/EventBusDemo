package com.example.administrator.eventbusdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.eventbusdemo.R;
import com.example.administrator.eventbusdemo.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {
    private Button btn2;
    private Button btn3;
    private Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         btn2 =(Button) findViewById(R.id.btn2);
         btn3= (Button)findViewById(R.id.btn3);
         btn4 = (Button)findViewById(R.id.btn4);
        btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 EventBus.getDefault().post(new MessageEvent("欢迎大家浏览我写的博客+1"));
                 finish();

             }
         });
         btn3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                 startActivity(intent);
             }
         });
         btn4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(SecondActivity.this, FourActivity.class);
                 startActivity(intent);
             }
         });
    }

}
