package com.xposed.demo.target;

import android.app.Application;
import android.util.Log;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        testHook();

    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }
    
    private void testHook(){
        Log.e("DFP","in com.xposed.demo.target testHook");
    }
}
