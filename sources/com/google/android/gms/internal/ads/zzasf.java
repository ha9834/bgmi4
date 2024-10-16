package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class zzasf {
    private int A;
    private String B;
    private boolean C;

    /* renamed from: a, reason: collision with root package name */
    private int f2792a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private String g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private double m;
    private boolean n;
    private String o;
    private String p;
    private boolean q;
    private boolean r;
    private String s;
    private boolean t;
    private final boolean u;
    private boolean v;
    private String w;
    private String x;
    private float y;
    private int z;

    public zzasf(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        a(context);
        b(context);
        c(context);
        Locale locale = Locale.getDefault();
        this.q = a(packageManager, "geo:0,0?q=donuts") != null;
        this.r = a(packageManager, "http://www.google.com") != null;
        this.s = locale.getCountry();
        zzyt.zzpa();
        this.t = zzazt.zzwx();
        this.u = DeviceProperties.isLatchsky(context);
        this.v = DeviceProperties.isSidewinder(context);
        this.w = locale.getLanguage();
        this.x = a(context, packageManager);
        this.B = d(context);
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        this.y = displayMetrics.density;
        this.z = displayMetrics.widthPixels;
        this.A = displayMetrics.heightPixels;
    }

    public zzasf(Context context, zzase zzaseVar) {
        a(context);
        b(context);
        c(context);
        this.o = Build.FINGERPRINT;
        this.p = Build.DEVICE;
        this.C = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzads.zzj(context);
        this.q = zzaseVar.zzdpf;
        this.r = zzaseVar.zzdpg;
        this.s = zzaseVar.zzdpi;
        this.t = zzaseVar.zzdpj;
        this.u = zzaseVar.zzdpk;
        this.v = zzaseVar.zzdpl;
        this.w = zzaseVar.zzdpo;
        this.x = zzaseVar.zzdpp;
        this.B = zzaseVar.zzdpq;
        this.y = zzaseVar.zzbtx;
        this.z = zzaseVar.zzdlt;
        this.A = zzaseVar.zzdlu;
    }

    private final void a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.f2792a = audioManager.getMode();
                this.b = audioManager.isMusicActive();
                this.c = audioManager.isSpeakerphoneOn();
                this.d = audioManager.getStreamVolume(3);
                this.e = audioManager.getRingerMode();
                this.f = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzk.zzlk().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.f2792a = -2;
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 2;
        this.f = 0;
    }

    @TargetApi(16)
    private final void b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.g = telephonyManager.getNetworkOperator();
        this.i = telephonyManager.getNetworkType();
        this.j = telephonyManager.getPhoneType();
        this.h = -2;
        this.k = false;
        this.l = -1;
        zzk.zzlg();
        if (zzaxi.zzp(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.h = activeNetworkInfo.getType();
                this.l = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.h = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.k = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.m = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) / registerReceiver.getIntExtra("scale", -1);
            this.n = intExtra == 2 || intExtra == 5;
        } else {
            this.m = -1.0d;
            this.n = false;
        }
    }

    private static String d(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo == null) {
                return null;
            }
            int i = packageInfo.versionCode;
            String str = packageInfo.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo a2 = a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a2 == null || (activityInfo = a2.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo == null) {
                return null;
            }
            int i = packageInfo.versionCode;
            String str = activityInfo.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static ResolveInfo a(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzk.zzlk().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    public final zzase zzty() {
        return new zzase(this.f2792a, this.q, this.r, this.g, this.s, this.t, this.u, this.v, this.b, this.c, this.w, this.x, this.B, this.d, this.h, this.i, this.j, this.e, this.f, this.y, this.z, this.A, this.m, this.n, this.k, this.l, this.o, this.C, this.p);
    }
}
