package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bf {

    /* renamed from: a, reason: collision with root package name */
    private final zzqj f4313a;
    private final byte[] b;

    private bf(int i) {
        this.b = new byte[i];
        this.f4313a = zzqj.zzg(this.b);
    }

    public final zzps a() {
        if (this.f4313a.zzoi() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
        return new zzqc(this.b);
    }

    public final zzqj b() {
        return this.f4313a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bf(int i, ba baVar) {
        this(i);
    }
}
