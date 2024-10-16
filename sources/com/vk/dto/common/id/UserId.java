package com.vk.dto.common.id;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class UserId implements Parcelable {
    private final long c;

    /* renamed from: a, reason: collision with root package name */
    public static final a f6933a = new a(null);
    public static final UserId b = new UserId(0);
    public static final Parcelable.Creator<UserId> CREATOR = new b();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserId) && this.c == ((UserId) obj).c;
    }

    public int hashCode() {
        return Long.hashCode(this.c);
    }

    public UserId(long j) {
        this.c = j;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserId(Parcel parcel) {
        this(parcel.readLong());
        h.b(parcel, "parcel");
    }

    public String toString() {
        return String.valueOf(this.c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        h.b(parcel, "dest");
        parcel.writeLong(this.c);
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements Parcelable.Creator<UserId> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserId createFromParcel(Parcel parcel) {
            h.b(parcel, "source");
            return new UserId(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserId[] newArray(int i) {
            return new UserId[i];
        }
    }
}
