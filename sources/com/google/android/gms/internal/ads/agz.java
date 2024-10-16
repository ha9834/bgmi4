package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class agz {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f1872a = d();
    private static final aho<?, ?> b = a(false);
    private static final aho<?, ?> c = a(true);
    private static final aho<?, ?> d = new ahp();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!zzdob.class.isAssignableFrom(cls) && (cls2 = f1872a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i, List<Double> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.g(i, list, z);
    }

    public static void b(int i, List<Float> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.f(i, list, z);
    }

    public static void c(int i, List<Long> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.c(i, list, z);
    }

    public static void d(int i, List<Long> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.d(i, list, z);
    }

    public static void e(int i, List<Long> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.n(i, list, z);
    }

    public static void f(int i, List<Long> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.e(i, list, z);
    }

    public static void g(int i, List<Long> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.l(i, list, z);
    }

    public static void h(int i, List<Integer> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.j(i, list, z);
    }

    public static void j(int i, List<Integer> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.m(i, list, z);
    }

    public static void k(int i, List<Integer> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.b(i, list, z);
    }

    public static void l(int i, List<Integer> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.k(i, list, z);
    }

    public static void m(int i, List<Integer> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.h(i, list, z);
    }

    public static void n(int i, List<Boolean> list, aib aibVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.i(i, list, z);
    }

    public static void a(int i, List<String> list, aib aibVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.a(i, list);
    }

    public static void b(int i, List<zzdmr> list, aib aibVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.b(i, list);
    }

    public static void a(int i, List<?> list, aib aibVar, agx agxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.a(i, list, agxVar);
    }

    public static void b(int i, List<?> list, aib aibVar, agx agxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        aibVar.b(i, list, agxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof afz) {
            afz afzVar = (afz) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzfm(afzVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdni.zzfm(list.get(i2).longValue());
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
        return a(list) + (list.size() * zzdni.zzgd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof afz) {
            afz afzVar = (afz) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzfn(afzVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdni.zzfn(list.get(i2).longValue());
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
        return b(list) + (size * zzdni.zzgd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof afz) {
            afz afzVar = (afz) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzfo(afzVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdni.zzfo(list.get(i2).longValue());
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
        return c(list) + (size * zzdni.zzgd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof afr) {
            afr afrVar = (afr) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzgj(afrVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdni.zzgj(list.get(i2).intValue());
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
        return d(list) + (size * zzdni.zzgd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof afr) {
            afr afrVar = (afr) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzge(afrVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdni.zzge(list.get(i2).intValue());
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
        return e(list) + (size * zzdni.zzgd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof afr) {
            afr afrVar = (afr) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzgf(afrVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdni.zzgf(list.get(i2).intValue());
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
        return f(list) + (size * zzdni.zzgd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof afr) {
            afr afrVar = (afr) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzgg(afrVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdni.zzgg(list.get(i2).intValue());
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
        return g(list) + (size * zzdni.zzgd(i));
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
        return size * zzdni.zzae(i, 0);
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
        return size * zzdni.zzn(i, 0L);
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
        return size * zzdni.zzj(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int zzgx;
        int zzgx2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzgd = zzdni.zzgd(i) * size;
        if (list instanceof zzdot) {
            zzdot zzdotVar = (zzdot) list;
            while (i2 < size) {
                Object zzgq = zzdotVar.zzgq(i2);
                if (zzgq instanceof zzdmr) {
                    zzgx2 = zzdni.zzda((zzdmr) zzgq);
                } else {
                    zzgx2 = zzdni.zzgx((String) zzgq);
                }
                zzgd += zzgx2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzdmr) {
                    zzgx = zzdni.zzda((zzdmr) obj);
                } else {
                    zzgx = zzdni.zzgx((String) obj);
                }
                zzgd += zzgx;
                i2++;
            }
        }
        return zzgd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, agx agxVar) {
        if (obj instanceof zzdor) {
            return zzdni.zza(i, (zzdor) obj);
        }
        return zzdni.b(i, (zzdpk) obj, agxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, agx agxVar) {
        int b2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgd = zzdni.zzgd(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzdor) {
                b2 = zzdni.zza((zzdor) obj);
            } else {
                b2 = zzdni.b((zzdpk) obj, agxVar);
            }
            zzgd += b2;
        }
        return zzgd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzdmr> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgd = size * zzdni.zzgd(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzgd += zzdni.zzda(list.get(i2));
        }
        return zzgd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzdpk> list, agx agxVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzdni.c(i, list.get(i3), agxVar);
        }
        return i2;
    }

    public static aho<?, ?> a() {
        return b;
    }

    public static aho<?, ?> b() {
        return c;
    }

    public static aho<?, ?> c() {
        return d;
    }

    private static aho<?, ?> a(boolean z) {
        try {
            Class<?> e = e();
            if (e == null) {
                return null;
            }
            return (aho) e.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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
    public static <T> void a(agf agfVar, T t, T t2, long j) {
        ahs.a(t, j, agfVar.a(ahs.f(t, j), ahs.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzdnu<FT>> void a(afh<FT> afhVar, T t, T t2) {
        afk<FT> a2 = afhVar.a(t2);
        if (a2.b()) {
            return;
        }
        afhVar.b(t).a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(aho<UT, UB> ahoVar, T t, T t2) {
        ahoVar.a(t, ahoVar.c(ahoVar.b(t), ahoVar.b(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzdog zzdogVar, UB ub, aho<UT, UB> ahoVar) {
        UB ub2;
        if (zzdogVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzdogVar.zzf(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue, ub2, ahoVar);
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
                if (!zzdogVar.zzf(intValue2)) {
                    Object a2 = a(i, intValue2, ub2, ahoVar);
                    it.remove();
                    ub2 = (UB) a2;
                }
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, aho<UT, UB> ahoVar) {
        if (ub == null) {
            ub = ahoVar.a();
        }
        ahoVar.a((aho<UT, UB>) ub, i, i2);
        return ub;
    }
}
