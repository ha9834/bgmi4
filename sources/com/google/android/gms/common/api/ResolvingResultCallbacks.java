package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f1299a;
    private final int b;

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public abstract void onSuccess(R r);

    public abstract void onUnresolvableFailure(Status status);

    @Override // com.google.android.gms.common.api.ResultCallbacks
    @KeepForSdk
    public final void onFailure(Status status) {
        if (status.hasResolution()) {
            try {
                status.startResolutionForResult(this.f1299a, this.b);
                return;
            } catch (IntentSender.SendIntentException e) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                onUnresolvableFailure(new Status(8));
                return;
            }
        }
        onUnresolvableFailure(status);
    }
}
