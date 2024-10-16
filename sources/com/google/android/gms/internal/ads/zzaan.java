package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

@zzard
/* loaded from: classes2.dex */
public final class zzaan implements MuteThisAdReason {

    /* renamed from: a, reason: collision with root package name */
    private final String f2681a;
    private zzaak b;

    public zzaan(zzaak zzaakVar) {
        String str;
        this.b = zzaakVar;
        try {
            str = zzaakVar.getDescription();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            str = null;
        }
        this.f2681a = str;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.f2681a;
    }

    public final zzaak zzpu() {
        return this.b;
    }
}
