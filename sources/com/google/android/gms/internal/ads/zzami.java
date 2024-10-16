package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@zzard
/* loaded from: classes2.dex */
public final class zzami extends zzbjg {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f2756a = new AtomicBoolean(false);
    private final AppMeasurementSdk b;

    private zzami(AppMeasurementSdk appMeasurementSdk) {
        this.b = appMeasurementSdk;
    }

    public static void initialize(final Context context, final String str) {
        if (f2756a.compareAndSet(false, true)) {
            new Thread(new Runnable(context, str) { // from class: com.google.android.gms.internal.ads.cq

                /* renamed from: a, reason: collision with root package name */
                private final Context f2103a;
                private final String b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2103a = context;
                    this.b = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzami.a(this.f2103a, this.b);
                }
            }).start();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void performAction(Bundle bundle) throws RemoteException {
        this.b.performAction(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final Bundle performActionWithResponse(Bundle bundle) throws RemoteException {
        return this.b.performActionWithResponse(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void logEvent(String str, String str2, Bundle bundle) throws RemoteException {
        this.b.logEvent(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.b.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final Map getUserProperties(String str, String str2, boolean z) throws RemoteException {
        return this.b.getUserProperties(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final int getMaxUserProperties(String str) throws RemoteException {
        return this.b.getMaxUserProperties(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void setConditionalUserProperty(Bundle bundle) throws RemoteException {
        this.b.setConditionalUserProperty(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        this.b.clearConditionalUserProperty(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final List getConditionalUserProperties(String str, String str2) throws RemoteException {
        return this.b.getConditionalUserProperties(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String getAppInstanceId() throws RemoteException {
        return this.b.getAppInstanceId();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String getGmpAppId() throws RemoteException {
        return this.b.getGmpAppId();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final long generateEventId() throws RemoteException {
        return this.b.generateEventId();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void beginAdUnitExposure(String str) throws RemoteException {
        this.b.beginAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void endAdUnitExposure(String str) throws RemoteException {
        this.b.endAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.b.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String getCurrentScreenName() throws RemoteException {
        return this.b.getCurrentScreenName();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String getCurrentScreenClass() throws RemoteException {
        return this.b.getCurrentScreenClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String getAppIdOrigin() throws RemoteException {
        return this.b.getAppIdOrigin();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(Context context, String str) {
        boolean z;
        zzacu.initialize(context);
        try {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcoa)).booleanValue()) {
                if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcnz)).booleanValue()) {
                    z = false;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("measurementEnabled", z);
                    ((zzbjh) zzbae.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", cr.f2104a)).zzc(new zzami(AppMeasurementSdk.getInstance(context, AdRequest.LOGTAG, "am", str, bundle)));
                    return;
                }
            }
            ((zzbjh) zzbae.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", cr.f2104a)).zzc(new zzami(AppMeasurementSdk.getInstance(context, AdRequest.LOGTAG, "am", str, bundle)));
            return;
        } catch (RemoteException | zzbag | NullPointerException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return;
        }
        z = true;
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("measurementEnabled", z);
    }
}
