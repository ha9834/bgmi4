package androidx.g;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class z {

    /* renamed from: a, reason: collision with root package name */
    private static Method f744a;
    private static boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ViewGroup viewGroup, boolean z) {
        a();
        Method method = f744a;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }

    private static void a() {
        if (b) {
            return;
        }
        try {
            f744a = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            f744a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
        }
        b = true;
    }
}
