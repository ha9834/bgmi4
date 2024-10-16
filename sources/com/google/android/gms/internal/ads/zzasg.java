package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

@zzard
/* loaded from: classes2.dex */
public final class zzasg {

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap<Context, ec> f2793a = new WeakHashMap<>();

    public final Future<zzase> zzt(Context context) {
        return zzaxg.zza(new eb(this, context));
    }
}
