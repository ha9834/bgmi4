package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
final class ym implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final String f2639a;
    private final Bundle b;

    private ym(String str, Bundle bundle) {
        this.f2639a = str;
        this.b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("consent_string", this.f2639a);
        bundle2.putBundle("iab_consent_info", this.b);
    }
}
