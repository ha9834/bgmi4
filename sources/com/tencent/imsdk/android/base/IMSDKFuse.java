package com.tencent.imsdk.android.base;

import android.app.Activity;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class IMSDKFuse {
    private static Map<String, Boolean> mFuseMap = new HashMap();

    public static boolean initialize(Activity activity) {
        return IMSDKConfig.initialize(activity);
    }

    public static boolean isAvailable(String str) {
        if (mFuseMap.containsKey(str)) {
            return mFuseMap.get(str).booleanValue();
        }
        boolean equalsIgnoreCase = "1".equalsIgnoreCase(IMSDKConfig.getOrMetaData(str, str, "1"));
        mFuseMap.put(str, Boolean.valueOf(equalsIgnoreCase));
        return equalsIgnoreCase;
    }

    public static boolean isAvailable(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            str = str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2.toUpperCase();
        }
        return isAvailable(str);
    }
}
