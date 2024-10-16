package com.google.android.vending.expansion.downloader.impl;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.expansion.downloader.f;
import com.google.android.vending.expansion.downloader.g;
import com.google.android.vending.licensing.e;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import java.io.File;

/* loaded from: classes2.dex */
public abstract class DownloaderService extends CustomIntentService implements f {
    private static boolean g;

    /* renamed from: a, reason: collision with root package name */
    long f5371a;
    long b;
    int c;
    long d;
    long e;
    float f;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private ConnectivityManager q;
    private WifiManager r;
    private PackageInfo s;
    private BroadcastReceiver t;
    private final g u;
    private final Messenger v;
    private Messenger w;
    private com.google.android.vending.expansion.downloader.impl.b x;
    private PendingIntent y;
    private PendingIntent z;

    public static boolean b(int i) {
        return i >= 400 && i < 600;
    }

    public static boolean c(int i) {
        return (i >= 200 && i < 300) || (i >= 400 && i < 600);
    }

    public abstract String g();

    public abstract byte[] h();

    public abstract String i();

    static /* synthetic */ boolean m() {
        return n();
    }

    public DownloaderService() {
        super("LVLDownloadService");
        this.u = com.google.android.vending.expansion.downloader.c.a(this);
        this.v = this.u.a();
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d("LVLDL", "Service Bound");
        return this.v.getBinder();
    }

