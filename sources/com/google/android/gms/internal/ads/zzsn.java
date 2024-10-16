package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzsn {

    /* renamed from: a, reason: collision with root package name */
    private int f3733a;
    private long[] b;

    public zzsn() {
        this(32);
    }

    private zzsn(int i) {
        this.b = new long[32];
    }

    public final void add(long j) {
        int i = this.f3733a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.b;
        int i2 = this.f3733a;
        this.f3733a = i2 + 1;
        jArr2[i2] = j;
    }

    public final long get(int i) {
        if (i < 0 || i >= this.f3733a) {
            int i2 = this.f3733a;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Invalid index ");
            sb.append(i);
            sb.append(", size is ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return this.b[i];
    }

    public final int size() {
        return this.f3733a;
    }
}
