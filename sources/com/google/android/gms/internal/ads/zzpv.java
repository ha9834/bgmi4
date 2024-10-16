package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzpo;

/* loaded from: classes2.dex */
public abstract class zzpv implements zzpo.zza {
    public final String zzatl;

    public zzpv(String str) {
        this.zzatl = (String) zzsk.checkNotNull(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
