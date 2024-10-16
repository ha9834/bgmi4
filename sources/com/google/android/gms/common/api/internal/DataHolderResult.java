package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
/* loaded from: classes.dex */
public class DataHolderResult implements Releasable, Result {

    /* renamed from: a, reason: collision with root package name */
    @KeepForSdk
    protected final Status f1309a;

    @KeepForSdk
    protected final DataHolder b;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public DataHolderResult(DataHolder dataHolder, Status status) {
        this.f1309a = status;
        this.b = dataHolder;
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public Status getStatus() {
        return this.f1309a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    @KeepForSdk
    public void release() {
        DataHolder dataHolder = this.b;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
