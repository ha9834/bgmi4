package com.tencent.grobot.lite.ui.container;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.grobot.lite.GRobotApplication;

/* loaded from: classes2.dex */
public abstract class Frame {
    protected final GRobotApplication app;
    protected final Bundle args;
    protected final FrameActivity context;
    protected View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAttachedToWindow() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onBackPressed() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onScreenOrientChange(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View view();

    public Frame(FrameActivity frameActivity, Bundle bundle) {
        this.context = frameActivity;
        this.args = bundle;
        this.app = frameActivity.app;
    }

    public FrameActivity context() {
        return this.context;
    }
}
