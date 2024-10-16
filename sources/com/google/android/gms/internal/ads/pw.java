package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
final class pw implements zzbpe<zzbph> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, zzcjv<zzbph>> f2427a;
    private final Map<String, zzcjv<zzbyn>> b;
    private final Map<String, zzclw<zzbyn>> c;
    private final zzdtu<zzbpe<zzbnf>> d;
    private final zzbzc e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pw(Map<String, zzcjv<zzbph>> map, Map<String, zzcjv<zzbyn>> map2, Map<String, zzclw<zzbyn>> map3, zzdtu<zzbpe<zzbnf>> zzdtuVar, zzbzc zzbzcVar) {
        this.f2427a = map;
        this.b = map2;
        this.c = map3;
        this.d = zzdtuVar;
        this.e = zzbzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final zzcjv<zzbph> zze(int i, String str) {
        zzcjv<zzbnf> zze;
        zzcjv<zzbph> zzcjvVar = this.f2427a.get(str);
        if (zzcjvVar != null) {
            return zzcjvVar;
        }
        if (i == 1) {
            if (this.e.zzail() == null || (zze = this.d.get().zze(i, str)) == null) {
                return null;
            }
            return zzbph.zza(zze);
        }
        if (i != 4) {
            return null;
        }
        zzclw<zzbyn> zzclwVar = this.c.get(str);
        if (zzclwVar != null) {
            return zzbph.zza((zzclw<? extends zzbpc>) zzclwVar);
        }
        zzcjv<zzbyn> zzcjvVar2 = this.b.get(str);
        if (zzcjvVar2 != null) {
            return zzbph.zza(zzcjvVar2);
        }
        return null;
    }
}
