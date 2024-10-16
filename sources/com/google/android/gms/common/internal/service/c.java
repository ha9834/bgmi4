package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes.dex */
final class c extends zaa {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<Status> f1475a;

    public c(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f1475a = resultHolder;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zaj
    public final void zaj(int i) throws RemoteException {
        this.f1475a.setResult(new Status(i));
    }
}
