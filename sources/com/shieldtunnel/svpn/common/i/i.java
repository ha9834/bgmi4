package com.shieldtunnel.svpn.common.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.Log;
import com.shieldtunnel.svpn.common.LogTag;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;

/* loaded from: classes2.dex */
public class i {

    /* loaded from: classes2.dex */
    static class a extends e {
        a(d dVar, c cVar) {
            super(dVar, cVar);
        }

        @Override // com.shieldtunnel.svpn.common.i.i.e
        byte[] a(d dVar) {
            byte[] a2 = i.a(dVar);
            Log.d(LogTag.NET, "Cellular Local IP: " + com.shieldtunnel.svpn.common.i.c.a(a2));
            return a2;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static boolean a() {
            return Build.VERSION.SDK_INT >= 29;
        }

        public static int a(Context context, int i, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                return connectivityManager.getConnectionOwnerUid(i, inetSocketAddress, inetSocketAddress2);
            } catch (NoSuchMethodError | RuntimeException e) {
                e.printStackTrace();
                return -1;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(byte[] bArr);
    }

    /* loaded from: classes2.dex */
    public interface d {
        boolean a(byte[] bArr);
    }

    /* loaded from: classes2.dex */
    private static abstract class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final d f5852a;
        private final c b;

        e(d dVar, c cVar) {
            this.b = cVar;
            this.f5852a = dVar;
        }

        abstract byte[] a(d dVar);

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(a(this.f5852a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class f {
        f() {
        }

        Enumeration<NetworkInterface> a() {
            return NetworkInterface.getNetworkInterfaces();
        }
    }

    public static void a(d dVar, c cVar) {
        com.shieldtunnel.svpn.common.j.c.a(new a(dVar, cVar));
    }

    static byte[] a(d dVar) {
        return a(dVar, new f());
    }

    static byte[] a(d dVar, f fVar) {
        Enumeration<NetworkInterface> a2;
        byte[] a3;
        try {
            a2 = fVar.a();
        } catch (SocketException unused) {
        }
        if (a2 == null) {
            return null;
        }
        while (a2.hasMoreElements()) {
            NetworkInterface nextElement = a2.nextElement();
            if (a(nextElement) && (a3 = a(dVar, nextElement)) != null) {
                return a3;
            }
        }
        return null;
    }

    private static byte[] a(d dVar, NetworkInterface networkInterface) {
        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
            InetAddress nextElement = inetAddresses.nextElement();
            if (!nextElement.isLoopbackAddress() && !nextElement.isAnyLocalAddress() && !nextElement.isLinkLocalAddress() && (nextElement instanceof Inet4Address)) {
                byte[] address = nextElement.getAddress();
                if (dVar == null || dVar.a(address)) {
                    return Arrays.copyOf(address, address.length);
                }
            }
        }
        return null;
    }

    private static boolean a(NetworkInterface networkInterface) {
        String name = networkInterface.getName();
        if (name == null) {
            return false;
        }
        String lowerCase = name.toLowerCase();
        return lowerCase.contains("rmnet") || lowerCase.contains("ccmni");
    }
}
