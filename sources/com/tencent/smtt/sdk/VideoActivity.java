package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes2.dex */
public class VideoActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            m.a(super.getApplicationContext()).a((String) null, bundleExtra, (com.tencent.tbs.video.interfaces.a) null);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m.a(this).a(this, 2);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        m.a(this).a(this, 1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        m.a(this).a(this, 3);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        m.a(this).a(this, 4);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        m.a(this).a(i, i2, intent);
    }
}
