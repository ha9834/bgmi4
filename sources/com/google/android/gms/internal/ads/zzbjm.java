package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbkw;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public abstract class zzbjm implements zzblp {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("AppComponent.class")
    private static zzbjm f2883a;

    protected abstract zzcvs a(zzcwx zzcwxVar);

    public abstract Executor zzace();

    public abstract zzbbl zzacf();

    public abstract zzbtb zzacg();

    public abstract zzclc zzach();

    public abstract zzbkz zzaci();

    public abstract zzbod zzacj();

    public abstract zzbwt zzack();

    public abstract zzbxp zzacl();

    public abstract zzcdg zzacm();

    public abstract zzcqp zzacn();

    public static zzbjm zza(Context context, zzamp zzampVar, int i) {
        zzbjm zzd = zzd(context, i);
        zzd.zzach().zzb(zzampVar);
        return zzd;
    }

    @Deprecated
    public static zzbjm zzd(Context context, int i) {
        synchronized (zzbjm.class) {
            if (f2883a != null) {
                return f2883a;
            }
            return a(new zzbai(15000000, i, true, false), context, new zzbkb());
        }
    }

    @Deprecated
    private static zzbjm a(zzbai zzbaiVar, Context context, zzbkw.zza zzaVar) {
        zzbjm zzbjmVar;
        synchronized (zzbjm.class) {
            if (f2883a == null) {
                f2883a = new zzbkn().zzc(new zzbjn(new zzbjn.zza().zza(zzbaiVar).zzbo(context))).zza(new zzbkw(zzaVar)).zzaec();
                zzacu.initialize(context);
                zzk.zzlk().zzd(context, zzbaiVar);
                zzk.zzlm().initialize(context);
                zzk.zzlg().zzak(context);
                zzk.zzlg().zzal(context);
                zzawx.zzaj(context);
                zzk.zzlj().initialize(context);
                zzk.zzmb().initialize(context);
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue()) {
                    new zzcjr(context, zzbaiVar, new zzwj(new zzwo(context)), new zzcjc(new zzcja(context), f2883a.zzacf())).zzakp();
                }
            }
            zzbjmVar = f2883a;
        }
        return zzbjmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final zzcvs zza(zzarx zzarxVar) {
        return a(new zzcwx(zzarxVar));
    }
}
