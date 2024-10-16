package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ho implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f2221a = new zzaxa(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
                return;
            } catch (Throwable th) {
                zzk.zzlg();
                zzaxi.zza(zzk.zzlk().getApplicationContext(), th);
                throw th;
            }
        }
        this.f2221a.post(runnable);
    }
}
