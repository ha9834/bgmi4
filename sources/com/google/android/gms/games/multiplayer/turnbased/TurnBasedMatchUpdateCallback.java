package com.google.android.gms.games.multiplayer.turnbased;

/* loaded from: classes.dex */
public abstract class TurnBasedMatchUpdateCallback implements OnTurnBasedMatchUpdateReceivedListener {
    @Override // com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener
    public abstract void onTurnBasedMatchReceived(TurnBasedMatch turnBasedMatch);

    @Override // com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener
    public abstract void onTurnBasedMatchRemoved(String str);
}
