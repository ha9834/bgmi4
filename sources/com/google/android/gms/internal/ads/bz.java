package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bz implements zzbbt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzakw f2089a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(zzala zzalaVar, zzakw zzakwVar) {
        this.f2089a = zzakwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final void run() {
        zzawz.zzds("Rejecting reference for JS Engine.");
        this.f2089a.reject();
    }
}
