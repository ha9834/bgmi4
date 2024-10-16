package com.tencent.msdk.stat;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import com.tencent.msdk.stat.common.StatLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpHost;

/* loaded from: classes.dex */
public class a {
    private static a g;
    private Handler e;
    private Context h;
    private StatLogger i;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f6287a = new ArrayList(10);
    private volatile int b = 2;
    private volatile String c = "";
    private volatile HttpHost d = null;
    private int f = 0;

    private a(Context context) {
        this.e = null;
        this.h = null;
        this.i = null;
        this.h = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("StatNetworkMan");
        handlerThread.start();
        this.e = new Handler(handlerThread.getLooper());
        k.a(context);
        this.i = com.tencent.msdk.stat.common.j.b();
        j();
        i();
        g();
    }

    public static a a(Context context) {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a(context);
                }
            }
        }
        return g;
    }

    private void i() {
        this.f6287a.add("117.135.169.101");
        this.f6287a.add("140.207.54.125");
        this.f6287a.add("180.153.8.53");
        this.f6287a.add("120.198.203.175");
        this.f6287a.add("14.17.43.18");
        this.f6287a.add("163.177.71.186");
        this.f6287a.add("111.30.131.31");
        this.f6287a.add("123.126.121.167");
        this.f6287a.add("123.151.152.111");
        this.f6287a.add("113.142.45.79");
        this.f6287a.add("123.138.162.90");
        this.f6287a.add("103.7.30.94");
    }

    private void j() {
        this.b = 0;
        this.d = null;
        this.c = null;
    }

    public HttpHost a() {
        return this.d;
    }

    public void a(String str) {
        if (StatConfig.isDebugEnable()) {
            this.i.i("updateIpList " + str);
        }
        this.f = new Random().nextInt(this.f6287a.size());
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public void d() {
        List<String> list = this.f6287a;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f = (this.f + 1) % this.f6287a.size();
    }

    public boolean e() {
        return this.b == 1;
    }

    public boolean f() {
        return this.b != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (!com.tencent.msdk.stat.common.p.f(this.h)) {
            if (StatConfig.isDebugEnable()) {
                this.i.i("NETWORK TYPE: network is close.");
            }
            j();
            return;
        }
        this.c = com.tencent.msdk.stat.common.j.k(this.h);
        if (StatConfig.isDebugEnable()) {
            this.i.i("NETWORK name:" + this.c);
        }
        if (com.tencent.msdk.stat.common.j.c(this.c)) {
            this.b = "WIFI".equalsIgnoreCase(this.c) ? 1 : 2;
            this.d = com.tencent.msdk.stat.common.j.a(this.h);
        }
        if (StatServiceImpl.a()) {
            StatServiceImpl.e(this.h);
        }
    }

    public void h() {
        this.h.getApplicationContext().registerReceiver(new b(this), new IntentFilter(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION));
    }
}
