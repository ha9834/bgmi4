package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.Set;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client, GmsClientEventManager.GmsClientEventState {
    private final ClientSettings d;
    private final Set<Scope> e;
    private final Account f;

    @KeepForSdk
    protected Set<Scope> a(Set<Scope> set) {
        return set;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public GmsClient(Context context, Looper looper, int i, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i, clientSettings, (GoogleApiClient.ConnectionCallbacks) Preconditions.checkNotNull(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) Preconditions.checkNotNull(onConnectionFailedListener));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public GmsClient(Context context, Looper looper, int i, ClientSettings clientSettings) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i, clientSettings, null, null);
    }

    @VisibleForTesting
    protected GmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int i, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, gmsClientSupervisor, googleApiAvailability, i, a(connectionCallbacks), a(onConnectionFailedListener), clientSettings.getRealClientClassName());
        this.d = clientSettings;
        this.f = clientSettings.getAccount();
        this.e = b(clientSettings.getAllRequestedScopes());
    }

    private final Set<Scope> b(Set<Scope> set) {
        Set<Scope> a2 = a(set);
        Iterator<Scope> it = a2.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a2;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Account getAccount() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public final ClientSettings h() {
        return this.d;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Set<Scope> g() {
        return this.e;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    private static BaseGmsClient.BaseConnectionCallbacks a(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new d(connectionCallbacks);
    }

    private static BaseGmsClient.BaseOnConnectionFailedListener a(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new e(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }
}
