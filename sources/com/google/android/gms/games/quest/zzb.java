package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzbd;

/* loaded from: classes.dex */
public final class zzb extends DataBufferRef implements Milestone {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final String getMilestoneId() {
        return d("external_milestone_id");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final long getCurrentProgress() {
        long j;
        long j2 = 0;
        switch (getState()) {
            case 1:
                j = 0;
                break;
            case 2:
                j = a("current_value");
                if (a("quest_state") != 6) {
                    j -= a("initial_value");
                    break;
                }
                break;
            case 3:
            case 4:
                j = getTargetProgress();
                break;
            default:
                j = 0;
                break;
        }
        if (j < 0) {
            zzbd.e("MilestoneRef", "Current progress should never be negative");
        } else {
            j2 = j;
        }
        if (j2 <= getTargetProgress()) {
            return j2;
        }
        zzbd.e("MilestoneRef", "Current progress should never exceed target progress");
        return getTargetProgress();
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final String getEventId() {
        return d("external_event_id");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final long getTargetProgress() {
        return a("target_value");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final byte[] getCompletionRewardData() {
        return f("completion_reward_data");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final int getState() {
        return b("milestone_state");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return MilestoneEntity.a(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return MilestoneEntity.a(this, obj);
    }

    public final String toString() {
        return MilestoneEntity.b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((MilestoneEntity) ((Milestone) freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Milestone freeze() {
        return new MilestoneEntity(this);
    }
}
