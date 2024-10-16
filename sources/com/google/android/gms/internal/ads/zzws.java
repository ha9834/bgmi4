package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzws {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f3769a;
    private int b;
    private int c;
    private final /* synthetic */ zzwo d;

    private zzws(zzwo zzwoVar, byte[] bArr) {
        this.d = zzwoVar;
        this.f3769a = bArr;
    }

    public final synchronized void zzdj() {
        try {
            if (this.d.b) {
                this.d.f3768a.zzc(this.f3769a);
                this.d.f3768a.zzl(this.b);
                this.d.f3768a.zzm(this.c);
                this.d.f3768a.zza(null);
                this.d.f3768a.zzdj();
            }
        } catch (RemoteException e) {
            zzbad.zzb("Clearcut log failed", e);
        }
    }

    public final zzws zzbx(int i) {
        this.b = i;
        return this;
    }

    public final zzws zzby(int i) {
        this.c = i;
        return this;
    }
}
