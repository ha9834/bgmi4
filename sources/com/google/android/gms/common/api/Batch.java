package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class Batch extends BasePendingResult<BatchResult> {

    /* renamed from: a, reason: collision with root package name */
    private int f1287a;
    private boolean b;
    private boolean d;
    private final PendingResult<?>[] e;
    private final Object f;

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f = new Object();
        this.f1287a = list.size();
        this.e = new PendingResult[this.f1287a];
        if (list.isEmpty()) {
            setResult(new BatchResult(Status.RESULT_SUCCESS, this.e));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult<?> pendingResult = list.get(i);
            this.e[i] = pendingResult;
            pendingResult.addStatusListener(new a(this));
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private List<PendingResult<?>> f1288a = new ArrayList();
        private GoogleApiClient b;

        public Builder(GoogleApiClient googleApiClient) {
            this.b = googleApiClient;
        }

        public final <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.f1288a.size());
            this.f1288a.add(pendingResult);
            return batchResultToken;
        }

        public final Batch build() {
            return new Batch(this.f1288a, this.b, null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public final void cancel() {
        super.cancel();
        for (PendingResult<?> pendingResult : this.e) {
            pendingResult.cancel();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.e);
    }

    /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, a aVar) {
        this(list, googleApiClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(Batch batch, boolean z) {
        batch.d = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean b(Batch batch, boolean z) {
        batch.b = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(Batch batch) {
        int i = batch.f1287a;
        batch.f1287a = i - 1;
        return i;
    }
}
