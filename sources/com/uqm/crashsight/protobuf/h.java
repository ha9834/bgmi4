package com.uqm.crashsight.protobuf;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import com.uqm.crashsight.protobuf.Descriptors;
import com.uqm.crashsight.protobuf.Internal;
import com.uqm.crashsight.protobuf.StructuralMessageInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements z {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f6816a;
    private static a b;

    static {
        new h();
        f6816a = new HashSet(Arrays.asList("cached_size", "serialized_size", "class"));
        b = new a();
    }

    private h() {
    }

    @Override // com.uqm.crashsight.protobuf.z
    public final boolean a(Class<?> cls) {
        return GeneratedMessageV3.class.isAssignableFrom(cls);
    }

    @Override // com.uqm.crashsight.protobuf.z
    public final y b(Class<?> cls) {
        if (!GeneratedMessageV3.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        Descriptors.Descriptor d = c(cls).d();
        switch (d.d().i()) {
            case PROTO2:
                return a(cls, d);
            case PROTO3:
                return b(cls, d);
            default:
                throw new IllegalArgumentException("Unsupported syntax: " + d.d().i());
        }
    }

    private static Message c(Class<?> cls) {
        try {
            return (Message) cls.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to get default instance for message class " + cls.getName(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Descriptors.Descriptor, Boolean> f6820a = new ConcurrentHashMap();
        private int b = 0;
        private final Stack<C0219a> c = new Stack<>();
        private final Map<Descriptors.Descriptor, C0219a> d = new HashMap();

        a() {
        }

        public final boolean a(Descriptors.Descriptor descriptor) {
            Boolean bool = this.f6820a.get(descriptor);
            if (bool != null) {
                return bool.booleanValue();
            }
            synchronized (this) {
                Boolean bool2 = this.f6820a.get(descriptor);
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
                return b(descriptor).d.b;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.uqm.crashsight.protobuf.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0219a {

            /* renamed from: a, reason: collision with root package name */
            final Descriptors.Descriptor f6821a;
            final int b;
            int c;
            b d = null;

            C0219a(Descriptors.Descriptor descriptor, int i) {
                this.f6821a = descriptor;
                this.b = i;
                this.c = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            final List<Descriptors.Descriptor> f6822a;
            boolean b;

            private b() {
                this.f6822a = new ArrayList();
                this.b = false;
            }

            /* synthetic */ b(byte b) {
                this();
            }
        }

        private C0219a b(Descriptors.Descriptor descriptor) {
            C0219a pop;
            boolean z;
            int i = this.b;
            this.b = i + 1;
            C0219a c0219a = new C0219a(descriptor, i);
            this.c.push(c0219a);
            this.d.put(descriptor, c0219a);
            for (Descriptors.FieldDescriptor fieldDescriptor : descriptor.f()) {
                if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    C0219a c0219a2 = this.d.get(fieldDescriptor.w());
                    if (c0219a2 == null) {
                        c0219a.c = Math.min(c0219a.c, b(fieldDescriptor.w()).c);
                    } else if (c0219a2.d == null) {
                        c0219a.c = Math.min(c0219a.c, c0219a2.c);
                    }
                }
            }
            if (c0219a.b == c0219a.c) {
                b bVar = new b((byte) 0);
                do {
                    pop = this.c.pop();
                    pop.d = bVar;
                    bVar.f6822a.add(pop.f6821a);
                } while (pop != c0219a);
                Iterator<Descriptors.Descriptor> it = bVar.f6822a.iterator();
                loop2: while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Descriptors.Descriptor next = it.next();
                    if (next.i()) {
                        break;
                    }
                    for (Descriptors.FieldDescriptor fieldDescriptor2 : next.f()) {
                        if (fieldDescriptor2.m()) {
                            break loop2;
                        }
                        if (fieldDescriptor2.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            C0219a c0219a3 = this.d.get(fieldDescriptor2.w());
                            if (c0219a3.d != bVar && c0219a3.d.b) {
                                break loop2;
                            }
                        }
                    }
                }
                bVar.b = z;
                Iterator<Descriptors.Descriptor> it2 = bVar.f6822a.iterator();
                while (it2.hasNext()) {
                    this.f6820a.put(it2.next(), Boolean.valueOf(bVar.b));
                }
            }
            return c0219a;
        }
    }

    private static StructuralMessageInfo a(Class<?> cls, Descriptors.Descriptor descriptor) {
        List<Descriptors.FieldDescriptor> f = descriptor.f();
        StructuralMessageInfo.Builder a2 = StructuralMessageInfo.a(f.size());
        a2.a(c(cls));
        a2.a(ProtoSyntax.PROTO2);
        a2.a(descriptor.e().f());
        b bVar = new b((byte) 0);
        Field field = null;
        int i = 0;
        int i2 = 1;
        for (int i3 = 0; i3 < f.size(); i3++) {
            final Descriptors.FieldDescriptor fieldDescriptor = f.get(i3);
            boolean l = fieldDescriptor.d().f().l();
            Internal.EnumVerifier enumVerifier = fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.ENUM ? new Internal.EnumVerifier() { // from class: com.uqm.crashsight.protobuf.h.1
                @Override // com.uqm.crashsight.protobuf.Internal.EnumVerifier
                public final boolean a(int i4) {
                    return Descriptors.FieldDescriptor.this.x().b(i4) != null;
                }
            } : null;
            if (fieldDescriptor.u() != null) {
                a2.a(a(cls, fieldDescriptor, bVar, l, enumVerifier));
            } else {
                Field a3 = a(cls, fieldDescriptor);
                int e = fieldDescriptor.e();
                FieldType a4 = a(fieldDescriptor);
                if (fieldDescriptor.l()) {
                    final Descriptors.FieldDescriptor b2 = fieldDescriptor.w().b(2);
                    if (b2.f() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        enumVerifier = new Internal.EnumVerifier() { // from class: com.uqm.crashsight.protobuf.h.2
                            @Override // com.uqm.crashsight.protobuf.Internal.EnumVerifier
                            public final boolean a(int i4) {
                                return Descriptors.FieldDescriptor.this.x().b(i4) != null;
                            }
                        };
                    }
                    a2.a(FieldInfo.a(a3, e, aq.a(cls, fieldDescriptor.b()), enumVerifier));
                } else if (!fieldDescriptor.o()) {
                    if (field == null) {
                        field = b(cls, "bitField" + i + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                    }
                    if (fieldDescriptor.m()) {
                        a2.a(FieldInfo.b(a3, e, a4, field, i2, l, enumVerifier));
                    } else {
                        a2.a(FieldInfo.a(a3, e, a4, field, i2, l, enumVerifier));
                    }
                } else if (enumVerifier != null) {
                    if (fieldDescriptor.p()) {
                        a2.a(FieldInfo.a(a3, e, a4, enumVerifier, b(cls, b(fieldDescriptor.b()) + "MemoizedSerializedSize")));
                    } else {
                        a2.a(FieldInfo.a(a3, e, a4, enumVerifier));
                    }
                } else if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    a2.a(FieldInfo.a(a3, e, a4, c(cls, fieldDescriptor)));
                } else if (fieldDescriptor.p()) {
                    a2.a(FieldInfo.a(a3, e, a4, b(cls, b(fieldDescriptor.b()) + "MemoizedSerializedSize")));
                } else {
                    a2.a(FieldInfo.a(a3, e, a4, l));
                }
            }
            int i4 = i2 << 1;
            if (i4 == 0) {
                i++;
                field = null;
                i2 = 1;
            } else {
                i2 = i4;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < f.size(); i5++) {
            Descriptors.FieldDescriptor fieldDescriptor2 = f.get(i5);
            if (!fieldDescriptor2.m()) {
                if (fieldDescriptor2.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (!b.a(fieldDescriptor2.w())) {
                    }
                }
            }
            arrayList.add(Integer.valueOf(fieldDescriptor2.e()));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            iArr[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        a2.a(iArr);
        return a2.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static StructuralMessageInfo b(Class<?> cls, Descriptors.Descriptor descriptor) {
        List<Descriptors.FieldDescriptor> f = descriptor.f();
        StructuralMessageInfo.Builder a2 = StructuralMessageInfo.a(f.size());
        a2.a(c(cls));
        a2.a(ProtoSyntax.PROTO3);
        b bVar = new b(0 == true ? 1 : 0);
        for (int i = 0; i < f.size(); i++) {
            Descriptors.FieldDescriptor fieldDescriptor = f.get(i);
            if (fieldDescriptor.u() != null) {
                a2.a(a(cls, fieldDescriptor, bVar, true, null));
            } else if (fieldDescriptor.l()) {
                a2.a(FieldInfo.a(a(cls, fieldDescriptor), fieldDescriptor.e(), aq.a(cls, fieldDescriptor.b()), (Internal.EnumVerifier) null));
            } else if (fieldDescriptor.o() && fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                a2.a(FieldInfo.a(a(cls, fieldDescriptor), fieldDescriptor.e(), a(fieldDescriptor), c(cls, fieldDescriptor)));
            } else if (fieldDescriptor.p()) {
                a2.a(FieldInfo.a(a(cls, fieldDescriptor), fieldDescriptor.e(), a(fieldDescriptor), b(cls, b(fieldDescriptor.b()) + "MemoizedSerializedSize")));
            } else {
                a2.a(FieldInfo.a(a(cls, fieldDescriptor), fieldDescriptor.e(), a(fieldDescriptor), true));
            }
        }
        return a2.a();
    }

    private static FieldInfo a(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor, b bVar, boolean z, Internal.EnumVerifier enumVerifier) {
        Class cls2;
        ai a2 = bVar.a(cls, fieldDescriptor.u());
        FieldType a3 = a(fieldDescriptor);
        switch (a3.b()) {
            case BOOLEAN:
                cls2 = Boolean.class;
                break;
            case BYTE_STRING:
                cls2 = ByteString.class;
                break;
            case DOUBLE:
                cls2 = Double.class;
                break;
            case FLOAT:
                cls2 = Float.class;
                break;
            case ENUM:
            case INT:
                cls2 = Integer.class;
                break;
            case LONG:
                cls2 = Long.class;
                break;
            case STRING:
                cls2 = String.class;
                break;
            case MESSAGE:
                cls2 = b(cls, fieldDescriptor);
                break;
            default:
                throw new IllegalArgumentException("Invalid type for oneof: " + a3);
        }
        return FieldInfo.a(fieldDescriptor.e(), a3, a2, cls2, z, enumVerifier);
    }

    private static FieldType a(Descriptors.FieldDescriptor fieldDescriptor) {
        switch (fieldDescriptor.h()) {
            case BOOL:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.BOOL_LIST_PACKED : FieldType.BOOL_LIST;
                }
                return FieldType.BOOL;
            case BYTES:
                return fieldDescriptor.o() ? FieldType.BYTES_LIST : FieldType.BYTES;
            case DOUBLE:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.DOUBLE_LIST_PACKED : FieldType.DOUBLE_LIST;
                }
                return FieldType.DOUBLE;
            case ENUM:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.ENUM_LIST_PACKED : FieldType.ENUM_LIST;
                }
                return FieldType.ENUM;
            case FIXED32:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.FIXED32_LIST_PACKED : FieldType.FIXED32_LIST;
                }
                return FieldType.FIXED32;
            case FIXED64:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.FIXED64_LIST_PACKED : FieldType.FIXED64_LIST;
                }
                return FieldType.FIXED64;
            case FLOAT:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.FLOAT_LIST_PACKED : FieldType.FLOAT_LIST;
                }
                return FieldType.FLOAT;
            case GROUP:
                return fieldDescriptor.o() ? FieldType.GROUP_LIST : FieldType.GROUP;
            case INT32:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.INT32_LIST_PACKED : FieldType.INT32_LIST;
                }
                return FieldType.INT32;
            case INT64:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.INT64_LIST_PACKED : FieldType.INT64_LIST;
                }
                return FieldType.INT64;
            case MESSAGE:
                if (fieldDescriptor.l()) {
                    return FieldType.MAP;
                }
                return fieldDescriptor.o() ? FieldType.MESSAGE_LIST : FieldType.MESSAGE;
            case SFIXED32:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.SFIXED32_LIST_PACKED : FieldType.SFIXED32_LIST;
                }
                return FieldType.SFIXED32;
            case SFIXED64:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.SFIXED64_LIST_PACKED : FieldType.SFIXED64_LIST;
                }
                return FieldType.SFIXED64;
            case SINT32:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.SINT32_LIST_PACKED : FieldType.SINT32_LIST;
                }
                return FieldType.SINT32;
            case SINT64:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.SINT64_LIST_PACKED : FieldType.SINT64_LIST;
                }
                return FieldType.SINT64;
            case STRING:
                return fieldDescriptor.o() ? FieldType.STRING_LIST : FieldType.STRING;
            case UINT32:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.UINT32_LIST_PACKED : FieldType.UINT32_LIST;
                }
                return FieldType.UINT32;
            case UINT64:
                if (fieldDescriptor.o()) {
                    return fieldDescriptor.p() ? FieldType.UINT64_LIST_PACKED : FieldType.UINT64_LIST;
                }
                return FieldType.UINT64;
            default:
                throw new IllegalArgumentException("Unsupported field type: " + fieldDescriptor.h());
        }
    }

    private static Field a(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        String b2 = fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.GROUP ? fieldDescriptor.w().b() : fieldDescriptor.b();
        return b(cls, b(b2) + (f6816a.contains(b2) ? "__" : EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field b(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unable to find field " + str + " in message class " + cls.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 1);
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '_') {
                z = true;
            } else if (Character.isDigit(charAt)) {
                sb.append(charAt);
                z = true;
            } else if (z) {
                sb.append(Character.toUpperCase(charAt));
                z = false;
            } else if (i == 0) {
                sb.append(Character.toLowerCase(charAt));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private static Class<?> b(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        try {
            return cls.getDeclaredMethod(c(fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.GROUP ? fieldDescriptor.w().b() : fieldDescriptor.b()), new Class[0]).getReturnType();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<?> c(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        try {
            return cls.getDeclaredMethod(c(fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.GROUP ? fieldDescriptor.w().b() : fieldDescriptor.b()), Integer.TYPE).getReturnType();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String c(String str) {
        String b2 = b(str);
        return "get" + Character.toUpperCase(b2.charAt(0)) + b2.substring(1, b2.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private ai[] f6823a;

        private b() {
            this.f6823a = new ai[2];
        }

        /* synthetic */ b(byte b) {
            this();
        }

        final ai a(Class<?> cls, Descriptors.OneofDescriptor oneofDescriptor) {
            int a2 = oneofDescriptor.a();
            ai[] aiVarArr = this.f6823a;
            if (a2 >= aiVarArr.length) {
                this.f6823a = (ai[]) Arrays.copyOf(aiVarArr, a2 << 1);
            }
            ai aiVar = this.f6823a[a2];
            if (aiVar != null) {
                return aiVar;
            }
            String b = h.b(oneofDescriptor.b());
            ai aiVar2 = new ai(oneofDescriptor.a(), h.b(cls, b + "Case_"), h.b(cls, b + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR));
            this.f6823a[a2] = aiVar2;
            return aiVar2;
        }
    }
}
