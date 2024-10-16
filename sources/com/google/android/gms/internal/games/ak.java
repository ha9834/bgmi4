package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes2.dex */
final class ak implements Quests.AcceptQuestResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4206a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, Status status) {
        this.f4206a = status;
    }

    @Override // com.google.android.gms.games.quest.Quests.AcceptQuestResult
    public final Quest getQuest() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4206a;
    }
}
