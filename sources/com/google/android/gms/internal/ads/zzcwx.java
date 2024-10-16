package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcwx {

    /* renamed from: a, reason: collision with root package name */
    private final zzarx f3484a;

    public zzcwx(zzarx zzarxVar) {
        this.f3484a = zzarxVar;
    }

    public final String zzamc() {
        return this.f3484a.packageName;
    }

    public final String zzamd() {
        return this.f3484a.zzdot.getString("ms");
    }

    @Nullable
    public final PackageInfo zzame() {
        return this.f3484a.zzdlm;
    }

    public final boolean zzamf() {
        return this.f3484a.zzdou;
    }

    public final List<String> zzamg() {
        return this.f3484a.zzdly;
    }

    public final ApplicationInfo zzamh() {
        return this.f3484a.applicationInfo;
    }

    public final String zzami() {
        return this.f3484a.zzdov;
    }
}