    private void a(int i, int i2) {
        switch (i) {
            case 0:
                this.j = true;
                switch (i2) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        this.l = false;
                        this.m = false;
                        return;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                        this.l = true;
                        this.m = false;
                        return;
                    case 12:
                    default:
                        this.j = false;
                        this.l = false;
                        this.m = false;
                        return;
                    case 13:
                    case 14:
                    case 15:
                        this.l = true;
                        this.m = true;
                        return;
                }
            case 1:
            case 7:
            case 9:
                this.j = false;
                this.l = false;
                this.m = false;
                return;
            case 6:
                this.j = true;
                this.l = true;
                this.m = true;
                return;
            default:
                return;
        }
    }

    private void a(NetworkInfo networkInfo) {
        boolean z = this.h;
        boolean z2 = this.i;
        boolean z3 = this.j;
        boolean z4 = this.k;
        boolean z5 = this.l;
        if (networkInfo != null) {
            this.k = networkInfo.isRoaming();
            this.i = networkInfo.isFailover();
            this.h = networkInfo.isConnected();
            a(networkInfo.getType(), networkInfo.getSubtype());
        } else {
            this.k = false;
            this.i = false;
            this.h = false;
            a(-1, -1);
        }
        this.n = (!this.n && z == this.h && z2 == this.i && z3 == this.j && z4 == this.k && z5 == this.l) ? false : true;
    }

    void f() {
        if (this.q == null) {
            this.q = (ConnectivityManager) getSystemService("connectivity");
        }
        if (this.r == null) {
            this.r = (WifiManager) getSystemService("wifi");
        }
        ConnectivityManager connectivityManager = this.q;
        if (connectivityManager == null) {
            Log.w("LVLDL", "couldn't get connectivity manager to poll network state");
        } else {
            a(connectivityManager.getActiveNetworkInfo());
        }
    }

    private static boolean a(c cVar, PackageInfo packageInfo) {
        return cVar.f != packageInfo.versionCode;
    }

    private static synchronized boolean n() {
        boolean z;
        synchronized (DownloaderService.class) {
            z = g;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(boolean z) {
        synchronized (DownloaderService.class) {
            g = z;
        }
    }

    public static int a(Context context, Intent intent, Class<?> cls) throws PackageManager.NameNotFoundException {
        return a(context, (PendingIntent) intent.getParcelableExtra("EPI"), cls);
    }

    public static int a(Context context, PendingIntent pendingIntent, Class<?> cls) throws PackageManager.NameNotFoundException {
        return a(context, pendingIntent, context.getPackageName(), cls.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    public static int a(Context context, PendingIntent pendingIntent, String str, String str2) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        c a2 = c.a(context);
        boolean a3 = a(a2, packageInfo);
        ?? r4 = 2;
        r4 = 2;
        if (a2.g == 0) {
            com.google.android.vending.expansion.downloader.impl.a[] a4 = a2.a();
            if (a4 != null) {
                for (com.google.android.vending.expansion.downloader.impl.a aVar : a4) {
                    if (!com.google.android.vending.expansion.downloader.d.a(context, aVar.c, aVar.e, true)) {
                        a2.c(-1);
                        break;
                    }
                }
            }
            r4 = a3;
        }
        switch (r4) {
            case 1:
            case 2:
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                intent.putExtra("EPI", pendingIntent);
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            default:
                return r4;
        }
    }

    @Override // com.google.android.vending.expansion.downloader.f
    public void a() {
        this.o = 1;
        this.p = 490;
    }

    @Override // com.google.android.vending.expansion.downloader.f
    public void b() {
        this.o = 1;
        this.p = 193;
    }

    @Override // com.google.android.vending.expansion.downloader.f
    public void a(int i) {
        c.a(this).b(i);
    }

    @Override // com.google.android.vending.expansion.downloader.f
    public void c() {
        if (this.o == 1) {
            this.o = 0;
        }
        Intent intent = new Intent(this, getClass());
        intent.putExtra("EPI", this.y);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Context f5373a;

        b(Context context, PendingIntent pendingIntent) {
            this.f5373a = context;
            DownloaderService.this.y = pendingIntent;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloaderService.b(true);
            DownloaderService.this.x.a(2);
            final com.google.android.vending.licensing.b bVar = new com.google.android.vending.licensing.b(this.f5373a, new com.google.android.vending.licensing.a(DownloaderService.this.h(), this.f5373a.getPackageName(), Settings.Secure.getString(this.f5373a.getContentResolver(), "android_id")));
            bVar.a();
            new com.google.android.vending.licensing.d(this.f5373a, bVar, DownloaderService.this.g()).a(new e() { // from class: com.google.android.vending.expansion.downloader.impl.DownloaderService.b.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.vending.licensing.e
                public void allow(int i) {
                    int i2;
                    try {
                        int b = bVar.b();
                        c a2 = c.a(b.this.f5373a);
                        if (b != 0) {
                            i2 = 0;
                            for (int i3 = 0; i3 < b; i3++) {
                                String b2 = bVar.b(i3);
                                if (b2 != null) {
                                    com.google.android.vending.expansion.downloader.impl.a aVar = new com.google.android.vending.expansion.downloader.impl.a(i3, b2, b.this.f5373a.getPackageName());
                                    long c = bVar.c(i3);
                                    if (DownloaderService.this.a(a2, i3, b2, c)) {
                                        int i4 = i2 | (-1);
                                        aVar.a();
                                        aVar.f5375a = bVar.a(i3);
                                        aVar.e = c;
                                        aVar.h = i4;
                                        a2.c(aVar);
                                        i2 = i4;
                                    } else {
                                        com.google.android.vending.expansion.downloader.impl.a a3 = a2.a(aVar.c);
                                        if (a3 == null) {
                                            Log.d("LVLDL", "file " + aVar.c + " found. Not downloading.");
                                            aVar.h = 200;
                                            aVar.e = c;
                                            aVar.f = c;
                                            aVar.f5375a = bVar.a(i3);
                                            a2.c(aVar);
                                        } else if (a3.h != 200) {
                                            a3.f5375a = bVar.a(i3);
                                            a2.c(a3);
                                            i2 |= -1;
                                        }
                                    }
                                }
                            }
                        } else {
                            i2 = 0;
                        }
                        try {
                            a2.a(b.this.f5373a.getPackageManager().getPackageInfo(b.this.f5373a.getPackageName(), 0).versionCode, i2);
                            switch (DownloaderService.a(b.this.f5373a, DownloaderService.this.y, DownloaderService.this.getClass())) {
                                case 0:
                                    DownloaderService.this.x.a(5);
                                    break;
                                case 1:
                                    Log.e("LVLDL", "In LVL checking loop!");
                                    DownloaderService.this.x.a(15);
                                    throw new RuntimeException("Error with LVL checking and database integrity");
                            }
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                            throw new RuntimeException("Error with getting information from package name");
                        }
                    } finally {
                        DownloaderService.b(false);
                    }
                }

                @Override // com.google.android.vending.licensing.e
                public void dontAllow(int i) {
                    try {
                        if (i != 291) {
                            if (i == 561) {
                                DownloaderService.this.x.a(15);
                            }
                        }
                        DownloaderService.this.x.a(16);
                    } finally {
                        DownloaderService.b(false);
                    }
                }

                @Override // com.google.android.vending.licensing.e
                public void applicationError(int i) {
                    try {
                        DownloaderService.this.x.a(16);
                    } finally {
                        DownloaderService.b(false);
                    }
                }
            });
        }
    }

    public void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        new Handler(applicationContext.getMainLooper()).post(new b(applicationContext, this.y));
    }

    public boolean a(c cVar, int i, String str, long j) {
        String str2;
        com.google.android.vending.expansion.downloader.impl.a a2 = cVar.a(str);
        if (a2 != null && (str2 = a2.c) != null) {
            if (str.equals(str2)) {
                return false;
            }
            File file = new File(com.google.android.vending.expansion.downloader.d.a(this, str2));
            if (file.exists()) {
                file.delete();
            }
        }
        return true ^ com.google.android.vending.expansion.downloader.d.a((Context) this, str, j, true);
    }

    private void b(long j) {
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        if (alarmManager == null) {
            Log.e("LVLDL", "couldn't get alarm manager");
            return;
        }
        String i = i();
        Intent intent = new Intent("android.intent.action.DOWNLOAD_WAKEUP");
        intent.putExtra("EPI", this.y);
        intent.setClassName(getPackageName(), i);
        this.z = PendingIntent.getBroadcast(this, 0, intent, 1073741824);
        alarmManager.set(0, System.currentTimeMillis() + j, this.z);
    }

    private void o() {
        if (this.z != null) {
            AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
            if (alarmManager == null) {
                Log.e("LVLDL", "couldn't get alarm manager");
            } else {
                alarmManager.cancel(this.z);
                this.z = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final Service f5372a;

        a(Service service) {
            this.f5372a = service;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloaderService.this.f();
            if (!DownloaderService.this.n || DownloaderService.m()) {
                return;
            }
            Log.d("LVLDL", "InnerBroadcastReceiver Called");
            Intent intent2 = new Intent(context, this.f5372a.getClass());
            intent2.putExtra("EPI", DownloaderService.this.y);
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent2);
            } else {
                context.startService(intent2);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService
    protected void a(Intent intent) {
        int i;
        boolean z = true;
        b(true);
        try {
            c a2 = c.a(this);
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("EPI");
            if (pendingIntent != null) {
                this.x.a(pendingIntent);
                this.y = pendingIntent;
            } else {
                if (this.y == null) {
                    Log.e("LVLDL", "Downloader started in bad state without notification intent.");
                    return;
                }
                this.x.a(this.y);
            }
            if (a(a2, this.s)) {
                a((Context) this);
                return;
            }
            com.google.android.vending.expansion.downloader.impl.a[] a3 = a2.a();
            long j = 0;
            this.f5371a = 0L;
            this.b = 0L;
            this.c = a3.length;
            for (com.google.android.vending.expansion.downloader.impl.a aVar : a3) {
                if (aVar.h == 200 && !com.google.android.vending.expansion.downloader.d.a((Context) this, aVar.c, aVar.e, true)) {
                    aVar.h = 0;
                    aVar.f = 0L;
                }
                this.b += aVar.e;
                this.f5371a += aVar.f;
            }
            f();
            if (this.t == null) {
                this.t = new a(this);
                IntentFilter intentFilter = new IntentFilter(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION);
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                registerReceiver(this.t, intentFilter);
            }
            int length = a3.length;
            int i2 = 0;
            while (i2 < length) {
                com.google.android.vending.expansion.downloader.impl.a aVar2 = a3[i2];
                long j2 = aVar2.f;
                if (aVar2.h != 200) {
                    DownloadThread downloadThread = new DownloadThread(aVar2, this, this.x);
                    o();
                    b(5000L);
                    downloadThread.a();
                    o();
                }
                a2.d(aVar2);
                int i3 = aVar2.h;
                if (i3 != 200) {
                    if (i3 == 403) {
                        a((Context) this);
                        return;
                    }
                    if (i3 == 487) {
                        aVar2.f = j;
                        a2.c(aVar2);
                        i = 13;
                    } else if (i3 != 490) {
                        switch (i3) {
                            case 193:
                                z = false;
                                i = 7;
                                break;
                            case 194:
                            case 195:
                                i = 6;
                                break;
                            case 196:
                            case 197:
                                if (this.r != null && !this.r.isWifiEnabled()) {
                                    i = 8;
                                    break;
                                } else {
                                    i = 9;
                                    break;
                                }
                            default:
                                switch (i3) {
                                    case 498:
                                        i = 17;
                                        break;
                                    case 499:
                                        i = 14;
                                        break;
                                    default:
                                        z = false;
                                        i = 19;
                                        break;
                                }
                        }
                    } else {
                        i = 18;
                    }
                    if (z) {
                        b(60000L);
                    } else {
                        o();
                    }
                    this.x.a(i);
                    return;
                }
                this.f5371a += aVar2.f - j2;
                a2.a(this.s.versionCode, 0);
                i2++;
                j = 0;
            }
            this.x.a(5);
        } finally {
            b(false);
        }
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService, android.app.Service
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.t;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.t = null;
        }
        this.u.b(this);
        super.onDestroy();
    }

    public int a(c cVar) {
        if (!this.h) {
            return 2;
        }
        if (!this.j) {
            return 1;
        }
        int i = cVar.h;
        if (this.k) {
            return 5;
        }
        return (i & 1) != 0 ? 1 : 6;
    }

    protected void j() {
        Notification.Builder contentText = new Notification.Builder(this).setContentTitle("Download OBB Service").setContentText("Download obb service is running");
        contentText.setChannelId("DownladObbId");
        Notification build = contentText.build();
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("DownladObbId", "Download OBB", 4));
        startForeground(1, build);
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            this.s = getPackageManager().getPackageInfo(getPackageName(), 0);
            CharSequence applicationLabel = getPackageManager().getApplicationLabel(getApplicationInfo());
            if (Build.VERSION.SDK_INT >= 26) {
                j();
            }
            this.x = new com.google.android.vending.expansion.downloader.impl.b(this, applicationLabel);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* loaded from: classes2.dex */
    public static class GenerateSaveFileError extends Exception {
        private static final long serialVersionUID = 3465966015408936540L;
        String mMessage;
        int mStatus;

        public GenerateSaveFileError(int i, String str) {
            this.mStatus = i;
            this.mMessage = str;
        }
    }

    public String a(String str) {
        return com.google.android.vending.expansion.downloader.d.b(this) + File.separator + str + ".tmp";
    }

    public String a(String str, long j) throws GenerateSaveFileError {
        String a2 = a(str);
        File file = new File(a2);
        if (!com.google.android.vending.expansion.downloader.d.a()) {
            Log.d("LVLDL", "External media not mounted: " + a2);
            throw new GenerateSaveFileError(499, "external media is not yet mounted");
        }
        if (!file.exists()) {
            if (com.google.android.vending.expansion.downloader.d.a(com.google.android.vending.expansion.downloader.d.a(a2)) >= j) {
                return a2;
            }
            throw new GenerateSaveFileError(498, "insufficient space on external storage");
        }
        Log.d("LVLDL", "File already exists: " + a2);
        throw new GenerateSaveFileError(488, "requested destination file already exists");
    }

    public int k() {
        return this.o;
    }

    public int l() {
        return this.p;
    }

    public void a(long j) {
        long j2;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j3 = this.e;
        if (0 != j3) {
            float f = ((float) (j - this.d)) / ((float) (uptimeMillis - j3));
            float f2 = this.f;
            if (0.0f != f2) {
                this.f = (f * 0.005f) + (f2 * 0.995f);
            } else {
                this.f = f;
            }
            j2 = ((float) (this.b - j)) / this.f;
        } else {
            j2 = -1;
        }
        this.e = uptimeMillis;
        this.d = j;
        this.x.a(new DownloadProgressInfo(this.b, j, j2, this.f));
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService
    protected boolean e() {
        return c.a(this).g == 0;
    }

    @Override // com.google.android.vending.expansion.downloader.f
    public void d() {
        this.x.a();
    }

    @Override // com.google.android.vending.expansion.downloader.f
    public void a(Messenger messenger) {
        this.w = messenger;
        this.x.b(this.w);
    }
}
