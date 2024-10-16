package com.subao.common.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonReader;
import android.util.JsonWriter;
import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;

/* loaded from: classes2.dex */
public class k implements Parcelable, com.subao.common.c {
    public static final Parcelable.Creator<k> CREATOR = new Parcelable.Creator<k>() { // from class: com.subao.common.b.k.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i) {
            return new k[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final long f5929a;
    public final long b;
    public final long c;
    public final long d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public k(long j, long j2, long j3, long j4) {
        this.f5929a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }

    protected k(Parcel parcel) {
        this.f5929a = parcel.readLong();
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static k a(JsonReader jsonReader) {
        if (jsonReader == null) {
            throw new NullPointerException();
        }
        try {
            jsonReader.setLenient(true);
            jsonReader.beginObject();
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (jsonReader.hasNext()) {
                String trim = jsonReader.nextName().trim();
                if ("backbone".equals(trim)) {
                    j = jsonReader.nextLong();
                } else if ("multi".equals(trim)) {
                    j2 = jsonReader.nextLong();
                } else if ("qos".equals(trim)) {
                    j3 = jsonReader.nextLong();
                } else if ("mtk".equals(trim)) {
                    j4 = jsonReader.nextLong();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return new k(j, j2, j3, j4);
        } catch (RuntimeException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static String a(k kVar, long j) {
        return kVar == null ? "" : kVar.a(j);
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("backbone").value(this.f5929a);
        jsonWriter.name("multi").value(this.b);
        jsonWriter.name("qos").value(this.c);
        jsonWriter.name("mtk").value(this.d);
        jsonWriter.endObject();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kVar.f5929a == this.f5929a && kVar.b == this.b && kVar.c == this.c && kVar.d == this.d;
    }

    private String a(long j) {
        if (this.f5929a == 0 && this.b == 0 && this.c == 0 && this.d == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(256);
        if (this.f5929a > 0) {
            sb.append("backbone");
            sb.append(CertificateUtil.DELIMITER);
            sb.append(j);
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.f5929a);
            sb.append(",");
        }
        if (this.b > 0) {
            sb.append("multi");
            sb.append(CertificateUtil.DELIMITER);
            sb.append(j);
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.b);
            sb.append(",");
        }
        if (this.c > 0) {
            sb.append("qos");
            sb.append(CertificateUtil.DELIMITER);
            sb.append(j);
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.c);
            sb.append(",");
        }
        if (this.d > 0) {
            sb.append("mtk");
            sb.append(CertificateUtil.DELIMITER);
            sb.append(j);
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.d);
            sb.append(",");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f5929a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
    }
}
