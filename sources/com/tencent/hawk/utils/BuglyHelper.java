package com.tencent.hawk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.hawk.bridge.Constant;
import com.tencent.hawk.bridge.TApmBuildConfig;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;

/* loaded from: classes2.dex */
public class BuglyHelper {
    private static boolean sBuglySet;

    public static void buglyShare(Context context) {
        SharedPreferences sharedPreferences;
        if (sBuglySet || (sharedPreferences = context.getSharedPreferences(APMidasPayNewAPI.BUGLY_SP_NAME, 0)) == null) {
            return;
        }
        String string = sharedPreferences.getString("b563002ef4", Constant.strError);
        if (string == null || string.equals(Constant.strError) || !string.equals(TApmBuildConfig.VERSION_NAME)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("b563002ef4", TApmBuildConfig.VERSION_NAME);
            edit.commit();
            sBuglySet = true;
        }
    }
}
