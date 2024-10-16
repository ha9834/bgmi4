package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.c.b;
import androidx.core.content.a.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Long, c.b> f567a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.b(t2) - i2) * 2) + (aVar.a(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    private static long b(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b.C0043b a(b.C0043b[] c0043bArr, int i) {
        return (b.C0043b) a(c0043bArr, i, new a<b.C0043b>() { // from class: androidx.core.graphics.k.1
            @Override // androidx.core.graphics.k.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int b(b.C0043b c0043b) {
                return c0043b.c();
            }

            @Override // androidx.core.graphics.k.a
            /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean a(b.C0043b c0043b) {
                return c0043b.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface a(Context context, InputStream inputStream) {
        File a2 = l.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (l.a(a2, inputStream)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0043b[] c0043bArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (c0043bArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(c0043bArr, i).a());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface a2 = a(context, inputStream);
            l.a(inputStream);
            return a2;
        } catch (IOException unused2) {
            l.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            l.a(inputStream2);
            throw th;
        }
    }

    private c.C0044c a(c.b bVar, int i) {
        return (c.C0044c) a(bVar.a(), i, new a<c.C0044c>() { // from class: androidx.core.graphics.k.2
            @Override // androidx.core.graphics.k.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int b(c.C0044c c0044c) {
                return c0044c.b();
            }

            @Override // androidx.core.graphics.k.a
            /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean a(c.C0044c c0044c) {
                return c0044c.c();
            }
        });
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0044c a2 = a(bVar, i);
        if (a2 == null) {
            return null;
        }
        Typeface a3 = e.a(context, resources, a2.f(), a2.a(), i);
        a(a3, bVar);
        return a3;
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File a2 = l.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (l.a(a2, resources, i)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c.b a(Typeface typeface) {
        long b = b(typeface);
        if (b == 0) {
            return null;
        }
        return this.f567a.get(Long.valueOf(b));
    }

    private void a(Typeface typeface, c.b bVar) {
        long b = b(typeface);
        if (b != 0) {
            this.f567a.put(Long.valueOf(b), bVar);
        }
    }
}
