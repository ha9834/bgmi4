package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* loaded from: classes.dex */
public interface MediationAdapter extends MediationExtrasReceiver {

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private int f1166a;

        public final zza zzdj(int i) {
            this.f1166a = 1;
            return this;
        }

        public final Bundle zzacc() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.f1166a);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
