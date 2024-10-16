package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum zzdnv {
    DOUBLE(0, zzdnx.SCALAR, zzdom.DOUBLE),
    FLOAT(1, zzdnx.SCALAR, zzdom.FLOAT),
    INT64(2, zzdnx.SCALAR, zzdom.LONG),
    UINT64(3, zzdnx.SCALAR, zzdom.LONG),
    INT32(4, zzdnx.SCALAR, zzdom.INT),
    FIXED64(5, zzdnx.SCALAR, zzdom.LONG),
    FIXED32(6, zzdnx.SCALAR, zzdom.INT),
    BOOL(7, zzdnx.SCALAR, zzdom.BOOLEAN),
    STRING(8, zzdnx.SCALAR, zzdom.STRING),
    MESSAGE(9, zzdnx.SCALAR, zzdom.MESSAGE),
    BYTES(10, zzdnx.SCALAR, zzdom.BYTE_STRING),
    UINT32(11, zzdnx.SCALAR, zzdom.INT),
    ENUM(12, zzdnx.SCALAR, zzdom.ENUM),
    SFIXED32(13, zzdnx.SCALAR, zzdom.INT),
    SFIXED64(14, zzdnx.SCALAR, zzdom.LONG),
    SINT32(15, zzdnx.SCALAR, zzdom.INT),
    SINT64(16, zzdnx.SCALAR, zzdom.LONG),
    GROUP(17, zzdnx.SCALAR, zzdom.MESSAGE),
    DOUBLE_LIST(18, zzdnx.VECTOR, zzdom.DOUBLE),
    FLOAT_LIST(19, zzdnx.VECTOR, zzdom.FLOAT),
    INT64_LIST(20, zzdnx.VECTOR, zzdom.LONG),
    UINT64_LIST(21, zzdnx.VECTOR, zzdom.LONG),
    INT32_LIST(22, zzdnx.VECTOR, zzdom.INT),
    FIXED64_LIST(23, zzdnx.VECTOR, zzdom.LONG),
    FIXED32_LIST(24, zzdnx.VECTOR, zzdom.INT),
    BOOL_LIST(25, zzdnx.VECTOR, zzdom.BOOLEAN),
    STRING_LIST(26, zzdnx.VECTOR, zzdom.STRING),
    MESSAGE_LIST(27, zzdnx.VECTOR, zzdom.MESSAGE),
    BYTES_LIST(28, zzdnx.VECTOR, zzdom.BYTE_STRING),
    UINT32_LIST(29, zzdnx.VECTOR, zzdom.INT),
    ENUM_LIST(30, zzdnx.VECTOR, zzdom.ENUM),
    SFIXED32_LIST(31, zzdnx.VECTOR, zzdom.INT),
    SFIXED64_LIST(32, zzdnx.VECTOR, zzdom.LONG),
    SINT32_LIST(33, zzdnx.VECTOR, zzdom.INT),
    SINT64_LIST(34, zzdnx.VECTOR, zzdom.LONG),
    DOUBLE_LIST_PACKED(35, zzdnx.PACKED_VECTOR, zzdom.DOUBLE),
    FLOAT_LIST_PACKED(36, zzdnx.PACKED_VECTOR, zzdom.FLOAT),
    INT64_LIST_PACKED(37, zzdnx.PACKED_VECTOR, zzdom.LONG),
    UINT64_LIST_PACKED(38, zzdnx.PACKED_VECTOR, zzdom.LONG),
    INT32_LIST_PACKED(39, zzdnx.PACKED_VECTOR, zzdom.INT),
    FIXED64_LIST_PACKED(40, zzdnx.PACKED_VECTOR, zzdom.LONG),
    FIXED32_LIST_PACKED(41, zzdnx.PACKED_VECTOR, zzdom.INT),
    BOOL_LIST_PACKED(42, zzdnx.PACKED_VECTOR, zzdom.BOOLEAN),
    UINT32_LIST_PACKED(43, zzdnx.PACKED_VECTOR, zzdom.INT),
    ENUM_LIST_PACKED(44, zzdnx.PACKED_VECTOR, zzdom.ENUM),
    SFIXED32_LIST_PACKED(45, zzdnx.PACKED_VECTOR, zzdom.INT),
    SFIXED64_LIST_PACKED(46, zzdnx.PACKED_VECTOR, zzdom.LONG),
    SINT32_LIST_PACKED(47, zzdnx.PACKED_VECTOR, zzdom.INT),
    SINT64_LIST_PACKED(48, zzdnx.PACKED_VECTOR, zzdom.LONG),
    GROUP_LIST(49, zzdnx.VECTOR, zzdom.MESSAGE),
    MAP(50, zzdnx.MAP, zzdom.VOID);

    private static final zzdnv[] X;
    private static final Type[] Y = new Type[0];
    private final int id;
    private final zzdom zzhgk;
    private final zzdnx zzhgl;
    private final Class<?> zzhgm;
    private final boolean zzhgn;

    zzdnv(int i, zzdnx zzdnxVar, zzdom zzdomVar) {
        this.id = i;
        this.zzhgl = zzdnxVar;
        this.zzhgk = zzdomVar;
        switch (zzdnxVar) {
            case MAP:
                this.zzhgm = zzdomVar.zzayl();
                break;
            case VECTOR:
                this.zzhgm = zzdomVar.zzayl();
                break;
            default:
                this.zzhgm = null;
                break;
        }
        boolean z = false;
        if (zzdnxVar == zzdnx.SCALAR) {
            switch (zzdomVar) {
                case BYTE_STRING:
                case MESSAGE:
                case STRING:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.zzhgn = z;
    }

    public final int id() {
        return this.id;
    }

    static {
        zzdnv[] values = values();
        X = new zzdnv[values.length];
        for (zzdnv zzdnvVar : values) {
            X[zzdnvVar.id] = zzdnvVar;
        }
    }
}
