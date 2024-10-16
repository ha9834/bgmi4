package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* loaded from: classes2.dex */
final class rr implements zzadx {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzccd f2473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rr(zzccd zzccdVar) {
        this.f2473a = zzccdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void zzc(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void zzrg() {
        zzbyn zzbynVar;
        zzbynVar = this.f2473a.d;
        zzbynVar.zzfi(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
    }
}
