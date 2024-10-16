package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum zzhb {
    DOUBLE(0, zzhd.SCALAR, zzho.DOUBLE),
    FLOAT(1, zzhd.SCALAR, zzho.FLOAT),
    INT64(2, zzhd.SCALAR, zzho.LONG),
    UINT64(3, zzhd.SCALAR, zzho.LONG),
    INT32(4, zzhd.SCALAR, zzho.INT),
    FIXED64(5, zzhd.SCALAR, zzho.LONG),
    FIXED32(6, zzhd.SCALAR, zzho.INT),
    BOOL(7, zzhd.SCALAR, zzho.BOOLEAN),
    STRING(8, zzhd.SCALAR, zzho.STRING),
    MESSAGE(9, zzhd.SCALAR, zzho.MESSAGE),
    BYTES(10, zzhd.SCALAR, zzho.BYTE_STRING),
    UINT32(11, zzhd.SCALAR, zzho.INT),
    ENUM(12, zzhd.SCALAR, zzho.ENUM),
    SFIXED32(13, zzhd.SCALAR, zzho.INT),
    SFIXED64(14, zzhd.SCALAR, zzho.LONG),
    SINT32(15, zzhd.SCALAR, zzho.INT),
    SINT64(16, zzhd.SCALAR, zzho.LONG),
    GROUP(17, zzhd.SCALAR, zzho.MESSAGE),
    DOUBLE_LIST(18, zzhd.VECTOR, zzho.DOUBLE),
    FLOAT_LIST(19, zzhd.VECTOR, zzho.FLOAT),
    INT64_LIST(20, zzhd.VECTOR, zzho.LONG),
    UINT64_LIST(21, zzhd.VECTOR, zzho.LONG),
    INT32_LIST(22, zzhd.VECTOR, zzho.INT),
    FIXED64_LIST(23, zzhd.VECTOR, zzho.LONG),
    FIXED32_LIST(24, zzhd.VECTOR, zzho.INT),
    BOOL_LIST(25, zzhd.VECTOR, zzho.BOOLEAN),
    STRING_LIST(26, zzhd.VECTOR, zzho.STRING),
    MESSAGE_LIST(27, zzhd.VECTOR, zzho.MESSAGE),
    BYTES_LIST(28, zzhd.VECTOR, zzho.BYTE_STRING),
    UINT32_LIST(29, zzhd.VECTOR, zzho.INT),
    ENUM_LIST(30, zzhd.VECTOR, zzho.ENUM),
    SFIXED32_LIST(31, zzhd.VECTOR, zzho.INT),
    SFIXED64_LIST(32, zzhd.VECTOR, zzho.LONG),
    SINT32_LIST(33, zzhd.VECTOR, zzho.INT),
    SINT64_LIST(34, zzhd.VECTOR, zzho.LONG),
    DOUBLE_LIST_PACKED(35, zzhd.PACKED_VECTOR, zzho.DOUBLE),
    FLOAT_LIST_PACKED(36, zzhd.PACKED_VECTOR, zzho.FLOAT),
    INT64_LIST_PACKED(37, zzhd.PACKED_VECTOR, zzho.LONG),
    UINT64_LIST_PACKED(38, zzhd.PACKED_VECTOR, zzho.LONG),
    INT32_LIST_PACKED(39, zzhd.PACKED_VECTOR, zzho.INT),
    FIXED64_LIST_PACKED(40, zzhd.PACKED_VECTOR, zzho.LONG),
    FIXED32_LIST_PACKED(41, zzhd.PACKED_VECTOR, zzho.INT),
    BOOL_LIST_PACKED(42, zzhd.PACKED_VECTOR, zzho.BOOLEAN),
    UINT32_LIST_PACKED(43, zzhd.PACKED_VECTOR, zzho.INT),
    ENUM_LIST_PACKED(44, zzhd.PACKED_VECTOR, zzho.ENUM),
    SFIXED32_LIST_PACKED(45, zzhd.PACKED_VECTOR, zzho.INT),
    SFIXED64_LIST_PACKED(46, zzhd.PACKED_VECTOR, zzho.LONG),
    SINT32_LIST_PACKED(47, zzhd.PACKED_VECTOR, zzho.INT),
    SINT64_LIST_PACKED(48, zzhd.PACKED_VECTOR, zzho.LONG),
    GROUP_LIST(49, zzhd.VECTOR, zzho.MESSAGE),
    MAP(50, zzhd.MAP, zzho.VOID);

    private static final zzhb[] X;
    private static final Type[] Y = new Type[0];
    private final int id;
    private final zzho zzsl;
    private final zzhd zzsm;
    private final Class<?> zzsn;
    private final boolean zzso;

    zzhb(int i, zzhd zzhdVar, zzho zzhoVar) {
        this.id = i;
        this.zzsm = zzhdVar;
        this.zzsl = zzhoVar;
        switch (zzhdVar) {
            case MAP:
                this.zzsn = zzhoVar.zzhn();
                break;
            case VECTOR:
                this.zzsn = zzhoVar.zzhn();
                break;
            default:
                this.zzsn = null;
                break;
        }
        boolean z = false;
        if (zzhdVar == zzhd.SCALAR) {
            switch (zzhoVar) {
                case BYTE_STRING:
                case MESSAGE:
                case STRING:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.zzso = z;
    }

    public final int id() {
        return this.id;
    }

    static {
        zzhb[] values = values();
        X = new zzhb[values.length];
        for (zzhb zzhbVar : values) {
            X[zzhbVar.id] = zzhbVar;
        }
    }
}
