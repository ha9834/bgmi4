package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fg {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2169a;
    private volatile int b;
    private volatile long c;

    private fg() {
        this.f2169a = new Object();
        this.b = fh.f2170a;
        this.c = 0L;
    }

    public final void a() {
        long currentTimeMillis = zzk.zzln().currentTimeMillis();
        synchronized (this.f2169a) {
            if (this.b == fh.c) {
                if (this.c + ((Long) zzyt.zzpe().zzd(zzacu.zzcwe)).longValue() <= currentTimeMillis) {
                    this.b = fh.f2170a;
                }
            }
        }
        long currentTimeMillis2 = zzk.zzln().currentTimeMillis();
        synchronized (this.f2169a) {
            if (this.b != 2) {
                return;
            }
            this.b = 3;
            if (this.b == fh.c) {
                this.c = currentTimeMillis2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ fg(ff ffVar) {
        this();
    }
}
