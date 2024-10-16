package com.ihoc.mgpa.k;

import android.content.Context;
import com.ihoc.mgpa.MgpaCallback;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.n.n;
import com.xiaomi.boostersdk.BuildConfig;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f5657a;
    private Class<?> b;
    private Object c;
    private Method d;
    private Method e;
    private Method f;
    private Method g;
    private Method h;
    private Method i;
    private Method j;
    private Method k;
    private String l = null;

    private d() {
        d();
    }

    public static d a() {
        if (f5657a == null) {
            synchronized (d.class) {
                if (f5657a == null) {
                    f5657a = new d();
                }
            }
        }
        return f5657a;
    }

    private void d() {
        Object[] objArr;
        String str;
        Object obj;
        e();
        Object a2 = n.a("com.ihoc.tgpatask.TransceiverManager", "getInstance");
        Class<?> a3 = n.a("com.ihoc.tgpatask.VmpCallback");
        if (a2 == null || a3 == null) {
            m.a("TransceiverHelper: check ihoc task version failed! Start to check enq version.", new Object[0]);
            a2 = n.a("com.enq.transceiver.TransceiverManager", "getInstance");
            a3 = n.a("com.enq.transceiver.VmpCallback");
            if (a2 == null || a3 == null) {
                m.a("TransceiverHelper: check enq version failed! Start to check gcloud version.", new Object[0]);
                a2 = n.a("com.tencent.gcloud.transceivertool.TransceiverManager", "getInstance");
                a3 = n.a("com.tencent.gcloud.transceivertool.VmpCallback");
                if (a2 == null || a3 == null) {
                    m.d("TransceiverHelper: check gcloud version failed!", new Object[0]);
                    obj = this.c;
                    if (obj != null || this.b == null) {
                    }
                    this.e = n.a(obj, "initByXid", new Class[]{String.class, String.class, Context.class});
                    this.d = n.a(this.c, "initByXid", new Class[]{String.class, Context.class});
                    this.f = n.a(this.c, "init", new Class[]{String.class, String.class, Context.class});
                    this.g = n.a(this.c, "start", (Class[]) null);
                    this.h = n.a(this.c, "stop", (Class[]) null);
                    this.i = n.a(this.c, "registerCallback", new Class[]{this.b});
                    this.j = n.a(this.c, "localTaskApi", new Class[]{String.class});
                    this.k = n.a(this.c, "localTaskApi", new Class[]{String.class, this.b});
                    return;
                }
                objArr = new Object[0];
                str = "TransceiverHelper: check gcloud version success!";
            } else {
                objArr = new Object[0];
                str = "TransceiverHelper: check enq version success!";
            }
        } else {
            objArr = new Object[0];
            str = "TransceiverHelper: check ihoc task version success!";
        }
        m.c(str, objArr);
        this.c = a2;
        this.b = a3;
        obj = this.c;
        if (obj != null) {
        }
    }

    private void e() {
        Class<?> cls;
        try {
            cls = Class.forName("com.ihoc.tgpatask.transceivertool.constant.ConfigConsts");
        } catch (Exception e) {
            e.printStackTrace();
            cls = null;
        }
        if (cls == null) {
            try {
                cls = Class.forName("com.enq.transceiver.transceivertool.constant.ConfigConsts");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (cls == null) {
            try {
                cls = Class.forName("com.tencent.gcloud.transceivertool.constant.ConfigConsts");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (cls == null) {
            m.b("can not find task code", new Object[0]);
            return;
        }
        try {
            cls.getField("VERSION").setAccessible(true);
            this.l = (String) cls.getField("VERSION").get(null);
        } catch (Exception unused) {
            m.b("can not find task version", new Object[0]);
        }
    }

    public void a(MgpaCallback mgpaCallback) {
        if (this.c == null || this.b == null) {
            return;
        }
        try {
            this.i.invoke(this.c, Proxy.newProxyInstance(d.class.getClassLoader(), new Class[]{this.b}, new b(mgpaCallback)));
        } catch (Exception e) {
            m.a("Transceiver registerCallback invoke exception!", e);
        }
    }

    public void a(String str) {
        Object obj = this.c;
        if (obj != null) {
            try {
                this.j.invoke(obj, str);
            } catch (Exception e) {
                m.a("Transceiver localTaskApi invoke exception!", e);
            }
        }
    }

    public void a(String str, a aVar) {
        if (this.c == null || this.b == null) {
            return;
        }
        try {
            this.k.invoke(this.c, str, Proxy.newProxyInstance(d.class.getClassLoader(), new Class[]{this.b}, new b(aVar)));
        } catch (Exception e) {
            m.a("Transceiver registerCallback invoke exception!", e);
        }
    }

    public void a(String str, String str2, Context context) {
        if (this.c != null) {
            try {
                if (this.e != null) {
                    m.a("Transceiver initByXid 3 is available!", new Object[0]);
                    this.e.invoke(this.c, str, str2, context);
                } else if (this.d != null) {
                    m.a("Transceiver initByXid 2 is available!", new Object[0]);
                    this.d.invoke(this.c, str, context);
                }
                this.g.invoke(this.c, new Object[0]);
            } catch (Exception e) {
                m.a("Transceiver preinit invoke exception!", e);
            }
        }
    }

    public void a(String str, String str2, String str3, Context context) {
        Method method;
        Object obj;
        Object[] objArr;
        String str4 = this.l;
        if (str4 == null) {
            m.b("Transceiver init invoke exception,can not get task sdk version", new Object[0]);
            return;
        }
        if (this.c != null) {
            try {
                if (str4.compareToIgnoreCase(BuildConfig.VERSION_NAME) > 0) {
                    method = this.f;
                    obj = this.c;
                    objArr = new Object[]{str, str3, context};
                } else if (this.l.compareToIgnoreCase("1.0.7") <= 0) {
                    this.f.invoke(this.c, str, str2, context);
                    return;
                } else {
                    method = this.f;
                    obj = this.c;
                    objArr = new Object[]{str, str3, context};
                }
                method.invoke(obj, objArr);
            } catch (Exception e) {
                m.a("Transceiver init invoke exception!", e);
            }
        }
    }

    public void b() {
        Object obj = this.c;
        if (obj != null) {
            try {
                this.g.invoke(obj, new Object[0]);
            } catch (Exception e) {
                m.a("Transceiver start invoke exception!", e);
            }
        }
    }

    public void c() {
        Object obj = this.c;
        if (obj != null) {
            try {
                this.h.invoke(obj, new Object[0]);
            } catch (Exception e) {
                m.a("Transceiver stop invoke exception!", e);
            }
        }
    }
}
