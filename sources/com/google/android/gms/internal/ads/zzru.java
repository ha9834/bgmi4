package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzru implements zzrv {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f3726a;
    private Uri b;
    private int c;
    private int d;

    public zzru(byte[] bArr) {
        zzsk.checkNotNull(bArr);
        zzsk.checkArgument(bArr.length > 0);
        this.f3726a = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final long zza(zzry zzryVar) throws IOException {
        this.b = zzryVar.uri;
        this.c = (int) zzryVar.zzahv;
        this.d = (int) (zzryVar.zzcd == -1 ? this.f3726a.length - zzryVar.zzahv : zzryVar.zzcd);
        int i = this.d;
        if (i > 0 && this.c + i <= this.f3726a.length) {
            return i;
        }
        int i2 = this.c;
        long j = zzryVar.zzcd;
        int length = this.f3726a.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i2);
        sb.append(", ");
        sb.append(j);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.d;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.f3726a, this.c, bArr, i, min);
        this.c += min;
        this.d -= min;
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri getUri() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final void close() throws IOException {
        this.b = null;
    }
}
