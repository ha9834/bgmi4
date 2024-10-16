package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;

/* loaded from: classes2.dex */
public final class zzcrz implements zzcva<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final String f3403a;
    private final String b;
    private final zzbqe c;
    private final zzcyi d;
    private final zzcxv e;

    public zzcrz(String str, String str2, zzbqe zzbqeVar, zzcyi zzcyiVar, zzcxv zzcxvVar) {
        this.f3403a = str;
        this.b = str2;
        this.c = zzbqeVar;
        this.d = zzcyiVar;
        this.e = zzcxvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<Object> zzalm() {
        return zzbar.zzm(new zzcuz(this) { // from class: com.google.android.gms.internal.ads.yg

            /* renamed from: a, reason: collision with root package name */
            private final zzcrz f2634a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2634a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void zzt(Object obj) {
                this.f2634a.a((Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Bundle bundle) {
        this.c.zzf(this.e.zzghg);
        bundle.putBundle("quality_signals", this.d.zzams());
        bundle.putString("seq_num", this.f3403a);
        bundle.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, this.b);
    }
}
