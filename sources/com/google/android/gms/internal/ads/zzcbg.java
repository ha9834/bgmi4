package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public final class zzcbg {
    public final int type;
    public final String zzcc;
    public final String zzfrt;
    public final zzadw zzfru;

    @VisibleForTesting
    public zzcbg(String str, String str2) {
        this.type = 1;
        this.zzcc = str;
        this.zzfrt = str2;
        this.zzfru = null;
    }

    @VisibleForTesting
    public zzcbg(String str, zzadw zzadwVar) {
        this.type = 2;
        this.zzcc = str;
        this.zzfrt = null;
        this.zzfru = zzadwVar;
    }
}
