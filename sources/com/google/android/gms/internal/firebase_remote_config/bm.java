package com.google.android.gms.internal.firebase_remote_config;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bm {

    /* renamed from: a, reason: collision with root package name */
    private final zzgo f4046a;
    private final byte[] b;

    private bm(int i) {
        this.b = new byte[i];
        this.f4046a = zzgo.zzc(this.b);
    }

    public final zzfx a() {
        if (this.f4046a.zzgb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
        return new zzgh(this.b);
    }

    public final zzgo b() {
        return this.f4046a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bm(int i, bg bgVar) {
        this(i);
    }
}
