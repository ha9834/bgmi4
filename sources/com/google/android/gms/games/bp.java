package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbo;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bp extends zzbo<OnTurnBasedMatchUpdateReceivedListener> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ListenerHolder f1632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(TurnBasedMultiplayerClient turnBasedMultiplayerClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.f1632a = listenerHolder2;
    }

    @Override // com.google.android.gms.games.internal.zzbo
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException, SecurityException {
        zzeVar.zzc(this.f1632a);
        taskCompletionSource.setResult(null);
    }
}
