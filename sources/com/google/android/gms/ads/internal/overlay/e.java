package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaxi;

@zzard
/* loaded from: classes.dex */
final class e extends zzawv {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzd f1152a;

    private e(zzd zzdVar) {
        this.f1152a = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        Bitmap zza = zzk.zzlz().zza(Integer.valueOf(this.f1152a.b.zzdkt.zzbrj));
        if (zza != null) {
            final Drawable zza2 = zzk.zzli().zza(this.f1152a.f1156a, zza, this.f1152a.b.zzdkt.zzbrh, this.f1152a.b.zzdkt.zzbri);
            zzaxi.zzdvv.post(new Runnable(this, zza2) { // from class: com.google.android.gms.ads.internal.overlay.f

                /* renamed from: a, reason: collision with root package name */
                private final e f1153a;
                private final Drawable b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f1153a = this;
                    this.b = zza2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e eVar = this.f1153a;
                    eVar.f1152a.f1156a.getWindow().setBackgroundDrawable(this.b);
                }
            });
        }
    }
}
