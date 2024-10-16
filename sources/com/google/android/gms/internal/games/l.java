package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l extends t {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4270a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int d;
    private final /* synthetic */ int e;
    private final /* synthetic */ boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(zzal zzalVar, GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        super(googleApiClient, null);
        this.f4270a = str;
        this.b = i;
        this.d = i2;
        this.e = i3;
        this.f = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4270a, this.b, this.d, this.e, this.f);
    }
}
