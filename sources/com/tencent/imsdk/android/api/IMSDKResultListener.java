package com.tencent.imsdk.android.api;

import com.tencent.imsdk.android.api.IMSDKResult;

/* loaded from: classes.dex */
public interface IMSDKResultListener<T extends IMSDKResult> {
    void onResult(T t);
}
