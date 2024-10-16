package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzj;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class sc implements zzj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcdn f2483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sc(zzcdn zzcdnVar) {
        this.f2483a = zzcdnVar;
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final void zzlc() {
        zzbtb zzbtbVar;
        zzbtbVar = this.f2483a.h;
        zzbtbVar.onPause();
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final void zzld() {
        zzbtb zzbtbVar;
        zzbtbVar = this.f2483a.h;
        zzbtbVar.onResume();
    }
}
