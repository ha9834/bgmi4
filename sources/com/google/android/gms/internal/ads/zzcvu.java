package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcvu implements zzcva<zzcvt> {

    /* renamed from: a, reason: collision with root package name */
    private final zzawi f3465a;
    private final Executor b;
    private final String c;

    @Nullable
    private final PackageInfo d;

    public zzcvu(zzawi zzawiVar, Executor executor, String str, @Nullable PackageInfo packageInfo) {
        this.f3465a = zzawiVar;
        this.b = executor;
        this.c = str;
        this.d = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvt> zzalm() {
        return zzbar.zza(zzbar.zza(this.f3465a.zza(this.c, this.d), zq.f2670a, this.b), Throwable.class, new zzbal(this) { // from class: com.google.android.gms.internal.ads.zr

            /* renamed from: a, reason: collision with root package name */
            private final zzcvu f2671a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2671a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2671a.a((Throwable) obj);
            }
        }, this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(Throwable th) throws Exception {
        return zzbar.zzm(new zzcvt(this.c));
    }
}
