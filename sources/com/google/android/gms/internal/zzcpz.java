package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* loaded from: classes.dex */
public final class zzcpz extends ConnectionsClient {
    private static final Api.zzf<zzcov> b = new Api.zzf<>();
    private static final Api.zza<zzcov, Api.ApiOptions.NoOptions> c = new ad();
    private static final Api<Api.ApiOptions.NoOptions> d = new Api<>("Nearby.CONNECTIONS_API", c, b);
    private final zzcon e;

    public zzcpz(Activity activity) {
        super(activity, d, GoogleApi.zza.zzfsr);
        this.e = zzcon.zzbdd();
    }

    public zzcpz(Context context) {
        super(context, d, GoogleApi.zza.zzfsr);
        this.e = zzcon.zzbdd();
    }

    private final Task<Void> a(an anVar) {
        return zzb(new am(this, anVar));
    }

    private final Task<Void> a(ap apVar) {
        return zzb(new ae(this, apVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        zzci<String> zza = this.e.zza((GoogleApi) this, str, "connection");
        this.e.zzb(this, new ak(this, zza), new al(this, zza.zzakx()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        zzcon zzconVar = this.e;
        zzconVar.zzb(this, zzconVar.zzb((GoogleApi) this, (zzcpz) str, "connection"));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> acceptConnection(final String str, PayloadCallback payloadCallback) {
        final zzci zza = zza(payloadCallback, PayloadCallback.class.getName());
        return a(new an(str, zza) { // from class: com.google.android.gms.internal.w

            /* renamed from: a, reason: collision with root package name */
            private final String f4676a;
            private final zzci b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4676a = str;
                this.b = zza;
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> cancelPayload(final long j) {
        return a(new an(j) { // from class: com.google.android.gms.internal.aa

            /* renamed from: a, reason: collision with root package name */
            private final long f1747a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1747a = j;
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void disconnectFromEndpoint(final String str) {
        a(new ap(str) { // from class: com.google.android.gms.internal.ab

            /* renamed from: a, reason: collision with root package name */
            private final String f1748a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1748a = str;
            }
        });
        b(str);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> rejectConnection(final String str) {
        return a(new an(str) { // from class: com.google.android.gms.internal.x

            /* renamed from: a, reason: collision with root package name */
            private final String f4677a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4677a = str;
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        final zzci zza = zza(new ao(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        a(str2);
        return a(new an(str, str2, zza) { // from class: com.google.android.gms.internal.v

            /* renamed from: a, reason: collision with root package name */
            private final String f4675a;
            private final String b;
            private final zzci c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4675a = str;
                this.b = str2;
                this.c = zza;
            }
        }).addOnFailureListener(new aj(this, str2));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(final String str, final Payload payload) {
        return a(new an(str, payload) { // from class: com.google.android.gms.internal.y

            /* renamed from: a, reason: collision with root package name */
            private final String f4678a;
            private final Payload b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4678a = str;
                this.b = payload;
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(final List<String> list, final Payload payload) {
        return a(new an(list, payload) { // from class: com.google.android.gms.internal.z

            /* renamed from: a, reason: collision with root package name */
            private final List f4679a;
            private final Payload b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4679a = list;
                this.b = payload;
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        zzci zza = zza(new ao(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzci zza2 = this.e.zza((GoogleApi) this, (zzcpz) new Object(), "advertising");
        return this.e.zzb(this, new af(this, zza2, str, str2, zza, advertisingOptions), new ag(this, zza2.zzakx()));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions) {
        zzci zza = this.e.zza((GoogleApi) this, (zzcpz) endpointDiscoveryCallback, "discovery");
        return this.e.zzb(this, new ah(this, zza, str, zza, discoveryOptions), new ai(this, zza.zzakx()));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAdvertising() {
        this.e.zza(this, "advertising");
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAllEndpoints() {
        stopAdvertising();
        stopDiscovery();
        a(ac.f1749a);
        this.e.zza(this, "connection");
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopDiscovery() {
        this.e.zza(this, "discovery");
    }
}
