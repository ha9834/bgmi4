package com.epicgames.ue4;

import android.provider.Settings;
import com.google.android.vending.licensing.a;
import com.google.android.vending.licensing.d;
import com.google.android.vending.licensing.e;
import com.google.android.vending.licensing.l;

/* loaded from: classes.dex */
public class GooglePlayLicensing {
    public static GooglePlayLicensing GoogleLicensing;
    private static final byte[] SALT = {-46, 65, 30, Byte.MIN_VALUE, -103, -57, 74, -64, 51, 88, -95, -45, 77, -117, -36, -113, -11, 32, -64, 89};
    private Logger Log;
    private GameActivity gameActivity;
    private d mChecker;
    private e mLicenseCheckerCallback;

    public void Init(GameActivity gameActivity, Logger logger) {
        this.gameActivity = gameActivity;
        this.Log = logger;
    }

    public void CheckLicense(String str) {
        this.Log.debug("Attempting to validate Google Play License.");
        String string = Settings.Secure.getString(this.gameActivity.getApplicationContext().getContentResolver(), "android_id");
        this.mLicenseCheckerCallback = new MyLicenseCheckerCallback();
        this.mChecker = new d(this.gameActivity.getApplicationContext(), new l(this.gameActivity.getApplicationContext(), new a(SALT, this.gameActivity.getApplicationContext().getPackageName(), string)), str);
        this.mChecker.a(this.mLicenseCheckerCallback);
    }

    public void onDestroy() {
        d dVar = this.mChecker;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* loaded from: classes.dex */
    private class MyLicenseCheckerCallback implements e {
        private MyLicenseCheckerCallback() {
        }

        @Override // com.google.android.vending.licensing.e
        public void allow(int i) {
            if (GooglePlayLicensing.this.gameActivity.isFinishing()) {
                return;
            }
            GooglePlayLicensing.this.Log.debug("Game is Licensed version. Allowing access.");
        }

        @Override // com.google.android.vending.licensing.e
        public void dontAllow(int i) {
            if (GooglePlayLicensing.this.gameActivity.isFinishing()) {
                return;
            }
            GooglePlayLicensing.this.Log.debug("***************Game is not licensed!");
        }

        @Override // com.google.android.vending.licensing.e
        public void applicationError(int i) {
            if (GooglePlayLicensing.this.gameActivity.isFinishing()) {
                return;
            }
            String num = Integer.toString(i);
            GooglePlayLicensing.this.Log.debug("ERROR: " + num);
        }
    }
}
