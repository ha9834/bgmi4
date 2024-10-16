package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcqz implements zzbal<zzarx, zzcrc> {

    /* renamed from: a, reason: collision with root package name */
    private Executor f3387a;
    private zzchz b;

    public zzcqz(Executor executor, zzchz zzchzVar) {
        this.f3387a = executor;
        this.b = zzchzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final /* synthetic */ zzbbh<zzcrc> zzf(zzarx zzarxVar) throws Exception {
        final zzarx zzarxVar2 = zzarxVar;
        return zzbar.zza(this.b.zzg(zzarxVar2), new zzbal(zzarxVar2) { // from class: com.google.android.gms.internal.ads.xw

            /* renamed from: a, reason: collision with root package name */
            private final zzarx f2623a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2623a = zzarxVar2;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.zzm(new zzcrc(new JsonReader(new InputStreamReader((InputStream) obj))).a(this.f2623a.zzdot));
            }
        }, this.f3387a);
    }
}
