package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class zzbt {

    /* renamed from: a, reason: collision with root package name */
    private static final Boolean f4137a = new Boolean(true);
    private static final String b = new String();
    private static final Character c = new Character(0);
    private static final Byte d = new Byte((byte) 0);
    private static final Short e = new Short((short) 0);
    private static final Integer f = new Integer(0);
    private static final Float g = new Float(0.0f);
    private static final Long h = new Long(0);
    private static final Double i = new Double(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final BigInteger j = new BigInteger("0");
    private static final BigDecimal k = new BigDecimal("0");
    private static final zzbw l = new zzbw(0);
    private static final ConcurrentHashMap<Class<?>, Object> m;

    public static <T> T zzd(Class<?> cls) {
        Object obj = (T) m.get(cls);
        if (obj == null) {
            synchronized (m) {
                obj = m.get(cls);
                if (obj == null) {
                    int i2 = 0;
                    if (cls.isArray()) {
                        Class<?> cls2 = cls;
                        do {
                            cls2 = cls2.getComponentType();
                            i2++;
                        } while (cls2.isArray());
                        obj = (T) Array.newInstance(cls2, new int[i2]);
                    } else if (cls.isEnum()) {
                        zzbz zzae = zzbr.zzc(cls).zzae(null);
                        Object[] objArr = {cls};
                        if (zzae == null) {
                            throw new NullPointerException(zzdy.zza("enum missing constant with @NullValue annotation: %s", objArr));
                        }
                        obj = zzae.zzcb();
                    } else {
                        obj = zzco.zzf((Class<Object>) cls);
                    }
                    m.put(cls, obj);
                }
            }
        }
        return (T) obj;
    }

    public static boolean isNull(Object obj) {
        return obj != null && obj == m.get(obj.getClass());
    }

    public static Map<String, Object> zzf(Object obj) {
        if (obj == null || isNull(obj)) {
            return Collections.emptyMap();
        }
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new l(obj, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T clone(T t) {
        T t2;
        if (t == 0 || zza(t.getClass())) {
            return t;
        }
        if (t instanceof zzby) {
            return (T) ((zzby) ((zzby) t).clone());
        }
        Class<?> cls = t.getClass();
        if (cls.isArray()) {
            t2 = (T) Array.newInstance(cls.getComponentType(), Array.getLength(t));
        } else if (t instanceof zzbl) {
            t2 = (T) ((zzbl) ((zzbl) t).clone());
        } else {
            if ("java.util.Arrays$ArrayList".equals(cls.getName())) {
                Object[] array = ((List) t).toArray();
                zza(array, array);
                return (T) Arrays.asList(array);
            }
            t2 = (T) zzco.zzf((Class) cls);
        }
        zza(t, t2);
        return t2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zza(Object obj, Object obj2) {
        Class<?> cls = obj.getClass();
        int i2 = 0;
        if (!(cls == obj2.getClass())) {
            throw new IllegalArgumentException();
        }
        if (cls.isArray()) {
            if (!(Array.getLength(obj) == Array.getLength(obj2))) {
                throw new IllegalArgumentException();
            }
            Iterator it = zzco.zzi(obj).iterator();
            while (it.hasNext()) {
                Array.set(obj2, i2, clone(it.next()));
                i2++;
            }
            return;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            Collection collection = (Collection) obj;
            if (ArrayList.class.isAssignableFrom(cls)) {
                ((ArrayList) obj2).ensureCapacity(collection.size());
            }
            Collection collection2 = (Collection) obj2;
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                collection2.add(clone(it2.next()));
            }
            return;
        }
        boolean isAssignableFrom = zzby.class.isAssignableFrom(cls);
        if (isAssignableFrom || !Map.class.isAssignableFrom(cls)) {
            zzbr zzc = isAssignableFrom ? ((zzby) obj).b : zzbr.zzc(cls);
            Iterator<String> it3 = zzc.f4136a.iterator();
            while (it3.hasNext()) {
                zzbz zzae = zzc.zzae(it3.next());
                if (!zzae.zzca() && (!isAssignableFrom || !zzae.isPrimitive())) {
                    Object zzh = zzae.zzh(obj);
                    if (zzh != null) {
                        zzae.zzb(obj2, clone(zzh));
                    }
                }
            }
            return;
        }
        if (zzbl.class.isAssignableFrom(cls)) {
            zzbl zzblVar = (zzbl) obj2;
            zzbl zzblVar2 = (zzbl) obj;
            int size = zzblVar2.size();
            while (i2 < size) {
                zzblVar.set(i2, clone(zzblVar2.zzg(i2)));
                i2++;
            }
            return;
        }
        Map map = (Map) obj2;
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            map.put((String) entry.getKey(), clone(entry.getValue()));
        }
    }

    public static boolean zza(Type type) {
        if (type instanceof WildcardType) {
            type = zzco.zza((WildcardType) type);
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Class cls = (Class) type;
        return cls.isPrimitive() || cls == Character.class || cls == String.class || cls == Integer.class || cls == Long.class || cls == Short.class || cls == Byte.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == zzbw.class || cls == Boolean.class;
    }

    public static boolean zzg(Object obj) {
        return obj == null || zza(obj.getClass());
    }

    public static Object zza(Type type, String str) {
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || cls != null) {
            if (cls == Void.class) {
                return null;
            }
            if (str == null || cls == null || cls.isAssignableFrom(String.class)) {
                return str;
            }
            if (cls == Character.class || cls == Character.TYPE) {
                if (str.length() != 1) {
                    String valueOf = String.valueOf(cls);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 37);
                    sb.append("expected type Character/char but got ");
                    sb.append(valueOf);
                    throw new IllegalArgumentException(sb.toString());
                }
                return Character.valueOf(str.charAt(0));
            }
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return Boolean.valueOf(str);
            }
            if (cls == Byte.class || cls == Byte.TYPE) {
                return Byte.valueOf(str);
            }
            if (cls == Short.class || cls == Short.TYPE) {
                return Short.valueOf(str);
            }
            if (cls == Integer.class || cls == Integer.TYPE) {
                return Integer.valueOf(str);
            }
            if (cls == Long.class || cls == Long.TYPE) {
                return Long.valueOf(str);
            }
            if (cls == Float.class || cls == Float.TYPE) {
                return Float.valueOf(str);
            }
            if (cls == Double.class || cls == Double.TYPE) {
                return Double.valueOf(str);
            }
            if (cls == zzbw.class) {
                return zzbw.zzaf(str);
            }
            if (cls == BigInteger.class) {
                return new BigInteger(str);
            }
            if (cls == BigDecimal.class) {
                return new BigDecimal(str);
            }
            if (cls.isEnum()) {
                if (!zzbr.zzc(cls).f4136a.contains(str)) {
                    throw new IllegalArgumentException(String.format("given enum name %s not part of enumeration", str));
                }
                return zzbr.zzc(cls).zzae(str).zzcb();
            }
        }
        String valueOf2 = String.valueOf(type);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 35);
        sb2.append("expected primitive class, but got: ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static Collection<Object> zzb(Type type) {
        if (type instanceof WildcardType) {
            type = zzco.zza((WildcardType) type);
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || (type instanceof GenericArrayType) || (cls != null && (cls.isArray() || cls.isAssignableFrom(ArrayList.class)))) {
            return new ArrayList();
        }
        if (cls == null) {
            String valueOf = String.valueOf(type);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
            sb.append("unable to create new instance of type: ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        }
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        return (Collection) zzco.zzf(cls);
    }

    public static Map<String, Object> zze(Class<?> cls) {
        if (cls == null || cls.isAssignableFrom(zzbl.class)) {
            return new zzbl();
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return new TreeMap();
        }
        return (Map) zzco.zzf((Class) cls);
    }

    public static Type zza(List<Type> list, Type type) {
        if (type instanceof WildcardType) {
            type = zzco.zza((WildcardType) type);
        }
        while (type instanceof TypeVariable) {
            Type zza = zzco.zza(list, (TypeVariable<?>) type);
            if (zza != null) {
                type = zza;
            }
            if (type instanceof TypeVariable) {
                type = ((TypeVariable) type).getBounds()[0];
            }
        }
        return type;
    }

    static {
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = new ConcurrentHashMap<>();
        m = concurrentHashMap;
        concurrentHashMap.put(Boolean.class, f4137a);
        m.put(String.class, b);
        m.put(Character.class, c);
        m.put(Byte.class, d);
        m.put(Short.class, e);
        m.put(Integer.class, f);
        m.put(Float.class, g);
        m.put(Long.class, h);
        m.put(Double.class, i);
        m.put(BigInteger.class, j);
        m.put(BigDecimal.class, k);
        m.put(zzbw.class, l);
    }
}
