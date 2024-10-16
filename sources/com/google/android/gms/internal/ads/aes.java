package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes2.dex */
final class aes implements Comparator<zzdmr> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdmr zzdmrVar, zzdmr zzdmrVar2) {
        int b;
        int b2;
        zzdmr zzdmrVar3 = zzdmrVar;
        zzdmr zzdmrVar4 = zzdmrVar2;
        zzdmy zzdmyVar = (zzdmy) zzdmrVar3.iterator();
        zzdmy zzdmyVar2 = (zzdmy) zzdmrVar4.iterator();
        while (zzdmyVar.hasNext() && zzdmyVar2.hasNext()) {
            b = zzdmr.b(zzdmyVar.nextByte());
            b2 = zzdmr.b(zzdmyVar2.nextByte());
            int compare = Integer.compare(b, b2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdmrVar3.size(), zzdmrVar4.size());
    }
}
