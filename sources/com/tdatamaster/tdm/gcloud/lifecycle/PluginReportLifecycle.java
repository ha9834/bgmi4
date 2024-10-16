package com.tdatamaster.tdm.gcloud.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tdatamaster.tdm.TDataMaster;

/* loaded from: classes2.dex */
public class PluginReportLifecycle {
    public void onCreate(Bundle bundle) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        TDataMaster.getInstance().onActivityResult(i, i2, intent);
    }

    public void onCreate(Activity activity, Bundle bundle) {
        TDataMaster.getInstance().initialize(activity);
    }

    public void onDestroy() {
        TDataMaster.getInstance().onDestroy();
    }

    public void onPause() {
        TDataMaster.getInstance().onPause();
    }

    public void onRestart() {
        TDataMaster.getInstance().onRestart();
    }

    public void onResume() {
        TDataMaster.getInstance().onResume();
    }

    public void onStart() {
        TDataMaster.getInstance().onStart();
    }

    public void onStop() {
        TDataMaster.getInstance().onStop();
    }
}
