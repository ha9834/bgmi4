package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzrr {
    public final zzrb zzbly;
    public final zzro zzblz;
    public final Object zzbma;
    public final zzlq[] zzbmb;

    public zzrr(zzrb zzrbVar, zzro zzroVar, Object obj, zzlq[] zzlqVarArr) {
        this.zzbly = zzrbVar;
        this.zzblz = zzroVar;
        this.zzbma = obj;
        this.zzbmb = zzlqVarArr;
    }

    public final boolean zza(zzrr zzrrVar, int i) {
        return zzrrVar != null && zzsy.zza(this.zzblz.zzbi(i), zzrrVar.zzblz.zzbi(i)) && zzsy.zza(this.zzbmb[i], zzrrVar.zzbmb[i]);
    }
}
