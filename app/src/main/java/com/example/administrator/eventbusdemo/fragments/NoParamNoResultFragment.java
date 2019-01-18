package com.example.administrator.eventbusdemo.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.eventbusdemo.R;
import com.example.administrator.eventbusdemo.activities.ThirdActivity;

public class NoParamNoResultFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view  = inflater.inflate(R.layout.fragment_blank, container, false);
        initInterface(view);
        return view;
    }

    private void initInterface(View view) {
        view.findViewById(R.id.txt_noAll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFunctionManager.invokeNoAll(ThirdActivity.FunctionNoParamNoResult);
            }
        });
        view.findViewById(R.id.txt_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mFunctionManager.invokeNoAll(MainActivity.FunctionNoParamNoResult);
                String result =  mFunctionManager.invokeWithResultOnly(ThirdActivity.FunctionWithResultOnly,String.class);
                Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.txt_param).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFunctionManager.invokeWithParamOnly(ThirdActivity.FunctionWithParamOnly,"有参无返回值");
            }
        });
        view.findViewById(R.id.txt_withAll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result =  mFunctionManager.invokeWithAll(ThirdActivity.FunctionWithParamWithResult,String.class,"有参有返回值");
                Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
