package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class zzdnb extends zzdna {
    protected final byte[] zzhcy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdnb(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.zzhcy = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public byte zzfm(int i) {
        return this.zzhcy[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdmr
    public byte a(int i) {
        return this.zzhcy[i];
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public int size() {
        return this.zzhcy.length;
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final zzdmr zzv(int i, int i2) {
        int b = b(0, i2, size());
        if (b == 0) {
            return zzdmr.zzhcr;
        }
        return new zzdmw(this.zzhcy, b(), b);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    protected void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzhcy, 0, bArr, 0, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdmr
    public final void a(zzdmq zzdmqVar) throws IOException {
        zzdmqVar.zzh(this.zzhcy, b(), size());
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    protected final String a(Charset charset) {
        return new String(this.zzhcy, b(), size(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final boolean zzavo() {
        int b = b();
        return ahv.a(this.zzhcy, b, size() + b);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdmr) || size() != ((zzdmr) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof zzdnb) {
            zzdnb zzdnbVar = (zzdnb) obj;
            int a2 = a();
            int a3 = zzdnbVar.a();
            if (a2 == 0 || a3 == 0 || a2 == a3) {
                return a(zzdnbVar, 0, size());
            }
            return false;
        }
        return obj.equals(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzdna
    final boolean a(zzdmr zzdmrVar, int i, int i2) {
        if (i2 > zzdmrVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzdmrVar.size()) {
            int size2 = zzdmrVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzdmrVar instanceof zzdnb) {
            zzdnb zzdnbVar = (zzdnb) zzdmrVar;
            byte[] bArr = this.zzhcy;
            byte[] bArr2 = zzdnbVar.zzhcy;
            int b = b() + i2;
            int b2 = b();
            int b3 = zzdnbVar.b();
            while (b2 < b) {
                if (bArr[b2] != bArr2[b3]) {
                    return false;
                }
                b2++;
                b3++;
            }
            return true;
        }
        return zzdmrVar.zzv(0, i2).equals(zzv(0, i2));
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    protected final int a(int i, int i2, int i3) {
        return zzdod.a(i, this.zzhcy, b(), i3);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final zzdnd zzavp() {
        return zzdnd.a(this.zzhcy, b(), size(), true);
    }
}
