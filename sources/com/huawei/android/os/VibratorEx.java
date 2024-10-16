package com.huawei.android.os;

import android.content.Context;
import android.util.Log;

/* loaded from: classes2.dex */
public class VibratorEx {
    private static final String TAG = "VibratorExMy";

    public VibratorEx() {
    }

    protected VibratorEx(Context context) {
    }

    public String getHwParameter(String str) {
        Log.i(TAG, "getHwParameter");
        return null;
    }

    public boolean isSupportHwVibrator(String str) {
        Log.i(TAG, "isSupportHwVibrator");
        return false;
    }

    public void setHwVibrator(String str) {
        Log.i(TAG, "setHwVibrator");
    }
}
