package com.example.demo_privacy_new;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.HashMap;

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    public static boolean flag = false;
    // 1、String 大类型
    // 2、String 小类型
    // 3、String 数据
    public static HashMap<String,HashMap<String,String>>[] hashMaps = new HashMap[3];


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "in MyApplication onCreate");
        PackageManager packageManager = getApplicationContext().getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(getPackageName());
        Log.d(TAG, "get package name = " + getPackageName());
        HashMap<String,HashMap<String,String>> hashMapHashMap = new HashMap<>();

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("11111","222222");
        hashMapHashMap.put("something",hashMap);
        MyApplication.hashMaps[0] = hashMapHashMap;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG,"in MyApplication onCreate run");
                }
            }
        }).start();
        MyApplication.flag = true;
        ReplaceApplicationUtils.replaceApplication(this, getOriginalApplicationName());
    }

    /**
     *
     */
    private String getOriginalApplicationName() {
        //先假设原Manifest中配置的是是名字
        String originalApplicationName = "com.example.demo_privacy_new.OriginalApplication";
        //否则设置为"com.android.Application"
        return originalApplicationName;
    }

}
