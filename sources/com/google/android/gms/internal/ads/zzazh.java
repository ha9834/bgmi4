package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@zzard
/* loaded from: classes2.dex */
public final class zzazh {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, Bitmap> f2837a = new ConcurrentHashMap();
    private AtomicInteger b = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.f2837a.get(num);
    }
}
