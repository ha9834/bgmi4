package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzapt {

    /* renamed from: a, reason: collision with root package name */
    private final zzbgz f2777a;
    private final boolean b;
    private final String c;

    public zzapt(zzbgz zzbgzVar, Map<String, String> map) {
        this.f2777a = zzbgzVar;
        this.c = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.b = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.b = true;
        }
    }

    public final void execute() {
        int zzwf;
        if (this.f2777a == null) {
            zzawz.zzep("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.c)) {
            zzk.zzli();
            zzwf = 7;
        } else if ("landscape".equalsIgnoreCase(this.c)) {
            zzk.zzli();
            zzwf = 6;
        } else {
            zzwf = this.b ? -1 : zzk.zzli().zzwf();
        }
        this.f2777a.setRequestedOrientation(zzwf);
    }
}
