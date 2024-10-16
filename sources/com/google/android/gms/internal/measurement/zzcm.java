package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class zzcm<T> {

    /* renamed from: a */
    private static final Object f4545a = new Object();

    @SuppressLint({"StaticFieldLeak"})
    private static Context b = null;
    private static boolean c = false;
    private static final AtomicInteger g = new AtomicInteger();
    private final zzct d;
    private final String e;
    private final T f;
    private volatile int h;
    private volatile T i;

    public static void zzr(Context context) {
        synchronized (f4545a) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (b != context) {
                synchronized (zzca.class) {
                    zzca.f4542a.clear();
                }
                synchronized (zzcs.class) {
                    zzcs.f4546a.clear();
                }
                synchronized (ax.class) {
                    ax.f4481a = null;
                }
                g.incrementAndGet();
                b = context;
            }
        }
    }

    abstract T a(Object obj);

    public static void a() {
        g.incrementAndGet();
    }

    private zzcm(zzct zzctVar, String str, T t) {
        Uri uri;
        this.h = -1;
        uri = zzctVar.b;
        if (uri == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.d = zzctVar;
        this.e = str;
        this.f = t;
    }

    private final String a(String str) {
        if (str != null && str.isEmpty()) {
            return this.e;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.e);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzrm() {
        String str;
        str = this.d.d;
        return a(str);
    }

    public final T get() {
        int i = g.get();
        if (this.h < i) {
            synchronized (this) {
                if (this.h < i) {
                    if (b == null) {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                    zzct zzctVar = this.d;
                    T b2 = b();
                    if (b2 == null && (b2 = c()) == null) {
                        b2 = this.f;
                    }
                    this.i = b2;
                    this.h = i;
                }
            }
        }
        return this.i;
    }

    @Nullable
    private final T b() {
        Uri uri;
        av a2;
        Object zzdd;
        Uri uri2;
        Uri uri3;
        zzct zzctVar = this.d;
        String str = (String) ax.a(b).zzdd("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
        if (!(str != null && zzbz.zzzw.matcher(str).matches())) {
            uri = this.d.b;
            if (uri != null) {
                Context context = b;
                uri2 = this.d.b;
                if (zzck.zza(context, uri2)) {
                    zzct zzctVar2 = this.d;
                    ContentResolver contentResolver = b.getContentResolver();
                    uri3 = this.d.b;
                    a2 = zzca.zza(contentResolver, uri3);
                } else {
                    a2 = null;
                }
            } else {
                Context context2 = b;
                zzct zzctVar3 = this.d;
                a2 = zzcs.a(context2, (String) null);
            }
            if (a2 != null && (zzdd = a2.zzdd(zzrm())) != null) {
                return a(zzdd);
            }
        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
            String valueOf = String.valueOf(zzrm());
            Log.d("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
        }
        return null;
    }

    @Nullable
    private final T c() {
        String str;
        zzct zzctVar = this.d;
        ax a2 = ax.a(b);
        str = this.d.c;
        Object zzdd = a2.zzdd(a(str));
        if (zzdd != null) {
            return a(zzdd);
        }
        return null;
    }

    public static zzcm<Long> b(zzct zzctVar, String str, long j) {
        return new ba(zzctVar, str, Long.valueOf(j));
    }

    public static zzcm<Boolean> b(zzct zzctVar, String str, boolean z) {
        return new az(zzctVar, str, Boolean.valueOf(z));
    }

    public static zzcm<Double> b(zzct zzctVar, String str, double d) {
        return new bc(zzctVar, str, Double.valueOf(d));
    }

    public static zzcm<String> b(zzct zzctVar, String str, String str2) {
        return new bb(zzctVar, str, str2);
    }

    public /* synthetic */ zzcm(zzct zzctVar, String str, Object obj, ba baVar) {
        this(zzctVar, str, obj);
    }
}
