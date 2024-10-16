package com.subao.common.k;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.subao.common.k.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC0175d f6097a;
    private static com.subao.common.k.e b = new a();
    private static final c c;

    /* loaded from: classes2.dex */
    public interface b {
        void a(Object obj);

        void b(Object obj);
    }

    /* renamed from: com.subao.common.k.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    interface InterfaceC0175d {
        com.subao.common.k.e a(Context context);

        boolean a();

        String b();
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            c = new c();
        } else {
            c = null;
        }
    }

    public static void a(Context context) {
        if (f6097a == null) {
            f6097a = b(context);
            b = f6097a.a(context);
        }
    }

    private static InterfaceC0175d b(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            String str = "vivo";
            f.b a2 = k.a(context);
            if (a2 == null) {
                str = "oppo";
                a2 = j.a(context);
            }
            if (a2 == null) {
                str = "miui";
                a2 = i.a(context);
            }
            if (a2 != null) {
                return new e(str, a2);
            }
        }
        Log.d("SubaoParallel", "Dual-WiFi not supported");
        return new f();
    }

    public static void a(b bVar) {
        c cVar = c;
        if (cVar != null) {
            cVar.a((c) bVar);
        }
    }

    public static void b(b bVar) {
        c cVar = c;
        if (cVar != null) {
            cVar.b((c) bVar);
        }
    }

    public static boolean a() {
        InterfaceC0175d interfaceC0175d = f6097a;
        return interfaceC0175d != null && interfaceC0175d.a();
    }

    public static String b() {
        InterfaceC0175d interfaceC0175d = f6097a;
        if (interfaceC0175d == null) {
            return null;
        }
        return interfaceC0175d.b();
    }

    public static boolean c() {
        return b.c();
    }

    public static int d() {
        int b2 = b.b();
        if (com.subao.common.d.a("SubaoParallel")) {
            Log.d("SubaoParallel", String.format(com.subao.common.e.r.f6001a, "ExtWifi.requestFD() return %d", Integer.valueOf(b2)));
        }
        return b2;
    }

    static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 21) {
            Log.d("SubaoParallel", String.format(com.subao.common.e.r.f6001a, "DualWifi not supported on Android version %d", Integer.valueOf(Build.VERSION.SDK_INT)));
            return false;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            Log.d("SubaoParallel", "Can not get WifiManager");
            return false;
        }
        try {
            Method declaredMethod = g.a().getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(wifiManager, new Object[0]);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | RuntimeException unused) {
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause != null) {
                Log.w("SubaoParallel", cause);
            } else {
                e2.printStackTrace();
            }
        }
        return false;
    }

    /* loaded from: classes2.dex */
    static abstract class h implements f.b {
        protected abstract void a(NetworkRequest.Builder builder);

        protected abstract int b();

        h() {
        }

        @Override // com.subao.common.k.f.b
        public NetworkRequest a() {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addTransportType(b());
            builder.addCapability(12);
            a(builder);
            return builder.build();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class k extends h {

        /* renamed from: a, reason: collision with root package name */
        private final int f6101a;

        @Override // com.subao.common.k.d.h
        protected void a(NetworkRequest.Builder builder) {
        }

        k(int i) {
            this.f6101a = i;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        static f.b a(Context context) {
            if (Build.VERSION.SDK_INT < 21 || !d.a(context, "supportDualWifi")) {
                return null;
            }
            int a2 = d.a("TRANSPORT_EXTWIFI");
            if (a2 == -1) {
                Log.w("SubaoParallel", "Dual-WiFi supported in VIVO, but transport-type get failed");
                return null;
            }
            Log.d("SubaoParallel", "Dual-WiFi supported (VIVO)");
            return new k(a2);
        }

        @Override // com.subao.common.k.d.h
        protected int b() {
            return this.f6101a;
        }
    }

    static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Class b2 = g.b();
            return b2.getField(str).getInt(b2);
        } catch (ReflectiveOperationException | RuntimeException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class j extends h {
        @Override // com.subao.common.k.d.h
        protected int b() {
            return 1;
        }

        j() {
        }

        public static f.b a(Context context) {
            if (!d.a(context, "isDualStaSupported")) {
                return null;
            }
            Log.d("SubaoParallel", "Dual-WiFi supported (OPPO)");
            return new j();
        }

        @Override // com.subao.common.k.d.h
        @SuppressLint({"WrongConstant"})
        protected void a(NetworkRequest.Builder builder) {
            builder.addCapability(30);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class i extends h {
        private static boolean b;

        /* renamed from: a, reason: collision with root package name */
        private final int f6100a;

        @Override // com.subao.common.k.d.h
        protected void a(NetworkRequest.Builder builder) {
        }

        i(int i) {
            this.f6100a = i;
        }

        public static f.b a(Context context) {
            if ((!b && Build.VERSION.SDK_INT < 29) || !b(context)) {
                return null;
            }
            int a2 = d.a("TRANSPORT_SLAVE_WIFI");
            if (a2 < 0) {
                Log.w("SubaoParallel", "Dual-WiFi supported in MIUI, but transport-type get failed");
                return null;
            }
            Log.d("SubaoParallel", "Dual-WiFi supported (MIUI)");
            return new i(a2);
        }

        private static boolean b(Context context) {
            if ("off".equals(Settings.System.getString(context.getContentResolver(), "cloud_slave_wifi_support"))) {
                return false;
            }
            try {
                Resources resources = context.getResources();
                if (resources == null) {
                    return false;
                }
                return resources.getBoolean(resources.getIdentifier("config_slave_wifi_support", "bool", "android.miui"));
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // com.subao.common.k.d.h
        protected int b() {
            return this.f6100a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class f implements InterfaceC0175d {
        @Override // com.subao.common.k.d.InterfaceC0175d
        public boolean a() {
            return false;
        }

        @Override // com.subao.common.k.d.InterfaceC0175d
        public String b() {
            return null;
        }

        f() {
        }

        @Override // com.subao.common.k.d.InterfaceC0175d
        public com.subao.common.k.e a(Context context) {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e implements InterfaceC0175d {

        /* renamed from: a, reason: collision with root package name */
        private final String f6098a;
        private final f.b b;

        @Override // com.subao.common.k.d.InterfaceC0175d
        public boolean a() {
            return true;
        }

        e(String str, f.b bVar) {
            this.f6098a = str;
            this.b = bVar;
        }

        @Override // com.subao.common.k.d.InterfaceC0175d
        public String b() {
            return this.f6098a;
        }

        @Override // com.subao.common.k.d.InterfaceC0175d
        public com.subao.common.k.e a(Context context) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return new a();
            }
            return new com.subao.common.k.f(connectivityManager, this.b, new ConnectivityManager.NetworkCallback() { // from class: com.subao.common.k.d.e.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    if (d.c != null) {
                        d.c.a(network);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    if (d.c != null) {
                        d.c.b(network);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g {
        static Class a() {
            return WifiManager.class;
        }

        @TargetApi(21)
        static Class b() {
            return NetworkCapabilities.class;
        }
    }

    /* loaded from: classes2.dex */
    private static class a implements com.subao.common.k.e {
        @Override // com.subao.common.a
        public void a() {
        }

        @Override // com.subao.common.k.e
        public int b() {
            return -1;
        }

        @Override // com.subao.common.k.e
        public boolean c() {
            return false;
        }

        private a() {
        }
    }

    /* loaded from: classes2.dex */
    static class c extends com.subao.common.g<b> {
        c() {
        }

        void a(Network network) {
            List<b> a2 = a();
            if (a2 != null) {
                Iterator<b> it = a2.iterator();
                while (it.hasNext()) {
                    it.next().a(network);
                }
            }
        }

        void b(Network network) {
            List<b> a2 = a();
            if (a2 != null) {
                Iterator<b> it = a2.iterator();
                while (it.hasNext()) {
                    it.next().b(network);
                }
            }
        }
    }
}
