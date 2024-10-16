package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes2.dex */
final class am implements Quests.ClaimMilestoneResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4207a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, Status status) {
        this.f4207a = status;
    }

    @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
    public final Milestone getMilestone() {
        return null;
    }

    @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
    public final Quest getQuest() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4207a;
    }
}
