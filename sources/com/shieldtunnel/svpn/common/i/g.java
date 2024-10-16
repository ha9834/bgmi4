package com.shieldtunnel.svpn.common.i;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.i.h;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import java.util.Locale;

/* loaded from: classes2.dex */
public class g implements h {

    @SuppressLint({"StaticFieldLeak"})
    private static g f;

    /* renamed from: a, reason: collision with root package name */
    private final Context f5849a;
    private boolean b;
    private boolean c;
    private h.a d;
    private a e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Context context, h.a aVar);
    }

    /* loaded from: classes2.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (NetWorkChangeReceiver.NETWORK_CHANGE_ACTION.equals(intent.getAction())) {
                g.this.d(context);
            }
        }
    }

    private g(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f5849a = applicationContext;
        applicationContext.registerReceiver(new b(), new IntentFilter(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION));
        c(applicationContext);
    }

    public static g a(Context context) {
        g gVar;
        g gVar2 = f;
        if (gVar2 != null) {
            return gVar2;
        }
        synchronized (g.class) {
            gVar = f;
            if (gVar == null) {
                gVar = new g(context);
                f = gVar;
            }
        }
        return gVar;
    }

    private static boolean b(NetworkInfo networkInfo) {
        return networkInfo != null && NetworkInfo.State.CONNECTED == networkInfo.getState();
    }

    private void e() {
        this.b = false;
        this.c = false;
    }

    private void f() {
        this.b = true;
        this.c = false;
    }

    private void g() {
        this.b = true;
        this.c = true;
    }

    void c(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (connectivityManager == null) {
            e();
            return;
        }
        if (b(connectivityManager.getNetworkInfo(1))) {
            g();
            return;
        }
        if (b(connectivityManager.getNetworkInfo(0))) {
            f();
            return;
        }
        e();
    }

    void d(Context context) {
        c(context);
        h.a a2 = a();
        if (a2 != this.d) {
            if (com.shieldtunnel.svpn.common.b.a(LogTag.NET)) {
                Locale locale = com.shieldtunnel.svpn.common.f.f.b;
                Object[] objArr = new Object[2];
                h.a aVar = this.d;
                objArr[0] = Integer.valueOf(aVar == null ? -1 : aVar.f5851a);
                objArr[1] = Integer.valueOf(a2.f5851a);
                Log.d(LogTag.NET, String.format(locale, "Connection Changed: %d -> %d", objArr));
            }
            this.d = a2;
            a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.a(context, a2);
            }
        }
    }

    static h.a b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return h.a.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            com.shieldtunnel.svpn.common.b.c(LogTag.NET, "getActiveNetworkInfo() return null");
            return h.a.DISCONNECT;
        }
        return a(activeNetworkInfo);
    }

    public static h.a a(NetworkInfo networkInfo) {
        if (!networkInfo.isConnectedOrConnecting()) {
            return h.a.DISCONNECT;
        }
        int type = networkInfo.getType();
        if (type == 0) {
            return e.a(networkInfo.getSubtype());
        }
        if (type != 1) {
            com.shieldtunnel.svpn.common.b.c(LogTag.NET, "NetworkInfo.getType() return: " + networkInfo.getType());
            return h.a.UNKNOWN;
        }
        return h.a.WIFI;
    }

    public h.a b() {
        return a();
    }

    public boolean d() {
        return this.c;
    }

    public boolean c() {
        return this.b;
    }

    private h.a a() {
        if (c()) {
            if (d()) {
                return h.a.WIFI;
            }
            return b(this.f5849a);
        }
        return h.a.DISCONNECT;
    }

    public void a(a aVar) {
        this.e = aVar;
    }
}
