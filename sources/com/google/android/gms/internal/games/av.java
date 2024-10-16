package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.request.Requests;
import java.util.Set;

/* loaded from: classes2.dex */
final class av implements Requests.UpdateRequestsResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4213a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, Status status) {
        this.f4213a = status;
    }

    @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
    public final Set<String> getRequestIds() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4213a;
    }

    @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
    public final int getRequestOutcome(String str) {
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown request ID ".concat(valueOf) : new String("Unknown request ID "));
    }
}
