package com.subao.common.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.google.android.gms.games.GamesStatusCodes;
import com.subao.common.k.m;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
class o implements n {

    /* renamed from: a, reason: collision with root package name */
    private final ConnectivityManager f6113a;
    private final List<ConnectivityManager.NetworkCallback> b = new ArrayList(4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            throw new m.d(2018);
        }
        this.f6113a = connectivityManager;
    }

    private static int a(m.e eVar) {
        switch (eVar) {
            case WIFI:
                return 1;
            case BLUETOOTH:
                return 2;
            case ETHERNET:
                return 3;
            case VPN:
                return 4;
            default:
                return 0;
        }
    }

    private void a(m.e eVar, ConnectivityManager.NetworkCallback networkCallback) {
        NetworkRequest build;
        try {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(a(eVar));
            build = builder.build();
        } catch (RuntimeException e) {
            com.subao.common.d.c("SubaoParallel", e.getMessage());
        }
        if (build != null) {
            this.f6113a.requestNetwork(build, networkCallback);
        } else {
            com.subao.common.d.c("SubaoParallel", "NetworkRequest.Builder.build() return null");
            com.subao.common.d.c("SubaoParallel", "requestNetwork() failed !!!");
            throw new m.d(GamesStatusCodes.STATUS_REQUEST_TOO_MANY_RECIPIENTS);
        }
    }

    @Override // com.subao.common.k.n
    public Object a(m.e eVar, m.a aVar) {
        a aVar2 = new a(aVar);
        a(eVar, aVar2);
        synchronized (this) {
            this.b.add(aVar2);
        }
        return aVar2;
    }

    @Override // com.subao.common.k.n
    public void a(Object obj) {
        boolean remove;
        if (obj != null) {
            synchronized (this) {
                remove = this.b.remove(obj);
            }
            if (remove) {
                this.f6113a.unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.subao.common.a
    public void a() {
        ConnectivityManager.NetworkCallback[] networkCallbackArr;
        synchronized (this) {
            int size = this.b.size();
            if (size > 0) {
                networkCallbackArr = (ConnectivityManager.NetworkCallback[]) this.b.toArray(new ConnectivityManager.NetworkCallback[size]);
                this.b.clear();
            } else {
                networkCallbackArr = null;
            }
        }
        if (networkCallbackArr != null) {
            for (ConnectivityManager.NetworkCallback networkCallback : networkCallbackArr) {
                this.f6113a.unregisterNetworkCallback(networkCallback);
            }
        }
    }

    /* loaded from: classes2.dex */
    static class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        private final m.a f6115a;

        public a(m.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null callback");
            }
            this.f6115a = aVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            this.f6115a.b(new p(network));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.f6115a.c(new p(network));
        }
    }
}
