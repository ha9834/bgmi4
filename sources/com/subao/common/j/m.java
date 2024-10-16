package com.subao.common.j;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;

/* loaded from: classes2.dex */
public class m {

    /* loaded from: classes2.dex */
    public interface a {
        void a(byte[] bArr);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(f fVar);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean a(byte[] bArr);
    }

    public static void a(c cVar, a aVar) {
        com.subao.common.m.d.a(new d(cVar, aVar) { // from class: com.subao.common.j.m.1
            @Override // com.subao.common.j.m.d
            byte[] a(c cVar2) {
                byte[] a2 = m.a(cVar2);
                Log.d("SubaoNet", "Local IP: " + com.subao.common.j.f.a(a2));
                return a2;
            }
        });
    }

    static byte[] a(c cVar) {
        return a(new e(), cVar);
    }

    static byte[] a(e eVar, c cVar) {
        try {
            Enumeration<NetworkInterface> a2 = eVar.a();
            if (a2 != null) {
                return a(a2, cVar);
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    private static byte[] a(Enumeration<NetworkInterface> enumeration, c cVar) {
        while (enumeration.hasMoreElements()) {
            byte[] a2 = a(cVar, enumeration.nextElement());
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public static void b(c cVar, a aVar) {
        com.subao.common.m.d.a(new d(cVar, aVar) { // from class: com.subao.common.j.m.2
            @Override // com.subao.common.j.m.d
            byte[] a(c cVar2) {
                byte[] b2 = m.b(cVar2);
                Log.d("SubaoNet", "Cellular Local IP: " + com.subao.common.j.f.a(b2));
                return b2;
            }
        });
    }

    static byte[] b(c cVar) {
        return a(cVar, new e());
    }

    static byte[] a(c cVar, e eVar) {
        Enumeration<NetworkInterface> a2;
        byte[] a3;
        try {
            a2 = eVar.a();
        } catch (SocketException unused) {
        }
        if (a2 == null) {
            return null;
        }
        while (a2.hasMoreElements()) {
            NetworkInterface nextElement = a2.nextElement();
            if (a(nextElement) && (a3 = a(cVar, nextElement)) != null) {
                return a3;
            }
        }
        return null;
    }

    private static byte[] a(c cVar, NetworkInterface networkInterface) {
        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
            InetAddress nextElement = inetAddresses.nextElement();
            if (!nextElement.isLoopbackAddress() && !nextElement.isAnyLocalAddress() && !nextElement.isLinkLocalAddress() && (nextElement instanceof Inet4Address)) {
                byte[] address = nextElement.getAddress();
                if (cVar == null || cVar.a(address)) {
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

    public static String a(Context context, l lVar) {
        WifiInfo connectionInfo;
        if (lVar.c()) {
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                    return null;
                }
                return connectionInfo.getSSID();
            } catch (RuntimeException unused) {
                return null;
            }
        }
        if (lVar.d()) {
            return a(context);
        }
        return null;
    }

    private static String a(Context context) {
        String networkOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && (networkOperator = telephonyManager.getNetworkOperator()) != null && networkOperator.length() >= 4) {
                int parseInt = Integer.parseInt(networkOperator.substring(0, 3));
                int parseInt2 = Integer.parseInt(networkOperator.substring(3));
                CellLocation cellLocation = telephonyManager.getCellLocation();
                if (cellLocation == null || !(cellLocation instanceof GsmCellLocation)) {
                    return null;
                }
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                int lac = gsmCellLocation.getLac();
                int cid = gsmCellLocation.getCid();
                StringBuilder sb = new StringBuilder(256);
                sb.append("MCC:");
                sb.append(parseInt);
                sb.append("MNC:");
                sb.append(parseInt2);
                sb.append("LAC:");
                sb.append(lac);
                sb.append("CID:");
                sb.append(cid);
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(final Context context, final b bVar) {
        com.subao.common.m.d.a(new Runnable() { // from class: com.subao.common.j.m.3
            @Override // java.lang.Runnable
            public void run() {
                WifiInfo connectionInfo;
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                    return;
                }
                bVar.a(new f(com.subao.common.j.f.c(com.subao.common.j.f.a(connectionInfo.getIpAddress())), Build.VERSION.SDK_INT >= 21 ? connectionInfo.getFrequency() : 0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e {
        e() {
        }

        Enumeration<NetworkInterface> a() {
            return NetworkInterface.getNetworkInterfaces();
        }
    }

    /* loaded from: classes2.dex */
    private static abstract class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final c f6084a;
        private final a b;

        abstract byte[] a(c cVar);

        d(c cVar, a aVar) {
            this.b = aVar;
            this.f6084a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(a(this.f6084a));
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final String f6085a;
        private final int b;

        f(String str, int i) {
            this.f6085a = str;
            this.b = i;
        }

        public String a() {
            return this.f6085a;
        }

        public int b() {
            return this.b;
        }
    }
}
