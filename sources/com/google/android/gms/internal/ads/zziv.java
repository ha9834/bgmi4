package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes2.dex */
public final class zziv implements zzid, zzio {
    private long f;
    private int g;
    private long h;
    private int i;
    private zzkm j;
    private int k;
    private int l;
    private int m;
    private zzif n;
    private akf[] o;
    private final zzkm c = new zzkm(16);
    private final Stack<zzir> d = new Stack<>();

    /* renamed from: a, reason: collision with root package name */
    private final zzkm f3657a = new zzkm(zzkj.zzaqt);
    private final zzkm b = new zzkm(4);
    private int e = 0;

    @Override // com.google.android.gms.internal.ads.zzio
    public final boolean zzfc() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final void zza(zzif zzifVar) {
        this.n = zzifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final void zzfh() {
        this.f = 0L;
        this.l = 0;
        this.m = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final int zza(zzie zzieVar, zzij zzijVar) throws IOException, InterruptedException {
        boolean z;
        zzir zzirVar;
        int i;
        zziv zzivVar;
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long zzgh;
        zzkm zzkmVar;
        zzkm zzkmVar2;
        int i9;
        int i10;
        int i11;
        int i12;
        zzij zzijVar2;
        zziv zzivVar2 = this;
        zzie zzieVar2 = zzieVar;
        while (true) {
            switch (zzivVar2.e) {
                case 0:
                    zziv zzivVar3 = zzivVar2;
                    boolean z2 = false;
                    if (zzieVar.zza(zzivVar3.c.data, 0, 8, true)) {
                        zzivVar3.c.setPosition(0);
                        zzivVar3.h = zzivVar3.c.zzge();
                        zzivVar3.g = zzivVar3.c.readInt();
                        if (zzivVar3.h == 1) {
                            zzieVar.readFully(zzivVar3.c.data, 8, 8);
                            zzivVar3.h = zzivVar3.c.readLong();
                            zzivVar3.f += 16;
                            zzivVar3.i = 16;
                        } else {
                            zzivVar3.f += 8;
                            zzivVar3.i = 8;
                        }
                        int i13 = zzivVar3.g;
                        if (i13 == akc.zzako || i13 == akc.zzakq || i13 == akc.zzakr || i13 == akc.zzaks || i13 == akc.zzakt) {
                            long j = zzivVar3.h;
                            if (j == 1) {
                                zzivVar3.d.add(new zzir(zzivVar3.g, (zzivVar3.f + j) - zzivVar3.i));
                                i11 = 0;
                            } else {
                                zzivVar3.d.add(new zzir(zzivVar3.g, (zzivVar3.f + j) - zzivVar3.i));
                                i11 = 0;
                            }
                            zzivVar3.e = i11;
                        } else {
                            int i14 = zzivVar3.g;
                            if (i14 == akc.zzakz || i14 == akc.zzakp || i14 == akc.zzala || i14 == akc.zzalp || i14 == akc.zzalq || i14 == akc.zzalb || i14 == akc.zzaka || i14 == akc.zzaku || i14 == akc.zzake || i14 == akc.zzakc || i14 == akc.zzals || i14 == akc.zzalt || i14 == akc.zzalu || i14 == akc.zzalv || i14 == akc.zzalw || i14 == akc.zzalx || i14 == akc.zzaly || i14 == akc.zzaky) {
                                zzkh.checkState(zzivVar3.h < 2147483647L);
                                zzivVar3.j = new zzkm((int) zzivVar3.h);
                                System.arraycopy(zzivVar3.c.data, 0, zzivVar3.j.data, 0, 8);
                                zzivVar3.e = 1;
                            } else {
                                zzivVar3.j = null;
                                zzivVar3.e = 1;
                            }
                        }
                        z2 = true;
                    }
                    if (!z2) {
                        return -1;
                    }
                    zzivVar2 = zzivVar3;
                    zzieVar2 = zzieVar;
                    break;
                case 1:
                    zzivVar2.e = 0;
                    long j2 = zzivVar2.f;
                    long j3 = zzivVar2.h;
                    int i15 = zzivVar2.i;
                    zzivVar2.f = j2 + (j3 - i15);
                    long j4 = j3 - i15;
                    boolean z3 = zzivVar2.j == null && (j3 >= 262144 || j3 > 2147483647L);
                    if (z3) {
                        zzijVar.zzahv = zzivVar2.f;
                    } else {
                        zzkm zzkmVar3 = zzivVar2.j;
                        if (zzkmVar3 != null) {
                            zzieVar2.readFully(zzkmVar3.data, zzivVar2.i, (int) j4);
                            if (!zzivVar2.d.isEmpty()) {
                                zzivVar2.d.peek().zzama.add(new zzis(zzivVar2.g, zzivVar2.j));
                            }
                        } else {
                            zzieVar2.zzr((int) j4);
                        }
                    }
                    while (!zzivVar2.d.isEmpty() && zzivVar2.d.peek().zzalz == zzivVar2.f) {
                        zzir pop = zzivVar2.d.pop();
                        if (pop.type == akc.zzako) {
                            ArrayList arrayList2 = new ArrayList();
                            int i16 = 0;
                            while (i16 < pop.zzamb.size()) {
                                zzir zzirVar2 = pop.zzamb.get(i16);
                                if (zzirVar2.type == akc.zzakq) {
                                    zzix a2 = akd.a(zzirVar2, pop.zzv(akc.zzakp));
                                    if (a2 == null || !(a2.type == 1936684398 || a2.type == 1986618469)) {
                                        z = z3;
                                        zzirVar = pop;
                                        i = i16;
                                        zzivVar = zzivVar2;
                                        arrayList = arrayList2;
                                    } else {
                                        zzir zzw = zzirVar2.zzw(akc.zzakr).zzw(akc.zzaks).zzw(akc.zzakt);
                                        zzkm zzkmVar4 = zzw.zzv(akc.zzalw).zzamc;
                                        zzis zzv = zzw.zzv(akc.zzalx);
                                        if (zzv == null) {
                                            zzv = zzw.zzv(akc.zzaly);
                                        }
                                        zzkm zzkmVar5 = zzv.zzamc;
                                        zzkm zzkmVar6 = zzw.zzv(akc.zzalv).zzamc;
                                        zzkm zzkmVar7 = zzw.zzv(akc.zzals).zzamc;
                                        zzis zzv2 = zzw.zzv(akc.zzalt);
                                        zzkm zzkmVar8 = zzv2 != null ? zzv2.zzamc : null;
                                        zzis zzv3 = zzw.zzv(akc.zzalu);
                                        zzkm zzkmVar9 = zzv3 != null ? zzv3.zzamc : null;
                                        zzkmVar4.setPosition(12);
                                        int zzgg = zzkmVar4.zzgg();
                                        int zzgg2 = zzkmVar4.zzgg();
                                        int[] iArr = new int[zzgg2];
                                        long[] jArr = new long[zzgg2];
                                        z = z3;
                                        long[] jArr2 = new long[zzgg2];
                                        zzirVar = pop;
                                        int[] iArr2 = new int[zzgg2];
                                        ArrayList arrayList3 = arrayList2;
                                        zzkmVar5.setPosition(12);
                                        int i17 = i16;
                                        int zzgg3 = zzkmVar5.zzgg();
                                        zzkmVar6.setPosition(12);
                                        int zzgg4 = zzkmVar6.zzgg() - 1;
                                        if (!(zzkmVar6.readInt() == 1)) {
                                            throw new IllegalStateException(String.valueOf("stsc first chunk must be 1"));
                                        }
                                        int zzgg5 = zzkmVar6.zzgg();
                                        zzkmVar6.zzac(4);
                                        if (zzgg4 > 0) {
                                            i3 = zzkmVar6.zzgg() - 1;
                                            i2 = 12;
                                        } else {
                                            i2 = 12;
                                            i3 = -1;
                                        }
                                        zzkmVar7.setPosition(i2);
                                        int zzgg6 = zzkmVar7.zzgg() - 1;
                                        int zzgg7 = zzkmVar7.zzgg();
                                        int zzgg8 = zzkmVar7.zzgg();
                                        if (zzkmVar9 != null) {
                                            zzkmVar9.setPosition(i2);
                                            i4 = zzkmVar9.zzgg() - 1;
                                            i5 = zzkmVar9.zzgg();
                                            i6 = zzkmVar9.readInt();
                                        } else {
                                            i4 = 0;
                                            i5 = 0;
                                            i6 = 0;
                                        }
                                        if (zzkmVar8 != null) {
                                            zzkmVar8.setPosition(i2);
                                            int zzgg9 = zzkmVar8.zzgg();
                                            i7 = zzkmVar8.zzgg() - 1;
                                            i8 = zzgg9;
                                        } else {
                                            i7 = -1;
                                            i8 = 0;
                                        }
                                        if (zzv.type == akc.zzalx) {
                                            zzgh = zzkmVar5.zzge();
                                        } else {
                                            zzgh = zzkmVar5.zzgh();
                                        }
                                        int i18 = zzgg5;
                                        int i19 = i3;
                                        int i20 = i6;
                                        int i21 = zzgg4;
                                        int i22 = 0;
                                        int i23 = 0;
                                        zzkm zzkmVar10 = zzkmVar6;
                                        int i24 = i5;
                                        int i25 = i7;
                                        int i26 = zzgg8;
                                        int i27 = i4;
                                        long j5 = 0;
                                        while (i22 < zzgg2) {
                                            jArr2[i22] = zzgh;
                                            iArr[i22] = zzgg == 0 ? zzkmVar4.zzgg() : zzgg;
                                            int[] iArr3 = iArr;
                                            long[] jArr3 = jArr2;
                                            jArr[i22] = j5 + i20;
                                            iArr2[i22] = zzkmVar8 == null ? 1 : 0;
                                            if (i22 == i25) {
                                                iArr2[i22] = 1;
                                                i8--;
                                                if (i8 > 0) {
                                                    i25 = zzkmVar8.zzgg() - 1;
                                                }
                                            }
                                            j5 += i26;
                                            zzgg7--;
                                            if (zzgg7 == 0 && zzgg6 > 0) {
                                                zzgg6--;
                                                zzgg7 = zzkmVar7.zzgg();
                                                i26 = zzkmVar7.zzgg();
                                            }
                                            if (zzkmVar9 != null && i24 - 1 == 0 && i27 > 0) {
                                                i27--;
                                                i24 = zzkmVar9.zzgg();
                                                i20 = zzkmVar9.readInt();
                                            }
                                            zzgg5--;
                                            if (zzgg5 == 0) {
                                                int i28 = i23 + 1;
                                                if (i28 < zzgg3) {
                                                    zzkmVar = zzkmVar8;
                                                    if (zzv.type == akc.zzalx) {
                                                        zzgh = zzkmVar5.zzge();
                                                        i9 = i19;
                                                    } else {
                                                        zzgh = zzkmVar5.zzgh();
                                                        i9 = i19;
                                                    }
                                                } else {
                                                    zzkmVar = zzkmVar8;
                                                    i9 = i19;
                                                }
                                                if (i28 == i9) {
                                                    i18 = zzkmVar10.zzgg();
                                                    zzkmVar2 = zzkmVar10;
                                                    i10 = i9;
                                                    zzkmVar2.zzac(4);
                                                    i21--;
                                                    if (i21 > 0) {
                                                        i10 = zzkmVar2.zzgg() - 1;
                                                    }
                                                } else {
                                                    zzkmVar2 = zzkmVar10;
                                                    i10 = i9;
                                                }
                                                if (i28 < zzgg3) {
                                                    i23 = i28;
                                                    i19 = i10;
                                                    zzgg5 = i18;
                                                } else {
                                                    i23 = i28;
                                                    i19 = i10;
                                                }
                                            } else {
                                                zzkmVar = zzkmVar8;
                                                zzkmVar2 = zzkmVar10;
                                                zzgh += iArr3[i22];
                                            }
                                            i22++;
                                            zzkmVar10 = zzkmVar2;
                                            iArr = iArr3;
                                            jArr2 = jArr3;
                                            zzkmVar8 = zzkmVar;
                                        }
                                        int[] iArr4 = iArr;
                                        long[] jArr4 = jArr2;
                                        zzkq.zza(jArr, 1000000L, a2.zzcs);
                                        zzkh.checkArgument(i8 == 0);
                                        zzkh.checkArgument(zzgg7 == 0);
                                        zzkh.checkArgument(zzgg5 == 0);
                                        zzkh.checkArgument(zzgg6 == 0);
                                        zzkh.checkArgument(i27 == 0);
                                        akg akgVar = new akg(jArr4, iArr4, jArr, iArr2);
                                        if (akgVar.f1931a != 0) {
                                            zzivVar = this;
                                            i = i17;
                                            akf akfVar = new akf(a2, akgVar, zzivVar.n.zzs(i));
                                            akfVar.c.zza(a2.zzame);
                                            arrayList = arrayList3;
                                            arrayList.add(akfVar);
                                        } else {
                                            arrayList = arrayList3;
                                            i = i17;
                                            zzivVar = this;
                                        }
                                    }
                                } else {
                                    z = z3;
                                    zzirVar = pop;
                                    i = i16;
                                    zzivVar = zzivVar2;
                                    arrayList = arrayList2;
                                }
                                i16 = i + 1;
                                arrayList2 = arrayList;
                                zzivVar2 = zzivVar;
                                z3 = z;
                                pop = zzirVar;
                            }
                            boolean z4 = z3;
                            zziv zzivVar4 = zzivVar2;
                            zzivVar4.o = (akf[]) arrayList2.toArray(new akf[0]);
                            zzivVar4.n.zzfi();
                            zzivVar4.n.zza(zzivVar4);
                            zzivVar4.e = 2;
                            zzivVar2 = zzivVar4;
                            z3 = z4;
                        } else {
                            boolean z5 = z3;
                            zziv zzivVar5 = zzivVar2;
                            if (!zzivVar5.d.isEmpty()) {
                                zzivVar5.d.peek().zzamb.add(pop);
                            }
                            zzivVar2 = zzivVar5;
                            z3 = z5;
                        }
                    }
                    boolean z6 = z3;
                    zziv zzivVar6 = zzivVar2;
                    if (!z6) {
                        zzivVar2 = zzivVar6;
                        zzieVar2 = zzieVar;
                        break;
                    } else {
                        return 1;
                    }
                default:
                    zziv zzivVar7 = zzivVar2;
                    zzie zzieVar3 = zzieVar2;
                    long j6 = Long.MAX_VALUE;
                    int i29 = 0;
                    int i30 = -1;
                    while (true) {
                        akf[] akfVarArr = zzivVar7.o;
                        if (i29 >= akfVarArr.length) {
                            if (i30 == -1) {
                                return -1;
                            }
                            akf akfVar2 = akfVarArr[i30];
                            int i31 = akfVar2.d;
                            long j7 = akfVar2.b.b[i31];
                            long position = (j7 - zzieVar.getPosition()) + zzivVar7.l;
                            if (position < 0) {
                                i12 = 1;
                                zzijVar2 = zzijVar;
                            } else {
                                if (position < 262144) {
                                    zzieVar3.zzr((int) position);
                                    zzivVar7.k = akfVar2.b.c[i31];
                                    if (akfVar2.f1930a.zzamf != -1) {
                                        byte[] bArr = zzivVar7.b.data;
                                        bArr[0] = 0;
                                        bArr[1] = 0;
                                        bArr[2] = 0;
                                        int i32 = akfVar2.f1930a.zzamf;
                                        int i33 = 4 - akfVar2.f1930a.zzamf;
                                        while (zzivVar7.l < zzivVar7.k) {
                                            if (zzivVar7.m == 0) {
                                                zzieVar3.readFully(zzivVar7.b.data, i33, i32);
                                                zzivVar7.b.setPosition(0);
                                                zzivVar7.m = zzivVar7.b.zzgg();
                                                zzivVar7.f3657a.setPosition(0);
                                                akfVar2.c.zza(zzivVar7.f3657a, 4);
                                                zzivVar7.l += 4;
                                                zzivVar7.k += i33;
                                            } else {
                                                int zza = akfVar2.c.zza(zzieVar3, zzivVar7.m);
                                                zzivVar7.l += zza;
                                                zzivVar7.m -= zza;
                                            }
                                        }
                                    } else {
                                        while (zzivVar7.l < zzivVar7.k) {
                                            int zza2 = akfVar2.c.zza(zzieVar3, zzivVar7.k - zzivVar7.l);
                                            zzivVar7.l += zza2;
                                            zzivVar7.m -= zza2;
                                        }
                                    }
                                    akfVar2.c.zza(akfVar2.b.d[i31], akfVar2.b.e[i31], zzivVar7.k, 0, null);
                                    akfVar2.d++;
                                    zzivVar7.l = 0;
                                    zzivVar7.m = 0;
                                    return 0;
                                }
                                zzijVar2 = zzijVar;
                                i12 = 1;
                            }
                            zzijVar2.zzahv = j7;
                            return i12;
                        }
                        akf akfVar3 = akfVarArr[i29];
                        int i34 = akfVar3.d;
                        if (i34 != akfVar3.b.f1931a) {
                            long j8 = akfVar3.b.b[i34];
                            if (j8 < j6) {
                                i30 = i29;
                                j6 = j8;
                            }
                        }
                        i29++;
                    }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final long zzdq(long j) {
        long j2 = Long.MAX_VALUE;
        int i = 0;
        while (true) {
            akf[] akfVarArr = this.o;
            if (i >= akfVarArr.length) {
                return j2;
            }
            akg akgVar = akfVarArr[i].b;
            int zza = zzkq.zza(akgVar.d, j, true, false);
            while (true) {
                if (zza < 0) {
                    zza = -1;
                    break;
                }
                if (akgVar.d[zza] <= j && (akgVar.e[zza] & 1) != 0) {
                    break;
                }
                zza--;
            }
            if (zza == -1) {
                zza = zzkq.zzb(akgVar.d, j, true, false);
                while (true) {
                    if (zza >= akgVar.d.length) {
                        zza = -1;
                        break;
                    }
                    if (akgVar.d[zza] >= j && (akgVar.e[zza] & 1) != 0) {
                        break;
                    }
                    zza++;
                }
            }
            this.o[i].d = zza;
            long j3 = akgVar.b[this.o[i].d];
            if (j3 < j2) {
                j2 = j3;
            }
            i++;
        }
    }
}
