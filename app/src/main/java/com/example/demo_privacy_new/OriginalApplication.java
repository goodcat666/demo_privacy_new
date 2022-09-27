package com.example.demo_privacy_new;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.HashMap;

public class OriginalApplication extends Application {
    private static final String TAG = "OriginalApplication";


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG,"in OriginalApplication attachBaseContext run");
                }
            }
        }).start();
        Log.d(TAG, "in OriginalApplication attachBaseContext");
        HashMap<String,HashMap<String,String>> hashMap = MyApplication.hashMaps[0];
        for(String stringSet: hashMap.keySet()){
            Log.d(TAG, hashMap.get(stringSet).toString());
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "in OriginalApplication onCreate");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG,"in OriginalApplication onCreate run");
                    Log.d(TAG,"in OriginalApplication onCreate run, in MyApplication flag = " + MyApplication.flag);
                }
            }
        }).start();
    }
}
