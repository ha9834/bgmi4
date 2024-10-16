package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
final class ee extends ed<zzhs, zzhs> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final boolean a(dm dmVar) {
        return false;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Object obj, zzhs zzhsVar) {
        ((zzey) obj).zzahz = zzhsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final void d(Object obj) {
        ((zzey) obj).zzahz.zzry();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ int f(zzhs zzhsVar) {
        return zzhsVar.zzuk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ int e(zzhs zzhsVar) {
        return zzhsVar.zzws();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ zzhs c(zzhs zzhsVar, zzhs zzhsVar2) {
        zzhs zzhsVar3 = zzhsVar;
        zzhs zzhsVar4 = zzhsVar2;
        return zzhsVar4.equals(zzhs.zzwq()) ? zzhsVar3 : zzhs.a(zzhsVar3, zzhsVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ void b(zzhs zzhsVar, ep epVar) throws IOException {
        zzhsVar.a(epVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ void a(zzhs zzhsVar, ep epVar) throws IOException {
        zzhsVar.zzb(epVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ void b(Object obj, zzhs zzhsVar) {
        a2(obj, zzhsVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ zzhs c(Object obj) {
        zzhs zzhsVar = ((zzey) obj).zzahz;
        if (zzhsVar != zzhs.zzwq()) {
            return zzhsVar;
        }
        zzhs a2 = zzhs.a();
        a2(obj, a2);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ zzhs b(Object obj) {
        return ((zzey) obj).zzahz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ void a(Object obj, zzhs zzhsVar) {
        a2(obj, zzhsVar);
    }

    @Override // com.google.android.gms.internal.measurement.ed
    final /* synthetic */ zzhs a(zzhs zzhsVar) {
        zzhs zzhsVar2 = zzhsVar;
        zzhsVar2.zzry();
        return zzhsVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ zzhs a() {
        return zzhs.a();
    }

    @Override // com.google.android.gms.internal.measurement.ed
    final /* synthetic */ void a(zzhs zzhsVar, int i, zzhs zzhsVar2) {
        zzhsVar.a((i << 3) | 3, zzhsVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ void a(zzhs zzhsVar, int i, zzdp zzdpVar) {
        zzhsVar.a((i << 3) | 2, zzdpVar);
    }

    @Override // com.google.android.gms.internal.measurement.ed
    final /* synthetic */ void b(zzhs zzhsVar, int i, long j) {
        zzhsVar.a((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.ed
    final /* synthetic */ void a(zzhs zzhsVar, int i, int i2) {
        zzhsVar.a((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ed
    public final /* synthetic */ void a(zzhs zzhsVar, int i, long j) {
        zzhsVar.a(i << 3, Long.valueOf(j));
    }
}
