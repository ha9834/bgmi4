package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcxf implements zzdti<zzcvb<JSONObject>> {
    public static zzcvb<JSONObject> zza(Object obj, zzcvu zzcvuVar, zzcwn zzcwnVar, zzdte<zzcvo> zzdteVar, zzdte<zzcvy> zzdteVar2, zzdte<zzcwc> zzdteVar3, zzdte<zzcwj> zzdteVar4, zzdte<zzcwq> zzdteVar5, zzdte<zzcwu> zzdteVar6, zzdte<zzcxh> zzdteVar7, Executor executor) {
        HashSet hashSet = new HashSet();
        hashSet.add((zv) obj);
        hashSet.add(zzcvuVar);
        hashSet.add(zzcwnVar);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvt)).booleanValue()) {
            hashSet.add(zzdteVar.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvu)).booleanValue()) {
            hashSet.add(zzdteVar2.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvv)).booleanValue()) {
            hashSet.add(zzdteVar3.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvw)).booleanValue()) {
            hashSet.add(zzdteVar4.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvz)).booleanValue()) {
            hashSet.add(zzdteVar5.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwb)).booleanValue()) {
            hashSet.add(zzdteVar6.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwc)).booleanValue()) {
            hashSet.add(zzdteVar7.get());
        }
        return (zzcvb) zzdto.zza(new zzcvb(executor, hashSet), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
