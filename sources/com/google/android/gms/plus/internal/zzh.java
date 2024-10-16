package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.plus.zzr;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzh extends GmsClient<zzf> {
    private Person d;
    private final zzn e;

    public zzh(Context context, Looper looper, ClientSettings clientSettings, zzn zznVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.e = zznVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String a() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.d = zzr.zza(bundle.getByteArray("loaded_person"));
        }
        super.a(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
        return queryLocalInterface instanceof zzf ? (zzf) queryLocalInterface : new zzg(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle d() {
        Bundle zze = this.e.zze();
        zze.putStringArray("request_visible_actions", this.e.zzc());
        zze.putString(ServiceSpecificExtraArgs.PlusExtraArgs.PLUS_AUTH_PACKAGE, this.e.zzd());
        return zze;
    }

    @VisibleForTesting
    public final String getAccountName() {
        e();
        try {
            return ((zzf) getService()).getAccountName();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.plus.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        Set<Scope> applicableScopes = h().getApplicableScopes(Plus.API);
        if (applicableScopes == null || applicableScopes.isEmpty()) {
            return false;
        }
        return (applicableScopes.size() == 1 && applicableScopes.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    @VisibleForTesting
    public final ICancelToken zza(BaseImplementation.ResultHolder<People.LoadPeopleResult> resultHolder, int i, String str) {
        e();
        b bVar = new b(resultHolder);
        try {
            return ((zzf) getService()).zza(bVar, 1, i, -1, str);
        } catch (RemoteException unused) {
            bVar.zza(DataHolder.empty(8), (String) null);
            return null;
        }
    }

    @VisibleForTesting
    public final void zza() {
        e();
        try {
            this.d = null;
            ((zzf) getService()).zza();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<People.LoadPeopleResult> resultHolder) {
        e();
        b bVar = new b(resultHolder);
        try {
            ((zzf) getService()).zza(bVar, 2, 1, -1, null);
        } catch (RemoteException unused) {
            bVar.zza(DataHolder.empty(8), (String) null);
        }
    }

    @VisibleForTesting
    public final void zza(BaseImplementation.ResultHolder<People.LoadPeopleResult> resultHolder, Collection<String> collection) {
        e();
        b bVar = new b(resultHolder);
        try {
            ((zzf) getService()).zza(bVar, new ArrayList(collection));
        } catch (RemoteException unused) {
            bVar.zza(DataHolder.empty(8), (String) null);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<People.LoadPeopleResult> resultHolder, String[] strArr) {
        zza(resultHolder, Arrays.asList(strArr));
    }

    @VisibleForTesting
    public final Person zzb() {
        e();
        return this.d;
    }

    @VisibleForTesting
    public final void zzb(BaseImplementation.ResultHolder<Status> resultHolder) {
        e();
        zza();
        c cVar = new c(resultHolder);
        try {
            ((zzf) getService()).zza(cVar);
        } catch (RemoteException unused) {
            cVar.zza(8, (Bundle) null);
        }
    }
}
