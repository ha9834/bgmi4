package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f477a = new Object();
    private static Set<String> b = new HashSet();
    private static final Object e = new Object();
    private final Context c;
    private final NotificationManager d;

    public static k a(Context context) {
        return new k(context);
    }

    private k(Context context) {
        this.c = context;
        this.d = (NotificationManager) this.c.getSystemService("notification");
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.d.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.c.getSystemService("appops");
        ApplicationInfo applicationInfo = this.c.getApplicationInfo();
        String packageName = this.c.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
