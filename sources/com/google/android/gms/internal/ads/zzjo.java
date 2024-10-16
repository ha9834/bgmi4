package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzjo implements zzjp {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f3663a;
    private int b;
    private int c;

    public zzjo(byte[] bArr) {
        zzkh.checkNotNull(bArr);
        zzkh.checkArgument(bArr.length > 0);
        this.f3663a = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long zza(zzjq zzjqVar) throws IOException {
        this.b = (int) zzjqVar.zzahv;
        this.c = (int) (zzjqVar.zzcd == -1 ? this.f3663a.length - zzjqVar.zzahv : zzjqVar.zzcd);
        int i = this.c;
        if (i > 0 && this.b + i <= this.f3663a.length) {
            return i;
        }
        int i2 = this.b;
        long j = zzjqVar.zzcd;
        int length = this.f3663a.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i2);
        sb.append(", ");
        sb.append(j);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.c;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.f3663a, this.b, bArr, i, min);
        this.b += min;
        this.c -= min;
        return min;
    }
}
