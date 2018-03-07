package com.lzy.o_eye;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * APP前后台切换监听
 *
 * @author:lizhenya
 * @Time: 2017/12/7
 * @email: 1556342503@qq.com
 */

public class O_EYE implements ComponentCallbacks2, Application.ActivityLifecycleCallbacks {
    private static volatile O_EYE o_eye;
    private static final Object mMutex = new Object();
    private Application mCtx;
    private boolean isBackground;
    private O_EYEListener OEYEListener;

    private O_EYE(Application context) {
        mCtx = context;
    }

    public static O_EYE getInstance(Application context) {
        if (o_eye == null) {
            synchronized (mMutex) {
                if (o_eye == null) {
                    o_eye = new O_EYE(context);
                }
            }
        }
        return o_eye;
    }


    public void init(O_EYEListener OEYEListener) {
        this.OEYEListener = OEYEListener;
        mCtx.registerComponentCallbacks(this);
        mCtx.registerActivityLifecycleCallbacks(this);

    }

    public void unregister() {
        mCtx.unregisterComponentCallbacks(this);
        mCtx.unregisterActivityLifecycleCallbacks(this);
    }

    @Override
    public void onTrimMemory(int level) {
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            isBackground = true;
            if (null == OEYEListener) {
                return;
            }
            OEYEListener.switchToBackground();
        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (isBackground) {
            isBackground = false;
            if (null == OEYEListener) {
                return;
            }
            OEYEListener.switchToForeground();
        }

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
