package com.google.android.gms.internal.games;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzeh f4247a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(zzeh zzehVar) {
        this.f4247a = zzehVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4247a.a();
    }
}
