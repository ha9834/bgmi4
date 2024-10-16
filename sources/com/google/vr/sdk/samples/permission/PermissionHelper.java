package com.google.vr.sdk.samples.permission;

import android.app.Activity;
import android.util.Log;
import androidx.core.content.a;

/* loaded from: classes2.dex */
public class PermissionHelper {
    private static final String LOG_TAG = "PermissionHelper";

    public static native void onAcquirePermissions(String[] strArr, int[] iArr);

    public static Activity getForegroundActivity() {
        Activity activity;
        try {
            activity = (Activity) Class.forName("com.google.vr.sdk.samples.transition.GVRTransition2DActivity").getMethod("getActivity", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            Log.e(LOG_TAG, "GVRTransition2DActivity.getActivity() failed. Trying to get GameActivity.");
            activity = null;
        }
        if (activity != null) {
            return activity;
        }
        try {
            return (Activity) Class.forName("com.epicgames.ue4.GameActivity").getMethod("Get", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused2) {
            Log.e(LOG_TAG, "GameActivity.Get() failed");
            return null;
        }
    }

    public static boolean checkPermission(String str) {
        Activity foregroundActivity = getForegroundActivity();
        if (foregroundActivity == null) {
            return false;
        }
        if (a.b(foregroundActivity, str) == 0) {
            Log.d(LOG_TAG, "checkPermission: " + str + " has granted");
            return true;
        }
        Log.d(LOG_TAG, "checkPermission: " + str + " has not granted");
        return false;
    }

    public static void acquirePermissions(String[] strArr) {
        acquirePermissions(strArr, getForegroundActivity());
    }

    public static void acquirePermissions(final String[] strArr, final Activity activity) {
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.google.vr.sdk.samples.permission.PermissionHelper.1
            @Override // java.lang.Runnable
            public void run() {
                PermissionFragment permissionFragment = PermissionFragment.getInstance(activity);
                if (permissionFragment != null) {
                    permissionFragment.acquirePermissions(strArr);
                }
            }
        });
    }
}
