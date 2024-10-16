package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class zzdz extends zzdw {
    protected final byte[] zzado;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdz(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.zzado = bArr;
    }

    protected int b() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzdp
    public byte zzaq(int i) {
        return this.zzado[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdp
    public byte a(int i) {
        return this.zzado[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzdp
    public int size() {
        return this.zzado.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzdp
    public final zzdp zza(int i, int i2) {
        int b = b(0, i2, size());
        if (b == 0) {
            return zzdp.zzadh;
        }
        return new zzds(this.zzado, b(), b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdp
    public final void a(zzdm zzdmVar) throws IOException {
        zzdmVar.zza(this.zzado, b(), size());
    }

    @Override // com.google.android.gms.internal.measurement.zzdp
    protected final String a(Charset charset) {
        return new String(this.zzado, b(), size(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzdp
    public final boolean zzsb() {
        int b = b();
        return ej.a(this.zzado, b, size() + b);
    }

    @Override // com.google.android.gms.internal.measurement.zzdp
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdp) || size() != ((zzdp) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof zzdz) {
            zzdz zzdzVar = (zzdz) obj;
            int a2 = a();
            int a3 = zzdzVar.a();
            if (a2 == 0 || a3 == 0 || a2 == a3) {
                return a(zzdzVar, 0, size());
            }
            return false;
        }
        return obj.equals(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzdw
    final boolean a(zzdp zzdpVar, int i, int i2) {
        if (i2 > zzdpVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzdpVar.size()) {
            int size2 = zzdpVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzdpVar instanceof zzdz) {
            zzdz zzdzVar = (zzdz) zzdpVar;
            byte[] bArr = this.zzado;
            byte[] bArr2 = zzdzVar.zzado;
            int b = b() + i2;
            int b2 = b();
            int b3 = zzdzVar.b();
            while (b2 < b) {
                if (bArr[b2] != bArr2[b3]) {
                    return false;
                }
                b2++;
                b3++;
            }
            return true;
        }
        return zzdpVar.zza(0, i2).equals(zza(0, i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzdp
    protected final int a(int i, int i2, int i3) {
        return zzez.a(i, this.zzado, b(), i3);
    }
}
