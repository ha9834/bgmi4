package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aiw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzdy f1901a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aiw(zzdy zzdyVar) {
        this.f1901a = zzdyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzacu.initialize(this.f1901a.f3628a);
    }
}
