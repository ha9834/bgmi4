package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
final class al implements zzaho<zzbgz> {
    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzbgz zzbgzVar, Map map) {
        zzbgz zzbgzVar2 = zzbgzVar;
        if (map.keySet().contains("start")) {
            zzbgzVar2.zzas(true);
        }
        if (map.keySet().contains("stop")) {
            zzbgzVar2.zzas(false);
        }
    }
}
