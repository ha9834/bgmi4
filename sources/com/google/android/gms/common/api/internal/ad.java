package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
final class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ac f1332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.f1332a = acVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client;
        client = this.f1332a.f1331a.c;
        client.disconnect();
    }
}
