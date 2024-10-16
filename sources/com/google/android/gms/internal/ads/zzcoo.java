package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class zzcoo implements zzf {

    /* renamed from: a, reason: collision with root package name */
    private final zzbri f3349a;
    private final zzbrt b;
    private final zzbvd c;
    private final zzbva d;
    private final zzbmn e;
    private AtomicBoolean f = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcoo(zzbri zzbriVar, zzbrt zzbrtVar, zzbvd zzbvdVar, zzbva zzbvaVar, zzbmn zzbmnVar) {
        this.f3349a = zzbriVar;
        this.b = zzbrtVar;
        this.c = zzbvdVar;
        this.d = zzbvaVar;
        this.e = zzbmnVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final synchronized void zzg(View view) {
        if (this.f.compareAndSet(false, true)) {
            this.e.onAdImpression();
            this.d.zzq(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzky() {
        if (this.f.get()) {
            this.f3349a.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzkz() {
        if (this.f.get()) {
            this.b.onAdImpression();
            this.c.zzagx();
        }
    }
}
