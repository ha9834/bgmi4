package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcub implements zzcuz<Bundle>, zzcva<zzcuz<Bundle>> {

    /* renamed from: a, reason: collision with root package name */
    private final ApplicationInfo f3438a;
    private final PackageInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcub(ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo) {
        this.f3438a = applicationInfo;
        this.b = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuz<Bundle>> zzalm() {
        return zzbar.zzm(this);
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.f3438a.packageName;
        PackageInfo packageInfo = this.b;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle2.putString("pn", str);
        if (valueOf != null) {
            bundle2.putInt("vc", valueOf.intValue());
        }
    }
}
