package com.tencent.imsdk.android.base.auth;

import android.content.Context;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.interfaces.IConnectable;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.T;
import java.util.Map;

/* loaded from: classes.dex */
public class IMSDKGuest implements IConnectable {
    private static final String GUEST_CHANNEL_ID = "5";
    private Context mCtx;

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public String getChannelId() {
        return "5";
    }

    public IMSDKGuest(Context context) {
        this.mCtx = context;
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public void login(String str, IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("iChannel", "5");
        sortableMap.put("sGuestId", DeviceUtils.getDeviceUuid(this.mCtx));
        sortableMap.put("sExtra", T.Device.getDeviceExtra(this.mCtx));
        iMSDKListener.onNotify(sortableMap);
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public void logout(IMSDKResultListener iMSDKResultListener) {
        if (IMSDKDB4Login.cleanSavedLoginData(this.mCtx, "5")) {
            iMSDKResultListener.onResult(new IMSDKResult(1, 1));
        } else {
            iMSDKResultListener.onResult(new IMSDKResult(8, 8, "unknown error occur while delete data"));
        }
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public String getChannelUserId() {
        return DeviceUtils.getDeviceUuid(this.mCtx);
    }
}
