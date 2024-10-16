package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class bx implements ep {

    /* renamed from: a, reason: collision with root package name */
    private final zzee f4493a;

    public static bx a(zzee zzeeVar) {
        if (zzeeVar.f4554a != null) {
            return zzeeVar.f4554a;
        }
        return new bx(zzeeVar);
    }

    private bx(zzee zzeeVar) {
        this.f4493a = (zzee) zzez.a(zzeeVar, "output");
        this.f4493a.f4554a = this;
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final int a() {
        return zzey.zzd.zzaio;
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, int i2) throws IOException {
        this.f4493a.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, long j) throws IOException {
        this.f4493a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void b(int i, long j) throws IOException {
        this.f4493a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, float f) throws IOException {
        this.f4493a.zza(i, f);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, double d) throws IOException {
        this.f4493a.zza(i, d);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void b(int i, int i2) throws IOException {
        this.f4493a.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void c(int i, long j) throws IOException {
        this.f4493a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void c(int i, int i2) throws IOException {
        this.f4493a.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void d(int i, long j) throws IOException {
        this.f4493a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void d(int i, int i2) throws IOException {
        this.f4493a.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, boolean z) throws IOException {
        this.f4493a.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, String str) throws IOException {
        this.f4493a.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, zzdp zzdpVar) throws IOException {
        this.f4493a.zza(i, zzdpVar);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void e(int i, int i2) throws IOException {
        this.f4493a.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void f(int i, int i2) throws IOException {
        this.f4493a.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void e(int i, long j) throws IOException {
        this.f4493a.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, Object obj, dl dlVar) throws IOException {
        this.f4493a.a(i, (zzgi) obj, dlVar);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void b(int i, Object obj, dl dlVar) throws IOException {
        zzee zzeeVar = this.f4493a;
        zzeeVar.zzb(i, 3);
        dlVar.a((dl) obj, (ep) zzeeVar.f4554a);
        zzeeVar.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i) throws IOException {
        this.f4493a.zzb(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void b(int i) throws IOException {
        this.f4493a.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, Object obj) throws IOException {
        if (obj instanceof zzdp) {
            this.f4493a.zzb(i, (zzdp) obj);
        } else {
            this.f4493a.zzb(i, (zzgi) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbj(list.get(i4).intValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbe(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void b(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbm(list.get(i4).intValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbh(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void c(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbq(list.get(i4).longValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbn(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbr(list.get(i4).longValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbn(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void e(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbt(list.get(i4).longValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbp(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void f(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzb(list.get(i4).floatValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void g(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zze(list.get(i4).doubleValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzd(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void h(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbo(list.get(i4).intValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbe(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void i(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzr(list.get(i4).booleanValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzq(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            while (i2 < list.size()) {
                Object zzbw = zzfpVar.zzbw(i2);
                if (zzbw instanceof String) {
                    this.f4493a.zzb(i, (String) zzbw);
                } else {
                    this.f4493a.zza(i, (zzdp) zzbw);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zzb(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void b(int i, List<zzdp> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f4493a.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbk(list.get(i4).intValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbf(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void k(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbn(list.get(i4).intValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbh(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbu(list.get(i4).longValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbp(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void m(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbl(list.get(i4).intValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbg(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void n(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4493a.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzee.zzbs(list.get(i4).longValue());
            }
            this.f4493a.zzbf(i3);
            while (i2 < list.size()) {
                this.f4493a.zzbo(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4493a.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void a(int i, List<?> list, dl dlVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), dlVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final void b(int i, List<?> list, dl dlVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), dlVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.ep
    public final <K, V> void a(int i, cu<K, V> cuVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f4493a.zzb(i, 2);
            this.f4493a.zzbf(zzga.a(cuVar, entry.getKey(), entry.getValue()));
            zzga.a(this.f4493a, cuVar, entry.getKey(), entry.getValue());
        }
    }
}
