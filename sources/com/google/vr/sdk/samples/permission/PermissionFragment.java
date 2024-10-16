package com.google.vr.sdk.samples.permission;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import androidx.legacy.app.a;

/* loaded from: classes2.dex */
public class PermissionFragment extends Fragment implements a.f {
    private static final int PERMISSION_REQUEST_CODE = 1101;
    private static final String PERMISSION_TAG = "TAG_PermissionFragment";
    private static final String TAG = "PermissionFragment";

    public static PermissionFragment getInstance(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        PermissionFragment permissionFragment = (PermissionFragment) fragmentManager.findFragmentByTag(PERMISSION_TAG);
        if (permissionFragment != null) {
            return permissionFragment;
        }
        try {
            Log.d(TAG, "Creating PlayGamesFragment");
            PermissionFragment permissionFragment2 = new PermissionFragment();
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(permissionFragment2, PERMISSION_TAG);
            beginTransaction.commit();
            fragmentManager.executePendingTransactions();
            return permissionFragment2;
        } catch (Throwable th) {
            Log.e(TAG, "Cannot launch PermissionFragment:" + th.getMessage(), th);
            return null;
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void acquirePermissions(String[] strArr) {
        a.a(this, strArr, 1101);
    }

    @Override // android.app.Fragment, androidx.legacy.app.a.f
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 1101 || strArr.length <= 0) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            Log.d(TAG, "permission granted for " + strArr[0]);
        } else {
            Log.d(TAG, "permission not granted for " + strArr[0]);
        }
        PermissionHelper.onAcquirePermissions(strArr, iArr);
    }
}
