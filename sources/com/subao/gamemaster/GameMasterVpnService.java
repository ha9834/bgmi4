package com.subao.gamemaster;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.subao.common.a.b;
import com.subao.common.a.e;
import com.subao.common.d;
import com.subao.common.e.r;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

@TargetApi(14)
/* loaded from: classes2.dex */
public class GameMasterVpnService extends e {
    private static String b;
    private static GameMasterVpnService c;

    /* renamed from: a, reason: collision with root package name */
    protected ParcelFileDescriptor f6145a;

    private static void b(String str) {
        d.a("SubaoGame", "GameVpn: " + str);
    }

    static String a(Context context) {
        Configuration configuration;
        String str = b;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Locale locale = null;
        Resources resources = context.getResources();
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            locale = configuration.locale;
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return (locale == null || "CN".equals(locale.getCountry())) ? "游戏加速服务" : "TW".equals(locale.getCountry()) ? "遊戲加速服務" : "Game Acceleration Service";
    }

    public static synchronized GameMasterVpnService c() {
        GameMasterVpnService gameMasterVpnService;
        synchronized (GameMasterVpnService.class) {
            gameMasterVpnService = c;
        }
        return gameMasterVpnService;
    }

    public static boolean b(Context context) {
        return context.startService(new Intent(context, (Class<?>) GameMasterVpnService.class)) != null;
    }

    public static void c(Context context) {
        context.stopService(new Intent(context, (Class<?>) GameMasterVpnService.class));
    }

    @TargetApi(21)
    static void a(VpnService.Builder builder, String str, Iterable<String> iterable) {
        boolean a2 = d.a("SubaoGame");
        if (a(builder, str, a2) && iterable != null) {
            Iterator<String> it = iterable.iterator();
            while (it.hasNext()) {
                a(builder, it.next(), a2);
            }
        }
    }

    @TargetApi(21)
    static boolean a(VpnService.Builder builder, String str, boolean z) {
        if (z) {
            b(String.format("add allowed app (%s)", str));
        }
        try {
            builder.addAllowedApplication(str);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        } catch (RuntimeException unused2) {
            return false;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        PackageManager packageManager = getPackageManager();
        if (packageManager != null) {
            try {
                Bundle bundle = packageManager.getServiceInfo(new ComponentName(this, (Class<?>) GameMasterVpnService.class), 128).metaData;
                if (bundle != null) {
                    int i3 = bundle.getInt("start_command_result", -1);
                    if (i3 >= 0) {
                        onStartCommand = i3;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        b(String.format(r.f6001a, "onStartCommand(%s, %d, %d) return %d", intent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(onStartCommand)));
        return onStartCommand;
    }

    @Override // android.app.Service
    public void onCreate() {
        boolean a2 = d.a("SubaoGame");
        if (a2) {
            b("service create");
        }
        super.onCreate();
        synchronized (GameMasterVpnService.class) {
            c = this;
        }
        com.subao.common.a.a a3 = b.a();
        if (a3 != null) {
            if (a2) {
                b("Notify AccelEngine instance when service create");
            }
            a3.b();
            return;
        }
        Log.w("SubaoGame", "AccelEngine instance is null");
    }

    @Override // android.net.VpnService
    public void onRevoke() {
        if (d.a("SubaoGame")) {
            d.a("SubaoGame", "service revoked");
        }
        a();
        super.onRevoke();
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (d.a("SubaoGame")) {
            b("service destroy");
        }
        a();
        super.onDestroy();
        synchronized (GameMasterVpnService.class) {
            if (c == this) {
                c = null;
            }
        }
    }

    @Override // com.subao.common.a.e
    public int a(Iterable<String> iterable) {
        boolean a2 = d.a("SubaoGame");
        synchronized (this) {
            if (this.f6145a == null) {
                if (a2) {
                    b("establish ...");
                }
                int a3 = a(iterable, new VpnService.Builder(this));
                if (a2) {
                    b("establish return: " + a3);
                }
                if (a3 != 0) {
                    return a3;
                }
            }
            return d();
        }
    }

    @Override // com.subao.common.a.e
    public boolean b() {
        return this.f6145a != null;
    }

    int d() {
        ParcelFileDescriptor parcelFileDescriptor = this.f6145a;
        if (parcelFileDescriptor == null) {
            return 8006;
        }
        return b.a().a(parcelFileDescriptor.getFd());
    }

    int a(Iterable<String> iterable, VpnService.Builder builder) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                a(builder, getPackageName(), iterable);
            }
            builder.addAddress("198.51.100.10", 32);
            builder.addRoute("0.0.0.0", 0);
            builder.setSession(a(getApplicationContext()));
            builder.setConfigureIntent(null);
            this.f6145a = builder.establish();
            if (this.f6145a == null) {
                return ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT;
            }
            return 0;
        } catch (Error e) {
            e.printStackTrace();
            return ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 8000;
        }
    }

    @Override // com.subao.common.a.e
    public void a() {
        boolean a2 = d.a("SubaoGame");
        synchronized (this) {
            if (this.f6145a != null) {
                b.a().d();
                if (a2) {
                    b("close interface");
                }
                try {
                    this.f6145a.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.f6145a = null;
            }
        }
    }

    public static void a(String str) {
        b = str;
    }
}
