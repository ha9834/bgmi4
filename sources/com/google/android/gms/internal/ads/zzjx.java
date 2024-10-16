package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzjx extends IOException {
    private final zzjq zzapt;

    public zzjx(String str, zzjq zzjqVar) {
        super(str);
        this.zzapt = zzjqVar;
    }

    public zzjx(IOException iOException, zzjq zzjqVar) {
        super(iOException);
        this.zzapt = zzjqVar;
    }

    public zzjx(String str, IOException iOException, zzjq zzjqVar) {
        super(str, iOException);
        this.zzapt = zzjqVar;
    }
}
