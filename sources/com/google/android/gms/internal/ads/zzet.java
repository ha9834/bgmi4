package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzet implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private final zzdy f3632a;
    private final zzbp.zza.C0092zza b;

    public zzet(zzdy zzdyVar, zzbp.zza.C0092zza c0092zza) {
        this.f3632a = zzdyVar;
        this.b = c0092zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Void call() throws Exception {
        if (this.f3632a.zzcq() != null) {
            this.f3632a.zzcq().get();
        }
        zzbp.zza zzcp = this.f3632a.zzcp();
        if (zzcp == null) {
            return null;
        }
        try {
            synchronized (this.b) {
                zzbp.zza.C0092zza c0092zza = this.b;
                byte[] byteArray = zzcp.toByteArray();
                c0092zza.zza(byteArray, 0, byteArray.length, zzdno.zzaxe());
            }
            return null;
        } catch (zzdok unused) {
            return null;
        }
    }
}
