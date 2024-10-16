package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* loaded from: classes2.dex */
final class bm implements Comparator<zzdp> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdp zzdpVar, zzdp zzdpVar2) {
        int b;
        int b2;
        zzdp zzdpVar3 = zzdpVar;
        zzdp zzdpVar4 = zzdpVar2;
        zzdu zzduVar = (zzdu) zzdpVar3.iterator();
        zzdu zzduVar2 = (zzdu) zzdpVar4.iterator();
        while (zzduVar.hasNext() && zzduVar2.hasNext()) {
            b = zzdp.b(zzduVar.nextByte());
            b2 = zzdp.b(zzduVar2.nextByte());
            int compare = Integer.compare(b, b2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdpVar3.size(), zzdpVar4.size());
    }
}
