package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* loaded from: classes2.dex */
final class anm implements zzqj, zzqk {

    /* renamed from: a, reason: collision with root package name */
    public final zzqj[] f1988a;
    private final IdentityHashMap<zzqw, Integer> b = new IdentityHashMap<>();
    private zzqk c;
    private int d;
    private zzrb e;
    private zzqj[] f;
    private zzqx g;

    public anm(zzqj... zzqjVarArr) {
        this.f1988a = zzqjVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void zza(zzqk zzqkVar, long j) {
        this.c = zzqkVar;
        zzqj[] zzqjVarArr = this.f1988a;
        this.d = zzqjVarArr.length;
        for (zzqj zzqjVar : zzqjVarArr) {
            zzqjVar.zza(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void zziy() throws IOException {
        for (zzqj zzqjVar : this.f1988a) {
            zzqjVar.zziy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final zzrb zziz() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long zza(zzrm[] zzrmVarArr, boolean[] zArr, zzqw[] zzqwVarArr, boolean[] zArr2, long j) {
        int[] iArr = new int[zzrmVarArr.length];
        int[] iArr2 = new int[zzrmVarArr.length];
        for (int i = 0; i < zzrmVarArr.length; i++) {
            iArr[i] = zzqwVarArr[i] == null ? -1 : this.b.get(zzqwVarArr[i]).intValue();
            iArr2[i] = -1;
            if (zzrmVarArr[i] != null) {
                zzra zzjr = zzrmVarArr[i].zzjr();
                int i2 = 0;
                while (true) {
                    zzqj[] zzqjVarArr = this.f1988a;
                    if (i2 >= zzqjVarArr.length) {
                        break;
                    }
                    if (zzqjVarArr[i2].zziz().zza(zzjr) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.b.clear();
        zzqw[] zzqwVarArr2 = new zzqw[zzrmVarArr.length];
        zzqw[] zzqwVarArr3 = new zzqw[zzrmVarArr.length];
        zzrm[] zzrmVarArr2 = new zzrm[zzrmVarArr.length];
        ArrayList arrayList = new ArrayList(this.f1988a.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.f1988a.length) {
            for (int i4 = 0; i4 < zzrmVarArr.length; i4++) {
                zzrm zzrmVar = null;
                zzqwVarArr3[i4] = iArr[i4] == i3 ? zzqwVarArr[i4] : null;
                if (iArr2[i4] == i3) {
                    zzrmVar = zzrmVarArr[i4];
                }
                zzrmVarArr2[i4] = zzrmVar;
            }
            zzrm[] zzrmVarArr3 = zzrmVarArr2;
            ArrayList arrayList2 = arrayList;
            zzrm[] zzrmVarArr4 = zzrmVarArr2;
            int i5 = i3;
            long zza = this.f1988a[i3].zza(zzrmVarArr3, zArr, zzqwVarArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzrmVarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    zzsk.checkState(zzqwVarArr3[i6] != null);
                    zzqwVarArr2[i6] = zzqwVarArr3[i6];
                    this.b.put(zzqwVarArr3[i6], Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    zzsk.checkState(zzqwVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(this.f1988a[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            zzrmVarArr2 = zzrmVarArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzqwVarArr2, 0, zzqwVarArr, 0, zzqwVarArr2.length);
        this.f = new zzqj[arrayList3.size()];
        arrayList3.toArray(this.f);
        this.g = new zzpy(this.f);
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void zzem(long j) {
        for (zzqj zzqjVar : this.f) {
            zzqjVar.zzem(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqj, com.google.android.gms.internal.ads.zzqx
    public final boolean zzel(long j) {
        return this.g.zzel(j);
    }

    @Override // com.google.android.gms.internal.ads.zzqj, com.google.android.gms.internal.ads.zzqx
    public final long zzix() {
        return this.g.zzix();
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long zzja() {
        long zzja = this.f1988a[0].zzja();
        int i = 1;
        while (true) {
            zzqj[] zzqjVarArr = this.f1988a;
            if (i >= zzqjVarArr.length) {
                if (zzja != -9223372036854775807L) {
                    for (zzqj zzqjVar : this.f) {
                        if (zzqjVar != this.f1988a[0] && zzqjVar.zzen(zzja) != zzja) {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzja;
            }
            if (zzqjVarArr[i].zzja() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long zzdu() {
        long j = Long.MAX_VALUE;
        for (zzqj zzqjVar : this.f) {
            long zzdu = zzqjVar.zzdu();
            if (zzdu != Long.MIN_VALUE) {
                j = Math.min(j, zzdu);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long zzen(long j) {
        long zzen = this.f[0].zzen(j);
        int i = 1;
        while (true) {
            zzqj[] zzqjVarArr = this.f;
            if (i >= zzqjVarArr.length) {
                return zzen;
            }
            if (zzqjVarArr[i].zzen(zzen) != zzen) {
                throw new IllegalStateException("Children seeked to different positions");
            }
            i++;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zza(zzqj zzqjVar) {
        int i = this.d - 1;
        this.d = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (zzqj zzqjVar2 : this.f1988a) {
            i2 += zzqjVar2.zziz().length;
        }
        zzra[] zzraVarArr = new zzra[i2];
        zzqj[] zzqjVarArr = this.f1988a;
        int length = zzqjVarArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            zzrb zziz = zzqjVarArr[i3].zziz();
            int i5 = zziz.length;
            int i6 = i4;
            int i7 = 0;
            while (i7 < i5) {
                zzraVarArr[i6] = zziz.zzbg(i7);
                i7++;
                i6++;
            }
            i3++;
            i4 = i6;
        }
        this.e = new zzrb(zzraVarArr);
        this.c.zza((zzqj) this);
    }

    @Override // com.google.android.gms.internal.ads.zzqy
    public final /* synthetic */ void zza(zzqj zzqjVar) {
        if (this.e != null) {
            this.c.zza((zzqk) this);
        }
    }
}
