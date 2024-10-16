package com.tencent.imsdk.android.base.interfaces;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public interface ILifeMonitor {
    void onActivityResult(int i, int i2, Intent intent);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onNewIntent(Intent intent);

    void onPause();

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onRestart();

    void onRestoreInstanceState(Bundle bundle);

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();
}
