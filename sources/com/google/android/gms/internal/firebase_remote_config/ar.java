package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class ar<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final CountDownLatch f4034a;

    private ar() {
        this.f4034a = new CountDownLatch(1);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        this.f4034a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f4034a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.f4034a.countDown();
    }

    public final boolean a(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f4034a.await(5L, timeUnit);
    }
}
