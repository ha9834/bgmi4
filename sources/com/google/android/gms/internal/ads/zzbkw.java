package com.google.android.gms.internal.ads;

@zzard
/* loaded from: classes2.dex */
public class zzbkw {

    /* renamed from: a, reason: collision with root package name */
    private zza f2900a;

    /* loaded from: classes2.dex */
    public static abstract class zza {
        public abstract zzbgd zzacu();

        public abstract zzbcp zzacv();

        public abstract zzwo zzacw();

        public abstract zzavd zzacx();
    }

    public zzbkw(zza zzaVar) {
        this.f2900a = zzaVar;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzauw, com.google.android.gms.internal.ads.zzavc] */
    public final com.google.android.gms.ads.internal.zza zzaeo() {
        zza zzaVar = this.f2900a;
        return new com.google.android.gms.ads.internal.zza(zzaVar.zzacu(), zzaVar.zzacv(), new zzauw(zzaVar.zzacx()), zzaVar.zzacw());
    }

    public final zzavd zzacx() {
        return this.f2900a.zzacx();
    }
}
