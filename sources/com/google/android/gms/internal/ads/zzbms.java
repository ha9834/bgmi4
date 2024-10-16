package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbms implements zzdti<Set<zzbuz<zzbrw>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbmn> f2939a;
    private final zzdtu<Executor> b;
    private final zzdtu<JSONObject> c;

    private zzbms(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        this.f2939a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzbms zzc(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        return new zzbms(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Set singleton;
        zzbmn zzbmnVar = this.f2939a.get();
        Executor executor = this.b.get();
        if (this.c.get() == null) {
            singleton = Collections.emptySet();
        } else {
            singleton = Collections.singleton(new zzbuz(zzbmnVar, executor));
        }
        return (Set) zzdto.zza(singleton, "Cannot return null from a non-@Nullable @Provides method");
    }
}
