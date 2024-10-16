package com.tencent.gcloud;

import android.app.Application;
import android.content.Context;
import com.tencent.abase.hotfix.GCloudFix;

/* loaded from: classes.dex */
public class GCloudApplication extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        GCloudFix.init(context);
    }
}
