package com.google.android.gms.internal.gtm;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzs extends com.google.android.gms.analytics.zzi<zzs> {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, String> f4447a = new HashMap(4);

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, String> entry : this.f4447a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append(ViewHierarchyConstants.DIMENSION_KEY);
            sb.append(valueOf);
            hashMap.put(sb.toString(), entry.getValue());
        }
        return zza((Object) hashMap);
    }

    public final Map<Integer, String> zzbk() {
        return Collections.unmodifiableMap(this.f4447a);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzs zzsVar) {
        zzsVar.f4447a.putAll(this.f4447a);
    }
}
