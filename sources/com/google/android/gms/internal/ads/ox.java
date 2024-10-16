package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class ox implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<zzbtb> f2405a;

    private ox(zzbtb zzbtbVar) {
        this.f2405a = new WeakReference<>(zzbtbVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbtb zzbtbVar = this.f2405a.get();
        if (zzbtbVar != null) {
            zzbtb.a(zzbtbVar);
        }
    }
}
