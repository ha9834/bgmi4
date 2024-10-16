package com.google.android.gms.internal.ads;

import java.io.IOException;

@zzard
/* loaded from: classes2.dex */
final class jk implements zzjp {

    /* renamed from: a, reason: collision with root package name */
    private final zzjp f2266a;
    private final long b;
    private final zzjp c;
    private long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jk(zzjp zzjpVar, int i, zzjp zzjpVar2) {
        this.f2266a = zzjpVar;
        this.b = i;
        this.c = zzjpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long zza(zzjq zzjqVar) throws IOException {
        long j;
        zzjq zzjqVar2;
        zzjq zzjqVar3;
        if (zzjqVar.zzahv >= this.b) {
            zzjqVar2 = null;
        } else {
            long j2 = zzjqVar.zzahv;
            if (zzjqVar.zzcd != -1) {
                j = Math.min(zzjqVar.zzcd, this.b - j2);
            } else {
                j = this.b - j2;
            }
            zzjqVar2 = new zzjq(zzjqVar.uri, j2, j, null);
        }
        if (zzjqVar.zzcd == -1 || zzjqVar.zzahv + zzjqVar.zzcd > this.b) {
            zzjqVar3 = new zzjq(zzjqVar.uri, Math.max(this.b, zzjqVar.zzahv), zzjqVar.zzcd != -1 ? Math.min(zzjqVar.zzcd, (zzjqVar.zzahv + zzjqVar.zzcd) - this.b) : -1L, null);
        } else {
            zzjqVar3 = null;
        }
        long zza = zzjqVar2 != null ? this.f2266a.zza(zzjqVar2) : 0L;
        long zza2 = zzjqVar3 != null ? this.c.zza(zzjqVar3) : 0L;
        this.d = zzjqVar.zzahv;
        if (zza == -1 || zza2 == -1) {
            return -1L;
        }
        return zza + zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.d;
        long j2 = this.b;
        if (j < j2) {
            i3 = this.f2266a.read(bArr, i, (int) Math.min(i2, j2 - j));
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

    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws IOException {
        this.f2266a.close();
        this.c.close();
    }
}
