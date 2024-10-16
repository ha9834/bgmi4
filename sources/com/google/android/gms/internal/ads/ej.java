package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
final class ej implements zzban<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbh f2148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ej(zzauq zzauqVar, zzbbh zzbbhVar) {
        this.f2148a = zzbbhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        List list;
        list = zzauq.f2809a;
        list.remove(this.f2148a);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(Void r2) {
        List list;
        list = zzauq.f2809a;
        list.remove(this.f2148a);
    }
}
