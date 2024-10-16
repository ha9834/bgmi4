package com.epicgames.ue4;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.tencent.gcloud.qr.QRCodeAPI;

/* loaded from: classes.dex */
public class SplashActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (getIntent().getStringExtra("RDOC") != null) {
            System.loadLibrary("FrameCapturer");
        }
        tryToFixAlienScreenLayout();
        try {
            Bundle bundle2 = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData;
            z = bundle2.containsKey("com.epicgames.ue4.GameActivity.bShouldHideUI") ? bundle2.getBoolean("com.epicgames.ue4.GameActivity.bShouldHideUI") : false;
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            z = false;
        }
        if (z) {
            View decorView = getWindow().getDecorView();
            if (Build.VERSION.SDK_INT >= 19) {
                decorView.setSystemUiVisibility(3846);
            }
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception unused2) {
        }
        try {
            Intent intent = new Intent(this, (Class<?>) GameActivity.class);
            intent.setData(getIntent().getData());
            intent.putExtras(getIntent());
            intent.addFlags(65536);
            intent.putExtra("UseSplashScreen", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            if (z) {
                intent.putExtra("ShouldHideUI", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            Intent intent2 = getIntent();
            Bundle extras = intent2.getExtras();
            if (extras != null) {
                intent.putExtras(extras);
            }
            String action = intent2.getAction();
            if (action != null) {
                intent.setAction(action);
            }
            startActivity(intent);
            finish();
            overridePendingTransition(0, 0);
        } catch (Exception unused3) {
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        QRCodeAPI.getInstance().RefreshLaunch(intent);
    }

    private void tryToFixAlienScreenLayout() {
        int i = 0;
        try {
            i = getApplicationContext().getResources().getIdentifier("UE4SplashThemeAllInOne", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, getApplicationContext().getPackageName());
            if (GameActivity.isAlienScreen(this)) {
                i = getApplicationContext().getResources().getIdentifier("UE4SplashThemeBG", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, getApplicationContext().getPackageName());
                setContentView(getApplicationContext().getResources().getIdentifier("activity_splash", "layout", getApplicationContext().getPackageName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i != 0) {
            setTheme(i);
        }
    }
}
