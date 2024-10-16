package com.subao.common.i;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonWriter;
import com.subao.common.e.ao;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;

/* loaded from: classes2.dex */
public class k implements Parcelable, com.subao.common.c {
    public static final Parcelable.Creator<k> CREATOR = new Parcelable.Creator<k>() { // from class: com.subao.common.i.k.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() >= 0 ? b.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i) {
            return new k[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private static a f6041a;
    private static String b;
    private static String c;
    private static String d;
    private static int e;
    private static String f;
    private static String g;
    private static b h;
    private String i = "";
    private String j;
    private String k;
    private int l;
    private String m;
    private b n;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);

        void a(String str, String str2, int i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    k(String str, String str2, String str3, int i, String str4, b bVar) {
        this.j = str2;
        this.k = str3;
        this.l = i;
        this.m = str4;
        this.n = bVar;
    }

    private static synchronized a i() {
        a aVar;
        synchronized (k.class) {
            aVar = f6041a;
        }
        return aVar;
    }

    public static k a() {
        return new k(b(), c(), d(), e(), f(), g());
    }

    public static synchronized String b() {
        String str;
        synchronized (k.class) {
            str = b;
        }
        return str;
    }

    public static synchronized void a(String str) {
        synchronized (k.class) {
            b = str;
            a i = i();
            if (i != null) {
                i.a(str);
            }
        }
    }

    public static void b(String str) {
        c = str;
        d = null;
        e = 0;
        f = null;
        g = null;
        h = null;
    }

    public static synchronized void a(String str, String str2, int i, String str3, b bVar) {
        synchronized (k.class) {
            c = str;
            d = str2;
            e = i;
            f = null;
            g = str3;
            h = bVar;
            a i2 = i();
            if (i2 != null) {
                i2.a(str, str2, i);
            }
        }
    }

    public static synchronized String c() {
        String str;
        synchronized (k.class) {
            str = c;
        }
        return str;
    }

    public static synchronized String d() {
        String str;
        synchronized (k.class) {
            str = d;
        }
        return str;
    }

    public static synchronized int e() {
        int i;
        synchronized (k.class) {
            i = e;
        }
        return i;
    }

    public static synchronized String f() {
        String str;
        synchronized (k.class) {
            str = f;
        }
        return str;
    }

    public static b g() {
        return h;
    }

    public static void a(String str, String str2) {
        if (str == null || !str.equals(c)) {
            return;
        }
        f = str2;
    }

    public String toString() {
        return String.format(com.subao.common.e.r.f6001a, "[subaoId=%s, userId=%s, serviceId=%s, userStatus=%d, config=%s]", this.i, this.j, this.k, Integer.valueOf(this.l), this.m);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.l == kVar.l && com.subao.common.e.a(this.i, kVar.i) && com.subao.common.e.a(this.j, kVar.j) && com.subao.common.e.a(this.k, kVar.k) && com.subao.common.e.a(this.m, kVar.m) && com.subao.common.e.a(this.n, kVar.n);
    }

    public int hashCode() {
        int i = this.l;
        for (Object obj : new Object[]{this.i, this.j, this.k, this.m, this.n}) {
            if (obj != null) {
                i ^= obj.hashCode();
            }
        }
        return i;
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        com.subao.common.n.g.a(jsonWriter, "id", this.i);
        com.subao.common.n.g.a(jsonWriter, "userId", this.j);
        com.subao.common.n.g.a(jsonWriter, "serviceId", this.k);
        jsonWriter.name("stat").value(this.l);
        com.subao.common.n.g.a(jsonWriter, ConfigDBHelper.TABLE_NAME_CONFIG, this.m);
        com.subao.common.n.g.a(jsonWriter, "credit", this.n);
        jsonWriter.endObject();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        if (this.n == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(0);
            this.n.writeToParcel(parcel, 0);
        }
    }

    public void h() {
        this.i = ao.b().c();
        this.j = "";
        this.k = "";
        this.l = 0;
        this.m = "";
        this.n.a();
    }
}
