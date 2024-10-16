package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcud implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f3440a;

    public zzcud(Bundle bundle) {
        this.f3440a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundle3 = this.f3440a;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
    }
}
