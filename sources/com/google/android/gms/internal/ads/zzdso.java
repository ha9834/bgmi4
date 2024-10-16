package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdso extends zzdrr<zzdso> {
    public Integer zzhrv = null;
    public String mimeType = null;
    public byte[] zzhsu = null;

    public zzdso() {
        this.f3603a = null;
        this.b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void zza(zzdrp zzdrpVar) throws IOException {
        Integer num = this.zzhrv;
        if (num != null) {
            zzdrpVar.zzx(1, num.intValue());
        }
        String str = this.mimeType;
        if (str != null) {
            zzdrpVar.zzf(2, str);
        }
        byte[] bArr = this.zzhsu;
        if (bArr != null) {
            zzdrpVar.zza(3, bArr);
        }
        super.zza(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int a() {
        int a2 = super.a();
        Integer num = this.zzhrv;
        if (num != null) {
            a2 += zzdrp.zzab(1, num.intValue());
        }
        String str = this.mimeType;
        if (str != null) {
            a2 += zzdrp.zzg(2, str);
        }
        byte[] bArr = this.zzhsu;
        return bArr != null ? a2 + zzdrp.zzb(3, bArr) : a2;
    }
}
