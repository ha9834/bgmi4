package com.tencent.grobot.lite.ui.container;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.grobot.lite.GRobotEnterManager;
import com.tencent.grobot.lite.GRobotIsolateActivity;

/* loaded from: classes2.dex */
public class BridgeActivity extends Activity {
    private static final String TAG = "BridgeActivity";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("frame_other_process", false)) {
            String stringExtra = intent.getStringExtra("frame_game_params_str");
            if (!TextUtils.isEmpty(stringExtra)) {
                GRobotEnterManager.parseLang(stringExtra);
            }
            intent.setComponent(new ComponentName(this, (Class<?>) GRobotIsolateActivity.class));
            startActivity(intent);
        }
        finish();
    }
}
