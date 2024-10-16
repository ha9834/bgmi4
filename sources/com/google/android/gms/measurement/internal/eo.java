package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class eo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Bundle f4837a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(zzgp zzgpVar, Bundle bundle) {
        this.b = zzgpVar;
        this.f4837a = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.f4837a);
    }
}
