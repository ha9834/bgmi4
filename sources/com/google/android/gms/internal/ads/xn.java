package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class xn extends zzaap {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaao f2615a;
    private final /* synthetic */ zzcqf b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xn(zzcqf zzcqfVar, zzaao zzaaoVar) {
        this.b = zzcqfVar;
        this.f2615a = zzaaoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaao
    public final void onAdMetadataChanged() throws RemoteException {
        boolean z;
        zzaao zzaaoVar;
        z = this.b.j;
        if (!z || (zzaaoVar = this.f2615a) == null) {
            return;
        }
        zzaaoVar.onAdMetadataChanged();
    }
}
