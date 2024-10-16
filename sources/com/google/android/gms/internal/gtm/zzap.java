package com.google.android.gms.internal.gtm;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.intlgame.core.INTLMethodID;

@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes2.dex */
public class zzap {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzap f4387a;
    private final Context b;
    private final Context c;
    private final Clock d;
    private final zzbq e;
    private final zzci f;
    private final com.google.android.gms.analytics.zzk g;
    private final zzae h;
    private final zzbv i;
    private final zzda j;
    private final zzcm k;
    private final GoogleAnalytics l;
    private final zzbh m;
    private final zzad n;
    private final zzba o;
    private final zzbu p;

    private zzap(zzar zzarVar) {
        Context applicationContext = zzarVar.getApplicationContext();
        Preconditions.checkNotNull(applicationContext, "Application context can't be null");
        Context zzdc = zzarVar.zzdc();
        Preconditions.checkNotNull(zzdc);
        this.b = applicationContext;
        this.c = zzdc;
        this.d = DefaultClock.getInstance();
        this.e = new zzbq(this);
        zzci zzciVar = new zzci(this);
        zzciVar.zzag();
        this.f = zzciVar;
        zzci zzco = zzco();
        String str = zzao.VERSION;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_DATA_PROTECTION_ACCEPTANCE);
        sb.append("Google Analytics ");
        sb.append(str);
        sb.append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        zzco.zzs(sb.toString());
        zzcm zzcmVar = new zzcm(this);
        zzcmVar.zzag();
        this.k = zzcmVar;
        zzda zzdaVar = new zzda(this);
        zzdaVar.zzag();
        this.j = zzdaVar;
        zzae zzaeVar = new zzae(this, zzarVar);
        zzbh zzbhVar = new zzbh(this);
        zzad zzadVar = new zzad(this);
        zzba zzbaVar = new zzba(this);
        zzbu zzbuVar = new zzbu(this);
        com.google.android.gms.analytics.zzk zzb = com.google.android.gms.analytics.zzk.zzb(applicationContext);
        zzb.zza(new h(this));
        this.g = zzb;
        GoogleAnalytics googleAnalytics = new GoogleAnalytics(this);
        zzbhVar.zzag();
        this.m = zzbhVar;
        zzadVar.zzag();
        this.n = zzadVar;
        zzbaVar.zzag();
        this.o = zzbaVar;
        zzbuVar.zzag();
        this.p = zzbuVar;
        zzbv zzbvVar = new zzbv(this);
        zzbvVar.zzag();
        this.i = zzbvVar;
        zzaeVar.zzag();
        this.h = zzaeVar;
        googleAnalytics.zzag();
        this.l = googleAnalytics;
        zzaeVar.start();
    }

    public static zzap zzc(Context context) {
        Preconditions.checkNotNull(context);
        if (f4387a == null) {
            synchronized (zzap.class) {
                if (f4387a == null) {
                    Clock defaultClock = DefaultClock.getInstance();
                    long elapsedRealtime = defaultClock.elapsedRealtime();
                    zzap zzapVar = new zzap(new zzar(context));
                    f4387a = zzapVar;
                    GoogleAnalytics.zzah();
                    long elapsedRealtime2 = defaultClock.elapsedRealtime() - elapsedRealtime;
                    long longValue = zzby.zzaap.get().longValue();
                    if (elapsedRealtime2 > longValue) {
                        zzapVar.zzco().zzc("Slow initialization (ms)", Long.valueOf(elapsedRealtime2), Long.valueOf(longValue));
                    }
                }
            }
        }
        return f4387a;
    }

    public final Context getContext() {
        return this.b;
    }

    public final Context zzdc() {
        return this.c;
    }

    public final Clock zzcn() {
        return this.d;
    }

    public final zzbq zzcp() {
        return this.e;
    }

    public final zzci zzco() {
        a(this.f);
        return this.f;
    }

    public final zzci zzdd() {
        return this.f;
    }

    public final com.google.android.gms.analytics.zzk zzcq() {
        Preconditions.checkNotNull(this.g);
        return this.g;
    }

    public final zzae zzcs() {
        a(this.h);
        return this.h;
    }

    public final zzbv zzct() {
        a(this.i);
        return this.i;
    }

    public final GoogleAnalytics zzde() {
        Preconditions.checkNotNull(this.l);
        Preconditions.checkArgument(this.l.isInitialized(), "Analytics instance not initialized");
        return this.l;
    }

    public final zzda zzcu() {
        a(this.j);
        return this.j;
    }

    public final zzcm zzcv() {
        a(this.k);
        return this.k;
    }

    public final zzcm zzdf() {
        zzcm zzcmVar = this.k;
        if (zzcmVar == null || !zzcmVar.isInitialized()) {
            return null;
        }
        return this.k;
    }

    public final zzad zzdg() {
        a(this.n);
        return this.n;
    }

    public final zzbh zzdh() {
        a(this.m);
        return this.m;
    }

    public final zzba zzcy() {
        a(this.o);
        return this.o;
    }

    public final zzbu zzcz() {
        return this.p;
    }

    private static void a(zzan zzanVar) {
        Preconditions.checkNotNull(zzanVar, "Analytics service not created/initialized");
        Preconditions.checkArgument(zzanVar.isInitialized(), "Analytics service not initialized");
    }
}
