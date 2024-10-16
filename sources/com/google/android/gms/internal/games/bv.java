package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bv extends ce {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f4235a;
    private final /* synthetic */ int[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(zzcz zzczVar, GoogleApiClient googleApiClient, int i, int[] iArr) {
        super(googleApiClient, null);
        this.f4235a = i;
        this.b = iArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4235a, this.b);
    }
}
