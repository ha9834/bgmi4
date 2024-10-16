package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.internal.zzbq;

/* loaded from: classes.dex */
final class s extends zzcsu {

    /* renamed from: a, reason: collision with root package name */
    private final zzn<Status> f4672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(zzn<Status> zznVar) {
        this.f4672a = (zzn) zzbq.checkNotNull(zznVar);
    }

    @Override // com.google.android.gms.internal.zzcst
    public final void zzer(int i) {
        Status b = zzcov.b(i);
        if (b.isSuccess()) {
            this.f4672a.setResult(b);
        } else {
            this.f4672a.zzu(b);
        }
    }
}
