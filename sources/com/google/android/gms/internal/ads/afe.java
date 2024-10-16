package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class afe implements aib {

    /* renamed from: a, reason: collision with root package name */
    private final zzdni f1842a;

    public static afe a(zzdni zzdniVar) {
        if (zzdniVar.f3585a != null) {
            return zzdniVar.f3585a;
        }
        return new afe(zzdniVar);
    }

    private afe(zzdni zzdniVar) {
        this.f1842a = (zzdni) zzdod.a(zzdniVar, "output");
        this.f1842a.f3585a = this;
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final int a() {
        return zzdob.zze.zzhhv;
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, int i2) throws IOException {
        this.f1842a.zzaa(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, long j) throws IOException {
        this.f1842a.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void b(int i, long j) throws IOException {
        this.f1842a.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, float f) throws IOException {
        this.f1842a.zza(i, f);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, double d) throws IOException {
        this.f1842a.zzb(i, d);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void b(int i, int i2) throws IOException {
        this.f1842a.zzx(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void c(int i, long j) throws IOException {
        this.f1842a.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void c(int i, int i2) throws IOException {
        this.f1842a.zzx(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void d(int i, long j) throws IOException {
        this.f1842a.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void d(int i, int i2) throws IOException {
        this.f1842a.zzaa(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, boolean z) throws IOException {
        this.f1842a.zzi(i, z);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, String str) throws IOException {
        this.f1842a.zzf(i, str);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, zzdmr zzdmrVar) throws IOException {
        this.f1842a.zza(i, zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void e(int i, int i2) throws IOException {
        this.f1842a.zzy(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void f(int i, int i2) throws IOException {
        this.f1842a.zzz(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void e(int i, long j) throws IOException {
        this.f1842a.zzi(i, j);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, Object obj, agx agxVar) throws IOException {
        this.f1842a.a(i, (zzdpk) obj, agxVar);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void b(int i, Object obj, agx agxVar) throws IOException {
        zzdni zzdniVar = this.f1842a;
        zzdniVar.zzw(i, 3);
        agxVar.a((agx) obj, (aib) zzdniVar.f3585a);
        zzdniVar.zzw(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i) throws IOException {
        this.f1842a.zzw(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void b(int i) throws IOException {
        this.f1842a.zzw(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, Object obj) throws IOException {
        if (obj instanceof zzdmr) {
            this.f1842a.zzb(i, (zzdmr) obj);
        } else {
            this.f1842a.zzb(i, (zzdpk) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzge(list.get(i4).intValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzfz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzx(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void b(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzgh(list.get(i4).intValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzgc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzaa(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void c(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzfm(list.get(i4).longValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzfn(list.get(i4).longValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void e(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzfp(list.get(i4).longValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzfl(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void f(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzh(list.get(i4).floatValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzg(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void g(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzc(list.get(i4).doubleValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void h(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzgj(list.get(i4).intValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzfz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzx(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void i(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzbg(list.get(i4).booleanValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzbf(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzi(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzdot) {
            zzdot zzdotVar = (zzdot) list;
            while (i2 < list.size()) {
                Object zzgq = zzdotVar.zzgq(i2);
                if (zzgq instanceof String) {
                    this.f1842a.zzf(i, (String) zzgq);
                } else {
                    this.f1842a.zza(i, (zzdmr) zzgq);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzf(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void b(int i, List<zzdmr> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f1842a.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzgf(list.get(i4).intValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzga(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzy(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void k(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzgi(list.get(i4).intValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzgc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzaa(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzfq(list.get(i4).longValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzfl(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void m(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzgg(list.get(i4).intValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzgb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzz(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void n(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f1842a.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzfo(list.get(i4).longValue());
            }
            this.f1842a.zzga(i3);
            while (i2 < list.size()) {
                this.f1842a.zzfk(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1842a.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(int i, List<?> list, agx agxVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), agxVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void b(int i, List<?> list, agx agxVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), agxVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final <K, V> void a(int i, age<K, V> ageVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f1842a.zzw(i, 2);
            this.f1842a.zzga(zzdpc.a(ageVar, entry.getKey(), entry.getValue()));
            zzdpc.a(this.f1842a, ageVar, entry.getKey(), entry.getValue());
        }
    }
}
