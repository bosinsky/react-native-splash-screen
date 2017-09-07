package com.cboy.rn.splashscreen;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * SplashScreen
 * from：http://www.devio.org
 * Author:CrazyCodeBoy
 * GitHub:https://github.com/crazycodeboy
 * Email:crazycodeboy@gmail.com
 */
public class SplashScreenModule extends ReactContextBaseJavaModule{
    public SplashScreenModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "SplashScreen";
    }
    
    @ReactMethod
    public void show() {
        SplashScreen.show(getCurrentActivity());
    }
    
    @ReactMethod
    public void hide() {
        SplashScreen.hide(getCurrentActivity());
    }
    
    @ReactMethod
    public void msg(String value) {
        SplashScreen.msg(getCurrentActivity(), value);
    }
}