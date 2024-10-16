package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzop;

/* loaded from: classes2.dex */
final class cr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzop f5108a;
    private final /* synthetic */ cp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cp cpVar, zzop zzopVar) {
        this.b = cpVar;
        this.f5108a = zzopVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.f5108a);
    }
}
