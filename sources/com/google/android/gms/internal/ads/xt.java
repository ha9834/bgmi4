package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class xt implements zzban<zzcrc> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzavy f2621a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xt(zzcqq zzcqqVar, zzavy zzavyVar) {
        this.f2621a = zzavyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        try {
            this.f2621a.onError("Internal error.");
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(@Nullable zzcrc zzcrcVar) {
        zzcrc zzcrcVar2 = zzcrcVar;
        try {
            this.f2621a.zzk(zzcrcVar2.zzgfw, zzcrcVar2.zzgfx);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
