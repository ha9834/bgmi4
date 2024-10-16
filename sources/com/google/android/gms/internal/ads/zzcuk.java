package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcuk implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final String f3445a;

    public zzcuk(String str) {
        this.f3445a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        bundle.putString("rtb", this.f3445a);
    }
}
