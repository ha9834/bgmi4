package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes2.dex */
final class f extends zzg {

    /* renamed from: a, reason: collision with root package name */
    private BaseImplementation.ResultHolder<Status> f3808a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f3808a = resultHolder;
    }

    @Override // com.google.android.gms.internal.p000authapi.zzg, com.google.android.gms.internal.p000authapi.zzu
    public final void zzc(Status status) {
        this.f3808a.setResult(status);
    }
}
