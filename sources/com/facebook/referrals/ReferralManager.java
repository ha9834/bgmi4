package com.facebook.referrals;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Validate;

/* loaded from: classes.dex */
public class ReferralManager {
    private static volatile ReferralManager instance;
    private ReferralLogger logger;

    ReferralManager() {
        Validate.sdkInitialized();
    }

    public static ReferralManager getInstance() {
        if (instance == null) {
            synchronized (ReferralManager.class) {
                if (instance == null) {
                    instance = new ReferralManager();
                }
            }
        }
        return instance;
    }

    public void startReferral(Activity activity) {
        startReferralImpl(new ActivityStartActivityDelegate(activity));
    }

    public void startReferral(Fragment fragment) {
        startReferralImpl(new FragmentStartActivityDelegate(new FragmentWrapper(fragment)));
    }

    public void startReferral(android.app.Fragment fragment) {
        startReferralImpl(new FragmentStartActivityDelegate(new FragmentWrapper(fragment)));
    }

    public void startReferral(FragmentWrapper fragmentWrapper) {
        startReferralImpl(new FragmentStartActivityDelegate(fragmentWrapper));
    }

    public void registerCallback(CallbackManager callbackManager, final FacebookCallback<ReferralResult> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(ReferralClient.getReferralRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.referrals.ReferralManager.1
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int i, Intent intent) {
                return ReferralManager.this.onActivityResult(i, intent, facebookCallback);
            }
        });
    }

    private void startReferralImpl(StartActivityDelegate startActivityDelegate) {
        ReferralLogger logger = getLogger(startActivityDelegate.getActivityContext());
        if (logger != null) {
            logger.logStartReferral();
        }
        if (tryFacebookActivity(startActivityDelegate)) {
            return;
        }
        FacebookException facebookException = new FacebookException("Failed to open Referral dialog: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        if (logger != null) {
            logger.logError(facebookException);
            throw facebookException;
        }
        throw facebookException;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean onActivityResult(int r4, android.content.Intent r5, com.facebook.FacebookCallback<com.facebook.referrals.ReferralResult> r6) {
        /*
            r3 = this;
            r0 = -1
            r1 = 0
            if (r4 != r0) goto L32
            if (r5 == 0) goto L32
            android.os.Bundle r0 = r5.getExtras()     // Catch: org.json.JSONException -> L66
            if (r0 == 0) goto L32
            android.os.Bundle r0 = r5.getExtras()     // Catch: org.json.JSONException -> L66
            java.lang.String r2 = "fb_referral_codes"
            boolean r0 = r0.containsKey(r2)     // Catch: org.json.JSONException -> L66
            if (r0 == 0) goto L32
            android.os.Bundle r4 = r5.getExtras()     // Catch: org.json.JSONException -> L66
            java.lang.String r5 = "fb_referral_codes"
            java.lang.String r4 = r4.getString(r5)     // Catch: org.json.JSONException -> L66
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch: org.json.JSONException -> L66
            r5.<init>(r4)     // Catch: org.json.JSONException -> L66
            java.util.List r4 = com.facebook.internal.Utility.convertJSONArrayToList(r5)     // Catch: org.json.JSONException -> L66
            com.facebook.referrals.ReferralResult r5 = new com.facebook.referrals.ReferralResult     // Catch: org.json.JSONException -> L66
            r5.<init>(r4)     // Catch: org.json.JSONException -> L66
            r4 = r1
            goto L6e
        L32:
            if (r4 != 0) goto L5d
            if (r5 == 0) goto L5a
            android.os.Bundle r4 = r5.getExtras()     // Catch: org.json.JSONException -> L66
            if (r4 == 0) goto L5a
            android.os.Bundle r4 = r5.getExtras()     // Catch: org.json.JSONException -> L66
            java.lang.String r0 = "error_message"
            boolean r4 = r4.containsKey(r0)     // Catch: org.json.JSONException -> L66
            if (r4 == 0) goto L5a
            android.os.Bundle r4 = r5.getExtras()     // Catch: org.json.JSONException -> L66
            java.lang.String r5 = "error_message"
            java.lang.String r4 = r4.getString(r5)     // Catch: org.json.JSONException -> L66
            com.facebook.FacebookException r5 = new com.facebook.FacebookException     // Catch: org.json.JSONException -> L66
            r5.<init>(r4)     // Catch: org.json.JSONException -> L66
            r4 = r5
            r5 = r1
            goto L6e
        L5a:
            r4 = r1
            r5 = r4
            goto L6e
        L5d:
            com.facebook.FacebookException r4 = new com.facebook.FacebookException     // Catch: org.json.JSONException -> L66
            java.lang.String r5 = "Unexpected call to ReferralManager.onActivityResult"
            r4.<init>(r5)     // Catch: org.json.JSONException -> L66
            r5 = r1
            goto L6e
        L66:
            com.facebook.FacebookException r4 = new com.facebook.FacebookException
            java.lang.String r5 = "Unable to parse referral codes from response"
            r4.<init>(r5)
            r5 = r1
        L6e:
            com.facebook.referrals.ReferralLogger r0 = r3.getLogger(r1)
            if (r0 == 0) goto L83
            if (r5 == 0) goto L7a
            r0.logSuccess()
            goto L83
        L7a:
            if (r4 == 0) goto L80
            r0.logError(r4)
            goto L83
        L80:
            r0.logCancel()
        L83:
            if (r5 == 0) goto L89
            r6.onSuccess(r5)
            goto L92
        L89:
            if (r4 == 0) goto L8f
            r6.onError(r4)
            goto L92
        L8f:
            r6.onCancel()
        L92:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.referrals.ReferralManager.onActivityResult(int, android.content.Intent, com.facebook.FacebookCallback):boolean");
    }

    private boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate) {
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(ReferralFragment.TAG);
        if (!resolveIntent(intent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(intent, CallbackManagerImpl.RequestCodeOffset.Referral.toRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private ReferralLogger getLogger(Context context) {
        if (context == null) {
            context = FacebookSdk.getApplicationContext();
        }
        if (context == null) {
            return null;
        }
        if (this.logger == null) {
            this.logger = new ReferralLogger(context, FacebookSdk.getApplicationId());
        }
        return this.logger;
    }

    private static boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    /* loaded from: classes.dex */
    private static class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activity;

        ActivityStartActivityDelegate(Activity activity) {
            Validate.notNull(activity, "activity");
            this.activity = activity;
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i) {
            this.activity.startActivityForResult(intent, i);
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public Activity getActivityContext() {
            return this.activity;
        }
    }

    /* loaded from: classes.dex */
    private static class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final FragmentWrapper fragment;

        FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            Validate.notNull(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i) {
            this.fragment.startActivityForResult(intent, i);
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public Activity getActivityContext() {
            return this.fragment.getActivity();
        }
    }
}
