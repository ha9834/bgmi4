package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zznm implements zzno {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f3694a = new byte[4096];
    private final zzrv b;
    private final long c;
    private long d;
    private byte[] e = new byte[65536];
    private int f;
    private int g;

    public zznm(zzrv zzrvVar, long j, long j2) {
        this.b = zzrvVar;
        this.d = j;
        this.c = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int a2 = a(bArr, i, i2);
        if (a2 == 0) {
            a2 = a(bArr, i, i2, 0, true);
        }
        c(a2);
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final boolean zza(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int a2 = a(bArr, i, i2);
        while (a2 < i2 && a2 != -1) {
            a2 = a(bArr, i, i2, a2, z);
        }
        c(a2);
        return a2 != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        zza(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final int zzaq(int i) throws IOException, InterruptedException {
        int a2 = a(i);
        if (a2 == 0) {
            byte[] bArr = f3694a;
            a2 = a(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        c(a2);
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void zzr(int i) throws IOException, InterruptedException {
        int a2 = a(i);
        while (a2 < i && a2 != -1) {
            byte[] bArr = f3694a;
            a2 = a(bArr, -a2, Math.min(i, bArr.length + a2), a2, false);
        }
        c(a2);
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void zzc(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        if (a(i2, false)) {
            System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        }
    }

    private final boolean a(int i, boolean z) throws IOException, InterruptedException {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            this.e = Arrays.copyOf(this.e, zzsy.zzd(bArr.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.g - this.f, i);
        while (min < i) {
            min = a(this.e, this.f, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        this.f += i;
        this.g = Math.max(this.g, this.f);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void zzar(int i) throws IOException, InterruptedException {
        a(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void zzig() {
        this.f = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final long getPosition() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final long getLength() {
        return this.c;
    }

    private final int a(int i) {
        int min = Math.min(this.g, i);
        b(min);
        return min;
    }

    private final int a(byte[] bArr, int i, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.e, 0, bArr, i, min);
        b(min);
        return min;
    }

    private final void b(int i) {
        this.g -= i;
        this.f = 0;
        byte[] bArr = this.e;
        int i2 = this.g;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[i2 + 65536];
        }
        System.arraycopy(this.e, i, bArr, 0, this.g);
        this.e = bArr;
    }

    private final int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.b.read(bArr, i + i3, i2 - i3);
        if (read != -1) {
            return i3 + read;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private final void c(int i) {
        if (i != -1) {
            this.d += i;
        }
    }
}
