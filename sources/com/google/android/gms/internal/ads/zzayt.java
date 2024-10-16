package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzayt {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f2832a = new ArrayList();
    private final List<Double> b = new ArrayList();
    private final List<Double> c = new ArrayList();

    public final zzayt zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.f2832a.size()) {
            double doubleValue = this.c.get(i).doubleValue();
            double doubleValue2 = this.b.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.f2832a.add(i, str);
        this.c.add(i, Double.valueOf(d));
        this.b.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzayq zzwq() {
        return new zzayq(this);
    }
}
