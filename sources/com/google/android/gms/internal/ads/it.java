package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.view.Surface;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class it implements zzhh {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<zzhh> f2248a;
    private final /* synthetic */ zzbdk b;

    private it(zzbdk zzbdkVar) {
        this.b = zzbdkVar;
        this.f2248a = new WeakReference<>(null);
    }

    public final void a(zzhh zzhhVar) {
        this.f2248a = new WeakReference<>(zzhhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzb(int i, long j) {
        zzhh zzhhVar = this.f2248a.get();
        if (zzhhVar != null) {
            zzhhVar.zzb(i, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zza(int i, int i2, float f) {
        zzhh zzhhVar = this.f2248a.get();
        if (zzhhVar != null) {
            zzhhVar.zza(i, i2, f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zza(Surface surface) {
        zzhh zzhhVar = this.f2248a.get();
        if (zzhhVar != null) {
            zzhhVar.zza(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzb(zzgv zzgvVar) {
        this.b.a("DecoderInitializationError", zzgvVar.getMessage());
        zzhh zzhhVar = this.f2248a.get();
        if (zzhhVar != null) {
            zzhhVar.zzb(zzgvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzb(MediaCodec.CryptoException cryptoException) {
        this.b.a("CryptoError", cryptoException.getMessage());
        zzhh zzhhVar = this.f2248a.get();
        if (zzhhVar != null) {
            zzhhVar.zzb(cryptoException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zza(String str, long j, long j2) {
        zzhh zzhhVar = this.f2248a.get();
        if (zzhhVar != null) {
            zzhhVar.zza(str, j, j2);
        }
    }
}
