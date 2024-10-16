package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.FieldSet;
import com.uqm.crashsight.protobuf.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class aq {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f6794a = d();
    private static final at<?, ?> b = a(false);
    private static final at<?, ?> c = a(true);
    private static final at<?, ?> d = new au();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f6794a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i, List<Double> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.g(i, list, z);
    }

    public static void b(int i, List<Float> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.f(i, list, z);
    }

    public static void c(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.c(i, list, z);
    }

    public static void d(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.d(i, list, z);
    }

    public static void e(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.n(i, list, z);
    }

    public static void f(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.e(i, list, z);
    }

    public static void g(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.l(i, list, z);
    }

    public static void h(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.j(i, list, z);
    }

    public static void j(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.m(i, list, z);
    }

    public static void k(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.b(i, list, z);
    }

    public static void l(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.k(i, list, z);
    }

    public static void m(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.h(i, list, z);
    }

    public static void n(int i, List<Boolean> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.i(i, list, z);
    }

    public static void a(int i, List<String> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.a(i, list);
    }

    public static void b(int i, List<ByteString> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.b(i, list);
    }

    public static void c(int i, List<?> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.c(i, list);
    }

    public static void a(int i, List<?> list, Writer writer, ao aoVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.a(i, list, aoVar);
    }

    public static void d(int i, List<?> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.d(i, list);
    }

    public static void b(int i, List<?> list, Writer writer, ao aoVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.b(i, list, aoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof s) {
            s sVar = (s) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.f(sVar.b(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.f(list.get(i2).longValue());
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
        return a(list) + (list.size() * CodedOutputStream.h(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof s) {
            s sVar = (s) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.g(sVar.b(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.g(list.get(i2).longValue());
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
        return b(list) + (size * CodedOutputStream.h(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof s) {
            s sVar = (s) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.h(sVar.b(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.h(list.get(i2).longValue());
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
        return c(list) + (size * CodedOutputStream.h(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof q) {
            q qVar = (q) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.l(qVar.b(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.l(list.get(i2).intValue());
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
        return d(list) + (size * CodedOutputStream.h(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof q) {
            q qVar = (q) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.i(qVar.b(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.i(list.get(i2).intValue());
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
        return e(list) + (size * CodedOutputStream.h(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof q) {
            q qVar = (q) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.j(qVar.b(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.j(list.get(i2).intValue());
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
        return f(list) + (size * CodedOutputStream.h(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof q) {
            q qVar = (q) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.k(qVar.b(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.k(list.get(i2).intValue());
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
        return g(list) + (size * CodedOutputStream.h(i));
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
        return size * CodedOutputStream.k(i, 0);
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
        return size * CodedOutputStream.i(i, 0L);
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
        return size * CodedOutputStream.b(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int b2;
        int b3;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int h = CodedOutputStream.h(i) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i2 < size) {
                Object b4 = lazyStringList.b(i2);
                if (b4 instanceof ByteString) {
                    b3 = CodedOutputStream.b((ByteString) b4);
                } else {
                    b3 = CodedOutputStream.b((String) b4);
                }
                h += b3;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof ByteString) {
                    b2 = CodedOutputStream.b((ByteString) obj);
                } else {
                    b2 = CodedOutputStream.b((String) obj);
                }
                h += b2;
                i2++;
            }
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, ao aoVar) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.a(i, (LazyFieldLite) obj);
        }
        return CodedOutputStream.b(i, (MessageLite) obj, aoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, ao aoVar) {
        int a2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int h = CodedOutputStream.h(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof LazyFieldLite) {
                a2 = CodedOutputStream.a((LazyFieldLite) obj);
            } else {
                a2 = CodedOutputStream.a((MessageLite) obj, aoVar);
            }
            h += a2;
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int h = size * CodedOutputStream.h(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            h += CodedOutputStream.b(list.get(i2));
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<MessageLite> list, ao aoVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += CodedOutputStream.d(i, list.get(i3), aoVar);
        }
        return i2;
    }

    public static at<?, ?> a() {
        return b;
    }

    public static at<?, ?> b() {
        return c;
    }

    public static at<?, ?> c() {
        return d;
    }

    private static at<?, ?> a(boolean z) {
        try {
            Class<?> e = e();
            if (e == null) {
                return null;
            }
            return (at) e.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.uqm.crashsight.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.uqm.crashsight.protobuf.av");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Class<?> cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + a(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length != 1) {
                throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
            }
            return aw.b(declaredFields[0]);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static String a(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        boolean z2 = z;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ('a' <= charAt && charAt <= 'z') {
                if (z2) {
                    sb.append((char) (charAt - ' '));
                } else {
                    sb.append(charAt);
                }
                z2 = false;
            } else if ('A' > charAt || charAt > 'Z') {
                if ('0' <= charAt && charAt <= '9') {
                    sb.append(charAt);
                }
                z2 = true;
            } else {
                if (i == 0 && !z2) {
                    sb.append((char) (charAt + ' '));
                } else {
                    sb.append(charAt);
                }
                z2 = false;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(u uVar, T t, T t2, long j) {
        aw.a(t, j, uVar.a(aw.f(t, j), aw.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void a(k<FT> kVar, T t, T t2) {
        FieldSet<FT> a2 = kVar.a(t2);
        if (a2.d()) {
            return;
        }
        kVar.b(t).a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(at<UT, UB> atVar, T t, T t2) {
        atVar.a(t, atVar.c(atVar.b(t), atVar.b(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, at<UT, UB> atVar) {
        UB ub2;
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (enumLiteMap.a(intValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    if (ub2 == null) {
                        ub2 = atVar.a();
                    }
                    atVar.a((at<UT, UB>) ub2, i, intValue);
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
                if (enumLiteMap.a(intValue2) == null) {
                    if (ub2 == null) {
                        ub2 = atVar.a();
                    }
                    atVar.a((at<UT, UB>) ub2, i, intValue2);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, at<UT, UB> atVar) {
        UB ub2;
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (enumVerifier.a(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    if (ub2 == null) {
                        ub2 = atVar.a();
                    }
                    atVar.a((at<UT, UB>) ub2, i, intValue);
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
                if (!enumVerifier.a(intValue2)) {
                    if (ub2 == null) {
                        ub2 = atVar.a();
                    }
                    atVar.a((at<UT, UB>) ub2, i, intValue2);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, at<UT, UB> atVar) {
        if (ub == null) {
            ub = atVar.a();
        }
        atVar.a((at<UT, UB>) ub, i, i2);
        return ub;
    }
}
