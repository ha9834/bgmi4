package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzba implements bd {

    /* renamed from: a, reason: collision with root package name */
    private int f5161a = 5;

    @Override // com.google.android.gms.tagmanager.bd
    public final void zzav(String str) {
        if (this.f5161a <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.bd
    public final void zza(String str, Throwable th) {
        if (this.f5161a <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    @Override // com.google.android.gms.tagmanager.bd
    public final void zzac(String str) {
        if (this.f5161a <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.bd
    public final void zzb(String str, Throwable th) {
        if (this.f5161a <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    @Override // com.google.android.gms.tagmanager.bd
    public final void zzaw(String str) {
        if (this.f5161a <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.bd
    public final void zzax(String str) {
        if (this.f5161a <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.bd
    public final void zzab(String str) {
        if (this.f5161a <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.bd
    public final void setLogLevel(int i) {
        this.f5161a = i;
    }
}
