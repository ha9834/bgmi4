package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements i {

    /* renamed from: a, reason: collision with root package name */
    private static int f121a;
    private static Field b;
    private static Field c;
    private static Field d;
    private Activity e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmLeaksCleaner(Activity activity) {
        this.e = activity;
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f121a == 0) {
            a();
        }
        if (f121a == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.e.getSystemService("input_method");
            try {
                Object obj = b.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) c.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                d.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }

    private static void a() {
        try {
            f121a = 2;
            c = InputMethodManager.class.getDeclaredField("mServedView");
            c.setAccessible(true);
            d = InputMethodManager.class.getDeclaredField("mNextServedView");
            d.setAccessible(true);
            b = InputMethodManager.class.getDeclaredField("mH");
            b.setAccessible(true);
            f121a = 1;
        } catch (NoSuchFieldException unused) {
        }
    }
}
