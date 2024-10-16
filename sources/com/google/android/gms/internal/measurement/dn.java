package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dn {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f4519a = d();
    private static final ed<?, ?> b = a(false);
    private static final ed<?, ?> c = a(true);
    private static final ed<?, ?> d = new ee();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!zzey.class.isAssignableFrom(cls) && (cls2 = f4519a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i, List<Double> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.g(i, list, z);
    }

    public static void b(int i, List<Float> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.f(i, list, z);
    }

    public static void c(int i, List<Long> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.c(i, list, z);
    }

    public static void d(int i, List<Long> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.d(i, list, z);
    }

    public static void e(int i, List<Long> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.n(i, list, z);
    }

    public static void f(int i, List<Long> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.e(i, list, z);
    }

    public static void g(int i, List<Long> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.l(i, list, z);
    }

    public static void h(int i, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.j(i, list, z);
    }

    public static void j(int i, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.m(i, list, z);
    }

    public static void k(int i, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.b(i, list, z);
    }

    public static void l(int i, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.k(i, list, z);
    }

    public static void m(int i, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.h(i, list, z);
    }

    public static void n(int i, List<Boolean> list, ep epVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.i(i, list, z);
    }

    public static void a(int i, List<String> list, ep epVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.a(i, list);
    }

    public static void b(int i, List<zzdp> list, ep epVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.b(i, list);
    }

    public static void a(int i, List<?> list, ep epVar, dl dlVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.a(i, list, dlVar);
    }

    public static void b(int i, List<?> list, ep epVar, dl dlVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        epVar.b(i, list, dlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cr) {
            cr crVar = (cr) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbq(crVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzbq(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzee.zzbi(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cr) {
            cr crVar = (cr) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbr(crVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzbr(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * zzee.zzbi(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cr) {
            cr crVar = (cr) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbs(crVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzbs(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * zzee.zzbi(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ci) {
            ci ciVar = (ci) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbo(ciVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzbo(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * zzee.zzbi(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ci) {
            ci ciVar = (ci) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbj(ciVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzbj(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * zzee.zzbi(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ci) {
            ci ciVar = (ci) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbk(ciVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzbk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * zzee.zzbi(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ci) {
            ci ciVar = (ci) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbl(ciVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzbl(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * zzee.zzbi(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzee.zzj(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzee.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzee.zzc(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int zzds;
        int zzds2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbi = zzee.zzbi(i) * size;
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            while (i2 < size) {
                Object zzbw = zzfpVar.zzbw(i2);
                if (zzbw instanceof zzdp) {
                    zzds2 = zzee.zzb((zzdp) zzbw);
                } else {
                    zzds2 = zzee.zzds((String) zzbw);
                }
                zzbi += zzds2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzdp) {
                    zzds = zzee.zzb((zzdp) obj);
                } else {
                    zzds = zzee.zzds((String) obj);
                }
                zzbi += zzds;
                i2++;
            }
        }
        return zzbi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, dl dlVar) {
        if (obj instanceof zzfn) {
            return zzee.zza(i, (zzfn) obj);
        }
        return zzee.b(i, (zzgi) obj, dlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, dl dlVar) {
        int b2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbi = zzee.zzbi(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzfn) {
                b2 = zzee.zza((zzfn) obj);
            } else {
                b2 = zzee.b((zzgi) obj, dlVar);
            }
            zzbi += b2;
        }
        return zzbi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzdp> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbi = size * zzee.zzbi(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbi += zzee.zzb(list.get(i2));
        }
        return zzbi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzgi> list, dl dlVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzee.c(i, list.get(i3), dlVar);
        }
        return i2;
    }

    public static ed<?, ?> a() {
        return b;
    }

    public static ed<?, ?> b() {
        return c;
    }

    public static ed<?, ?> c() {
        return d;
    }

    private static ed<?, ?> a(boolean z) {
        try {
            Class<?> e = e();
            if (e == null) {
                return null;
            }
            return (ed) e.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(cv cvVar, T t, T t2, long j) {
        eg.a(t, j, cvVar.a(eg.f(t, j), eg.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzeq<FT>> void a(ca<FT> caVar, T t, T t2) {
        cb<FT> a2 = caVar.a(t2);
        if (a2.f4495a.isEmpty()) {
            return;
        }
        caVar.b(t).a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(ed<UT, UB> edVar, T t, T t2) {
        edVar.a(t, edVar.c(edVar.b(t), edVar.b(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzfe zzfeVar, UB ub, ed<UT, UB> edVar) {
        UB ub2;
        if (zzfeVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzfeVar.zzg(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue, ub2, edVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            ub2 = ub;
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzfeVar.zzg(intValue2)) {
                    Object a2 = a(i, intValue2, ub2, edVar);
                    it.remove();
                    ub2 = (UB) a2;
                }
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, ed<UT, UB> edVar) {
        if (ub == null) {
            ub = edVar.a();
        }
        edVar.a((ed<UT, UB>) ub, i, i2);
        return ub;
    }
}
