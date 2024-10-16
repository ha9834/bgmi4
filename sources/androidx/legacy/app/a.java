package androidx.legacy.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;

@Deprecated
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final e f762a;
    private static g b;

    /* loaded from: classes.dex */
    interface e {
        void a(Fragment fragment, String[] strArr, int i);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface f {
        @Deprecated
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface g {
        @Deprecated
        boolean a(Fragment fragment, String[] strArr, int i);
    }

    /* loaded from: classes.dex */
    static class d implements e {
        d() {
        }

        @Override // androidx.legacy.app.a.e
        public void a(final Fragment fragment, final String[] strArr, final int i) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.legacy.app.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    Activity activity = fragment.getActivity();
                    if (activity != null) {
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                        }
                    } else {
                        Arrays.fill(iArr, -1);
                    }
                    ((f) fragment).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    /* renamed from: androidx.legacy.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0056a extends d {
        C0056a() {
        }
    }

    /* loaded from: classes.dex */
    static class b extends C0056a {
        b() {
        }

        @Override // androidx.legacy.app.a.d, androidx.legacy.app.a.e
        public void a(Fragment fragment, String[] strArr, int i) {
            fragment.requestPermissions(strArr, i);
        }
    }

    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            f762a = new c();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            f762a = new b();
        } else if (Build.VERSION.SDK_INT >= 15) {
            f762a = new C0056a();
        } else {
            f762a = new d();
        }
    }

    @Deprecated
    public static void a(Fragment fragment, String[] strArr, int i) {
        g gVar = b;
        if (gVar == null || !gVar.a(fragment, strArr, i)) {
            f762a.a(fragment, strArr, i);
        }
    }
}
