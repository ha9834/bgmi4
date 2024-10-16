package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzdcb<P> {

    /* renamed from: a, reason: collision with root package name */
    private final P f3540a;
    private final byte[] b;
    private final zzdgu c;
    private final zzdhm d;

    public zzdcb(P p, byte[] bArr, zzdgu zzdguVar, zzdhm zzdhmVar) {
        this.f3540a = p;
        this.b = Arrays.copyOf(bArr, bArr.length);
        this.c = zzdguVar;
        this.d = zzdhmVar;
    }

    public final P zzanv() {
        return this.f3540a;
    }

    public final zzdhm zzanw() {
        return this.d;
    }

    public final byte[] zzanx() {
        byte[] bArr = this.b;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
