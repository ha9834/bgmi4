package com.google.firebase.abt;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes2.dex */
public class AbtException extends Exception {
    public AbtException(String str) {
        super(str);
    }

    public AbtException(String str, Exception exc) {
        super(str, exc);
    }
}
