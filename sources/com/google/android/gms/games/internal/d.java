package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BaseGmsClient;

/* loaded from: classes.dex */
final class d implements BaseImplementation.ResultHolder<Status> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ BaseGmsClient.SignOutCallbacks f1664a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        this.f1664a = signOutCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.f1664a.onSignOutComplete();
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* synthetic */ void setResult(Status status) {
        this.f1664a.onSignOutComplete();
    }
}
