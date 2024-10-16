package com.tencent.gcloud;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class GCloudActivity extends Activity {
    private static final int REQUEST_CODE_ASK_PERMISSION = 100;
    private static final String TAG = "GCloudActivity";
    private boolean bEnableRequestPermission = true;

    static {
        try {
            System.loadLibrary("gcloudcore");
            System.loadLibrary("TDataMaster");
            System.loadLibrary("gcloud");
        } catch (Throwable th) {
            Log.e(TAG, "GCloudActivity loadLibrary err=" + th.toString());
        }
    }

    protected GCloudActivity() {
    }

    private void RequestPermission(Activity activity, List<String> list, int i) {
        if (activity == null || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (str != null && a.b(activity.getApplicationContext(), str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            androidx.core.app.a.a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Log.i(TAG, "onActivityResult");
        GCloud.Instance.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.i(TAG, "onConfigurationChanged");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(TAG, "GCloudActivity onCreate");
        if (this.bEnableRequestPermission) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.READ_PHONE_STATE");
            arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            RequestPermission(this, arrayList, 100);
        }
        if (GCloud.Instance.initialize(this)) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        GCloud.Instance.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent");
        GCloud.Instance.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        GCloud.Instance.onPause();
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str;
        StringBuilder sb;
        String str2;
        Log.i(TAG, "onRequestPermissionsResult: " + i);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 100) {
            return;
        }
        if (strArr.length <= 0 || iArr.length <= 0) {
            Log.e(TAG, "onRequestPermissionsResult: permissions or grantResults is empty");
            return;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (iArr[0] == 0) {
                str = TAG;
                sb = new StringBuilder();
                sb.append("onRequestPermissionsResult: ");
                sb.append(strArr[i2]);
                str2 = " Granted!";
            } else {
                str = TAG;
                sb = new StringBuilder();
                sb.append("onRequestPermissionsResult: ");
                sb.append(strArr[i2]);
                str2 = " Denied!";
            }
            sb.append(str2);
            Log.i(str, sb.toString());
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
        GCloud.Instance.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        GCloud.Instance.onResume();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Log.i(TAG, "onSaveInstanceState");
    }

    public void setEnableRequestPermission(boolean z) {
        this.bEnableRequestPermission = z;
    }
}
