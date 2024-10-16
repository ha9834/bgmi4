package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite;
import com.uqm.crashsight.protobuf.Internal;
import com.uqm.crashsight.protobuf.LazyField;
import com.uqm.crashsight.protobuf.MessageLite;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class FieldSet<T extends FieldDescriptorLite<T>> {
    private static final FieldSet d = new FieldSet((byte) 0);

    /* renamed from: a, reason: collision with root package name */
    private final ar<T, Object> f6702a;
    private boolean b;
    private boolean c;

    /* loaded from: classes3.dex */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        MessageLite.Builder a(MessageLite.Builder builder, MessageLite messageLite);

        int e();

        WireFormat.JavaType g();

        WireFormat.FieldType i();

        boolean o();

        boolean p();
    }

    /* synthetic */ FieldSet(ar arVar, byte b) {
        this(arVar);
    }

    private FieldSet() {
        this.f6702a = ar.a(16);
    }

    private FieldSet(byte b) {
        this(ar.a(0));
        if (this.b) {
            return;
        }
        this.f6702a.a();
        this.b = true;
    }

    private FieldSet(ar<T, Object> arVar) {
        this.f6702a = arVar;
        if (this.b) {
            return;
        }
        this.f6702a.a();
        this.b = true;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> a() {
        return new FieldSet<>();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> b() {
        return d;
    }

    public static <T extends FieldDescriptorLite<T>> a<T> c() {
        return new a<>((byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        return this.f6702a.isEmpty();
    }

    public final void e() {
        if (this.b) {
            return;
        }
        this.f6702a.a();
        this.b = true;
    }

    public final boolean f() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldSet) {
            return this.f6702a.equals(((FieldSet) obj).f6702a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6702a.hashCode();
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final FieldSet<T> clone() {
        FieldSet<T> fieldSet = new FieldSet<>();
        for (int i = 0; i < this.f6702a.c(); i++) {
            Map.Entry<T, Object> b = this.f6702a.b(i);
            fieldSet.a((FieldSet<T>) b.getKey(), b.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f6702a.d()) {
            fieldSet.a((FieldSet<T>) entry.getKey(), entry.getValue());
        }
        fieldSet.c = this.c;
        return fieldSet;
    }

    public final Map<T, Object> h() {
        if (!this.c) {
            return this.f6702a.b() ? this.f6702a : Collections.unmodifiableMap(this.f6702a);
        }
        ar b = b((ar) this.f6702a, false);
        if (this.f6702a.b()) {
            b.a();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> ar<T, Object> b(ar<T, Object> arVar, boolean z) {
        ar<T, Object> a2 = ar.a(16);
        for (int i = 0; i < arVar.c(); i++) {
            a(a2, arVar.b(i), z);
        }
        Iterator<Map.Entry<T, Object>> it = arVar.d().iterator();
        while (it.hasNext()) {
            a(a2, it.next(), z);
        }
        return a2;
    }

    private static <T extends FieldDescriptorLite<T>> void a(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            map.put(key, ((LazyField) value).a());
        } else if (z && (value instanceof List)) {
            map.put(key, new ArrayList((List) value));
        } else {
            map.put(key, value);
        }
    }

    public final Iterator<Map.Entry<T, Object>> i() {
        if (this.c) {
            return new LazyField.b(this.f6702a.entrySet().iterator());
        }
        return this.f6702a.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> j() {
        if (this.c) {
            return new LazyField.b(this.f6702a.e().iterator());
        }
        return this.f6702a.e().iterator();
    }

    public final boolean a(T t) {
        if (t.o()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f6702a.get(t) != null;
    }

    public final Object b(T t) {
        Object obj = this.f6702a.get(t);
        return obj instanceof LazyField ? ((LazyField) obj).a() : obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(T t, Object obj) {
        if (t.o()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!b(t.i(), it.next())) {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
            obj = arrayList;
        } else if (!b(t.i(), obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof LazyField) {
            this.c = true;
        }
        this.f6702a.a((ar<T, Object>) t, (T) obj);
    }

    public final void c(T t) {
        this.f6702a.remove(t);
        if (this.f6702a.isEmpty()) {
            this.c = false;
        }
    }

    public final void b(T t, Object obj) {
        List list;
        if (!t.o()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        if (!b(t.i(), obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        Object obj2 = this.f6702a.get(t);
        if (obj2 instanceof LazyField) {
            obj2 = ((LazyField) obj2).a();
        }
        if (obj2 == null) {
            list = new ArrayList();
            this.f6702a.a((ar<T, Object>) t, (T) list);
        } else {
            list = (List) obj2;
        }
        list.add(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(WireFormat.FieldType fieldType, Object obj) {
        Internal.a(obj);
        switch (fieldType.a()) {
            case INT:
                return obj instanceof Integer;
            case LONG:
                return obj instanceof Long;
            case FLOAT:
                return obj instanceof Float;
            case DOUBLE:
                return obj instanceof Double;
            case BOOLEAN:
                return obj instanceof Boolean;
            case STRING:
                return obj instanceof String;
            case BYTE_STRING:
                return (obj instanceof ByteString) || (obj instanceof byte[]);
            case ENUM:
                return (obj instanceof Integer) || (obj instanceof Internal.EnumLite);
            case MESSAGE:
                return (obj instanceof MessageLite) || (obj instanceof LazyField);
            default:
                return false;
        }
    }

    public final boolean k() {
        for (int i = 0; i < this.f6702a.c(); i++) {
            if (!b((Map.Entry) this.f6702a.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.f6702a.d().iterator();
        while (it.hasNext()) {
            if (!b((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> boolean b(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.g() == WireFormat.JavaType.MESSAGE) {
            if (key.o()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((MessageLite) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof MessageLite) {
                    if (!((MessageLite) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof LazyField) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(WireFormat.FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.b();
    }

    public final void a(FieldSet<T> fieldSet) {
        for (int i = 0; i < fieldSet.f6702a.c(); i++) {
            c(fieldSet.f6702a.b(i));
        }
        Iterator<Map.Entry<T, Object>> it = fieldSet.f6702a.d().iterator();
        while (it.hasNext()) {
            c(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object b(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private void c(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).a();
        }
        if (key.o()) {
            Object obj = this.f6702a.get(key);
            if (obj instanceof LazyField) {
                obj = ((LazyField) obj).a();
            }
            if (obj == null) {
                obj = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) obj).add(b(it.next()));
            }
            this.f6702a.a((ar<T, Object>) key, (T) obj);
            return;
        }
        if (key.g() == WireFormat.JavaType.MESSAGE) {
            Object obj2 = this.f6702a.get(key);
            if (obj2 instanceof LazyField) {
                obj2 = ((LazyField) obj2).a();
            }
            if (obj2 == null) {
                this.f6702a.a((ar<T, Object>) key, (T) b(value));
                return;
            } else {
                this.f6702a.a((ar<T, Object>) key, (T) key.a(((MessageLite) obj2).toBuilder(), (MessageLite) value).build());
                return;
            }
        }
        this.f6702a.a((ar<T, Object>) key, (T) b(value));
    }

    public static Object a(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z) throws IOException {
        return WireFormat.a(codedInputStream, fieldType, WireFormat.Utf8Validation.STRICT);
    }

    public final void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f6702a.c(); i++) {
            Map.Entry<T, Object> b = this.f6702a.b(i);
            a((FieldDescriptorLite<?>) b.getKey(), b.getValue(), codedOutputStream);
        }
        for (Map.Entry<T, Object> entry : this.f6702a.d()) {
            a((FieldDescriptorLite<?>) entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }

    public final void b(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f6702a.c(); i++) {
            a(this.f6702a.b(i), codedOutputStream);
        }
        Iterator<Map.Entry<T, Object>> it = this.f6702a.d().iterator();
        while (it.hasNext()) {
            a(it.next(), codedOutputStream);
        }
    }

    private static void a(Map.Entry<T, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        T key = entry.getKey();
        if (key.g() == WireFormat.JavaType.MESSAGE && !key.o() && !key.p()) {
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                value = ((LazyField) value).a();
            }
            codedOutputStream.b(entry.getKey().e(), (MessageLite) value);
            return;
        }
        a((FieldDescriptorLite<?>) key, entry.getValue(), codedOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.j) {
            codedOutputStream.e(i, (MessageLite) obj);
        } else {
            codedOutputStream.a(i, fieldType.b());
            a(codedOutputStream, fieldType, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.uqm.crashsight.protobuf.FieldSet$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] b = new int[WireFormat.FieldType.values().length];

        static {
            try {
                b[WireFormat.FieldType.f6781a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[WireFormat.FieldType.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[WireFormat.FieldType.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[WireFormat.FieldType.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[WireFormat.FieldType.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[WireFormat.FieldType.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[WireFormat.FieldType.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[WireFormat.FieldType.h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[WireFormat.FieldType.j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[WireFormat.FieldType.k.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[WireFormat.FieldType.i.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[WireFormat.FieldType.l.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[WireFormat.FieldType.m.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[WireFormat.FieldType.o.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[WireFormat.FieldType.p.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[WireFormat.FieldType.q.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[WireFormat.FieldType.r.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[WireFormat.FieldType.n.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            f6703a = new int[WireFormat.JavaType.values().length];
            try {
                f6703a[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f6703a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f6703a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f6703a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f6703a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f6703a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f6703a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f6703a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f6703a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    private static void a(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.a(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.a(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.a(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.b(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.b(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.d(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.e(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.a(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.c((MessageLite) obj);
                return;
            case 10:
                codedOutputStream.a((MessageLite) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.a((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.a((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ByteString) {
                    codedOutputStream.a((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.b((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.c(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.f(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.e(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.d(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.c(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    codedOutputStream.g(((Internal.EnumLite) obj).a());
                    return;
                } else {
                    codedOutputStream.g(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void a(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType i = fieldDescriptorLite.i();
        int e = fieldDescriptorLite.e();
        if (fieldDescriptorLite.o()) {
            List list = (List) obj;
            if (fieldDescriptorLite.p()) {
                codedOutputStream.a(e, 2);
                int i2 = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    i2 += c(i, it.next());
                }
                codedOutputStream.o(i2);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    a(codedOutputStream, i, it2.next());
                }
                return;
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                a(codedOutputStream, i, e, it3.next());
            }
            return;
        }
        if (obj instanceof LazyField) {
            a(codedOutputStream, i, e, ((LazyField) obj).a());
        } else {
            a(codedOutputStream, i, e, obj);
        }
    }

    public final int l() {
        int i = 0;
        for (int i2 = 0; i2 < this.f6702a.c(); i2++) {
            Map.Entry<T, Object> b = this.f6702a.b(i2);
            i += c((FieldDescriptorLite<?>) b.getKey(), b.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f6702a.d()) {
            i += c((FieldDescriptorLite<?>) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int m() {
        int i = 0;
        for (int i2 = 0; i2 < this.f6702a.c(); i2++) {
            i += d(this.f6702a.b(i2));
        }
        Iterator<Map.Entry<T, Object>> it = this.f6702a.d().iterator();
        while (it.hasNext()) {
            i += d(it.next());
        }
        return i;
    }

    private static int d(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.g() == WireFormat.JavaType.MESSAGE && !key.o() && !key.p()) {
            if (value instanceof LazyField) {
                return CodedOutputStream.b(entry.getKey().e(), (LazyField) value);
            }
            return CodedOutputStream.d(entry.getKey().e(), (MessageLite) value);
        }
        return c((FieldDescriptorLite<?>) key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(WireFormat.FieldType fieldType, int i, Object obj) {
        int h = CodedOutputStream.h(i);
        if (fieldType == WireFormat.FieldType.j) {
            h <<= 1;
        }
        return h + c(fieldType, obj);
    }

    private static int c(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.b[fieldType.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                return CodedOutputStream.g();
            case 2:
                ((Float) obj).floatValue();
                return CodedOutputStream.f();
            case 3:
                return CodedOutputStream.f(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.g(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.i(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                return CodedOutputStream.d();
            case 7:
                ((Integer) obj).intValue();
                return CodedOutputStream.b();
            case 8:
                ((Boolean) obj).booleanValue();
                return CodedOutputStream.h();
            case 9:
                return CodedOutputStream.d((MessageLite) obj);
            case 10:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.a((LazyField) obj);
                }
                return CodedOutputStream.b((MessageLite) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.b((ByteString) obj);
                }
                return CodedOutputStream.b((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.b((ByteString) obj);
                }
                return CodedOutputStream.c((byte[]) obj);
            case 13:
                return CodedOutputStream.j(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                return CodedOutputStream.c();
            case 15:
                ((Long) obj).longValue();
                return CodedOutputStream.e();
            case 16:
                return CodedOutputStream.k(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.h(((Long) obj).longValue());
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.l(((Internal.EnumLite) obj).a());
                }
                return CodedOutputStream.l(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int c(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType i = fieldDescriptorLite.i();
        int e = fieldDescriptorLite.e();
        if (fieldDescriptorLite.o()) {
            int i2 = 0;
            if (fieldDescriptorLite.p()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i2 += c(i, it.next());
                }
                return CodedOutputStream.h(e) + i2 + CodedOutputStream.p(i2);
            }
            for (Object obj2 : (List) obj) {
                int h = CodedOutputStream.h(e);
                if (i == WireFormat.FieldType.j) {
                    h <<= 1;
                }
                i2 += h + c(i, obj2);
            }
            return i2;
        }
        int h2 = CodedOutputStream.h(e);
        if (i == WireFormat.FieldType.j) {
            h2 <<= 1;
        }
        return h2 + c(i, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a<T extends FieldDescriptorLite<T>> {

        /* renamed from: a, reason: collision with root package name */
        private ar<T, Object> f6704a;
        private boolean b;
        private boolean c;
        private boolean d;

        /* synthetic */ a(byte b) {
            this();
        }

        private a() {
            this(ar.a(16));
        }

        private a(ar<T, Object> arVar) {
            this.f6704a = arVar;
            this.c = true;
        }

        public final FieldSet<T> a() {
            if (this.f6704a.isEmpty()) {
                return FieldSet.b();
            }
            byte b = 0;
            this.c = false;
            ar<T, Object> arVar = this.f6704a;
            if (this.d) {
                arVar = FieldSet.b((ar) arVar, false);
                a(arVar);
            }
            FieldSet<T> fieldSet = new FieldSet<>(arVar, b);
            ((FieldSet) fieldSet).c = this.b;
            return fieldSet;
        }

        private static <T extends FieldDescriptorLite<T>> void a(ar<T, Object> arVar) {
            for (int i = 0; i < arVar.c(); i++) {
                Map.Entry<T, Object> b = arVar.b(i);
                b.setValue(c(b.getKey(), b.getValue()));
            }
            for (Map.Entry<T, Object> entry : arVar.d()) {
                entry.setValue(c(entry.getKey(), entry.getValue()));
            }
        }

        private static <T extends FieldDescriptorLite<T>> Object c(T t, Object obj) {
            if (obj == null || t.g() != WireFormat.JavaType.MESSAGE) {
                return obj;
            }
            if (!t.o()) {
                return obj instanceof MessageLite.Builder ? ((MessageLite.Builder) obj).build() : obj;
            }
            if (!(obj instanceof List)) {
                throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + obj.getClass());
            }
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                Object obj2 = list.get(i);
                Object build = obj2 instanceof MessageLite.Builder ? ((MessageLite.Builder) obj2).build() : obj2;
                if (build != obj2) {
                    if (list == obj) {
                        list = new ArrayList(list);
                    }
                    list.set(i, build);
                }
            }
            return list;
        }

        public final Map<T, Object> b() {
            if (!this.b) {
                return this.f6704a.b() ? this.f6704a : Collections.unmodifiableMap(this.f6704a);
            }
            ar b = FieldSet.b((ar) this.f6704a, false);
            if (this.f6704a.b()) {
                b.a();
            } else {
                a(b);
            }
            return b;
        }

        public final boolean a(T t) {
            if (t.o()) {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            }
            return this.f6704a.get(t) != null;
        }

        public final Object b(T t) {
            Object obj = this.f6704a.get(t);
            if (obj instanceof LazyField) {
                obj = ((LazyField) obj).a();
            }
            return c(t, obj);
        }

        public final void a(T t, Object obj) {
            boolean z = true;
            if (!this.c) {
                this.f6704a = FieldSet.b((ar) this.f6704a, true);
                this.c = true;
            }
            if (t.o()) {
                if (!(obj instanceof List)) {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                for (Object obj2 : arrayList) {
                    a(t.i(), obj2);
                    this.d = this.d || (obj2 instanceof MessageLite.Builder);
                }
                obj = arrayList;
            } else {
                a(t.i(), obj);
            }
            if (obj instanceof LazyField) {
                this.b = true;
            }
            if (!this.d && !(obj instanceof MessageLite.Builder)) {
                z = false;
            }
            this.d = z;
            this.f6704a.a((ar<T, Object>) t, (T) obj);
        }

        public final void b(T t, Object obj) {
            List list;
            boolean z = true;
            if (!this.c) {
                this.f6704a = FieldSet.b((ar) this.f6704a, true);
                this.c = true;
            }
            if (!t.o()) {
                throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
            }
            if (!this.d && !(obj instanceof MessageLite.Builder)) {
                z = false;
            }
            this.d = z;
            a(t.i(), obj);
            Object b = b(t);
            if (b == null) {
                list = new ArrayList();
                this.f6704a.a((ar<T, Object>) t, (T) list);
            } else {
                list = (List) b;
            }
            list.add(obj);
        }

        private static void a(WireFormat.FieldType fieldType, Object obj) {
            if (FieldSet.b(fieldType, obj)) {
                return;
            }
            if (fieldType.a() != WireFormat.JavaType.MESSAGE || !(obj instanceof MessageLite.Builder)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }

        public final boolean c() {
            for (int i = 0; i < this.f6704a.c(); i++) {
                if (!FieldSet.b((Map.Entry) this.f6704a.b(i))) {
                    return false;
                }
            }
            Iterator<Map.Entry<T, Object>> it = this.f6704a.d().iterator();
            while (it.hasNext()) {
                if (!FieldSet.b((Map.Entry) it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final void a(FieldSet<T> fieldSet) {
            if (!this.c) {
                this.f6704a = FieldSet.b((ar) this.f6704a, true);
                this.c = true;
            }
            for (int i = 0; i < ((FieldSet) fieldSet).f6702a.c(); i++) {
                a(((FieldSet) fieldSet).f6702a.b(i));
            }
            Iterator it = ((FieldSet) fieldSet).f6702a.d().iterator();
            while (it.hasNext()) {
                a((Map.Entry) it.next());
            }
        }

        private void a(Map.Entry<T, Object> entry) {
            T key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                value = ((LazyField) value).a();
            }
            if (key.o()) {
                Object b = b(key);
                if (b == null) {
                    b = new ArrayList();
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    ((List) b).add(FieldSet.b(it.next()));
                }
                this.f6704a.a((ar<T, Object>) key, (T) b);
                return;
            }
            if (key.g() != WireFormat.JavaType.MESSAGE) {
                this.f6704a.a((ar<T, Object>) key, (T) FieldSet.b(value));
                return;
            }
            Object b2 = b(key);
            if (b2 == null) {
                this.f6704a.a((ar<T, Object>) key, (T) FieldSet.b(value));
            } else if (b2 instanceof MessageLite.Builder) {
                key.a((MessageLite.Builder) b2, (MessageLite) value);
            } else {
                this.f6704a.a((ar<T, Object>) key, (T) key.a(((MessageLite) b2).toBuilder(), (MessageLite) value).build());
            }
        }
    }
}
