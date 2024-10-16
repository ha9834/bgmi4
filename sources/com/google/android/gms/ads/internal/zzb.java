package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzaxi;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzb {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1160a;
    private boolean b;
    private zzavb c;
    private zzark d;

    public zzb(Context context, zzavb zzavbVar, zzark zzarkVar) {
        this.f1160a = context;
        this.c = zzavbVar;
        this.d = null;
        if (this.d == null) {
            this.d = new zzark();
        }
    }

    private final boolean a() {
        zzavb zzavbVar = this.c;
        return (zzavbVar != null && zzavbVar.zzuc().zzdrw) || this.d.zzdom;
    }

    public final void recordClick() {
        this.b = true;
    }

    public final boolean zzkx() {
        return !a() || this.b;
    }

    public final void zzbk(String str) {
        if (a()) {
            if (str == null) {
                str = "";
            }
            zzavb zzavbVar = this.c;
            if (zzavbVar != null) {
                zzavbVar.zza(str, null, 3);
                return;
            }
            if (!this.d.zzdom || this.d.zzdon == null) {
                return;
            }
            for (String str2 : this.d.zzdon) {
                if (!TextUtils.isEmpty(str2)) {
                    String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    zzk.zzlg();
                    zzaxi.zzb(this.f1160a, "", replace);
                }
            }
        }
    }
}
