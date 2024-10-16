package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcdp {

    /* renamed from: a, reason: collision with root package name */
    private final zzbri f3197a;
    private final zzbse b;
    private final zzbss c;
    private final zzbsv d;
    private final zzbtp e;
    private final Executor f;
    private final zzbva g;
    private final zzbmn h;
    private final com.google.android.gms.ads.internal.zzb i;
    private final zzbry j;
    private final zzavb k;
    private final zzdh l;
    private final zzbtl m;

    public zzcdp(zzbri zzbriVar, zzbse zzbseVar, zzbss zzbssVar, zzbsv zzbsvVar, zzbtp zzbtpVar, Executor executor, zzbva zzbvaVar, zzbmn zzbmnVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbry zzbryVar, @Nullable zzavb zzavbVar, zzdh zzdhVar, zzbtl zzbtlVar) {
        this.f3197a = zzbriVar;
        this.b = zzbseVar;
        this.c = zzbssVar;
        this.d = zzbsvVar;
        this.e = zzbtpVar;
        this.f = executor;
        this.g = zzbvaVar;
        this.h = zzbmnVar;
        this.i = zzbVar;
        this.j = zzbryVar;
        this.k = zzavbVar;
        this.l = zzdhVar;
        this.m = zzbtlVar;
    }

    public final void zzb(final zzbgz zzbgzVar, boolean z) {
        zzdc zzcg;
        zzbgzVar.zzaai().zza(new zzxr(this) { // from class: com.google.android.gms.internal.ads.sd

            /* renamed from: a, reason: collision with root package name */
            private final zzcdp f2484a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2484a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzxr
            public final void onAdClicked() {
                this.f2484a.b();
            }
        }, this.c, this.d, new zzagx(this) { // from class: com.google.android.gms.internal.ads.se

            /* renamed from: a, reason: collision with root package name */
            private final zzcdp f2485a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2485a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzagx
            public final void onAppEvent(String str, String str2) {
                this.f2485a.a(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzu(this) { // from class: com.google.android.gms.internal.ads.sf

            /* renamed from: a, reason: collision with root package name */
            private final zzcdp f2486a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2486a = this;
            }

            @Override // com.google.android.gms.ads.internal.overlay.zzu
            public final void zztq() {
                this.f2486a.a();
            }
        }, z, null, this.i, new sm(this), this.k);
        zzbgzVar.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.google.android.gms.internal.ads.sg

            /* renamed from: a, reason: collision with root package name */
            private final zzcdp f2487a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2487a = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f2487a.a(view, motionEvent);
            }
        });
        zzbgzVar.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.gms.internal.ads.sh

            /* renamed from: a, reason: collision with root package name */
            private final zzcdp f2488a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2488a = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2488a.a(view);
            }
        });
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcrg)).booleanValue() && (zzcg = this.l.zzcg()) != null) {
            zzcg.zzb(zzbgzVar.getView());
        }
        this.g.zza(zzbgzVar, this.f);
        this.g.zza(new zzue(zzbgzVar) { // from class: com.google.android.gms.internal.ads.si

            /* renamed from: a, reason: collision with root package name */
            private final zzbgz f2489a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2489a = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzue
            public final void zza(zzud zzudVar) {
                this.f2489a.zzaai().zza(zzudVar.zzbtr.left, zzudVar.zzbtr.top, false);
            }
        }, this.f);
        this.g.zzq(zzbgzVar.getView());
        zzbgzVar.zza("/trackActiveViewUnit", new zzaho(this, zzbgzVar) { // from class: com.google.android.gms.internal.ads.sj

            /* renamed from: a, reason: collision with root package name */
            private final zzcdp f2490a;
            private final zzbgz b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2490a = this;
                this.b = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void zza(Object obj, Map map) {
                this.f2490a.a(this.b, (zzbgz) obj, map);
            }
        });
        this.h.zzq(zzbgzVar);
        this.j.zza(new zzbvp(zzbgzVar) { // from class: com.google.android.gms.internal.ads.sk

            /* renamed from: a, reason: collision with root package name */
            private final zzbgz f2491a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2491a = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbvp
            public final void zzagy() {
                this.f2491a.destroy();
            }
        }, this.f);
    }

    public static zzbbh<?> zza(zzbgz zzbgzVar, String str, String str2) {
        final zzbbr zzbbrVar = new zzbbr();
        zzbgzVar.zzaai().zza(new zzbij(zzbbrVar) { // from class: com.google.android.gms.internal.ads.sl

            /* renamed from: a, reason: collision with root package name */
            private final zzbbr f2492a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2492a = zzbbrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zzae(boolean z) {
                zzbbr zzbbrVar2 = this.f2492a;
                if (z) {
                    zzbbrVar2.set(null);
                } else {
                    zzbbrVar2.setException(new Exception("Ad Web View failed to load."));
                }
            }
        });
        zzbgzVar.zzb(str, str2, null);
        return zzbbrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbgz zzbgzVar, zzbgz zzbgzVar2, Map map) {
        this.h.zzf(zzbgzVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(View view) {
        this.i.recordClick();
        zzavb zzavbVar = this.k;
        if (zzavbVar != null) {
            zzavbVar.zzue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        this.i.recordClick();
        zzavb zzavbVar = this.k;
        if (zzavbVar == null) {
            return false;
        }
        zzavbVar.zzue();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.b.onAdLeftApplication();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str, String str2) {
        this.e.onAppEvent(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        this.f3197a.onAdClicked();
    }
}
