package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class mk extends zzcvs {

    /* renamed from: a, reason: collision with root package name */
    private zzcwx f2342a;
    private zzdtu<zzcvo> b;
    private zzdtu<String> c;
    private zzdtu<zzcvy> d;
    private zzdtu<zzcwc> e;
    private zzdtu<zzcwj> f;
    private zzdtu<Boolean> g;
    private zzdtu<ApplicationInfo> h;
    private zzdtu<zzcwq> i;
    private zzdtu<zzcwu> j;
    private zzdtu<zzcxh> k;
    private zzdtu<String> l;
    private zzdtu<zzcez> m;
    private zzdtu<zzcez> n;
    private zzdtu<zzcez> o;
    private zzdtu<zzcez> p;
    private zzdtu<Map<zzczs, zzcez>> q;
    private zzdtu<Set<zzbuz<zzczz>>> r;
    private zzdtu<Set<zzbuz<zzczz>>> s;
    private zzdtu t;
    private zzdtu<zzczt> u;
    private final /* synthetic */ zzbkc v;

    private mk(zzbkc zzbkcVar, zzcwx zzcwxVar) {
        zzdtu zzdtuVar;
        zzdtu zzdtuVar2;
        zzdtu zzdtuVar3;
        zzdtu zzdtuVar4;
        zzdtu zzdtuVar5;
        zzdtu zzdtuVar6;
        zzdtu zzdtuVar7;
        zzdtu zzdtuVar8;
        zzdtu zzdtuVar9;
        this.v = zzbkcVar;
        this.f2342a = zzcwxVar;
        zzbln zzafa = zzbln.zzafa();
        zzdtuVar = this.v.h;
        zzdtuVar2 = this.v.d;
        this.b = new zzcvr(zzafa, zzdtuVar, zzdtuVar2, zzcyx.zzamw());
        this.c = new zzcwy(zzcwxVar);
        zzbjy zzacs = zzbjy.zzacs();
        zzdtuVar3 = this.v.h;
        this.d = new zzcwa(zzacs, zzdtuVar3, this.c, zzcyx.zzamw());
        zzblj zzaes = zzblj.zzaes();
        zzcyx zzamw = zzcyx.zzamw();
        zzdtuVar4 = this.v.h;
        this.e = new zzcwe(zzaes, zzamw, zzdtuVar4);
        this.f = new zzcwl(zzblk.zzaeu(), zzcyx.zzamw(), this.c);
        this.g = new zzcxa(zzcwxVar);
        this.h = new zzcwz(zzcwxVar);
        zzbll zzaew = zzbll.zzaew();
        zzdtuVar5 = this.v.d;
        this.i = new zzcws(zzaew, zzdtuVar5, this.g, this.h);
        zzblm zzaey = zzblm.zzaey();
        zzdtuVar6 = this.v.d;
        zzdtuVar7 = this.v.h;
        this.j = new zzcww(zzaey, zzdtuVar6, zzdtuVar7);
        this.k = new zzcxj(zzcyx.zzamw());
        this.l = new zzcxb(zzcwxVar);
        this.m = zzdth.zzao(zzcet.zzajt());
        this.n = zzdth.zzao(zzces.zzajs());
        this.o = zzdth.zzao(zzceu.zzaju());
        this.p = zzdth.zzao(zzcev.zzajv());
        this.q = zzdtk.zzho(4).zza(zzczs.GMS_SIGNALS, this.m).zza(zzczs.BUILD_URL, this.n).zza(zzczs.HTTP, this.o).zza(zzczs.PRE_PROCESS, this.p).zzbbf();
        zzdtu<String> zzdtuVar10 = this.l;
        zzdtuVar8 = this.v.h;
        this.r = zzdth.zzao(new zzcew(zzdtuVar10, zzdtuVar8, zzcyx.zzamw(), this.q));
        this.s = zzdtq.zzao(0, 1).zzar(this.r).zzbbh();
        this.t = zzdab.zzan(this.s);
        zzcyx zzamw2 = zzcyx.zzamw();
        zzdtuVar9 = this.v.d;
        this.u = zzdth.zzao(zzdaa.zzq(zzamw2, zzdtuVar9, this.t));
    }

    private final zzcwn a() {
        return new zzcwn(zzbli.zzaer(), zzcyx.zzamx(), (List) zzdto.zza(this.f2342a.zzamg(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzcvu b() {
        return new zzcvu(zzbln.zzafb(), zzcyx.zzamx(), (String) zzdto.zza(this.f2342a.zzamd(), "Cannot return null from a non-@Nullable @Provides method"), this.f2342a.zzame());
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final zzcvb<JSONObject> zzadp() {
        zzdtu zzdtuVar;
        zzdtu zzdtuVar2;
        zzdtu zzdtuVar3;
        zzdtu zzdtuVar4;
        zzbjn zzbjnVar;
        zzdtu zzdtuVar5;
        zzbjn zzbjnVar2;
        zzdtu zzdtuVar6;
        zzdtu zzdtuVar7;
        zzdtu zzdtuVar8;
        zzbjn zzbjnVar3;
        zzbjn zzbjnVar4;
        zzdtu zzdtuVar9;
        zzbbl zzamx = zzcyx.zzamx();
        zzdtp zzhp = zzdtp.zzhp(11);
        zzcwj zzcwjVar = new zzcwj(zzblk.zzaev(), zzcyx.zzamx(), zzcwy.zzb(this.f2342a));
        zzdtuVar = this.v.d;
        zzdtp zzas = zzhp.zzas((zzcva) zzdto.zza(new zzctz(zzcwjVar, 0L, (ScheduledExecutorService) zzdtuVar.get()), "Cannot return null from a non-@Nullable @Provides method"));
        zzamh zzaex = zzbll.zzaex();
        zzdtuVar2 = this.v.d;
        zzcwq zzcwqVar = new zzcwq(zzaex, (ScheduledExecutorService) zzdtuVar2.get(), this.f2342a.zzamf(), zzcwz.zzc(this.f2342a));
        zzdtuVar3 = this.v.d;
        zzdtp zzas2 = zzas.zzas((zzcva) zzdto.zza(new zzctz(zzcwqVar, ((Long) zzyt.zzpe().zzd(zzacu.zzcsq)).longValue(), (ScheduledExecutorService) zzdtuVar3.get()), "Cannot return null from a non-@Nullable @Provides method"));
        zzaql zzaez = zzblm.zzaez();
        zzdtuVar4 = this.v.d;
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) zzdtuVar4.get();
        zzbjnVar = this.v.f2898a;
        zzcwu zzcwuVar = new zzcwu(zzaez, scheduledExecutorService, zzbjq.zza(zzbjnVar));
        zzdtuVar5 = this.v.d;
        zzdtp zzas3 = zzas2.zzas((zzcva) zzdto.zza(new zzctz(zzcwuVar, ((Long) zzyt.zzpe().zzd(zzacu.zzctg)).longValue(), (ScheduledExecutorService) zzdtuVar5.get()), "Cannot return null from a non-@Nullable @Provides method"));
        zzawi zzafb = zzbln.zzafb();
        zzbjnVar2 = this.v.f2898a;
        Context zza = zzbjq.zza(zzbjnVar2);
        zzdtuVar6 = this.v.d;
        zzcvo zzcvoVar = new zzcvo(zzafb, zza, (ScheduledExecutorService) zzdtuVar6.get(), zzcyx.zzamx());
        zzdtuVar7 = this.v.d;
        zzdtp zzas4 = zzas3.zzas((zzcva) zzdto.zza(new zzctz(zzcvoVar, 0L, (ScheduledExecutorService) zzdtuVar7.get()), "Cannot return null from a non-@Nullable @Provides method"));
        zzcxh zzcxhVar = new zzcxh(zzcyx.zzamx());
        zzdtuVar8 = this.v.d;
        zzdtp zzas5 = zzas4.zzas((zzcva) zzdto.zza(new zzctz(zzcxhVar, 0L, (ScheduledExecutorService) zzdtuVar8.get()), "Cannot return null from a non-@Nullable @Provides method")).zzas(zzcxe.zzamj());
        zzbjnVar3 = this.v.f2898a;
        zzdtp zzas6 = zzas5.zzas(new zzcvy(null, zzbjq.zza(zzbjnVar3), zzcwy.zzb(this.f2342a), zzcyx.zzamx()));
        zzwa zzaet = zzblj.zzaet();
        zzbbl zzamx2 = zzcyx.zzamx();
        zzbjnVar4 = this.v.f2898a;
        zzdtp zzas7 = zzas6.zzas(new zzcwc(zzaet, zzamx2, zzbjq.zza(zzbjnVar4))).zzas(a()).zzas(b());
        zzdtuVar9 = this.v.q;
        return new zzcvb<>(zzamx, zzas7.zzas((zzcva) zzdtuVar9.get()).zzbbg());
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final zzcvb<JSONObject> zzadq() {
        zzdtu zzdtuVar;
        zzdtuVar = this.v.q;
        return zzcxf.zza(zzdtuVar.get(), b(), a(), zzdth.zzap(this.b), zzdth.zzap(this.d), zzdth.zzap(this.e), zzdth.zzap(this.f), zzdth.zzap(this.i), zzdth.zzap(this.j), zzdth.zzap(this.k), zzcyx.zzamx());
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final zzczt zzadr() {
        return this.u.get();
    }
}
