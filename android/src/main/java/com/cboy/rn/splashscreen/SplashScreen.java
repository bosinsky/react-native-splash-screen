package com.cboy.rn.splashscreen;
import android.app.Activity;
import android.app.Dialog;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

/**
 * SplashScreen
 * from：http://www.devio.org
 * Author:CrazyCodeBoy
 * GitHub:https://github.com/crazycodeboy
 * Email:crazycodeboy@gmail.com
 */
public class SplashScreen {
    private static Dialog mSplashDialog;
    private static WeakReference<Activity> mActivity;

    public static void show(final Activity activity,final boolean fullScreen) {
        if (activity == null) return;
        mActivity = new WeakReference<Activity>(activity);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!activity.isFinishing()) {

                    mSplashDialog = new Dialog(activity,fullScreen? R.style.SplashScreen_Fullscreen:R.style.SplashScreen_SplashTheme);
                    mSplashDialog.setContentView(R.layout.launch_screen);
                    mSplashDialog.setCancelable(false);

                    if (!mSplashDialog.isShowing()) {
                        mSplashDialog.show();
                    }
                }
            }
        });
    }

    public static void show(final Activity activity) {
        show(activity,false);
    }

    public static void msg(Activity activity, final String mex) {
        if (activity == null) return;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final TextView splashScreenTextView = (TextView)mSplashDialog.findViewById(R.id.splash_screen_text);
                splashScreenTextView.setText(mex);
            }
        });
    }

    public static void hide(Activity activity) {
        if (activity == null) activity = mActivity.get();
        if (activity == null) return;

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mSplashDialog != null && mSplashDialog.isShowing()) {
                    mSplashDialog.dismiss();
                }
            }
        });
    }
}
