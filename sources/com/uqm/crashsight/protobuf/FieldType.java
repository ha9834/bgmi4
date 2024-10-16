package com.uqm.crashsight.protobuf;

/* loaded from: classes3.dex */
public enum FieldType {
    DOUBLE(0, Collection.SCALAR, JavaType.DOUBLE),
    FLOAT(1, Collection.SCALAR, JavaType.FLOAT),
    INT64(2, Collection.SCALAR, JavaType.LONG),
    UINT64(3, Collection.SCALAR, JavaType.LONG),
    INT32(4, Collection.SCALAR, JavaType.INT),
    FIXED64(5, Collection.SCALAR, JavaType.LONG),
    FIXED32(6, Collection.SCALAR, JavaType.INT),
    BOOL(7, Collection.SCALAR, JavaType.BOOLEAN),
    STRING(8, Collection.SCALAR, JavaType.STRING),
    MESSAGE(9, Collection.SCALAR, JavaType.MESSAGE),
    BYTES(10, Collection.SCALAR, JavaType.BYTE_STRING),
    UINT32(11, Collection.SCALAR, JavaType.INT),
    ENUM(12, Collection.SCALAR, JavaType.ENUM),
    SFIXED32(13, Collection.SCALAR, JavaType.INT),
    SFIXED64(14, Collection.SCALAR, JavaType.LONG),
    SINT32(15, Collection.SCALAR, JavaType.INT),
    SINT64(16, Collection.SCALAR, JavaType.LONG),
    GROUP(17, Collection.SCALAR, JavaType.MESSAGE),
    DOUBLE_LIST(18, Collection.VECTOR, JavaType.DOUBLE),
    FLOAT_LIST(19, Collection.VECTOR, JavaType.FLOAT),
    INT64_LIST(20, Collection.VECTOR, JavaType.LONG),
    UINT64_LIST(21, Collection.VECTOR, JavaType.LONG),
    INT32_LIST(22, Collection.VECTOR, JavaType.INT),
    FIXED64_LIST(23, Collection.VECTOR, JavaType.LONG),
    FIXED32_LIST(24, Collection.VECTOR, JavaType.INT),
    BOOL_LIST(25, Collection.VECTOR, JavaType.BOOLEAN),
    STRING_LIST(26, Collection.VECTOR, JavaType.STRING),
    MESSAGE_LIST(27, Collection.VECTOR, JavaType.MESSAGE),
    BYTES_LIST(28, Collection.VECTOR, JavaType.BYTE_STRING),
    UINT32_LIST(29, Collection.VECTOR, JavaType.INT),
    ENUM_LIST(30, Collection.VECTOR, JavaType.ENUM),
    SFIXED32_LIST(31, Collection.VECTOR, JavaType.INT),
    SFIXED64_LIST(32, Collection.VECTOR, JavaType.LONG),
    SINT32_LIST(33, Collection.VECTOR, JavaType.INT),
    SINT64_LIST(34, Collection.VECTOR, JavaType.LONG),
    DOUBLE_LIST_PACKED(35, Collection.PACKED_VECTOR, JavaType.DOUBLE),
    FLOAT_LIST_PACKED(36, Collection.PACKED_VECTOR, JavaType.FLOAT),
    INT64_LIST_PACKED(37, Collection.PACKED_VECTOR, JavaType.LONG),
    UINT64_LIST_PACKED(38, Collection.PACKED_VECTOR, JavaType.LONG),
    INT32_LIST_PACKED(39, Collection.PACKED_VECTOR, JavaType.INT),
    FIXED64_LIST_PACKED(40, Collection.PACKED_VECTOR, JavaType.LONG),
    FIXED32_LIST_PACKED(41, Collection.PACKED_VECTOR, JavaType.INT),
    BOOL_LIST_PACKED(42, Collection.PACKED_VECTOR, JavaType.BOOLEAN),
    UINT32_LIST_PACKED(43, Collection.PACKED_VECTOR, JavaType.INT),
    ENUM_LIST_PACKED(44, Collection.PACKED_VECTOR, JavaType.ENUM),
    SFIXED32_LIST_PACKED(45, Collection.PACKED_VECTOR, JavaType.INT),
    SFIXED64_LIST_PACKED(46, Collection.PACKED_VECTOR, JavaType.LONG),
    SINT32_LIST_PACKED(47, Collection.PACKED_VECTOR, JavaType.INT),
    SINT64_LIST_PACKED(48, Collection.PACKED_VECTOR, JavaType.LONG),
    GROUP_LIST(49, Collection.VECTOR, JavaType.MESSAGE),
    MAP(50, Collection.MAP, JavaType.VOID);

    private static final FieldType[] ac;
    private final JavaType Z;
    private final int aa;
    private final Collection ab;

    static {
        FieldType[] values = values();
        ac = new FieldType[values.length];
        for (FieldType fieldType : values) {
            ac[fieldType.aa] = fieldType;
        }
    }

    FieldType(int i, Collection collection, JavaType javaType) {
        this.aa = i;
        this.ab = collection;
        this.Z = javaType;
        switch (collection) {
            case MAP:
                javaType.a();
                break;
            case VECTOR:
                javaType.a();
                break;
        }
        if (collection == Collection.SCALAR) {
            int[] iArr = AnonymousClass1.b;
            javaType.ordinal();
        }
    }

    /* renamed from: com.uqm.crashsight.protobuf.FieldType$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] b = new int[JavaType.values().length];

        static {
            try {
                b[JavaType.BYTE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[JavaType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[JavaType.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f6706a = new int[Collection.values().length];
            try {
                f6706a[Collection.MAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6706a[Collection.VECTOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6706a[Collection.SCALAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public final int a() {
        return this.aa;
    }

    public final JavaType b() {
        return this.Z;
    }

    public final boolean c() {
        return this.ab == Collection.SCALAR;
    }

    public final boolean d() {
        return this.ab.a();
    }

    public final boolean e() {
        return this.ab == Collection.MAP;
    }

    /* loaded from: classes3.dex */
    enum Collection {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);

        private final boolean e;

        Collection(boolean z) {
            this.e = z;
        }

        public final boolean a() {
            return this.e;
        }
    }
}
