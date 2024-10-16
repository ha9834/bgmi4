package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class zzqc extends zzqb {
    protected final byte[] zzawe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqc(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.zzawe = bArr;
    }

    protected int b() {
        return 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public byte zzak(int i) {
        return this.zzawe[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzps
    public byte a(int i) {
        return this.zzawe[i];
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public int size() {
        return this.zzawe.length;
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final zzps zzc(int i, int i2) {
        int b = b(0, i2, size());
        if (b == 0) {
            return zzps.zzavx;
        }
        return new zzpx(this.zzawe, b(), b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzps
    public final void a(zzpr zzprVar) throws IOException {
        zzprVar.zza(this.zzawe, b(), size());
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    protected final String a(Charset charset) {
        return new String(this.zzawe, b(), size(), charset);
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final boolean zznd() {
        int b = b();
        return dx.a(this.zzawe, b, size() + b);
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzps) || size() != ((zzps) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof zzqc) {
            zzqc zzqcVar = (zzqc) obj;
            int a2 = a();
            int a3 = zzqcVar.a();
            if (a2 == 0 || a3 == 0 || a2 == a3) {
                return a(zzqcVar, 0, size());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzqb
    final boolean a(zzps zzpsVar, int i, int i2) {
        if (i2 > zzpsVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzpsVar.size()) {
            int size2 = zzpsVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzpsVar instanceof zzqc) {
            zzqc zzqcVar = (zzqc) zzpsVar;
            return dv.a(this.zzawe, b(), zzqcVar.zzawe, zzqcVar.b(), i2) == -1;
        }
        return zzpsVar.zzc(0, i2).equals(zzc(0, i2));
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    protected final int a(int i, int i2, int i3) {
        return zzre.a(i, this.zzawe, b(), i3);
    }
}
