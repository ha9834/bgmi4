package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcoz implements zzf {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzf f3356a;

    public final synchronized void zza(zzf zzfVar) {
        this.f3356a = zzfVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final synchronized void zzg(View view) {
        if (this.f3356a != null) {
            this.f3356a.zzg(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final synchronized void zzky() {
        if (this.f3356a != null) {
            this.f3356a.zzky();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final synchronized void zzkz() {
        if (this.f3356a != null) {
            this.f3356a.zzkz();
        }
    }
}
