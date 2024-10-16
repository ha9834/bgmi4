package com.google.android.gms.internal.ads;

@zzard
/* loaded from: classes2.dex */
final class kg extends zzay {

    /* renamed from: a, reason: collision with root package name */
    static final kg f2288a = new kg();

    kg() {
    }

    @Override // com.google.android.gms.internal.ads.zzay
    public final zzbd zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbf();
        }
        if ("mvhd".equals(str)) {
            return new zzbg();
        }
        return new zzbh(str);
    }
}
