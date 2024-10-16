package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzsb extends IOException {
    private final int type;
    private final zzry zzbmo;

    public zzsb(String str, zzry zzryVar, int i) {
        super(str);
        this.zzbmo = zzryVar;
        this.type = 1;
    }

    public zzsb(IOException iOException, zzry zzryVar, int i) {
        super(iOException);
        this.zzbmo = zzryVar;
        this.type = i;
    }

    public zzsb(String str, IOException iOException, zzry zzryVar, int i) {
        super(str, iOException);
        this.zzbmo = zzryVar;
        this.type = 1;
    }
}
