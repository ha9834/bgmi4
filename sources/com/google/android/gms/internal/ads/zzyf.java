package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

@zzard
/* loaded from: classes2.dex */
public final class zzyf extends zzzt {

    /* renamed from: a, reason: collision with root package name */
    private final AppEventListener f3780a;

    public zzyf(AppEventListener appEventListener) {
        this.f3780a = appEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzzs
    public final void onAppEvent(String str, String str2) {
        this.f3780a.onAppEvent(str, str2);
    }

    public final AppEventListener getAppEventListener() {
        return this.f3780a;
    }
}
