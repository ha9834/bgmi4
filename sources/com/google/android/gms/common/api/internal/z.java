package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

/* loaded from: classes.dex */
final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager.zaa f1381a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(GoogleApiManager.zaa zaaVar) {
        this.f1381a = zaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1381a.c();
    }
}
