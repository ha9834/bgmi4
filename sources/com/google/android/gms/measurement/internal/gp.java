package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class gp extends a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzjg f4890a;
    private final /* synthetic */ zzjc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gp(zzjc zzjcVar, eg egVar, zzjg zzjgVar) {
        super(egVar);
        this.b = zzjcVar;
        this.f4890a = zzjgVar;
    }

    @Override // com.google.android.gms.measurement.internal.a
    public final void a() {
        this.b.cancel();
        this.b.zzab().zzgs().zzao("Starting upload from DelayedRunnable");
        this.f4890a.c();
    }
}
