package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzdap;
import com.google.android.gms.internal.ads.zzdau;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzdan {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3528a;
    private final Looper b;

    public zzdan(Context context, Looper looper) {
        this.f3528a = context;
        this.b = looper;
    }

    public final void zzgb(String str) {
        new abb(this.f3528a, this.b, (zzdau) ((zzdob) zzdau.zzank().zzge(this.f3528a.getPackageName()).zzb(zzdau.zzb.BLOCKED_IMPRESSION).zzb(zzdap.zzani().zzgd(str).zzb(zzdap.zza.BLOCKED_REASON_BACKGROUND)).zzaya())).a();
    }
}
