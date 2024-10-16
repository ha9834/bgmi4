package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager.zaa f1329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(GoogleApiManager.zaa zaaVar) {
        this.f1329a = zaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1329a.d();
    }
}
