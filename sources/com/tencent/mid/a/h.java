package com.tencent.mid.a;

import android.content.Context;
import com.tencent.mid.api.MidCallback;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.util.Util;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f6254a;
    private MidCallback b;
    private int c;
    private com.tencent.mid.util.d d;

    public h(Context context, int i, MidCallback midCallback) {
        this.f6254a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.f6254a = context;
        this.c = i;
        this.b = midCallback;
        this.d = Util.getLogger();
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (h.class) {
            this.d.d("ServiceRunnable begin, type:" + this.c + ",ver:4.07");
            try {
                switch (this.c) {
                    case 1:
                        MidEntity a2 = g.a(this.f6254a);
                        if (Util.isMidValid(a2)) {
                            this.b.onSuccess(a2);
                            break;
                        } else if (Util.isNetworkAvailable(this.f6254a)) {
                            c.a(this.f6254a).a(1, new f(this.f6254a), this.b);
                            break;
                        } else {
                            this.b.onFail(MidConstants.ERROR_NETWORK, "network not available.");
                            break;
                        }
                    case 2:
                        b();
                        break;
                    default:
                        this.d.d("wrong type:" + this.c);
                        break;
                }
            } catch (Throwable th) {
                this.d.f(th);
            }
            this.d.d("ServiceRunnable end");
        }
    }

    private void a() {
        MidEntity a2 = com.tencent.mid.b.g.a(this.f6254a).a(new ArrayList(Arrays.asList(2)));
        MidEntity a3 = com.tencent.mid.b.g.a(this.f6254a).a(new ArrayList(Arrays.asList(4)));
        if (Util.equal(a3, a2)) {
            this.d.d("local mid check passed.");
            return;
        }
        MidEntity newerMidEntity = Util.getNewerMidEntity(a3, a2);
        this.d.d("local mid check failed, redress with mid:" + newerMidEntity.toString());
        if (com.tencent.mid.util.g.a(this.f6254a).b("ten.mid.allowCheckAndRewriteLocal.bool", 0) == 1) {
            com.tencent.mid.b.g.a(this.f6254a).f(newerMidEntity);
        }
    }

    private void b() {
        com.tencent.mid.b.a l = com.tencent.mid.b.g.a(this.f6254a).l();
        if (l == null) {
            this.d.d("CheckEntity is null");
            return;
        }
        int c = l.c() + 1;
        long currentTimeMillis = System.currentTimeMillis() - l.b();
        if (currentTimeMillis < 0) {
            currentTimeMillis = -currentTimeMillis;
        }
        this.d.b("check entity: " + l.toString() + ",duration:" + currentTimeMillis);
        if ((c > l.d() && currentTimeMillis > a.f6246a) || currentTimeMillis > l.a() * a.f6246a) {
            a();
            c();
            l.b(c);
            l.a(System.currentTimeMillis());
            com.tencent.mid.b.g.a(this.f6254a).a(l);
        }
        MidEntity a2 = com.tencent.mid.b.g.a(this.f6254a).a();
        this.d.b("midNewEntity:" + a2);
        if (Util.isMidValid(a2)) {
            return;
        }
        this.d.b("request mid_new ");
        c.a(this.f6254a).a(3, new f(this.f6254a), new MidCallback() { // from class: com.tencent.mid.a.h.1
            @Override // com.tencent.mid.api.MidCallback
            public void onSuccess(Object obj) {
                h.this.d.b("request new mid success:" + obj);
            }

            @Override // com.tencent.mid.api.MidCallback
            public void onFail(int i, String str) {
                h.this.d.b("request new mid failed, errCode:" + i + ",msg:" + str);
            }
        });
    }

    private void c() {
        this.d.b("checkServer");
        c.a(this.f6254a).a(2, new f(this.f6254a), new MidCallback() { // from class: com.tencent.mid.a.h.2
            @Override // com.tencent.mid.api.MidCallback
            public void onSuccess(Object obj) {
                h.this.d.b("checkServer success:" + obj);
            }

            @Override // com.tencent.mid.api.MidCallback
            public void onFail(int i, String str) {
                h.this.d.b("checkServer failed, errCode:" + i + ",msg:" + str);
            }
        });
    }
}
