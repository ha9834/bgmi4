package com.google.android.gms.internal.firebase_remote_config;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final /* synthetic */ class ap implements Executor {

    /* renamed from: a, reason: collision with root package name */
    static final Executor f4032a = new ap();

    private ap() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
