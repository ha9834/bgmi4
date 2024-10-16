package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.Nearby;

/* loaded from: classes2.dex */
abstract class ai extends com.google.android.gms.common.api.internal.zzm<Status, zzah> {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.zzci<com.google.android.gms.common.api.internal.zzn<Status>> f5001a;

    public ai(GoogleApiClient googleApiClient) {
        super(Nearby.MESSAGES_API, googleApiClient);
        this.f5001a = googleApiClient.zzt(this);
    }
}
