package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;

@zzard
/* loaded from: classes2.dex */
public class zzyh {

    /* renamed from: a, reason: collision with root package name */
    private final zzxx f3782a;
    private final zzxw b;
    private final zzabk c;
    private final zzagk d;
    private final zzatf e;
    private final zzauj f;
    private final zzaqf g;
    private final zzagl h;

    public zzyh(zzxx zzxxVar, zzxw zzxwVar, zzabk zzabkVar, zzagk zzagkVar, zzatf zzatfVar, zzauj zzaujVar, zzaqf zzaqfVar, zzagl zzaglVar) {
        this.f3782a = zzxxVar;
        this.b = zzxwVar;
        this.c = zzabkVar;
        this.d = zzagkVar;
        this.e = zzatfVar;
        this.f = zzaujVar;
        this.g = zzaqfVar;
        this.h = zzaglVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzyt.zzpa().zza(context, zzyt.zzpg().zzbsx, "gmob-apps", bundle, true);
    }

    public final zzzf zzb(Context context, String str, zzamp zzampVar) {
        return new aqi(this, context, str, zzampVar).a(context, false);
    }

    public final zzaem zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return new aqk(this, frameLayout, frameLayout2, context).a(context, false);
    }

    public final zzaer zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return new aql(this, view, hashMap, hashMap2).a(view.getContext(), false);
    }

    public final zzatt zzc(Context context, String str, zzamp zzampVar) {
        return new aqn(this, context, str, zzampVar).a(context, false);
    }

    public final zzaqg zzb(Activity activity) {
        aqf aqfVar = new aqf(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzbad.zzen("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return aqfVar.a(activity, z);
    }
}
