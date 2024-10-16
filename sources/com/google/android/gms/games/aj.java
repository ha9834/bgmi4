package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbo;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class aj extends zzbo<com.google.android.gms.games.multiplayer.realtime.zzh> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ListenerHolder f1617a;
    private final /* synthetic */ RoomConfig b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2, RoomConfig roomConfig) {
        super(listenerHolder);
        this.f1617a = listenerHolder2;
        this.b = roomConfig;
    }

    @Override // com.google.android.gms.games.internal.zzbo
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException, SecurityException {
        ListenerHolder<? extends RoomUpdateListener> listenerHolder = this.f1617a;
        zzeVar.zza(listenerHolder, (ListenerHolder<? extends RoomStatusUpdateListener>) listenerHolder, (ListenerHolder<? extends RealTimeMessageReceivedListener>) listenerHolder, this.b);
        taskCompletionSource.setResult(null);
    }
}
