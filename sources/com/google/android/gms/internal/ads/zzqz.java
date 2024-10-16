package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzqz extends zzlr {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3714a = new Object();
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final boolean f;
    private final boolean g;

    public zzqz(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final int zzhf() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final int zzhg() {
        return 1;
    }

    private zzqz(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.b = j;
        this.c = j2;
        this.d = 0L;
        this.e = 0L;
        this.f = z;
        this.g = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final zzlu zza(int i, zzlu zzluVar, boolean z, long j) {
        zzsk.zzc(i, 0, 1);
        boolean z2 = this.f;
        long j2 = this.c;
        zzluVar.zzaun = null;
        zzluVar.zzauq = -9223372036854775807L;
        zzluVar.zzaur = -9223372036854775807L;
        zzluVar.zzaus = z2;
        zzluVar.zzaut = false;
        zzluVar.zzauw = 0L;
        zzluVar.zzack = j2;
        zzluVar.zzauu = 0;
        zzluVar.zzauv = 0;
        zzluVar.zzaux = 0L;
        return zzluVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final zzlt zza(int i, zzlt zzltVar, boolean z) {
        zzsk.zzc(i, 0, 1);
        Object obj = z ? f3714a : null;
        return zzltVar.zza(obj, obj, 0, this.b, 0L, false);
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final int zzc(Object obj) {
        return f3714a.equals(obj) ? 0 : -1;
    }
}
