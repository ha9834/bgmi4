package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhh;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class bv implements eo {

    /* renamed from: a, reason: collision with root package name */
    private final zzgo f4049a;

    public static bv a(zzgo zzgoVar) {
        if (zzgoVar.f4176a != null) {
            return zzgoVar.f4176a;
        }
        return new bv(zzgoVar);
    }

    private bv(zzgo zzgoVar) {
        this.f4049a = (zzgo) zzhi.a(zzgoVar, "output");
        this.f4049a.f4176a = this;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final int a() {
        return zzhh.zzd.zztv;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, int i2) throws IOException {
        this.f4049a.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, long j) throws IOException {
        this.f4049a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void b(int i, long j) throws IOException {
        this.f4049a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, float f) throws IOException {
        this.f4049a.zza(i, f);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, double d) throws IOException {
        this.f4049a.zza(i, d);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void b(int i, int i2) throws IOException {
        this.f4049a.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void c(int i, long j) throws IOException {
        this.f4049a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void c(int i, int i2) throws IOException {
        this.f4049a.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void d(int i, long j) throws IOException {
        this.f4049a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void d(int i, int i2) throws IOException {
        this.f4049a.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, boolean z) throws IOException {
        this.f4049a.zzc(i, z);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, String str) throws IOException {
        this.f4049a.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, zzfx zzfxVar) throws IOException {
        this.f4049a.zza(i, zzfxVar);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void e(int i, int i2) throws IOException {
        this.f4049a.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void f(int i, int i2) throws IOException {
        this.f4049a.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void e(int i, long j) throws IOException {
        this.f4049a.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, Object obj, dm dmVar) throws IOException {
        this.f4049a.a(i, (zzim) obj, dmVar);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void b(int i, Object obj, dm dmVar) throws IOException {
        zzgo zzgoVar = this.f4049a;
        zzgoVar.zzc(i, 3);
        dmVar.a((dm) obj, (eo) zzgoVar.f4176a);
        zzgoVar.zzc(i, 4);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i) throws IOException {
        this.f4049a.zzc(i, 3);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void b(int i) throws IOException {
        this.f4049a.zzc(i, 4);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, Object obj) throws IOException {
        if (obj instanceof zzfx) {
            this.f4049a.zzb(i, (zzfx) obj);
        } else {
            this.f4049a.zza(i, (zzim) obj);
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzar(list.get(i4).intValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzam(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void b(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzau(list.get(i4).intValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzap(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void c(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzk(list.get(i4).longValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzl(list.get(i4).longValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void e(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzn(list.get(i4).longValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void f(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzc(list.get(i4).floatValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzb(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void g(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzd(list.get(i4).doubleValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzc(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void h(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzaw(list.get(i4).intValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzam(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void i(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzf(list.get(i4).booleanValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zze(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zzc(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzhx) {
            zzhx zzhxVar = (zzhx) list;
            while (i2 < list.size()) {
                Object zzbd = zzhxVar.zzbd(i2);
                if (zzbd instanceof String) {
                    this.f4049a.zzb(i, (String) zzbd);
                } else {
                    this.f4049a.zza(i, (zzfx) zzbd);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zzb(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void b(int i, List<zzfx> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f4049a.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzas(list.get(i4).intValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzan(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void k(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzav(list.get(i4).intValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzap(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzo(list.get(i4).longValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void m(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzat(list.get(i4).intValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzao(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void n(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f4049a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgo.zzm(list.get(i4).longValue());
            }
            this.f4049a.zzan(i3);
            while (i2 < list.size()) {
                this.f4049a.zzi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4049a.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void a(int i, List<?> list, dm dmVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), dmVar);
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final void b(int i, List<?> list, dm dmVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), dmVar);
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.eo
    public final <K, V> void a(int i, ct<K, V> ctVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f4049a.zzc(i, 2);
            this.f4049a.zzan(zzie.a(ctVar, entry.getKey(), entry.getValue()));
            zzie.a(this.f4049a, ctVar, entry.getKey(), entry.getValue());
        }
    }
}
