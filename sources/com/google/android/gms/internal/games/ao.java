package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes2.dex */
final class ao implements Quests.LoadQuestsResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4208a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, Status status) {
        this.f4208a = status;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4208a;
    }

    @Override // com.google.android.gms.games.quest.Quests.LoadQuestsResult
    public final QuestBuffer getQuests() {
        return new QuestBuffer(DataHolder.empty(this.f4208a.getStatusCode()));
    }
}
