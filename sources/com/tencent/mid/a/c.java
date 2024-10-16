package com.tencent.mid.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.LocalServerSocket;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.imsdk.android.login.migrate.MigrateWebConsts;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import com.tencent.mid.api.MidCallback;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    private static com.tencent.mid.util.d c = Util.getLogger();
    private static c i = null;
    private static Context j = null;
    private com.tencent.mid.util.a d = null;
    private com.tencent.mid.util.a e = null;
    private long f = 0;
    private int g = 0;
    private int h = -1;

    /* renamed from: a, reason: collision with root package name */
    int f6249a = -1;
    LocalServerSocket b = null;

    private void c() {
        this.f = 0L;
        this.g = 0;
    }

    private void d() {
        this.g++;
        this.f = System.currentTimeMillis();
    }

    private boolean e() {
        if (this.g <= 3) {
            return false;
        }
        if (System.currentTimeMillis() - this.f < 1800000) {
            return true;
        }
        c();
        return false;
    }

    private c(Context context) {
        try {
            j = context.getApplicationContext();
        } catch (Throwable th) {
            c.f(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tencent.mid.util.a a(int i2) {
        if (i2 == 1) {
            if (this.d == null) {
                this.d = new com.tencent.mid.util.a();
                this.d.e();
            }
            return this.d;
        }
        if (this.e == null) {
            this.e = new com.tencent.mid.util.a();
            this.e.a("key-/.*$!xx", "vec-;*5@)&%(");
        }
        return this.e;
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (i == null) {
                i = new c(context);
            }
            cVar = i;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context a() {
        return j;
    }

    boolean b() {
        int i2 = this.f6249a;
        this.f6249a = i2 + 1;
        if (i2 > 1000) {
            c.f("send count limit " + this.f6249a);
            return false;
        }
        SharedPreferences a2 = com.tencent.mid.api.a.a(j).a();
        if (a2 == null) {
            return true;
        }
        String str = "SEND_LIMIT_" + Util.getDateString(0);
        if (this.f6249a == 0) {
            this.f6249a = a2.getInt(str, 0);
        }
        a2.edit().putInt(str, this.f6249a);
        return true;
    }

    private boolean f() {
        try {
            this.b = new LocalServerSocket("com.tencent.teg.mid.sock.lock");
            c.h("open socket mLocalServerSocket:" + this.b);
            return true;
        } catch (IOException unused) {
            c.d("socket Name:com.tencent.teg.mid.sock.lock is in use.");
            return false;
        } catch (Throwable unused2) {
            c.d("something wrong while create LocalServerSocket.");
            return false;
        }
    }

    private void g() {
        LocalServerSocket localServerSocket = this.b;
        if (localServerSocket != null) {
            try {
                localServerSocket.close();
                c.b("close socket  mLocalServerSocket:" + this.b);
                this.b = null;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, e eVar, MidCallback midCallback) {
        if (eVar == null || midCallback == null) {
            if (midCallback != null) {
                midCallback.onFail(MidConstants.ERROR_ARGUMENT, "packet == null || handler == null");
            }
            c.f("packet == null || handler == null || cb == null");
            return;
        }
        if (!Util.isNetworkAvailable(j)) {
            midCallback.onFail(MidConstants.ERROR_NETWORK, "network not available.");
            return;
        }
        int i3 = 0;
        while (!f()) {
            int i4 = i3 + 1;
            if (i3 >= 10) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            i3 = i4;
        }
        if (i2 == 1) {
            MidEntity a2 = g.a(j);
            if (Util.isMidValid(a2)) {
                midCallback.onSuccess(a2);
                g();
                return;
            }
        }
        if (i2 == 3) {
            MidEntity a3 = com.tencent.mid.b.g.a(j).a();
            if (Util.isMidValid(a3)) {
                midCallback.onSuccess(a3);
                g();
                return;
            }
        }
        if (!b()) {
            g();
        } else {
            b(i2, eVar, midCallback);
            g();
        }
    }

    private void b(int i2, e eVar, MidCallback midCallback) {
        b bVar;
        d a2;
        c.b(" enter http request, type:" + i2);
        b bVar2 = null;
        try {
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                }
                if (e()) {
                    c.f("Http request failed too much, please check the network.");
                    if (midCallback != null) {
                        midCallback.onFail(MidConstants.ERROR_HTTP_FAILED_TOO_MUCH, "Http request failed too much, please check the network.");
                        return;
                    }
                    return;
                }
                com.tencent.mid.util.b a3 = com.tencent.mid.util.b.a(j);
                bVar = new b(Util.getHttpAddr(j), null);
                try {
                    JSONObject jSONObject = new JSONObject();
                    eVar.a(jSONObject);
                    jSONObject.put("rty", i2);
                    if (this.h > 0) {
                        jSONObject.put(MigrateWebConsts.MIGRATE_WEB_INTENT_SEQ, this.h);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("android", jSONObject);
                    jSONObject2.put("mid_list", Util.queryMids(j, 1));
                    jSONObject2.put("mid_list_new", Util.queryMids(j, 2));
                    String jSONObject3 = jSONObject2.toString();
                    c.b("jsonBodyStr:" + jSONObject3);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(jSONObject3.length());
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(jSONObject3.getBytes("UTF-8"));
                    gZIPOutputStream.close();
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    com.tencent.mid.util.a a4 = a(i2);
                    byteArrayOutputStream.reset();
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    String f = a3.f();
                    if (i2 == 1 || i2 == 3) {
                        f = i2 == 1 ? a3.d() : a3.e();
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(64);
                        byteArrayOutputStream2.write(a4.b());
                        byteArrayOutputStream2.write(a4.c());
                        byteArrayOutputStream2.close();
                        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                        com.tencent.mid.util.f.a(a3.b());
                        byte[] a5 = com.tencent.mid.util.f.a(byteArray2);
                        dataOutputStream.writeShort(a3.a());
                        dataOutputStream.writeShort(a5.length);
                        dataOutputStream.write(a5);
                    }
                    dataOutputStream.write(a4.a(byteArray));
                    dataOutputStream.close();
                    byteArrayOutputStream.close();
                    a2 = bVar.a(f, byteArrayOutputStream.toByteArray(), HttpStack.ENCODING_GZIP, i2);
                } catch (Throwable th2) {
                    th = th2;
                    bVar2 = bVar;
                    d();
                    th.printStackTrace();
                    midCallback.onFail(MidConstants.ERROR_SDK_LOGIC, th.toString());
                    c.d(th.toString());
                    th.printStackTrace();
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    return;
                }
                if (a2.a() != 200) {
                    String str = "response code invalid:" + a2.a();
                    c.d(str);
                    midCallback.onFail(a2.a(), str);
                    try {
                        bVar.a();
                        return;
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        return;
                    }
                }
                JSONObject b = a2.b();
                if (b.has("ret_code") || b.has("ret_msg")) {
                    int i3 = b.getInt("ret_code");
                    String str2 = "response code:" + i3 + ",msg:" + b.getString("ret_msg");
                    c.d(str2);
                    if (i3 != 0) {
                        midCallback.onFail(i3, str2);
                        try {
                            bVar.a();
                            return;
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                            return;
                        }
                    }
                }
                if (!b.isNull(MigrateWebConsts.MIGRATE_WEB_INTENT_SEQ)) {
                    this.h = b.getInt(MigrateWebConsts.MIGRATE_WEB_INTENT_SEQ);
                }
                if (!b.isNull("mid")) {
                    String string = b.getString("mid");
                    if (b.has("guid")) {
                        a(string, b.optLong("guid", 0L), b.optInt("reset", 0), midCallback);
                    }
                }
                int optInt = b.optInt("locW", -1);
                if (optInt > -1) {
                    com.tencent.mid.util.g.a(j).a("ten.mid.allowCheckAndRewriteLocal.bool", optInt);
                }
                a(b.optString(MidConstants.NEW_MID_TAG), b.optLong("guid", 0L), b.optInt("reset_new", 0));
                bVar.a();
            } catch (Throwable th5) {
                th = th5;
                bVar = null;
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
    }

    private static void a(String str, long j2, int i2) {
        if (Util.isMidValid(str)) {
            if (!Util.isMidValid(com.tencent.mid.b.g.a(j).b())) {
                i2 = 3;
            }
            c.b("updateNewVersionMidEntity reset:" + i2);
            if (i2 > 0) {
                MidEntity midEntity = new MidEntity();
                midEntity.setMid(str);
                midEntity.setGuid(j2);
                midEntity.setMac(CustomDeviceInfos.getMacAddress(j));
                midEntity.setImei(CustomDeviceInfos.getDeviceId(j));
                midEntity.setImsi(CustomDeviceInfos.getImsi(j));
                midEntity.setTimestamps(System.currentTimeMillis());
                midEntity.setVersion(3);
                c.b("server return new version mid midEntity:" + midEntity.toString());
                if (i2 != 8) {
                    switch (i2) {
                        case 1:
                            com.tencent.mid.b.g.a(j).b(midEntity);
                            break;
                        case 2:
                            com.tencent.mid.b.g.a(j).c(midEntity);
                            break;
                        case 3:
                            com.tencent.mid.b.g.a(j).a(midEntity);
                            break;
                        case 4:
                            com.tencent.mid.b.g.a(j).f(midEntity);
                            com.tencent.mid.b.g.a(j).a(midEntity);
                            break;
                    }
                } else {
                    com.tencent.mid.b.g.a(j).f(midEntity);
                    com.tencent.mid.b.g.a(j).a(midEntity);
                    com.tencent.mid.b.g.a(j).g(midEntity);
                }
                com.tencent.mid.b.g.a(j).a(-1, -1);
            }
        }
    }

    private static void a(String str, long j2, int i2, MidCallback midCallback) {
        if (Util.isMidValid(str)) {
            if (!Util.isMidValid(g.d(j))) {
                i2 = 4;
            }
            c.b("updateMidEntity reset:" + i2);
            if (i2 > 0) {
                MidEntity midEntity = new MidEntity();
                midEntity.setMid(str);
                midEntity.setGuid(j2);
                midEntity.setMac(CustomDeviceInfos.getMacAddress(j));
                midEntity.setImei(CustomDeviceInfos.getDeviceId(j));
                midEntity.setImsi(CustomDeviceInfos.getImsi(j));
                midEntity.setTimestamps(System.currentTimeMillis());
                midEntity.setVersion(3);
                c.b("server return new mid midEntity:" + midEntity.toString());
                midCallback.onSuccess(midEntity.toString());
                switch (i2) {
                    case 1:
                        com.tencent.mid.b.g.a(j).d(midEntity);
                        break;
                    case 2:
                        com.tencent.mid.b.g.a(j).e(midEntity);
                        break;
                    case 3:
                        com.tencent.mid.b.g.a(j).f(midEntity);
                        break;
                    case 4:
                        com.tencent.mid.b.g.a(j).f(midEntity);
                        com.tencent.mid.b.g.a(j).g(midEntity);
                        break;
                }
                com.tencent.mid.b.g.a(j).a(-1, -1);
            }
        }
    }
}
