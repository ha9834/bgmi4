package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class zzrj extends zzrp {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<Map<zzrb, zzrl>> f3721a = new SparseArray<>();
    private final SparseBooleanArray b = new SparseBooleanArray();
    private int c = 0;
    private zzrk d;

    protected abstract zzrm[] a(zzlp[] zzlpVarArr, zzrb[] zzrbVarArr, int[][][] iArr) throws zzku;

    public final void zzg(int i, boolean z) {
        if (this.b.get(i) == z) {
            return;
        }
        this.b.put(i, z);
        a();
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final zzrr zza(zzlp[] zzlpVarArr, zzrb zzrbVar) throws zzku {
        int[] iArr;
        int[] iArr2 = new int[zzlpVarArr.length + 1];
        zzra[][] zzraVarArr = new zzra[zzlpVarArr.length + 1];
        int[][][] iArr3 = new int[zzlpVarArr.length + 1][];
        for (int i = 0; i < zzraVarArr.length; i++) {
            zzraVarArr[i] = new zzra[zzrbVar.length];
            iArr3[i] = new int[zzrbVar.length];
        }
        int[] iArr4 = new int[zzlpVarArr.length];
        for (int i2 = 0; i2 < iArr4.length; i2++) {
            iArr4[i2] = zzlpVarArr[i2].zzgp();
        }
        for (int i3 = 0; i3 < zzrbVar.length; i3++) {
            zzra zzbg = zzrbVar.zzbg(i3);
            int length = zzlpVarArr.length;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= zzlpVarArr.length) {
                    i4 = length;
                    break;
                }
                zzlp zzlpVar = zzlpVarArr[i4];
                int i6 = length;
                int i7 = i5;
                for (int i8 = 0; i8 < zzbg.length; i8++) {
                    int zza = zzlpVar.zza(zzbg.zzbf(i8)) & 3;
                    if (zza > i7) {
                        if (zza == 3) {
                            break;
                        }
                        i6 = i4;
                        i7 = zza;
                    }
                }
                i4++;
                i5 = i7;
                length = i6;
            }
            if (i4 == zzlpVarArr.length) {
                iArr = new int[zzbg.length];
            } else {
                zzlp zzlpVar2 = zzlpVarArr[i4];
                int[] iArr5 = new int[zzbg.length];
                for (int i9 = 0; i9 < zzbg.length; i9++) {
                    iArr5[i9] = zzlpVar2.zza(zzbg.zzbf(i9));
                }
                iArr = iArr5;
            }
            int i10 = iArr2[i4];
            zzraVarArr[i4][i10] = zzbg;
            iArr3[i4][i10] = iArr;
            iArr2[i4] = iArr2[i4] + 1;
        }
        zzrb[] zzrbVarArr = new zzrb[zzlpVarArr.length];
        int[] iArr6 = new int[zzlpVarArr.length];
        for (int i11 = 0; i11 < zzlpVarArr.length; i11++) {
            int i12 = iArr2[i11];
            zzrbVarArr[i11] = new zzrb((zzra[]) Arrays.copyOf(zzraVarArr[i11], i12));
            iArr3[i11] = (int[][]) Arrays.copyOf(iArr3[i11], i12);
            iArr6[i11] = zzlpVarArr[i11].getTrackType();
        }
        zzrb zzrbVar2 = new zzrb((zzra[]) Arrays.copyOf(zzraVarArr[zzlpVarArr.length], iArr2[zzlpVarArr.length]));
        zzrm[] a2 = a(zzlpVarArr, zzrbVarArr, iArr3);
        int i13 = 0;
        while (true) {
            if (i13 < zzlpVarArr.length) {
                if (this.b.get(i13)) {
                    a2[i13] = null;
                } else {
                    zzrb zzrbVar3 = zzrbVarArr[i13];
                    Map<zzrb, zzrl> map = this.f3721a.get(i13);
                    if ((map != null ? map.get(zzrbVar3) : null) != null) {
                        throw new NoSuchMethodError();
                    }
                }
                i13++;
            } else {
                zzrk zzrkVar = new zzrk(iArr6, zzrbVarArr, iArr4, iArr3, zzrbVar2);
                zzlq[] zzlqVarArr = new zzlq[zzlpVarArr.length];
                for (int i14 = 0; i14 < zzlpVarArr.length; i14++) {
                    zzlqVarArr[i14] = a2[i14] != null ? zzlq.zzauk : null;
                }
                return new zzrr(zzrbVar, new zzro(a2), zzrkVar, zzlqVarArr);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzd(Object obj) {
        this.d = (zzrk) obj;
    }
}
