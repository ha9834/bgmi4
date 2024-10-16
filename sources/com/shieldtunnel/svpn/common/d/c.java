package com.shieldtunnel.svpn.common.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.net.VpnService;
import android.os.Build;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.google.android.gms.nearby.messages.BleSignal;
import com.shieldtunnel.svpn.Jni;
import com.shieldtunnel.svpn.XYVpnService;
import com.shieldtunnel.svpn.common.ErrorCode;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.d.a;
import com.shieldtunnel.svpn.common.d.e;
import com.shieldtunnel.svpn.common.f.k;
import com.shieldtunnel.svpn.common.f.p;
import com.shieldtunnel.svpn.common.f.q;
import com.shieldtunnel.svpn.common.i.g;
import com.shieldtunnel.svpn.common.i.h;
import com.shieldtunnel.svpn.common.i.i;
import com.shieldtunnel.svpn.common.intf.NetDelay;
import com.shieldtunnel.svpn.common.intf.NodeDetectCallback;
import com.shieldtunnel.svpn.common.intf.NodeInfo;
import com.shieldtunnel.svpn.common.intf.NodeState;
import com.shieldtunnel.svpn.common.intf.TunnelEventListener;
import com.shieldtunnel.svpn.common.intf.UserInfo;
import com.shieldtunnel.svpn.common.intf.VPNStateListener;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class c implements com.shieldtunnel.svpn.common.d.a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f5781a;
    private final com.shieldtunnel.svpn.common.h.d b;
    private final com.shieldtunnel.svpn.common.jni.b c;
    private final String d;
    private final com.shieldtunnel.svpn.common.f.d e;
    private final com.shieldtunnel.svpn.common.i.g f;
    private final p g;
    private final com.shieldtunnel.svpn.common.f.a h;
    private volatile m i;
    private final com.shieldtunnel.svpn.common.h.c j;
    private UserInfo k;
    private TunnelEventListener m;
    private o n;
    private final n p;
    private C0149c r;
    private f l = new f(null, a.EnumC0148a.REGION);
    private com.shieldtunnel.svpn.common.d.e o = new com.shieldtunnel.svpn.common.d.h();
    private final com.shieldtunnel.svpn.common.e.a<NodeDetectCallback> q = new com.shieldtunnel.svpn.common.e.a<>(4);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5782a;
        final /* synthetic */ byte[] b;

        a(int i, byte[] bArr) {
            this.f5782a = i;
            this.b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.f5782a) {
                case 0:
                    c.this.o.a(com.shieldtunnel.svpn.common.k.e.a(this.b));
                    return;
                case 1:
                    c.this.o.a(com.shieldtunnel.svpn.common.k.e.a(com.shieldtunnel.svpn.common.k.e.a(this.b), BleSignal.UNKNOWN_TX_POWER));
                    return;
                case 2:
                    c.this.o.c();
                    return;
                case 3:
                case 4:
                case 6:
                    c.this.o.a(this.f5782a, this.b);
                    return;
                case 5:
                    c cVar = c.this;
                    cVar.a(cVar.l.a(), c.this.l.b());
                    return;
                case 7:
                    c.this.a(TunnelEventListener.Event.NODE_LIST_UPDATE, 0);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5783a;

        static {
            int[] iArr = new int[h.a.values().length];
            f5783a = iArr;
            try {
                iArr[h.a.MOBILE_3G.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5783a[h.a.MOBILE_4G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Context f5785a;
        private final com.shieldtunnel.svpn.common.jni.b b;

        e(Context context, com.shieldtunnel.svpn.common.jni.b bVar) {
            this.f5785a = context.getApplicationContext();
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<ApplicationInfo> installedApplications = this.f5785a.getPackageManager().getInstalledApplications(0);
            StringBuilder sb = new StringBuilder(installedApplications.size() * 64);
            for (ApplicationInfo applicationInfo : installedApplications) {
                sb.append(String.format(com.shieldtunnel.svpn.common.f.f.b, "%d:%s,", Integer.valueOf(applicationInfo.uid), applicationInfo.packageName));
            }
            this.b.a(0, "key_app_list", sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private String f5786a;
        private a.EnumC0148a b;

        f(String str, a.EnumC0148a enumC0148a) {
            this.f5786a = str;
            this.b = enumC0148a;
        }

        String a() {
            return this.f5786a;
        }

        a.EnumC0148a b() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g implements g.a {

        /* loaded from: classes2.dex */
        class a implements i.c {
            a() {
            }

            @Override // com.shieldtunnel.svpn.common.i.i.c
            public void a(byte[] bArr) {
                c.this.c.a(0, "key_mobile_private_ip", com.shieldtunnel.svpn.common.i.c.a(bArr));
            }
        }

        private g() {
        }

        @Override // com.shieldtunnel.svpn.common.i.g.a
        public void a(Context context, h.a aVar) {
            if (aVar == h.a.UNKNOWN) {
                aVar = h.a.MOBILE_4G;
            }
            c.this.c.a(0, "key_net_state", aVar.f5851a);
            int i = b.f5783a[aVar.ordinal()];
            if (i == 1 || i == 2) {
                com.shieldtunnel.svpn.common.i.i.a((i.d) null, new a());
            }
            if (aVar != h.a.DISCONNECT) {
                com.shieldtunnel.svpn.common.i.d.a(context, aVar, c.this.c);
            }
        }

        /* synthetic */ g(c cVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private static class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final NodeDetectCallback f5789a;
        private final int b;
        private final List<NodeState> c;

        /* synthetic */ h(NodeDetectCallback nodeDetectCallback, int i, List list, a aVar) {
            this(nodeDetectCallback, i, list);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5789a.onNodeDetectResult(this.b, this.c);
        }

        private h(NodeDetectCallback nodeDetectCallback, int i, List<NodeState> list) {
            this.f5789a = nodeDetectCallback;
            this.b = i;
            this.c = list;
        }
    }

    /* loaded from: classes2.dex */
    private static class k extends k.b {
        k(String str, String str2, q qVar, com.shieldtunnel.svpn.common.i.h hVar) {
            super(str, str2, qVar, hVar);
        }

        @Override // com.shieldtunnel.svpn.common.f.k.b
        public com.shieldtunnel.svpn.common.g.b a(String str) {
            return com.shieldtunnel.svpn.common.g.c.a(com.shieldtunnel.svpn.common.g.a.a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class l extends Thread {
        l() {
            super("JNI-ProxyLoop");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Jni.proxyLoop(0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class m extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private com.shieldtunnel.svpn.common.jni.b f5791a;
        private volatile boolean b;

        m(com.shieldtunnel.svpn.common.jni.b bVar) {
            this.f5791a = bVar;
        }

        void a() {
            this.b = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.b) {
                this.f5791a.b();
            }
            this.f5791a = null;
            Log.d(LogTag.MAIN, "ProxyLooper exit.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class n implements e.a {
        private n() {
        }

        @Override // com.shieldtunnel.svpn.common.d.e.a
        public void a(com.shieldtunnel.svpn.common.d.e eVar) {
            c.this.a(eVar);
        }

        /* synthetic */ n(c cVar, a aVar) {
            this();
        }

        @Override // com.shieldtunnel.svpn.common.d.e.a
        public void a(TunnelEventListener.Event event, int i, byte[] bArr) {
            c.this.a(event, i, bArr);
        }

        @Override // com.shieldtunnel.svpn.common.d.e.a
        public void a(boolean z) {
            c.this.a(z);
        }

        @Override // com.shieldtunnel.svpn.common.d.e.a
        public void a(int i) {
            c.this.c.a(i);
        }
    }

    /* loaded from: classes2.dex */
    private class o implements VPNStateListener {

        /* renamed from: a, reason: collision with root package name */
        private volatile VPNStateListener f5793a;

        private o() {
        }

        @Override // com.shieldtunnel.svpn.common.intf.VPNStateListener
        public void onVPNStateChanged(boolean z, boolean z2) {
            if (!z && z2) {
                c.this.a();
            }
            VPNStateListener vPNStateListener = this.f5793a;
            if (vPNStateListener != null) {
                vPNStateListener.onVPNStateChanged(z, z2);
            }
        }

        /* synthetic */ o(c cVar, a aVar) {
            this();
        }
    }

    public c(Context context, String str, String str2, String str3, com.shieldtunnel.svpn.common.f.d dVar, com.shieldtunnel.svpn.common.jni.b bVar, p pVar) {
        a aVar = null;
        this.n = new o(this, aVar);
        this.f5781a = context.getApplicationContext();
        this.d = str;
        this.e = dVar;
        this.b = new com.shieldtunnel.svpn.common.h.d(str3, str);
        this.c = bVar;
        this.f = com.shieldtunnel.svpn.common.i.g.a(this.f5781a);
        this.g = pVar == null ? new p() : pVar;
        com.shieldtunnel.svpn.common.f.c.a(str2);
        com.shieldtunnel.svpn.common.g.a.a(context);
        if (pVar == null) {
            this.g.b(context);
        }
        this.h = new com.shieldtunnel.svpn.common.f.a(new k(str, str3, this.g.g(), this.f), bVar);
        this.j = new com.shieldtunnel.svpn.common.h.c(dVar, new com.shieldtunnel.svpn.common.h.d(str3, str), this.g.f());
        com.shieldtunnel.svpn.common.jni.b bVar2 = this.c;
        bVar2.a(new com.shieldtunnel.svpn.common.d.d(this, bVar2));
        XYVpnService.a(this.n);
        this.p = new n(this, aVar);
    }

    private static boolean h() {
        return a(com.shieldtunnel.svpn.common.k.d.b()) && a(com.shieldtunnel.svpn.common.k.d.a());
    }

    private void i() {
        if (this.r == null) {
            C0149c c0149c = new C0149c(this.c);
            this.r = c0149c;
            c0149c.a(this.f5781a);
        }
    }

    private void j() {
        C0149c c0149c = this.r;
        if (c0149c != null) {
            c0149c.a();
            this.r = null;
        }
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int d() {
        return 1002;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int e() {
        return this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.f5781a;
    }

    public int g() {
        if (this.i == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return 1014;
            }
            if (!h()) {
                return 1003;
            }
            if (!XYVpnService.a(this.f5781a, this.d)) {
                return 1015;
            }
            this.h.a(this.g.c());
            this.h.a(a(this.g.d(), 600000L), a(this.g.e(), 10800000L));
            int a2 = this.c.a(this.d, this.e, this.h.a(this.c.a()), this.h.a());
            if (a2 != 0) {
                Log.w(LogTag.MAIN, String.format(com.shieldtunnel.svpn.common.f.f.b, "Engine.JNI initialize return: %d", Integer.valueOf(a2)));
                return 1001;
            }
            new l().start();
            this.c.a(0, "key_android_version_sdk_int", Build.VERSION.SDK_INT);
            d.a(this.c, this.g);
            d.a(this.f5781a, this.c);
            this.c.a(0, "key_current_app_package_name", this.f5781a.getPackageName());
            this.h.c();
            this.i = d.a(this.c);
            this.c.a(this.b);
            this.f.a(new g(this, null));
            com.shieldtunnel.svpn.common.i.d.a(this.f5781a, this.f.b(), this.c);
            if (Build.VERSION.SDK_INT < 29) {
                com.shieldtunnel.svpn.common.j.c.a(new e(this.f5781a, this.c));
            }
            i();
            return 0;
        }
        throw new AssertionError("ProxyLooper is not null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d {
        static void a(com.shieldtunnel.svpn.common.jni.b bVar, p pVar) {
            a(bVar, pVar.f(), "C.DroneConfig");
            a(bVar, pVar.g(), "C.PortalConfig");
        }

        private static void a(com.shieldtunnel.svpn.common.jni.b bVar, q qVar, String str) {
            if (qVar != null) {
                bVar.a(str + ".Scheme", qVar.f5827a);
                bVar.a(str + ".Host", qVar.b);
                int i = qVar.c;
                if (i <= 0) {
                    i = "http".equals(qVar.b) ? 80 : 443;
                }
                bVar.a(str + ".Port", Integer.toString(i));
            }
        }

        static void a(Context context, com.shieldtunnel.svpn.common.jni.b bVar) {
            com.shieldtunnel.svpn.common.f.i iVar = new com.shieldtunnel.svpn.common.f.i();
            if (iVar.b(context)) {
                bVar.a(0, "key_inject", iVar.c());
            }
        }

        static m a(com.shieldtunnel.svpn.common.jni.b bVar) {
            m mVar = new m(bVar);
            mVar.start();
            return mVar;
        }
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int b(List<String> list) {
        if (list == null) {
            return 1012;
        }
        list.clear();
        for (String str : b().split("\\|")) {
            if (!TextUtils.isEmpty(str)) {
                list.add(str);
            }
        }
        return 0;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int c() {
        j();
        this.h.d();
        if (this.i != null) {
            a();
            this.c.c();
        }
        XYVpnService.b();
        XYVpnService.a(this.f5781a);
        synchronized (this) {
            m mVar = this.i;
            this.i = null;
            if (mVar != null) {
                mVar.a();
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr) {
        XYVpnService.a(this.f5781a);
        a("lua_error", bArr);
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public String b() {
        return com.shieldtunnel.svpn.common.k.e.b(this.c.b("key_node_region_list"));
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str, Object obj) {
        this.j.a(System.currentTimeMillis(), str, obj);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.shieldtunnel.svpn.common.d.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0149c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final com.shieldtunnel.svpn.common.jni.b f5784a;
        private Context b;

        C0149c(com.shieldtunnel.svpn.common.jni.b bVar) {
            this.f5784a = bVar;
        }

        void a(Context context) {
            if (this.b != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            Context applicationContext = context.getApplicationContext();
            this.b = applicationContext;
            applicationContext.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                str = "screen_off";
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                str = "screen_on";
            } else if (!"android.intent.action.USER_PRESENT".equals(action)) {
                return;
            } else {
                str = "user_present";
            }
            this.f5784a.a(0, "key_broadcast", str);
        }

        void a() {
            Context context = this.b;
            this.b = null;
            if (context != null) {
                context.unregisterReceiver(this);
            }
        }
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str, String str2) {
        this.c.a(str, str2);
        return 0;
    }

    private static long a(Integer num, long j2) {
        return num == null ? j2 : num.intValue() * 1000;
    }

    private static boolean a(Locale locale) {
        return (com.shieldtunnel.svpn.common.k.d.b(locale) || com.shieldtunnel.svpn.common.k.d.a(locale)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.shieldtunnel.svpn.common.d.e eVar) {
        if (com.shieldtunnel.svpn.common.b.a(LogTag.MAIN)) {
            Log.d(LogTag.MAIN, String.format("Change state from '%s' to '%s'", this.o.a(), eVar.a()));
        }
        this.o = eVar;
    }

    /* loaded from: classes2.dex */
    private static class j {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean a(String str, List<NodeInfo> list) {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                try {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        NodeInfo a2 = a(jsonReader);
                        if (a2 != null) {
                            list.add(a2);
                        }
                    }
                    jsonReader.endArray();
                    return true;
                } finally {
                    com.shieldtunnel.svpn.common.c.a(jsonReader);
                }
            } catch (IOException | AssertionError | RuntimeException e) {
                Log.w(LogTag.MAIN, String.format("Parse nodes json error: %s", e.getMessage()));
                return false;
            }
        }

        private static List<String> b(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList(4);
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                String a2 = com.shieldtunnel.svpn.common.k.c.a(jsonReader);
                if (!TextUtils.isEmpty(a2)) {
                    arrayList.add(a2);
                }
            }
            jsonReader.endArray();
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }

        private static NodeInfo a(JsonReader jsonReader) {
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            List<String> list = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("id".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if ("flags".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("region".equals(nextName)) {
                    str = jsonReader.nextString();
                } else if ("area".equals(nextName)) {
                    str2 = com.shieldtunnel.svpn.common.k.c.a(jsonReader);
                } else if ("tags".equals(nextName)) {
                    list = b(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (str == null || str2 == null) {
                return null;
            }
            return new NodeInfo(i, i2, str, str2, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final NodeDetectCallback f5790a;
        private final int b;
        private final int c;
        private final byte[] d;

        i(NodeDetectCallback nodeDetectCallback, int i, int i2, byte[] bArr) {
            this.f5790a = nodeDetectCallback;
            this.b = i;
            this.c = i2;
            this.d = bArr;
        }

        private static List<NodeState> a(byte[] bArr) {
            if (bArr == null || bArr.length <= 2) {
                return null;
            }
            ArrayList arrayList = new ArrayList(64);
            String a2 = com.shieldtunnel.svpn.common.k.e.a(bArr);
            JsonReader jsonReader = new JsonReader(new StringReader(a2));
            try {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    NodeState b = b(jsonReader);
                    if (b != null) {
                        arrayList.add(b);
                    } else {
                        Log.w(LogTag.MAIN, "There is a node-state parse failed");
                    }
                }
                jsonReader.endArray();
            } catch (IOException | AssertionError | RuntimeException unused) {
                com.shieldtunnel.svpn.common.b.b(LogTag.MAIN, "NodeDetectResult, invalid json: " + a2);
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }

        private static NodeState b(JsonReader jsonReader) {
            jsonReader.beginObject();
            int i = -1;
            NetDelay netDelay = null;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("nodeId".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if ("delay".equals(nextName)) {
                    netDelay = a(jsonReader);
                } else if ("score".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (i <= 0 || netDelay == null) {
                return null;
            }
            return new NodeState(i, i2, netDelay);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5790a == null) {
                com.shieldtunnel.svpn.common.b.b(LogTag.MAIN, String.format(com.shieldtunnel.svpn.common.f.f.b, "Cannot find node detect callback with key %d", Integer.valueOf(this.b)));
            } else {
                com.shieldtunnel.svpn.common.j.b.a().b(new h(this.f5790a, this.c, a(this.d), null));
            }
        }

        private static NetDelay a(JsonReader jsonReader) {
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("average".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if ("variance".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("lost".equals(nextName)) {
                    i3 = jsonReader.nextInt();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return new NetDelay(i, i2, i3);
        }
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(TunnelEventListener tunnelEventListener) {
        this.m = tunnelEventListener;
        return 0;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str) {
        if (str == null || str.length() < 7) {
            return 1012;
        }
        this.c.a(0, "key_custom_node_list", str);
        return 0;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(int i2, int i3) {
        if (i2 <= 0 || i3 > 65535 || i2 > i3) {
            return 1012;
        }
        this.c.a(0, "key_node_port_range", String.format(com.shieldtunnel.svpn.common.f.f.f5810a, "%d,%d", Integer.valueOf(i2), Integer.valueOf(i3)));
        return 0;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(List<NodeInfo> list) {
        if (list == null) {
            return 1012;
        }
        list.clear();
        String b2 = this.c.b("key_nodes_json");
        if (TextUtils.isEmpty(b2) || j.a(b2, list)) {
            return 0;
        }
        return ErrorCode.INTERNAL_ERROR;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str, NodeDetectCallback nodeDetectCallback) {
        if (nodeDetectCallback == null) {
            return 1012;
        }
        this.c.a(this.q.a((com.shieldtunnel.svpn.common.e.a<NodeDetectCallback>) nodeDetectCallback), str);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TunnelEventListener.Event event, int i2) {
        return a(event, i2, (byte[]) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TunnelEventListener.Event event, int i2, byte[] bArr) {
        TunnelEventListener tunnelEventListener = this.m;
        if (tunnelEventListener != null) {
            tunnelEventListener.onEvent(event, i2, com.shieldtunnel.svpn.common.k.e.a(bArr));
        }
        return i2;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str, a.EnumC0148a enumC0148a) {
        a(TunnelEventListener.Event.DIAL_UP, 0);
        if (!this.o.d()) {
            return a(TunnelEventListener.Event.DIAL_UP_RESULT, 1004);
        }
        UserInfo userInfo = this.k;
        if (userInfo == null) {
            return a(TunnelEventListener.Event.DIAL_UP_RESULT, 1009);
        }
        if (VpnService.prepare(this.f5781a) != null) {
            return a(TunnelEventListener.Event.DIAL_UP_RESULT, 8000);
        }
        if (enumC0148a == a.EnumC0148a.ID_LIST && (str == null || str.trim().length() == 0)) {
            return a(TunnelEventListener.Event.DIAL_UP_RESULT, 1012);
        }
        if (XYVpnService.d() == null) {
            XYVpnService.a(this.f5781a, this.d);
        }
        this.l = new f(str, enumC0148a);
        a(new com.shieldtunnel.svpn.common.d.g(this.p));
        if (enumC0148a == a.EnumC0148a.REGION) {
            this.c.b(userInfo, str);
        } else {
            this.c.a(userInfo, str);
        }
        return 0;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a() {
        return a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(boolean z) {
        if (!this.o.b()) {
            return 1004;
        }
        a(new com.shieldtunnel.svpn.common.d.j(this.p));
        this.c.a(z);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, byte[] bArr) {
        Log.d(LogTag.MAIN, String.format(com.shieldtunnel.svpn.common.f.f.b, "Tunnel event: %d (%s)", Integer.valueOf(i2), com.shieldtunnel.svpn.common.k.e.a(bArr)));
        com.shieldtunnel.svpn.common.j.b.a().b(new a(i2, bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, int i3, byte[] bArr) {
        com.shieldtunnel.svpn.common.j.c.a(new i(this.q.a(i2), i2, i3, bArr));
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(VPNStateListener vPNStateListener) {
        this.n.f5793a = vPNStateListener;
        return 0;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return 1012;
        }
        this.k = new UserInfo(str, str2, str3);
        return 0;
    }
}
