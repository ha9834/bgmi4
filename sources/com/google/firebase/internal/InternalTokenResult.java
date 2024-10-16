package com.google.firebase.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;

@KeepForSdk
/* loaded from: classes2.dex */
public class InternalTokenResult {
    private String token;

    @KeepForSdk
    public InternalTokenResult(String str) {
        this.token = str;
    }

    @KeepForSdk
    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        return Objects.hashCode(this.token);
    }

    public boolean equals(Object obj) {
        if (obj instanceof InternalTokenResult) {
            return Objects.equal(this.token, ((InternalTokenResult) obj).token);
        }
        return false;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("token", this.token).toString();
    }
}
