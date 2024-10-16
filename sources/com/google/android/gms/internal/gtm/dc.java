package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dc {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f4343a = d();
    private static final dr<?, ?> b = a(false);
    private static final dr<?, ?> c = a(true);
    private static final dr<?, ?> d = new ds();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!zzrc.class.isAssignableFrom(cls) && (cls2 = f4343a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i, List<Double> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.g(i, list, z);
    }

    public static void b(int i, List<Float> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.f(i, list, z);
    }

    public static void c(int i, List<Long> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.c(i, list, z);
    }

    public static void d(int i, List<Long> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.d(i, list, z);
    }

    public static void e(int i, List<Long> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.n(i, list, z);
    }

    public static void f(int i, List<Long> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.e(i, list, z);
    }

    public static void g(int i, List<Long> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.l(i, list, z);
    }

    public static void h(int i, List<Integer> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.j(i, list, z);
    }

    public static void j(int i, List<Integer> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.m(i, list, z);
    }

    public static void k(int i, List<Integer> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.b(i, list, z);
    }

    public static void l(int i, List<Integer> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.k(i, list, z);
    }

    public static void m(int i, List<Integer> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.h(i, list, z);
    }

    public static void n(int i, List<Boolean> list, ed edVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.i(i, list, z);
    }

    public static void a(int i, List<String> list, ed edVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.a(i, list);
    }

    public static void b(int i, List<zzps> list, ed edVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.b(i, list);
    }

    public static void a(int i, List<?> list, ed edVar, da daVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.a(i, list, daVar);
    }

    public static void b(int i, List<?> list, ed edVar, da daVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        edVar.b(i, list, daVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cg) {
            cg cgVar = (cg) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzs(cgVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzs(list.get(i2).longValue());
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
        return a(list) + (list.size() * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cg) {
            cg cgVar = (cg) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzt(cgVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzt(list.get(i2).longValue());
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
        return b(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cg) {
            cg cgVar = (cg) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzu(cgVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzu(list.get(i2).longValue());
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
        return c(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof by) {
            by byVar = (by) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbh(byVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbh(list.get(i2).intValue());
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
        return d(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof by) {
            by byVar = (by) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbc(byVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbc(list.get(i2).intValue());
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
        return e(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof by) {
            by byVar = (by) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbd(byVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbd(list.get(i2).intValue());
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
        return f(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof by) {
            by byVar = (by) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbe(byVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbe(list.get(i2).intValue());
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
        return g(list) + (size * zzqj.zzbb(i));
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
        return size * zzqj.zzl(i, 0);
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
        return size * zzqj.zzg(i, 0L);
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
        return size * zzqj.zzc(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int zzda;
        int zzda2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbb = zzqj.zzbb(i) * size;
        if (list instanceof zzrt) {
            zzrt zzrtVar = (zzrt) list;
            while (i2 < size) {
                Object zzbn = zzrtVar.zzbn(i2);
                if (zzbn instanceof zzps) {
                    zzda2 = zzqj.zzb((zzps) zzbn);
                } else {
                    zzda2 = zzqj.zzda((String) zzbn);
                }
                zzbb += zzda2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzps) {
                    zzda = zzqj.zzb((zzps) obj);
                } else {
                    zzda = zzqj.zzda((String) obj);
                }
                zzbb += zzda;
                i2++;
            }
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, da daVar) {
        if (obj instanceof zzrr) {
            return zzqj.zza(i, (zzrr) obj);
        }
        return zzqj.b(i, (zzsk) obj, daVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, da daVar) {
        int b2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = zzqj.zzbb(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzrr) {
                b2 = zzqj.zza((zzrr) obj);
            } else {
                b2 = zzqj.b((zzsk) obj, daVar);
            }
            zzbb += b2;
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzps> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = size * zzqj.zzbb(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbb += zzqj.zzb(list.get(i2));
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzsk> list, da daVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzqj.c(i, list.get(i3), daVar);
        }
        return i2;
    }

    public static dr<?, ?> a() {
        return b;
    }

    public static dr<?, ?> b() {
        return c;
    }

    public static dr<?, ?> c() {
        return d;
    }

    private static dr<?, ?> a(boolean z) {
        try {
            Class<?> e = e();
            if (e == null) {
                return null;
            }
            return (dr) e.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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
    public static <T> void a(cl clVar, T t, T t2, long j) {
        dv.a(t, j, clVar.a(dv.f(t, j), dv.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzqv<FT>> void a(bp<FT> bpVar, T t, T t2) {
        bs<FT> a2 = bpVar.a(t2);
        if (a2.f4320a.isEmpty()) {
            return;
        }
        bpVar.b(t).a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(dr<UT, UB> drVar, T t, T t2) {
        drVar.a(t, drVar.c(drVar.b(t), drVar.b(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzrh zzrhVar, UB ub, dr<UT, UB> drVar) {
        UB ub2;
        if (zzrhVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzrhVar.zzb(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue, ub2, drVar);
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
                if (!zzrhVar.zzb(intValue2)) {
                    Object a2 = a(i, intValue2, ub2, drVar);
                    it.remove();
                    ub2 = (UB) a2;
                }
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, dr<UT, UB> drVar) {
        if (ub == null) {
            ub = drVar.a();
        }
        drVar.a((dr<UT, UB>) ub, i, i2);
        return ub;
    }
}
