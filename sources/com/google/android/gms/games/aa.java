package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class aa extends zzag<Intent> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Room f1607a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(RealTimeMultiplayerClient realTimeMultiplayerClient, Room room, int i) {
        this.f1607a = room;
        this.b = i;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzeVar.zza(this.f1607a, this.b));
    }
}
