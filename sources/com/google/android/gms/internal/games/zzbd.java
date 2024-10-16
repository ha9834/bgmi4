package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;

/* loaded from: classes2.dex */
public final class zzbd implements Players {
    @Override // com.google.android.gms.games.Players
    public final String getCurrentPlayerId(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzb(true);
    }

    @Override // com.google.android.gms.games.Players
    public final Player getCurrentPlayer(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzax();
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.enqueue(new w(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str, boolean z) {
        return googleApiClient.enqueue(new x(this, googleApiClient, str, z));
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.enqueue(new y(this, googleApiClient, i, z));
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new z(this, googleApiClient, i));
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.enqueue(new aa(this, googleApiClient, i, z));
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new ab(this, googleApiClient, i));
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new ac(this, googleApiClient, z));
    }

    @Override // com.google.android.gms.games.Players
    public final Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player) {
        return Games.zza(googleApiClient).zzb(new PlayerEntity(player));
    }

    @Override // com.google.android.gms.games.Players
    public final Intent getPlayerSearchIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbm();
    }
}
