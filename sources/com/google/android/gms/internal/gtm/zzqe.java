package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzqe {

    /* renamed from: a, reason: collision with root package name */
    int f4433a;
    int b;
    bj c;
    private int d;
    private boolean e;

    public static zzqe zzd(byte[] bArr, int i, int i2) {
        return a(bArr, i, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long a() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzsk> T zza(zzsu<T> zzsuVar, zzqp zzqpVar) throws IOException;

    public abstract void zzan(int i) throws zzrk;

    public abstract boolean zzao(int i) throws IOException;

    public abstract int zzaq(int i) throws zzrk;

    public abstract void zzar(int i);

    public abstract void zzas(int i) throws IOException;

    public abstract int zzni() throws IOException;

    public abstract long zznj() throws IOException;

    public abstract long zznk() throws IOException;

    public abstract int zznl() throws IOException;

    public abstract long zznm() throws IOException;

    public abstract int zznn() throws IOException;

    public abstract boolean zzno() throws IOException;

    public abstract String zznp() throws IOException;

    public abstract zzps zznq() throws IOException;

    public abstract int zznr() throws IOException;

    public abstract int zzns() throws IOException;

    public abstract int zznt() throws IOException;

    public abstract long zznu() throws IOException;

    public abstract int zznv() throws IOException;

    public abstract long zznw() throws IOException;

    public abstract boolean zzny() throws IOException;

    public abstract int zznz();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqe a(byte[] bArr, int i, int i2, boolean z) {
        bi biVar = new bi(bArr, i, i2, false);
        try {
            biVar.zzaq(i2);
            return biVar;
        } catch (zzrk e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zzqe() {
        this.b = 100;
        this.d = Integer.MAX_VALUE;
        this.e = false;
    }

    public final int zzap(int i) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(47);
            sb.append("Recursion limit cannot be negative: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        int i2 = this.b;
        this.b = i;
        return i2;
    }
}
