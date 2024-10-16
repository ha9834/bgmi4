package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzd;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzacb;

    @VisibleForTesting
    private final AppMeasurement zzacc;

    @VisibleForTesting
    final Map<String, com.google.firebase.analytics.connector.internal.zza> zzacd;

    private AnalyticsConnectorImpl(AppMeasurement appMeasurement) {
        Preconditions.checkNotNull(appMeasurement);
        this.zzacc = appMeasurement;
        this.zzacd = new ConcurrentHashMap();
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzacb == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzacb == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zzb.zzacf, zza.zzace);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzacb = new AnalyticsConnectorImpl(AppMeasurement.zza(context, bundle));
                }
            }
        }
        return zzacb;
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzd.zzdj(str) && zzd.zza(str2, bundle) && zzd.zzb(str, str2, bundle)) {
            this.zzacc.logEventInternal(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void setUserProperty(String str, String str2, Object obj) {
        if (zzd.zzdj(str) && zzd.zzu(str, str2)) {
            this.zzacc.setUserPropertyInternal(str, str2, obj);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzacc.getUserProperties(z);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        com.google.firebase.analytics.connector.internal.zza zzeVar;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzd.zzdj(str) || zzdi(str)) {
            return null;
        }
        AppMeasurement appMeasurement = this.zzacc;
        if ("fiam".equals(str)) {
            zzeVar = new zzc(appMeasurement, analyticsConnectorListener);
        } else {
            zzeVar = "crash".equals(str) ? new zze(appMeasurement, analyticsConnectorListener) : null;
        }
        if (zzeVar == null) {
            return null;
        }
        this.zzacd.put(str, zzeVar);
        return new AnalyticsConnector.AnalyticsConnectorHandle() { // from class: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.1
            @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
            public void unregister() {
                if (AnalyticsConnectorImpl.this.zzdi(str)) {
                    AnalyticsConnector.AnalyticsConnectorListener zzrr = AnalyticsConnectorImpl.this.zzacd.get(str).zzrr();
                    if (zzrr != null) {
                        zzrr.onMessageTriggered(0, null);
                    }
                    AnalyticsConnectorImpl.this.zzacd.remove(str);
                }
            }

            @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
            @KeepForSdk
            public void registerEventNames(Set<String> set) {
                if (!AnalyticsConnectorImpl.this.zzdi(str) || !str.equals("fiam") || set == null || set.isEmpty()) {
                    return;
                }
                AnalyticsConnectorImpl.this.zzacd.get(str).registerEventNames(set);
            }

            @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
            @KeepForSdk
            public void unregisterEventNames() {
                if (AnalyticsConnectorImpl.this.zzdi(str) && str.equals("fiam")) {
                    AnalyticsConnectorImpl.this.zzacd.get(str).unregisterEventNames();
                }
            }
        };
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzd.zza(conditionalUserProperty)) {
            this.zzacc.setConditionalUserProperty(zzd.zzb(conditionalUserProperty));
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzd.zza(str2, bundle)) {
            this.zzacc.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<AppMeasurement.ConditionalUserProperty> it = this.zzacc.getConditionalUserProperties(str, str2).iterator();
        while (it.hasNext()) {
            arrayList.add(zzd.zzb(it.next()));
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public int getMaxUserProperties(String str) {
        return this.zzacc.getMaxUserProperties(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzdi(String str) {
        return (str.isEmpty() || !this.zzacd.containsKey(str) || this.zzacd.get(str) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) zzacb).zzacc.zza(z);
        }
    }
}
