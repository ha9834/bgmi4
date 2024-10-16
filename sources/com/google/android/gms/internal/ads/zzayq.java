package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzayq {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f2830a;
    private final double[] b;
    private final double[] c;
    private final int[] d;
    private int e;

    private zzayq(zzayt zzaytVar) {
        List list;
        List list2;
        List list3;
        List list4;
        list = zzaytVar.b;
        int size = list.size();
        list2 = zzaytVar.f2832a;
        this.f2830a = (String[]) list2.toArray(new String[size]);
        list3 = zzaytVar.b;
        this.b = a(list3);
        list4 = zzaytVar.c;
        this.c = a(list4);
        this.d = new int[size];
        this.e = 0;
    }

    private static double[] a(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d) {
        this.e++;
        int i = 0;
        while (true) {
            double[] dArr = this.c;
            if (i >= dArr.length) {
                return;
            }
            if (dArr[i] <= d && d < this.b[i]) {
                int[] iArr = this.d;
                iArr[i] = iArr[i] + 1;
            }
            if (d < this.c[i]) {
                return;
            } else {
                i++;
            }
        }
    }

    public final List<zzays> zzwp() {
        ArrayList arrayList = new ArrayList(this.f2830a.length);
        int i = 0;
        while (true) {
            String[] strArr = this.f2830a;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.c[i];
            double d2 = this.b[i];
            int[] iArr = this.d;
            double d3 = iArr[i];
            double d4 = this.e;
            Double.isNaN(d3);
            Double.isNaN(d4);
            arrayList.add(new zzays(str, d, d2, d3 / d4, iArr[i]));
            i++;
        }
    }
}
