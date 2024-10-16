package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzdqu {

    /* renamed from: a, reason: collision with root package name */
    private static final zzdqu f3598a = new zzdqu(0, new int[0], new Object[0], false);
    private int b;
    private int[] c;
    private Object[] d;
    private int e;
    private boolean f;

    public static zzdqu zzazz() {
        return f3598a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdqu a() {
        return new zzdqu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdqu a(zzdqu zzdquVar, zzdqu zzdquVar2) {
        int i = zzdquVar.b + zzdquVar2.b;
        int[] copyOf = Arrays.copyOf(zzdquVar.c, i);
        System.arraycopy(zzdquVar2.c, 0, copyOf, zzdquVar.b, zzdquVar2.b);
        Object[] copyOf2 = Arrays.copyOf(zzdquVar.d, i);
        System.arraycopy(zzdquVar2.d, 0, copyOf2, zzdquVar.b, zzdquVar2.b);
        return new zzdqu(i, copyOf, copyOf2, true);
    }

    private zzdqu() {
        this(0, new int[8], new Object[8], true);
    }

    private zzdqu(int i, int[] iArr, Object[] objArr, boolean z) {
        this.e = -1;
        this.b = i;
        this.c = iArr;
        this.d = objArr;
        this.f = z;
    }

    public final void zzavj() {
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(aib aibVar) throws IOException {
        if (aibVar.a() == zzdob.zze.zzhhw) {
            for (int i = this.b - 1; i >= 0; i--) {
                aibVar.a(this.c[i] >>> 3, this.d[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            aibVar.a(this.c[i2] >>> 3, this.d[i2]);
        }
    }

    public final void zzb(aib aibVar) throws IOException {
        if (this.b == 0) {
            return;
        }
        if (aibVar.a() == zzdob.zze.zzhhv) {
            for (int i = 0; i < this.b; i++) {
                a(this.c[i], this.d[i], aibVar);
            }
            return;
        }
        for (int i2 = this.b - 1; i2 >= 0; i2--) {
            a(this.c[i2], this.d[i2], aibVar);
        }
    }

    private static void a(int i, Object obj, aib aibVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 != 5) {
            switch (i3) {
                case 0:
                    aibVar.a(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    aibVar.d(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    aibVar.a(i2, (zzdmr) obj);
                    return;
                case 3:
                    if (aibVar.a() == zzdob.zze.zzhhv) {
                        aibVar.a(i2);
                        ((zzdqu) obj).zzb(aibVar);
                        aibVar.b(i2);
                        return;
                    } else {
                        aibVar.b(i2);
                        ((zzdqu) obj).zzb(aibVar);
                        aibVar.a(i2);
                        return;
                    }
                default:
                    throw new RuntimeException(zzdok.f());
            }
        }
        aibVar.d(i2, ((Integer) obj).intValue());
    }

    public final int zzbab() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            i2 += zzdni.zzd(this.c[i3] >>> 3, (zzdmr) this.d[i3]);
        }
        this.e = i2;
        return i2;
    }

    public final int zzaxj() {
        int zzae;
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
                        zzae = zzdni.zzl(i5, ((Long) this.d[i3]).longValue());
                        break;
                    case 1:
                        zzae = zzdni.zzn(i5, ((Long) this.d[i3]).longValue());
                        break;
                    case 2:
                        zzae = zzdni.zzc(i5, (zzdmr) this.d[i3]);
                        break;
                    case 3:
                        zzae = (zzdni.zzgd(i5) << 1) + ((zzdqu) this.d[i3]).zzaxj();
                        break;
                    default:
                        throw new IllegalStateException(zzdok.f());
                }
            } else {
                zzae = zzdni.zzae(i5, ((Integer) this.d[i3]).intValue());
            }
            i2 += zzae;
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
        if (obj == null || !(obj instanceof zzdqu)) {
            return false;
        }
        zzdqu zzdquVar = (zzdqu) obj;
        int i = this.b;
        if (i == zzdquVar.b) {
            int[] iArr = this.c;
            int[] iArr2 = zzdquVar.c;
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
                Object[] objArr2 = zzdquVar.d;
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
            agk.a(sb, i, String.valueOf(this.c[i2] >>> 3), this.d[i2]);
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
