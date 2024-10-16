package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
final class ak implements zzaho<zzbgz> {
    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzbgz zzbgzVar, Map map) {
        zzbgz zzbgzVar2 = zzbgzVar;
        if (map.keySet().contains("start")) {
            zzbgzVar2.zzaai().zzabe();
        } else if (map.keySet().contains("stop")) {
            zzbgzVar2.zzaai().zzabf();
        } else if (map.keySet().contains("cancel")) {
            zzbgzVar2.zzaai().zzabg();
        }
    }
}
