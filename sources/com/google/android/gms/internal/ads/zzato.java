package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;
import org.json.JSONException;

@zzard
@SafeParcelable.Class(creator = "RewardItemParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzato extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzato> CREATOR = new zzatp();

    @SafeParcelable.Field(id = 2)
    public final String type;

    @SafeParcelable.Field(id = 3)
    public final int zzdqm;

    public zzato(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    @SafeParcelable.Constructor
    public zzato(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i) {
        this.type = str;
        this.zzdqm = i;
    }

    public static zzato zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzato(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.type, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdqm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzato)) {
            return false;
        }
        zzato zzatoVar = (zzato) obj;
        return Objects.equal(this.type, zzatoVar.type) && Objects.equal(Integer.valueOf(this.zzdqm), Integer.valueOf(zzatoVar.zzdqm));
    }

    public final int hashCode() {
        return Objects.hashCode(this.type, Integer.valueOf(this.zzdqm));
    }
}
