package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzdnd {

    /* renamed from: a, reason: collision with root package name */
    int f3584a;
    int b;
    afb c;
    private int d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdnd a(byte[] bArr, int i, int i2, boolean z) {
        afa afaVar = new afa(bArr, i, i2, z);
        try {
            afaVar.zzfr(i2);
            return afaVar;
        } catch (zzdok e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzfi(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzft(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long a() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzavu() throws IOException;

    public abstract long zzavv() throws IOException;

    public abstract long zzavw() throws IOException;

    public abstract int zzavx() throws IOException;

    public abstract long zzavy() throws IOException;

    public abstract int zzavz() throws IOException;

    public abstract boolean zzawa() throws IOException;

    public abstract String zzawb() throws IOException;

    public abstract zzdmr zzawc() throws IOException;

    public abstract int zzawd() throws IOException;

    public abstract int zzawe() throws IOException;

    public abstract int zzawf() throws IOException;

    public abstract long zzawg() throws IOException;

    public abstract int zzawh() throws IOException;

    public abstract long zzawi() throws IOException;

    public abstract boolean zzawk() throws IOException;

    public abstract int zzawl();

    public abstract void zzfp(int i) throws zzdok;

    public abstract boolean zzfq(int i) throws IOException;

    public abstract int zzfr(int i) throws zzdok;

    public abstract void zzfs(int i);

    private zzdnd() {
        this.b = 100;
        this.d = Integer.MAX_VALUE;
        this.e = false;
    }
}
