package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzalk {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2750a = new Object();
    private final Object b = new Object();

    @GuardedBy("lockClient")
    private zzalr c;

    @GuardedBy("lockService")
    private zzalr d;

    public final zzalr zza(Context context, zzbai zzbaiVar) {
        zzalr zzalrVar;
        synchronized (this.b) {
            if (this.d == null) {
                this.d = new zzalr(a(context), zzbaiVar, (String) zzyt.zzpe().zzd(zzacu.zzcku));
            }
            zzalrVar = this.d;
        }
        return zzalrVar;
    }

    public final zzalr zzb(Context context, zzbai zzbaiVar) {
        zzalr zzalrVar;
        synchronized (this.f2750a) {
            if (this.c == null) {
                this.c = new zzalr(a(context), zzbaiVar, (String) zzyt.zzpe().zzd(zzacu.zzckv));
            }
            zzalrVar = this.c;
        }
        return zzalrVar;
    }

    private static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
