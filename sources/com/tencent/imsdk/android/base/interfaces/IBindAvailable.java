package com.tencent.imsdk.android.base.interfaces;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.auth.IMSDKAuthResult;

/* loaded from: classes.dex */
public interface IBindAvailable {
    void connect(String str, String str2, IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener, Object... objArr);

    String getChannelId();

    void recover(String str, String str2, IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener, Object... objArr);

    void sendCode(String str, int i, IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr);
}
