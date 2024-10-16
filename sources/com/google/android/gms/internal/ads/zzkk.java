package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzkk {

    /* renamed from: a, reason: collision with root package name */
    private int f3671a;
    private long[] b;

    public zzkk() {
        this(32);
    }

    private zzkk(int i) {
        this.b = new long[32];
    }

    public final void add(long j) {
        int i = this.f3671a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.b;
        int i2 = this.f3671a;
        this.f3671a = i2 + 1;
        jArr2[i2] = j;
    }

    public final long get(int i) {
        if (i < 0 || i >= this.f3671a) {
            int i2 = this.f3671a;
            StringBuilder sb = new StringBuilder(45);
            sb.append("Invalid size ");
            sb.append(i);
            sb.append(", size is ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return this.b[i];
    }

    public final int size() {
        return this.f3671a;
    }
}
