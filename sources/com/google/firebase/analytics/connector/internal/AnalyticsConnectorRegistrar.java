package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.BuildConfig;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
/* loaded from: classes2.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @KeepForSdk
    @SuppressLint({"MissingPermission"})
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(AnalyticsConnector.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Context.class)).add(Dependency.required(Subscriber.class)).factory(zzb.zzach).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-analytics", BuildConfig.VERSION_NAME));
    }
}
