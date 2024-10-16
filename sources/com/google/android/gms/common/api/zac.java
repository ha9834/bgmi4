package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@ShowFirstParty
/* loaded from: classes.dex */
public abstract class zac {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("sLock")
    private static final Map<Object, zac> f1408a = new WeakHashMap();
    private static final Object b = new Object();

    public abstract void remove(int i);
}
