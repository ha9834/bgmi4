package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* loaded from: classes2.dex */
public final class zzcrp implements zzcva<zzcro> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcva<zzcvf> f3398a;
    private final zzcxv b;
    private final Context c;
    private final zzawm d;

    public zzcrp(zzcsk<zzcvf> zzcskVar, zzcxv zzcxvVar, Context context, zzawm zzawmVar) {
        this.f3398a = zzcskVar;
        this.b = zzcxvVar;
        this.c = context;
        this.d = zzawmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcro> zzalm() {
        return zzbar.zza(this.f3398a.zzalm(), new zzbam(this) { // from class: com.google.android.gms.internal.ads.ya

            /* renamed from: a, reason: collision with root package name */
            private final zzcrp f2628a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2628a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object apply(Object obj) {
                return this.f2628a.a((zzcvf) obj);
            }
        }, zzbbm.zzeaf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcro a(zzcvf zzcvfVar) {
        String str;
        boolean z;
        String str2;
        float f;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        DisplayMetrics displayMetrics;
        zzyd zzydVar = this.b.zzdll;
        if (zzydVar.zzchg == null) {
            str = zzydVar.zzaap;
            z = zzydVar.zzchh;
        } else {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzyd zzydVar2 : zzydVar.zzchg) {
                if (!zzydVar2.zzchh && !z2) {
                    str = zzydVar2.zzaap;
                    z2 = true;
                }
                if (zzydVar2.zzchh && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        }
        Resources resources = this.c.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i = 0;
            i2 = 0;
        } else {
            float f2 = displayMetrics.density;
            int i6 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
            str2 = this.d.zzvc().zzvx();
            i = i6;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        if (zzydVar.zzchg != null) {
            boolean z4 = false;
            for (zzyd zzydVar3 : zzydVar.zzchg) {
                if (zzydVar3.zzchh) {
                    z4 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    if (zzydVar3.width == -1 && f != 0.0f) {
                        i4 = (int) (zzydVar3.widthPixels / f);
                    } else {
                        i4 = zzydVar3.width;
                    }
                    sb.append(i4);
                    sb.append("x");
                    if (zzydVar3.height == -2 && f != 0.0f) {
                        i5 = (int) (zzydVar3.heightPixels / f);
                    } else {
                        i5 = zzydVar3.height;
                    }
                    sb.append(i5);
                }
            }
            if (z4) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzcro(zzydVar, str, z, sb.toString(), f, i, i2, str2);
    }
}
