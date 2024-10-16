package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class y extends ai {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ Message f5021a;
    private /* synthetic */ ag b;
    private /* synthetic */ PublishOptions c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(zzbi zzbiVar, GoogleApiClient googleApiClient, Message message, ag agVar, PublishOptions publishOptions) {
        super(googleApiClient);
        this.f5021a = message;
        this.b = agVar;
        this.c = publishOptions;
    }
}
