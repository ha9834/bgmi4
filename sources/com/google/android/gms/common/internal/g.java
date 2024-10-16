package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class g implements PendingResult.StatusListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ PendingResult f1470a;
    private final /* synthetic */ TaskCompletionSource b;
    private final /* synthetic */ PendingResultUtil.ResultConverter c;
    private final /* synthetic */ PendingResultUtil.zaa d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.zaa zaaVar) {
        this.f1470a = pendingResult;
        this.b = taskCompletionSource;
        this.c = resultConverter;
        this.d = zaaVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            this.b.setResult(this.c.convert(this.f1470a.await(0L, TimeUnit.MILLISECONDS)));
        } else {
            this.b.setException(this.d.zaf(status));
        }
    }
}
