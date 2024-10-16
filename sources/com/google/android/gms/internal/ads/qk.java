package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class qk implements zzadx {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcab f2440a;
    private final /* synthetic */ ViewGroup b;
    private final /* synthetic */ zzbzl c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qk(zzbzl zzbzlVar, zzcab zzcabVar, ViewGroup viewGroup) {
        this.c = zzbzlVar;
        this.f2440a = zzcabVar;
        this.b = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void zzrg() {
        boolean a2;
        zzbzl zzbzlVar = this.c;
        a2 = zzbzl.a(this.f2440a, zzbzj.zzfpm);
        if (a2) {
            this.f2440a.onClick(this.b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void zzc(MotionEvent motionEvent) {
        this.f2440a.onTouch(null, motionEvent);
    }
}
