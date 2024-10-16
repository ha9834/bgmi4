package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ap implements zzbal<zzaig, ParcelFileDescriptor> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaia f2022a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(zzaii zzaiiVar, zzaia zzaiaVar) {
        this.f2022a = zzaiaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final /* synthetic */ zzbbh<ParcelFileDescriptor> zzf(zzaig zzaigVar) throws Exception {
        zzbbr zzbbrVar = new zzbbr();
        zzaigVar.zza(this.f2022a, new aq(this, zzbbrVar));
        return zzbbrVar;
    }
}
