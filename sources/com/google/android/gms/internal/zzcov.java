package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Hide
/* loaded from: classes.dex */
public final class zzcov extends zzab<zzcso> {

    /* renamed from: a, reason: collision with root package name */
    private final long f4683a;
    private final Set<k> b;
    private final Set<d> c;
    private zzctz d;

    public zzcov(Context context, Looper looper, zzr zzrVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, zzrVar, connectionCallbacks, onConnectionFailedListener);
        this.b = new HashSet();
        this.c = new HashSet();
        this.f4683a = hashCode();
    }

    private final void a() {
        Iterator<k> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        Iterator<d> it2 = this.c.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        this.b.clear();
        this.c.clear();
        zzctz zzctzVar = this.d;
        if (zzctzVar != null) {
            zzctzVar.a();
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status b(int i) {
        return new Status(i, ConnectionsStatusCodes.getStatusCodeString(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzcso) zzalw()).zza(new zzcot());
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        a();
        super.disconnect();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void disconnectFromEndpoint(String str) throws RemoteException {
        ((zzcso) zzalw()).zza(new zzcrv(str));
    }

    public final void onConnectionSuspended(int i) {
        if (i == 1) {
            a();
        }
        super.onConnectionSuspended(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void stopAdvertising() throws RemoteException {
        ((zzcso) zzalw()).zza(new zzcuo());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void stopAllEndpoints() throws RemoteException {
        ((zzcso) zzalw()).zza(new zzcuq());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void stopDiscovery() throws RemoteException {
        ((zzcso) zzalw()).zza(new zzcus());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(zzn<Status> zznVar, long j) throws RemoteException {
        ((zzcso) zzalw()).zza(new zzcor(new s(zznVar).asBinder(), j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(zzn<Status> zznVar, String str, zzci<PayloadCallback> zzciVar) throws RemoteException {
        ((zzcso) zzalw()).zza(new zzcop(new s(zznVar).asBinder(), (IBinder) null, str, (byte[]) null, new p(zzciVar).asBinder()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(zzn<Status> zznVar, String str, zzci<EndpointDiscoveryCallback> zzciVar, DiscoveryOptions discoveryOptions) throws RemoteException {
        k kVar = new k(zzciVar);
        this.b.add(kVar);
        ((zzcso) zzalw()).zza(new zzcum(new s(zznVar).asBinder(), (IBinder) null, str, 0L, discoveryOptions, kVar.asBinder()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(zzn<Status> zznVar, String str, String str2, zzci<ConnectionLifecycleCallback> zzciVar) throws RemoteException {
        d dVar = new d(zzciVar);
        this.c.add(dVar);
        ((zzcso) zzalw()).zza(new zzcug(new s(zznVar).asBinder(), (IBinder) null, (IBinder) null, str, str2, (byte[]) null, dVar.asBinder()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(zzn<Connections.StartAdvertisingResult> zznVar, String str, String str2, zzci<ConnectionLifecycleCallback> zzciVar, AdvertisingOptions advertisingOptions) throws RemoteException {
        d dVar = new d(zzciVar);
        this.c.add(dVar);
        ((zzcso) zzalw()).zza(new zzcuk(new u(zznVar).asBinder(), (IBinder) null, str, str2, 0L, advertisingOptions, dVar.asBinder()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(zzn<Status> zznVar, String[] strArr, Payload payload, boolean z) throws RemoteException {
        try {
            Pair<zzcub, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> a2 = zzcud.a(payload);
            ((zzcso) zzalw()).zza(new zzcui(new s(zznVar).asBinder(), strArr, (zzcub) a2.first, z));
            if (a2.second != null) {
                Pair pair = (Pair) a2.second;
                this.d.a(payload.asStream().asInputStream(), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.first), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.second), payload.getId());
            }
        } catch (IOException unused) {
            zznVar.setResult(b(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzj(zzn<Status> zznVar, String str) throws RemoteException {
        ((zzcso) zzalw()).zza(new zzcue(new s(zznVar).asBinder(), str));
    }
}
