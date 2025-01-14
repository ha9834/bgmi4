package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.iid.FirebaseInstanceId;

/* loaded from: classes2.dex */
final /* synthetic */ class zzq implements ComponentFactory {
    static final ComponentFactory zzki = new zzq();

    private zzq() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new RemoteConfigComponent((Context) componentContainer.get(Context.class), (FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class), ((AbtComponent) componentContainer.get(AbtComponent.class)).get("frc"), (AnalyticsConnector) componentContainer.get(AnalyticsConnector.class));
    }
}
