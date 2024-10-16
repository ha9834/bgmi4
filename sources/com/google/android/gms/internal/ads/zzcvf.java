package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.helpshift.analytics.AnalyticsEventKey;

/* loaded from: classes2.dex */
public final class zzcvf implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3456a;
    private final boolean b;
    private final String c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final boolean k;
    private final String l;

    public zzcvf(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, String str3, String str4, String str5, boolean z6, String str6) {
        this.f3456a = z;
        this.b = z2;
        this.c = str;
        this.d = z3;
        this.e = z4;
        this.f = z5;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = z6;
        this.l = str6;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putBoolean("cog", this.f3456a);
        bundle2.putBoolean("coh", this.b);
        bundle2.putString("gl", this.c);
        bundle2.putBoolean("simulator", this.d);
        bundle2.putBoolean("is_latchsky", this.e);
        bundle2.putBoolean("is_sidewinder", this.f);
        bundle2.putString("hl", this.g);
        bundle2.putString(AnalyticsEventKey.SMART_INTENT_MODEL_VERSION, this.h);
        bundle2.putString("submodel", this.l);
        Bundle zza = zzcxz.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        zza.putString("build", this.j);
        Bundle zza2 = zzcxz.zza(zza, "browser");
        zza.putBundle("browser", zza2);
        zza2.putBoolean("is_browser_custom_tabs_capable", this.k);
        if (TextUtils.isEmpty(this.i)) {
            return;
        }
        Bundle zza3 = zzcxz.zza(zza, "play_store");
        zza.putBundle("play_store", zza3);
        zza3.putString("package_version", this.i);
    }
}
