package com.subao.common.i;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonWriter;

/* loaded from: classes2.dex */
public class b implements Parcelable, com.subao.common.c {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.subao.common.i.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private long f6027a;
    private int b;
    private int c;
    private String d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b(long j, int i, int i2, String str) {
        this.f6027a = j;
        this.b = i;
        this.c = i2;
        this.d = str;
    }

    protected b(Parcel parcel) {
        this.f6027a = parcel.readLong();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("start").value(this.f6027a);
        jsonWriter.name("length").value(this.b);
        jsonWriter.name("type").value(this.c);
        if (this.d != null) {
            jsonWriter.name("id").value(this.d);
        }
        jsonWriter.endObject();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.b == bVar.b && this.c == bVar.c && this.f6027a == bVar.f6027a && com.subao.common.e.a(this.d, bVar.d);
    }

    public int hashCode() {
        int i = this.b | (this.c << 24);
        long j = this.f6027a;
        int i2 = (i ^ ((int) j)) ^ ((int) (j >> 32));
        String str = this.d;
        return str != null ? i2 ^ str.hashCode() : i2;
    }

    public String toString() {
        return String.format(com.subao.common.e.r.f6001a, "[%d-%d, t=%d, id=%s]", Long.valueOf(this.f6027a), Integer.valueOf(this.b), Integer.valueOf(this.c), com.subao.common.n.h.a((Object) this.d));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f6027a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
    }

    public void a() {
        this.f6027a = 0L;
        this.b = 0;
        this.c = 0;
        this.d = "";
    }
}
