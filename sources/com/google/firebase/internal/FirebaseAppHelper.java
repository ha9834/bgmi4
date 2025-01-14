package com.google.firebase.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.GetTokenResult;

@KeepForSdk
@Deprecated
/* loaded from: classes2.dex */
public class FirebaseAppHelper {
    @KeepForSdk
    public static Task<GetTokenResult> getToken(FirebaseApp firebaseApp, boolean z) {
        return firebaseApp.getToken(z);
    }

    @KeepForSdk
    public static void addIdTokenListener(FirebaseApp firebaseApp, FirebaseApp.IdTokenListener idTokenListener) {
        firebaseApp.addIdTokenListener(idTokenListener);
    }

    @KeepForSdk
    public static void removeIdTokenListener(FirebaseApp firebaseApp, FirebaseApp.IdTokenListener idTokenListener) {
        firebaseApp.removeIdTokenListener(idTokenListener);
    }

    @KeepForSdk
    public static String getUid(FirebaseApp firebaseApp) throws FirebaseApiNotAvailableException {
        return firebaseApp.getUid();
    }
}
