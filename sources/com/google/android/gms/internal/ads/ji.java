package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ji implements zzhh {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbdq f2264a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ji(zzbdq zzbdqVar) {
        this.f2264a = zzbdqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zza(Surface surface) {
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zza(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzb(int i, long j) {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Dropped frames. Count: ");
        sb.append(i);
        sb.append(" Elapsed: ");
        sb.append(j);
        zzawz.zzdp(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zza(int i, int i2, float f) {
        int i3;
        int i4;
        float f2;
        this.f2264a.w = i;
        this.f2264a.x = i2;
        this.f2264a.y = f;
        zzbdq zzbdqVar = this.f2264a;
        i3 = zzbdqVar.w;
        i4 = this.f2264a.x;
        f2 = this.f2264a.y;
        zzbdqVar.a(i3, i4, f2);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzb(zzgv zzgvVar) {
        this.f2264a.b("DecoderInitializationError", zzgvVar.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzb(MediaCodec.CryptoException cryptoException) {
        this.f2264a.b("CryptoError", cryptoException.getMessage());
    }
}
