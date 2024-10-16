package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zace f1338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(zace zaceVar) {
        this.f1338a = zaceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zach zachVar;
        zachVar = this.f1338a.h;
        zachVar.zag(new ConnectionResult(4));
    }
}
