package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzada;
import com.google.android.gms.internal.ads.zzajh;
import com.google.android.gms.internal.ads.zzajs;
import com.google.android.gms.internal.ads.zzalk;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzasg;
import com.google.android.gms.internal.ads.zzavg;
import com.google.android.gms.internal.ads.zzawm;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzaya;
import com.google.android.gms.internal.ads.zzayi;
import com.google.android.gms.internal.ads.zzazg;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzbbs;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzbfs;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzuq;
import com.google.android.gms.internal.ads.zzvm;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzwi;

@zzard
/* loaded from: classes.dex */
public final class zzk {

    /* renamed from: a, reason: collision with root package name */
    private static zzk f1164a = new zzk();
    private final zzazh A;
    private final zzaqd B;
    private final zzwi C;
    private final zzavg D;
    private final zzazp E;
    private final zzbfs F;
    private final zzbbz G;
    private final com.google.android.gms.ads.internal.overlay.zza b;
    private final zzare c;
    private final zzm d;
    private final zzaqw e;
    private final zzaxi f;
    private final zzbhf g;
    private final zzaxo h;
    private final zzuq i;
    private final zzawm j;
    private final zzaya k;
    private final zzvm l;
    private final zzvn m;
    private final Clock n;
    private final zzd o;
    private final zzada p;
    private final zzayi q;
    private final zzasg r;
    private final zzajs s;
    private final zzbbs t;
    private final zzajh u;
    private final zzalk v;
    private final zzazg w;
    private final zzv x;
    private final zzw y;
    private final zzamn z;

    protected zzk() {
        this(new com.google.android.gms.ads.internal.overlay.zza(), new zzare(), new zzm(), new zzaqw(), new zzaxi(), new zzbhf(), zzaxo.zzcv(Build.VERSION.SDK_INT), new zzuq(), new zzawm(), new zzaya(), new zzvm(), new zzvn(), DefaultClock.getInstance(), new zzd(), new zzada(), new zzayi(), new zzasg(), new zzajs(), new zzbbs(), new zzalk(), new zzazg(), new zzv(), new zzw(), new zzamn(), new zzazh(), new zzaqd(), new zzwi(), new zzavg(), new zzazp(), new zzbfs(), new zzbbz());
    }

    private zzk(com.google.android.gms.ads.internal.overlay.zza zzaVar, zzare zzareVar, zzm zzmVar, zzaqw zzaqwVar, zzaxi zzaxiVar, zzbhf zzbhfVar, zzaxo zzaxoVar, zzuq zzuqVar, zzawm zzawmVar, zzaya zzayaVar, zzvm zzvmVar, zzvn zzvnVar, Clock clock, zzd zzdVar, zzada zzadaVar, zzayi zzayiVar, zzasg zzasgVar, zzajs zzajsVar, zzbbs zzbbsVar, zzalk zzalkVar, zzazg zzazgVar, zzv zzvVar, zzw zzwVar, zzamn zzamnVar, zzazh zzazhVar, zzaqd zzaqdVar, zzwi zzwiVar, zzavg zzavgVar, zzazp zzazpVar, zzbfs zzbfsVar, zzbbz zzbbzVar) {
        this.b = zzaVar;
        this.c = zzareVar;
        this.d = zzmVar;
        this.e = zzaqwVar;
        this.f = zzaxiVar;
        this.g = zzbhfVar;
        this.h = zzaxoVar;
        this.i = zzuqVar;
        this.j = zzawmVar;
        this.k = zzayaVar;
        this.l = zzvmVar;
        this.m = zzvnVar;
        this.n = clock;
        this.o = zzdVar;
        this.p = zzadaVar;
        this.q = zzayiVar;
        this.r = zzasgVar;
        this.s = zzajsVar;
        this.t = zzbbsVar;
        this.u = new zzajh();
        this.v = zzalkVar;
        this.w = zzazgVar;
        this.x = zzvVar;
        this.y = zzwVar;
        this.z = zzamnVar;
        this.A = zzazhVar;
        this.B = zzaqdVar;
        this.C = zzwiVar;
        this.D = zzavgVar;
        this.E = zzazpVar;
        this.F = zzbfsVar;
        this.G = zzbbzVar;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zzle() {
        return f1164a.b;
    }

    public static zzm zzlf() {
        return f1164a.d;
    }

    public static zzaxi zzlg() {
        return f1164a.f;
    }

    public static zzbhf zzlh() {
        return f1164a.g;
    }

    public static zzaxo zzli() {
        return f1164a.h;
    }

    public static zzuq zzlj() {
        return f1164a.i;
    }

    public static zzawm zzlk() {
        return f1164a.j;
    }

    public static zzaya zzll() {
        return f1164a.k;
    }

    public static zzvn zzlm() {
        return f1164a.m;
    }

    public static Clock zzln() {
        return f1164a.n;
    }

    public static zzd zzlo() {
        return f1164a.o;
    }

    public static zzada zzlp() {
        return f1164a.p;
    }

    public static zzayi zzlq() {
        return f1164a.q;
    }

    public static zzasg zzlr() {
        return f1164a.r;
    }

    public static zzbbs zzls() {
        return f1164a.t;
    }

    public static zzalk zzlt() {
        return f1164a.v;
    }

    public static zzazg zzlu() {
        return f1164a.w;
    }

    public static zzaqd zzlv() {
        return f1164a.B;
    }

    public static zzv zzlw() {
        return f1164a.x;
    }

    public static zzw zzlx() {
        return f1164a.y;
    }

    public static zzamn zzly() {
        return f1164a.z;
    }

    public static zzazh zzlz() {
        return f1164a.A;
    }

    public static zzwi zzma() {
        return f1164a.C;
    }

    public static zzazp zzmb() {
        return f1164a.E;
    }

    public static zzbfs zzmc() {
        return f1164a.F;
    }

    public static zzbbz zzmd() {
        return f1164a.G;
    }

    public static zzavg zzme() {
        return f1164a.D;
    }
}
