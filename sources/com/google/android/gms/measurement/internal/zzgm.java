package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzx;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzgm {

    /* renamed from: a, reason: collision with root package name */
    final Context f4943a;
    String b;
    String c;
    String d;
    Boolean e;
    long f;
    zzx g;
    boolean h;

    @VisibleForTesting
    public zzgm(Context context, zzx zzxVar) {
        this.h = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.f4943a = applicationContext;
        if (zzxVar != null) {
            this.g = zzxVar;
            this.b = zzxVar.zzv;
            this.c = zzxVar.origin;
            this.d = zzxVar.zzu;
            this.h = zzxVar.zzt;
            this.f = zzxVar.zzs;
            if (zzxVar.zzw != null) {
                this.e = Boolean.valueOf(zzxVar.zzw.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
