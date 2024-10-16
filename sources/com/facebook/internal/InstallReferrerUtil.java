package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.h;
import kotlin.text.l;

/* loaded from: classes.dex */
public final class InstallReferrerUtil {
    public static final InstallReferrerUtil INSTANCE = new InstallReferrerUtil();
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";

    /* loaded from: classes.dex */
    public interface Callback {
        void onReceiveReferrerUrl(String str);
    }

    private InstallReferrerUtil() {
    }

    public static final void tryUpdateReferrerInfo(Callback callback) {
        h.b(callback, "callback");
        if (INSTANCE.isUpdated()) {
            return;
        }
        INSTANCE.tryConnectReferrerInfo(callback);
    }

    private final void tryConnectReferrerInfo(final Callback callback) {
        final InstallReferrerClient build = InstallReferrerClient.newBuilder(FacebookSdk.getApplicationContext()).build();
        try {
            build.startConnection(new InstallReferrerStateListener() { // from class: com.facebook.internal.InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                }

                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerSetupFinished(int i) {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        switch (i) {
                            case 0:
                                try {
                                    InstallReferrerClient installReferrerClient = InstallReferrerClient.this;
                                    h.a((Object) installReferrerClient, "referrerClient");
                                    ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
                                    h.a((Object) installReferrer, "referrerClient.installReferrer");
                                    String installReferrer2 = installReferrer.getInstallReferrer();
                                    if (installReferrer2 != null && (l.a((CharSequence) installReferrer2, (CharSequence) "fb", false, 2, (Object) null) || l.a((CharSequence) installReferrer2, (CharSequence) "facebook", false, 2, (Object) null))) {
                                        callback.onReceiveReferrerUrl(installReferrer2);
                                    }
                                    InstallReferrerUtil.INSTANCE.updateReferrer();
                                    return;
                                } catch (RemoteException unused) {
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                InstallReferrerUtil.INSTANCE.updateReferrer();
                                return;
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateReferrer() {
        FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
    }

    private final boolean isUpdated() {
        return FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean(IS_REFERRER_UPDATED, false);
    }
}
