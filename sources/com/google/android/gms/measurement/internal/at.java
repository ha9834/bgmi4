package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class at implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4742a;
    private final /* synthetic */ long b;
    private final /* synthetic */ zza c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(zza zzaVar, String str, long j) {
        this.c = zzaVar;
        this.f4742a = str;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f4742a, this.b);
    }
}
