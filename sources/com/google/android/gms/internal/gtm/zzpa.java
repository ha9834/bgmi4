package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class zzpa {

    /* renamed from: a, reason: collision with root package name */
    private static final Integer f4428a = 0;
    private static final Integer b = 1;
    private final Context c;
    private final ExecutorService d;

    public zzpa(Context context) {
        this(context, zzdf.zzgp().zzr(zzdi.zzadg));
    }

    @VisibleForTesting
    private zzpa(Context context, ExecutorService executorService) {
        this.c = context;
        this.d = executorService;
    }
}
