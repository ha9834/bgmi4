package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbmx implements zzdti<Set<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbmn> f2944a;
    private final zzdtu<Executor> b;
    private final zzdtu<JSONObject> c;

    private zzbmx(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        this.f2944a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzbmx zzf(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        return new zzbmx(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Set singleton;
        zzbmn zzbmnVar = this.f2944a.get();
        Executor executor = this.b.get();
        if (this.c.get() == null) {
            singleton = Collections.emptySet();
        } else {
            singleton = Collections.singleton(new zzbuz(zzbmnVar, executor));
        }
        return (Set) zzdto.zza(singleton, "Cannot return null from a non-@Nullable @Provides method");
    }
}
