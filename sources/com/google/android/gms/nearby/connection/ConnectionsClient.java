package com.google.android.gms.nearby.connection;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ConnectionsClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    public static int MAX_BYTES_DATA_SIZE = 32768;

    /* JADX INFO: Access modifiers changed from: protected */
    @Hide
    public ConnectionsClient(Activity activity, Api<Api.ApiOptions.NoOptions> api, GoogleApi.zza zzaVar) {
        super(activity, api, (Api.ApiOptions) null, zzaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Hide
    public ConnectionsClient(Context context, Api<Api.ApiOptions.NoOptions> api, GoogleApi.zza zzaVar) {
        super(context, api, (Api.ApiOptions) null, zzaVar);
    }

    public abstract Task<Void> acceptConnection(String str, PayloadCallback payloadCallback);

    public abstract Task<Void> cancelPayload(long j);

    public abstract void disconnectFromEndpoint(String str);

    public abstract Task<Void> rejectConnection(String str);

    public abstract Task<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback);

    public abstract Task<Void> sendPayload(String str, Payload payload);

    public abstract Task<Void> sendPayload(List<String> list, Payload payload);

    public abstract Task<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions);

    public abstract Task<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions);

    public abstract void stopAdvertising();

    public abstract void stopAllEndpoints();

    public abstract void stopDiscovery();
}
