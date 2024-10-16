package androidx.lifecycle;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Class<?>, Integer> f788a = new HashMap();
    private static Map<Class<?>, List<Constructor<? extends e>>> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a(Object obj) {
        boolean z = obj instanceof i;
        boolean z2 = obj instanceof d;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((d) obj, (i) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((d) obj, null);
        }
        if (z) {
            return (i) obj;
        }
        Class<?> cls = obj.getClass();
        if (b(cls) == 2) {
            List<Constructor<? extends e>> list = b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
            }
            e[] eVarArr = new e[list.size()];
            for (int i = 0; i < list.size(); i++) {
                eVarArr[i] = a(list.get(i), obj);
            }
            return new CompositeGeneratedAdaptersObserver(eVarArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    private static e a(Constructor<? extends e> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static Constructor<? extends e> a(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a2 = a(canonicalName);
            if (!name.isEmpty()) {
                a2 = name + "." + a2;
            }
            Constructor declaredConstructor = Class.forName(a2).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static int b(Class<?> cls) {
        Integer num = f788a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int c = c(cls);
        f788a.put(cls, Integer.valueOf(c));
        return c;
    }

    private static int c(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends e> a2 = a(cls);
        if (a2 != null) {
            b.put(cls, Collections.singletonList(a2));
            return 2;
        }
        if (b.f782a.a(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (d(superclass)) {
            if (b(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (d(cls2)) {
                if (b(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        b.put(cls, arrayList);
        return 2;
    }

    private static boolean d(Class<?> cls) {
        return cls != null && j.class.isAssignableFrom(cls);
    }

    public static String a(String str) {
        return str.replace(".", EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR) + "_LifecycleAdapter";
    }
}
