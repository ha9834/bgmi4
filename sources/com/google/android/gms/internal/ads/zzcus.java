package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcus implements zzcva<zzcur> {

    /* renamed from: a, reason: collision with root package name */
    private final zzavg f3449a;
    private final zzbbl b;
    private final Context c;

    public zzcus(zzavg zzavgVar, zzbbl zzbblVar, Context context) {
        this.f3449a = zzavgVar;
        this.b = zzbblVar;
        this.c = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcur> zzalm() {
        return this.b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zg

            /* renamed from: a, reason: collision with root package name */
            private final zzcus f2660a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2660a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2660a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcur a() throws Exception {
        Long l;
        if (!this.f3449a.zzx(this.c)) {
            return new zzcur(null, null, null, null, null);
        }
        String zzaa = this.f3449a.zzaa(this.c);
        if (zzaa == null) {
            zzaa = "";
        }
        String str = zzaa;
        String zzab = this.f3449a.zzab(this.c);
        if (zzab == null) {
            zzab = "";
        }
        String str2 = zzab;
        String zzac = this.f3449a.zzac(this.c);
        if (zzac == null) {
            zzac = "";
        }
        String str3 = zzac;
        String zzad = this.f3449a.zzad(this.c);
        if (zzad == null) {
            zzad = "";
        }
        String str4 = zzad;
        if ("TIME_OUT".equals(str2)) {
            l = (Long) zzyt.zzpe().zzd(zzacu.zzcnx);
        } else {
            l = null;
        }
        return new zzcur(str, str2, str3, str4, l);
    }
}
