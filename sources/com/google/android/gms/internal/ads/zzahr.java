package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.CollectionUtils;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzahr implements zzaho<zzbgz> {
    private static final Map<String, Integer> d = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.zzb f2732a;
    private final zzapr b;
    private final zzaqc c;

    public zzahr(com.google.android.gms.ads.internal.zzb zzbVar, zzapr zzaprVar, zzaqc zzaqcVar) {
        this.f2732a = zzbVar;
        this.b = zzaprVar;
        this.c = zzaqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzbgz zzbgzVar, Map map) {
        com.google.android.gms.ads.internal.zzb zzbVar;
        zzbgz zzbgzVar2 = zzbgzVar;
        int intValue = d.get((String) map.get(AnalyticsEventKey.ACTION_SHA)).intValue();
        if (intValue != 5 && intValue != 7 && (zzbVar = this.f2732a) != null && !zzbVar.zzkx()) {
            this.f2732a.zzbk(null);
            return;
        }
        if (intValue == 1) {
            this.b.zzg(map);
            return;
        }
        switch (intValue) {
            case 3:
                new zzapu(zzbgzVar2, map).execute();
                return;
            case 4:
                new zzapo(zzbgzVar2, map).execute();
                return;
            case 5:
                new zzapt(zzbgzVar2, map).execute();
                return;
            case 6:
                this.b.zzw(true);
                return;
            case 7:
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcmw)).booleanValue()) {
                    this.c.zztd();
                    return;
                }
                return;
            default:
                zzawz.zzeo("Unknown MRAID command called.");
                return;
        }
    }
}
