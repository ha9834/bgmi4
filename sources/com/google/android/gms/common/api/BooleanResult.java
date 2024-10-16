package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
/* loaded from: classes.dex */
public class BooleanResult implements Result {

    /* renamed from: a, reason: collision with root package name */
    private final Status f1291a;
    private final boolean b;

    @ShowFirstParty
    @KeepForSdk
    public BooleanResult(Status status, boolean z) {
        this.f1291a = (Status) Preconditions.checkNotNull(status, "Status must not be null");
        this.b = z;
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public Status getStatus() {
        return this.f1291a;
    }

    @KeepForSdk
    public boolean getValue() {
        return this.b;
    }

    @KeepForSdk
    public final int hashCode() {
        return ((this.f1291a.hashCode() + 527) * 31) + (this.b ? 1 : 0);
    }

    @KeepForSdk
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.f1291a.equals(booleanResult.f1291a) && this.b == booleanResult.b;
    }
}
