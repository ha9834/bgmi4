package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bs extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TurnBasedMultiplayerClient turnBasedMultiplayerClient, String str) {
        this.f1634a = str;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzeVar.zzd(this.f1634a, 1);
        taskCompletionSource.setResult(null);
    }
}
