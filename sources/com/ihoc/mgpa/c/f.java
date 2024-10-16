package com.ihoc.mgpa.c;

import android.content.Context;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f5499a = null;
    private static int b = 50;
    private boolean c = false;
    private Class d = null;
    private Method e = null;
    private Class f = null;
    private Constructor<?> g = null;
    private Method h = null;
    private Method i = null;
    private Method j = null;
    private Method k = null;
    private Method l = null;
    private Object m = null;

    private f() {
    }

    public static f a() {
        if (f5499a == null) {
            synchronized (f.class) {
                if (f5499a == null) {
                    f5499a = new f();
                }
            }
        }
        return f5499a;
    }

    private void c(String str, int i, int i2, int i3) {
        if (this.c) {
            try {
                this.m = this.g.newInstance(this.e.invoke(this.d, str));
                if (this.j != null) {
                    this.j.invoke(this.m, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                } else {
                    this.i.invoke(this.m, Integer.valueOf(i));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void a(String str) {
        String str2;
        int i;
        int i2;
        if (com.ihoc.mgpa.i.f.R()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i3 = b;
                int i4 = 255;
                if (jSONObject.has("amplitude") && (i2 = jSONObject.getInt("amplitude")) >= 1 && i2 <= 255) {
                    i4 = i2;
                }
                if (!jSONObject.has("loop") || (i = jSONObject.getInt("loop")) < 1) {
                    i = 1;
                }
                if (jSONObject.has("interval") && (i3 = jSONObject.getInt("interval")) < b) {
                    i3 = b;
                }
                String str3 = null;
                if (jSONObject.has("json")) {
                    str3 = jSONObject.getString("json");
                } else if (jSONObject.has("path")) {
                    str3 = com.ihoc.mgpa.n.i.i(jSONObject.getString("path"));
                }
                com.ihoc.mgpa.n.m.a("playPattern: json=%s, loop=%d, amplitude=%d, interval=%d", str3, Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i3));
                if (com.ihoc.mgpa.n.p.a(str3)) {
                    com.ihoc.mgpa.n.m.b("playPattern: he file json data get error!", new Object[0]);
                    return;
                }
                if (this.c && !com.ihoc.mgpa.i.f.O()) {
                    c(str3, i, i3, i4);
                } else if (com.ihoc.mgpa.i.f.Z()) {
                    com.ihoc.mgpa.e.a.a().a(str3, i, i4);
                    com.ihoc.mgpa.e.a.a().a(i4, i3);
                }
            } catch (JSONException e) {
                e = e;
                str2 = "playPattern: HePlay value parse to json exception, ple check!";
                com.ihoc.mgpa.n.m.a(str2, e);
            } catch (Exception e2) {
                e = e2;
                str2 = "playPattern: HePlay exception, ple check!";
                com.ihoc.mgpa.n.m.a(str2, e);
            }
        }
    }

    public void a(String str, int i, int i2, int i3) {
        String str2;
        try {
            b(com.ihoc.mgpa.n.i.i(str), i, i2, i3);
        } catch (IOException e) {
            e = e;
            str2 = "HapticPlay: read he file exception, ple check!";
            com.ihoc.mgpa.n.m.a(str2, e);
        } catch (Exception e2) {
            e = e2;
            str2 = "HapticPlay: play file exception, ple check!";
            com.ihoc.mgpa.n.m.a(str2, e);
        }
    }

    public void b() {
        Method method;
        if (com.ihoc.mgpa.i.f.R()) {
            if (!this.c || com.ihoc.mgpa.i.f.O()) {
                if (com.ihoc.mgpa.i.f.Z()) {
                    com.ihoc.mgpa.e.a.a().c();
                    return;
                }
                return;
            }
            Object obj = this.m;
            if (obj == null || (method = this.l) == null) {
                return;
            }
            try {
                method.invoke(obj, new Object[0]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(String str) {
        a(str, 1, b, 255);
    }

    public void b(String str, int i, int i2, int i3) {
        if (i < 1) {
            i = 1;
        }
        int i4 = b;
        if (i2 < i4) {
            i2 = i4;
        }
        if (i3 < 1 || i3 > 255) {
            i3 = 255;
        }
        try {
            if (!com.ihoc.mgpa.i.f.R()) {
                com.ihoc.mgpa.n.m.a("HapticPlay: haptic feature is not open in cloud config, ple call tgpa team!", new Object[0]);
                return;
            }
            if (com.ihoc.mgpa.n.p.a(str)) {
                com.ihoc.mgpa.n.m.b("HapticPlay: he file json data is empty! ple check the he file.", new Object[0]);
                return;
            }
            com.ihoc.mgpa.n.m.a("HapticPlay: json=%s, loop=%d, amplitude=%d, interval=%d", str, Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2));
            if (this.c && !com.ihoc.mgpa.i.f.O()) {
                c(str, i, i2, i3);
            } else if (!com.ihoc.mgpa.i.f.Z()) {
                com.ihoc.mgpa.n.m.a("HapticPlay: general haptic is not open in cloud config, ple call tgpa team!", new Object[0]);
            } else {
                com.ihoc.mgpa.e.a.a().a(str, i, i3);
                com.ihoc.mgpa.e.a.a().a(i3, i2);
            }
        } catch (Exception e) {
            com.ihoc.mgpa.n.m.a("HapticPlay: play json exception, ple check!", e);
        }
    }

    public synchronized void c() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Object[] objArr = new Object[1];
            objArr[0] = "dalvik.system.VMRuntime";
            Class cls = (Class) declaredMethod.invoke(null, objArr);
            Object[] objArr2 = new Object[2];
            objArr2[0] = "getRuntime";
            objArr2[1] = null;
            Method method = (Method) declaredMethod2.invoke(cls, objArr2);
            Object[] objArr3 = new Object[2];
            objArr3[0] = "setHiddenApiExemptions";
            Class[] clsArr = new Class[1];
            clsArr[0] = String[].class;
            objArr3[1] = clsArr;
            Method method2 = (Method) declaredMethod2.invoke(cls, objArr3);
            Object invoke = method.invoke(null, new Object[0]);
            Object[] objArr4 = new Object[1];
            String[] strArr = new String[1];
            strArr[0] = "L";
            objArr4[0] = strArr;
            method2.invoke(invoke, objArr4);
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.b("TGPA", "reflect bootstrap failed:");
        }
        try {
            try {
                this.d = Class.forName("android.os.DynamicEffect");
                this.e = this.d.getMethod("create", String.class);
                this.f = Class.forName("android.os.HapticPlayer");
                this.g = this.f.getConstructor(this.d);
                this.h = this.f.getMethod("isAvailable", new Class[0]);
                this.i = this.f.getMethod("start", Integer.TYPE);
                this.i = com.ihoc.mgpa.n.n.a((Class<?>) this.f, "start", new Class[]{Integer.TYPE});
                this.j = com.ihoc.mgpa.n.n.a((Class<?>) this.f, "start", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.l = this.f.getMethod("stop", new Class[0]);
                this.c = ((Boolean) this.h.invoke(this.f, new Object[0])).booleanValue();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        }
        if (this.c) {
            com.ihoc.mgpa.n.m.c("TGPA", "support haptic");
        }
        Context a2 = com.ihoc.mgpa.n.a.a();
        if (com.ihoc.mgpa.i.f.Z()) {
            com.ihoc.mgpa.e.a.a().a(a2);
            if (com.ihoc.mgpa.e.a.a().d()) {
                com.ihoc.mgpa.n.m.c("TGPA", "support richtap");
            } else {
                com.ihoc.mgpa.n.m.c("TGPA", "don't support richtap");
                if (com.ihoc.mgpa.i.f.oa()) {
                    com.ihoc.mgpa.n.m.c("TGPA", "use none richtap.");
                    com.ihoc.mgpa.e.a.a().a(true);
                }
            }
        }
    }

    public void c(String str) {
        b(str, 1, b, 255);
    }

    public int d() {
        return this.c ? 1 : 3;
    }

    public int e() {
        if (!com.ihoc.mgpa.i.f.R()) {
            return 0;
        }
        if (this.c) {
            return 1;
        }
        if (!com.ihoc.mgpa.i.f.Z()) {
            return -1;
        }
        if (com.ihoc.mgpa.e.a.a().d()) {
            return 2;
        }
        return (com.ihoc.mgpa.i.f.oa() && com.ihoc.mgpa.e.a.a().b()) ? 3 : -1;
    }

    public int f() {
        return (!this.c || this.j == null) ? 0 : 1;
    }
}
