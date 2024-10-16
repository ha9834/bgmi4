package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzadh {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, zzadg> f2705a = new HashMap();
    private final zzadi b;

    public zzadh(zzadi zzadiVar) {
        this.b = zzadiVar;
    }

    public final void zza(String str, zzadg zzadgVar) {
        this.f2705a.put(str, zzadgVar);
    }

    public final void zza(String str, String str2, long j) {
        zzadi zzadiVar = this.b;
        zzadg zzadgVar = this.f2705a.get(str2);
        String[] strArr = {str};
        if (zzadiVar != null && zzadgVar != null) {
            zzadiVar.zza(zzadgVar, j, strArr);
        }
        Map<String, zzadg> map = this.f2705a;
        zzadi zzadiVar2 = this.b;
        map.put(str, zzadiVar2 == null ? null : zzadiVar2.zzfa(j));
    }

    public final zzadi zzqw() {
        return this.b;
    }
}
