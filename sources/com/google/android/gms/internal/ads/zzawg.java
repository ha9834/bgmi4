package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

@zzard
/* loaded from: classes2.dex */
public final class zzawg implements zzawi {
    @Override // com.google.android.gms.internal.ads.zzawi
    public final zzbbh<String> zza(String str, PackageInfo packageInfo) {
        return zzbar.zzm(str);
    }

    @Override // com.google.android.gms.internal.ads.zzawi
    public final zzbbh<AdvertisingIdClient.Info> zzag(Context context) {
        zzbbr zzbbrVar = new zzbbr();
        zzyt.zzpa();
        if (zzazt.zzbg(context)) {
            zzaxg.zzc(new fc(this, context, zzbbrVar));
        }
        return zzbbrVar;
    }
}
