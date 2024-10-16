package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzaa extends com.google.android.gms.analytics.zzi<zzaa> {

    /* renamed from: a, reason: collision with root package name */
    private String f4382a;
    private int b;
    private int c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;

    public zzaa() {
        this(false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private zzaa(boolean r5) {
        /*
            r4 = this;
            java.util.UUID r5 = java.util.UUID.randomUUID()
            long r0 = r5.getLeastSignificantBits()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r0 = r0 & r2
            int r1 = (int) r0
            if (r1 == 0) goto L10
            goto L23
        L10:
            long r0 = r5.getMostSignificantBits()
            long r0 = r0 & r2
            int r1 = (int) r0
            if (r1 == 0) goto L19
            goto L23
        L19:
            java.lang.String r5 = "GAv4"
            java.lang.String r0 = "UUID.randomUUID() returned 0."
            android.util.Log.e(r5, r0)
            r1 = 2147483647(0x7fffffff, float:NaN)
        L23:
            r5 = 0
            r4.<init>(r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzaa.<init>(boolean):void");
    }

    @ShowFirstParty
    @VisibleForTesting
    private zzaa(boolean z, int i) {
        Preconditions.checkNotZero(i);
        this.b = i;
        this.g = false;
    }

    public final String zzca() {
        return this.f4382a;
    }

    public final int zzcb() {
        return this.b;
    }

    public final String zzcc() {
        return this.e;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", this.f4382a);
        hashMap.put("interstitial", Boolean.valueOf(this.f));
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, Boolean.valueOf(this.g));
        hashMap.put("screenId", Integer.valueOf(this.b));
        hashMap.put("referrerScreenId", Integer.valueOf(this.c));
        hashMap.put("referrerScreenName", this.d);
        hashMap.put("referrerUri", this.e);
        return zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzaa zzaaVar) {
        zzaa zzaaVar2 = zzaaVar;
        if (!TextUtils.isEmpty(this.f4382a)) {
            zzaaVar2.f4382a = this.f4382a;
        }
        int i = this.b;
        if (i != 0) {
            zzaaVar2.b = i;
        }
        int i2 = this.c;
        if (i2 != 0) {
            zzaaVar2.c = i2;
        }
        if (!TextUtils.isEmpty(this.d)) {
            zzaaVar2.d = this.d;
        }
        if (!TextUtils.isEmpty(this.e)) {
            String str = this.e;
            if (TextUtils.isEmpty(str)) {
                zzaaVar2.e = null;
            } else {
                zzaaVar2.e = str;
            }
        }
        boolean z = this.f;
        if (z) {
            zzaaVar2.f = z;
        }
        boolean z2 = this.g;
        if (z2) {
            zzaaVar2.g = z2;
        }
    }
}
