package a;

import com.amazonaws.services.s3.internal.Constants;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import okhttp3.ac;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    static final Type[] f53a = new Type[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> a(Type type) {
        if (type == null) {
            throw new NullPointerException("type == null");
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (!(rawType instanceof Class)) {
                throw new IllegalArgumentException();
            }
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(a(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return a(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    static boolean a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    static String b(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (!cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException();
        }
        return a(type, cls, a(type, cls, cls2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Type a(Type type, Class<?> cls, Type type2) {
        while (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type a2 = a(type, cls, (TypeVariable<?>) typeVariable);
            if (a2 == typeVariable) {
                return a2;
            }
            type2 = a2;
        }
        if (type2 instanceof Class) {
            Class cls2 = (Class) type2;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type a3 = a(type, cls, (Type) componentType);
                return componentType == a3 ? cls2 : new a(a3);
            }
        }
        if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type a4 = a(type, cls, genericComponentType);
            return genericComponentType == a4 ? genericArrayType : new a(a4);
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type a5 = a(type, cls, ownerType);
            boolean z = a5 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i = 0; i < length; i++) {
                Type a6 = a(type, cls, actualTypeArguments[i]);
                if (a6 != actualTypeArguments[i]) {
                    if (!z) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z = true;
                    }
                    actualTypeArguments[i] = a6;
                }
            }
            return z ? new b(a5, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        if (!(type2 instanceof WildcardType)) {
            return type2;
        }
        WildcardType wildcardType = (WildcardType) type2;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (lowerBounds.length == 1) {
            Type a7 = a(type, cls, lowerBounds[0]);
            if (a7 != lowerBounds[0]) {
                return new c(new Type[]{Object.class}, new Type[]{a7});
            }
        } else if (upperBounds.length == 1) {
            Type a8 = a(type, cls, upperBounds[0]);
            if (a8 != upperBounds[0]) {
                return new c(new Type[]{a8}, f53a);
            }
        }
        return wildcardType;
    }

    private static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> a2 = a(typeVariable);
        if (a2 == null) {
            return typeVariable;
        }
        Type a3 = a(type, cls, a2);
        if (!(a3 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a3).getActualTypeArguments()[a((Object[]) a2.getTypeParameters(), (Object) typeVariable)];
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static void c(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ac a(ac acVar) throws IOException {
        okio.c cVar = new okio.c();
        acVar.d().a(cVar);
        return ac.a(acVar.a(), acVar.b(), cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        if (cls.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type a(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i < 0 || i >= actualTypeArguments.length) {
            throw new IllegalArgumentException("Index " + i + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
        }
        Type type = actualTypeArguments[i];
        return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean d(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (d(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return d(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? Constants.NULL_VERSION_ID : type.getClass().getName()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type e(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        return a(0, (ParameterizedType) type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements ParameterizedType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f55a;
        private final Type b;
        private final Type[] c;

        public b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            this.f55a = type;
            this.b = type2;
            this.c = (Type[]) typeArr.clone();
            for (Type type3 : this.c) {
                if (type3 == null) {
                    throw new NullPointerException();
                }
                o.c(type3);
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f55a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && o.a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ o.a((Object) this.f55a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.c.length + 1) * 30);
            sb.append(o.b(this.b));
            if (this.c.length == 0) {
                return sb.toString();
            }
            sb.append("<");
            sb.append(o.b(this.c[0]));
            for (int i = 1; i < this.c.length; i++) {
                sb.append(", ");
                sb.append(o.b(this.c[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements GenericArrayType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f54a;

        public a(Type type) {
            this.f54a = type;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f54a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && o.a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return this.f54a.hashCode();
        }

        public String toString() {
            return o.b(this.f54a) + "[]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements WildcardType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f56a;
        private final Type b;

        public c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length == 1) {
                if (typeArr2[0] == null) {
                    throw new NullPointerException();
                }
                o.c(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    throw new IllegalArgumentException();
                }
                this.b = typeArr2[0];
                this.f56a = Object.class;
                return;
            }
            if (typeArr[0] == null) {
                throw new NullPointerException();
            }
            o.c(typeArr[0]);
            this.b = null;
            this.f56a = typeArr[0];
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f56a};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.b;
            return type != null ? new Type[]{type} : o.f53a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && o.a((Type) this, (Type) obj);
        }

        public int hashCode() {
            Type type = this.b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f56a.hashCode() + 31);
        }

        public String toString() {
            if (this.b != null) {
                return "? super " + o.b(this.b);
            }
            if (this.f56a == Object.class) {
                return "?";
            }
            return "? extends " + o.b(this.f56a);
        }
    }
}
