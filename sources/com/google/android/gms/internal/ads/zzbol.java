package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzbol extends zzbnf {
    private final zzaga f;
    private final Runnable g;
    private final Executor h;

    public zzbol(zzaga zzagaVar, Runnable runnable, Executor executor) {
        this.f = zzagaVar;
        this.g = runnable;
        this.h = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final zzaar getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void zza(ViewGroup viewGroup, zzyd zzydVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final View zzafi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final zzcxn zzafj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final int zzafk() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void zzpm() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final void zzafl() {
        final AtomicReference atomicReference = new AtomicReference(this.g);
        final Runnable runnable = new Runnable(atomicReference) { // from class: com.google.android.gms.internal.ads.nm

            /* renamed from: a, reason: collision with root package name */
            private final AtomicReference f2372a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2372a = atomicReference;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable2 = (Runnable) this.f2372a.getAndSet(null);
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        };
        this.h.execute(new Runnable(this, runnable) { // from class: com.google.android.gms.internal.ads.nn

            /* renamed from: a, reason: collision with root package name */
            private final zzbol f2373a;
            private final Runnable b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2373a = this;
                this.b = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2373a.a(this.b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Runnable runnable) {
        try {
            if (this.f.zzq(ObjectWrapper.wrap(runnable))) {
                return;
            }
            runnable.run();
        } catch (RemoteException unused) {
            runnable.run();
        }
    }
}
