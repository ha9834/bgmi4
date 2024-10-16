package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzgj {

    /* renamed from: a, reason: collision with root package name */
    int f4175a;
    int b;
    int c;
    br d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgj a(byte[] bArr, int i, int i2, boolean z) {
        bq bqVar = new bq(bArr, 0, i2, false);
        try {
            bqVar.zzaa(i2);
            return bqVar;
        } catch (zzhm e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzac(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzg(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long a() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzaa(int i) throws zzhm;

    public abstract void zzab(int i);

    public abstract int zzfb() throws IOException;

    public abstract long zzfc() throws IOException;

    public abstract long zzfd() throws IOException;

    public abstract int zzfe() throws IOException;

    public abstract long zzff() throws IOException;

    public abstract int zzfg() throws IOException;

    public abstract boolean zzfh() throws IOException;

    public abstract String zzfi() throws IOException;

    public abstract zzfx zzfj() throws IOException;

    public abstract int zzfk() throws IOException;

    public abstract int zzfl() throws IOException;

    public abstract int zzfm() throws IOException;

    public abstract long zzfn() throws IOException;

    public abstract int zzfo() throws IOException;

    public abstract long zzfp() throws IOException;

    public abstract boolean zzfr() throws IOException;

    public abstract int zzfs();

    public abstract void zzy(int i) throws zzhm;

    public abstract boolean zzz(int i) throws IOException;

    private zzgj() {
        this.b = 100;
        this.c = Integer.MAX_VALUE;
        this.e = false;
    }
}
