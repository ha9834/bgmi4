package com.tencent.imsdk.android.tools;

import android.app.Activity;
import androidx.annotation.Keep;
import com.amazonaws.services.s3.internal.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKLifeMonitor;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKFuse;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: classes.dex */
public class T {
    public static volatile Activity mGlobalActivityUpToDate;

    /* loaded from: classes.dex */
    public static class Device extends DeviceUtils {
    }

    /* loaded from: classes.dex */
    public static class Digest extends DigestUtils {
    }

    /* loaded from: classes.dex */
    public static class HelperLog extends HelpLogger {
    }

    /* loaded from: classes.dex */
    public static class Life extends IMSDKLifeMonitor {
    }

    /* loaded from: classes.dex */
    public static class Meta extends MetaDataUtils {
    }

    public static boolean setGlobalActivityUpToDate(Activity activity) {
        if (activity == null || mGlobalActivityUpToDate == activity || activity.isFinishing()) {
            return false;
        }
        mGlobalActivityUpToDate = activity;
        return IMSDKConfig.initialize(mGlobalActivityUpToDate) && IMSDKFuse.initialize(mGlobalActivityUpToDate);
    }

    public static String toHexString(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            int i3 = i * 2;
            cArr2[i3] = cArr[i2 / 16];
            cArr2[i3 + 1] = cArr[i2 % 16];
        }
        return new String(cArr2);
    }

    public static boolean ckIsEmpty(String str) {
        return str == null || str.trim().equals("") || str.trim().equals(Constants.NULL_VERSION_ID);
    }

    @Deprecated
    public static boolean ckNonEmpty(String... strArr) {
        for (String str : strArr) {
            if (ckIsEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> getSortableMap() {
        return new TreeMap(new Comparator<String>() { // from class: com.tencent.imsdk.android.tools.T.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                if (str == null || str2 == null) {
                    return (str == null && str2 == null) ? 0 : -1;
                }
                return str.compareTo(str2);
            }
        });
    }

    public static Map<String, String> jsonToMap(String str) {
        Map<String, String> sortableMap = getSortableMap();
        if (ckIsEmpty(str)) {
            return sortableMap;
        }
        try {
            sortableMap = jsonToMap(new JSONObject(str));
            IMLogger.d(sortableMap.toString());
            return sortableMap;
        } catch (JSONException e) {
            IMLogger.w("convert json to map error " + e.getMessage(), new Object[0]);
            return sortableMap;
        }
    }

    public static Map<String, String> jsonToMap(JSONObject jSONObject) throws JSONException {
        Map<String, String> sortableMap = getSortableMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof String) {
                sortableMap.put(next, String.valueOf(obj));
            } else if (obj instanceof JSONObject) {
                jsonToMap((JSONObject) obj);
            }
        }
        return sortableMap;
    }

    public static boolean isDebug() {
        return IMSDKConfig.getOrMetaData(IR.meta.IMSDK_DEBUG.toUpperCase(), IR.meta.IMSDK_DEBUG, false);
    }
}
