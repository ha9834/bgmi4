package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzalr {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private static final zzayp<zzajw> f2752a = new ce();

    @VisibleForTesting
    private static final zzayp<zzajw> b = new cf();
    private final zzakh c;

    public zzalr(Context context, zzbai zzbaiVar, String str) {
        this.c = new zzakh(context, zzbaiVar, str, f2752a, b);
    }

    public final <I, O> zzalj<I, O> zza(String str, zzalm<I> zzalmVar, zzall<O> zzallVar) {
        return new zzalu(this.c, str, zzalmVar, zzallVar);
    }

    public final zzaly zzsc() {
        return new zzaly(this.c);
    }
}
