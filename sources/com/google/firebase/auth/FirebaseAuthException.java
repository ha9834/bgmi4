package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;
import com.google.firebase.annotations.PublicApi;

@PublicApi
/* loaded from: classes2.dex */
public class FirebaseAuthException extends FirebaseException {
    private final String errorCode;

    @PublicApi
    public FirebaseAuthException(String str, String str2) {
        super(str2);
        this.errorCode = Preconditions.checkNotEmpty(str);
    }

    @PublicApi
    public String getErrorCode() {
        return this.errorCode;
    }
}
