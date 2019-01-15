package com.example.administrator.eventbusdemo.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.administrator.eventbusdemo.ThirdActivity;
import com.example.administrator.eventbusdemo.struct.FunctionManager;

/**
 * Created by Administrator on 2019/1/15 0015.
 */

public class BaseFragment extends Fragment {


    public FunctionManager mFunctionManager;
    private ThirdActivity thirdActivity;

    public void setmFunctionManager(FunctionManager mFunctionManager) {
        this.mFunctionManager = mFunctionManager;
    }


    //绑定接口
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ThirdActivity) {
            thirdActivity  = (ThirdActivity) context;
            thirdActivity.setFunctionForFragment(getTag());
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    //解绑接口
    @Override
    public void onDetach() {
        super.onDetach();
        thirdActivity=null;
    }
}
