package com.subao.common.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.helpshift.analytics.AnalyticsEventKey;
import com.subao.common.a.e;
import com.subao.common.b.b;
import com.subao.common.b.d;
import com.subao.common.c.e;
import com.subao.common.e.ab;
import com.subao.common.e.ad;
import com.subao.common.e.ah;
import com.subao.common.e.am;
import com.subao.common.e.an;
import com.subao.common.e.ao;
import com.subao.common.e.aq;
import com.subao.common.e.e;
import com.subao.common.e.f;
import com.subao.common.e.r;
import com.subao.common.e.u;
import com.subao.common.e.v;
import com.subao.common.e.z;
import com.subao.common.f;
import com.subao.common.i.d;
import com.subao.common.i.f;
import com.subao.common.i.n;
import com.subao.common.i.p;
import com.subao.common.intf.AccelSwitchListener;
import com.subao.common.intf.NodeDetectCallback;
import com.subao.common.intf.ProductList;
import com.subao.common.intf.QueryOriginUserStateCallback;
import com.subao.common.intf.QueryProductCallback;
import com.subao.common.intf.QuerySignCouponsCallback;
import com.subao.common.intf.QueryThirdPartyAuthInfoCallback;
import com.subao.common.intf.RequestBuyCallback;
import com.subao.common.intf.RequestTrialCallback;
import com.subao.common.intf.SupportGameLabel;
import com.subao.common.intf.UserAuthCallback;
import com.subao.common.intf.UserInfo;
import com.subao.common.intf.UserStateListener;
import com.subao.common.intf.VPNStateListener;
import com.subao.common.intf.XunyouTokenStateListener;
import com.subao.common.intf.XunyouUserStateCallback;
import com.subao.common.j.j;
import com.subao.common.j.l;
import com.subao.common.j.m;
import com.subao.common.k.d;
import com.subao.common.k.m;
import com.subao.vpn.JniCallback;
import com.subao.vpn.VPNJni;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class c implements com.subao.common.a.a, com.subao.common.a, d.a, d.c {
    private boolean A;
    private e.a B;
    private boolean C;
    private long E;
    private final b F;
    private final com.subao.common.k.j G;

    /* renamed from: a, reason: collision with root package name */
    final String f5867a;
    final String b;
    final String c;
    final com.subao.common.j.j d;
    final ab e;
    final com.subao.common.i.g f;
    private final Context h;
    private final r.a i;
    private final int j;
    private final v.a k;
    private final com.subao.common.g.c l;
    private final am m;
    private final com.subao.common.e.a n;
    private e o;
    private volatile r p;
    private int q;
    private final com.subao.common.k.v r;
    private final com.subao.common.i.i s;
    private volatile UserInfo u;
    private AccelSwitchListener v;
    private VPNStateListener w;
    private volatile UserStateListener x;
    private an y;
    private aq z;
    private int t = -1;
    final com.subao.common.b.q g = new com.subao.common.b.q();
    private final com.subao.common.e.i<an, ProductList> D = new com.subao.common.e.i<>(3600000);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void a(String str, byte[] bArr, XunyouTokenStateListener xunyouTokenStateListener);

        byte[] a();
    }

    static /* synthetic */ long K() {
        return L();
    }

    public c(Context context, r.a aVar, String str, String str2, com.subao.common.j.j jVar, com.subao.common.g.c cVar, am amVar, boolean z) {
        com.subao.common.f.b.a(context, str, cVar);
        com.subao.common.e.r.b = aVar;
        this.h = context.getApplicationContext();
        this.i = aVar;
        this.j = a(this.h);
        this.f5867a = str;
        this.b = str2;
        this.c = "";
        this.l = cVar;
        f.a.a(cVar);
        this.d = jVar;
        this.m = amVar == null ? new am() : amVar;
        this.F = f(str);
        com.subao.common.f.a.a(context, aVar);
        this.e = new ab(com.subao.common.f.d.a(new File(com.subao.common.f.a.a(), "proxy_data")));
        b(context);
        if (amVar == null) {
            this.m.a(context, aVar);
        }
        this.n = new com.subao.common.e.a(aVar, new o(l(), str2, this.m.c(), this.m.k(), this.d), cVar, new p(cVar));
        this.r = new com.subao.common.k.v(context, cVar);
        this.n.e();
        this.G = new com.subao.common.k.j(context, new com.subao.common.k.l() { // from class: com.subao.common.a.c.1
            @Override // com.subao.common.k.l
            public int a(Context context2) {
                return c.this.s();
            }
        });
        this.s = new com.subao.common.i.j(context, this.i, str2, str, this.c, this.d, new com.subao.common.i.f(new i()));
        this.y = this.m.j();
        if (this.y == null) {
            this.y = com.subao.common.e.f.a(f.g.DRONE);
        }
        this.f = com.subao.common.i.h.a(this.y, this.s);
        this.k = new v.a(l(), str2, this.m.i(), this.d);
        if (z) {
            com.subao.common.g.c cVar2 = this.l;
            com.subao.common.j.j jVar2 = this.d;
            a(new com.subao.common.a.d(this, cVar2, jVar2, new a(jVar2, this.f, str2), this.y, this.k));
        }
    }

    private b f(String str) {
        if ("D72C7B0F-B835-46BE-B0C6-5CA60CCED8AF".equals(str)) {
            return new d();
        }
        return new C0161c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(boolean z) {
        if (this.A != z) {
            this.A = z;
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public am e() {
        return this.m;
    }

    public void b(boolean z) {
        this.C = z;
    }

    @Override // com.subao.common.b.d.a
    public UserStateListener f() {
        return this.x;
    }

    private static long L() {
        return SystemClock.elapsedRealtime();
    }

    private static int a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.uid;
    }

    public static String a(String str, String str2) {
        return String.format("http://service.xunyou.mobi/?appid=%s&userid=%s", com.subao.common.e.a(str), com.subao.common.e.a(str2));
    }

    private static String a(String str, String str2, String str3, r.a aVar) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return str2;
        }
        if (aVar == r.a.ROM) {
            return str2 + str3 + str.substring(indexOf);
        }
        return str2 + str.substring(indexOf);
    }

    static com.subao.common.j.n a(com.subao.common.g.a aVar) {
        switch (aVar) {
            case TCP:
                return com.subao.common.j.n.TCP;
            case UDP:
                return com.subao.common.j.n.UDP;
            default:
                return com.subao.common.j.n.BOTH;
        }
    }

    com.subao.common.e.a g() {
        return this.n;
    }

    boolean h() {
        return this.p != null;
    }

    public aq c(boolean z) {
        if (z) {
            this.z = com.subao.common.e.a.a(this.h, com.subao.common.h.a.a(), this.C, this.l);
        }
        return this.z;
    }

    public List<SupportGameLabel> i() {
        List<com.subao.common.e.b> a2 = com.subao.common.h.a.a();
        if (a2 == null || a2.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(a2.size());
        for (com.subao.common.e.b bVar : a2) {
            arrayList.add(new SupportGameLabel(bVar.f5977a, bVar.b()));
        }
        return arrayList;
    }

    public void a(JniCallback jniCallback) {
        this.l.a(jniCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context j() {
        return this.h;
    }

    public v.a k() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return this.f5867a;
    }

    private void b(Context context) {
        ao b2 = ao.b();
        b2.a((ao) new ao.a() { // from class: com.subao.common.a.c.2
            @Override // com.subao.common.e.ao.a
            public void a(String str) {
                com.subao.common.i.k.a(str);
                c.this.l.b(0, "key_subao_id", str);
            }
        });
        b2.a(context);
        com.subao.common.i.k.a(ao.b().c());
    }

    @Override // com.subao.common.a
    public void a() {
        synchronized (this) {
            r rVar = this.p;
            this.p = null;
            if (rVar != null) {
                rVar.a();
            }
            this.l.a();
            this.r.a();
        }
    }

    public void a(e.a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.B = aVar;
    }

    public int m() {
        return this.l.b();
    }

    public int a(com.subao.common.g.a aVar, String str, String str2, int i2, byte[] bArr) {
        int a2 = h.a(this);
        if (a2 != 0) {
            return a2;
        }
        com.subao.common.k.d.a(this.h);
        com.subao.common.b.b.a(this.m.i(), l(), com.subao.common.f.d.a(com.subao.common.f.a.a("ac5")));
        this.n.a(this.m.d());
        this.n.a(bArr);
        byte[] a3 = this.n.a(this.l.b());
        e.a a4 = this.n.a();
        this.q = a4 == null ? 0 : a4.f5982a;
        String b2 = this.n.b();
        String c = this.n.c();
        String str3 = a4 == null ? null : a4.b;
        l.a a5 = this.d.a();
        boolean a6 = this.l.a(com.subao.common.e.f.a(), this.d.a().g, aVar, str, a3, str3, b2, c);
        if (a6) {
            h.a(aVar);
            h.a(this.h, this.l, this.i);
            this.l.b(0, "key_sdk_guid", this.f5867a);
            this.l.b(0, "key_current_app_package_name", this.h.getPackageName());
            if (aVar == com.subao.common.g.a.VPN) {
                this.z = this.n.a(this.h, this.C);
            } else {
                h.a(this.h, this.l, a(aVar), str2);
            }
            h.a(this.l, i2);
            this.l.b(0, "key_set_imsi", this.c);
            this.n.d();
            this.p = h.a(this.l);
            com.subao.common.i.a e2 = this.s.e();
            this.l.a(e2.a(), e2.b());
            if (aVar == com.subao.common.g.a.VPN) {
                this.o = e.a(new f(com.subao.common.m.b.a()), this.m.g() == null ? -1L : r2.intValue() * 1000);
            }
            this.d.a(new j());
            a(this.i);
            t.a(this.l.k());
            d(true);
            boolean z = this.l.b("key_is_load_mtk_so", "") == 1;
            if (z) {
                VPNJni.loadMTKLibrary();
                String otherLibraryLoadingError = VPNJni.getOtherLibraryLoadingError();
                if (!TextUtils.isEmpty(otherLibraryLoadingError)) {
                    this.l.b(0, "key_other_sdk_load_error", otherLibraryLoadingError);
                    VPNJni.resetOtherLibraryLoadingError();
                    z = false;
                }
            }
            com.subao.a.a.a(this.l, z);
            h.b(this.l);
            h.c(this.l);
            if (a5 == l.a.WIFI) {
                a(this.h, this.l);
            }
        }
        return a6 ? 0 : -1;
    }

    private void a(r.a aVar) {
        if (aVar != r.a.SDK) {
            this.l.a("C.Auth.RequestTimeout", Integer.toString(16));
            this.l.a("C.Auth.UserAuthRetryUpbound", "0");
        }
    }

    void n() {
        if (this.A) {
            l.a(this.h, this, this.f, this.s, this.q, this.v);
        } else {
            m.a(this.v);
        }
    }

    public int o() {
        int i2;
        if (this.p == null) {
            return 1000;
        }
        synchronized (this) {
            if (this.A) {
                i2 = 1002;
            } else {
                this.A = this.l.e();
                i2 = this.A ? 0 : 1001;
            }
        }
        if (i2 == 0) {
            n();
        }
        return i2;
    }

    public void p() {
        if (this.p == null) {
            return;
        }
        this.r.a();
        synchronized (this) {
            if (this.A) {
                this.l.f();
                this.A = false;
                n();
            }
        }
    }

    @Override // com.subao.common.a.a
    public int a(int i2) {
        v.a(this.w, true);
        if (this.p == null) {
            return 1000;
        }
        if (this.i == r.a.SDK) {
            return 1003;
        }
        if (!this.l.g(i2)) {
            return 1001;
        }
        o();
        return 0;
    }

    @Override // com.subao.common.a.a
    public void d() {
        v.a(this.w, false);
        if (this.p == null || this.i == r.a.SDK) {
            return;
        }
        p();
        this.l.o();
    }

    @Override // com.subao.common.a.a
    public boolean c() {
        return this.l.d();
    }

    @Override // com.subao.common.a.a
    public void b() {
        C();
    }

    public synchronized void a(AccelSwitchListener accelSwitchListener) {
        this.v = accelSwitchListener;
    }

    public void a(VPNStateListener vPNStateListener) {
        this.w = vPNStateListener;
    }

    @Override // com.subao.common.b.d.c
    public void a(long j2) {
        this.E = j2;
    }

    public void a(UserStateListener userStateListener) {
        this.x = userStateListener;
    }

    public long q() {
        return this.E;
    }

    public void a(String str, String str2, String str3, long j2, UserAuthCallback userAuthCallback, Object obj) {
        a(0, str, str2, str3, j2, userAuthCallback, obj);
    }

    private void a(int i2, String str, String str2, String str3, long j2, UserAuthCallback userAuthCallback, Object obj) {
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", String.format("setUserToken(%s, %s, %s)", str, str2, str3));
        }
        this.u = new UserInfo(str, str2, str3);
        com.subao.common.i.k.b(str);
        com.subao.common.j.e.a(false, null);
        this.l.a(i2, str, str2, str3);
        if (userAuthCallback != null) {
            u.a(this, j2, userAuthCallback, obj, str, x(), w());
        }
    }

    public void a(String str, byte[] bArr, XunyouTokenStateListener xunyouTokenStateListener) {
        this.F.a(str, bArr, xunyouTokenStateListener);
    }

    public void a(UserInfo userInfo, long j2, XunyouUserStateCallback xunyouUserStateCallback, Object obj, boolean z) {
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", String.format(com.subao.common.e.r.f6001a, "queryXunyouUserState(%s, %d)", userInfo.toString(), Long.valueOf(j2)));
        }
        this.u = userInfo;
        com.subao.common.i.k.b(userInfo.getUserId());
        y yVar = new y(xunyouUserStateCallback);
        if (z) {
            if (!this.d.b()) {
                yVar.onXunyouUserState(userInfo, obj, 1005, 0, "");
                return;
            }
            com.subao.common.b.b.a(userInfo.getUserId());
        }
        a(this.g.a(userInfo, yVar, obj), userInfo.getUserId(), userInfo.getToken(), userInfo.getAppId(), -1L, null, null);
    }

    public void a(long j2, XunyouUserStateCallback xunyouUserStateCallback, Object obj) {
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", String.format(com.subao.common.e.r.f6001a, "refreshXunyouUserState(%d)", Long.valueOf(j2)));
        }
        UserInfo userInfo = this.u;
        if (userInfo == null) {
            new y(xunyouUserStateCallback).onXunyouUserState(null, obj, 1004, 0, "");
        } else {
            a(userInfo, j2, xunyouUserStateCallback, obj, true);
        }
    }

    public void a(UserInfo userInfo, long j2, QueryOriginUserStateCallback queryOriginUserStateCallback, Object obj) {
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", String.format(com.subao.common.e.r.f6001a, "queryOriginUserState(%s, %d)", userInfo.toString(), Long.valueOf(j2)));
        }
        com.subao.common.b.j.a(this.d, this.m.i(), l(), userInfo, 15000L, queryOriginUserStateCallback, obj);
    }

    public byte[] r() {
        return this.F.a();
    }

    public void a(UserInfo userInfo, int i2, QueryThirdPartyAuthInfoCallback queryThirdPartyAuthInfoCallback) {
        if (!this.d.b()) {
            queryThirdPartyAuthInfoCallback.onThirdPartyAuthInfoResult(1005, null);
        } else {
            com.subao.common.m.d.a(new com.subao.common.b.l(l(), this.m.i(), this.b, userInfo, i2 <= 0 ? 8000 : i2, queryThirdPartyAuthInfoCallback));
        }
    }

    public boolean a(RequestTrialCallback requestTrialCallback) {
        UserInfo userInfo = this.u;
        if (userInfo != null) {
            return com.subao.common.b.b.a(this.f5867a, this.m.i(), userInfo.getUserId(), requestTrialCallback);
        }
        if (requestTrialCallback == null) {
            return false;
        }
        requestTrialCallback.onRequestTrialResult(1004);
        return false;
    }

    public void a(QueryProductCallback queryProductCallback, boolean z) {
        a(queryProductCallback, z, this.m.h(), this.D, this.d);
    }

    void a(QueryProductCallback queryProductCallback, boolean z, an anVar, com.subao.common.e.i<an, ProductList> iVar, com.subao.common.j.l lVar) {
        ProductList a2;
        if (z) {
            iVar.a(anVar, null);
            a2 = null;
        } else {
            a2 = iVar.a(anVar);
        }
        if (a2 == null) {
            if (!lVar.b()) {
                queryProductCallback.onQueryProductResult(1005, null);
                return;
            } else {
                com.subao.common.m.d.a(new com.subao.common.c.e(l(), anVar, new q(queryProductCallback, anVar, iVar)));
                return;
            }
        }
        queryProductCallback.onQueryProductResult(0, a2);
    }

    public void a(String str, String str2, int i2, RequestBuyCallback requestBuyCallback) {
        a(str, str2, i2, requestBuyCallback, this.m.h(), this.d);
    }

    void a(String str, String str2, int i2, RequestBuyCallback requestBuyCallback, an anVar, com.subao.common.j.l lVar) {
        UserInfo userInfo;
        if (!lVar.b()) {
            requestBuyCallback.onRequestBuyResult(1005, null);
            return;
        }
        if (!TextUtils.isEmpty(str) && ((userInfo = this.u) == null || !str.equals(userInfo.getUserId()))) {
            requestBuyCallback.onRequestBuyResult(1009, null);
            return;
        }
        com.subao.common.b.g b2 = com.subao.common.b.b.b(str);
        if (b2 == null || b2.f5925a == null) {
            requestBuyCallback.onRequestBuyResult(1009, null);
        } else {
            com.subao.common.m.d.a(new com.subao.common.c.a(l(), anVar, b2.f5925a, str2, i2, requestBuyCallback));
        }
    }

    public void a(QuerySignCouponsCallback querySignCouponsCallback) {
        UserInfo userInfo = this.u;
        String userId = userInfo == null ? null : userInfo.getUserId();
        if (userId == null) {
            querySignCouponsCallback.onQuerySignCouponsResult(1004, null);
        } else {
            com.subao.common.b.b.a(k(), userId, (u.a) new g(querySignCouponsCallback), true);
        }
    }

    public int s() {
        try {
            int a2 = this.r.a(this.h);
            Log.d("SubaoParallel", String.format(com.subao.common.e.r.f6001a, "request mobile fd = %d", Integer.valueOf(a2)));
            return a2;
        } catch (m.d e2) {
            Log.d("SubaoParallel", String.format(com.subao.common.e.r.f6001a, "request mobile fd failed, error = %d", Integer.valueOf(e2.a())));
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i2) {
        this.G.a(new com.subao.common.k.i(this.l, i2));
    }

    public int c(int i2) {
        e.a aVar = this.B;
        if (aVar == null) {
            return ConnectionsStatusCodes.STATUS_ENDPOINT_UNKNOWN;
        }
        com.subao.common.a.e a2 = aVar.a();
        if (a2 == null || !a2.b() || a2.protect(i2)) {
            return 0;
        }
        a2.a();
        return 8002;
    }

    public int t() {
        return this.t;
    }

    public void d(int i2) {
        this.l.b(i2);
    }

    public void e(int i2) {
        this.l.a(i2);
    }

    public void a(float f2, float f3) {
        this.l.a(f2, f3);
    }

    public String b(long j2) {
        int b2 = this.l.b("key_get_mail_action", String.valueOf(j2));
        String w2 = w();
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(b2);
        if (w2 == null) {
            w2 = "";
        }
        objArr[1] = w2;
        return String.format("%d,%s", objArr);
    }

    public void a(int i2, long j2) {
        this.l.b(0, "key_mail_action_success", String.format(com.subao.common.e.r.f6001a, "%d,%d", Integer.valueOf(i2), Long.valueOf(j2)));
    }

    public void f(int i2) {
        this.l.a(0, "key_mail_already_read", i2);
    }

    public void g(int i2) {
        this.l.a(0, "key_mail_already_click", i2);
    }

    public void h(int i2) {
        this.l.a(0, "key_go_activity_center", i2);
    }

    public int u() {
        int h2 = this.l.h();
        if (this.m.f() != null) {
            return this.m.f().intValue();
        }
        boolean c = c();
        l.a a2 = this.d.a();
        if (d.a.a()) {
            this.f.a(this.s.e().a(com.subao.common.i.k.a(), h2, a2.g, c));
        }
        return h2;
    }

    public void i(int i2) {
        this.t = i2;
        this.l.a(0, "key_free_flow_type", i2);
    }

    public void a(String str, int i2) {
        this.l.a(str, i2);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, int i2) {
        p.c cVar = new p.c(f2, (float) Math.sqrt(f3), f4, f5, f6, 0.0f, i2);
        this.f.a(cVar);
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", "onNetDelayQualityV3: " + cVar.toString());
        }
    }

    public String v() {
        return this.l.j();
    }

    public String j(int i2) {
        String userId;
        String appId;
        this.l.a(0, "key_mobile_switch_state", com.subao.common.j.k.a(this.h).a());
        String c = this.l.c(i2);
        if (!TextUtils.isEmpty(c)) {
            String e2 = this.m.e();
            if (!TextUtils.isEmpty(e2)) {
                c = a(c, e2, this.f5867a, com.subao.common.e.r.b);
            }
        }
        if (TextUtils.isEmpty(c)) {
            UserInfo userInfo = this.u;
            if (userInfo == null) {
                appId = null;
                userId = null;
            } else {
                userId = userInfo.getUserId();
                appId = userInfo.getAppId();
            }
            c = a(appId, userId);
        }
        com.subao.common.d.a("SubaoGame", c);
        return c;
    }

    public void d(boolean z) {
        this.l.a(0, "key_front_game_uid", z ? this.j : -1);
    }

    public String w() {
        return this.l.n();
    }

    public void a(String str) {
        this.l.b(0, "key_game_server_id", str);
    }

    public void k(int i2) {
        this.l.a(0, "key_sdk_player_level", i2);
    }

    public int x() {
        return this.l.l();
    }

    public void b(String str, String str2) {
        com.subao.common.b.b.a(new a(this.d, this.f, this.b), 0, (String) null, str, str2);
    }

    public boolean y() {
        return this.l.m();
    }

    public int z() {
        return this.d.a().g;
    }

    public void A() {
        this.l.c();
    }

    public void a(String str, String str2, int i2) {
        if (i2 <= 0 || i2 >= 65536 || str == null || com.subao.common.j.f.a(str2) == null) {
            Log.w("SubaoGame", "Incorrect arguments of addAccelAddress()");
        } else {
            this.l.a(str, str2, i2);
        }
    }

    public void B() {
        this.l.i();
    }

    public String l(int i2) {
        return this.l.d(i2);
    }

    public void a(int i2, boolean z) {
        this.l.a(i2, z);
    }

    public void c(String str, String str2) {
        this.l.b(0, "key_set_round_openid", str);
        this.l.b(0, "key_set_round_pvpid", str2);
    }

    public void b(String str) {
        this.l.b(0, "key_pay_type_white_list", str);
    }

    public void e(boolean z) {
        UserInfo userInfo = this.u;
        a(z, userInfo == null ? null : userInfo.getUserId());
    }

    void a(boolean z, String str) {
        this.l.a(0, "key_user_wifi_accel", z ? 1 : 0);
        boolean z2 = !TextUtils.isEmpty(str);
        if (z2) {
            com.subao.common.b.b.a(new a(this.d, this.f, this.b), 0, str, z);
        }
        if (d.a.d()) {
            HashMap hashMap = new HashMap(2);
            if (!z2) {
                str = "(none)";
            }
            hashMap.put("userId", str);
            hashMap.put("switch", z ? "on" : "off");
            this.f.a(new n.a("set_wa_switch", hashMap));
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public synchronized int C() {
        int i2;
        boolean a2 = com.subao.common.d.a("SubaoGame");
        i2 = 0;
        if (Build.VERSION.SDK_INT < 14) {
            i2 = ConnectionsStatusCodes.STATUS_BLUETOOTH_ERROR;
        } else {
            e.a aVar = this.B;
            if (aVar == null) {
                i2 = ConnectionsStatusCodes.STATUS_ENDPOINT_UNKNOWN;
            } else {
                com.subao.common.a.e a3 = aVar.a();
                if (a3 != null) {
                    if (a2) {
                        Log.d("SubaoGame", "Service already exists, call startProxy() ...");
                    }
                    aq c = c(false);
                    i2 = a3.a(c == null ? null : c.a((aq.a) new aq.c(), false));
                } else if (!aVar.a(this.h)) {
                    i2 = ConnectionsStatusCodes.STATUS_ALREADY_HAVE_ACTIVE_STRATEGY;
                }
            }
        }
        if (a2) {
            Log.d("SubaoGame", "openVPN() return " + i2);
        }
        return i2;
    }

    private com.subao.common.a.e M() {
        e.a aVar = this.B;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public synchronized void D() {
        com.subao.common.a.e M = M();
        if (M != null) {
            M.a();
        }
    }

    public boolean E() {
        com.subao.common.a.e M = M();
        return M != null && M.b();
    }

    public void a(int i2, long j2, NodeDetectCallback nodeDetectCallback, Object obj) {
        this.l.e(i2);
        if (nodeDetectCallback != null) {
            k.a(this, i2, j2, nodeDetectCallback, obj);
        }
    }

    public String F() {
        return com.subao.common.j.e.c();
    }

    public int G() {
        return this.l.p();
    }

    public boolean m(int i2) {
        return this.l.f(i2);
    }

    public static String H() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        Log.d("SubaoGame", "getXunyouUserID: " + replace);
        return replace;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class r extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private com.subao.common.g.c f5890a;
        private volatile boolean b;

        r(com.subao.common.g.c cVar) {
            this.f5890a = cVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.b) {
                this.f5890a.g();
            }
            this.f5890a = null;
        }

        void a() {
            this.b = true;
        }
    }

    public String I() {
        return String.format("%d,%s", Integer.valueOf(this.l.q()), w());
    }

    public void a(int i2, String str, String str2, String str3) {
        an h2 = this.m.h();
        if (h2 == null) {
            h2 = com.subao.common.e.f.a(f.g.HR);
        }
        com.subao.a.a.a(i2, h2, str, str2, str3, this.l);
    }

    public void a(int i2, int i3, String str, String str2, int i4, int i5) {
        com.subao.a.a.a(i2, this.h, i3, str, str2, i4, this.l, i5);
    }

    public void a(int i2, int i3) {
        com.subao.a.a.a(i2, this.l, i3);
    }

    public void a(int i2, String str, int i3, String str2, int i4, int i5) {
        com.subao.a.a.a(i2, str, i3, str2, i4, i5);
    }

    public void b(int i2, int i3) {
        com.subao.a.a.b(i2, this.l, i3);
    }

    public void J() {
        com.subao.a.a.c();
    }

    public void n(int i2) {
        com.subao.a.a.a(i2, this.l);
    }

    public void o(int i2) {
        com.subao.a.a.a(i2);
    }

    public void p(int i2) {
        com.subao.a.a.b(i2);
    }

    public void b(String str, String str2, int i2) {
        this.l.b(str, str2, i2);
    }

    public void c(String str, String str2, int i2) {
        if (i2 <= 0 || i2 >= 65536 || str == null || com.subao.common.j.f.a(str2) == null) {
            Log.w("SubaoGame", "Incorrect arguments of addNewArenaAddress()");
        } else {
            this.l.c(str, str2, i2);
        }
    }

    public void q(int i2) {
        this.l.i(i2);
    }

    public Boolean b(String str, int i2) {
        return Boolean.valueOf(this.l.b(str, i2));
    }

    public void c(String str) {
        this.l.c(str);
    }

    public void d(String str) {
        this.l.d(str);
    }

    public void e(String str) {
        this.l.e(str);
    }

    /* loaded from: classes2.dex */
    private static class i implements f.b {

        /* renamed from: a, reason: collision with root package name */
        private final File f5880a = new File(com.subao.common.f.a.a(), "links");

        i() {
            if (this.f5880a.exists() && this.f5880a.isDirectory()) {
                return;
            }
            this.f5880a.mkdirs();
        }

        @Override // com.subao.common.i.f.b
        public RandomAccessFile a(String str, boolean z) {
            return new RandomAccessFile(new File(this.f5880a, str), z ? AnalyticsEventKey.SMART_INTENT_SEARCH_RANK : "rw");
        }

        @Override // com.subao.common.i.f.b
        public String[] a() {
            return this.f5880a.list();
        }

        @Override // com.subao.common.i.f.b
        public void a(String str) {
            File file = new File(this.f5880a, str);
            if (file.delete()) {
                return;
            }
            Log.w("SubaoGame", "Delete File Failed: " + file.getAbsolutePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Context f5884a;
        private final com.subao.common.a.a b;
        private final com.subao.common.i.g c;
        private final com.subao.common.i.i d;
        private final int e;
        private final AccelSwitchListener f;

        private l(Context context, com.subao.common.a.a aVar, com.subao.common.i.g gVar, com.subao.common.i.i iVar, int i, AccelSwitchListener accelSwitchListener) {
            this.f5884a = context;
            this.b = aVar;
            this.c = gVar;
            this.d = iVar;
            this.e = i;
            this.f = accelSwitchListener;
        }

        static void a(Context context, com.subao.common.a.a aVar, com.subao.common.i.g gVar, com.subao.common.i.i iVar, int i, AccelSwitchListener accelSwitchListener) {
            l lVar = new l(context, aVar, gVar, iVar, i, accelSwitchListener);
            if (com.subao.common.n.i.b()) {
                lVar.run();
            } else {
                com.subao.common.m.b.a().a(lVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AccelSwitchListener accelSwitchListener = this.f;
            if (accelSwitchListener != null) {
                accelSwitchListener.onAccelSwitch(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final AccelSwitchListener f5885a;

        m(AccelSwitchListener accelSwitchListener) {
            this.f5885a = accelSwitchListener;
        }

        static void a(AccelSwitchListener accelSwitchListener) {
            m mVar = new m(accelSwitchListener);
            if (com.subao.common.n.i.b()) {
                mVar.run();
            } else {
                com.subao.common.m.b.a().a(mVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AccelSwitchListener accelSwitchListener = this.f5885a;
            if (accelSwitchListener != null) {
                accelSwitchListener.onAccelSwitch(false);
            }
            s.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class s {

        /* renamed from: a, reason: collision with root package name */
        private static a f5891a;

        static void a() {
            com.subao.common.m.b.a().a(f5891a, 600000L);
        }

        static void b() {
            if (f5891a != null) {
                com.subao.common.m.b.a().b(f5891a);
                f5891a = null;
            }
        }

        static boolean c() {
            return com.subao.common.n.c.a() == com.subao.common.e.l.a().c();
        }

        static void a(com.subao.common.i.g gVar, int i) {
            gVar.a(i, 0, (List<com.subao.common.i.l>) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final com.subao.common.a.a f5892a;
            private final com.subao.common.i.g b;
            private final int c;

            @Override // java.lang.Runnable
            public void run() {
                if (this.f5892a.c() && ao.a(com.subao.common.i.k.b()) && !s.c()) {
                    s.a(this.b, this.c);
                }
                s.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class o extends ad.a {
        o(String str, String str2, an anVar, boolean z, com.subao.common.j.l lVar) {
            super(str, str2, anVar, z, lVar);
        }

        @Override // com.subao.common.e.ad.a
        public com.subao.common.f.c a(String str) {
            return com.subao.common.f.d.a(com.subao.common.f.a.a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class j implements j.a {
        private j() {
        }

        @Override // com.subao.common.j.j.a
        public void a(l.a aVar) {
            if (aVar == l.a.UNKNOWN) {
                aVar = l.a.MOBILE_4G;
            }
            com.subao.common.j.e.a();
            c.this.l.a(0, "key_net_state", aVar.g);
            switch (aVar) {
                case WIFI:
                    c cVar = c.this;
                    cVar.a(cVar.h, c.this.l);
                    break;
                case MOBILE_3G:
                case MOBILE_4G:
                    com.subao.common.j.m.b(null, new m.a() { // from class: com.subao.common.a.c.j.1
                        @Override // com.subao.common.j.m.a
                        public void a(byte[] bArr) {
                            c.this.l.b(0, "key_mobile_private_ip", com.subao.common.j.f.a(bArr));
                        }
                    });
                    break;
            }
            if (aVar == l.a.MOBILE_4G) {
                com.subao.common.l.c.a().f();
            } else {
                com.subao.common.l.c.a().e();
            }
            e eVar = c.this.o;
            if (eVar != null) {
                eVar.b(aVar);
            }
        }
    }

    void a(Context context, final com.subao.common.g.c cVar) {
        com.subao.common.j.m.a(context, new m.b() { // from class: com.subao.common.a.c.3
            @Override // com.subao.common.j.m.b
            public void a(m.f fVar) {
                cVar.b(0, "key_wifi_ip", fVar.a());
                cVar.a(0, "key_main_wifi_frequency", fVar.b());
            }
        });
    }

    /* loaded from: classes2.dex */
    public static class a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        private final com.subao.common.j.l f5872a;
        private final com.subao.common.i.g b;
        private final String c;

        public a(com.subao.common.j.l lVar, com.subao.common.i.g gVar, String str) {
            if (lVar == null) {
                throw new NullPointerException("NetTypeDetector cannot be null");
            }
            if (gVar == null) {
                throw new NullPointerException("MessageSender cannot be null");
            }
            this.f5872a = lVar;
            this.b = gVar;
            this.c = str;
        }

        @Override // com.subao.common.b.b.c
        public boolean a() {
            return this.f5872a.b();
        }

        @Override // com.subao.common.b.b.c
        public d.b b() {
            return new d.b() { // from class: com.subao.common.a.c.a.1
                @Override // com.subao.common.i.d.b
                public void a(String str, String str2) {
                    if (d.a.b()) {
                        a.this.b.a(str, str2);
                    }
                }
            };
        }

        @Override // com.subao.common.b.b.c
        public String c() {
            return this.c;
        }
    }

    /* loaded from: classes2.dex */
    static class n extends com.subao.common.j.p {

        /* renamed from: a, reason: collision with root package name */
        private int f5886a;
        private final String b;
        private final int c;
        private final String f;

        @Override // com.subao.common.j.p
        protected String a() {
            return null;
        }

        public n(d.b bVar, int i, String str, int i2, String str2) {
            super(bVar, i, 0);
            this.b = str;
            this.c = i2;
            this.f = str2;
        }

        @Override // com.subao.common.j.p
        protected void a(int i, byte[] bArr) {
            b(i);
        }

        @Override // com.subao.common.j.p
        protected void b(int i, byte[] bArr) {
            e();
            b(i);
        }

        private void b(int i) {
            com.subao.common.d.a("SubaoNet", "OrdersResponseCallbackRetry code: " + i);
        }

        private void e() {
            if (this.f5886a < 5) {
                com.subao.common.m.b.a().a(new Runnable() { // from class: com.subao.common.a.c.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.subao.common.b.b.a(n.this.b, n.this.c, n.this.f, n.this);
                    }
                }, Math.round(Math.pow(2.0d, this.f5886a) * 5000.0d));
                this.f5886a++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class h {
        static int a(c cVar) {
            if (cVar.h()) {
                return 1;
            }
            return cVar.m.b() ? -1 : 0;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.subao.common.a.c$h$1] */
        static void a(com.subao.common.g.a aVar) {
            if (aVar == com.subao.common.g.a.VPN) {
                new Thread("JNI-ProxyLoop") { // from class: com.subao.common.a.c.h.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        VPNJni.proxyLoop(0, false);
                    }
                }.start();
            } else {
                VPNJni.proxyLoop(0, true);
            }
        }

        static void a(Context context, com.subao.common.g.c cVar, r.a aVar) {
            z zVar = new z();
            if (zVar.a(context, aVar)) {
                cVar.a(0, "key_inject", zVar.b());
            }
        }

        static void a(com.subao.common.g.c cVar, int i) {
            if (i >= 0) {
                cVar.a(i);
            }
        }

        static void a(Context context, com.subao.common.g.c cVar, com.subao.common.j.n nVar, String str) {
            cVar.b(0, "key_hook_module", str);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String a2 = com.subao.common.n.e.a(context, applicationInfo);
            int i = applicationInfo.uid;
            String packageName = context.getPackageName();
            if (a2 == null) {
                a2 = "";
            }
            cVar.a(i, packageName, a2, nVar, 0);
        }

        static r a(com.subao.common.g.c cVar) {
            r rVar = new r(cVar);
            rVar.start();
            return rVar;
        }

        static void b(com.subao.common.g.c cVar) {
            String str;
            String b = com.subao.common.k.d.b();
            if ("vivo".equals(b)) {
                str = "v";
            } else if ("oppo".equals(b)) {
                str = "o";
            } else if (!"miui".equals(b)) {
                return;
            } else {
                str = "m";
            }
            cVar.b(0, "key_dual_wifi", str);
            if (com.subao.common.k.d.c()) {
                cVar.a(0, "key_dual_wifi_state_change", 1);
            }
        }

        static void c(com.subao.common.g.c cVar) {
            if (com.subao.common.k.d.a()) {
                com.subao.common.k.d.a(new a(cVar));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class a implements d.b {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<com.subao.common.g.c> f5879a;

            private a(com.subao.common.g.c cVar) {
                this.f5879a = new WeakReference<>(cVar);
            }

            private void a(int i) {
                com.subao.common.g.c cVar = this.f5879a.get();
                if (cVar != null) {
                    cVar.a(0, "key_dual_wifi_state_change", i);
                } else {
                    com.subao.common.k.d.b(this);
                }
            }

            @Override // com.subao.common.k.d.b
            public void a(Object obj) {
                a(1);
            }

            @Override // com.subao.common.k.d.b
            public void b(Object obj) {
                a(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static abstract class w<C> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final long f5895a;
        private c b;
        private C c;
        private Object d;

        abstract void a(C c, Object obj, boolean z);

        abstract boolean a(c cVar);

        w(c cVar, long j, C c, Object obj) {
            this.b = cVar;
            this.f5895a = Math.max(1000L, j);
            this.c = c;
            this.d = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            long K = c.K() + this.f5895a;
            while (true) {
                SystemClock.sleep(500L);
                if (a(this.b)) {
                    z = false;
                    break;
                } else if (c.K() >= K) {
                    z = true;
                    break;
                }
            }
            a(this.c, this.d, z);
            a();
        }

        private void a() {
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class k extends w<NodeDetectCallback> {

        /* renamed from: a, reason: collision with root package name */
        private final int f5883a;
        private boolean b;

        static void a(c cVar, int i, long j, NodeDetectCallback nodeDetectCallback, Object obj) {
            com.subao.common.m.d.a().execute(new k(cVar, i, j, nodeDetectCallback, obj));
        }

        private k(c cVar, int i, long j, NodeDetectCallback nodeDetectCallback, Object obj) {
            super(cVar, j, nodeDetectCallback, obj);
            this.f5883a = i;
        }

        @Override // com.subao.common.a.c.w
        boolean a(c cVar) {
            boolean m = cVar.m(this.f5883a);
            this.b = m;
            return m;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.subao.common.a.c.w
        public void a(NodeDetectCallback nodeDetectCallback, Object obj, boolean z) {
            nodeDetectCallback.onNodeDetectComplete(this.f5883a, this.b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class x<C> extends w<C> {

        /* renamed from: a, reason: collision with root package name */
        private final String f5896a;
        private final int b;
        private final String c;
        private int d;
        private String e;
        private int f;

        x(c cVar, long j, C c, Object obj, String str, int i, String str2) {
            super(cVar, j, c, obj);
            this.f5896a = str;
            this.b = i;
            this.c = str2;
            this.d = i;
            this.e = str2;
        }

        @Override // com.subao.common.a.c.w
        boolean a(c cVar) {
            this.d = cVar.x();
            this.e = cVar.w();
            if (this.d != this.b) {
                this.f |= 1;
            }
            if (!com.subao.common.n.h.a(this.e, this.c)) {
                this.f |= 2;
            }
            return this.f == 3;
        }

        protected String a() {
            return this.f5896a;
        }

        int b() {
            return this.d;
        }

        String c() {
            return this.e;
        }

        boolean d() {
            return (this.f & 1) != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class u extends x<UserAuthCallback> {
        static void a(c cVar, long j, UserAuthCallback userAuthCallback, Object obj, String str, int i, String str2) {
            com.subao.common.m.d.a().execute(new u(cVar, j, userAuthCallback, obj, str, i, str2));
        }

        private u(c cVar, long j, UserAuthCallback userAuthCallback, Object obj, String str, int i, String str2) {
            super(cVar, j, userAuthCallback, obj, str, i, str2);
        }

        @Override // com.subao.common.a.c.x, com.subao.common.a.c.w
        boolean a(c cVar) {
            super.a(cVar);
            return d();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.subao.common.a.c.w
        public void a(UserAuthCallback userAuthCallback, Object obj, boolean z) {
            userAuthCallback.onUserAuthResult(a(), b(), c(), z, obj);
        }
    }

    /* loaded from: classes2.dex */
    static class v implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final VPNStateListener f5894a;
        private final boolean b;

        v(VPNStateListener vPNStateListener, boolean z) {
            this.f5894a = vPNStateListener;
            this.b = z;
        }

        static void a(VPNStateListener vPNStateListener, boolean z) {
            if (vPNStateListener == null) {
                return;
            }
            if (com.subao.common.n.i.b()) {
                vPNStateListener.onVPNStateChanged(z);
            } else {
                com.subao.common.m.b.a().a(new v(vPNStateListener, z));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5894a.onVPNStateChanged(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class y implements XunyouUserStateCallback {

        /* renamed from: a, reason: collision with root package name */
        private final XunyouUserStateCallback f5897a;

        y(XunyouUserStateCallback xunyouUserStateCallback) {
            this.f5897a = xunyouUserStateCallback;
        }

        @Override // com.subao.common.intf.XunyouUserStateCallback
        public void onXunyouUserState(UserInfo userInfo, Object obj, int i, int i2, String str) {
            if (com.subao.common.d.a("SubaoAuth")) {
                com.subao.common.d.a("SubaoAuth", String.format(com.subao.common.e.r.f6001a, "onXunyouUserState(%s): error=%d, userState=%d, vipTime=%s", userInfo, Integer.valueOf(i), Integer.valueOf(i2), str));
            }
            XunyouUserStateCallback xunyouUserStateCallback = this.f5897a;
            if (xunyouUserStateCallback != null) {
                xunyouUserStateCallback.onXunyouUserState(userInfo, obj, i, i2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements e.a {
        private final com.subao.common.m.a b;

        f(com.subao.common.m.a aVar) {
            this.b = aVar;
        }

        @Override // com.subao.common.m.a
        public boolean a(Runnable runnable) {
            return this.b.a(runnable);
        }

        @Override // com.subao.common.m.a
        public boolean a(Runnable runnable, long j) {
            return this.b.a(runnable, j);
        }

        @Override // com.subao.common.m.a
        public void b(Runnable runnable) {
            this.b.b(runnable);
        }

        @Override // com.subao.common.a.c.e.a
        public l.a a() {
            return c.this.d.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.g().b(c.this.h, c.this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private final a f5875a;
        private final long b;
        private final b c;
        private final boolean d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface a extends com.subao.common.m.a, Runnable {
            l.a a();
        }

        private e(a aVar, long j) {
            this.f5875a = aVar;
            this.b = j <= 0 ? 18000000L : j;
            this.c = new b();
            this.d = a(aVar.a());
        }

        static e a(a aVar, long j) {
            e eVar = new e(aVar, j);
            eVar.f5875a.a(eVar.c, eVar.b);
            return eVar;
        }

        static boolean a(l.a aVar) {
            switch (aVar) {
                case WIFI:
                case MOBILE_3G:
                case MOBILE_4G:
                case UNKNOWN:
                    return true;
                default:
                    return false;
            }
        }

        static long a() {
            return ad.g();
        }

        void b(l.a aVar) {
            if (this.d || !a(aVar)) {
                return;
            }
            this.f5875a.b(this.c);
            this.f5875a.a(this.c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class b implements Runnable {
            private long b = e.a() - 18000000;

            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean a2 = com.subao.common.d.a("SubaoData");
                if (a2) {
                    Log.d("SubaoData", "[DataAutoRefresher] run");
                }
                long a3 = e.a();
                long j = a3 - this.b;
                if (j < e.this.b) {
                    if (a2) {
                        Log.d("SubaoData", "[DataAutoRefresher] Elapsed from last execute: " + j);
                    }
                    e.this.f5875a.a(this, e.this.b - j);
                    return;
                }
                if (!e.a(e.this.f5875a.a())) {
                    if (a2) {
                        Log.d("SubaoData", "[DataAutoRefresher] Network is bad");
                    }
                    e.this.f5875a.a(this, e.this.b);
                    return;
                }
                long h = a3 - ad.h();
                if (h < e.this.b) {
                    if (a2) {
                        Log.d("SubaoData", "[DataAutoRefresher] Elapsed from last download: " + h);
                    }
                    e.this.f5875a.a(this, e.this.b - h);
                    return;
                }
                if (a2) {
                    Log.d("SubaoData", "[DataAutoRefresher] do it !!");
                }
                this.b = a3;
                e.this.f5875a.run();
                e.this.f5875a.a(this, e.this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class q implements e.a {

        /* renamed from: a, reason: collision with root package name */
        private final QueryProductCallback f5889a;
        private final an b;
        private final com.subao.common.e.i<an, ProductList> c;

        q(QueryProductCallback queryProductCallback, an anVar, com.subao.common.e.i<an, ProductList> iVar) {
            this.f5889a = queryProductCallback;
            this.b = anVar;
            this.c = iVar;
        }

        @Override // com.subao.common.c.e.a
        public void a(int i, ProductList productList) {
            int i2 = 0;
            if (com.subao.common.d.a("SubaoData")) {
                Locale locale = com.subao.common.e.r.f6001a;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(productList == null ? 0 : productList.getCount());
                Log.d("SubaoData", String.format(locale, "QueryProductList result, responseCode is %d, product count is %d", objArr));
            }
            if (i == -1) {
                i2 = 1006;
            } else if (i != 200) {
                i2 = 1008;
            }
            this.c.a(this.b, i2 == 0 ? productList : null);
            this.f5889a.onQueryProductResult(i2, productList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.subao.common.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0161c implements b {
        @Override // com.subao.common.a.c.b
        public void a(String str, byte[] bArr, XunyouTokenStateListener xunyouTokenStateListener) {
        }

        @Override // com.subao.common.a.c.b
        public byte[] a() {
            return null;
        }

        private C0161c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements b {
        private d() {
        }

        @Override // com.subao.common.a.c.b
        public void a(String str, byte[] bArr, XunyouTokenStateListener xunyouTokenStateListener) {
            if (com.subao.common.d.a("SubaoGame")) {
                Log.d("SubaoGame", String.format("setUserToken_FromOtherAppCaller, userId = %s", str));
            }
            if (bArr == null || bArr.length == 0) {
                if (com.subao.common.d.a("SubaoGame")) {
                    Log.d("SubaoGame", "setUserToken_FromOtherAppCaller, jwtToken is null");
                }
            } else {
                com.subao.common.b.b.a(bArr);
                com.subao.common.b.b.a(xunyouTokenStateListener);
                c.this.l.a(50, str, "DummyToken", "WiFiKey");
            }
        }

        @Override // com.subao.common.a.c.b
        public byte[] a() {
            return com.subao.common.b.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class g implements u.a {

        /* renamed from: a, reason: collision with root package name */
        private final QuerySignCouponsCallback f5878a;

        g(QuerySignCouponsCallback querySignCouponsCallback) {
            this.f5878a = querySignCouponsCallback;
        }

        private static void a(List<String> list, String str) {
            if (list.indexOf(str) < 0) {
                list.add(str);
            }
        }

        @Override // com.subao.common.e.u.a
        public void a(int i, List<com.subao.common.e.n> list) {
            if (i != 0) {
                this.f5878a.onQuerySignCouponsResult(i, null);
                return;
            }
            ArrayList arrayList = new ArrayList(3);
            if (list != null && !list.isEmpty()) {
                Iterator<com.subao.common.e.n> it = list.iterator();
                while (it.hasNext()) {
                    String a2 = it.next().a("xiaomi");
                    if (a2 != null) {
                        char c = 65535;
                        int hashCode = a2.hashCode();
                        if (hashCode != -948167249) {
                            if (hashCode != -647590143) {
                                if (hashCode == 1447980040 && a2.equals("dayfree")) {
                                    c = 0;
                                }
                            } else if (a2.equals("threeDaysfree")) {
                                c = 2;
                            }
                        } else if (a2.equals("twoDaysfree")) {
                            c = 1;
                        }
                        switch (c) {
                            case 0:
                                a(arrayList, "1");
                                break;
                            case 1:
                                a(arrayList, "2");
                                break;
                            case 2:
                                a(arrayList, "3");
                                break;
                        }
                    }
                }
            }
            this.f5878a.onQuerySignCouponsResult(i, arrayList);
        }
    }

    /* loaded from: classes2.dex */
    private static class p implements ah.a {

        /* renamed from: a, reason: collision with root package name */
        private final com.subao.common.g.c f5888a;

        p(com.subao.common.g.c cVar) {
            this.f5888a = cVar;
        }

        @Override // com.subao.common.e.ah.a
        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f5888a.b(0, r.b.f6003a, str);
        }

        @Override // com.subao.common.e.ah.a
        public void a(ah.b bVar) {
            String a2 = bVar.a("steam_proxy");
            if (a2 != null) {
                this.f5888a.b(0, "key_http_proxy_node", a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class t {
        static void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Matcher matcher = Pattern.compile("(?:https?://)?([^:/]+)").matcher(str);
            if (!matcher.find() || matcher.groupCount() < 1) {
                return;
            }
            String group = matcher.group(1);
            if (TextUtils.isEmpty(group)) {
                return;
            }
            com.subao.common.m.d.a(new a(group));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final String f5893a;

            private a(String str) {
                this.f5893a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(this.f5893a);
                    if (allByName == null || !com.subao.common.d.a("SubaoGame")) {
                        return;
                    }
                    for (InetAddress inetAddress : allByName) {
                        Log.d("SubaoGame", inetAddress.toString());
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
