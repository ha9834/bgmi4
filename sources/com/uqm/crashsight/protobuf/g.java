package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.MapEntryLite;
import com.uqm.crashsight.protobuf.WireFormat;
import com.uqm.crashsight.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g implements Writer {

    /* renamed from: a, reason: collision with root package name */
    private final CodedOutputStream f6814a;

    public static g a(CodedOutputStream codedOutputStream) {
        if (codedOutputStream.f6640a != null) {
            return codedOutputStream.f6640a;
        }
        return new g(codedOutputStream);
    }

    private g(CodedOutputStream codedOutputStream) {
        this.f6814a = (CodedOutputStream) Internal.a(codedOutputStream, "output");
        this.f6814a.f6640a = this;
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final Writer.FieldOrder a() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, int i2) throws IOException {
        this.f6814a.f(i, i2);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, long j) throws IOException {
        this.f6814a.a(i, j);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void b(int i, long j) throws IOException {
        this.f6814a.e(i, j);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, float f) throws IOException {
        this.f6814a.a(i, f);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, double d) throws IOException {
        this.f6814a.a(i, d);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void b(int i, int i2) throws IOException {
        this.f6814a.g(i, i2);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void c(int i, long j) throws IOException {
        this.f6814a.b(i, j);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void c(int i, int i2) throws IOException {
        this.f6814a.b(i, i2);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void d(int i, long j) throws IOException {
        this.f6814a.d(i, j);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void d(int i, int i2) throws IOException {
        this.f6814a.e(i, i2);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, boolean z) throws IOException {
        this.f6814a.a(i, z);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, String str) throws IOException {
        this.f6814a.a(i, str);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, ByteString byteString) throws IOException {
        this.f6814a.a(i, byteString);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void e(int i, int i2) throws IOException {
        this.f6814a.c(i, i2);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void f(int i, int i2) throws IOException {
        this.f6814a.d(i, i2);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void e(int i, long j) throws IOException {
        this.f6814a.c(i, j);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, Object obj) throws IOException {
        this.f6814a.a(i, (MessageLite) obj);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, Object obj, ao aoVar) throws IOException {
        this.f6814a.a(i, (MessageLite) obj, aoVar);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void b(int i, Object obj) throws IOException {
        this.f6814a.e(i, (MessageLite) obj);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void b(int i, Object obj, ao aoVar) throws IOException {
        this.f6814a.c(i, (MessageLite) obj, aoVar);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i) throws IOException {
        this.f6814a.a(i, 3);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void b(int i) throws IOException {
        this.f6814a.a(i, 4);
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void c(int i, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.f6814a.b(i, (ByteString) obj);
        } else {
            this.f6814a.b(i, (MessageLite) obj);
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.i(list.get(i4).intValue());
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.b(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.b(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void b(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).intValue();
                i3 += CodedOutputStream.b();
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.e(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.e(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void c(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.f(list.get(i4).longValue());
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.a(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.a(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.g(list.get(i4).longValue());
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.b(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.b(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void e(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).longValue();
                i3 += CodedOutputStream.d();
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.d(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.d(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void f(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).floatValue();
                i3 += CodedOutputStream.f();
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.a(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.a(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void g(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).doubleValue();
                i3 += CodedOutputStream.g();
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.a(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.a(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void h(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.l(list.get(i4).intValue());
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.g(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.g(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void i(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).booleanValue();
                i3 += CodedOutputStream.h();
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.a(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.a(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i2 < list.size()) {
                Object b = lazyStringList.b(i2);
                if (b instanceof String) {
                    this.f6814a.a(i, (String) b);
                } else {
                    this.f6814a.a(i, (ByteString) b);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.a(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void b(int i, List<ByteString> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f6814a.a(i, list.get(i2));
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.j(list.get(i4).intValue());
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.c(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.c(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void k(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).intValue();
                i3 += CodedOutputStream.c();
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.f(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.f(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).longValue();
                i3 += CodedOutputStream.e();
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.e(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.e(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void m(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.k(list.get(i4).intValue());
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.d(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.d(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void n(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f6814a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.h(list.get(i4).longValue());
            }
            this.f6814a.c(i3);
            while (i2 < list.size()) {
                this.f6814a.c(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f6814a.c(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void c(int i, List<?> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f6814a.a(i, (MessageLite) list.get(i2));
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void a(int i, List<?> list, ao aoVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f6814a.a(i, (MessageLite) list.get(i2), aoVar);
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void d(int i, List<?> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f6814a.e(i, (MessageLite) list.get(i2));
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final void b(int i, List<?> list, ao aoVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f6814a.c(i, (MessageLite) list.get(i2), aoVar);
        }
    }

    @Override // com.uqm.crashsight.protobuf.Writer
    public final <K, V> void a(int i, MapEntryLite.a<K, V> aVar, Map<K, V> map) throws IOException {
        if (!this.f6814a.a()) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                this.f6814a.a(i, 2);
                this.f6814a.c(MapEntryLite.a(aVar, entry.getKey(), entry.getValue()));
                MapEntryLite.a(this.f6814a, aVar, entry.getKey(), entry.getValue());
            }
            return;
        }
        int i2 = 0;
        switch (AnonymousClass1.f6815a[aVar.c.ordinal()]) {
            case 1:
                V v = map.get(Boolean.FALSE);
                if (v != null) {
                    a(i, false, v, aVar);
                }
                V v2 = map.get(Boolean.TRUE);
                if (v2 != null) {
                    a(i, true, v2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                int[] iArr = new int[map.size()];
                Iterator<K> it = map.keySet().iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    iArr[i3] = ((Integer) it.next()).intValue();
                    i3++;
                }
                Arrays.sort(iArr);
                int length = iArr.length;
                while (i2 < length) {
                    int i4 = iArr[i2];
                    V v3 = map.get(Integer.valueOf(i4));
                    this.f6814a.a(i, 2);
                    this.f6814a.c(MapEntryLite.a((MapEntryLite.a<Integer, V>) aVar, Integer.valueOf(i4), (Object) v3));
                    MapEntryLite.a(this.f6814a, (MapEntryLite.a<Integer, V>) aVar, Integer.valueOf(i4), (Object) v3);
                    i2++;
                }
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                long[] jArr = new long[map.size()];
                Iterator<K> it2 = map.keySet().iterator();
                int i5 = 0;
                while (it2.hasNext()) {
                    jArr[i5] = ((Long) it2.next()).longValue();
                    i5++;
                }
                Arrays.sort(jArr);
                int length2 = jArr.length;
                while (i2 < length2) {
                    long j = jArr[i2];
                    V v4 = map.get(Long.valueOf(j));
                    this.f6814a.a(i, 2);
                    this.f6814a.c(MapEntryLite.a((MapEntryLite.a<Long, V>) aVar, Long.valueOf(j), (Object) v4));
                    MapEntryLite.a(this.f6814a, (MapEntryLite.a<Long, V>) aVar, Long.valueOf(j), (Object) v4);
                    i2++;
                }
                return;
            case 12:
                String[] strArr = new String[map.size()];
                Iterator<K> it3 = map.keySet().iterator();
                int i6 = 0;
                while (it3.hasNext()) {
                    strArr[i6] = (String) it3.next();
                    i6++;
                }
                Arrays.sort(strArr);
                int length3 = strArr.length;
                while (i2 < length3) {
                    String str = strArr[i2];
                    V v5 = map.get(str);
                    this.f6814a.a(i, 2);
                    this.f6814a.c(MapEntryLite.a((MapEntryLite.a<String, V>) aVar, str, (Object) v5));
                    MapEntryLite.a(this.f6814a, (MapEntryLite.a<String, V>) aVar, str, (Object) v5);
                    i2++;
                }
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.c);
        }
    }

    /* renamed from: com.uqm.crashsight.protobuf.g$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6815a = new int[WireFormat.FieldType.values().length];

        static {
            try {
                f6815a[WireFormat.FieldType.h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6815a[WireFormat.FieldType.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6815a[WireFormat.FieldType.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6815a[WireFormat.FieldType.o.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6815a[WireFormat.FieldType.q.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6815a[WireFormat.FieldType.m.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6815a[WireFormat.FieldType.f.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6815a[WireFormat.FieldType.c.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6815a[WireFormat.FieldType.p.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6815a[WireFormat.FieldType.r.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6815a[WireFormat.FieldType.d.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6815a[WireFormat.FieldType.i.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private <V> void a(int i, boolean z, V v, MapEntryLite.a<Boolean, V> aVar) throws IOException {
        this.f6814a.a(i, 2);
        this.f6814a.c(MapEntryLite.a(aVar, Boolean.valueOf(z), v));
        MapEntryLite.a(this.f6814a, aVar, Boolean.valueOf(z), v);
    }
}
