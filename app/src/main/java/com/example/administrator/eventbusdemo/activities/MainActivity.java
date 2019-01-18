package com.example.administrator.eventbusdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.eventbusdemo.R;
import com.example.administrator.eventbusdemo.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mText;
//    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        rl = (RelativeLayout) findViewById(R.id.rl);
//        rl.setAlpha((float) 0.3);
        mButton = (Button) findViewById(R.id.btn1);
        mText = (TextView) findViewById(R.id.tv1);
        mText.setText("今天是星期三");
        jumpActivity();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        mText.setText(messageEvent.getMessage());
    }

    private void jumpActivity() {

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
