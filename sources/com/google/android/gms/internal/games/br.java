package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.multiplayer.ParticipantResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class br extends cg {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4231a;
    private final /* synthetic */ byte[] b;
    private final /* synthetic */ ParticipantResult[] d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(zzcz zzczVar, GoogleApiClient googleApiClient, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        super(googleApiClient, null);
        this.f4231a = str;
        this.b = bArr;
        this.d = participantResultArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4231a, this.b, this.d);
    }
}
