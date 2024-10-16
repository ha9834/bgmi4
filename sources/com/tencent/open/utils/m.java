package com.tencent.open.utils;

/* loaded from: classes.dex */
public final class m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private long f6412a;

    public m(long j) {
        this.f6412a = j;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof m) && this.f6412a == ((m) obj).b();
    }

    public byte[] a() {
        long j = this.f6412a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f6412a;
    }

    public int hashCode() {
        return (int) this.f6412a;
    }
}
