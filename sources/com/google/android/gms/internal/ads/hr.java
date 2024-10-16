package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class hr<T> implements zzban<T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbw f2223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hr(zzbbw zzbbwVar) {
        this.f2223a = zzbbwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzk(@Nullable T t) {
        AtomicInteger atomicInteger;
        atomicInteger = this.f2223a.b;
        atomicInteger.set(1);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        AtomicInteger atomicInteger;
        atomicInteger = this.f2223a.b;
        atomicInteger.set(-1);
    }
}
