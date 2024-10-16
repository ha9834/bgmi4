package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzm extends zzb implements zzk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void initialize(IObjectWrapper iObjectWrapper, zzx zzxVar, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, iObjectWrapper);
        zzd.zza(a2, zzxVar);
        a2.writeLong(j);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzd.zza(a2, bundle);
        zzd.writeBoolean(a2, z);
        zzd.writeBoolean(a2, z2);
        a2.writeLong(j);
        b(2, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzp zzpVar, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzd.zza(a2, bundle);
        zzd.zza(a2, zzpVar);
        a2.writeLong(j);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzd.zza(a2, iObjectWrapper);
        zzd.writeBoolean(a2, z);
        a2.writeLong(j);
        b(4, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void getUserProperties(String str, String str2, boolean z, zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzd.writeBoolean(a2, z);
        zzd.zza(a2, zzpVar);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void getMaxUserProperties(String str, zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        zzd.zza(a2, zzpVar);
        b(6, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeLong(j);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, bundle);
        a2.writeLong(j);
        b(8, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzd.zza(a2, bundle);
        b(9, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void getConditionalUserProperties(String str, String str2, zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzd.zza(a2, zzpVar);
        b(10, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.writeBoolean(a2, z);
        a2.writeLong(j);
        b(11, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(12, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(13, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(14, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, iObjectWrapper);
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeLong(j);
        b(15, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void getCurrentScreenName(zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzpVar);
        b(16, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void getCurrentScreenClass(zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzpVar);
        b(17, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void setInstanceIdProvider(zzv zzvVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzvVar);
        b(18, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void getCachedAppInstanceId(zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzpVar);
        b(19, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void getAppInstanceId(zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzpVar);
        b(20, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void getGmpAppId(zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzpVar);
        b(21, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void generateEventId(zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzpVar);
        b(22, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeLong(j);
        b(23, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeLong(j);
        b(24, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, iObjectWrapper);
        a2.writeLong(j);
        b(25, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, iObjectWrapper);
        a2.writeLong(j);
        b(26, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, iObjectWrapper);
        zzd.zza(a2, bundle);
        a2.writeLong(j);
        b(27, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, iObjectWrapper);
        a2.writeLong(j);
        b(28, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, iObjectWrapper);
        a2.writeLong(j);
        b(29, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, iObjectWrapper);
        a2.writeLong(j);
        b(30, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzp zzpVar, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, iObjectWrapper);
        zzd.zza(a2, zzpVar);
        a2.writeLong(j);
        b(31, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void performAction(Bundle bundle, zzp zzpVar, long j) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, bundle);
        zzd.zza(a2, zzpVar);
        a2.writeLong(j);
        b(32, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        a2.writeString(str);
        zzd.zza(a2, iObjectWrapper);
        zzd.zza(a2, iObjectWrapper2);
        zzd.zza(a2, iObjectWrapper3);
        b(33, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void setEventInterceptor(zzq zzqVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzqVar);
        b(34, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void registerOnMeasurementEventListener(zzq zzqVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzqVar);
        b(35, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void unregisterOnMeasurementEventListener(zzq zzqVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzqVar);
        b(36, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void initForTests(Map map) throws RemoteException {
        Parcel a2 = a();
        a2.writeMap(map);
        b(37, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void getTestFlag(zzp zzpVar, int i) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzpVar);
        a2.writeInt(i);
        b(38, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel a2 = a();
        zzd.writeBoolean(a2, z);
        b(39, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void isDataCollectionEnabled(zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzpVar);
        b(40, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzk
    public final void getDeepLink(zzp zzpVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzpVar);
        b(41, a2);
    }
}
