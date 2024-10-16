package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;

@KeepForSdk
/* loaded from: classes.dex */
public class StatusCallback extends IStatusCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    @KeepForSdk
    private final BaseImplementation.ResultHolder<Status> f1324a;

    @KeepForSdk
    public StatusCallback(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f1324a = resultHolder;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    @KeepForSdk
    public void onResult(Status status) {
        this.f1324a.setResult(status);
    }
}
