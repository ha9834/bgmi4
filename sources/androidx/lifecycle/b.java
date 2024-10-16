package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    static b f782a = new b();
    private final Map<Class<?>, a> b = new HashMap();
    private final Map<Class<?>, Boolean> c = new HashMap();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Class<?> cls) {
        Boolean bool = this.c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] c = c(cls);
        for (Method method : c) {
            if (((r) method.getAnnotation(r.class)) != null) {
                a(cls, c);
                return true;
            }
        }
        this.c.put(cls, false);
        return false;
    }

    private Method[] c(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a b(Class<?> cls) {
        a aVar = this.b.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    private void a(Map<C0059b, Lifecycle.Event> map, C0059b c0059b, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(c0059b);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(c0059b, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0059b.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i;
        a b;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (b = b(superclass)) != null) {
            hashMap.putAll(b.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0059b, Lifecycle.Event> entry : b(cls2).b.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            r rVar = (r) method.getAnnotation(r.class);
            if (rVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(k.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                Lifecycle.Event a2 = rVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (a2 != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new C0059b(i, method), a2, cls);
                z = true;
            }
        }
        a aVar = new a(hashMap);
        this.b.put(cls, aVar);
        this.c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Map<Lifecycle.Event, List<C0059b>> f783a = new HashMap();
        final Map<C0059b, Lifecycle.Event> b;

        a(Map<C0059b, Lifecycle.Event> map) {
            this.b = map;
            for (Map.Entry<C0059b, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<C0059b> list = this.f783a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f783a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(k kVar, Lifecycle.Event event, Object obj) {
            a(this.f783a.get(event), kVar, event, obj);
            a(this.f783a.get(Lifecycle.Event.ON_ANY), kVar, event, obj);
        }

        private static void a(List<C0059b> list, k kVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(kVar, event, obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0059b {

        /* renamed from: a, reason: collision with root package name */
        final int f784a;
        final Method b;

        C0059b(int i, Method method) {
            this.f784a = i;
            this.b = method;
            this.b.setAccessible(true);
        }

        void a(k kVar, Lifecycle.Event event, Object obj) {
            try {
                switch (this.f784a) {
                    case 0:
                        this.b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.b.invoke(obj, kVar);
                        return;
                    case 2:
                        this.b.invoke(obj, kVar, event);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0059b)) {
                return false;
            }
            C0059b c0059b = (C0059b) obj;
            return this.f784a == c0059b.f784a && this.b.getName().equals(c0059b.b.getName());
        }

        public int hashCode() {
            return (this.f784a * 31) + this.b.getName().hashCode();
        }
    }
}
