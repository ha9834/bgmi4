package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.Requests;

/* loaded from: classes2.dex */
final class at implements Requests.LoadRequestsResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4212a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, Status status) {
        this.f4212a = status;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4212a;
    }

    @Override // com.google.android.gms.games.request.Requests.LoadRequestsResult
    public final GameRequestBuffer getRequests(int i) {
        return new GameRequestBuffer(DataHolder.empty(this.f4212a.getStatusCode()));
    }
}
