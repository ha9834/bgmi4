package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final /* synthetic */ class zzj implements Executor {
    static final Executor zzam = new zzj();

    private zzj() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
