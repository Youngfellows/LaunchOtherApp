package com.tiffany.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tiffany.myapplication.utils.LaunchApp;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchAct(View view) {
        launch();
    }

    /**
     * 判断B应用是否在后台运行并直接打开
     */
    public void launch() {
        String packageName = "com.google.ime";
        //根据包名检测
        if (LaunchApp.checkPackInfo(this, packageName)) {
            LaunchApp.openPackage(this, packageName);
        } else {
            Log.w(TAG, "launch:: 没有安装:" + packageName);
            Toast.makeText(this, "没有安装" + packageName, Toast.LENGTH_LONG).show();
        }
    }
}