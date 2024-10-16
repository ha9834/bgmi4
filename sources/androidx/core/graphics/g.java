package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.c.b;
import androidx.core.content.a.c;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
class g extends k {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f565a;
    private static final Constructor<?> b;
    private static final Method c;
    private static final Method d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        b = constructor;
        f565a = cls;
        c = method2;
        d = method;
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static Object b() {
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f565a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.k
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0043b[] c0043bArr, int i) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        androidx.b.g gVar = new androidx.b.g();
        for (b.C0043b c0043b : c0043bArr) {
            Uri a2 = c0043b.a();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(a2);
            if (byteBuffer == null) {
                byteBuffer = l.a(context, cancellationSignal, a2);
                gVar.put(a2, byteBuffer);
            }
            if (byteBuffer == null || !a(b2, byteBuffer, c0043b.b(), c0043b.c(), c0043b.d())) {
                return null;
            }
        }
        Typeface a3 = a(b2);
        if (a3 == null) {
            return null;
        }
        return Typeface.create(a3, i);
    }

    @Override // androidx.core.graphics.k
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        for (c.C0044c c0044c : bVar.a()) {
            ByteBuffer a2 = l.a(context, resources, c0044c.f());
            if (a2 == null || !a(b2, a2, c0044c.e(), c0044c.b(), c0044c.c())) {
                return null;
            }
        }
        return a(b2);
    }
}
