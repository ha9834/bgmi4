package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzk;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* loaded from: classes.dex */
public final class zzcfz implements AppEventListener, zzbrl, zzbro, zzbrw, zzbrx, zzbsr, zzbtk, zzczz, zzxr {

    /* renamed from: a, reason: collision with root package name */
    private final List<Object> f3244a;
    private final zzcfn b;
    private long c;

    public zzcfz(zzcfn zzcfnVar, zzbjm zzbjmVar) {
        this.b = zzcfnVar;
        this.f3244a = Collections.singletonList(zzbjmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zza(zzcxu zzcxuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final void zzbp(Context context) {
        a(zzbrx.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final void zzbq(Context context) {
        a(zzbrx.class, "onResume", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final void zzbr(Context context) {
        a(zzbrx.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void onAppEvent(String str, String str2) {
        a(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        long elapsedRealtime = zzk.zzln().elapsedRealtime() - this.c;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime);
        zzawz.zzds(sb.toString());
        a(zzbsr.class, "onAdLoaded", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(int i) {
        a(zzbro.class, "onAdFailedToLoad", Integer.valueOf(i));
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdOpened() {
        a(zzbrl.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdClosed() {
        a(zzbrl.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdLeftApplication() {
        a(zzbrl.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final void onAdClicked() {
        a(zzxr.class, "onAdClicked", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final void onAdImpression() {
        a(zzbrw.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoStarted() {
        a(zzbrl.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    @ParametersAreNonnullByDefault
    public final void zzb(zzasr zzasrVar, String str, String str2) {
        a(zzbrl.class, "onRewarded", zzasrVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoCompleted() {
        a(zzbrl.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zza(zzczs zzczsVar, String str) {
        a(zzczr.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zzb(zzczs zzczsVar, String str) {
        a(zzczr.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zza(zzczs zzczsVar, String str, Throwable th) {
        a(zzczr.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zzc(zzczs zzczsVar, String str) {
        a(zzczr.class, "onTaskSucceeded", str);
    }

    private final void a(Class cls, String str, Object... objArr) {
        zzcfn zzcfnVar = this.b;
        List<Object> list = this.f3244a;
        String valueOf = String.valueOf(cls.getSimpleName());
        zzcfnVar.zza(list, valueOf.length() != 0 ? "Event-".concat(valueOf) : new String("Event-"), str, objArr);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzb(zzarx zzarxVar) {
        this.c = zzk.zzln().elapsedRealtime();
        a(zzbtk.class, "onAdRequest", new Object[0]);
    }
}
