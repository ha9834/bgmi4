package com.tencent.imsdk.android.tools;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.common.IMSDKUrlResult;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.relation.IMSDKUrlBase;
import java.util.HashMap;

/* loaded from: classes.dex */
public class UrlUtils {
    public static volatile IMSDKUrlBase mUrlInstance;

    public static boolean initialize(Context context) {
        IMSDKErrCode.initialize(context);
        mUrlInstance = new IMSDKUrlBase(context);
        return context != null;
    }

    public static void shortUrl(String str, IMSDKResultListener<IMSDKUrlResult> iMSDKResultListener, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("sUrl", str);
        mUrlInstance.connectIMSDK(IR.path.URL_CONVERT, hashMap, iMSDKResultListener);
    }

    public static void shortUrl(String str, String str2, IMSDKResultListener<IMSDKUrlResult> iMSDKResultListener, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("sUrl", str);
        hashMap.put("urlTypeMark", str2);
        mUrlInstance.connectIMSDK(IR.path.URL_CONVERT, hashMap, iMSDKResultListener);
    }
}
