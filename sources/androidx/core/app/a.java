package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.core.app.m;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends androidx.core.content.a {

    /* renamed from: a, reason: collision with root package name */
    private static b f460a;

    /* renamed from: androidx.core.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0042a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(Activity activity, String[] strArr, int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(mVar != null ? new d(mVar) : null);
        }
    }

    public static void b(Activity activity, m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(mVar != null ? new d(mVar) : null);
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Activity activity, final String[] strArr, final int i) {
        b bVar = f460a;
        if (bVar == null || !bVar.a(activity, strArr, i)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof c) {
                    ((c) activity).validateRequestPermissionsRequestCode(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof InterfaceC0042a) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int[] iArr = new int[strArr.length];
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                        }
                        ((InterfaceC0042a) activity).onRequestPermissionsResult(i, strArr, iArr);
                    }
                });
            }
        }
    }

    public static boolean a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void e(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else if (Build.VERSION.SDK_INT <= 23) {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (activity.isFinishing() || androidx.core.app.c.a(activity)) {
                        return;
                    }
                    activity.recreate();
                }
            });
        } else {
            if (androidx.core.app.c.a(activity)) {
                return;
            }
            activity.recreate();
        }
    }

    /* loaded from: classes.dex */
    private static class d extends SharedElementCallback {

        /* renamed from: a, reason: collision with root package name */
        private final m f463a;

        d(m mVar) {
            this.f463a = mVar;
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f463a.a(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f463a.b(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.f463a.a(list);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f463a.a(list, map);
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f463a.a(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f463a.a(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f463a.a(list, list2, new m.a() { // from class: androidx.core.app.a.d.1
                @Override // androidx.core.app.m.a
                public void a() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }
}
