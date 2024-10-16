package androidx.g;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class af extends ae {

    /* renamed from: a, reason: collision with root package name */
    private static Method f708a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    @Override // androidx.g.ah
    public void a(View view, Matrix matrix) {
        a();
        Method method = f708a;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Override // androidx.g.ah
    public void b(View view, Matrix matrix) {
        b();
        Method method = c;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    private void a() {
        if (b) {
            return;
        }
        try {
            f708a = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            f708a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
        }
        b = true;
    }

    private void b() {
        if (d) {
            return;
        }
        try {
            c = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            c.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
        }
        d = true;
    }
}
