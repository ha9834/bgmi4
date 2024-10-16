package com.tencent.gcloud;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes2.dex */
public abstract class Plugin {
    public Plugin() {
        PluginManager.Instance.addPlugin(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onActivityResult(int i, int i2, Intent intent);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onDestroy();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean onInitialize(Activity activity);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onNewIntent(Intent intent);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onPause();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onRestart();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onResume();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onStart();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onStop();
}
