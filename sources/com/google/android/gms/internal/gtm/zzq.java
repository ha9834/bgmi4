package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.helpshift.util.ErrorReportProvider;
import java.util.HashMap;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzq extends com.google.android.gms.analytics.zzi<zzq> {

    /* renamed from: a, reason: collision with root package name */
    private String f4432a;
    private String b;
    private String c;
    private String d;

    @Override // com.google.android.gms.analytics.zzi
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final void zzb(zzq zzqVar) {
        if (!TextUtils.isEmpty(this.f4432a)) {
            zzqVar.f4432a = this.f4432a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            zzqVar.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            zzqVar.c = this.c;
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        zzqVar.d = this.d;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.f4432a);
        hashMap.put("appVersion", this.b);
        hashMap.put(ErrorReportProvider.KEY_APP_ID, this.c);
        hashMap.put("appInstallerId", this.d);
        return zza((Object) hashMap);
    }

    public final String zzaz() {
        return this.f4432a;
    }

    public final void setAppName(String str) {
        this.f4432a = str;
    }

    public final String zzba() {
        return this.b;
    }

    public final void setAppVersion(String str) {
        this.b = str;
    }

    public final String zzbb() {
        return this.c;
    }

    public final void setAppId(String str) {
        this.c = str;
    }

    public final String zzbc() {
        return this.d;
    }

    public final void setAppInstallerId(String str) {
        this.d = str;
    }
}
