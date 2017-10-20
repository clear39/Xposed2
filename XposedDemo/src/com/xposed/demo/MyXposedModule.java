package com.xposed.demo;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class MyXposedModule implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        Log.e("DFP","" +  lpparam.packageName);
        if(lpparam.packageName.equals("com.xposed.demo.target") == false){
            return;
        }
        findAndHookMethod("com.xposed.demo.target.MainApplication",
                lpparam.classLoader,"testHook", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param)
                    throws Throwable {
                Log.e("DFP","before called");
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param)
                    throws Throwable {
                Log.e("DFP","after called");
                super.afterHookedMethod(param);
            }
            
        });
        
    }

}
