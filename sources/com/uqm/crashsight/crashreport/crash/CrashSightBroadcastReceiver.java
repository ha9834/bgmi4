package com.uqm.crashsight.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import com.uqm.crashsight.proguard.i;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;

/* loaded from: classes3.dex */
public class CrashSightBroadcastReceiver extends BroadcastReceiver {
    private static CrashSightBroadcastReceiver d;
    private Context b;
    private String c;
    private boolean e = true;

    /* renamed from: a, reason: collision with root package name */
    private IntentFilter f6578a = new IntentFilter();

    public static synchronized CrashSightBroadcastReceiver getInstance() {
        CrashSightBroadcastReceiver crashSightBroadcastReceiver;
        synchronized (CrashSightBroadcastReceiver.class) {
            if (d == null) {
                d = new CrashSightBroadcastReceiver();
            }
            crashSightBroadcastReceiver = d;
        }
        return crashSightBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.f6578a.hasAction(str)) {
            this.f6578a.addAction(str);
        }
        m.c("add action %s", str);
    }

    public synchronized void register(Context context) {
        this.b = context;
        q.a(new Runnable() { // from class: com.uqm.crashsight.crashreport.crash.CrashSightBroadcastReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    m.a(CrashSightBroadcastReceiver.d.getClass(), "Register broadcast receiver of CrashSight.", new Object[0]);
                    synchronized (this) {
                        CrashSightBroadcastReceiver.this.b.registerReceiver(CrashSightBroadcastReceiver.d, CrashSightBroadcastReceiver.this.f6578a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            m.a(getClass(), "Unregister broadcast receiver of CrashSight.", new Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (Throwable th) {
            if (m.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (m.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION)) {
                if (this.e) {
                    this.e = false;
                    return true;
                }
                String b = com.uqm.crashsight.crashreport.common.info.c.b(this.b);
                m.c("is Connect BC " + b, new Object[0]);
                m.a("network %s changed to %s", this.c, b);
                if (b == null) {
                    this.c = null;
                    return true;
                }
                String str = this.c;
                this.c = b;
                long currentTimeMillis = System.currentTimeMillis();
                com.uqm.crashsight.crashreport.common.strategy.a a2 = com.uqm.crashsight.crashreport.common.strategy.a.a();
                i a3 = i.a();
                com.uqm.crashsight.crashreport.common.info.a a4 = com.uqm.crashsight.crashreport.common.info.a.a(context);
                if (a2 != null && a3 != null && a4 != null) {
                    if (!b.equals(str)) {
                        if (currentTimeMillis - a3.a(c.f6591a) > 30000) {
                            m.a("try to upload crash on network changed.", new Object[0]);
                            c a5 = c.a();
                            if (a5 != null) {
                                a5.a(0L);
                            }
                        }
                        if (currentTimeMillis - a3.a(1001) > 30000) {
                            m.a("try to upload userinfo on network changed.", new Object[0]);
                            com.uqm.crashsight.crashreport.biz.b.f6555a.b();
                        }
                    }
                    return true;
                }
                m.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
