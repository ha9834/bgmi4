package androidx.g;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name */
    static final Property<View, Float> f706a;
    static final Property<View, Rect> b;
    private static final ah c;
    private static Field d;
    private static boolean e;

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            c = new ag();
        } else if (Build.VERSION.SDK_INT >= 21) {
            c = new af();
        } else if (Build.VERSION.SDK_INT >= 19) {
            c = new ae();
        } else {
            c = new ah();
        }
        f706a = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.g.ad.1
            @Override // android.util.Property
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(ad.c(view));
            }

            @Override // android.util.Property
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float f) {
                ad.a(view, f.floatValue());
            }
        };
        b = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.g.ad.2
            @Override // android.util.Property
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Rect get(View view) {
                return androidx.core.f.v.z(view);
            }

            @Override // android.util.Property
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(View view, Rect rect) {
                androidx.core.f.v.a(view, rect);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ac a(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ab(view);
        }
        return aa.d(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static al b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ak(view);
        }
        return new aj(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, float f) {
        c.a(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(View view) {
        return c.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(View view) {
        c.b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(View view) {
        c.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, int i) {
        a();
        Field field = d;
        if (field != null) {
            try {
                d.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, Matrix matrix) {
        c.a(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view, Matrix matrix) {
        c.b(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, int i, int i2, int i3, int i4) {
        c.a(view, i, i2, i3, i4);
    }

    private static void a() {
        if (e) {
            return;
        }
        try {
            d = View.class.getDeclaredField("mViewFlags");
            d.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
        }
        e = true;
    }
}
