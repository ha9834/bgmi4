package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzbp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class zzde extends zzdf {
    private static final String s = "zzde";
    private AdvertisingIdClient.Info t;

    public static zzde zzb(Context context) {
        a(context, true);
        return new zzde(context);
    }

    @Override // com.google.android.gms.internal.ads.zzdf, com.google.android.gms.internal.ads.zzdd
    protected final zzbp.zza.C0092zza a(Context context, View view, Activity activity) {
        return null;
    }

    private zzde(Context context) {
        super(context, "");
    }

    public static String zza(String str, String str2) {
        return tr.a(str, str2, true);
    }

    @Override // com.google.android.gms.internal.ads.zzdf
    protected final void a(zzdy zzdyVar, Context context, zzbp.zza.C0092zza c0092zza, zzbk.zza zzaVar) {
        if (zzdyVar.b) {
            AdvertisingIdClient.Info info = this.t;
            if (info != null) {
                String id = info.getId();
                if (!TextUtils.isEmpty(id)) {
                    c0092zza.zzaf(zzef.zzap(id));
                    c0092zza.zzb(zzbp.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    c0092zza.zzb(this.t.isLimitAdTrackingEnabled());
                }
                this.t = null;
                return;
            }
            return;
        }
        a(b(zzdyVar, context, c0092zza, zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdf
    public final List<Callable<Void>> b(zzdy zzdyVar, Context context, zzbp.zza.C0092zza c0092zza, zzbk.zza zzaVar) {
        ArrayList arrayList = new ArrayList();
        if (zzdyVar.zzch() == null) {
            return arrayList;
        }
        arrayList.add(new zzes(zzdyVar, "3pegtvj7nkb7e3rwh5b+3dnQATJj6aqtaosJ3DkOYPzNGN2w+CoarbJEsY1UQgeA", "/kRTFQbKQx44ublaFMNQ8yNL6QxOrgEofiWDpZSH6zA=", c0092zza, zzdyVar.zzcd(), 24));
        return arrayList;
    }

    public final void zza(AdvertisingIdClient.Info info) {
        this.t = info;
    }
}
