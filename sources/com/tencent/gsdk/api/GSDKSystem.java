package com.tencent.gsdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.db.conversation.tables.ConversationTable;
import com.tencent.abase.utils.ConstantUtils;
import com.tencent.gsdk.utils.JNIHelper;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.tencent.open.SocialOperation;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class GSDKSystem {
    private static String A = "http://gsdk.qq.com:60000/?cmdid=";
    private static String B = "http://cloud.gsdk.qq.com:18081/?cmdid=";
    private static String C = "http://cloud.gsdk.proximabeta.com:18081/?cmdid=";
    private static int D = 1;
    private static int E = 3;
    private static String F = "&appid=";
    private static int G = 0;
    private static boolean H = false;
    private static boolean I = true;
    private static boolean J = true;
    private static boolean K = true;
    private static boolean L = false;
    private static boolean M = false;
    private static long N = 0;
    private static long O = 0;
    private static long P = 0;
    private static long Q = 0;
    private static long R = 0;
    private static long S = 0;
    private static int T = 0;
    private static int U = 0;
    private static int V = 0;
    private static int W = 0;
    private static int X = 0;
    private static int Y = 0;
    private static int Z = 0;

    /* renamed from: a, reason: collision with root package name */
    public static List<Long> f6215a = null;
    private static HashMap<String, c> aa = null;
    private static HashMap<String, j> ab = null;
    private static boolean ae = false;
    private static GSDKSystem af = null;
    public static List<Long> b = null;
    public static List<Long> c = null;
    public static List<Long> d = null;
    public static List<Long> e = null;
    public static List<Long> f = null;
    public static List<Long> g = null;
    public static List<Long> h = null;
    public static List<Long> i = null;
    public static List<Long> j = null;
    public static List<Long> k = null;
    public static List<Long> l = null;
    public static List<Long> m = null;
    public static List<Long> n = null;
    private static Timer o = null;
    private static Timer p = null;
    private static Timer q = null;
    private static Context r = null;
    private static String s = null;
    private static String t = null;
    private static int u = 0;
    private static int v = 0;
    private static String y = "1.1.6ig";
    private static String z = "";
    private Application ac;
    private f ad;
    private com.tencent.gsdk.api.b ag;
    private b ah;
    private int ai;
    private Activity aj;
    private com.tencent.gsdk.api.d ak;
    private String al;
    private Handler w;
    private HandlerThread x;

    public void a(Context context, String str) {
    }

    public static GSDKSystem getInstance() {
        if (af == null) {
            synchronized (GSDKSystem.class) {
                if (af == null) {
                    af = new GSDKSystem();
                }
            }
        }
        return af;
    }

    public void a(String str) {
        z = str;
    }

    public void a(Context context, String str, boolean z2, int i2) {
        if (context == null) {
            return;
        }
        s = str;
        u = i2;
        com.tencent.gsdk.utils.g.f6245a = z2;
        com.tencent.gsdk.utils.a.c.a(z2);
        if (!ae) {
            this.x = new HandlerThread("THREAD__100");
            this.x.start();
            this.w = new d(this.x.getLooper());
            aa = new HashMap<>();
            ab = new HashMap<>();
            r = context.getApplicationContext();
            Activity activity = (Activity) context;
            this.ac = activity.getApplication();
            com.tencent.gsdk.utils.c.g(r);
            com.tencent.gsdk.api.f.a(r, com.tencent.gsdk.api.f.f6234a);
            com.tencent.gsdk.api.a.a(r);
            this.ai = com.tencent.gsdk.utils.d.a();
            if (this.ai == 2) {
                this.aj = activity;
            }
            com.tencent.gsdk.utils.g.b("engine plat is:" + this.ai);
            ae = true;
        }
        if (this.ac != null && Build.VERSION.SDK_INT >= 14) {
            if (this.ad != null) {
                n();
            }
            this.ad = new f();
            this.ac.registerActivityLifecycleCallbacks(this.ad);
        }
        b();
        a(context, z2);
        t = com.tencent.gsdk.utils.e.a();
    }

    public void a(final Context context, boolean z2) {
        if (context != null && z2) {
            try {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.gsdk.api.GSDKSystem.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("GSDK已打开Debug模式，现网版本请务必关闭，否则将影响客户端的性能。即将Init接口中Debug参数设为false！");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tencent.gsdk.api.GSDKSystem.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.dismiss();
                            }
                        });
                        builder.create().show();
                    }
                });
            } catch (Exception e2) {
                com.tencent.gsdk.utils.g.d("Debug alert dialog error:" + e2.getMessage());
            }
        }
    }

    public void a(int i2, String str) {
        v = i2;
        com.tencent.gsdk.api.f.a(r, com.tencent.gsdk.api.f.f6234a, com.tencent.gsdk.api.f.d, str);
    }

    public Context a() {
        return r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        GSDKSystem.this.e(((e) message.obj).f6223a);
                        break;
                    case 1:
                        GSDKSystem.this.a(GSDKSystem.this.ag, (com.tencent.gsdk.api.c) message.obj);
                        break;
                    case 2:
                        GSDKSystem.this.d((com.tencent.gsdk.api.b) message.obj);
                        break;
                    case 3:
                        GSDKSystem.this.c((com.tencent.gsdk.api.b) message.obj);
                        break;
                    case 5:
                        GSDKSystem.this.d();
                        break;
                    case 6:
                        GSDKSystem.this.a((com.tencent.gsdk.api.d) message.obj);
                        break;
                    case 7:
                        GSDKSystem.this.a((a) message.obj);
                        break;
                    case 8:
                        GSDKSystem.a((HashMap<String, c>) GSDKSystem.aa, 1);
                        break;
                    case 9:
                        GSDKSystem.this.o();
                        break;
                }
            } catch (Exception e) {
                com.tencent.gsdk.utils.g.d("MainHandler error:" + e.getMessage());
            }
        }
    }

    public void b(String str) {
        if (this.w == null) {
            return;
        }
        e eVar = new e(str);
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = eVar;
        this.w.sendMessage(obtain);
    }

    public void a(com.tencent.gsdk.api.c cVar) {
        com.tencent.gsdk.api.c cVar2;
        if (cVar == null) {
            cVar2 = new com.tencent.gsdk.api.c(0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, "0");
        } else {
            cVar2 = new com.tencent.gsdk.api.c(cVar.f6231a, cVar.b, cVar.c, cVar.d, cVar.e, cVar.f, cVar.g, cVar.h, cVar.i, cVar.j, cVar.k);
        }
        if (this.w == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = cVar2;
        this.w.sendMessage(obtain);
    }

    public void c(String str) {
        this.ah = new b(str);
    }

    public void a(com.tencent.gsdk.api.b bVar) {
        if (this.w == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = bVar;
        this.w.sendMessage(obtain);
    }

    public void b(com.tencent.gsdk.api.b bVar) {
        if (this.w == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = bVar;
        this.w.sendMessage(obtain);
    }

    public void b() {
        Message obtain = Message.obtain();
        obtain.what = 5;
        Handler handler = this.w;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public void a(int i2, boolean z2, String str, boolean z3, boolean z4) {
        com.tencent.gsdk.api.d dVar = new com.tencent.gsdk.api.d(i2, z2, str, z3, z4);
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = dVar;
        Handler handler = this.w;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public void a(int i2, int i3, boolean z2, String str) {
        a aVar = new a(i2, i3, z2, str);
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = aVar;
        Handler handler = this.w;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public void c() {
        Message obtain = Message.obtain();
        obtain.what = 9;
        Handler handler = this.w;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public static void a(HashMap<String, c> hashMap, int i2) {
        if (hashMap == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            c cVar = hashMap.get(it.next());
            hashMap2.put(AnalyticsEventKey.SEARCH_QUERY + cVar.f6221a, cVar.b);
            hashMap2.put("t" + cVar.f6221a, cVar.c + "");
        }
        hashMap2.put("isBack", i2 + "");
        if (hashMap != null) {
            hashMap.clear();
        }
        hashMap2.put("openid", e());
        hashMap2.put("version", y);
        hashMap2.put("devices", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        hashMap2.put("wifi_num", String.valueOf(com.tencent.gsdk.utils.c.f(r)));
        hashMap2.put("wifi_rssi", String.valueOf(com.tencent.gsdk.utils.c.d(r)));
        hashMap2.put("gate_delay", String.valueOf(com.tencent.gsdk.utils.h.a(r)));
        hashMap2.put("gate_delay", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        hashMap2.put("wifi_speed", String.valueOf(com.tencent.gsdk.utils.c.e(r)));
        hashMap2.put("free_storage", String.valueOf(com.tencent.gsdk.api.g.f(r)));
        hashMap2.put("total_storage", String.valueOf(com.tencent.gsdk.api.g.e(r)));
        hashMap2.put("signal_level", String.valueOf(com.tencent.gsdk.utils.c.a()));
        com.tencent.gsdk.utils.g.c("login signal_level level is " + String.valueOf(com.tencent.gsdk.utils.c.a()));
        hashMap2.put("xg", com.tencent.gsdk.utils.c.b(r));
        hashMap2.put(ConversationTable.Columns.LOCAL_UUID, t);
        a("gsdk_report_login", System.currentTimeMillis(), true, (Map<String, String>) hashMap2);
    }

    private static String m() {
        if (!TextUtils.isEmpty(z)) {
            com.tencent.gsdk.utils.g.a("use custom control url:" + z);
            return z + "/?cmdid=";
        }
        int i2 = u;
        if (i2 == 0) {
            return A;
        }
        if (i2 == 1) {
            return B;
        }
        if (i2 == 2) {
            return C;
        }
        return null;
    }

    public void d() {
        boolean z2;
        String str = s;
        if (str == null || str.length() == 0) {
            s = "NULL";
        }
        String m2 = m();
        String str2 = m2 + E + F + s;
        com.tencent.gsdk.utils.g.b("switch url is:" + str2);
        String str3 = com.tencent.gsdk.api.f.f6234a;
        boolean z3 = false;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setUseCaches(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                byteArrayOutputStream.close();
                inputStream.close();
                String b2 = com.tencent.gsdk.utils.a.b(new String(byteArrayOutputStream.toByteArray()));
                com.tencent.gsdk.utils.g.b("login switch result is:" + b2);
                JSONObject jSONObject = new JSONObject(b2);
                if (jSONObject.getInt("errno") == 0) {
                    int i2 = jSONObject.getInt(FirebaseAnalytics.Event.LOGIN);
                    int i3 = jSONObject.getInt("pay");
                    if (i2 != 1) {
                        I = false;
                    }
                    if (i3 != 1) {
                        J = false;
                    }
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.b, Boolean.valueOf(I));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.c, Boolean.valueOf(J));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.e, jSONObject.getString("domain1"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.f, jSONObject.getString("domain2"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.g, jSONObject.getString("domain3"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.h, jSONObject.getString("domain4"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.i, jSONObject.getString("domain5"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.j, jSONObject.getString("domain6"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.s, jSONObject.getString("errmsg"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.r, jSONObject.getInt("domain"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.q, jSONObject.getInt("errno"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.k, jSONObject.getInt("port1"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.l, jSONObject.getInt("port2"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.m, jSONObject.getInt("port3"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.n, jSONObject.getInt("port4"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.o, jSONObject.getInt("port5"));
                    com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.p, jSONObject.getInt("port6"));
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            httpURLConnection.disconnect();
            z3 = z2;
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("request login switch error:" + e2.getMessage());
        }
        if (!z3) {
            I = com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.b);
            J = com.tencent.gsdk.api.f.a(r, str3, com.tencent.gsdk.api.f.c);
            com.tencent.gsdk.utils.g.b("login switch is:" + I + " pay switch is:" + J);
        }
        if (com.tencent.gsdk.api.f.c(r, str3, com.tencent.gsdk.api.f.q) == 0 && com.tencent.gsdk.api.f.c(r, str3, com.tencent.gsdk.api.f.r) == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("controlUrl", m2.replace("/?cmdid=", ""));
        hashMap.put(ConversationTable.Columns.LOCAL_UUID, t);
        String b3 = b(com.tencent.gsdk.api.f.b(r, str3, com.tencent.gsdk.api.f.e), com.tencent.gsdk.api.f.c(r, str3, com.tencent.gsdk.api.f.k));
        String b4 = b(com.tencent.gsdk.api.f.b(r, str3, com.tencent.gsdk.api.f.f), com.tencent.gsdk.api.f.c(r, str3, com.tencent.gsdk.api.f.l));
        String b5 = b(com.tencent.gsdk.api.f.b(r, str3, com.tencent.gsdk.api.f.g), com.tencent.gsdk.api.f.c(r, str3, com.tencent.gsdk.api.f.m));
        String b6 = b(com.tencent.gsdk.api.f.b(r, str3, com.tencent.gsdk.api.f.h), com.tencent.gsdk.api.f.c(r, str3, com.tencent.gsdk.api.f.n));
        String b7 = b(com.tencent.gsdk.api.f.b(r, str3, com.tencent.gsdk.api.f.i), com.tencent.gsdk.api.f.c(r, str3, com.tencent.gsdk.api.f.o));
        String b8 = b(com.tencent.gsdk.api.f.b(r, str3, com.tencent.gsdk.api.f.j), com.tencent.gsdk.api.f.c(r, str3, com.tencent.gsdk.api.f.p));
        hashMap.put("d1", b3);
        hashMap.put("d2", b4);
        hashMap.put("d3", b5);
        hashMap.put("d4", b6);
        hashMap.put("d5", b7);
        hashMap.put("d6", b8);
        if (!z3) {
            hashMap.put("isCache", "1");
        } else {
            hashMap.put("isCache", "0");
        }
        a("gsdk_report_con", currentTimeMillis, true, (Map<String, String>) hashMap);
    }

    private String b(String str, int i2) {
        StringBuilder sb;
        String str2 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
        if (str == null || str.length() == 0 || str.equalsIgnoreCase(Constants.NULL_VERSION_ID)) {
            if (i2 == 0) {
                i2 = -1;
            }
            return "-1_-1_-1_-1_" + i2 + "_-1";
        }
        Socket socket = new Socket();
        String f2 = f(str);
        long j2 = -1;
        boolean z2 = false;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = InetAddress.getByName(str).getHostAddress();
                j2 = System.currentTimeMillis() - currentTimeMillis;
                socket.connect(new InetSocketAddress(str, i2), 3000);
                if (!socket.isClosed() && socket.isConnected()) {
                    z2 = true;
                }
                socket.close();
            } catch (Exception e2) {
                com.tencent.gsdk.utils.g.c("getSocketConnectivity error:" + e2.getMessage());
                try {
                    socket.close();
                } catch (IOException e3) {
                    e = e3;
                    sb = new StringBuilder();
                    sb.append("getSocketConnectivity close socket error:");
                    sb.append(e.getMessage());
                    com.tencent.gsdk.utils.g.c(sb.toString());
                    return str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + j2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + f2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + i2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + z2;
                }
            }
            try {
                socket.close();
            } catch (IOException e4) {
                e = e4;
                sb = new StringBuilder();
                sb.append("getSocketConnectivity close socket error:");
                sb.append(e.getMessage());
                com.tencent.gsdk.utils.g.c(sb.toString());
                return str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + j2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + f2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + i2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + z2;
            }
            return str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + j2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + f2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + i2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + z2;
        } catch (Throwable th) {
            try {
                socket.close();
            } catch (IOException e5) {
                com.tencent.gsdk.utils.g.c("getSocketConnectivity close socket error:" + e5.getMessage());
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.gsdk.api.d dVar) {
        this.ak = dVar;
        if (this.ak == null || !I || aa == null || L) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.gsdk.utils.g.a("setEvent tag:" + this.ak.f6232a + ",status:" + this.ak.b + ",msg:" + this.ak.c + ",authorize:" + this.ak.d + ",finish:" + this.ak.e);
        StringBuilder sb = new StringBuilder();
        sb.append(this.ak.b);
        sb.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        sb.append(this.ak.c);
        String sb2 = sb.toString();
        long j2 = R;
        aa.put(String.valueOf(this.ak.f6232a), new c(this.ak.f6232a, sb2, j2 != 0 ? currentTimeMillis - j2 : -1L));
        R = currentTimeMillis;
        if (!this.ak.b || this.ak.e) {
            if (this.ak.e) {
                n();
            }
            a(aa, 0);
        }
        if (this.ak.e && this.ak.b) {
            K = true;
            L = true;
        } else {
            K = false;
        }
    }

    private void n() {
        try {
            if (this.ac == null || Build.VERSION.SDK_INT < 14 || this.ad == null) {
                return;
            }
            this.ac.unregisterActivityLifecycleCallbacks(this.ad);
            this.ad = null;
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.c("unregisterLifecycleCallbacks error:" + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null || !J || ab == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.gsdk.api.e eVar = null;
        try {
            com.tencent.gsdk.utils.g.a("setPay id:" + aVar.f6219a + ",tag:" + aVar.b + ",status:" + aVar.c + ",msg:" + aVar.d);
            eVar = com.tencent.gsdk.api.e.a(aVar.b);
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("gsdk setPay enum error:" + e2.getMessage());
        }
        if (eVar != com.tencent.gsdk.api.e.PayStart) {
            ab.put(String.valueOf(aVar.b), new j(aVar.b, aVar.f6219a + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + aVar.c + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + aVar.d, currentTimeMillis - S));
        }
        S = currentTimeMillis;
        if (!aVar.c || eVar == com.tencent.gsdk.api.e.PayDone) {
            b(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        long a2;
        if (M) {
            return;
        }
        try {
            String b2 = com.tencent.gsdk.utils.c.b(r);
            if (b2.equals("wifi")) {
                a2 = com.tencent.gsdk.utils.c.d(r);
            } else {
                a2 = com.tencent.gsdk.utils.c.a();
            }
            int a3 = com.tencent.gsdk.utils.h.a(r);
            ArrayList arrayList = new ArrayList();
            String str = ConstantUtils.PING_DOMAIN;
            if (u == 2) {
                str = "www.facebook.com";
            }
            for (int i2 = 0; i2 < 3; i2++) {
                arrayList.add(Long.valueOf(com.tencent.gsdk.utils.h.a(str)));
            }
            String obj = arrayList.toString();
            String substring = obj.substring(1, obj.length() - 1);
            ArrayList arrayList2 = new ArrayList();
            if (this.ag != null && !TextUtils.isEmpty(this.ag.c) && !this.ag.c.equalsIgnoreCase("NULL")) {
                for (int i3 = 0; i3 < 3; i3++) {
                    long c2 = c(this.ag.c, this.ag.d);
                    if (c2 <= 0 || c2 >= 3000) {
                        c2 = 3000;
                    }
                    arrayList2.add(Long.valueOf(c2));
                }
            }
            String obj2 = arrayList2.toString();
            String substring2 = obj2.substring(1, obj2.length() - 1);
            M = true;
            HashMap hashMap = new HashMap();
            hashMap.put("netType", b2);
            hashMap.put("signalLevel", String.valueOf(a2));
            hashMap.put("gateway", String.valueOf(a3));
            hashMap.put("pingDelay", substring);
            hashMap.put("speedDelay", substring2);
            hashMap.put("totcpu", String.valueOf(com.tencent.gsdk.api.g.d()));
            hashMap.put("availmem", String.valueOf(com.tencent.gsdk.api.g.b(r)));
            a("gsdk_report_460", System.currentTimeMillis(), true, (Map<String, String>) hashMap);
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("doTimeOutDetect error:" + e2.getMessage());
        }
    }

    private void b(a aVar) {
        if (ab == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (aVar.b == 1) {
                hashMap.put("s1", ab.get("1").b);
                hashMap.put("t1", String.valueOf(ab.get("1").c));
                hashMap.put("s2", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
                hashMap.put("t2", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            } else if (aVar.b == 2) {
                if (ab.containsKey("1")) {
                    hashMap.put("s1", ab.get("1").b);
                    hashMap.put("t1", String.valueOf(ab.get("1").c));
                } else {
                    hashMap.put("s1", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
                    hashMap.put("t1", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
                }
                hashMap.put("s2", ab.get("2").b);
                hashMap.put("t2", String.valueOf(ab.get("2").c));
            } else {
                if (ab.containsKey("1")) {
                    hashMap.put("s1", ab.get("1").b);
                    hashMap.put("t1", String.valueOf(ab.get("1").c));
                } else {
                    hashMap.put("s1", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
                    hashMap.put("t1", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
                }
                if (ab.containsKey("2")) {
                    hashMap.put("s2", ab.get("2").b);
                    hashMap.put("t2", String.valueOf(ab.get("2").c));
                } else {
                    hashMap.put("s2", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
                    hashMap.put("t2", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
                }
            }
            for (String str : ab.keySet()) {
                if (!str.equals("1") && !str.equals("2")) {
                    hashMap.put(AnalyticsEventKey.SEARCH_QUERY + str, ab.get(str).b);
                    hashMap.put("t" + str, String.valueOf(ab.get(str).c));
                }
            }
            a("gsdk_report_pay", System.currentTimeMillis(), true, (Map<String, String>) hashMap);
            if (ab != null) {
                ab.clear();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0314  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(java.lang.String r46) {
        /*
            Method dump skipped, instructions count: 960
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.gsdk.api.GSDKSystem.e(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.tencent.gsdk.api.b bVar) {
        if (bVar == null) {
            return;
        }
        final int i2 = bVar.e;
        final int i3 = bVar.f6230a;
        final int i4 = bVar.l;
        final int i5 = bVar.n;
        final int i6 = bVar.o;
        final int i7 = bVar.p;
        final int i8 = bVar.r;
        final String str = bVar.b;
        int i9 = this.ai;
        if (i9 == 1) {
            try {
                Method method = Class.forName("com.unity3d.player.UnityPlayer").getMethod("UnitySendMessage", String.class, String.class, String.class);
                if (i2 > 0) {
                    method.invoke(null, "GSDKCallBackGameObejct", "GSDKStartCallback", "" + i3 + "|" + str + "|" + i4 + "|" + i5 + "|" + i6 + "|" + i7 + "|" + i8);
                } else {
                    method.invoke(null, "GSDKCallBackGameObejct", "GSDKStartCallback", "" + i3 + "|" + str + "|0|0");
                }
                return;
            } catch (Exception e2) {
                com.tencent.gsdk.utils.g.c("UnityPlayer startFPS error:" + e2.getMessage());
                return;
            }
        }
        if (i9 == 2) {
            if (this.aj == null) {
                return;
            }
            try {
                Class<?> cls = Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
                if (cls == null) {
                    return;
                }
                cls.getMethod("runOnGLThread", Runnable.class).invoke(this.aj, new Runnable() { // from class: com.tencent.gsdk.api.GSDKSystem.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i2 > 0) {
                            JNIHelper.SendInfo(i3 + "|" + str + "|" + i4 + "|" + i5 + "|" + i6 + "|" + i7 + "|" + i8);
                            return;
                        }
                        JNIHelper.SendInfo(i3 + "|" + str + "|0|0|0|0|0");
                    }
                });
                return;
            } catch (Exception e3) {
                com.tencent.gsdk.utils.g.c("Cocos2dxActivity startFPS error:" + e3.getMessage());
                return;
            }
        }
        if (i9 == 3) {
            try {
                if (i2 > 0) {
                    JNIHelper.SendInfo(i3 + "|" + str + "|" + i4 + "|" + i5 + "|" + i6 + "|" + i7 + "|" + i8);
                } else {
                    JNIHelper.SendInfo(i3 + "|" + str + "|0|0|0|0|0");
                }
            } catch (Exception e4) {
                com.tencent.gsdk.utils.g.c("GameActivity startFPS error:" + e4.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.tencent.gsdk.api.b bVar) {
        if (bVar.j > 0) {
            Q = com.tencent.gsdk.api.g.k();
        }
    }

    private void p() {
        R = 0L;
        Timer timer = o;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = p;
        if (timer2 != null) {
            timer2.cancel();
        }
        Timer timer3 = q;
        if (timer3 != null) {
            timer3.cancel();
        }
        List<Long> list = f6215a;
        if (list != null) {
            list.clear();
        }
        List<Long> list2 = b;
        if (list2 != null) {
            list2.clear();
        }
        List<Long> list3 = c;
        if (list3 != null) {
            list3.clear();
        }
        List<Long> list4 = e;
        if (list4 != null) {
            list4.clear();
        }
        List<Long> list5 = d;
        if (list5 != null) {
            list5.clear();
        }
        List<Long> list6 = g;
        if (list6 != null) {
            list6.clear();
        }
        List<Long> list7 = f;
        if (list7 != null) {
            list7.clear();
        }
        List<Long> list8 = h;
        if (list8 != null) {
            list8.clear();
        }
        List<Long> list9 = i;
        if (list9 != null) {
            list9.clear();
        }
        List<Long> list10 = j;
        if (list10 != null) {
            list10.clear();
        }
        List<Long> list11 = k;
        if (list11 != null) {
            list11.clear();
        }
        List<Long> list12 = l;
        if (list12 != null) {
            list12.clear();
        }
        List<Long> list13 = m;
        if (list13 != null) {
            list13.clear();
        }
        List<Long> list14 = n;
        if (list14 != null) {
            list14.clear();
        }
        this.ag = null;
        com.tencent.gsdk.api.a.a(0);
    }

    public void a(com.tencent.gsdk.api.b bVar, com.tencent.gsdk.api.c cVar) {
        com.tencent.gsdk.api.b bVar2;
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        HashMap hashMap;
        int i3;
        double d2;
        double d3;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        HashMap hashMap2;
        long j8;
        long j9;
        long j10;
        long j11;
        double d4;
        int i4;
        double d5;
        long j12;
        long j13;
        double d6;
        long j14;
        long j15;
        long j16;
        String str6;
        String str7;
        com.tencent.gsdk.api.b bVar3;
        com.tencent.gsdk.api.b bVar4 = bVar;
        if (bVar4 == null || com.tencent.gsdk.api.f.c(r, com.tencent.gsdk.api.f.f6234a, com.tencent.gsdk.api.f.t) != 0) {
            return;
        }
        M = false;
        Timer timer = o;
        if (timer != null) {
            timer.cancel();
            o = null;
        }
        Timer timer2 = p;
        if (timer2 != null) {
            timer2.cancel();
            p = null;
        }
        Timer timer3 = q;
        if (timer3 != null) {
            timer3.cancel();
            q = null;
        }
        P = System.currentTimeMillis();
        List<Long> list = f6215a;
        int size = list != null ? list.size() : 0;
        List<Long> list2 = b;
        int size2 = list2 != null ? list2.size() : 0;
        int i5 = size + size2;
        String str8 = GSDKPlatform.mTag;
        String e2 = e();
        HashMap hashMap3 = new HashMap();
        hashMap3.put("version", y);
        hashMap3.put("openid", e2);
        hashMap3.put(SocialOperation.GAME_ZONE_ID, this.al);
        if (bVar4.f6230a == 0 && bVar4.e > 0) {
            hashMap3.put("fmin", String.valueOf(cVar.c));
            hashMap3.put("fmax", String.valueOf(cVar.b));
            hashMap3.put("favg", String.valueOf(cVar.f6231a));
            hashMap3.put("fheavy", String.valueOf(cVar.e));
            hashMap3.put("flight", String.valueOf(cVar.f));
            hashMap3.put("ftotal", String.valueOf(cVar.d));
            hashMap3.put("fcntx0", String.valueOf(cVar.g));
            hashMap3.put("lfps1", cVar.h + "");
            hashMap3.put("lfps2", cVar.i + "");
            hashMap3.put("lfps3", cVar.j + "");
        } else {
            hashMap3.put("fmin", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("fmax", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("favg", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("fheavy", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("flight", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("ftotal", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("fcntx0", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("lfps1", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("lfps2", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("lfps3", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        }
        hashMap3.put(ViewHierarchyConstants.TAG_KEY, str8);
        String valueOf = String.valueOf(P / 1000);
        String valueOf2 = String.valueOf((P - O) / 1000);
        hashMap3.put("etime", valueOf);
        hashMap3.put("time", valueOf2);
        if (bVar4.f6230a == 0 && bVar4.f > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (f6215a != null) {
                int i6 = 0;
                d6 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                while (i6 < size) {
                    double longValue = f6215a.get(i6).longValue();
                    Double.isNaN(longValue);
                    d6 += longValue;
                    if (i6 <= size - 2) {
                        int i7 = i6 + 1;
                        long longValue2 = f6215a.get(i7).longValue() - f6215a.get(i6).longValue();
                        if (longValue2 >= 100) {
                            arrayList.add(Integer.valueOf(i7));
                            bVar3 = bVar;
                        } else {
                            bVar3 = bVar;
                        }
                        str6 = valueOf;
                        str7 = valueOf2;
                        if (longValue2 >= bVar3.m) {
                            arrayList2.add(Integer.valueOf(i7));
                        }
                    } else {
                        str6 = valueOf;
                        str7 = valueOf2;
                        bVar3 = bVar;
                    }
                    i6++;
                    bVar4 = bVar3;
                    valueOf = str6;
                    valueOf2 = str7;
                }
                bVar2 = bVar4;
                str3 = valueOf;
                str4 = valueOf2;
            } else {
                bVar2 = bVar4;
                str3 = valueOf;
                str4 = valueOf2;
                d6 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            long size3 = arrayList.size();
            long size4 = arrayList2.size();
            List<Long> list3 = f6215a;
            if (list3 == null || list3.size() == 0) {
                j14 = 0;
                j15 = 0;
            } else {
                j15 = f6215a.get(0).longValue();
                j14 = f6215a.get(0).longValue();
                for (Long l2 : f6215a) {
                    if (l2.longValue() < j15) {
                        j15 = l2.longValue();
                    }
                    if (l2.longValue() > j14) {
                        j14 = l2.longValue();
                    }
                }
            }
            if (size != 0) {
                str = str8;
                double d7 = size;
                Double.isNaN(d7);
                j16 = Math.round(d6 / d7);
            } else {
                str = str8;
                j16 = 0;
            }
            str2 = e2;
            hashMap3.put("pmin", String.valueOf(j15));
            hashMap3.put("pmax", String.valueOf(j14));
            hashMap3.put("pavg", String.valueOf(j16));
            hashMap3.put("pheavy", String.valueOf(size3));
            hashMap3.put("plost", String.valueOf(size2));
            hashMap3.put("ptotal", String.valueOf(i5));
            hashMap3.put("pcntx00", String.valueOf(size4));
        } else {
            bVar2 = bVar4;
            str = str8;
            str2 = e2;
            str3 = valueOf;
            str4 = valueOf2;
            hashMap3.put("pmin", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("pmax", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("pavg", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("pheavy", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("plost", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("ptotal", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("pcntx00", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        }
        if (bVar2.f6230a == 0 && bVar2.h > 0) {
            List<Long> list4 = d;
            if (list4 != null) {
                j9 = -1;
                for (Long l3 : list4) {
                    if (l3.longValue() > j9) {
                        j9 = l3.longValue();
                    }
                }
                if (d.size() >= 1) {
                    j10 = d.get(0).longValue();
                    List<Long> list5 = d;
                    j11 = list5.get(list5.size() - 1).longValue();
                } else {
                    j10 = -1;
                    j11 = -1;
                }
                d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i8 = 0; i8 < d.size(); i8++) {
                    double longValue3 = d.get(i8).longValue();
                    Double.isNaN(longValue3);
                    d4 += longValue3;
                }
            } else {
                j9 = -1;
                j10 = -1;
                j11 = -1;
                d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            if (e != null) {
                int i9 = 0;
                d5 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                while (i9 < e.size()) {
                    double longValue4 = e.get(i9).longValue();
                    Double.isNaN(longValue4);
                    d5 += longValue4;
                    i9++;
                    i5 = i5;
                }
                i4 = i5;
            } else {
                i4 = i5;
                d5 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            if (i4 != 0) {
                i2 = i4;
                double d8 = i2;
                Double.isNaN(d8);
                j13 = Math.round(d4 / d8);
                Double.isNaN(d8);
                j12 = Math.round(d5 / d8);
            } else {
                i2 = i4;
                j12 = 0;
                j13 = 0;
            }
            long a2 = com.tencent.gsdk.api.g.a(r);
            str5 = str;
            hashMap3.put("mem", String.valueOf(j13));
            hashMap3.put("availmem", String.valueOf(j12));
            hashMap3.put("totalmem", String.valueOf(a2));
            hashMap3.put("max_mem ", String.valueOf(j9));
            hashMap3.put("start_mem", String.valueOf(j10));
            hashMap3.put("end_mem", String.valueOf(j11));
        } else {
            i2 = i5;
            str5 = str;
            hashMap3.put("mem", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("availmem", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("totalmem", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("max_mem ", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("start_mem", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap3.put("end_mem", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        }
        if (bVar2.f6230a == 0 && bVar2.g > 0) {
            if (f != null) {
                d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i10 = 0; i10 < f.size(); i10++) {
                    double longValue5 = f.get(i10).longValue();
                    Double.isNaN(longValue5);
                    d2 += longValue5;
                }
            } else {
                d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            if (g != null) {
                d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i11 = 0; i11 < g.size(); i11++) {
                    double longValue6 = g.get(i11).longValue();
                    Double.isNaN(longValue6);
                    d3 += longValue6;
                }
            } else {
                d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            if (i2 != 0) {
                double d9 = i2;
                Double.isNaN(d9);
                j3 = Math.round(d2 / d9);
                Double.isNaN(d9);
                j2 = Math.round(d3 / d9);
            } else {
                j2 = 0;
                j3 = 0;
            }
            List<Long> list6 = h;
            if (list6 == null || list6.size() == 0) {
                j4 = -1;
                j5 = -1;
            } else {
                long longValue7 = h.get(0).longValue();
                j5 = longValue7;
                long j17 = 0;
                for (Long l4 : h) {
                    if (l4.longValue() > j5) {
                        j5 = l4.longValue();
                    }
                    j17 += l4.longValue();
                }
                j4 = j17 / h.size();
            }
            List<Long> list7 = i;
            if (list7 == null || list7.size() == 0) {
                j6 = -1;
                j7 = -1;
            } else {
                long longValue8 = i.get(0).longValue();
                j7 = longValue8;
                long j18 = 0;
                for (Long l5 : i) {
                    if (l5.longValue() > j7) {
                        j7 = l5.longValue();
                    }
                    j18 += l5.longValue();
                }
                j6 = j18 / i.size();
            }
            List<Long> list8 = j;
            if (list8 == null || list8.size() == 0) {
                hashMap2 = hashMap3;
                j8 = -1;
            } else {
                Iterator<Long> it = j.iterator();
                long j19 = 0;
                while (it.hasNext()) {
                    j19 += it.next().longValue();
                }
                hashMap2 = hashMap3;
                j8 = j19 / j.size();
            }
            hashMap = hashMap2;
            hashMap.put("cpu", String.valueOf(j3));
            hashMap.put("totcpu", String.valueOf(j2));
            hashMap.put("cpu_temp_max", String.valueOf(j5));
            hashMap.put("cpu_temp_avg", String.valueOf(j4));
            hashMap.put("gpu_temp_avg", String.valueOf(j6));
            hashMap.put("gpu_temp_max", String.valueOf(j7));
            hashMap.put("gpu", String.valueOf(j8));
        } else {
            hashMap = hashMap3;
            hashMap.put("cpu", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("totcpu", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("cpu_temp_max", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("cpu_temp_avg", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("gpu_temp_avg", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("gpu_temp_max", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("gpu", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        }
        if (bVar2.f6230a == 0 && bVar2.i > 0) {
            U = com.tencent.gsdk.api.a.a();
            int i12 = T;
            int i13 = -1;
            if (i12 != -1 && (i3 = U) != -1) {
                i13 = i12 - i3;
            }
            hashMap.put("battery", String.valueOf(i13));
            hashMap.put("start_battery", String.valueOf(T));
            hashMap.put("end_battery", String.valueOf(U));
            hashMap.put("bt", String.valueOf(com.tencent.gsdk.api.g.d(r)));
            hashMap.put("bs", String.valueOf(com.tencent.gsdk.api.a.b()));
        } else {
            hashMap.put("battery", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("start_battery", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("end_battery", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("bt", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("bs", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        }
        if (bVar2.f6230a == 0 && bVar2.j > 0) {
            hashMap.put("netflow", String.valueOf((com.tencent.gsdk.api.g.k() - Q) / 1024));
        } else {
            hashMap.put("netflow", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        }
        if (bVar2.f6230a == 0 && bVar2.q > 0) {
            List<Long> list9 = k;
            if (list9 != null && list9.size() != 0) {
                int i14 = 0;
                for (int i15 = 0; i15 < k.size(); i15++) {
                    i14 = (int) (i14 + k.get(i15).longValue());
                }
                Y = i14 / k.size();
            }
            hashMap.put("devices", String.valueOf(V));
            hashMap.put("wifi_num", String.valueOf(W));
            hashMap.put("wifi_rssi", String.valueOf(X));
            List<Long> list10 = n;
            if (list10 != null && list10.size() != 0) {
                long j20 = 0;
                for (int i16 = 0; i16 < n.size(); i16++) {
                    j20 += n.get(i16).longValue();
                }
                hashMap.put("wifi_speed", String.valueOf(j20 / n.size()));
            } else {
                hashMap.put("wifi_speed", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            }
            hashMap.put("gate_delay", String.valueOf(Y));
        } else {
            hashMap.put("devices", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("wifi_num", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("wifi_rssi", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("wifi_speed", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
            hashMap.put("gate_delay", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        }
        List<Long> list11 = l;
        if (list11 != null && list11.size() != 0) {
            int i17 = 0;
            for (int i18 = 0; i18 < l.size(); i18++) {
                i17 = (int) (i17 + l.get(i18).longValue());
            }
            Z = i17 / l.size();
            hashMap.put("signal_level", String.valueOf(Z));
        } else {
            hashMap.put("signal_level", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        }
        hashMap.put("xg", com.tencent.gsdk.utils.c.b(r));
        String str9 = GSDKPlatform.mRoomIp;
        if (str9 != null) {
            hashMap.put("roomip", str9);
        } else {
            hashMap.put("roomip", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        }
        b bVar5 = this.ah;
        if (bVar5 != null) {
            hashMap.put("gpu_model", bVar5.f6220a);
        } else {
            hashMap.put("gpu_model", CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
        }
        hashMap.put("cpu_model", com.tencent.gsdk.api.g.c().get("Hardware"));
        hashMap.put("cpu_core", String.valueOf(com.tencent.gsdk.api.g.a()));
        hashMap.put("cpu_freq", com.tencent.gsdk.api.g.b());
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        hashMap.put("resolution", com.tencent.gsdk.api.g.l());
        long e3 = com.tencent.gsdk.api.g.e(a());
        long f2 = com.tencent.gsdk.api.g.f(a());
        hashMap.put("total_storage", String.valueOf(e3));
        hashMap.put("free_storage", String.valueOf(f2));
        a("gsdk_report_1", O, true, (Map<String, String>) hashMap);
        a(bVar, str5, str4, str3, str2, cVar);
    }

    private void a(com.tencent.gsdk.api.b bVar, String str, String str2, String str3, String str4, com.tencent.gsdk.api.c cVar) {
        try {
            int i2 = 1024;
            if (bVar.g == 2) {
                HashMap hashMap = new HashMap();
                hashMap.put(ViewHierarchyConstants.TAG_KEY, str);
                hashMap.put("time", str2);
                hashMap.put("etime", str3);
                hashMap.put("openid", str4);
                String str5 = "";
                if (f != null && f.size() != 0) {
                    Iterator<Long> it = f.iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        long longValue = it.next().longValue();
                        if (str5.length() + String.valueOf(longValue).length() > 1024) {
                            hashMap.put("cpu_list" + i3, str5);
                            i3++;
                            str5 = String.valueOf(longValue) + ",";
                        } else {
                            str5 = str5 + String.valueOf(longValue) + ",";
                        }
                        if (i3 > 45) {
                            break;
                        }
                    }
                    if (str5.length() > 0 && i3 <= 45) {
                        hashMap.put("cpu_list" + i3, str5);
                    }
                } else {
                    hashMap.put("cpu_list", "");
                }
                a("gsdk_report_cpuList", O, true, (Map<String, String>) hashMap);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(ViewHierarchyConstants.TAG_KEY, str);
                hashMap2.put("time", str2);
                hashMap2.put("etime", str3);
                hashMap2.put("openid", str4);
                String str6 = "";
                if (h != null && h.size() != 0) {
                    Iterator<Long> it2 = h.iterator();
                    int i4 = 0;
                    while (it2.hasNext()) {
                        long longValue2 = it2.next().longValue();
                        if (str6.length() + String.valueOf(longValue2).length() > i2) {
                            hashMap2.put("cpu_temp_list" + i4, str6);
                            str6 = String.valueOf(longValue2) + ",";
                            i4++;
                        } else {
                            str6 = str6 + String.valueOf(longValue2) + ",";
                        }
                        if (i4 > 45) {
                            break;
                        } else {
                            i2 = 1024;
                        }
                    }
                    if (str6.length() > 0 && i4 <= 45) {
                        hashMap2.put("cpu_temp_list" + i4, str6);
                    }
                } else {
                    hashMap2.put("cpu_temp_list", "");
                }
                a("gsdk_report_cpuTempList", O, true, (Map<String, String>) hashMap2);
                HashMap hashMap3 = new HashMap();
                hashMap3.put(ViewHierarchyConstants.TAG_KEY, str);
                hashMap3.put("time", str2);
                hashMap3.put("etime", str3);
                hashMap3.put("openid", str4);
                String str7 = "";
                if (i != null && i.size() != 0) {
                    Iterator<Long> it3 = i.iterator();
                    int i5 = 0;
                    while (it3.hasNext()) {
                        long longValue3 = it3.next().longValue();
                        if (str7.length() + String.valueOf(longValue3).length() > 1024) {
                            hashMap3.put("gpu_temp_list" + i5, str7);
                            str7 = String.valueOf(longValue3) + ",";
                            i5++;
                        } else {
                            str7 = str7 + String.valueOf(longValue3) + ",";
                        }
                        if (i5 > 45) {
                            break;
                        }
                    }
                    if (str7.length() > 0 && i5 <= 45) {
                        hashMap3.put("gpu_temp_list" + i5, str7);
                    }
                } else {
                    hashMap3.put("gpu_temp_list", "");
                }
                a("gsdk_report_gpuTempList", O, true, (Map<String, String>) hashMap3);
                HashMap hashMap4 = new HashMap();
                hashMap4.put(ViewHierarchyConstants.TAG_KEY, str);
                hashMap4.put("time", str2);
                hashMap4.put("etime", str3);
                hashMap4.put("openid", str4);
                String str8 = "";
                if (j != null && j.size() != 0) {
                    Iterator<Long> it4 = j.iterator();
                    int i6 = 0;
                    while (it4.hasNext()) {
                        long longValue4 = it4.next().longValue();
                        if (str8.length() + String.valueOf(longValue4).length() > 1024) {
                            hashMap4.put("gpu_usage_list" + i6, str8);
                            str8 = String.valueOf(longValue4) + ",";
                            i6++;
                        } else {
                            str8 = str8 + String.valueOf(longValue4) + ",";
                        }
                        if (i6 > 45) {
                            break;
                        }
                    }
                    if (str8.length() > 0 && i6 <= 45) {
                        hashMap4.put("gpu_usage_list" + i6, str8);
                    }
                } else {
                    hashMap4.put("gpu_usage_list", "");
                }
                a("gsdk_report_gpuUsageList", O, true, (Map<String, String>) hashMap4);
            }
            if (bVar.h == 2) {
                HashMap hashMap5 = new HashMap();
                hashMap5.put(ViewHierarchyConstants.TAG_KEY, str);
                hashMap5.put("time", str2);
                hashMap5.put("etime", str3);
                hashMap5.put("openid", str4);
                String str9 = "";
                if (d != null && d.size() != 0) {
                    Iterator<Long> it5 = d.iterator();
                    int i7 = 0;
                    while (it5.hasNext()) {
                        long longValue5 = it5.next().longValue();
                        if (str9.length() + String.valueOf(longValue5).length() > 1024) {
                            hashMap5.put("mem_list" + i7, str9);
                            str9 = String.valueOf(longValue5) + ",";
                            i7++;
                        } else {
                            str9 = str9 + String.valueOf(longValue5) + ",";
                        }
                        if (i7 > 45) {
                            break;
                        }
                    }
                    if (str9.length() > 0 && i7 <= 45) {
                        hashMap5.put("mem_list" + i7, str9);
                    }
                } else {
                    hashMap5.put("mem_list", "");
                }
                a("gsdk_report_memList", O, true, (Map<String, String>) hashMap5);
            }
            if (bVar.f == 2) {
                HashMap hashMap6 = new HashMap();
                hashMap6.put(ViewHierarchyConstants.TAG_KEY, str);
                hashMap6.put("time", str2);
                hashMap6.put("etime", str3);
                hashMap6.put("openid", str4);
                String str10 = "";
                if (c != null && c.size() != 0) {
                    Iterator<Long> it6 = c.iterator();
                    int i8 = 0;
                    while (it6.hasNext()) {
                        long longValue6 = it6.next().longValue();
                        if (str10.length() + String.valueOf(longValue6).length() > 1024) {
                            hashMap6.put("udp_list" + i8, str10);
                            str10 = String.valueOf(longValue6) + ",";
                            i8++;
                        } else {
                            str10 = str10 + String.valueOf(longValue6) + ",";
                        }
                        if (i8 > 45) {
                            break;
                        }
                    }
                    if (str10.length() > 0 && i8 <= 45) {
                        hashMap6.put("udp_list" + i8, str10);
                    }
                } else {
                    hashMap6.put("udp_list", "");
                }
                a("gsdk_report_udpList", O, true, (Map<String, String>) hashMap6);
                HashMap hashMap7 = new HashMap();
                hashMap7.put(ViewHierarchyConstants.TAG_KEY, str);
                hashMap7.put("time", str2);
                hashMap7.put("etime", str3);
                hashMap7.put("openid", str4);
                String str11 = "";
                if (m != null && m.size() != 0) {
                    Iterator<Long> it7 = m.iterator();
                    int i9 = 0;
                    while (it7.hasNext()) {
                        long longValue7 = it7.next().longValue();
                        if (str11.length() + String.valueOf(longValue7).length() > 1024) {
                            hashMap7.put("signal_list" + i9, str11);
                            str11 = String.valueOf(longValue7) + ",";
                            i9++;
                        } else {
                            str11 = str11 + String.valueOf(longValue7) + ",";
                        }
                        if (i9 > 45) {
                            break;
                        }
                    }
                    if (str11.length() > 0 && i9 <= 45) {
                        hashMap7.put("signal_list" + i9, str11);
                    }
                } else {
                    hashMap7.put("signal_list", "");
                }
                a("gsdk_report_signalList", O, true, (Map<String, String>) hashMap7);
                HashMap hashMap8 = new HashMap();
                hashMap8.put(ViewHierarchyConstants.TAG_KEY, str);
                hashMap8.put("time", str2);
                hashMap8.put("etime", str3);
                hashMap8.put("openid", str4);
                String str12 = "";
                if (n != null && n.size() != 0) {
                    Iterator<Long> it8 = n.iterator();
                    int i10 = 0;
                    while (it8.hasNext()) {
                        long longValue8 = it8.next().longValue();
                        if (str12.length() + String.valueOf(longValue8).length() > 1024) {
                            hashMap8.put("link_speed_list" + i10, str12);
                            str12 = String.valueOf(longValue8) + ",";
                            i10++;
                        } else {
                            str12 = str12 + String.valueOf(longValue8) + ",";
                        }
                        if (i10 > 45) {
                            break;
                        }
                    }
                    if (str12.length() > 0 && i10 <= 45) {
                        hashMap8.put("link_speed_list" + i10, str12);
                    }
                } else {
                    hashMap8.put("link_speed_list", "");
                }
                a("gsdk_report_linkSpeedList", O, true, (Map<String, String>) hashMap8);
            }
            if (bVar.e == 2) {
                HashMap hashMap9 = new HashMap();
                hashMap9.put(ViewHierarchyConstants.TAG_KEY, str);
                hashMap9.put("time", str2);
                hashMap9.put("etime", str3);
                hashMap9.put("openid", str4);
                String[] strArr = null;
                if (cVar.k != null && cVar.k.contains(",")) {
                    strArr = cVar.k.split(",");
                }
                if (strArr != null && strArr.length != 0) {
                    String str13 = "";
                    int i11 = 0;
                    for (String str14 : strArr) {
                        if (str13.length() + str14.length() > 1024) {
                            hashMap9.put("fps_list" + i11, str13);
                            str13 = str14 + ",";
                            i11++;
                        } else {
                            str13 = str13 + str14 + ",";
                        }
                        if (i11 > 45) {
                            break;
                        }
                    }
                    if (str13.length() > 0 && i11 <= 45) {
                        hashMap9.put("fps_list" + i11, str13);
                    }
                } else {
                    hashMap9.put("fps_list", "");
                }
                a("gsdk_report_fpsList", O, true, (Map<String, String>) hashMap9);
            }
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("reportGsdkList error:" + e2.getMessage());
        }
    }

    public static String e() {
        return com.tencent.gsdk.api.f.b(r, com.tencent.gsdk.api.f.f6234a, com.tencent.gsdk.api.f.d);
    }

    private void a(String str, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("rcr", str);
        if (z2) {
            hashMap.put("isCache", "1");
        } else {
            hashMap.put("isCache", "0");
        }
        a("gsdk_report_0", O, true, (Map<String, String>) hashMap);
    }

    public static void a(String str, long j2, boolean z2, Map<String, String> map) {
        com.tencent.gsdk.utils.a.c.a(str, map);
    }

    public static String d(String str) {
        String str2 = "";
        int i2 = Build.VERSION.SDK_INT;
        String str3 = s;
        if (str3 == null || str3.length() == 0) {
            s = "NULL";
        }
        String m2 = m();
        if (TextUtils.isEmpty(m2)) {
            com.tencent.gsdk.utils.g.d("request controller environment parameter error");
            return "";
        }
        try {
            String str4 = m2 + D + F + s;
            com.tencent.gsdk.utils.g.a("request controller url:" + str4);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str4).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setUseCaches(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, v);
            jSONObject.put("openid", e());
            jSONObject.put("os", 1);
            jSONObject.put("platapi", i2);
            jSONObject.put("version", y);
            jSONObject.put(SocialOperation.GAME_ZONE_ID, str);
            byte[] bytes = com.tencent.gsdk.utils.a.a(jSONObject.toString()).getBytes();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.close();
                inputStream.close();
                String str5 = new String(byteArrayOutputStream.toByteArray());
                try {
                    str2 = com.tencent.gsdk.utils.a.b(str5);
                    com.tencent.gsdk.utils.g.a("request controller result:" + str2);
                } catch (Exception e2) {
                    e = e2;
                    str2 = str5;
                    com.tencent.gsdk.utils.g.d("request controller error, msg:" + e.getMessage());
                    return str2;
                }
            } else {
                com.tencent.gsdk.utils.g.d("request controller response code error is:" + httpURLConnection.getResponseCode());
            }
        } catch (Exception e3) {
            e = e3;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class i extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        private int f6227a;
        private int b;

        public i(com.tencent.gsdk.api.b bVar, int i) {
            this.f6227a = bVar.q;
            this.b = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.f6227a <= 0 || this.b != 4) {
                if (!com.tencent.gsdk.utils.c.a(GSDKSystem.r) || this.b == 4) {
                    return;
                }
                long a2 = com.tencent.gsdk.utils.c.a();
                if (GSDKSystem.l != null) {
                    GSDKSystem.l.add(Long.valueOf(a2));
                }
                if (GSDKSystem.m != null) {
                    GSDKSystem.m.add(Long.valueOf(a2));
                    return;
                }
                return;
            }
            int unused = GSDKSystem.X = com.tencent.gsdk.utils.c.d(GSDKSystem.r);
            if (GSDKSystem.m != null) {
                GSDKSystem.m.add(Long.valueOf(GSDKSystem.X));
            }
            if (GSDKSystem.n != null) {
                GSDKSystem.n.add(Long.valueOf(com.tencent.gsdk.utils.c.e(GSDKSystem.r)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        private int f6225a;
        private int b;

        public g(com.tencent.gsdk.api.b bVar) {
            this.f6225a = bVar.h;
            this.b = bVar.g;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.f6225a > 0) {
                GSDKSystem.e.add(Long.valueOf(com.tencent.gsdk.api.g.b(GSDKSystem.r)));
                GSDKSystem.d.add(Long.valueOf(com.tencent.gsdk.api.g.c(GSDKSystem.r)));
            }
            if (this.b > 0) {
                if (GSDKSystem.g != null) {
                    GSDKSystem.g.add(Long.valueOf(com.tencent.gsdk.api.g.d()));
                }
                if (GSDKSystem.f != null) {
                    GSDKSystem.f.add(Long.valueOf(com.tencent.gsdk.api.g.e()));
                }
                if (GSDKSystem.h != null) {
                    GSDKSystem.h.add(Long.valueOf(com.tencent.gsdk.api.g.h()));
                }
                if (GSDKSystem.i != null) {
                    GSDKSystem.i.add(Long.valueOf(com.tencent.gsdk.api.g.i()));
                }
                if (GSDKSystem.j != null) {
                    GSDKSystem.j.add(Long.valueOf(com.tencent.gsdk.api.g.j()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class h extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        private String f6226a;
        private int b;
        private int c;

        public h(com.tencent.gsdk.api.b bVar) {
            this.f6226a = bVar.c;
            this.b = bVar.d;
            this.c = bVar.f;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.c > 0) {
                long unused = GSDKSystem.N = GSDKSystem.c(this.f6226a, this.b);
                com.tencent.gsdk.utils.g.a("socket cost time is " + GSDKSystem.N);
                if (GSDKSystem.H) {
                    if (GSDKSystem.f6215a != null) {
                        GSDKSystem.f6215a.add(Long.valueOf(GSDKSystem.N));
                    }
                    boolean unused2 = GSDKSystem.H = false;
                } else if (GSDKSystem.b != null) {
                    GSDKSystem.b.add(Long.valueOf(GSDKSystem.N));
                }
                if (GSDKSystem.c != null) {
                    GSDKSystem.c.add(Long.valueOf(GSDKSystem.N));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0096, code lost:
    
        r0 = java.lang.System.currentTimeMillis() - r14;
        com.tencent.gsdk.api.GSDKSystem.H = true;
     */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long c(java.lang.String r14, int r15) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.gsdk.api.GSDKSystem.c(java.lang.String, int):long");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String f(String str) {
        String str2;
        BufferedReader bufferedReader = null;
        ?? r1 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                URL url = new URL("http://182.254.116.117/d?dn=" + com.tencent.gsdk.utils.f.a(str, ">srW/8;&") + "&clientip=1&ttl=1&id=1");
                StringBuilder sb = new StringBuilder();
                sb.append("GSDK HttpDns URL: ");
                sb.append(url);
                com.tencent.gsdk.utils.g.a(sb.toString());
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(1000);
                openConnection.setReadTimeout(1000);
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader3.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String b2 = com.tencent.gsdk.utils.f.b(readLine, ">srW/8;&");
                        com.tencent.gsdk.utils.g.a("HttpDnsServer response ips are " + b2);
                        if (b2.contains("|")) {
                            r1 = b2.substring(0, b2.indexOf("|"));
                        }
                    } catch (IOException e2) {
                        e = e2;
                        str2 = r1;
                        bufferedReader2 = bufferedReader3;
                        com.tencent.gsdk.utils.g.c("getHttpDns error:" + e.getMessage());
                        bufferedReader = bufferedReader2;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                                bufferedReader = bufferedReader2;
                            } catch (IOException e3) {
                                ?? sb2 = new StringBuilder();
                                sb2.append("getHttpDns colse reader error:");
                                sb2.append(e3.getMessage());
                                com.tencent.gsdk.utils.g.c(sb2.toString());
                                bufferedReader = sb2;
                            }
                        }
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                com.tencent.gsdk.utils.g.c("getHttpDns colse reader error:" + e4.getMessage());
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader3.close();
                try {
                    bufferedReader3.close();
                } catch (IOException e5) {
                    com.tencent.gsdk.utils.g.c("getHttpDns colse reader error:" + e5.getMessage());
                }
                str2 = r1;
                bufferedReader = r1;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
            str2 = null;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        String f6223a;

        public e(String str) {
            this.f6223a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        String f6220a;

        public b(String str) {
            this.f6220a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f6219a;
        int b;
        boolean c;
        String d;

        public a(int i, int i2, boolean z, String str) {
            this.f6219a = -1;
            this.b = -1;
            this.c = false;
            this.d = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
            this.f6219a = i;
            this.b = i2;
            this.c = z;
            this.d = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        int f6221a;
        String b;
        long c;

        public c(int i, String str, long j) {
            this.f6221a = -1;
            this.b = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
            this.c = -1L;
            this.f6221a = i;
            this.b = str;
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j {

        /* renamed from: a, reason: collision with root package name */
        int f6228a;
        String b;
        long c;

        public j(int i, String str, long j) {
            this.f6228a = -1;
            this.b = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
            this.c = -1L;
            this.f6228a = i;
            this.b = str;
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Application.ActivityLifecycleCallbacks {
        f() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            com.tencent.gsdk.utils.g.a("onActivityCreated");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            com.tencent.gsdk.utils.g.a("onActivityStarted");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            com.tencent.gsdk.utils.g.a("onActivityResumed");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            com.tencent.gsdk.utils.g.a("onActivityPaused");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            com.tencent.gsdk.utils.g.a("onActivitySaveInstanceState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            com.tencent.gsdk.utils.g.a("onActivityStopped");
            if (!GSDKSystem.I || GSDKSystem.K || GSDKSystem.this.ak == null) {
                return;
            }
            try {
                if (GSDKSystem.this.ak.d || GSDKSystem.this.w == null) {
                    return;
                }
                Message obtain = Message.obtain();
                obtain.obj = GSDKSystem.this.ak;
                obtain.what = 8;
                GSDKSystem.this.w.sendMessage(obtain);
            } catch (Exception e) {
                com.tencent.gsdk.utils.g.d("gsdk onActivityStopped enum error:" + e.getMessage());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            com.tencent.gsdk.utils.g.a("onActivityDestroyed");
        }
    }
}
