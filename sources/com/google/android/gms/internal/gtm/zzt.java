package com.google.android.gms.internal.gtm;

import android.annotation.SuppressLint;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzt extends com.google.android.gms.analytics.zzi<zzt> {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, Double> f4449a = new HashMap(4);

    @SuppressLint({"UseSparseArrays"})
    public zzt() {
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, Double> entry : this.f4449a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 6);
            sb.append("metric");
            sb.append(valueOf);
            hashMap.put(sb.toString(), entry.getValue());
        }
        return zza((Object) hashMap);
    }

    public final Map<Integer, Double> zzbl() {
        return Collections.unmodifiableMap(this.f4449a);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzt zztVar) {
        zztVar.f4449a.putAll(this.f4449a);
    }
}
