package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes2.dex */
public final class zzbn implements Quests {
    @Override // com.google.android.gms.games.quest.Quests
    public final Intent getQuestsIntent(GoogleApiClient googleApiClient, int[] iArr) {
        return Games.zza(googleApiClient).zza(iArr);
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final Intent getQuestIntent(GoogleApiClient googleApiClient, String str) {
        return Games.zza(googleApiClient).zzd(str);
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final void registerQuestUpdateListener(GoogleApiClient googleApiClient, QuestUpdateListener questUpdateListener) {
        com.google.android.gms.games.internal.zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zze(googleApiClient.registerListener(questUpdateListener));
        }
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final void unregisterQuestUpdateListener(GoogleApiClient googleApiClient) {
        com.google.android.gms.games.internal.zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzbj();
        }
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final PendingResult<Quests.AcceptQuestResult> accept(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new af(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final PendingResult<Quests.ClaimMilestoneResult> claim(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.execute(new ag(this, googleApiClient, str, str2));
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final PendingResult<Quests.LoadQuestsResult> load(GoogleApiClient googleApiClient, int[] iArr, int i, boolean z) {
        return googleApiClient.enqueue(new ah(this, googleApiClient, iArr, i, z));
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final PendingResult<Quests.LoadQuestsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr) {
        return googleApiClient.enqueue(new ai(this, googleApiClient, z, strArr));
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final void showStateChangedPopup(GoogleApiClient googleApiClient, String str) {
        com.google.android.gms.games.internal.zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zze(str);
        }
    }
}
