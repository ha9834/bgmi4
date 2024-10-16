package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzada {
    public static void zza(zzacy zzacyVar, zzacx zzacxVar) {
        if (zzacxVar.b() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzacxVar.c())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzacyVar.zza(zzacxVar.b(), zzacxVar.c(), zzacxVar.a(), zzacxVar.d());
    }
}
