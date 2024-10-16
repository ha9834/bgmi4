package com.tencent.hawk.receiver;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import com.tencent.hawk.bridge.HawkLogger;
import com.tencent.hawk.bridge.HawkNative;

/* loaded from: classes2.dex */
public class BatteryMgr {
    private static BatteryManager sBatteryMgr;

    @SuppressLint({"NewApi"})
    public static void postBatteryInfoManual(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                if (sBatteryMgr == null) {
                    sBatteryMgr = (BatteryManager) context.getSystemService("batterymanager");
                }
                int intProperty = sBatteryMgr.getIntProperty(4);
                int intProperty2 = sBatteryMgr.getIntProperty(3);
                int intProperty3 = sBatteryMgr.getIntProperty(2);
                int intProperty4 = Build.VERSION.SDK_INT >= 26 ? sBatteryMgr.getIntProperty(6) : 0;
                HawkNative.postBatteryInfo(2, intProperty4, intProperty, intProperty2, intProperty3, 0, 0, 0);
                HawkLogger.d(String.format("battery info : %d %d %d %d", Integer.valueOf(intProperty4), Integer.valueOf(intProperty), Integer.valueOf(intProperty2), Integer.valueOf(intProperty3)).toString());
            }
        } catch (Exception unused) {
            HawkLogger.e("BatteryInfo Exception ocurred");
        }
    }
}
