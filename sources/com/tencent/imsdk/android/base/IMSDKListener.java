package com.tencent.imsdk.android.base;

import androidx.annotation.Keep;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;

@Keep
/* loaded from: classes.dex */
public interface IMSDKListener<T> extends IMSDKResultListener<IMSDKResult> {
    void onNotify(T t);
}
