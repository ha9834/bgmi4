package androidx.g;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class ae extends ah {

    /* renamed from: a, reason: collision with root package name */
    private static Method f707a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    @Override // androidx.g.ah
    public void b(View view) {
    }

    @Override // androidx.g.ah
    public void c(View view) {
    }

    @Override // androidx.g.ah
    public void a(View view, float f) {
        a();
        Method method = f707a;
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(f));
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        view.setAlpha(f);
    }

    @Override // androidx.g.ah
    public float a(View view) {
        b();
        Method method = c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return super.a(view);
    }

    private void a() {
        if (b) {
            return;
        }
        try {
            f707a = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            f707a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
        }
        b = true;
    }

    private void b() {
        if (d) {
            return;
        }
        try {
            c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            c.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
        }
        d = true;
    }
}
