package com.tencent.imsdk.android.base.login;

import android.content.Context;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GuestLogin extends IMSDKLoginBase {
    private static final int GUEST_CHANNEL_ID = 5;
    private InnerStat.Builder mSTBuilder;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return 5;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        return true;
    }

    public GuestLogin(Context context) {
        super(context);
        this.mSTBuilder = new InnerStat.Builder(context, "2.10.1", "");
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, IMSDKListener iMSDKListener, Object... objArr) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("iChannel", String.valueOf(5));
        sortableMap.put("sGuestId", DeviceUtils.getDeviceUuid(this.mCurCtx));
        sortableMap.put("sExtra", T.Device.getDeviceExtra(this.mCurCtx));
        String str2 = "";
        if (objArr != null && objArr.length > 1) {
            String str3 = "";
            for (Object obj : objArr) {
                if (obj != null && obj.getClass().getName().equals("java.lang.String")) {
                    str3 = obj.toString();
                }
            }
            str2 = str3;
        }
        if (!T.ckIsEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String string = jSONObject.has("ugId") ? jSONObject.getString("ugId") : "";
                if (!T.ckIsEmpty(string)) {
                    sortableMap.put("sUgId", string);
                }
                String string2 = jSONObject.has("ugId1") ? jSONObject.getString("ugId1") : "";
                if (!T.ckIsEmpty(string2)) {
                    sortableMap.put("sUgId1", string2);
                }
            } catch (JSONException unused) {
                IMLogger.e("IMSDK GuestLogin with invalid extraJson", new Object[0]);
                iMSDKListener.onResult(new IMSDKLoginResult(9999, 11, "make sure your extraJson info correct"));
                return;
            }
        }
        InnerStat.Builder builder = this.mSTBuilder;
        if (builder != null) {
            builder.setExtraProp(sortableMap).setMethod("login2Channel(Guest)").create().reportEvent();
        }
        iMSDKListener.onNotify(sortableMap);
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        iMSDKLoginResult.channelTokenExpire = 2147483647L;
        return iMSDKLoginResult;
    }
}
