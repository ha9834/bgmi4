package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class BatchResult implements Result {

    /* renamed from: a, reason: collision with root package name */
    private final Status f1289a;
    private final PendingResult<?>[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.f1289a = status;
        this.b = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f1289a;
    }

    public final <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        Preconditions.checkArgument(batchResultToken.f1290a < this.b.length, "The result token does not belong to this batch");
        return (R) this.b[batchResultToken.f1290a].await(0L, TimeUnit.MILLISECONDS);
    }
}
