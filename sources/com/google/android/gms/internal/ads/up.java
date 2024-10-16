package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class up implements zzbpb {

    /* renamed from: a, reason: collision with root package name */
    private final zzbgz f2546a;

    private up(zzbgz zzbgzVar) {
        this.f2546a = zzbgzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbpb a(zzbgz zzbgzVar) {
        return new up(zzbgzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzaar getVideoController() {
        return this.f2546a.zzyb();
    }
}
