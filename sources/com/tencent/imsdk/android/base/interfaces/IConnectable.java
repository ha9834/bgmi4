package com.tencent.imsdk.android.base.interfaces;

import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKListener;
import java.util.Map;

/* loaded from: classes.dex */
public interface IConnectable {
    String getChannelId();

    String getChannelUserId();

    void login(String str, IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr);

    void logout(IMSDKResultListener iMSDKResultListener);
}
