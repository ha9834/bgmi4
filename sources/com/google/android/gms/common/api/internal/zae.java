package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* loaded from: classes.dex */
public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zab {

    /* renamed from: a, reason: collision with root package name */
    private final A f1399a;

    public zae(int i, A a2) {
        super(i);
        this.f1399a = a2;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException {
        try {
            this.f1399a.run(zaaVar.zaab());
        } catch (RuntimeException e) {
            zaa(e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(Status status) {
        this.f1399a.setFailedResult(status);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.f1399a.setFailedResult(new Status(10, sb.toString()));
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(zaab zaabVar, boolean z) {
        zaabVar.a(this.f1399a, z);
    }
}
