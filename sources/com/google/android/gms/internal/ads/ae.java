package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
final class ae implements zzaho<zzbgz> {
    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzbgz zzbgzVar, Map map) {
        zzbgz zzbgzVar2 = zzbgzVar;
        com.google.android.gms.ads.internal.overlay.zzd zzaae = zzbgzVar2.zzaae();
        if (zzaae != null) {
            zzaae.close();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzd zzaaf = zzbgzVar2.zzaaf();
        if (zzaaf != null) {
            zzaaf.close();
        } else {
            zzawz.zzep("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
