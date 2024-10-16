package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzco {
    private static ParameterizedType a(Type type, Class<?> cls) {
        Class<?> cls2;
        if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
            return null;
        }
        while (type != null && type != Object.class) {
            if (type instanceof Class) {
                cls2 = (Class) type;
            } else {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class<?> zza = zza(parameterizedType);
                if (zza == cls) {
                    return parameterizedType;
                }
                if (cls.isInterface()) {
                    for (Type type2 : zza.getGenericInterfaces()) {
                        if (cls.isAssignableFrom(type2 instanceof Class ? (Class) type2 : zza((ParameterizedType) type2))) {
                            type = type2;
                            break;
                        }
                    }
                }
                cls2 = zza;
            }
            type = cls2.getGenericSuperclass();
        }
        return null;
    }

    public static boolean zza(Class<?> cls, Class<?> cls2) {
        return cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls);
    }

    public static <T> T zzf(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw a((Exception) e, (Class<?>) cls);
        } catch (InstantiationException e2) {
            throw a((Exception) e2, (Class<?>) cls);
        }
    }

    private static IllegalArgumentException a(Exception exc, Class<?> cls) {
        StringBuilder sb = new StringBuilder("unable to create new instance of class ");
        sb.append(cls.getName());
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (cls.isArray()) {
            arrayList.add("because it is an array");
        } else if (cls.isPrimitive()) {
            arrayList.add("because it is primitive");
        } else if (cls == Void.class) {
            arrayList.add("because it is void");
        } else {
            if (Modifier.isInterface(cls.getModifiers())) {
                arrayList.add("because it is an interface");
            } else if (Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add("because it is abstract");
            }
            if (cls.getEnclosingClass() != null && !Modifier.isStatic(cls.getModifiers())) {
                arrayList.add("because it is not static");
            }
            if (!Modifier.isPublic(cls.getModifiers())) {
                arrayList.add("possibly because it is not public");
            } else {
                try {
                    cls.getConstructor(new Class[0]);
                } catch (NoSuchMethodException unused) {
                    arrayList.add("because it has no accessible default constructor");
                }
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        boolean z = false;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            String str = (String) obj;
            if (z) {
                sb.append(" and");
            } else {
                z = true;
            }
            sb.append(" ");
            sb.append(str);
        }
        return new IllegalArgumentException(sb.toString(), exc);
    }

    public static boolean zzc(Type type) {
        if (type instanceof GenericArrayType) {
            return true;
        }
        return (type instanceof Class) && ((Class) type).isArray();
    }

    public static Type zzd(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Class<?> zza(ParameterizedType parameterizedType) {
        return (Class) parameterizedType.getRawType();
    }

    public static Type zza(WildcardType wildcardType) {
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (lowerBounds.length != 0) {
            return lowerBounds[0];
        }
        return wildcardType.getUpperBounds()[0];
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.GenericDeclaration] */
    public static Type zza(List<Type> list, TypeVariable<?> typeVariable) {
        Type zza;
        ?? genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            Class cls = (Class) genericDeclaration;
            int size = list.size();
            ParameterizedType parameterizedType = null;
            while (parameterizedType == null) {
                size--;
                if (size < 0) {
                    break;
                }
                parameterizedType = a(list.get(size), (Class<?>) cls);
            }
            if (parameterizedType != null) {
                TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                int i = 0;
                while (i < typeParameters.length && !typeParameters[i].equals(typeVariable)) {
                    i++;
                }
                Type type = parameterizedType.getActualTypeArguments()[i];
                return (!(type instanceof TypeVariable) || (zza = zza(list, (TypeVariable<?>) type)) == null) ? type : zza;
            }
        }
        return null;
    }

    public static Class<?> zzb(List<Type> list, Type type) {
        if (type instanceof TypeVariable) {
            type = zza(list, (TypeVariable<?>) type);
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(zzb(list, zzd(type)), 0).getClass();
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return zza((ParameterizedType) type);
        }
        zzch.checkArgument(type == null, "wildcard type is not supported: %s", type);
        return Object.class;
    }

    public static Type zze(Type type) {
        return a(type, Iterable.class, 0);
    }

    public static Type zzf(Type type) {
        return a(type, Map.class, 1);
    }

    private static Type a(Type type, Class<?> cls, int i) {
        Type zza;
        ParameterizedType a2 = a(type, cls);
        if (a2 == null) {
            return null;
        }
        Type type2 = a2.getActualTypeArguments()[i];
        return (!(type2 instanceof TypeVariable) || (zza = zza((List<Type>) Arrays.asList(type), (TypeVariable<?>) type2)) == null) ? type2 : zza;
    }

    public static <T> Iterable<T> zzi(Object obj) {
        if (obj instanceof Iterable) {
            return (Iterable) obj;
        }
        Class<?> cls = obj.getClass();
        zzch.checkArgument(cls.isArray(), "not an array or Iterable: %s", cls);
        if (!cls.getComponentType().isPrimitive()) {
            return Arrays.asList((Object[]) obj);
        }
        return new q(obj);
    }

    public static Object zza(Collection<?> collection, Class<?> cls) {
        if (cls.isPrimitive()) {
            Object newInstance = Array.newInstance(cls, collection.size());
            int i = 0;
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                Array.set(newInstance, i, it.next());
                i++;
            }
            return newInstance;
        }
        return collection.toArray((Object[]) Array.newInstance(cls, collection.size()));
    }
}
