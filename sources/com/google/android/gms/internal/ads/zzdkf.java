package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzdkf {

    /* renamed from: a, reason: collision with root package name */
    private final zzdlj f3569a;
    private final zzdlj b;

    public zzdkf(byte[] bArr, byte[] bArr2) {
        this.f3569a = zzdlj.zzv(bArr);
        this.b = zzdlj.zzv(bArr2);
    }

    public final byte[] zzauw() {
        zzdlj zzdljVar = this.f3569a;
        if (zzdljVar == null) {
            return null;
        }
        return zzdljVar.getBytes();
    }

    public final byte[] zzaux() {
        zzdlj zzdljVar = this.b;
        if (zzdljVar == null) {
            return null;
        }
        return zzdljVar.getBytes();
    }
}
