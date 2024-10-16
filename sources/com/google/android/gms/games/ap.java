package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes.dex */
final class ap implements ListenerHolder.Notifier<com.google.android.gms.games.multiplayer.realtime.zzh> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ao f1621a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.f1621a = aoVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
        this.f1621a.f1620a.c.getRoomUpdateCallback().onLeftRoom(0, this.f1621a.f1620a.b);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(com.google.android.gms.games.multiplayer.realtime.zzh zzhVar) {
        zzhVar.onLeftRoom(0, this.f1621a.f1620a.b);
    }
}
