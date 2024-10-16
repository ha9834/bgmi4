package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ar extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f334a = new Object();
    private static ArrayList<WeakReference<ar>> b;
    private final Resources c;
    private final Resources.Theme d;

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (f334a) {
            if (b == null) {
                b = new ArrayList<>();
            } else {
                for (int size = b.size() - 1; size >= 0; size--) {
                    WeakReference<ar> weakReference = b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        b.remove(size);
                    }
                }
                for (int size2 = b.size() - 1; size2 >= 0; size2--) {
                    WeakReference<ar> weakReference2 = b.get(size2);
                    ar arVar = weakReference2 != null ? weakReference2.get() : null;
                    if (arVar != null && arVar.getBaseContext() == context) {
                        return arVar;
                    }
                }
            }
            ar arVar2 = new ar(context);
            b.add(new WeakReference<>(arVar2));
            return arVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof ar) || (context.getResources() instanceof at) || (context.getResources() instanceof az)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || az.a();
    }

    private ar(Context context) {
        super(context);
        if (az.a()) {
            this.c = new az(this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
        } else {
            this.c = new at(this, context.getResources());
            this.d = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.c.getAssets();
    }
}
