package com.subao.common.k;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.net.DatagramSocket;
import java.util.ArrayDeque;
import java.util.Deque;

@TargetApi(21)
/* loaded from: classes2.dex */
class f implements e {

    /* renamed from: a, reason: collision with root package name */
    private final ConnectivityManager f6102a;
    private a b;

    /* loaded from: classes2.dex */
    public interface b {
        NetworkRequest a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ConnectivityManager connectivityManager, b bVar, ConnectivityManager.NetworkCallback networkCallback) {
        this.f6102a = connectivityManager;
        this.b = new a(networkCallback);
        connectivityManager.requestNetwork(bVar.a(), this.b);
    }

    @Override // com.subao.common.a
    public void a() {
        a aVar;
        synchronized (this) {
            aVar = this.b;
            this.b = null;
        }
        if (aVar != null) {
            this.f6102a.unregisterNetworkCallback(aVar);
        }
    }

    @Override // com.subao.common.k.e
    public boolean c() {
        return d() != null;
    }

    @Override // com.subao.common.k.e
    public int b() {
        Network d = d();
        if (d == null) {
            com.subao.common.d.a("SubaoParallel", "Dual-WiFi request failed (no available network)");
            return -1;
        }
        int a2 = a(d);
        Log.d("SubaoParallel", String.format(com.subao.common.e.r.f6001a, "Dual-WiFi request. fd=%d", Integer.valueOf(a2)));
        return a2;
    }

    private Network d() {
        a aVar = this.b;
        if (aVar == null) {
            Log.w("SubaoParallel", "Dual-WiFi get available network failed. (disposed)");
            return null;
        }
        return aVar.a();
    }

    private static int a(Network network) {
        DatagramSocket datagramSocket;
        try {
            datagramSocket = new DatagramSocket();
            try {
                try {
                    r.a(datagramSocket, network);
                    ParcelFileDescriptor fromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
                    if (fromDatagramSocket != null) {
                        int detachFd = fromDatagramSocket.detachFd();
                        datagramSocket.close();
                        return detachFd;
                    }
                    datagramSocket.close();
                    return -1;
                } catch (IOException | RuntimeException unused) {
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }
                    return -1;
                }
            } catch (Throwable th) {
                th = th;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                throw th;
            }
        } catch (IOException | RuntimeException unused2) {
            datagramSocket = null;
        } catch (Throwable th2) {
            th = th2;
            datagramSocket = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        private final ConnectivityManager.NetworkCallback f6103a;
        private final Deque<Network> b = new ArrayDeque(4);

        a(ConnectivityManager.NetworkCallback networkCallback) {
            this.f6103a = networkCallback;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            if (com.subao.common.d.a("SubaoParallel")) {
                Log.d("SubaoParallel", String.format("Dual-WiFi available: %s", network.toString()));
            }
            synchronized (this) {
                if (!this.b.contains(network)) {
                    this.b.add(network);
                    if (this.b.size() > 8) {
                        this.b.poll();
                    }
                }
            }
            ConnectivityManager.NetworkCallback networkCallback = this.f6103a;
            if (networkCallback != null) {
                networkCallback.onAvailable(network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            if (com.subao.common.d.a("SubaoParallel")) {
                Log.d("SubaoParallel", String.format("Dual-WiFi lost: %s", network.toString()));
            }
            synchronized (this) {
                this.b.remove(network);
            }
            ConnectivityManager.NetworkCallback networkCallback = this.f6103a;
            if (networkCallback != null) {
                networkCallback.onLost(network);
            }
        }

        Network a() {
            Network peekLast;
            synchronized (this) {
                peekLast = this.b.peekLast();
            }
            return peekLast;
        }
    }
}
