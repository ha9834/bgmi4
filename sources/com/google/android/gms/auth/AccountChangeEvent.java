package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.abase.utils.ConstantUtils;

@SafeParcelable.Class(creator = "AccountChangeEventCreator")
/* loaded from: classes.dex */
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f1211a;

    @SafeParcelable.Field(id = 2)
    private final long b;

    @SafeParcelable.Field(id = 3)
    private final String c;

    @SafeParcelable.Field(id = 4)
    private final int d;

    @SafeParcelable.Field(id = 5)
    private final int e;

    @SafeParcelable.Field(id = 6)
    private final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AccountChangeEvent(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) String str2) {
        this.f1211a = i;
        this.b = j;
        this.c = (String) Preconditions.checkNotNull(str);
        this.d = i2;
        this.e = i3;
        this.f = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.f1211a = 1;
        this.b = j;
        this.c = (String) Preconditions.checkNotNull(str);
        this.d = i;
        this.e = i2;
        this.f = str2;
    }

    public String getAccountName() {
        return this.c;
    }

    public int getChangeType() {
        return this.d;
    }

    public int getEventIndex() {
        return this.e;
    }

    public String getChangeData() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f1211a);
        SafeParcelWriter.writeLong(parcel, 2, this.b);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeInt(parcel, 4, this.d);
        SafeParcelWriter.writeInt(parcel, 5, this.e);
        SafeParcelWriter.writeString(parcel, 6, this.f, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public String toString() {
        String str = ConstantUtils.NET_UNKNOWN;
        switch (this.d) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        String str2 = this.c;
        String str3 = this.f;
        int i = this.e;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 91 + String.valueOf(str).length() + String.valueOf(str3).length());
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(str2);
        sb.append(", changeType = ");
        sb.append(str);
        sb.append(", changeData = ");
        sb.append(str3);
        sb.append(", eventIndex = ");
        sb.append(i);
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f1211a), Long.valueOf(this.b), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e), this.f);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.f1211a == accountChangeEvent.f1211a && this.b == accountChangeEvent.b && Objects.equal(this.c, accountChangeEvent.c) && this.d == accountChangeEvent.d && this.e == accountChangeEvent.e && Objects.equal(this.f, accountChangeEvent.f);
    }
}
