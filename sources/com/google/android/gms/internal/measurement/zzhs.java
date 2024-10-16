package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzhs {

    /* renamed from: a, reason: collision with root package name */
    private static final zzhs f4568a = new zzhs(0, new int[0], new Object[0], false);
    private int b;
    private int[] c;
    private Object[] d;
    private int e;
    private boolean f;

    public static zzhs zzwq() {
        return f4568a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhs a() {
        return new zzhs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhs a(zzhs zzhsVar, zzhs zzhsVar2) {
        int i = zzhsVar.b + zzhsVar2.b;
        int[] copyOf = Arrays.copyOf(zzhsVar.c, i);
        System.arraycopy(zzhsVar2.c, 0, copyOf, zzhsVar.b, zzhsVar2.b);
        Object[] copyOf2 = Arrays.copyOf(zzhsVar.d, i);
        System.arraycopy(zzhsVar2.d, 0, copyOf2, zzhsVar.b, zzhsVar2.b);
        return new zzhs(i, copyOf, copyOf2, true);
    }

    private zzhs() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhs(int i, int[] iArr, Object[] objArr, boolean z) {
        this.e = -1;
        this.b = i;
        this.c = iArr;
        this.d = objArr;
        this.f = z;
    }

    public final void zzry() {
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ep epVar) throws IOException {
        if (epVar.a() == zzey.zzd.zzaip) {
            for (int i = this.b - 1; i >= 0; i--) {
                epVar.a(this.c[i] >>> 3, this.d[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            epVar.a(this.c[i2] >>> 3, this.d[i2]);
        }
    }

    public final void zzb(ep epVar) throws IOException {
        if (this.b == 0) {
            return;
        }
        if (epVar.a() == zzey.zzd.zzaio) {
            for (int i = 0; i < this.b; i++) {
                a(this.c[i], this.d[i], epVar);
            }
            return;
        }
        for (int i2 = this.b - 1; i2 >= 0; i2--) {
            a(this.c[i2], this.d[i2], epVar);
        }
    }

    private static void a(int i, Object obj, ep epVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 != 5) {
            switch (i3) {
                case 0:
                    epVar.a(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    epVar.d(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    epVar.a(i2, (zzdp) obj);
                    return;
                case 3:
                    if (epVar.a() == zzey.zzd.zzaio) {
                        epVar.a(i2);
                        ((zzhs) obj).zzb(epVar);
                        epVar.b(i2);
                        return;
                    } else {
                        epVar.b(i2);
                        ((zzhs) obj).zzb(epVar);
                        epVar.a(i2);
                        return;
                    }
                default:
                    throw new RuntimeException(zzfi.f());
            }
        }
        epVar.d(i2, ((Integer) obj).intValue());
    }

    public final int zzws() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            i2 += zzee.zzd(this.c[i3] >>> 3, (zzdp) this.d[i3]);
        }
        this.e = i2;
        return i2;
    }

    public final int zzuk() {
        int zzj;
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            int i4 = this.c[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 5) {
                switch (i6) {
                    case 0:
                        zzj = zzee.zze(i5, ((Long) this.d[i3]).longValue());
                        break;
                    case 1:
                        zzj = zzee.zzg(i5, ((Long) this.d[i3]).longValue());
                        break;
                    case 2:
                        zzj = zzee.zzc(i5, (zzdp) this.d[i3]);
                        break;
                    case 3:
                        zzj = (zzee.zzbi(i5) << 1) + ((zzhs) this.d[i3]).zzuk();
                        break;
                    default:
                        throw new IllegalStateException(zzfi.f());
                }
            } else {
                zzj = zzee.zzj(i5, ((Integer) this.d[i3]).intValue());
            }
            i2 += zzj;
        }
        this.e = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhs)) {
            return false;
        }
        zzhs zzhsVar = (zzhs) obj;
        int i = this.b;
        if (i == zzhsVar.b) {
            int[] iArr = this.c;
            int[] iArr2 = zzhsVar.c;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                }
                if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                Object[] objArr = this.d;
                Object[] objArr2 = zzhsVar.d;
                int i3 = this.b;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    }
                    i4++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b;
        int i2 = (i + 527) * 31;
        int[] iArr = this.c;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.d;
        int i7 = this.b;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            da.a(sb, i, String.valueOf(this.c[i2] >>> 3), this.d[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, Object obj) {
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.b;
        if (i2 == this.c.length) {
            int i3 = this.b + (i2 < 4 ? 8 : i2 >> 1);
            this.c = Arrays.copyOf(this.c, i3);
            this.d = Arrays.copyOf(this.d, i3);
        }
        int[] iArr = this.c;
        int i4 = this.b;
        iArr[i4] = i;
        this.d[i4] = obj;
        this.b = i4 + 1;
    }
}
