package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsl extends zzdrr<zzdsl> {
    private static volatile zzdsl[] c;
    public byte[] zzhsn = null;
    public byte[] zzhso = null;

    public static zzdsl[] zzbaz() {
        if (c == null) {
            synchronized (zzdrv.zzhnw) {
                if (c == null) {
                    c = new zzdsl[0];
                }
            }
        }
        return c;
    }

    public zzdsl() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        zzdrpVar.zza(1, this.zzhsn);
        byte[] bArr = this.zzhso;
        if (bArr != null) {
            zzdrpVar.zza(2, bArr);
        }
        super.zza(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int a() {
        int a2 = super.a() + zzdrp.zzb(1, this.zzhsn);
        byte[] bArr = this.zzhso;
        return bArr != null ? a2 + zzdrp.zzb(2, bArr) : a2;
    }
}
