package com.google.android.gms.games.multiplayer.realtime;

import java.util.List;

/* loaded from: classes.dex */
public final class zzg implements zzh {

    /* renamed from: a, reason: collision with root package name */
    private final RoomUpdateCallback f1727a;
    private final RoomStatusUpdateCallback b;
    private final OnRealTimeMessageReceivedListener c;

    public zzg(RoomUpdateCallback roomUpdateCallback, RoomStatusUpdateCallback roomStatusUpdateCallback, OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener) {
        this.f1727a = roomUpdateCallback;
        this.b = roomStatusUpdateCallback;
        this.c = onRealTimeMessageReceivedListener;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.OnRealTimeMessageReceivedListener, com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener
    public final void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
        OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener = this.c;
        if (onRealTimeMessageReceivedListener != null) {
            onRealTimeMessageReceivedListener.onRealTimeMessageReceived(realTimeMessage);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onRoomConnecting(Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onRoomConnecting(room);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onRoomAutoMatching(Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onRoomAutoMatching(room);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onPeerInvitedToRoom(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerInvitedToRoom(room, list);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onPeerDeclined(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerDeclined(room, list);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onPeerJoined(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerJoined(room, list);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onPeerLeft(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerLeft(room, list);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onConnectedToRoom(Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onConnectedToRoom(room);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onDisconnectedFromRoom(Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onDisconnectedFromRoom(room);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onPeersConnected(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeersConnected(room, list);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onPeersDisconnected(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeersDisconnected(room, list);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onP2PConnected(String str) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onP2PConnected(str);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public final void onP2PDisconnected(String str) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.b;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onP2PDisconnected(str);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public final void onRoomCreated(int i, Room room) {
        RoomUpdateCallback roomUpdateCallback = this.f1727a;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onRoomCreated(i, room);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public final void onJoinedRoom(int i, Room room) {
        RoomUpdateCallback roomUpdateCallback = this.f1727a;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onJoinedRoom(i, room);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public final void onLeftRoom(int i, String str) {
        RoomUpdateCallback roomUpdateCallback = this.f1727a;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onLeftRoom(i, str);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public final void onRoomConnected(int i, Room room) {
        RoomUpdateCallback roomUpdateCallback = this.f1727a;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onRoomConnected(i, room);
        }
    }
}
