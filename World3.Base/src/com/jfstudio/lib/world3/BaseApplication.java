package com.jfstudio.lib.world3;

import android.app.Application;

import com.jfstudio.lib.world3.utils.PreferencesUtils;

public class BaseApplication extends Application {

    private static final String APP_INSTALL_TIME = "APP_INSTALL_TIME";
    public static long sAppInstallTime = 0;

    @Override
    public void onCreate() {
        recordAppInstallTime();
    }

    private void recordAppInstallTime() {
        sAppInstallTime = PreferencesUtils.getLongPreference(this, APP_INSTALL_TIME, 0);
        if (sAppInstallTime == 0) {
            sAppInstallTime = System.currentTimeMillis();
            PreferencesUtils.setLongPreference(this, APP_INSTALL_TIME, sAppInstallTime);
        }
    }
}
