package com.qdedu.gradesystem;

import android.app.Application;


import com.qdedu.gradesystem.utils.Constant;

import cn.bmob.v3.Bmob;

/**
 * desc :
 * author：xiedong
 * date：2019/2/19
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, Constant.APP_ID);
    }
}
