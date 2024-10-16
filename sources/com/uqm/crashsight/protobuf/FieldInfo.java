package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
final class FieldInfo implements Comparable<FieldInfo> {

    /* renamed from: a, reason: collision with root package name */
    private final Field f6700a;
    private final FieldType b;
    private final Class<?> c;
    private final int d;
    private final Field e;
    private final int f;
    private final boolean g;
    private final boolean h;
    private final ai i;
    private final Field j;
    private final Class<?> k;
    private final Object l;
    private final Internal.EnumVerifier m;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(FieldInfo fieldInfo) {
        return this.d - fieldInfo.d;
    }

    public static FieldInfo a(Field field, int i, FieldType fieldType, boolean z) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
        Internal.a(field, "field");
        Internal.a(fieldType, "fieldType");
        if (fieldType == FieldType.MESSAGE_LIST || fieldType == FieldType.GROUP_LIST) {
            throw new IllegalStateException("Shouldn't be called for repeated message fields.");
        }
        return new FieldInfo(field, i, fieldType, null, null, 0, false, z, null, null, null, null, null);
    }

    public static FieldInfo a(Field field, int i, FieldType fieldType, Field field2) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
        Internal.a(field, "field");
        Internal.a(fieldType, "fieldType");
        if (fieldType == FieldType.MESSAGE_LIST || fieldType == FieldType.GROUP_LIST) {
            throw new IllegalStateException("Shouldn't be called for repeated message fields.");
        }
        return new FieldInfo(field, i, fieldType, null, null, 0, false, false, null, null, null, null, field2);
    }

    public static FieldInfo a(Field field, int i, FieldType fieldType, Class<?> cls) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
        Internal.a(field, "field");
        Internal.a(fieldType, "fieldType");
        Internal.a(cls, "messageClass");
        return new FieldInfo(field, i, fieldType, cls, null, 0, false, false, null, null, null, null, null);
    }

    public static FieldInfo a(Field field, int i, FieldType fieldType, Internal.EnumVerifier enumVerifier) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
        Internal.a(field, "field");
        return new FieldInfo(field, i, fieldType, null, null, 0, false, false, null, null, null, enumVerifier, null);
    }

    public static FieldInfo a(Field field, int i, FieldType fieldType, Internal.EnumVerifier enumVerifier, Field field2) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
        Internal.a(field, "field");
        return new FieldInfo(field, i, fieldType, null, null, 0, false, false, null, null, null, enumVerifier, field2);
    }

    public static FieldInfo a(Field field, int i, FieldType fieldType, Field field2, int i2, boolean z, Internal.EnumVerifier enumVerifier) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
        Internal.a(field, "field");
        Internal.a(fieldType, "fieldType");
        Internal.a(field2, "presenceField");
        if (field2 != null) {
            if (!(i2 != 0 && ((i2 + (-1)) & i2) == 0)) {
                throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i2);
            }
        }
        return new FieldInfo(field, i, fieldType, null, field2, i2, false, z, null, null, null, enumVerifier, null);
    }

    public static FieldInfo a(int i, FieldType fieldType, ai aiVar, Class<?> cls, boolean z, Internal.EnumVerifier enumVerifier) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
        Internal.a(fieldType, "fieldType");
        Internal.a(aiVar, "oneof");
        Internal.a(cls, "oneofStoredType");
        if (!fieldType.c()) {
            throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i + " is of type " + fieldType);
        }
        return new FieldInfo(null, i, fieldType, null, null, 0, false, z, aiVar, cls, null, enumVerifier, null);
    }

    public static FieldInfo b(Field field, int i, FieldType fieldType, Field field2, int i2, boolean z, Internal.EnumVerifier enumVerifier) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
        Internal.a(field, "field");
        Internal.a(fieldType, "fieldType");
        Internal.a(field2, "presenceField");
        if (field2 != null) {
            if (!(i2 != 0 && ((i2 + (-1)) & i2) == 0)) {
                throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i2);
            }
        }
        return new FieldInfo(field, i, fieldType, null, field2, i2, true, z, null, null, null, enumVerifier, null);
    }

    public static FieldInfo a(Field field, int i, Object obj, Internal.EnumVerifier enumVerifier) {
        Internal.a(obj, "mapDefaultEntry");
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
        Internal.a(field, "field");
        return new FieldInfo(field, i, FieldType.MAP, null, null, 0, false, true, null, null, obj, enumVerifier, null);
    }

    private FieldInfo(Field field, int i, FieldType fieldType, Class<?> cls, Field field2, int i2, boolean z, boolean z2, ai aiVar, Class<?> cls2, Object obj, Internal.EnumVerifier enumVerifier, Field field3) {
        this.f6700a = field;
        this.b = fieldType;
        this.c = cls;
        this.d = i;
        this.e = field2;
        this.f = i2;
        this.g = z;
        this.h = z2;
        this.i = aiVar;
        this.k = cls2;
        this.l = obj;
        this.m = enumVerifier;
        this.j = field3;
    }

    public final int a() {
        return this.d;
    }

    public final Field b() {
        return this.f6700a;
    }

    public final FieldType c() {
        return this.b;
    }

    public final ai d() {
        return this.i;
    }

    public final Internal.EnumVerifier e() {
        return this.m;
    }

    public final Field f() {
        return this.e;
    }

    public final Object g() {
        return this.l;
    }

    public final int h() {
        return this.f;
    }

    public final boolean i() {
        return this.g;
    }

    public final boolean j() {
        return this.h;
    }

    public final Field k() {
        return this.j;
    }

    public final Class<?> l() {
        switch (this.b) {
            case MESSAGE:
            case GROUP:
                Field field = this.f6700a;
                return field != null ? field.getType() : this.k;
            case MESSAGE_LIST:
            case GROUP_LIST:
                return this.c;
            default:
                return null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private Builder() {
        }
    }
}
