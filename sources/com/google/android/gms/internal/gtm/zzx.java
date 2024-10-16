package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzx extends com.google.android.gms.analytics.zzi<zzx> {

    /* renamed from: a, reason: collision with root package name */
    private String f4464a;
    private String b;
    private String c;
    private long d;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.f4464a);
        hashMap.put("action", this.b);
        hashMap.put("label", this.c);
        hashMap.put("value", Long.valueOf(this.d));
        return zza((Object) hashMap);
    }

    public final String zzbr() {
        return this.f4464a;
    }

    public final String getAction() {
        return this.b;
    }

    public final String getLabel() {
        return this.c;
    }

    public final long getValue() {
        return this.d;
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzx zzxVar) {
        zzx zzxVar2 = zzxVar;
        if (!TextUtils.isEmpty(this.f4464a)) {
            zzxVar2.f4464a = this.f4464a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            zzxVar2.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            zzxVar2.c = this.c;
        }
        long j = this.d;
        if (j != 0) {
            zzxVar2.d = j;
        }
    }
}
