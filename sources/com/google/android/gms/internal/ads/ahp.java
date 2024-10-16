package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
final class ahp extends aho<zzdqu, zzdqu> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final boolean a(agw agwVar) {
        return false;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Object obj, zzdqu zzdquVar) {
        ((zzdob) obj).zzhhd = zzdquVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final void d(Object obj) {
        ((zzdob) obj).zzhhd.zzavj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ int f(zzdqu zzdquVar) {
        return zzdquVar.zzaxj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ int e(zzdqu zzdquVar) {
        return zzdquVar.zzbab();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ zzdqu c(zzdqu zzdquVar, zzdqu zzdquVar2) {
        zzdqu zzdquVar3 = zzdquVar;
        zzdqu zzdquVar4 = zzdquVar2;
        return zzdquVar4.equals(zzdqu.zzazz()) ? zzdquVar3 : zzdqu.a(zzdquVar3, zzdquVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ void b(zzdqu zzdquVar, aib aibVar) throws IOException {
        zzdquVar.a(aibVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ void a(zzdqu zzdquVar, aib aibVar) throws IOException {
        zzdquVar.zzb(aibVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ void b(Object obj, zzdqu zzdquVar) {
        a2(obj, zzdquVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ zzdqu c(Object obj) {
        zzdqu zzdquVar = ((zzdob) obj).zzhhd;
        if (zzdquVar != zzdqu.zzazz()) {
            return zzdquVar;
        }
        zzdqu a2 = zzdqu.a();
        a2(obj, a2);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ zzdqu b(Object obj) {
        return ((zzdob) obj).zzhhd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ void a(Object obj, zzdqu zzdquVar) {
        a2(obj, zzdquVar);
    }

    @Override // com.google.android.gms.internal.ads.aho
    final /* synthetic */ zzdqu a(zzdqu zzdquVar) {
        zzdqu zzdquVar2 = zzdquVar;
        zzdquVar2.zzavj();
        return zzdquVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ zzdqu a() {
        return zzdqu.a();
    }

    @Override // com.google.android.gms.internal.ads.aho
    final /* synthetic */ void a(zzdqu zzdquVar, int i, zzdqu zzdquVar2) {
        zzdquVar.a((i << 3) | 3, zzdquVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ void a(zzdqu zzdquVar, int i, zzdmr zzdmrVar) {
        zzdquVar.a((i << 3) | 2, zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.aho
    final /* synthetic */ void b(zzdqu zzdquVar, int i, long j) {
        zzdquVar.a((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.aho
    final /* synthetic */ void a(zzdqu zzdquVar, int i, int i2) {
        zzdquVar.a((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.aho
    public final /* synthetic */ void a(zzdqu zzdquVar, int i, long j) {
        zzdquVar.a(i << 3, Long.valueOf(j));
    }
}
