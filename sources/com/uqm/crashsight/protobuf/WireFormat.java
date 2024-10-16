package com.uqm.crashsight.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.helpshift.logger.model.LogDatabaseTable;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class WireFormat {

    /* renamed from: a, reason: collision with root package name */
    static final int f6779a = 11;
    static final int b = 12;
    static final int c = 16;
    static final int d = 26;

    public static int a(int i) {
        return i & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static int b(int i) {
        return i >>> 3;
    }

    private WireFormat() {
    }

    /* loaded from: classes3.dex */
    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
        BOOLEAN(false),
        STRING(""),
        BYTE_STRING(ByteString.f6635a),
        ENUM(null),
        MESSAGE(null);

        JavaType(Object obj) {
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'i' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static class FieldType {
        public static final FieldType i;
        public static final FieldType k;
        public static final FieldType l;
        private static final /* synthetic */ FieldType[] u;
        private final JavaType s;
        private final int t;

        /* renamed from: a, reason: collision with root package name */
        public static final FieldType f6781a = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
        public static final FieldType b = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
        public static final FieldType c = new FieldType("INT64", 2, JavaType.LONG, 0);
        public static final FieldType d = new FieldType("UINT64", 3, JavaType.LONG, 0);
        public static final FieldType e = new FieldType("INT32", 4, JavaType.INT, 0);
        public static final FieldType f = new FieldType("FIXED64", 5, JavaType.LONG, 1);
        public static final FieldType g = new FieldType("FIXED32", 6, JavaType.INT, 5);
        public static final FieldType h = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
        public static final FieldType j = new FieldType("GROUP", 9, JavaType.MESSAGE, 3) { // from class: com.uqm.crashsight.protobuf.WireFormat.FieldType.2
            @Override // com.uqm.crashsight.protobuf.WireFormat.FieldType
            public final boolean c() {
                return false;
            }

            {
                int i2 = 9;
                int i3 = 3;
                byte b2 = 0;
            }
        };
        public static final FieldType m = new FieldType("UINT32", 12, JavaType.INT, 0);
        public static final FieldType n = new FieldType("ENUM", 13, JavaType.ENUM, 0);
        public static final FieldType o = new FieldType("SFIXED32", 14, JavaType.INT, 5);
        public static final FieldType p = new FieldType("SFIXED64", 15, JavaType.LONG, 1);
        public static final FieldType q = new FieldType("SINT32", 16, JavaType.INT, 0);
        public static final FieldType r = new FieldType("SINT64", 17, JavaType.LONG, 0);

        public boolean c() {
            return true;
        }

        /* synthetic */ FieldType(String str, int i2, JavaType javaType, int i3, byte b2) {
            this(str, i2, javaType, i3);
        }

        public static FieldType valueOf(String str) {
            return (FieldType) Enum.valueOf(FieldType.class, str);
        }

        public static FieldType[] values() {
            return (FieldType[]) u.clone();
        }

        static {
            int i2 = 2;
            i = new FieldType("STRING", 8, JavaType.STRING, i2) { // from class: com.uqm.crashsight.protobuf.WireFormat.FieldType.1
                @Override // com.uqm.crashsight.protobuf.WireFormat.FieldType
                public final boolean c() {
                    return false;
                }

                {
                    int i3 = 8;
                    int i4 = 2;
                    byte b2 = 0;
                }
            };
            k = new FieldType(LogDatabaseTable.LogTableColumns.MESSAGE, 10, JavaType.MESSAGE, i2) { // from class: com.uqm.crashsight.protobuf.WireFormat.FieldType.3
                @Override // com.uqm.crashsight.protobuf.WireFormat.FieldType
                public final boolean c() {
                    return false;
                }

                {
                    int i3 = 10;
                    int i4 = 2;
                    byte b2 = 0;
                }
            };
            l = new FieldType("BYTES", 11, JavaType.BYTE_STRING, i2) { // from class: com.uqm.crashsight.protobuf.WireFormat.FieldType.4
                @Override // com.uqm.crashsight.protobuf.WireFormat.FieldType
                public final boolean c() {
                    return false;
                }

                {
                    int i3 = 11;
                    int i4 = 2;
                    byte b2 = 0;
                }
            };
            u = new FieldType[]{f6781a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r};
        }

        private FieldType(String str, int i2, JavaType javaType, int i3) {
            this.s = javaType;
            this.t = i3;
        }

        public final JavaType a() {
            return this.s;
        }

        public final int b() {
            return this.t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum Utf8Validation {
        LOOSE { // from class: com.uqm.crashsight.protobuf.WireFormat.Utf8Validation.1
            @Override // com.uqm.crashsight.protobuf.WireFormat.Utf8Validation
            final Object a(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.j();
            }
        },
        STRICT { // from class: com.uqm.crashsight.protobuf.WireFormat.Utf8Validation.2
            @Override // com.uqm.crashsight.protobuf.WireFormat.Utf8Validation
            final Object a(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.k();
            }
        },
        LAZY { // from class: com.uqm.crashsight.protobuf.WireFormat.Utf8Validation.3
            @Override // com.uqm.crashsight.protobuf.WireFormat.Utf8Validation
            final Object a(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.l();
            }
        };

        abstract Object a(CodedInputStream codedInputStream) throws IOException;

        /* synthetic */ Utf8Validation(byte b) {
            this();
        }
    }

    /* renamed from: com.uqm.crashsight.protobuf.WireFormat$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6780a = new int[FieldType.values().length];

        static {
            try {
                f6780a[FieldType.f6781a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6780a[FieldType.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6780a[FieldType.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6780a[FieldType.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6780a[FieldType.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6780a[FieldType.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6780a[FieldType.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6780a[FieldType.h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6780a[FieldType.l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6780a[FieldType.m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6780a[FieldType.o.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6780a[FieldType.p.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6780a[FieldType.q.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6780a[FieldType.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6780a[FieldType.i.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6780a[FieldType.j.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6780a[FieldType.k.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f6780a[FieldType.n.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(CodedInputStream codedInputStream, FieldType fieldType, Utf8Validation utf8Validation) throws IOException {
        switch (AnonymousClass1.f6780a[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(codedInputStream.b());
            case 2:
                return Float.valueOf(codedInputStream.c());
            case 3:
                return Long.valueOf(codedInputStream.e());
            case 4:
                return Long.valueOf(codedInputStream.d());
            case 5:
                return Integer.valueOf(codedInputStream.f());
            case 6:
                return Long.valueOf(codedInputStream.g());
            case 7:
                return Integer.valueOf(codedInputStream.h());
            case 8:
                return Boolean.valueOf(codedInputStream.i());
            case 9:
                return codedInputStream.l();
            case 10:
                return Integer.valueOf(codedInputStream.m());
            case 11:
                return Integer.valueOf(codedInputStream.o());
            case 12:
                return Long.valueOf(codedInputStream.p());
            case 13:
                return Integer.valueOf(codedInputStream.q());
            case 14:
                return Long.valueOf(codedInputStream.r());
            case 15:
                return utf8Validation.a(codedInputStream);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
