# O_EYE
    Android前后台切换监听库，放弃修改底层源码监听Home键的方式来监听APP前后台切换，使用方便。
# 使用方式
## 1.添加库到项目中
<pre><code>compile 'com.lzy:O_EYE:1.0.0'</code></pre>
## 2.重写Application，并在XXApplication中完成注册、回调、反注册
<pre><code>
   public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        O_EYE.getInstance(this).init(new O_EYEListener() {
            @Override
            public void switchToForeground() {
                Toast.makeText(MyApplication.this, "APP切换至前台", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void switchToBackground() {
                Toast.makeText(MyApplication.this, "App切换至后台", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
</code></pre>


