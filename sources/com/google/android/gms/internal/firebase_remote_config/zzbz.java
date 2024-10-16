package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class zzbz {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Field, zzbz> f4143a = new WeakHashMap();
    private final boolean b;
    private final Field c;
    private final String d;

    public static zzbz zza(Enum<?> r5) {
        try {
            zzbz zza = zza(r5.getClass().getField(r5.name()));
            Object[] objArr = {r5};
            if (zza != null) {
                return zza;
            }
            throw new IllegalArgumentException(zzdy.zza("enum constant missing @Value or @NullValue annotation: %s", objArr));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static zzbz zza(Field field) {
        String str = null;
        if (field == null) {
            return null;
        }
        synchronized (f4143a) {
            zzbz zzbzVar = f4143a.get(field);
            boolean isEnumConstant = field.isEnumConstant();
            if (zzbzVar == null && (isEnumConstant || !Modifier.isStatic(field.getModifiers()))) {
                if (isEnumConstant) {
                    zzcp zzcpVar = (zzcp) field.getAnnotation(zzcp.class);
                    if (zzcpVar != null) {
                        str = zzcpVar.value();
                    } else if (((zzcf) field.getAnnotation(zzcf.class)) == null) {
                        return null;
                    }
                } else {
                    zzcc zzccVar = (zzcc) field.getAnnotation(zzcc.class);
                    if (zzccVar == null) {
                        return null;
                    }
                    str = zzccVar.value();
                    field.setAccessible(true);
                }
                if ("##default".equals(str)) {
                    str = field.getName();
                }
                zzbzVar = new zzbz(field, str);
                f4143a.put(field, zzbzVar);
            }
            return zzbzVar;
        }
    }

    private zzbz(Field field, String str) {
        this.c = field;
        this.d = str == null ? null : str.intern();
        this.b = zzbt.zza(this.c.getType());
    }

    public final Field zzbz() {
        return this.c;
    }

    public final String getName() {
        return this.d;
    }

    public final Type getGenericType() {
        return this.c.getGenericType();
    }

    public final boolean zzca() {
        return Modifier.isFinal(this.c.getModifiers());
    }

    public final boolean isPrimitive() {
        return this.b;
    }

    public final Object zzh(Object obj) {
        return a(this.c, obj);
    }

    public final void zzb(Object obj, Object obj2) {
        zza(this.c, obj, obj2);
    }

    public final <T extends Enum<T>> T zzcb() {
        return (T) Enum.valueOf(this.c.getDeclaringClass(), this.c.getName());
    }

    private static Object a(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void zza(Field field, Object obj, Object obj2) {
        if (Modifier.isFinal(field.getModifiers())) {
            Object a2 = a(field, obj);
            if (obj2 == null) {
                if (a2 == null) {
                    return;
                }
            } else if (obj2.equals(a2)) {
                return;
            }
            String valueOf = String.valueOf(a2);
            String valueOf2 = String.valueOf(obj2);
            String name = field.getName();
            String name2 = obj.getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48 + String.valueOf(valueOf2).length() + String.valueOf(name).length() + String.valueOf(name2).length());
            sb.append("expected final value <");
            sb.append(valueOf);
            sb.append("> but was <");
            sb.append(valueOf2);
            sb.append("> on ");
            sb.append(name);
            sb.append(" field in ");
            sb.append(name2);
            throw new IllegalArgumentException(sb.toString());
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (SecurityException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
