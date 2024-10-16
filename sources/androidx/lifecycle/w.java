package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private final b f795a;
    private final x b;

    /* loaded from: classes.dex */
    public interface b {
        <T extends v> T a(Class<T> cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e {
        void a(v vVar) {
        }

        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c extends e implements b {
        public abstract <T extends v> T a(String str, Class<T> cls);

        public <T extends v> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }
    }

    public w(x xVar, b bVar) {
        this.f795a = bVar;
        this.b = xVar;
    }

    public <T extends v> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public <T extends v> T a(String str, Class<T> cls) {
        T t;
        T t2 = (T) this.b.a(str);
        if (cls.isInstance(t2)) {
            Object obj = this.f795a;
            if (obj instanceof e) {
                ((e) obj).a(t2);
            }
            return t2;
        }
        b bVar = this.f795a;
        if (bVar instanceof c) {
            t = (T) ((c) bVar).a(str, cls);
        } else {
            t = (T) bVar.a(cls);
        }
        this.b.a(str, t);
        return t;
    }

    /* loaded from: classes.dex */
    public static class d implements b {

        /* renamed from: a, reason: collision with root package name */
        private static d f797a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static d a() {
            if (f797a == null) {
                f797a = new d();
            }
            return f797a;
        }

        @Override // androidx.lifecycle.w.b
        public <T extends v> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends d {

        /* renamed from: a, reason: collision with root package name */
        private static a f796a;
        private Application b;

        public static a a(Application application) {
            if (f796a == null) {
                f796a = new a(application);
            }
            return f796a;
        }

        public a(Application application) {
            this.b = application;
        }

        @Override // androidx.lifecycle.w.d, androidx.lifecycle.w.b
        public <T extends v> T a(Class<T> cls) {
            if (androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                try {
                    return cls.getConstructor(Application.class).newInstance(this.b);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e2);
                } catch (NoSuchMethodException e3) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e3);
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e4);
                }
            }
            return (T) super.a(cls);
        }
    }
}
