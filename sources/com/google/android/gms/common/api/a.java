package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements PendingResult.StatusListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Batch f1303a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Batch batch) {
        this.f1303a = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Object obj;
        int i;
        boolean z;
        boolean z2;
        Status status2;
        PendingResult[] pendingResultArr;
        obj = this.f1303a.f;
        synchronized (obj) {
            if (this.f1303a.isCanceled()) {
                return;
            }
            if (status.isCanceled()) {
                Batch.a(this.f1303a, true);
            } else if (!status.isSuccess()) {
                Batch.b(this.f1303a, true);
            }
            Batch.b(this.f1303a);
            i = this.f1303a.f1287a;
            if (i == 0) {
                z = this.f1303a.d;
                if (z) {
                    super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                } else {
                    z2 = this.f1303a.b;
                    if (z2) {
                        status2 = new Status(13);
                    } else {
                        status2 = Status.RESULT_SUCCESS;
                    }
                    Batch batch = this.f1303a;
                    pendingResultArr = this.f1303a.e;
                    batch.setResult(new BatchResult(status2, pendingResultArr));
                }
            }
        }
    }
}
