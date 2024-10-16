package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzr extends com.google.android.gms.analytics.zzi<zzr> {

    /* renamed from: a, reason: collision with root package name */
    private String f4439a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.f4439a);
        hashMap.put("source", this.b);
        hashMap.put("medium", this.c);
        hashMap.put("keyword", this.d);
        hashMap.put(FirebaseAnalytics.Param.CONTENT, this.e);
        hashMap.put("id", this.f);
        hashMap.put("adNetworkId", this.g);
        hashMap.put("gclid", this.h);
        hashMap.put("dclid", this.i);
        hashMap.put(FirebaseAnalytics.Param.ACLID, this.j);
        return zza((Object) hashMap);
    }

    public final String getName() {
        return this.f4439a;
    }

    public final void setName(String str) {
        this.f4439a = str;
    }

    public final String getSource() {
        return this.b;
    }

    public final void zzc(String str) {
        this.b = str;
    }

    public final String zzbd() {
        return this.c;
    }

    public final void zzd(String str) {
        this.c = str;
    }

    public final String zzbe() {
        return this.d;
    }

    public final void zze(String str) {
        this.d = str;
    }

    public final String zzbf() {
        return this.e;
    }

    public final void zzf(String str) {
        this.e = str;
    }

    public final String getId() {
        return this.f;
    }

    public final void zzg(String str) {
        this.f = str;
    }

    public final String zzbg() {
        return this.g;
    }

    public final void zzh(String str) {
        this.g = str;
    }

    public final String zzbh() {
        return this.h;
    }

    public final void zzi(String str) {
        this.h = str;
    }

    public final String zzbi() {
        return this.i;
    }

    public final void zzj(String str) {
        this.i = str;
    }

    public final String zzbj() {
        return this.j;
    }

    public final void zzk(String str) {
        this.j = str;
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzr zzrVar) {
        zzr zzrVar2 = zzrVar;
        if (!TextUtils.isEmpty(this.f4439a)) {
            zzrVar2.f4439a = this.f4439a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            zzrVar2.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            zzrVar2.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            zzrVar2.d = this.d;
        }
        if (!TextUtils.isEmpty(this.e)) {
            zzrVar2.e = this.e;
        }
        if (!TextUtils.isEmpty(this.f)) {
            zzrVar2.f = this.f;
        }
        if (!TextUtils.isEmpty(this.g)) {
            zzrVar2.g = this.g;
        }
        if (!TextUtils.isEmpty(this.h)) {
            zzrVar2.h = this.h;
        }
        if (!TextUtils.isEmpty(this.i)) {
            zzrVar2.i = this.i;
        }
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        zzrVar2.j = this.j;
    }
}
