package com.google.android.gms.internal.firebase_remote_config;

import java.util.Comparator;

/* loaded from: classes2.dex */
final class bi implements Comparator<zzfx> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzfx zzfxVar, zzfx zzfxVar2) {
        int b;
        int b2;
        zzfx zzfxVar3 = zzfxVar;
        zzfx zzfxVar4 = zzfxVar2;
        zzgc zzgcVar = (zzgc) zzfxVar3.iterator();
        zzgc zzgcVar2 = (zzgc) zzfxVar4.iterator();
        while (zzgcVar.hasNext() && zzgcVar2.hasNext()) {
            b = zzfx.b(zzgcVar.nextByte());
            b2 = zzfx.b(zzgcVar2.nextByte());
            int compare = Integer.compare(b, b2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzfxVar3.size(), zzfxVar4.size());
    }
}
