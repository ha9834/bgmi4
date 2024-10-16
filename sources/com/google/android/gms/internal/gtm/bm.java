package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class bm implements ed {

    /* renamed from: a, reason: collision with root package name */
    private final zzqj f4316a;

    public static bm a(zzqj zzqjVar) {
        if (zzqjVar.f4434a != null) {
            return zzqjVar.f4434a;
        }
        return new bm(zzqjVar);
    }

    private bm(zzqj zzqjVar) {
        this.f4316a = (zzqj) zzre.a(zzqjVar, "output");
        this.f4316a.f4434a = this;
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final int a() {
        return zzrc.zze.zzbbc;
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, int i2) throws IOException {
        this.f4316a.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, long j) throws IOException {
        this.f4316a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void b(int i, long j) throws IOException {
        this.f4316a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, float f) throws IOException {
        this.f4316a.zza(i, f);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, double d) throws IOException {
        this.f4316a.zza(i, d);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void b(int i, int i2) throws IOException {
        this.f4316a.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void c(int i, long j) throws IOException {
        this.f4316a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void c(int i, int i2) throws IOException {
        this.f4316a.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void d(int i, long j) throws IOException {
        this.f4316a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void d(int i, int i2) throws IOException {
        this.f4316a.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, boolean z) throws IOException {
        this.f4316a.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, String str) throws IOException {
        this.f4316a.zza(i, str);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, zzps zzpsVar) throws IOException {
        this.f4316a.zza(i, zzpsVar);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void e(int i, int i2) throws IOException {
        this.f4316a.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void f(int i, int i2) throws IOException {
        this.f4316a.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void e(int i, long j) throws IOException {
        this.f4316a.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, Object obj, da daVar) throws IOException {
        this.f4316a.a(i, (zzsk) obj, daVar);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void b(int i, Object obj, da daVar) throws IOException {
        zzqj zzqjVar = this.f4316a;
        zzqjVar.zzd(i, 3);
        daVar.a((da) obj, (ed) zzqjVar.f4434a);
        zzqjVar.zzd(i, 4);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i) throws IOException {
        this.f4316a.zzd(i, 3);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void b(int i) throws IOException {
        this.f4316a.zzd(i, 4);
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, Object obj) throws IOException {
        if (obj instanceof zzps) {
            this.f4316a.zzb(i, (zzps) obj);
        } else {
            this.f4316a.zzb(i, (zzsk) obj);
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbc(list.get(i4).intValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzax(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void b(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbf(list.get(i4).intValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void c(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzs(list.get(i4).longValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzp(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzt(list.get(i4).longValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzp(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void e(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzv(list.get(i4).longValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzr(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void f(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzb(list.get(i4).floatValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void g(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzc(list.get(i4).doubleValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void h(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbh(list.get(i4).intValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzax(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void i(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzj(list.get(i4).booleanValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzi(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzrt) {
            zzrt zzrtVar = (zzrt) list;
            while (i2 < list.size()) {
                Object zzbn = zzrtVar.zzbn(i2);
                if (zzbn instanceof String) {
                    this.f4316a.zza(i, (String) zzbn);
                } else {
                    this.f4316a.zza(i, (zzps) zzbn);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zza(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void b(int i, List<zzps> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f4316a.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbd(list.get(i4).intValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzay(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void k(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbg(list.get(i4).intValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzw(list.get(i4).longValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzr(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void m(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbe(list.get(i4).intValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void n(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4316a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzu(list.get(i4).longValue());
            }
            this.f4316a.zzay(i3);
            while (i2 < list.size()) {
                this.f4316a.zzq(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4316a.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(int i, List<?> list, da daVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), daVar);
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final void b(int i, List<?> list, da daVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), daVar);
        }
    }

    @Override // com.google.android.gms.internal.gtm.ed
    public final <K, V> void a(int i, ck<K, V> ckVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f4316a.zzd(i, 2);
            this.f4316a.zzay(zzsc.a(ckVar, entry.getKey(), entry.getValue()));
            zzsc.a(this.f4316a, ckVar, entry.getKey(), entry.getValue());
        }
    }
}
