package com.example.administrator.eventbusdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.eventbusdemo.fragments.BaseFragment;
import com.example.administrator.eventbusdemo.fragments.NoParamNoResultFragment;
import com.example.administrator.eventbusdemo.struct.FunctionManager;
import com.example.administrator.eventbusdemo.struct.FunctionNoParamNoResult;
import com.example.administrator.eventbusdemo.struct.FunctionWithParamOnly;
import com.example.administrator.eventbusdemo.struct.FunctionWithParamWithResult;
import com.example.administrator.eventbusdemo.struct.FunctionWithResultOnly;

public class ThirdActivity extends AppCompatActivity {
    //传进去的接口的名称,有多少接口就在底下定义多少名字
    public static final String FunctionNoParamNoResult = "FunctionNoParamNoResult";
    public static final String FunctionWithResultOnly = "FunctionWithResultOnly";
    public static final String FunctionWithParamOnly = "FunctionWithParamOnly";
    public static final String FunctionWithParamWithResult = "FunctionWithParamWithResult";
    private FragmentManager fm;
    private Handler  handler =  new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x123:
                    String message = (String) msg.obj;
                    Toast.makeText(ThirdActivity.this, message, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        NoParamNoResultFragment noParamNoResultFragment = new NoParamNoResultFragment();
        ft.add(R.id.fragment,noParamNoResultFragment,NoParamNoResultFragment.class.getName());
        ft.commit();


    }

    public void setFunctionForFragment(String tag) {
        if (TextUtils.isEmpty(tag)) {
            Log.e(ThirdActivity.class.getSimpleName(), "tag is null !");
            return;
        }
        BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(tag);
        FunctionManager functionManager = FunctionManager.getInstance();

        functionManager.addFunction(new FunctionNoParamNoResult(FunctionNoParamNoResult) {
            @Override
            public void function() {
                Toast.makeText(ThirdActivity.this, "无参无返回值", Toast.LENGTH_SHORT).show();
            }
        });

        functionManager.addFunction(new FunctionWithResultOnly<String>(FunctionWithResultOnly) {
            @Override
            public String function() {
                return "无参有返回值";
            }
        });
        functionManager.addFunction(new FunctionWithParamOnly<String>(FunctionWithParamOnly) {
            @Override
            public void function(String o) {
                Toast.makeText(ThirdActivity.this, o, Toast.LENGTH_SHORT).show();
            }
        });

        functionManager.addFunction(new FunctionWithParamWithResult<String, String>(FunctionWithParamWithResult) {
            @Override
            public String function(String o) {
                return o;
            }
        });
        fragment.setmFunctionManager(functionManager);
    }


}
