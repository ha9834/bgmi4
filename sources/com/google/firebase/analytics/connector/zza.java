package com.google.firebase.analytics.connector;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class zza implements EventHandler {
    static final EventHandler zzace = new zza();

    private zza() {
    }

    @Override // com.google.firebase.events.EventHandler
    public final void handle(Event event) {
        AnalyticsConnectorImpl.zza(event);
    }
}
