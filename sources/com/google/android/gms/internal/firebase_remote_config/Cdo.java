package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase_remote_config.do, reason: invalid class name */
/* loaded from: classes2.dex */
public final class Cdo {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f4079a = d();
    private static final ec<?, ?> b = a(false);
    private static final ec<?, ?> c = a(true);
    private static final ec<?, ?> d = new ed();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!zzhh.class.isAssignableFrom(cls) && (cls2 = f4079a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i, List<Double> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.g(i, list, z);
    }

    public static void b(int i, List<Float> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.f(i, list, z);
    }

    public static void c(int i, List<Long> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.c(i, list, z);
    }

    public static void d(int i, List<Long> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.d(i, list, z);
    }

    public static void e(int i, List<Long> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.n(i, list, z);
    }

    public static void f(int i, List<Long> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.e(i, list, z);
    }

    public static void g(int i, List<Long> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.l(i, list, z);
    }

    public static void h(int i, List<Integer> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.j(i, list, z);
    }

    public static void j(int i, List<Integer> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.m(i, list, z);
    }

    public static void k(int i, List<Integer> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.b(i, list, z);
    }

    public static void l(int i, List<Integer> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.k(i, list, z);
    }

    public static void m(int i, List<Integer> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.h(i, list, z);
    }

    public static void n(int i, List<Boolean> list, eo eoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.i(i, list, z);
    }

    public static void a(int i, List<String> list, eo eoVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.a(i, list);
    }

    public static void b(int i, List<zzfx> list, eo eoVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.b(i, list);
    }

    public static void a(int i, List<?> list, eo eoVar, dm dmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.a(i, list, dmVar);
    }

    public static void b(int i, List<?> list, eo eoVar, dm dmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        eoVar.b(i, list, dmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof co) {
            co coVar = (co) list;
            i = 0;
            while (i2 < size) {
                i += zzgo.zzk(coVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgo.zzk(list.get(i2).longValue());
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
        return a(list) + (list.size() * zzgo.zzaq(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof co) {
            co coVar = (co) list;
            i = 0;
            while (i2 < size) {
                i += zzgo.zzl(coVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgo.zzl(list.get(i2).longValue());
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
        return b(list) + (size * zzgo.zzaq(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof co) {
            co coVar = (co) list;
            i = 0;
            while (i2 < size) {
                i += zzgo.zzm(coVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgo.zzm(list.get(i2).longValue());
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
        return c(list) + (size * zzgo.zzaq(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ch) {
            ch chVar = (ch) list;
            i = 0;
            while (i2 < size) {
                i += zzgo.zzaw(chVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgo.zzaw(list.get(i2).intValue());
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
        return d(list) + (size * zzgo.zzaq(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ch) {
            ch chVar = (ch) list;
            i = 0;
            while (i2 < size) {
                i += zzgo.zzar(chVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgo.zzar(list.get(i2).intValue());
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
        return e(list) + (size * zzgo.zzaq(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ch) {
            ch chVar = (ch) list;
            i = 0;
            while (i2 < size) {
                i += zzgo.zzas(chVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgo.zzas(list.get(i2).intValue());
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
        return f(list) + (size * zzgo.zzaq(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ch) {
            ch chVar = (ch) list;
            i = 0;
            while (i2 < size) {
                i += zzgo.zzat(chVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgo.zzat(list.get(i2).intValue());
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
        return g(list) + (size * zzgo.zzaq(i));
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
        return size * zzgo.zzk(i, 0);
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
        return size * zzgo.zzg(i, 0L);
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
        return size * zzgo.zzd(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int zzbl;
        int zzbl2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzaq = zzgo.zzaq(i) * size;
        if (list instanceof zzhx) {
            zzhx zzhxVar = (zzhx) list;
            while (i2 < size) {
                Object zzbd = zzhxVar.zzbd(i2);
                if (zzbd instanceof zzfx) {
                    zzbl2 = zzgo.zzc((zzfx) zzbd);
                } else {
                    zzbl2 = zzgo.zzbl((String) zzbd);
                }
                zzaq += zzbl2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzfx) {
                    zzbl = zzgo.zzc((zzfx) obj);
                } else {
                    zzbl = zzgo.zzbl((String) obj);
                }
                zzaq += zzbl;
                i2++;
            }
        }
        return zzaq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, dm dmVar) {
        if (obj instanceof zzhv) {
            return zzgo.zza(i, (zzhv) obj);
        }
        return zzgo.b(i, (zzim) obj, dmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, dm dmVar) {
        int a2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzaq = zzgo.zzaq(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzhv) {
                a2 = zzgo.zza((zzhv) obj);
            } else {
                a2 = zzgo.a((zzim) obj, dmVar);
            }
            zzaq += a2;
        }
        return zzaq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzfx> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzaq = size * zzgo.zzaq(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzaq += zzgo.zzc(list.get(i2));
        }
        return zzaq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzim> list, dm dmVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzgo.c(i, list.get(i3), dmVar);
        }
        return i2;
    }

    public static ec<?, ?> a() {
        return b;
    }

    public static ec<?, ?> b() {
        return c;
    }

    public static ec<?, ?> c() {
        return d;
    }

    private static ec<?, ?> a(boolean z) {
        try {
            Class<?> e = e();
            if (e == null) {
                return null;
            }
            return (ec) e.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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
        eh.a(t, j, cvVar.a(eh.f(t, j), eh.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzhc<FT>> void a(by<FT> byVar, T t, T t2) {
        cd<FT> a2 = byVar.a(t2);
        if (a2.f4056a.isEmpty()) {
            return;
        }
        byVar.b(t).a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(ec<UT, UB> ecVar, T t, T t2) {
        ecVar.a(t, ecVar.c(ecVar.b(t), ecVar.b(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzhk zzhkVar, UB ub, ec<UT, UB> ecVar) {
        UB ub2;
        if (zzhkVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzhkVar.zzbc(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue, ub2, ecVar);
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
                if (!zzhkVar.zzbc(intValue2)) {
                    Object a2 = a(i, intValue2, ub2, ecVar);
                    it.remove();
                    ub2 = (UB) a2;
                }
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, ec<UT, UB> ecVar) {
        if (ub == null) {
            ub = ecVar.a();
        }
        ecVar.a((ec<UT, UB>) ub, i, i2);
        return ub;
    }
}
