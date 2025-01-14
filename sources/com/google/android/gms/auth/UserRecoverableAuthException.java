package com.google.android.gms.auth;

import android.content.Intent;

/* loaded from: classes.dex */
public class UserRecoverableAuthException extends GoogleAuthException {
    private final Intent mIntent;

    public UserRecoverableAuthException(String str, Intent intent) {
        super(str);
        this.mIntent = intent;
    }

    public Intent getIntent() {
        Intent intent = this.mIntent;
        if (intent == null) {
            return null;
        }
        return new Intent(intent);
    }
}
