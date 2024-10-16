package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class az extends Resources {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f345a;
    private final WeakReference<Context> b;

    public static boolean a() {
        return b() && Build.VERSION.SDK_INT <= 20;
    }

    public az(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = this.b.get();
        if (context != null) {
            return ak.a().a(context, this, i);
        }
        return super.getDrawable(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public static boolean b() {
        return f345a;
    }
}
