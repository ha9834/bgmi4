package com.shieldtunnel.svpn.common.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.shieldtunnel.svpn.common.i.h;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f5846a;

    public static boolean a(Context context, h.a aVar, com.shieldtunnel.svpn.common.jni.b bVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        com.shieldtunnel.svpn.common.j.c.a(new a(context, aVar, bVar));
        return true;
    }

    /* loaded from: classes2.dex */
    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Context f5847a;
        private final h.a b;
        private final com.shieldtunnel.svpn.common.jni.b c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.shieldtunnel.svpn.common.i.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0158a {

            /* renamed from: a, reason: collision with root package name */
            final h.a f5848a;
            final String b;

            C0158a(h.a aVar, String str) {
                this.f5848a = aVar;
                this.b = str;
            }
        }

        a(Context context, h.a aVar, com.shieldtunnel.svpn.common.jni.b bVar) {
            this.f5847a = context;
            this.b = aVar;
            this.c = bVar;
        }

        private String a() {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f5847a.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(8);
            ArrayList arrayList2 = new ArrayList(8);
            a(connectivityManager, arrayList, arrayList2);
            return a(this.b, arrayList, arrayList2);
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2 = a();
            if (TextUtils.isEmpty(a2) || com.shieldtunnel.svpn.common.c.a(a2, d.f5846a)) {
                return;
            }
            String unused = d.f5846a = a2;
            this.c.a(0, "key_local_dns", a2);
        }

        private static void a(ConnectivityManager connectivityManager, List<C0158a> list, List<C0158a> list2) {
            LinkProperties linkProperties;
            for (Network network : connectivityManager.getAllNetworks()) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                if (networkInfo != null && networkInfo.isConnected() && (linkProperties = connectivityManager.getLinkProperties(network)) != null) {
                    for (InetAddress inetAddress : linkProperties.getDnsServers()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            C0158a c0158a = new C0158a(g.a(networkInfo), hostAddress);
                            if (inetAddress instanceof Inet4Address) {
                                list.add(c0158a);
                            } else {
                                list2.add(c0158a);
                            }
                        }
                    }
                }
            }
        }

        static String a(h.a aVar, List<C0158a> list, List<C0158a> list2) {
            String a2 = a(list, aVar);
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
            String a3 = a(list2, aVar);
            if (!TextUtils.isEmpty(a3)) {
                return a3;
            }
            if (!list.isEmpty()) {
                return list.get(0).b;
            }
            if (list2.isEmpty()) {
                return null;
            }
            return list2.get(0).b;
        }

        static String a(List<C0158a> list, h.a aVar) {
            if (list.isEmpty()) {
                return null;
            }
            for (C0158a c0158a : list) {
                if (c0158a.f5848a == aVar) {
                    return c0158a.b;
                }
            }
            return null;
        }
    }
}
