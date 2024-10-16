package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class u extends zzag<Intent> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Player f1742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PlayersClient playersClient, Player player) {
        this.f1742a = player;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzeVar.zza(new PlayerEntity(this.f1742a)));
    }
}
