package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

/* loaded from: classes.dex */
final /* synthetic */ class n implements zze.aa {

    /* renamed from: a, reason: collision with root package name */
    static final zze.aa f1677a = new n();

    private n() {
    }

    @Override // com.google.android.gms.games.internal.zze.aa
    public final void a(Object obj, int i, Room room) {
        ((RoomUpdateListener) obj).onJoinedRoom(i, room);
    }
}
