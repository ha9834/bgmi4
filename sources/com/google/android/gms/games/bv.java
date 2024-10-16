package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bv extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1636a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TurnBasedMultiplayerClient turnBasedMultiplayerClient, String str) {
        this.f1636a = str;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzeVar.zzb(this.f1636a);
        taskCompletionSource.setResult(null);
    }
}
