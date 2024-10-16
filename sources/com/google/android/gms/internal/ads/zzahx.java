package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzahx implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final zzahy f2736a;

    public static void zza(zzbgz zzbgzVar, zzahy zzahyVar) {
        zzbgzVar.zza("/reward", new zzahx(zzahyVar));
    }

    private zzahx(zzahy zzahyVar) {
        this.f2736a = zzahyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzato zzatoVar = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzatoVar = new zzato(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzawz.zzd("Unable to parse reward amount.", e);
            }
            this.f2736a.zza(zzatoVar);
            return;
        }
        if ("video_start".equals(str)) {
            this.f2736a.zzrq();
        } else if ("video_complete".equals(str)) {
            this.f2736a.zzrr();
        }
    }
}
