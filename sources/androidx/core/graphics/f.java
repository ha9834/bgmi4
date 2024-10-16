package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.c.b;
import androidx.core.content.a.c;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class f extends k {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f564a;
    private static Constructor<?> b;
    private static Method c;
    private static Method d;
    private static boolean e;

    private static void a() {
        Method method;
        Class<?> cls;
        Method method2;
        if (e) {
            return;
        }
        e = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        b = constructor;
        f564a = cls;
        c = method2;
        d = method;
    }

    private File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
            return null;
        } catch (ErrnoException unused) {
            return null;
        }
    }

    private static Object b() {
        a();
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface a(Object obj) {
        a();
        try {
            Object newInstance = Array.newInstance(f564a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean a(Object obj, String str, int i, boolean z) {
        a();
        try {
            return ((Boolean) c.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // androidx.core.graphics.k
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0043b[] c0043bArr, int i) {
        if (c0043bArr.length < 1) {
            return null;
        }
        b.C0043b a2 = a(c0043bArr, i);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.a(), AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File a3 = a(openFileDescriptor);
                if (a3 != null && a3.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(a3);
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    Typeface a4 = super.a(context, fileInputStream);
                    fileInputStream.close();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return a4;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (openFileDescriptor != null) {
                    try {
                        openFileDescriptor.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (IOException unused3) {
            return null;
        }
    }

    @Override // androidx.core.graphics.k
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        Object b2 = b();
        for (c.C0044c c0044c : bVar.a()) {
            File a2 = l.a(context);
            if (a2 == null) {
                return null;
            }
            try {
                if (!l.a(a2, resources, c0044c.f())) {
                    return null;
                }
                if (!a(b2, a2.getPath(), c0044c.b(), c0044c.c())) {
                    return null;
                }
                a2.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                a2.delete();
            }
        }
        return a(b2);
    }
}
