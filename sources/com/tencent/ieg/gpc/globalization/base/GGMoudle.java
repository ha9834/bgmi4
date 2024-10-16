package com.tencent.ieg.gpc.globalization.base;

import android.app.Activity;
import com.tencent.ieg.gpc.globalization.base.interfaces.IModule;

/* loaded from: classes2.dex */
public class GGMoudle implements IModule {
    protected Activity currentActivity;

    @Override // com.tencent.ieg.gpc.globalization.base.interfaces.IModule
    public void initialize(Activity activity) {
        this.currentActivity = activity;
    }

    @Override // com.tencent.ieg.gpc.globalization.base.interfaces.IModule
    public void dispose() {
        this.currentActivity = null;
    }
}
