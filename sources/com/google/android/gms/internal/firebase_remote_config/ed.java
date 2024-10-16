package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
final class ed extends ec<zzjw, zzjw> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final boolean a(dj djVar) {
        return false;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Object obj, zzjw zzjwVar) {
        ((zzhh) obj).zztg = zzjwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final void d(Object obj) {
        ((zzhh) obj).zztg.zzeu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ int f(zzjw zzjwVar) {
        return zzjwVar.zzgy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ int e(zzjw zzjwVar) {
        return zzjwVar.zzjb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ zzjw c(zzjw zzjwVar, zzjw zzjwVar2) {
        zzjw zzjwVar3 = zzjwVar;
        zzjw zzjwVar4 = zzjwVar2;
        return zzjwVar4.equals(zzjw.zziz()) ? zzjwVar3 : zzjw.a(zzjwVar3, zzjwVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ void b(zzjw zzjwVar, eo eoVar) throws IOException {
        zzjwVar.a(eoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ void a(zzjw zzjwVar, eo eoVar) throws IOException {
        zzjwVar.zzb(eoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ void b(Object obj, zzjw zzjwVar) {
        a2(obj, zzjwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ zzjw c(Object obj) {
        zzjw zzjwVar = ((zzhh) obj).zztg;
        if (zzjwVar != zzjw.zziz()) {
            return zzjwVar;
        }
        zzjw a2 = zzjw.a();
        a2(obj, a2);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ zzjw b(Object obj) {
        return ((zzhh) obj).zztg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ void a(Object obj, zzjw zzjwVar) {
        a2(obj, zzjwVar);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    final /* synthetic */ zzjw a(zzjw zzjwVar) {
        zzjw zzjwVar2 = zzjwVar;
        zzjwVar2.zzeu();
        return zzjwVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ zzjw a() {
        return zzjw.a();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    final /* synthetic */ void a(zzjw zzjwVar, int i, zzjw zzjwVar2) {
        zzjwVar.a((i << 3) | 3, zzjwVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ void a(zzjw zzjwVar, int i, zzfx zzfxVar) {
        zzjwVar.a((i << 3) | 2, zzfxVar);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    final /* synthetic */ void b(zzjw zzjwVar, int i, long j) {
        zzjwVar.a((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    final /* synthetic */ void a(zzjw zzjwVar, int i, int i2) {
        zzjwVar.a((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.ec
    public final /* synthetic */ void a(zzjw zzjwVar, int i, long j) {
        zzjwVar.a(i << 3, Long.valueOf(j));
    }
}
