package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcwy implements zzdti<String> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcwx f3485a;

    public zzcwy(zzcwx zzcwxVar) {
        this.f3485a = zzcwxVar;
    }

    public static String zzb(zzcwx zzcwxVar) {
        return (String) zzdto.zza(zzcwxVar.zzamc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzb(this.f3485a);
    }
}
