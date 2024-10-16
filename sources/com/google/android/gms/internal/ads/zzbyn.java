package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbyn extends zzbpc {
    private final Executor f;
    private final zzbyt g;
    private final zzbzb h;
    private final zzbzl i;
    private final zzbyx j;
    private final zzbzc k;
    private final zzdte<zzccb> l;
    private final zzdte<zzcbz> m;
    private final zzdte<zzccg> n;
    private final zzdte<zzcbw> o;
    private final zzdte<zzccd> p;
    private zzcab q;
    private boolean r;
    private final zzavf s;
    private final zzdh t;
    private final zzbai u;
    private final Context v;

    public zzbyn(Executor executor, zzbyt zzbytVar, zzbzb zzbzbVar, zzbzl zzbzlVar, zzbyx zzbyxVar, zzbzc zzbzcVar, zzdte<zzccb> zzdteVar, zzdte<zzcbz> zzdteVar2, zzdte<zzccg> zzdteVar3, zzdte<zzcbw> zzdteVar4, zzdte<zzccd> zzdteVar5, zzavf zzavfVar, zzdh zzdhVar, zzbai zzbaiVar, Context context) {
        this.f = executor;
        this.g = zzbytVar;
        this.h = zzbzbVar;
        this.i = zzbzlVar;
        this.j = zzbyxVar;
        this.k = zzbzcVar;
        this.l = zzdteVar;
        this.m = zzdteVar2;
        this.n = zzdteVar3;
        this.o = zzdteVar4;
        this.p = zzdteVar5;
        this.s = zzavfVar;
        this.t = zzdhVar;
        this.u = zzbaiVar;
        this.v = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final void zzafl() {
        this.f.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.qc

            /* renamed from: a, reason: collision with root package name */
            private final zzbyn f2433a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2433a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2433a.b();
            }
        });
        if (this.g.zzahv() != 7) {
            Executor executor = this.f;
            zzbzb zzbzbVar = this.h;
            zzbzbVar.getClass();
            executor.execute(qd.a(zzbzbVar));
        }
        super.zzafl();
    }

    public final synchronized void zzfi(String str) {
        this.h.zzfi(str);
    }

    public final synchronized void zzahk() {
        if (this.r) {
            return;
        }
        this.h.zzahk();
    }

    public final synchronized void zzf(Bundle bundle) {
        this.h.zzf(bundle);
    }

    public final synchronized boolean zzh(Bundle bundle) {
        if (this.r) {
            return true;
        }
        boolean zzh = this.h.zzh(bundle);
        this.r = zzh;
        return zzh;
    }

    public final synchronized void zzg(Bundle bundle) {
        this.h.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final synchronized void destroy() {
        this.f.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.qe

            /* renamed from: a, reason: collision with root package name */
            private final zzbyn f2435a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2435a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2435a.a();
            }
        });
        super.destroy();
    }

    public final synchronized void zza(zzcab zzcabVar) {
        zzdc zzcg;
        this.q = zzcabVar;
        this.i.zzc(zzcabVar);
        this.h.zza(zzcabVar.zzafi(), zzcabVar.zzaiu(), zzcabVar.zzaiv(), zzcabVar, zzcabVar);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcrg)).booleanValue() && (zzcg = this.t.zzcg()) != null) {
            zzcg.zzb(zzcabVar.zzafi());
        }
        if (zzcabVar.zzais() != null) {
            zzcabVar.zzais().zza(this.s);
        }
    }

    public final synchronized void zzb(zzcab zzcabVar) {
        this.h.zza(zzcabVar.zzafi(), zzcabVar.zzait());
        if (zzcabVar.zzair() != null) {
            zzcabVar.zzair().setClickable(false);
            zzcabVar.zzair().removeAllViews();
        }
        if (zzcabVar.zzais() != null) {
            zzcabVar.zzais().zzb(this.s);
        }
        this.q = null;
    }

    public final synchronized void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwq)).booleanValue()) {
            this.i.zzd(this.q);
        }
        this.h.zza(view, view2, map, map2, z);
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.h.zza(view, motionEvent, view2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.r) {
            return;
        }
        if (z) {
            this.h.zza(view, map, map2);
            this.r = true;
            return;
        }
        if (!z) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcsl)).booleanValue() && map != null) {
                Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    View view2 = it.next().getValue().get();
                    if (view2 != null && zzx(view2)) {
                        this.h.zza(view, map, map2);
                        this.r = true;
                        return;
                    }
                }
            }
        }
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.h.setClickConfirmingView(view);
    }

    public final synchronized void zza(zzagd zzagdVar) {
        this.h.zza(zzagdVar);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.h.cancelUnconfirmedClick();
    }

    public final synchronized void zza(zzaak zzaakVar) {
        this.h.zza(zzaakVar);
    }

    public final synchronized void zza(zzaag zzaagVar) {
        this.h.zza(zzaagVar);
    }

    public final synchronized void zzro() {
        this.h.zzro();
    }

    public final synchronized void recordCustomClickGesture() {
        if (this.q == null) {
            zzawz.zzdp("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z = this.q instanceof zzbzi;
            this.f.execute(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.qf

                /* renamed from: a, reason: collision with root package name */
                private final zzbyn f2436a;
                private final boolean b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2436a = this;
                    this.b = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2436a.a(this.b);
                }
            });
        }
    }

    public static boolean zzx(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    public final boolean zzahs() {
        return this.j.zzaif();
    }

    private final void a(String str) {
        String str2;
        View view;
        if (this.j.zzaih()) {
            zzbgz zzaia = this.g.zzaia();
            zzbgz zzahz = this.g.zzahz();
            if (zzaia == null && zzahz == null) {
                return;
            }
            boolean z = zzaia != null;
            boolean z2 = zzahz != null;
            if (z) {
                str2 = null;
            } else if (z2) {
                zzaia = zzahz;
                str2 = "javascript";
            } else {
                zzaia = null;
                str2 = null;
            }
            if (zzaia.getWebView() != null && zzk.zzlv().zzl(this.v)) {
                int i = this.u.zzdzc;
                int i2 = this.u.zzdzd;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i);
                sb.append(".");
                sb.append(i2);
                IObjectWrapper zza = zzk.zzlv().zza(sb.toString(), zzaia.getWebView(), "", "javascript", str2, str);
                if (zza == null) {
                    return;
                }
                this.g.zzan(zza);
                zzaia.zzam(zza);
                if (z2 && (view = zzahz.getView()) != null) {
                    zzk.zzlv().zza(zza, view);
                }
                zzk.zzlv().zzaa(zza);
            }
        }
    }

    public final void zzy(View view) {
        IObjectWrapper zzaib = this.g.zzaib();
        boolean z = this.g.zzaia() != null;
        if (!this.j.zzaih() || zzaib == null || !z || view == null) {
            return;
        }
        zzk.zzlv().zza(zzaib, view);
    }

    public final zzaee zzrp() {
        return new zzbym(this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(boolean z) {
        this.h.zza(this.q.zzafi(), this.q.zzait(), this.q.zzaiu(), z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.h.destroy();
        this.g.destroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        try {
            switch (this.g.zzahv()) {
                case 1:
                    if (this.k.zzaii() != null) {
                        a("Google");
                        this.k.zzaii().zza(this.l.get());
                        return;
                    }
                    return;
                case 2:
                    if (this.k.zzaij() != null) {
                        a("Google");
                        this.k.zzaij().zza(this.m.get());
                        return;
                    }
                    return;
                case 3:
                    if (this.k.zzfn(this.g.getCustomTemplateId()) != null) {
                        this.k.zzfn(this.g.getCustomTemplateId()).zzb(this.p.get());
                        return;
                    }
                    return;
                case 4:
                case 5:
                default:
                    zzawz.zzen("Wrong native template id!");
                    return;
                case 6:
                    if (this.k.zzaik() != null) {
                        a("Google");
                        this.k.zzaik().zza(this.n.get());
                        return;
                    }
                    return;
                case 7:
                    if (this.k.zzaim() != null) {
                        this.k.zzaim().zza(this.o.get());
                        return;
                    }
                    return;
            }
        } catch (RemoteException e) {
            zzawz.zzc("RemoteException when notifyAdLoad is called", e);
        }
    }
}
