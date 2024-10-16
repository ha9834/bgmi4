package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ei implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4831a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Object c;
    private final /* synthetic */ long d;
    private final /* synthetic */ zzgp e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(zzgp zzgpVar, String str, String str2, Object obj, long j) {
        this.e = zzgpVar;
        this.f4831a = str;
        this.b = str2;
        this.c = obj;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.a(this.f4831a, this.b, this.c, this.d);
    }
}
