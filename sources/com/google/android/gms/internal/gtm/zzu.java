package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzu extends com.google.android.gms.analytics.zzi<zzu> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f4452a = new HashMap();

    public final String toString() {
        return zza((Object) this.f4452a);
    }

    public final void set(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        Preconditions.checkNotEmpty(str, "Name can not be empty or \"&\"");
        this.f4452a.put(str, str2);
    }

    public final Map<String, Object> zzbm() {
        return Collections.unmodifiableMap(this.f4452a);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzu zzuVar) {
        zzu zzuVar2 = zzuVar;
        Preconditions.checkNotNull(zzuVar2);
        zzuVar2.f4452a.putAll(this.f4452a);
    }
}
