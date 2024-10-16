package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class jj implements zzgq {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbdq f2265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jj(zzbdq zzbdqVar) {
        this.f2265a = zzbdqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zza(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzgq
    public final void zza(zzhu zzhuVar) {
        this.f2265a.b("AudioTrackInitializationError", zzhuVar.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzgq
    public final void zza(zzhv zzhvVar) {
        this.f2265a.b("AudioTrackWriteError", zzhvVar.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzb(zzgv zzgvVar) {
        this.f2265a.b("DecoderInitializationError", zzgvVar.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzb(MediaCodec.CryptoException cryptoException) {
        this.f2265a.b("CryptoError", cryptoException.getMessage());
    }
}
