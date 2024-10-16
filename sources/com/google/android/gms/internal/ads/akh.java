package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class akh implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Handler f1932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public akh(zzi zziVar, Handler handler) {
        this.f1932a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1932a.post(runnable);
    }
}
