package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.internal.measurement.zzx;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.connect.common.Constants;
import java.util.Map;

@DynamiteApi
/* loaded from: classes2.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzn {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    zzfj f4719a = null;
    private Map<Integer, zzgn> b = new androidx.b.a();

    /* loaded from: classes2.dex */
    class a implements zzgn {

        /* renamed from: a, reason: collision with root package name */
        private com.google.android.gms.internal.measurement.zzq f4720a;

        a(com.google.android.gms.internal.measurement.zzq zzqVar) {
            this.f4720a = zzqVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzgn
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.f4720a.onEvent(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.f4719a.zzab().zzgn().zza("Event listener threw exception", e);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements zzgk {

        /* renamed from: a, reason: collision with root package name */
        private com.google.android.gms.internal.measurement.zzq f4721a;

        b(com.google.android.gms.internal.measurement.zzq zzqVar) {
            this.f4721a = zzqVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzgk
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.f4721a.onEvent(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.f4719a.zzab().zzgn().zza("Event interceptor threw exception", e);
            }
        }
    }

    private final void a() {
        if (this.f4719a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void initialize(IObjectWrapper iObjectWrapper, zzx zzxVar, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfj zzfjVar = this.f4719a;
        if (zzfjVar == null) {
            this.f4719a = zzfj.zza(context, zzxVar);
        } else {
            zzfjVar.zzab().zzgn().zzao("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        a();
        this.f4719a.zzq().logEvent(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        a();
        this.f4719a.zzq().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void setUserId(String str, long j) throws RemoteException {
        a();
        this.f4719a.zzq().zza(null, "_id", str, true, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        a();
        this.f4719a.zzt().setCurrentScreen((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        a();
        this.f4719a.zzq().setMeasurementEnabled(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void resetAnalyticsData(long j) throws RemoteException {
        a();
        this.f4719a.zzq().resetAnalyticsData(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void setMinimumSessionDuration(long j) throws RemoteException {
        a();
        this.f4719a.zzq().setMinimumSessionDuration(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        a();
        this.f4719a.zzq().setSessionTimeoutDuration(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void getMaxUserProperties(String str, zzp zzpVar) throws RemoteException {
        a();
        this.f4719a.zzq();
        Preconditions.checkNotEmpty(str);
        this.f4719a.zzz().zza(zzpVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void getCurrentScreenName(zzp zzpVar) throws RemoteException {
        a();
        a(zzpVar, this.f4719a.zzq().getCurrentScreenName());
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void getCurrentScreenClass(zzp zzpVar) throws RemoteException {
        a();
        a(zzpVar, this.f4719a.zzq().getCurrentScreenClass());
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void getCachedAppInstanceId(zzp zzpVar) throws RemoteException {
        a();
        a(zzpVar, this.f4719a.zzq().zzi());
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void getAppInstanceId(zzp zzpVar) throws RemoteException {
        a();
        this.f4719a.zzaa().zza(new es(this, zzpVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void getDeepLink(zzp zzpVar) throws RemoteException {
        a();
        zzgp zzq = this.f4719a.zzq();
        zzq.zzo();
        if (!zzq.zzad().zzd(null, zzak.zzjc)) {
            zzq.zzz().zzb(zzpVar, "");
        } else if (zzq.zzac().u.get() > 0) {
            zzq.zzz().zzb(zzpVar, "");
        } else {
            zzq.zzac().u.set(zzq.zzx().currentTimeMillis());
            zzq.v.zza(zzpVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void getGmpAppId(zzp zzpVar) throws RemoteException {
        a();
        a(zzpVar, this.f4719a.zzq().getGmpAppId());
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void generateEventId(zzp zzpVar) throws RemoteException {
        a();
        this.f4719a.zzz().zza(zzpVar, this.f4719a.zzz().zzjv());
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        a();
        this.f4719a.zzp().beginAdUnitExposure(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        a();
        this.f4719a.zzp().endAdUnitExposure(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void initForTests(Map map) throws RemoteException {
        a();
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void logEventAndBundle(String str, String str2, Bundle bundle, zzp zzpVar, long j) throws RemoteException {
        a();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", Constants.JumpUrlConstants.SRC_TYPE_APP);
        this.f4719a.zzaa().zza(new gk(this, zzpVar, new zzai(str2, new zzah(bundle), Constants.JumpUrlConstants.SRC_TYPE_APP, j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        a();
        fb fbVar = this.f4719a.zzq().f4944a;
        if (fbVar != null) {
            this.f4719a.zzq().zzif();
            fbVar.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        a();
        fb fbVar = this.f4719a.zzq().f4944a;
        if (fbVar != null) {
            this.f4719a.zzq().zzif();
            fbVar.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        a();
        fb fbVar = this.f4719a.zzq().f4944a;
        if (fbVar != null) {
            this.f4719a.zzq().zzif();
            fbVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        a();
        fb fbVar = this.f4719a.zzq().f4944a;
        if (fbVar != null) {
            this.f4719a.zzq().zzif();
            fbVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        a();
        fb fbVar = this.f4719a.zzq().f4944a;
        if (fbVar != null) {
            this.f4719a.zzq().zzif();
            fbVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        a();
        fb fbVar = this.f4719a.zzq().f4944a;
        if (fbVar != null) {
            this.f4719a.zzq().zzif();
            fbVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzp zzpVar, long j) throws RemoteException {
        a();
        fb fbVar = this.f4719a.zzq().f4944a;
        Bundle bundle = new Bundle();
        if (fbVar != null) {
            this.f4719a.zzq().zzif();
            fbVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzpVar.zzb(bundle);
        } catch (RemoteException e) {
            this.f4719a.zzab().zzgn().zza("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void performAction(Bundle bundle, zzp zzpVar, long j) throws RemoteException {
        a();
        zzpVar.zzb(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void getUserProperties(String str, String str2, boolean z, zzp zzpVar) throws RemoteException {
        a();
        this.f4719a.zzaa().zza(new fn(this, zzpVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        a();
        this.f4719a.zzab().a(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzq zzqVar) throws RemoteException {
        a();
        zzgp zzq = this.f4719a.zzq();
        b bVar = new b(zzqVar);
        zzq.zzm();
        zzq.j();
        zzq.zzaa().zza(new em(zzq, bVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzq zzqVar) throws RemoteException {
        a();
        zzgn zzgnVar = this.b.get(Integer.valueOf(zzqVar.id()));
        if (zzgnVar == null) {
            zzgnVar = new a(zzqVar);
            this.b.put(Integer.valueOf(zzqVar.id()), zzgnVar);
        }
        this.f4719a.zzq().zza(zzgnVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzq zzqVar) throws RemoteException {
        a();
        zzgn remove = this.b.remove(Integer.valueOf(zzqVar.id()));
        if (remove == null) {
            remove = new a(zzqVar);
        }
        this.f4719a.zzq().zzb(remove);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void setInstanceIdProvider(zzv zzvVar) throws RemoteException {
        a();
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        a();
        if (bundle == null) {
            this.f4719a.zzab().zzgk().zzao("Conditional user property must not be null");
        } else {
            this.f4719a.zzq().setConditionalUserProperty(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        a();
        this.f4719a.zzq().clearConditionalUserProperty(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void getConditionalUserProperties(String str, String str2, zzp zzpVar) throws RemoteException {
        a();
        this.f4719a.zzaa().zza(new gz(this, zzpVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void getTestFlag(zzp zzpVar, int i) throws RemoteException {
        a();
        switch (i) {
            case 0:
                this.f4719a.zzz().zzb(zzpVar, this.f4719a.zzq().zzih());
                return;
            case 1:
                this.f4719a.zzz().zza(zzpVar, this.f4719a.zzq().zzii().longValue());
                return;
            case 2:
                zzjs zzz = this.f4719a.zzz();
                double doubleValue = this.f4719a.zzq().zzik().doubleValue();
                Bundle bundle = new Bundle();
                bundle.putDouble(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, doubleValue);
                try {
                    zzpVar.zzb(bundle);
                    return;
                } catch (RemoteException e) {
                    zzz.v.zzab().zzgn().zza("Error returning double value to wrapper", e);
                    return;
                }
            case 3:
                this.f4719a.zzz().zza(zzpVar, this.f4719a.zzq().zzij().intValue());
                return;
            case 4:
                this.f4719a.zzz().zza(zzpVar, this.f4719a.zzq().zzig().booleanValue());
                return;
            default:
                return;
        }
    }

    private final void a(zzp zzpVar, String str) {
        this.f4719a.zzz().zzb(zzpVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        a();
        this.f4719a.zzq().zza(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public void isDataCollectionEnabled(zzp zzpVar) throws RemoteException {
        a();
        this.f4719a.zzaa().zza(new gy(this, zzpVar));
    }
}
