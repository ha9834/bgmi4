package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class u extends w.c {
    private static final Class<?>[] f = {Application.class, t.class};
    private static final Class<?>[] g = {t.class};

    /* renamed from: a, reason: collision with root package name */
    private final Application f793a;
    private final w.b b;
    private final Bundle c;
    private final Lifecycle d;
    private final androidx.savedstate.b e;

    @SuppressLint({"LambdaLast"})
    public u(Application application, androidx.savedstate.d dVar, Bundle bundle) {
        w.b a2;
        this.e = dVar.getSavedStateRegistry();
        this.d = dVar.getLifecycle();
        this.c = bundle;
        this.f793a = application;
        if (application != null) {
            a2 = w.a.a(application);
        } else {
            a2 = w.d.a();
        }
        this.b = a2;
    }

    @Override // androidx.lifecycle.w.c
    public <T extends v> T a(String str, Class<T> cls) {
        Constructor a2;
        T t;
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        if (isAssignableFrom && this.f793a != null) {
            a2 = a(cls, f);
        } else {
            a2 = a(cls, g);
        }
        if (a2 == null) {
            return (T) this.b.a(cls);
        }
        SavedStateHandleController a3 = SavedStateHandleController.a(this.e, this.d, str, this.c);
        if (isAssignableFrom) {
            try {
                if (this.f793a != null) {
                    t = (T) a2.newInstance(this.f793a, a3.b());
                    t.a("androidx.lifecycle.savedstate.vm.tag", a3);
                    return t;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to access " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
            }
        }
        t = (T) a2.newInstance(a3.b());
        t.a("androidx.lifecycle.savedstate.vm.tag", a3);
        return t;
    }

    @Override // androidx.lifecycle.w.c, androidx.lifecycle.w.b
    public <T extends v> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) a(canonicalName, cls);
    }

    private static <T> Constructor<T> a(Class<T> cls, Class<?>[] clsArr) {
        for (Object obj : cls.getConstructors()) {
            Constructor<T> constructor = (Constructor<T>) obj;
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.w.e
    void a(v vVar) {
        SavedStateHandleController.a(vVar, this.e, this.d);
    }
}
