package com.lzy.o_eye_demo;

import android.app.Application;
import android.widget.Toast;

import com.lzy.o_eye.O_EYE;
import com.lzy.o_eye.O_EYEListener;

/**
 * @author:lizhenya
 * @Time: 2017/12/7
 * @email: 1556342503@qq.com
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        O_EYE.getInstance(this).init(new O_EYEListener() {
            @Override
            public void switchToForeground() {
                //切换到前台：do your things
                Toast.makeText(MyApplication.this, "App切换到前台", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void switchToBackground() {
                //切换到后台：do your things
                Toast.makeText(MyApplication.this, "App切换到后台", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        O_EYE.getInstance(this).unregister();
    }
}
