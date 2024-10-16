package com.subao.common.j;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.subao.common.j.l;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import java.util.Locale;

/* loaded from: classes2.dex */
public class j implements l {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static j f6080a;
    private final Context b;
    private boolean c;
    private boolean d;
    private boolean e;
    private l.a f;
    private a g;

    /* loaded from: classes2.dex */
    public interface a {
        void a(l.a aVar);
    }

    private j(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        applicationContext.registerReceiver(new b(), new IntentFilter(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION));
        d(applicationContext);
    }

    public static j a(Context context) {
        j jVar;
        j jVar2 = f6080a;
        if (jVar2 != null) {
            return jVar2;
        }
        synchronized (j.class) {
            jVar = f6080a;
            if (jVar == null) {
                jVar = new j(context);
                f6080a = jVar;
            }
        }
        return jVar;
    }

    private static boolean a(NetworkInfo networkInfo) {
        return networkInfo != null && NetworkInfo.State.CONNECTED == networkInfo.getState();
    }

    static l.a b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return l.a.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            com.subao.common.d.b("SubaoNet", "getActiveNetworkInfo() return null");
            return l.a.DISCONNECT;
        }
        if (!activeNetworkInfo.isConnectedOrConnecting()) {
            return l.a.DISCONNECT;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                return h.a(activeNetworkInfo.getSubtype());
            case 1:
                return l.a.WIFI;
            default:
                com.subao.common.d.b("SubaoNet", "NetworkInfo.getType() return: " + activeNetworkInfo.getType());
                return l.a.UNKNOWN;
        }
    }

    void c(Context context) {
        d(context);
        l.a h = h();
        if (h != this.f) {
            if (com.subao.common.d.a("SubaoNet")) {
                Locale locale = com.subao.common.e.r.f6001a;
                Object[] objArr = new Object[2];
                l.a aVar = this.f;
                objArr[0] = Integer.valueOf(aVar == null ? -1 : aVar.g);
                objArr[1] = Integer.valueOf(h.g);
                Log.d("SubaoNet", String.format(locale, "Connection Changed: %d -> %d", objArr));
            }
            this.f = h;
            a aVar2 = this.g;
            if (aVar2 != null) {
                aVar2.a(this.f);
            }
        }
    }

    void d(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (connectivityManager == null) {
            g();
            return;
        }
        if (a(connectivityManager.getNetworkInfo(1))) {
            f();
            return;
        }
        if (a(connectivityManager.getNetworkInfo(0))) {
            e();
            return;
        }
        g();
    }

    private void e() {
        this.c = true;
        this.e = true;
        this.d = false;
    }

    private void f() {
        this.c = true;
        this.d = true;
        this.e = false;
    }

    private void g() {
        this.c = false;
        this.d = false;
        this.e = false;
    }

    private l.a h() {
        if (b()) {
            if (c()) {
                return l.a.WIFI;
            }
            return b(this.b);
        }
        return l.a.DISCONNECT;
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    @Override // com.subao.common.j.l
    public l.a a() {
        return h();
    }

    @Override // com.subao.common.j.l
    public boolean b() {
        return this.c;
    }

    @Override // com.subao.common.j.l
    public boolean c() {
        return this.d;
    }

    @Override // com.subao.common.j.l
    public boolean d() {
        return this.e;
    }

    /* loaded from: classes2.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (NetWorkChangeReceiver.NETWORK_CHANGE_ACTION.equals(intent.getAction())) {
                j.this.c(context);
            }
        }
    }
}
