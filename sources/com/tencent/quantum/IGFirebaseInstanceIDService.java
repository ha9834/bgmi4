package com.tencent.quantum;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/* loaded from: classes.dex */
public class IGFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "IGFirebaseInstanceIDService";

    @Override // com.google.firebase.iid.FirebaseInstanceIdService
    public void onTokenRefresh() {
        Log.d(TAG, "onTokenRefresh()");
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token != null) {
            Log.d(TAG, "Refreshed token: " + token);
            try {
                Class.forName("com.adjust.sdk.Adjust").getMethod("setPushToken", String.class).invoke(null, token);
            } catch (Exception unused) {
                Log.d(TAG, "Adjust plugin is not linked.");
            }
        }
    }
}
