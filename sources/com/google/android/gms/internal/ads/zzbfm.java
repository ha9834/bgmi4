package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.Arrays;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzbfm implements zzbgd {
    @Override // com.google.android.gms.internal.ads.zzbgd
    public final zzbft zza(zzbdf zzbdfVar, int i, String str, zzbde zzbdeVar) {
        if (Build.VERSION.SDK_INT >= 16 && i > 0) {
            List asList = Arrays.asList(zzbdeVar.zzeeg.split(","));
            if (asList.contains("3")) {
                int zzyq = zzbfa.zzyq();
                if (zzyq < zzbdeVar.zzeej) {
                    return new zzbgp(zzbdfVar, zzbdeVar);
                }
                if (zzyq < zzbdeVar.zzeed) {
                    return new zzbgo(zzbdfVar, zzbdeVar);
                }
                return new zzbgf(zzbdfVar);
            }
            if (asList.contains("1")) {
                int zzyq2 = zzbdk.zzyq();
                if (zzyq2 < zzbdeVar.zzeej) {
                    if (i == 1) {
                        return new zzbgk(zzbdfVar);
                    }
                    if (i == 2) {
                        return new zzbgh(zzbdfVar, null);
                    }
                }
                if (zzyq2 < zzbdeVar.zzeed) {
                    return new zzbgg(zzbdfVar, zzbdeVar);
                }
                return new zzbgf(zzbdfVar);
            }
        }
        return new zzbge(zzbdfVar);
    }
}
