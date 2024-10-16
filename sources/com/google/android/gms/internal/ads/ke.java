package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

@zzard
/* loaded from: classes2.dex */
final class ke implements zzrv {

    /* renamed from: a, reason: collision with root package name */
    private final zzrv f2286a;
    private final long b;
    private final zzrv c;
    private long d;
    private Uri e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ke(zzrv zzrvVar, int i, zzrv zzrvVar2) {
        this.f2286a = zzrvVar;
        this.b = i;
        this.c = zzrvVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final long zza(zzry zzryVar) throws IOException {
        long j;
        zzry zzryVar2;
        zzry zzryVar3;
        this.e = zzryVar.uri;
        if (zzryVar.zzahv >= this.b) {
            zzryVar2 = null;
        } else {
            long j2 = zzryVar.zzahv;
            if (zzryVar.zzcd != -1) {
                j = Math.min(zzryVar.zzcd, this.b - j2);
            } else {
                j = this.b - j2;
            }
            zzryVar2 = new zzry(zzryVar.uri, j2, j, null);
        }
        if (zzryVar.zzcd == -1 || zzryVar.zzahv + zzryVar.zzcd > this.b) {
            zzryVar3 = new zzry(zzryVar.uri, Math.max(this.b, zzryVar.zzahv), zzryVar.zzcd != -1 ? Math.min(zzryVar.zzcd, (zzryVar.zzahv + zzryVar.zzcd) - this.b) : -1L, null);
        } else {
            zzryVar3 = null;
        }
        long zza = zzryVar2 != null ? this.f2286a.zza(zzryVar2) : 0L;
        long zza2 = zzryVar3 != null ? this.c.zza(zzryVar3) : 0L;
        this.d = zzryVar.zzahv;
        if (zza == -1 || zza2 == -1) {
            return -1L;
        }
        return zza + zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.d;
        long j2 = this.b;
        if (j < j2) {
            i3 = this.f2286a.read(bArr, i, (int) Math.min(i2, j2 - j));
            this.d += i3;
        } else {
            i3 = 0;
        }
        if (this.d < this.b) {
            return i3;
        }
        int read = this.c.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.d += read;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri getUri() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final void close() throws IOException {
        this.f2286a.close();
        this.c.close();
    }
}
