package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
final class ds extends dr<zzts, zzts> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final boolean a(cz czVar) {
        return false;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Object obj, zzts zztsVar) {
        ((zzrc) obj).zzbak = zztsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final void d(Object obj) {
        ((zzrc) obj).zzbak.zzmi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ int f(zzts zztsVar) {
        return zztsVar.zzpe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ int e(zzts zztsVar) {
        return zztsVar.zzrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ zzts c(zzts zztsVar, zzts zztsVar2) {
        zzts zztsVar3 = zztsVar;
        zzts zztsVar4 = zztsVar2;
        return zztsVar4.equals(zzts.zzrj()) ? zztsVar3 : zzts.a(zztsVar3, zztsVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ void b(zzts zztsVar, ed edVar) throws IOException {
        zztsVar.a(edVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ void a(zzts zztsVar, ed edVar) throws IOException {
        zztsVar.zzb(edVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ void b(Object obj, zzts zztsVar) {
        a2(obj, zztsVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ zzts c(Object obj) {
        zzts zztsVar = ((zzrc) obj).zzbak;
        if (zztsVar != zzts.zzrj()) {
            return zztsVar;
        }
        zzts a2 = zzts.a();
        a2(obj, a2);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ zzts b(Object obj) {
        return ((zzrc) obj).zzbak;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ void a(Object obj, zzts zztsVar) {
        a2(obj, zztsVar);
    }

    @Override // com.google.android.gms.internal.gtm.dr
    final /* synthetic */ zzts a(zzts zztsVar) {
        zzts zztsVar2 = zztsVar;
        zztsVar2.zzmi();
        return zztsVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ zzts a() {
        return zzts.a();
    }

    @Override // com.google.android.gms.internal.gtm.dr
    final /* synthetic */ void a(zzts zztsVar, int i, zzts zztsVar2) {
        zztsVar.a((i << 3) | 3, zztsVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ void a(zzts zztsVar, int i, zzps zzpsVar) {
        zztsVar.a((i << 3) | 2, zzpsVar);
    }

    @Override // com.google.android.gms.internal.gtm.dr
    final /* synthetic */ void b(zzts zztsVar, int i, long j) {
        zztsVar.a((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.gtm.dr
    final /* synthetic */ void a(zzts zztsVar, int i, int i2) {
        zztsVar.a((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dr
    public final /* synthetic */ void a(zzts zztsVar, int i, long j) {
        zztsVar.a(i << 3, Long.valueOf(j));
    }
}
