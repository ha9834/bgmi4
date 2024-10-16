package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfj;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzgl;
import com.google.android.gms.measurement.internal.zzgn;
import com.google.android.gms.measurement.internal.zzhi;
import com.google.android.gms.measurement.internal.zzho;
import com.google.android.gms.measurement.internal.zzjn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@Deprecated
/* loaded from: classes2.dex */
public class AppMeasurement {

    @ShowFirstParty
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";

    @ShowFirstParty
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";

    @ShowFirstParty
    @KeepForSdk
    public static final String FIAM_ORIGIN = "fiam";

    /* renamed from: a, reason: collision with root package name */
    private static volatile AppMeasurement f4713a;
    private final zzfj b;
    private final zzhi c;
    private final boolean d;

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static class ConditionalUserProperty {

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public boolean mActive;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mAppId;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mName;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mOrigin;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mTriggerEventName;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTriggeredTimestamp;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public Object mValue;

        @KeepForSdk
        public ConditionalUserProperty() {
        }

        @KeepForSdk
        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                this.mValue = zzho.zza(obj);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            Bundle bundle = conditionalUserProperty.mTimedOutEventParams;
            if (bundle != null) {
                this.mTimedOutEventParams = new Bundle(bundle);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            Bundle bundle2 = conditionalUserProperty.mTriggeredEventParams;
            if (bundle2 != null) {
                this.mTriggeredEventParams = new Bundle(bundle2);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            Bundle bundle3 = conditionalUserProperty.mExpiredEventParams;
            if (bundle3 != null) {
                this.mExpiredEventParams = new Bundle(bundle3);
            }
        }

        private ConditionalUserProperty(Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzgg.zza(bundle, "app_id", String.class, null);
            this.mOrigin = (String) zzgg.zza(bundle, "origin", String.class, null);
            this.mName = (String) zzgg.zza(bundle, "name", String.class, null);
            this.mValue = zzgg.zza(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
            this.mTriggerTimeout = ((Long) zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
            this.mTimedOutEventParams = (Bundle) zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
            this.mTriggeredEventName = (String) zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
            this.mTriggeredEventParams = (Bundle) zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
            this.mTimeToLive = ((Long) zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
            this.mExpiredEventParams = (Bundle) zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                zzgg.zza(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str4);
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, this.mTriggeredTimestamp);
            return bundle;
        }
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class Event extends zzgj {

        @ShowFirstParty
        @KeepForSdk
        public static final String AD_REWARD = "_ar";

        @ShowFirstParty
        @KeepForSdk
        public static final String APP_EXCEPTION = "_ae";

        private Event() {
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

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class Param extends zzgi {

        @ShowFirstParty
        @KeepForSdk
        public static final String FATAL = "fatal";

        @ShowFirstParty
        @KeepForSdk
        public static final String TIMESTAMP = "timestamp";

        @ShowFirstParty
        @KeepForSdk
        public static final String TYPE = "type";

        private Param() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class UserProperty extends zzgl {

        @ShowFirstParty
        @KeepForSdk
        public static final String FIREBASE_LAST_NOTIFICATION = "_ln";

        private UserProperty() {
        }
    }

    @ShowFirstParty
    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return a(context, null, null);
    }

    @VisibleForTesting
    private static AppMeasurement a(Context context, String str, String str2) {
        if (f4713a == null) {
            synchronized (AppMeasurement.class) {
                if (f4713a == null) {
                    zzhi a2 = a(context, null);
                    if (a2 != null) {
                        f4713a = new AppMeasurement(a2);
                    } else {
                        f4713a = new AppMeasurement(zzfj.zza(context, null, null, null));
                    }
                }
            }
        }
        return f4713a;
    }

    public static AppMeasurement zza(Context context, Bundle bundle) {
        if (f4713a == null) {
            synchronized (AppMeasurement.class) {
                if (f4713a == null) {
                    zzhi a2 = a(context, bundle);
                    if (a2 != null) {
                        f4713a = new AppMeasurement(a2);
                    } else {
                        f4713a = new AppMeasurement(zzfj.zza(context, null, null, bundle));
                    }
                }
            }
        }
        return f4713a;
    }

    private static zzhi a(Context context, Bundle bundle) {
        try {
            try {
                return (zzhi) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, bundle);
            } catch (Exception unused) {
                return null;
            }
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @KeepForSdk
    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        if (this.d) {
            this.c.setMeasurementEnabled(z);
        } else {
            this.b.zzq().setMeasurementEnabled(z);
        }
    }

    public final void zza(boolean z) {
        if (this.d) {
            this.c.setDataCollectionEnabled(z);
        } else {
            this.b.zzq().zza(z);
        }
    }

    private AppMeasurement(zzfj zzfjVar) {
        Preconditions.checkNotNull(zzfjVar);
        this.b = zzfjVar;
        this.c = null;
        this.d = false;
    }

    private AppMeasurement(zzhi zzhiVar) {
        Preconditions.checkNotNull(zzhiVar);
        this.c = zzhiVar;
        this.b = null;
        this.d = true;
    }

    @ShowFirstParty
    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.d) {
            this.c.logEventInternal(str, str2, bundle);
        } else {
            this.b.zzq().logEvent(str, str2, bundle);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        if (this.d) {
            this.c.logEventInternalNoInterceptor(str, str2, bundle, j);
        } else {
            this.b.zzq().logEvent(str, str2, bundle, true, false, j);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public void setUserPropertyInternal(String str, String str2, Object obj) {
        Preconditions.checkNotEmpty(str);
        if (this.d) {
            this.c.setUserPropertyInternal(str, str2, obj);
        } else {
            this.b.zzq().zzb(str, str2, obj, true);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        if (this.d) {
            return this.c.getUserProperties(null, null, z);
        }
        List<zzjn> zzh = this.b.zzq().zzh(z);
        androidx.b.a aVar = new androidx.b.a(zzh.size());
        for (zzjn zzjnVar : zzh) {
            aVar.put(zzjnVar.name, zzjnVar.getValue());
        }
        return aVar;
    }

    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        if (this.d) {
            this.c.zza(eventInterceptor);
        } else {
            this.b.zzq().zza(eventInterceptor);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        if (this.d) {
            this.c.zza(onEventListener);
        } else {
            this.b.zzq().zza(onEventListener);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        if (this.d) {
            this.c.zzb(onEventListener);
        } else {
            this.b.zzq().zzb(onEventListener);
        }
    }

    @Keep
    public String getCurrentScreenName() {
        if (this.d) {
            return this.c.getCurrentScreenName();
        }
        return this.b.zzq().getCurrentScreenName();
    }

    @Keep
    public String getCurrentScreenClass() {
        if (this.d) {
            return this.c.getCurrentScreenClass();
        }
        return this.b.zzq().getCurrentScreenClass();
    }

    @Keep
    public String getAppInstanceId() {
        if (this.d) {
            return this.c.zzi();
        }
        return this.b.zzq().zzi();
    }

    @Keep
    public String getGmpAppId() {
        if (this.d) {
            return this.c.getGmpAppId();
        }
        return this.b.zzq().getGmpAppId();
    }

    @Keep
    public long generateEventId() {
        if (this.d) {
            return this.c.generateEventId();
        }
        return this.b.zzz().zzjv();
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        if (this.d) {
            this.c.beginAdUnitExposure(str);
        } else {
            this.b.zzp().beginAdUnitExposure(str, this.b.zzx().elapsedRealtime());
        }
    }

    @Keep
    public void endAdUnitExposure(String str) {
        if (this.d) {
            this.c.endAdUnitExposure(str);
        } else {
            this.b.zzp().endAdUnitExposure(str, this.b.zzx().elapsedRealtime());
        }
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        if (this.d) {
            this.c.setConditionalUserProperty(conditionalUserProperty.a());
        } else {
            this.b.zzq().setConditionalUserProperty(conditionalUserProperty.a());
        }
    }

    @VisibleForTesting
    @Keep
    protected void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        if (!this.d) {
            this.b.zzq().zzd(conditionalUserProperty.a());
            return;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (this.d) {
            this.c.clearConditionalUserProperty(str, str2, bundle);
        } else {
            this.b.zzq().clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @VisibleForTesting
    @Keep
    protected void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        if (this.d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.b.zzq().clearConditionalUserPropertyAs(str, str2, str3, bundle);
    }

    @VisibleForTesting
    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        if (this.d) {
            return this.c.getUserProperties(str, str2, z);
        }
        return this.b.zzq().getUserProperties(str, str2, z);
    }

    @VisibleForTesting
    @Keep
    protected Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        if (this.d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        return this.b.zzq().getUserPropertiesAs(str, str2, str3, z);
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> zzn;
        if (this.d) {
            zzn = this.c.getConditionalUserProperties(str, str2);
        } else {
            zzn = this.b.zzq().zzn(str, str2);
        }
        ArrayList arrayList = new ArrayList(zzn == null ? 0 : zzn.size());
        Iterator<Bundle> it = zzn.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @VisibleForTesting
    @Keep
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        if (this.d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        ArrayList<Bundle> zzd = this.b.zzq().zzd(str, str2, str3);
        int i = 0;
        ArrayList arrayList = new ArrayList(zzd == null ? 0 : zzd.size());
        ArrayList<Bundle> arrayList2 = zzd;
        int size = arrayList2.size();
        while (i < size) {
            Bundle bundle = arrayList2.get(i);
            i++;
            arrayList.add(new ConditionalUserProperty(bundle));
        }
        return arrayList;
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public int getMaxUserProperties(String str) {
        if (this.d) {
            return this.c.getMaxUserProperties(str);
        }
        this.b.zzq();
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @KeepForSdk
    public Boolean getBoolean() {
        if (this.d) {
            return (Boolean) this.c.zzb(4);
        }
        return this.b.zzq().zzig();
    }

    @KeepForSdk
    public String getString() {
        if (this.d) {
            return (String) this.c.zzb(0);
        }
        return this.b.zzq().zzih();
    }

    @KeepForSdk
    public Long getLong() {
        if (this.d) {
            return (Long) this.c.zzb(1);
        }
        return this.b.zzq().zzii();
    }

    @KeepForSdk
    public Integer getInteger() {
        if (this.d) {
            return (Integer) this.c.zzb(3);
        }
        return this.b.zzq().zzij();
    }

    @KeepForSdk
    public Double getDouble() {
        if (this.d) {
            return (Double) this.c.zzb(2);
        }
        return this.b.zzq().zzik();
    }
}
