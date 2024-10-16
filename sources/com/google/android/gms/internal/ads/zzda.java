package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import com.google.android.gms.internal.ads.zzbi;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes2.dex */
public class zzda {
    protected volatile Boolean b;
    private zzdy c;
    private static final ConditionVariable d = new ConditionVariable();

    /* renamed from: a, reason: collision with root package name */
    protected static volatile zzwo f3522a = null;
    private static volatile Random e = null;

    public zzda(zzdy zzdyVar) {
        this.c = zzdyVar;
        zzdyVar.zzch().execute(new abj(this));
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, null);
    }

    public final void zza(int i, int i2, long j, Exception exc) {
        try {
            d.block();
            if (!this.b.booleanValue() || f3522a == null) {
                return;
            }
            zzbi.zza.C0090zza zzd = zzbi.zza.zzs().zzl(this.c.f3628a.getPackageName()).zzd(j);
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                zzdmb.zza(exc, new PrintWriter(stringWriter));
                zzd.zzm(stringWriter.toString()).zzn(exc.getClass().getName());
            }
            zzws zzg = f3522a.zzg(((zzbi.zza) ((zzdob) zzd.zzaya())).toByteArray());
            zzg.zzby(i);
            if (i2 != -1) {
                zzg.zzbx(i2);
            }
            zzg.zzdj();
        } catch (Exception unused) {
        }
    }

    public static int zzcd() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return b().nextInt();
        } catch (RuntimeException unused) {
            return b().nextInt();
        }
    }

    private static Random b() {
        if (e == null) {
            synchronized (zzda.class) {
                if (e == null) {
                    e = new Random();
                }
            }
        }
        return e;
    }
}
