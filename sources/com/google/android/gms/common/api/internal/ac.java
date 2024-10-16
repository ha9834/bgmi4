package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac implements BaseGmsClient.SignOutCallbacks {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleApiManager.zaa f1331a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(GoogleApiManager.zaa zaaVar) {
        this.f1331a = zaaVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        GoogleApiManager.this.p.post(new ad(this));
    }
}
