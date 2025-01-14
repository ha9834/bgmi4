package com.google.android.gms.internal.gtm;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum zzqw {
    DOUBLE(0, zzqy.SCALAR, zzrm.DOUBLE),
    FLOAT(1, zzqy.SCALAR, zzrm.FLOAT),
    INT64(2, zzqy.SCALAR, zzrm.LONG),
    UINT64(3, zzqy.SCALAR, zzrm.LONG),
    INT32(4, zzqy.SCALAR, zzrm.INT),
    FIXED64(5, zzqy.SCALAR, zzrm.LONG),
    FIXED32(6, zzqy.SCALAR, zzrm.INT),
    BOOL(7, zzqy.SCALAR, zzrm.BOOLEAN),
    STRING(8, zzqy.SCALAR, zzrm.STRING),
    MESSAGE(9, zzqy.SCALAR, zzrm.MESSAGE),
    BYTES(10, zzqy.SCALAR, zzrm.BYTE_STRING),
    UINT32(11, zzqy.SCALAR, zzrm.INT),
    ENUM(12, zzqy.SCALAR, zzrm.ENUM),
    SFIXED32(13, zzqy.SCALAR, zzrm.INT),
    SFIXED64(14, zzqy.SCALAR, zzrm.LONG),
    SINT32(15, zzqy.SCALAR, zzrm.INT),
    SINT64(16, zzqy.SCALAR, zzrm.LONG),
    GROUP(17, zzqy.SCALAR, zzrm.MESSAGE),
    DOUBLE_LIST(18, zzqy.VECTOR, zzrm.DOUBLE),
    FLOAT_LIST(19, zzqy.VECTOR, zzrm.FLOAT),
    INT64_LIST(20, zzqy.VECTOR, zzrm.LONG),
    UINT64_LIST(21, zzqy.VECTOR, zzrm.LONG),
    INT32_LIST(22, zzqy.VECTOR, zzrm.INT),
    FIXED64_LIST(23, zzqy.VECTOR, zzrm.LONG),
    FIXED32_LIST(24, zzqy.VECTOR, zzrm.INT),
    BOOL_LIST(25, zzqy.VECTOR, zzrm.BOOLEAN),
    STRING_LIST(26, zzqy.VECTOR, zzrm.STRING),
    MESSAGE_LIST(27, zzqy.VECTOR, zzrm.MESSAGE),
    BYTES_LIST(28, zzqy.VECTOR, zzrm.BYTE_STRING),
    UINT32_LIST(29, zzqy.VECTOR, zzrm.INT),
    ENUM_LIST(30, zzqy.VECTOR, zzrm.ENUM),
    SFIXED32_LIST(31, zzqy.VECTOR, zzrm.INT),
    SFIXED64_LIST(32, zzqy.VECTOR, zzrm.LONG),
    SINT32_LIST(33, zzqy.VECTOR, zzrm.INT),
    SINT64_LIST(34, zzqy.VECTOR, zzrm.LONG),
    DOUBLE_LIST_PACKED(35, zzqy.PACKED_VECTOR, zzrm.DOUBLE),
    FLOAT_LIST_PACKED(36, zzqy.PACKED_VECTOR, zzrm.FLOAT),
    INT64_LIST_PACKED(37, zzqy.PACKED_VECTOR, zzrm.LONG),
    UINT64_LIST_PACKED(38, zzqy.PACKED_VECTOR, zzrm.LONG),
    INT32_LIST_PACKED(39, zzqy.PACKED_VECTOR, zzrm.INT),
    FIXED64_LIST_PACKED(40, zzqy.PACKED_VECTOR, zzrm.LONG),
    FIXED32_LIST_PACKED(41, zzqy.PACKED_VECTOR, zzrm.INT),
    BOOL_LIST_PACKED(42, zzqy.PACKED_VECTOR, zzrm.BOOLEAN),
    UINT32_LIST_PACKED(43, zzqy.PACKED_VECTOR, zzrm.INT),
    ENUM_LIST_PACKED(44, zzqy.PACKED_VECTOR, zzrm.ENUM),
    SFIXED32_LIST_PACKED(45, zzqy.PACKED_VECTOR, zzrm.INT),
    SFIXED64_LIST_PACKED(46, zzqy.PACKED_VECTOR, zzrm.LONG),
    SINT32_LIST_PACKED(47, zzqy.PACKED_VECTOR, zzrm.INT),
    SINT64_LIST_PACKED(48, zzqy.PACKED_VECTOR, zzrm.LONG),
    GROUP_LIST(49, zzqy.VECTOR, zzrm.MESSAGE),
    MAP(50, zzqy.MAP, zzrm.VOID);

    private static final zzqw[] X;
    private static final Type[] Y = new Type[0];
    private final int id;
    private final zzrm zzazr;
    private final zzqy zzazs;
    private final Class<?> zzazt;
    private final boolean zzazu;

    zzqw(int i, zzqy zzqyVar, zzrm zzrmVar) {
        this.id = i;
        this.zzazs = zzqyVar;
        this.zzazr = zzrmVar;
        switch (zzqyVar) {
            case MAP:
                this.zzazt = zzrmVar.zzpx();
                break;
            case VECTOR:
                this.zzazt = zzrmVar.zzpx();
                break;
            default:
                this.zzazt = null;
                break;
        }
        boolean z = false;
        if (zzqyVar == zzqy.SCALAR) {
            switch (zzrmVar) {
                case BYTE_STRING:
                case MESSAGE:
                case STRING:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.zzazu = z;
    }

    public final int id() {
        return this.id;
    }

    static {
        zzqw[] values = values();
        X = new zzqw[values.length];
        for (zzqw zzqwVar : values) {
            X[zzqwVar.id] = zzqwVar;
        }
    }
}
