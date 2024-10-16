package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.nearby.Nearby;

/* loaded from: classes.dex */
abstract class bk<R extends Result> extends zzm<R, zzcov> {
    public bk(GoogleApiClient googleApiClient) {
        super(Nearby.CONNECTIONS_API, googleApiClient);
    }
}
