package androidx.g;

import android.animation.LayoutTransition;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class y {

    /* renamed from: a, reason: collision with root package name */
    private static LayoutTransition f743a;
    private static Field b;
    private static boolean c;
    private static Method d;
    private static boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.view.ViewGroup r5, boolean r6) {
        /*
            android.animation.LayoutTransition r0 = androidx.g.y.f743a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L2a
            androidx.g.y$1 r0 = new androidx.g.y$1
            r0.<init>()
            androidx.g.y.f743a = r0
            android.animation.LayoutTransition r0 = androidx.g.y.f743a
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = androidx.g.y.f743a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = androidx.g.y.f743a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = androidx.g.y.f743a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = androidx.g.y.f743a
            r4 = 4
            r0.setAnimator(r4, r3)
        L2a:
            if (r6 == 0) goto L4a
            android.animation.LayoutTransition r6 = r5.getLayoutTransition()
            if (r6 == 0) goto L44
            boolean r0 = r6.isRunning()
            if (r0 == 0) goto L3b
            a(r6)
        L3b:
            android.animation.LayoutTransition r0 = androidx.g.y.f743a
            if (r6 == r0) goto L44
            int r0 = androidx.g.j.a.transition_layout_save
            r5.setTag(r0, r6)
        L44:
            android.animation.LayoutTransition r6 = androidx.g.y.f743a
            r5.setLayoutTransition(r6)
            goto L9c
        L4a:
            r5.setLayoutTransition(r3)
            boolean r6 = androidx.g.y.c
            if (r6 != 0) goto L6a
            java.lang.Class<android.view.ViewGroup> r6 = android.view.ViewGroup.class
            java.lang.String r0 = "mLayoutSuppressed"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r0)     // Catch: java.lang.NoSuchFieldException -> L61
            androidx.g.y.b = r6     // Catch: java.lang.NoSuchFieldException -> L61
            java.lang.reflect.Field r6 = androidx.g.y.b     // Catch: java.lang.NoSuchFieldException -> L61
            r6.setAccessible(r1)     // Catch: java.lang.NoSuchFieldException -> L61
            goto L68
        L61:
            java.lang.String r6 = "ViewGroupUtilsApi14"
            java.lang.String r0 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.i(r6, r0)
        L68:
            androidx.g.y.c = r1
        L6a:
            java.lang.reflect.Field r6 = androidx.g.y.b
            if (r6 == 0) goto L85
            boolean r6 = r6.getBoolean(r5)     // Catch: java.lang.IllegalAccessException -> L7e
            if (r6 == 0) goto L7c
            java.lang.reflect.Field r0 = androidx.g.y.b     // Catch: java.lang.IllegalAccessException -> L7a
            r0.setBoolean(r5, r2)     // Catch: java.lang.IllegalAccessException -> L7a
            goto L7c
        L7a:
            r2 = r6
            goto L7e
        L7c:
            r2 = r6
            goto L85
        L7e:
            java.lang.String r6 = "ViewGroupUtilsApi14"
            java.lang.String r0 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.i(r6, r0)
        L85:
            if (r2 == 0) goto L8a
            r5.requestLayout()
        L8a:
            int r6 = androidx.g.j.a.transition_layout_save
            java.lang.Object r6 = r5.getTag(r6)
            android.animation.LayoutTransition r6 = (android.animation.LayoutTransition) r6
            if (r6 == 0) goto L9c
            int r0 = androidx.g.j.a.transition_layout_save
            r5.setTag(r0, r3)
            r5.setLayoutTransition(r6)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.g.y.a(android.view.ViewGroup, boolean):void");
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!e) {
            try {
                d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            e = true;
        }
        Method method = d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
