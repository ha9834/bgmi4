package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class ah extends an {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int[] f4204a;
    private final /* synthetic */ int b;
    private final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(zzbn zzbnVar, GoogleApiClient googleApiClient, int[] iArr, int i, boolean z) {
        super(googleApiClient, null);
        this.f4204a = iArr;
        this.b = i;
        this.d = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4204a, this.b, this.d);
    }
}
