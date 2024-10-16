package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class gs implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzjm f4892a;
    private final /* synthetic */ zzjg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gs(zzjg zzjgVar, zzjm zzjmVar) {
        this.b = zzjgVar;
        this.f4892a = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f4892a);
        this.b.a();
    }
}
