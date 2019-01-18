package com.example.administrator.eventbusdemo.utils;

import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2019/1/18 0018.
 */

public class InternetUtils {

    public static OkHttpClient mokHttpClient;

    //okhhtp和rxjava的绑定使用
    public static Observable<String> getObservable(final String ip){
        Observable observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                mokHttpClient = new OkHttpClient();
                RequestBody formBody=new FormBody.Builder()
                        .add("lng","23")
                        .add("lat","122")
                        .build();
                Request request=new Request.Builder()
                        .url("http://web.fxhkapp.com/web/v1/find/index")
                        .post(formBody)
                        .build();
                Call call=mokHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        subscriber.onError(new Exception("error"));
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String str = response.body().string();
                        subscriber.onNext(str);
                        subscriber.onCompleted();
                    }
                });

            }
        });
        return observable;
    };

    public static void  postAsyHttp(String size){
        getObservable(size).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("ccc","4"+e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.i("ccc",s);
            }
        });
    }
}
