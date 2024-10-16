package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcxv {
    public final zzady zzdgs;
    public final zzyd zzdll;
    public final zzaiy zzdne;
    public final zzxz zzghg;
    public final zzzy zzgkz;
    public final zzacd zzgla;
    public final String zzglb;
    public final ArrayList<String> zzglc;
    public final ArrayList<String> zzgld;
    public final String zzgle;
    public final String zzglf;
    public final int zzglg;
    public final PublisherAdViewOptions zzglh;
    public final zzzs zzgli;
    public final Set<String> zzglj;

    private zzcxv(zzcxx zzcxxVar) {
        zzacd zzacdVar;
        this.zzdll = zzcxx.a(zzcxxVar);
        this.zzglb = zzcxx.b(zzcxxVar);
        this.zzgkz = zzcxx.c(zzcxxVar);
        this.zzghg = new zzxz(zzcxx.l(zzcxxVar).versionCode, zzcxx.l(zzcxxVar).zzcgn, zzcxx.l(zzcxxVar).extras, zzcxx.l(zzcxxVar).zzcgo, zzcxx.l(zzcxxVar).zzcgp, zzcxx.l(zzcxxVar).zzcgq, zzcxx.l(zzcxxVar).zzcgr, zzcxx.l(zzcxxVar).zzbqn || zzcxx.m(zzcxxVar), zzcxx.l(zzcxxVar).zzcgs, zzcxx.l(zzcxxVar).zzcgt, zzcxx.l(zzcxxVar).zzmw, zzcxx.l(zzcxxVar).zzcgu, zzcxx.l(zzcxxVar).zzcgv, zzcxx.l(zzcxxVar).zzcgw, zzcxx.l(zzcxxVar).zzcgx, zzcxx.l(zzcxxVar).zzcgy, zzcxx.l(zzcxxVar).zzcgz, zzcxx.l(zzcxxVar).zzcha, zzcxx.l(zzcxxVar).zzchb, zzcxx.l(zzcxxVar).zzchc, zzcxx.l(zzcxxVar).zzchd);
        zzady zzadyVar = null;
        if (zzcxx.n(zzcxxVar) != null) {
            zzacdVar = zzcxx.n(zzcxxVar);
        } else {
            zzacdVar = zzcxx.o(zzcxxVar) != null ? zzcxx.o(zzcxxVar).zzcyn : null;
        }
        this.zzgla = zzacdVar;
        this.zzglc = zzcxx.d(zzcxxVar);
        this.zzgld = zzcxx.e(zzcxxVar);
        if (zzcxx.d(zzcxxVar) != null) {
            if (zzcxx.o(zzcxxVar) == null) {
                zzadyVar = new zzady(new NativeAdOptions.Builder().build());
            } else {
                zzadyVar = zzcxx.o(zzcxxVar);
            }
        }
        this.zzdgs = zzadyVar;
        this.zzgle = zzcxx.f(zzcxxVar);
        this.zzglf = zzcxx.g(zzcxxVar);
        this.zzglg = zzcxx.h(zzcxxVar);
        this.zzglh = zzcxx.i(zzcxxVar);
        this.zzgli = zzcxx.j(zzcxxVar);
        this.zzdne = zzcxx.k(zzcxxVar);
        this.zzglj = zzcxxVar.zzglj;
    }

    public final zzaga zzamn() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzglh;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzku();
    }
}
