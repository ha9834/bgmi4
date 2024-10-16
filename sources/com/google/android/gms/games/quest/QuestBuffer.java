package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
@Deprecated
/* loaded from: classes.dex */
public final class QuestBuffer extends EntityBuffer<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final String a() {
        return "external_quest_id";
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final /* synthetic */ Quest a(int i, int i2) {
        return new QuestRef(this.f1413a, i, i2);
    }
}
