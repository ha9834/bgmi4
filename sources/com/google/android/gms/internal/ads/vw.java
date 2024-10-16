package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
public final class vw<T> implements zzban<T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2575a;
    private final /* synthetic */ long b;
    private final /* synthetic */ zzcmu c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public vw(zzcmu zzcmuVar, String str, long j) {
        this.c = zzcmuVar;
        this.f2575a = str;
        this.b = j;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzk(T t) {
        Clock clock;
        clock = this.c.f3329a;
        this.c.a(this.f2575a, 0, clock.elapsedRealtime() - this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        Clock clock;
        clock = this.c.f3329a;
        long elapsedRealtime = clock.elapsedRealtime();
        int i = 3;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (!(th instanceof zzcmk)) {
            if (th instanceof CancellationException) {
                i = 4;
            } else if (th instanceof zzcgm) {
                i = ((zzcgm) th).getErrorCode() == 3 ? 1 : 6;
            } else {
                i = 6;
            }
        }
        this.c.a(this.f2575a, i, elapsedRealtime - this.b);
    }
}
