package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public final class zzda {
    public static <T> zzdb<T> zza(zzdb<T> zzdbVar) {
        if ((zzdbVar instanceof be) || (zzdbVar instanceof zzdd)) {
            return zzdbVar;
        }
        if (zzdbVar instanceof Serializable) {
            return new zzdd(zzdbVar);
        }
        return new be(zzdbVar);
    }

    public static <T> zzdb<T> zzg(@NullableDecl T t) {
        return new zzde(t);
    }
}
