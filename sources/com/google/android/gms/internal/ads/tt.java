package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
final class tt implements zzbtk {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2527a;
    private final zzavg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public tt(Context context, zzavg zzavgVar) {
        this.f2527a = context;
        this.b = zzavgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzb(zzarx zzarxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zza(zzcxu zzcxuVar) {
        if (TextUtils.isEmpty(zzcxuVar.zzgky.zzgku.zzdoj)) {
            return;
        }
        this.b.zzi(this.f2527a, zzcxuVar.zzgky.zzgku.zzdoj);
    }
}
