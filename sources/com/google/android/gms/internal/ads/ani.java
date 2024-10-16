package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
final class ani implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ IOException f1984a;
    private final /* synthetic */ ane b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ani(ane aneVar, IOException iOException) {
        this.b = aneVar;
        this.f1984a = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqi zzqiVar;
        zzqiVar = this.b.e;
        zzqiVar.zzb(this.f1984a);
    }
}
