package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes2.dex */
final class aoz implements Comparator<zzvi> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aoz(zzvb zzvbVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzvi zzviVar, zzvi zzviVar2) {
        zzvi zzviVar3 = zzviVar;
        zzvi zzviVar4 = zzviVar2;
        int i = zzviVar3.c - zzviVar4.c;
        return i != 0 ? i : (int) (zzviVar3.f3759a - zzviVar4.f3759a);
    }
}
