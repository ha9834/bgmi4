package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzard;

@zzard
/* loaded from: classes.dex */
public final class zzt extends zzaqh {

    /* renamed from: a, reason: collision with root package name */
    private AdOverlayInfoParcel f1158a;
    private Activity b;
    private boolean c = false;
    private boolean d = false;

    public zzt(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f1158a = adOverlayInfoParcel;
        this.b = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onBackPressed() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onRestart() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onStart() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void zzac(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void zzdd() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final boolean zztg() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onCreate(Bundle bundle) {
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f1158a;
        if (adOverlayInfoParcel == null) {
            this.b.finish();
            return;
        }
        if (z) {
            this.b.finish();
            return;
        }
        if (bundle == null) {
            if (adOverlayInfoParcel.zzcgi != null) {
                this.f1158a.zzcgi.onAdClicked();
            }
            if (this.b.getIntent() != null && this.b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && this.f1158a.zzdkm != null) {
                this.f1158a.zzdkm.zzta();
            }
        }
        zzk.zzle();
        if (zza.zza(this.b, this.f1158a.zzdkl, this.f1158a.zzdkq)) {
            return;
        }
        this.b.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onResume() throws RemoteException {
        if (this.c) {
            this.b.finish();
            return;
        }
        this.c = true;
        if (this.f1158a.zzdkm != null) {
            this.f1158a.zzdkm.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.c);
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onPause() throws RemoteException {
        if (this.f1158a.zzdkm != null) {
            this.f1158a.zzdkm.onPause();
        }
        if (this.b.isFinishing()) {
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onStop() throws RemoteException {
        if (this.b.isFinishing()) {
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onDestroy() throws RemoteException {
        if (this.b.isFinishing()) {
            a();
        }
    }

    private final synchronized void a() {
        if (!this.d) {
            if (this.f1158a.zzdkm != null) {
                this.f1158a.zzdkm.zzsz();
            }
            this.d = true;
        }
    }
}
