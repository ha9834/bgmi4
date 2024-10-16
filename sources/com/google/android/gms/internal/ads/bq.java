package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzala f2081a;
    private final /* synthetic */ zzajw b;
    private final /* synthetic */ zzakh c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(zzakh zzakhVar, zzala zzalaVar, zzajw zzajwVar) {
        this.c = zzakhVar;
        this.f2081a = zzalaVar;
        this.b = zzajwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.c.f2745a;
        synchronized (obj) {
            if (this.f2081a.getStatus() != -1 && this.f2081a.getStatus() != 1) {
                this.f2081a.reject();
                Executor executor = zzbbm.zzeae;
                zzajw zzajwVar = this.b;
                zzajwVar.getClass();
                executor.execute(br.a(zzajwVar));
                zzawz.zzds("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
