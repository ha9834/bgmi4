package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
final class dp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AdOverlayInfoParcel f2128a;
    private final /* synthetic */ zzapl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(zzapl zzaplVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.b = zzaplVar;
        this.f2128a = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        zzk.zzlf();
        activity = this.b.f2774a;
        com.google.android.gms.ads.internal.overlay.zzm.zza(activity, this.f2128a, true);
    }
}
