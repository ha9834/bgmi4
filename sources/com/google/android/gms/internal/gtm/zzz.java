package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzz extends com.google.android.gms.analytics.zzi<zzz> {

    /* renamed from: a, reason: collision with root package name */
    private String f4465a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private double h;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("hitType", this.f4465a);
        hashMap.put("clientId", this.b);
        hashMap.put("userId", this.c);
        hashMap.put("androidAdId", this.d);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.e));
        hashMap.put("sessionControl", this.f);
        hashMap.put("nonInteraction", Boolean.valueOf(this.g));
        hashMap.put("sampleRate", Double.valueOf(this.h));
        return zza((Object) hashMap);
    }

    public final String zzbs() {
        return this.f4465a;
    }

    public final void zzl(String str) {
        this.f4465a = str;
    }

    public final String zzbt() {
        return this.b;
    }

    public final void setClientId(String str) {
        this.b = str;
    }

    public final String zzbu() {
        return this.c;
    }

    public final void setUserId(String str) {
        this.c = str;
    }

    public final String zzbv() {
        return this.d;
    }

    public final void zzm(String str) {
        this.d = str;
    }

    public final boolean zzbw() {
        return this.e;
    }

    public final void zza(boolean z) {
        this.e = z;
    }

    public final String zzbx() {
        return this.f;
    }

    public final boolean zzby() {
        return this.g;
    }

    public final void zzb(boolean z) {
        this.g = true;
    }

    public final double zzbz() {
        return this.h;
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzz zzzVar) {
        zzz zzzVar2 = zzzVar;
        if (!TextUtils.isEmpty(this.f4465a)) {
            zzzVar2.f4465a = this.f4465a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            zzzVar2.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            zzzVar2.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            zzzVar2.d = this.d;
        }
        if (this.e) {
            zzzVar2.e = true;
        }
        if (!TextUtils.isEmpty(this.f)) {
            zzzVar2.f = this.f;
        }
        boolean z = this.g;
        if (z) {
            zzzVar2.g = z;
        }
        double d = this.h;
        if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            Preconditions.checkArgument(d >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d <= 100.0d, "Sample rate must be between 0% and 100%");
            zzzVar2.h = d;
        }
    }
}
