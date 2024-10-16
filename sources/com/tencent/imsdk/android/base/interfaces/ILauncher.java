package com.tencent.imsdk.android.base.interfaces;

import android.content.Intent;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.common.IMSDKLaunchResult;

/* loaded from: classes.dex */
public interface ILauncher {
    void handleLaunchData(Intent intent, IMSDKResultListener<IMSDKLaunchResult> iMSDKResultListener);
}
