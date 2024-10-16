package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.zzf;
import com.uqm.crashsight.CrashSight;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SafeParcelable.Class(creator = "SortOrderCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class SortOrder extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SortOrder> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final List<zzf> f1562a;

    @SafeParcelable.Field(defaultValue = CrashSight.SDK_IS_DEV, id = 2)
    private final boolean b;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final List<zzf> f1563a = new ArrayList();
        private boolean b = false;

        public Builder addSortAscending(SortableMetadataField sortableMetadataField) {
            this.f1563a.add(new zzf(sortableMetadataField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortableMetadataField) {
            this.f1563a.add(new zzf(sortableMetadataField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder(this.f1563a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public SortOrder(@SafeParcelable.Param(id = 1) List<zzf> list, @SafeParcelable.Param(id = 2) boolean z) {
        this.f1562a = list;
        this.b = z;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", TextUtils.join(",", this.f1562a), Boolean.valueOf(this.b));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f1562a, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
