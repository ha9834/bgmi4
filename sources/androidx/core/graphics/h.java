package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.c.b;
import androidx.core.content.a.c;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends f {

    /* renamed from: a, reason: collision with root package name */
    protected final Class<?> f566a;
    protected final Constructor<?> b;
    protected final Method c;
    protected final Method d;
    protected final Method e;
    protected final Method f;
    protected final Method g;

    public h() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> a2 = a();
            constructor = a(a2);
            method2 = b(a2);
            method3 = c(a2);
            method4 = d(a2);
            method5 = e(a2);
            method = f(a2);
            cls = a2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f566a = cls;
        this.b = constructor;
        this.c = method2;
        this.d = method3;
        this.e = method4;
        this.f = method5;
        this.g = method;
    }

    private boolean b() {
        if (this.c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.c != null;
    }

    private Object c() {
        try {
            return this.b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    protected Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f566a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean b(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private void c(Object obj) {
        try {
            this.f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    @Override // androidx.core.graphics.f, androidx.core.graphics.k
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        if (!b()) {
            return super.a(context, bVar, resources, i);
        }
        Object c = c();
        if (c == null) {
            return null;
        }
        for (c.C0044c c0044c : bVar.a()) {
            if (!a(context, c, c0044c.a(), c0044c.e(), c0044c.b(), c0044c.c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0044c.d()))) {
                c(c);
                return null;
            }
        }
        if (b(c)) {
            return a(c);
        }
        return null;
    }

    @Override // androidx.core.graphics.f, androidx.core.graphics.k
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0043b[] c0043bArr, int i) {
        Typeface a2;
        if (c0043bArr.length < 1) {
            return null;
        }
        if (!b()) {
            b.C0043b a3 = a(c0043bArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a3.a(), AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a3.c()).setItalic(a3.d()).build();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return build;
                } catch (Throwable th) {
                    if (openFileDescriptor != null) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> a4 = androidx.core.c.b.a(context, c0043bArr, cancellationSignal);
        Object c = c();
        if (c == null) {
            return null;
        }
        boolean z = false;
        for (b.C0043b c0043b : c0043bArr) {
            ByteBuffer byteBuffer = a4.get(c0043b.a());
            if (byteBuffer != null) {
                if (!a(c, byteBuffer, c0043b.b(), c0043b.c(), c0043b.d() ? 1 : 0)) {
                    c(c);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            c(c);
            return null;
        }
        if (b(c) && (a2 = a(c)) != null) {
            return Typeface.create(a2, i);
        }
        return null;
    }

    @Override // androidx.core.graphics.k
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!b()) {
            return super.a(context, resources, i, str, i2);
        }
        Object c = c();
        if (c == null) {
            return null;
        }
        if (!a(context, c, str, 0, -1, -1, null)) {
            c(c);
            return null;
        }
        if (b(c)) {
            return a(c);
        }
        return null;
    }

    protected Class<?> a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> a(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    protected Method b(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method c(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method d(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    protected Method e(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method f(Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
