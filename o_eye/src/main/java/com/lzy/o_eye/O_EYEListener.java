package com.lzy.o_eye;

/**
 * @author:lizhenya
 * @Time: 2017/12/7
 * @email: 1556342503@qq.com
 */

public interface O_EYEListener {
    /**
     * App切换至前台
     */
    void switchToForeground();


    /**
     * APP切换至后台
     */
    void switchToBackground();
}
