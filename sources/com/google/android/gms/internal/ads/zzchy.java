package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* loaded from: classes2.dex */
public final class zzchy extends zzars {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzchx f3267a;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzchy(zzchx zzchxVar) {
        this.f3267a = zzchxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzarr
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.f3267a.f3266a.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }

    @Override // com.google.android.gms.internal.ads.zzarr
    public final void zza(zzaym zzaymVar) {
        this.f3267a.f3266a.setException(new zzayn(zzaymVar.zzdwv, zzaymVar.errorCode));
    }
}
