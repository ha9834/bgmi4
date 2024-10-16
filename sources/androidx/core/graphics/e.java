package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.c.b;
import androidx.core.content.a.c;
import androidx.core.content.a.f;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final k f563a;
    private static final androidx.b.e<String, Typeface> b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f563a = new j();
        } else if (Build.VERSION.SDK_INT >= 28) {
            f563a = new i();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f563a = new h();
        } else if (Build.VERSION.SDK_INT >= 24 && g.a()) {
            f563a = new g();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f563a = new f();
        } else {
            f563a = new k();
        }
        b = new androidx.b.e<>(16);
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return b.get(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface a2;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (z) {
                if (dVar.b() == 0) {
                    z2 = true;
                }
            } else if (aVar2 == null) {
                z2 = true;
            }
            a2 = androidx.core.c.b.a(context, dVar.a(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            a2 = f563a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.a(a2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a2 != null) {
            b.put(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = f563a.a(context, resources, i, str, i2);
        if (a2 != null) {
            b.put(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.C0043b[] c0043bArr, int i) {
        return f563a.a(context, cancellationSignal, c0043bArr, i);
    }

    private static Typeface b(Context context, Typeface typeface, int i) {
        c.b a2 = f563a.a(typeface);
        if (a2 == null) {
            return null;
        }
        return f563a.a(context, a2, context.getResources(), i);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        Typeface b2;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (b2 = b(context, typeface, i)) == null) ? Typeface.create(typeface, i) : b2;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
}
