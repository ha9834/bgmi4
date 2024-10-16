package com.shieldtunnel.svpn;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.messages.BleSignal;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.d.k;
import com.shieldtunnel.svpn.common.f.f;
import com.shieldtunnel.svpn.common.intf.VPNStateListener;
import com.shieldtunnel.svpn.common.intf.VpnServiceStrategy;
import java.io.IOException;
import java.net.InetAddress;

/* loaded from: classes2.dex */
public class XYVpnService extends VpnService {
    private static VPNStateListener b;
    private static volatile XYVpnService c;
    private static String d;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f5773a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VPNStateListener f5774a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;

        a(XYVpnService xYVpnService, VPNStateListener vPNStateListener, boolean z, boolean z2) {
            this.f5774a = vPNStateListener;
            this.b = z;
            this.c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5774a.onVPNStateChanged(this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f5775a;
        public final int b;

        private b(int i, int i2) {
            this.f5775a = i;
            this.b = i2;
        }

        static b a(int i) {
            return new b(0, i);
        }

        static b b(int i) {
            return new b(i, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        Log.d(LogTag.MAIN, "st-engine: " + str);
    }

    public static synchronized XYVpnService d() {
        XYVpnService xYVpnService;
        synchronized (XYVpnService.class) {
            xYVpnService = c;
        }
        return xYVpnService;
    }

    VpnService.Builder c() {
        return new VpnService.Builder(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b("service create");
        Integer num = VpnServiceStrategy.iconResId;
        if (num != null) {
            c.a(this, num.intValue());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b("service destroy");
        c.a(this);
        a(true);
        synchronized (XYVpnService.class) {
            if (c == this) {
                c = null;
            }
        }
    }

    @Override // android.net.VpnService
    public void onRevoke() {
        b("service revoked");
        super.onRevoke();
        a(true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        c = this;
        super.onStartCommand(intent, i, i2);
        Integer num = VpnServiceStrategy.startCommandResult;
        int intValue = num != null ? num.intValue() : 1;
        b(String.format(f.b, "onStartCommand(%s, %d, %d) return %d", intent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(intValue)));
        return intValue;
    }

    public static void a(VPNStateListener vPNStateListener) {
        b = vPNStateListener;
    }

    public static boolean b() {
        XYVpnService xYVpnService = c;
        if (xYVpnService != null) {
            return xYVpnService.a(false);
        }
        return false;
    }

    static String a() {
        String str = VpnServiceStrategy.sessionName;
        return TextUtils.isEmpty(str) ? VpnServiceStrategy.DEFAULT_SESSION_NAME : str;
    }

    public static boolean a(Context context, String str) {
        d = str;
        return context.startService(new Intent(context, (Class<?>) XYVpnService.class)) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int b(android.net.VpnService.Builder r5, com.shieldtunnel.svpn.common.d.k r6) {
        /*
            java.lang.Integer r0 = com.shieldtunnel.svpn.common.intf.VpnServiceStrategy.ipVersionSupport
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1a
            int r0 = r0.intValue()
            r3 = 2
            if (r0 != r3) goto L10
            r0 = 1
            r1 = 0
            goto L1b
        L10:
            java.lang.Integer r0 = com.shieldtunnel.svpn.common.intf.VpnServiceStrategy.ipVersionSupport
            int r0 = r0.intValue()
            if (r0 != r1) goto L1a
            r0 = 0
            goto L1b
        L1a:
            r0 = 1
        L1b:
            java.lang.String r3 = r6.f()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L26
            r0 = 0
        L26:
            int r3 = r6.b()
            r4 = 1280(0x500, float:1.794E-42)
            if (r3 >= r4) goto L2f
            r0 = 0
        L2f:
            if (r1 != 0) goto L36
            if (r0 != 0) goto L36
            r5 = 8008(0x1f48, float:1.1222E-41)
            return r5
        L36:
            if (r1 == 0) goto L50
            java.lang.String r3 = r6.e()
            a(r5, r3)
            r3 = 4
            byte[] r3 = new byte[r3]
            java.net.InetAddress r3 = java.net.InetAddress.getByAddress(r3)
            r5.addRoute(r3, r2)
            if (r0 != 0) goto L50
            int r3 = android.system.OsConstants.AF_INET6
            r5.allowFamily(r3)
        L50:
            if (r0 == 0) goto L6d
            java.lang.String r6 = r6.f()
            a(r5, r6)
            r6 = 16
            byte[] r6 = new byte[r6]
            java.lang.String r0 = "::"
            java.net.InetAddress r6 = java.net.InetAddress.getByAddress(r0, r6)
            r5.addRoute(r6, r2)
            if (r1 != 0) goto L6d
            int r6 = android.system.OsConstants.AF_INET
            r5.allowFamily(r6)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shieldtunnel.svpn.XYVpnService.b(android.net.VpnService$Builder, com.shieldtunnel.svpn.common.d.k):int");
    }

    /* loaded from: classes2.dex */
    private static class c {
        private static NotificationChannel a() {
            NotificationChannel notificationChannel = new NotificationChannel("30A8469A-7E5C-49B0-8452-3751AD433A14", XYVpnService.a(), 3);
            notificationChannel.setDescription(VpnServiceStrategy.description);
            notificationChannel.setSound(null, null);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            return notificationChannel;
        }

        static void a(Service service, int i) {
            NotificationManager notificationManager = (NotificationManager) service.getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            Notification.Builder builder = new Notification.Builder(service);
            builder.setContentTitle(XYVpnService.a());
            builder.setContentText(VpnServiceStrategy.description);
            builder.setSmallIcon(i);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel a2 = a();
                notificationManager.createNotificationChannel(a2);
                builder.setChannelId(a2.getId());
            }
            service.startForeground(319, builder.build());
            XYVpnService.b("start foreground");
        }

        static void a(Service service) {
            service.stopForeground(true);
            XYVpnService.b("stop foreground");
        }
    }

    public static boolean a(Context context) {
        return context.stopService(new Intent(context, (Class<?>) XYVpnService.class));
    }

    public b a(k kVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return b.b(1014);
        }
        a(true);
        b("establish ...");
        VpnService.Builder c2 = c();
        int a2 = a(c2, kVar);
        if (a2 != 0) {
            return b.b(a2);
        }
        try {
            ParcelFileDescriptor establish = c2.establish();
            if (establish == null) {
                return b.b(8002);
            }
            b("establish success");
            if (!protect(kVar.d())) {
                b("protect fd failed");
                com.shieldtunnel.svpn.common.c.a(establish);
                return b.b(ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT);
            }
            this.f5773a = true;
            a(true, false);
            return b.a(establish.detachFd());
        } catch (Error e) {
            e.printStackTrace();
            return b.b(ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED);
        } catch (Exception e2) {
            e2.printStackTrace();
            return b.b(8003);
        }
    }

    private static void a(VpnService.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InetAddress byName = InetAddress.getByName(str);
        builder.addAddress(byName, byName.getAddress().length * 8);
    }

    int a(VpnService.Builder builder, k kVar) {
        try {
            builder.setSession(a());
            builder.setMtu(kVar.b());
            try {
                builder.addDnsServer(kVar.a());
                int b2 = b(builder, kVar);
                if (b2 != 0) {
                    return b2;
                }
                try {
                    a(d, builder, VpnServiceStrategy.appFilterMode);
                    return 0;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    return 8001;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                return ConnectionsStatusCodes.STATUS_OUT_OF_ORDER_API_CALL;
            }
        } catch (RuntimeException e3) {
            e3.printStackTrace();
            return 8010;
        }
    }

    void a(String str, VpnService.Builder builder, Integer num) {
        int intValue;
        if (num == null) {
            String[] strArr = f.d;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    intValue = BleSignal.UNKNOWN_TX_POWER;
                    break;
                } else {
                    if (strArr[i].compareToIgnoreCase(str) == 0) {
                        intValue = 2;
                        break;
                    }
                    i++;
                }
            }
            if (intValue == Integer.MIN_VALUE) {
                intValue = 4;
            }
        } else {
            intValue = num.intValue();
        }
        if (intValue == 2 || intValue == 3) {
            builder.addAllowedApplication(getPackageName());
        } else if (intValue != 5) {
            builder.addDisallowedApplication(getPackageName());
        }
    }

    boolean a(boolean z) {
        boolean z2;
        synchronized (this) {
            z2 = this.f5773a;
            this.f5773a = false;
        }
        if (!z2) {
            return false;
        }
        a(false, z);
        return true;
    }

    private void a(boolean z, boolean z2) {
        VPNStateListener vPNStateListener = b;
        if (vPNStateListener == null) {
            return;
        }
        if (com.shieldtunnel.svpn.common.k.f.b()) {
            vPNStateListener.onVPNStateChanged(z, z2);
        } else {
            com.shieldtunnel.svpn.common.j.b.a().b(new a(this, vPNStateListener, z, z2));
        }
    }
}
