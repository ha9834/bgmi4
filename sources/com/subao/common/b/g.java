package com.subao.common.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class g implements Parcelable, com.subao.common.c {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.subao.common.b.g.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i) {
            return new g[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f5925a;
    public final long b;
    public final String c;
    public final int d;
    public final String e;
    public final int f;
    public final int g;
    public final k h;
    public final long i;
    public final int j;
    public final long k;
    public final int l;
    public final int m;
    public final String n;
    public final String o;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public g(String str, long j, String str2, int i, String str3, int i2, long j2, int i3, k kVar, int i4, long j3, int i5, int i6, String str4, String str5) {
        this.f5925a = str;
        this.b = j;
        this.c = str2;
        this.d = i;
        this.e = str3;
        this.f = i2;
        this.i = j2;
        this.g = i3;
        this.h = kVar;
        this.j = i4;
        this.k = j3;
        this.l = i5;
        this.m = i6;
        this.n = str4;
        this.o = str5;
    }

    protected g(Parcel parcel) {
        this.f5925a = parcel.readString();
        this.b = parcel.readLong();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = (k) parcel.readParcelable(k.class.getClassLoader());
        this.i = parcel.readLong();
        this.j = parcel.readInt();
        this.k = parcel.readLong();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readString();
        this.o = parcel.readString();
    }

    public static g a(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException();
        }
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
        try {
            return a(jsonReader);
        } finally {
            com.subao.common.e.a(jsonReader);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static g a(JsonReader jsonReader) {
        if (jsonReader == null) {
            throw new NullPointerException();
        }
        try {
            jsonReader.setLenient(true);
            jsonReader.beginObject();
            String str = "";
            String str2 = "";
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            k kVar = null;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("accelToken".equals(nextName)) {
                    str3 = jsonReader.nextString();
                } else if ("expiresIn".equals(nextName)) {
                    j = jsonReader.nextLong();
                } else if ("shortId".equals(nextName)) {
                    str4 = jsonReader.nextString();
                } else if ("userStatus".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if ("accelExpiredTime".equals(nextName)) {
                    str5 = jsonReader.nextString();
                } else if ("totalAccelDays".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("currentTime".equals(nextName)) {
                    j2 = jsonReader.nextLong();
                } else if ("contractStatus".equals(nextName)) {
                    i3 = jsonReader.nextInt();
                } else if ("scopes".equals(nextName)) {
                    kVar = k.a(jsonReader);
                } else if ("purchaseTimes".equals(nextName)) {
                    i4 = jsonReader.nextInt();
                } else if ("creditStart".equals(nextName)) {
                    j3 = jsonReader.nextLong();
                } else if ("creditLength".equals(nextName)) {
                    i5 = jsonReader.nextInt();
                } else if ("creditType".equals(nextName)) {
                    i6 = jsonReader.nextInt();
                } else if ("creditID".equals(nextName)) {
                    str = jsonReader.nextString();
                } else if ("portraits".equals(nextName)) {
                    str2 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (str3 == null) {
                throw new IOException("Create fail");
            }
            return new g(str3, j, str4, i, str5, i2, j2, i3, kVar, i4, j3, i5, i6, str, str2);
        } catch (RuntimeException e) {
            throw new IOException(e.getMessage());
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.b == gVar.b && a(gVar);
    }

    public boolean a(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar == this) {
            return true;
        }
        return this.f == gVar.f && this.d == gVar.d && this.i == gVar.i && this.g == gVar.g && this.j == gVar.j && this.k == gVar.k && this.l == gVar.l && this.m == gVar.m && com.subao.common.e.a(this.n, gVar.n) && com.subao.common.e.a(this.f5925a, gVar.f5925a) && com.subao.common.e.a(this.c, gVar.c) && com.subao.common.e.a(this.e, gVar.e) && com.subao.common.e.a(this.h, gVar.h) && com.subao.common.e.a(this.o, gVar.o);
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        com.subao.common.n.g.a(jsonWriter, "accelToken", this.f5925a);
        jsonWriter.name("expiresIn").value(this.b);
        com.subao.common.n.g.a(jsonWriter, "shortId", this.c);
        jsonWriter.name("userStatus").value(this.d);
        com.subao.common.n.g.a(jsonWriter, "accelExpiredTime", this.e);
        jsonWriter.name("totalAccelDays").value(this.f);
        jsonWriter.name("currentTime").value(this.i);
        jsonWriter.name("contractStatus").value(this.g);
        com.subao.common.n.g.a(jsonWriter, "scopes", this.h);
        jsonWriter.name("purchaseTimes").value(this.j);
        jsonWriter.name("creditStart").value(this.k);
        jsonWriter.name("creditLength").value(this.l);
        jsonWriter.name("creditType").value(this.m);
        jsonWriter.name("creditID").value(this.n);
        jsonWriter.name("portraits").value(this.o);
        jsonWriter.endObject();
    }

    public g a(long j) {
        return new g(this.f5925a, j, this.c, this.d, this.e, this.f, this.i, this.g, this.h, this.j, this.k, this.l, this.m, this.n, this.o);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5925a);
        parcel.writeLong(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeParcelable(this.h, i);
        parcel.writeLong(this.i);
        parcel.writeInt(this.j);
        parcel.writeLong(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
    }
}
