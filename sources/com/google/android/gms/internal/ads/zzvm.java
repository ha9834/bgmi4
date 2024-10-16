package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzvm {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3761a = new Object();

    @GuardedBy("poolLock")
    private boolean b = false;
}
