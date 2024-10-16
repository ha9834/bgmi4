package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzz;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzgn;
import java.util.List;
import java.util.Map;

@KeepForSdk
/* loaded from: classes2.dex */
public class AppMeasurementSdk {

    /* renamed from: a, reason: collision with root package name */
    private final zzz f4718a;

    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class ConditionalUserProperty {

        @KeepForSdk
        public static final String ACTIVE = "active";

        @KeepForSdk
        public static final String CREATION_TIMESTAMP = "creation_timestamp";

        @KeepForSdk
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";

        @KeepForSdk
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";

        @KeepForSdk
        public static final String NAME = "name";

        @KeepForSdk
        public static final String ORIGIN = "origin";

        @KeepForSdk
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";

        @KeepForSdk
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";

        @KeepForSdk
        public static final String TIME_TO_LIVE = "time_to_live";

        @KeepForSdk
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";

        @KeepForSdk
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";

        @KeepForSdk
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";

        @KeepForSdk
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";

        @KeepForSdk
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";

        @KeepForSdk
        public static final String VALUE = "value";

        private ConditionalUserProperty() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public interface EventInterceptor extends zzgk {
        @Override // com.google.android.gms.measurement.internal.zzgk
        @ShowFirstParty
        @KeepForSdk
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public interface OnEventListener extends zzgn {
        @Override // com.google.android.gms.measurement.internal.zzgn
        @ShowFirstParty
        @KeepForSdk
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    @KeepForSdk
    public static AppMeasurementSdk getInstance(Context context) {
        return zzz.zza(context).zzg();
    }

    @KeepForSdk
    public static AppMeasurementSdk getInstance(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzz.zza(context, str, str2, str3, bundle).zzg();
    }

    public AppMeasurementSdk(zzz zzzVar) {
        this.f4718a = zzzVar;
    }

    @KeepForSdk
    public void setMeasurementEnabled(boolean z) {
        this.f4718a.setMeasurementEnabled(z);
    }

    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        this.f4718a.logEventInternal(str, str2, bundle);
    }

    @KeepForSdk
    public void logEventNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.f4718a.logEventInternalNoInterceptor(str, str2, bundle, j);
    }

    @KeepForSdk
    public void setUserProperty(String str, String str2, Object obj) {
        this.f4718a.setUserPropertyInternal(str, str2, obj);
    }

    @KeepForSdk
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.f4718a.getUserProperties(str, str2, z);
    }

    @KeepForSdk
    public void setConditionalUserProperty(Bundle bundle) {
        this.f4718a.setConditionalUserProperty(bundle);
    }

    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.f4718a.clearConditionalUserProperty(str, str2, bundle);
    }

    @KeepForSdk
    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.f4718a.getConditionalUserProperties(str, str2);
    }

    @KeepForSdk
    public String getCurrentScreenName() {
        return this.f4718a.getCurrentScreenName();
    }

    @KeepForSdk
    public String getCurrentScreenClass() {
        return this.f4718a.getCurrentScreenClass();
    }

    @KeepForSdk
    public String getAppInstanceId() {
        return this.f4718a.zzi();
    }

    @KeepForSdk
    public String getGmpAppId() {
        return this.f4718a.getGmpAppId();
    }

    @KeepForSdk
    public long generateEventId() {
        return this.f4718a.generateEventId();
    }

    @KeepForSdk
    public void beginAdUnitExposure(String str) {
        this.f4718a.beginAdUnitExposure(str);
    }

    @KeepForSdk
    public void endAdUnitExposure(String str) {
        this.f4718a.endAdUnitExposure(str);
    }

    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.f4718a.zza(eventInterceptor);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.f4718a.zza(onEventListener);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.f4718a.zzb(onEventListener);
    }

    @KeepForSdk
    public Bundle performActionWithResponse(Bundle bundle) {
        return this.f4718a.zza(bundle, true);
    }

    @KeepForSdk
    public void performAction(Bundle bundle) {
        this.f4718a.zza(bundle, false);
    }

    @KeepForSdk
    public int getMaxUserProperties(String str) {
        return this.f4718a.getMaxUserProperties(str);
    }

    @KeepForSdk
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.f4718a.setCurrentScreen(activity, str, str2);
    }

    @KeepForSdk
    public String getAppIdOrigin() {
        return this.f4718a.getAppIdOrigin();
    }
}
