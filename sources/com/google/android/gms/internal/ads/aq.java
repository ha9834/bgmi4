package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes2.dex */
final class aq extends zzaif {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbr f2042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar, zzbbr zzbbrVar) {
        this.f2042a = zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaie
    public final void zza(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.f2042a.set(parcelFileDescriptor);
    }
}
