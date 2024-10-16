package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzib implements zzie {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f3654a = new byte[4096];
    private final zzjp b;
    private long c;
    private long d;

    public zzib(zzjp zzjpVar, long j, long j2) {
        this.b = zzjpVar;
        this.c = j;
        this.d = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zza(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int i3 = i;
        int i4 = i2;
        while (i4 > 0) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int read = this.b.read(bArr, i3, i4);
            if (read == -1) {
                if (z && i4 == i2) {
                    return false;
                }
                throw new EOFException();
            }
            i3 += read;
            i4 -= read;
        }
        this.c += i2;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        zza(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void zzr(int i) throws IOException, InterruptedException {
        int i2 = i;
        while (i2 > 0) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            zzjp zzjpVar = this.b;
            byte[] bArr = f3654a;
            int read = zzjpVar.read(bArr, 0, Math.min(bArr.length, i2));
            if (read == -1) {
                throw new EOFException();
            }
            i2 -= read;
        }
        this.c += i;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final long getPosition() {
        return this.c;
    }
}
