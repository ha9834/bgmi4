package com.tencent.quantum;

import android.content.Context;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FirebasePush {
    static String TAG = "FirebasePush";

    public static void RegisteFCM(Context context) {
        boolean z;
        try {
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            Iterator<FirebaseApp> it = FirebaseApp.getApps(context).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                FirebaseApp next = it.next();
                if (next != null && "iGameFirebaseApp".equals(next.getName())) {
                    z = false;
                    break;
                }
            }
            if (z) {
                FirebaseApp.initializeApp(context, fromResource, "iGameFirebaseApp");
            }
            String token = FirebaseInstanceId.getInstance(FirebaseApp.getInstance("iGameFirebaseApp")).getToken();
            if (token == null || token.length() == 0) {
                return;
            }
            Log.d(TAG, "FCM token: " + token);
            Class.forName("com.adjust.sdk.Adjust").getMethod("setPushToken", String.class).invoke(null, token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
