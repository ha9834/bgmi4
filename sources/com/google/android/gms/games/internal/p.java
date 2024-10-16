package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import java.util.ArrayList;

/* loaded from: classes.dex */
final /* synthetic */ class p implements zze.w {

    /* renamed from: a, reason: collision with root package name */
    static final zze.w f1679a = new p();

    private p() {
    }

    @Override // com.google.android.gms.games.internal.zze.w
    public final void a(Object obj, Room room, ArrayList arrayList) {
        ((RoomStatusUpdateListener) obj).onPeerJoined(room, arrayList);
    }
}
