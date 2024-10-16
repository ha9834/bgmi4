package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzabp extends zzzl {

    /* renamed from: a, reason: collision with root package name */
    private zzyz f2690a;

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String getAdUnitId() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzaar getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean isLoading() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void pause() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void resume() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setManualImpressionsEnabled(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void showInterstitial() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaax zzaaxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzacd zzacdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzado zzadoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaqn zzaqnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaqt zzaqtVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzatb zzatbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzyd zzydVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzyw zzywVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzzp zzzpVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzzs zzzsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzb(zzzy zzzyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzbt(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String zzpj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final IObjectWrapper zzpl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzpm() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyd zzpn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzzs zzpo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyz zzpp() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean zzb(zzxz zzxzVar) {
        zzbad.zzen("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.zzyr.post(new g(this));
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzb(zzyz zzyzVar) {
        this.f2690a = zzyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final Bundle getAdMetadata() {
        return new Bundle();
    }
}
