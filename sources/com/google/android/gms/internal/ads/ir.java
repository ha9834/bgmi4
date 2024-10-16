package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ir implements zzgq {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<zzgq> f2246a;
    private final /* synthetic */ zzbdk b;

    private ir(zzbdk zzbdkVar) {
        this.b = zzbdkVar;
        this.f2246a = new WeakReference<>(null);
    }

    public final void a(zzgq zzgqVar) {
        this.f2246a = new WeakReference<>(zzgqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgq
    public final void zza(zzhu zzhuVar) {
        this.b.a("AudioTrackInitializationError", zzhuVar.getMessage());
        zzgq zzgqVar = this.f2246a.get();
        if (zzgqVar != null) {
            zzgqVar.zza(zzhuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgq
    public final void zza(zzhv zzhvVar) {
        this.b.a("AudioTrackWriteError", zzhvVar.getMessage());
        zzgq zzgqVar = this.f2246a.get();
        if (zzgqVar != null) {
            zzgqVar.zza(zzhvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzb(zzgv zzgvVar) {
        this.b.a("DecoderInitializationError", zzgvVar.getMessage());
        zzgq zzgqVar = this.f2246a.get();
        if (zzgqVar != null) {
            zzgqVar.zzb(zzgvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzb(MediaCodec.CryptoException cryptoException) {
        this.b.a("CryptoError", cryptoException.getMessage());
        zzgq zzgqVar = this.f2246a.get();
        if (zzgqVar != null) {
            zzgqVar.zzb(cryptoException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zza(String str, long j, long j2) {
        zzgq zzgqVar = this.f2246a.get();
        if (zzgqVar != null) {
            zzgqVar.zza(str, j, j2);
        }
    }
}
