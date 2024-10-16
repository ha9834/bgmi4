package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* loaded from: classes2.dex */
final class ab extends ai {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ PendingIntent f4996a;
    private /* synthetic */ aj b;
    private /* synthetic */ SubscribeOptions c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(zzbi zzbiVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent, aj ajVar, SubscribeOptions subscribeOptions) {
        super(googleApiClient);
        this.f4996a = pendingIntent;
        this.b = ajVar;
        this.c = subscribeOptions;
    }
}
