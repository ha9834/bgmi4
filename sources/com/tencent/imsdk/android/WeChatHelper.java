package com.tencent.imsdk.android;

import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.util.Map;

/* loaded from: classes.dex */
public class WeChatHelper {
    public static boolean isApplicationSupported(IWXAPI iwxapi) {
        return true;
    }

    public static boolean checkWeChatEnvError(IWXAPI iwxapi, IMSDKListener<Map<String, String>> iMSDKListener) {
        if (!isApplicationInstalled(iwxapi)) {
            iMSDKListener.onResult(new IMSDKLoginResult(15, 15, IMSDKErrCode.getMessageByCode(15)));
            return true;
        }
        if (isApplicationSupported(iwxapi)) {
            return false;
        }
        iMSDKListener.onResult(new IMSDKLoginResult(16, 16, IMSDKErrCode.getMessageByCode(16)));
        return true;
    }

    public static boolean isApplicationInstalled(IWXAPI iwxapi) {
        if (iwxapi != null) {
            return iwxapi.isWXAppInstalled();
        }
        return false;
    }
}
