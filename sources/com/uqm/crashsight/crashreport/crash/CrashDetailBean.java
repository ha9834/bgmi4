package com.uqm.crashsight.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.uqm.crashsight.crashreport.common.info.PlugInBean;
import com.uqm.crashsight.proguard.q;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.uqm.crashsight.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i) {
            return new CrashDetailBean[i];
        }
    };
    public Map<String, String> A;
    public String B;
    public String C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public String J;
    public String K;
    public String L;
    public String M;
    public long N;
    public boolean O;
    public Map<String, String> P;
    public Map<String, String> Q;
    public int R;
    public int S;
    public Map<String, String> T;
    public Map<String, String> U;
    public byte[] V;
    public String W;
    public String X;
    private String Y;

    /* renamed from: a, reason: collision with root package name */
    public long f6577a;
    public int b;
    public String c;
    public boolean d;
    public String e;
    public String f;
    public String g;
    public Map<String, PlugInBean> h;
    public Map<String, PlugInBean> i;
    public boolean j;
    public boolean k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public long s;
    public String t;
    public int u;
    public String v;
    public String w;
    public String x;
    public String y;
    public byte[] z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return 1;
        }
        long j = this.s - crashDetailBean2.s;
        if (j <= 0) {
            return j < 0 ? -1 : 0;
        }
        return 1;
    }

    public CrashDetailBean() {
        this.f6577a = -1L;
        this.b = 0;
        this.c = UUID.randomUUID().toString();
        this.d = false;
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = -1L;
        this.t = null;
        this.u = 0;
        this.v = "";
        this.w = "";
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = "";
        this.C = "";
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = "";
        this.Y = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = -1L;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = -1;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
    }

    public CrashDetailBean(Parcel parcel) {
        this.f6577a = -1L;
        this.b = 0;
        this.c = UUID.randomUUID().toString();
        this.d = false;
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = -1L;
        this.t = null;
        this.u = 0;
        this.v = "";
        this.w = "";
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = "";
        this.C = "";
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = "";
        this.Y = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = -1L;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = -1;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readByte() == 1;
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.j = parcel.readByte() == 1;
        this.k = parcel.readByte() == 1;
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.s = parcel.readLong();
        this.t = parcel.readString();
        this.u = parcel.readInt();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.A = q.b(parcel);
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.I = parcel.readLong();
        this.J = parcel.readString();
        this.Y = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readLong();
        this.O = parcel.readByte() == 1;
        this.P = q.b(parcel);
        this.h = q.a(parcel);
        this.i = q.a(parcel);
        this.R = parcel.readInt();
        this.S = parcel.readInt();
        this.T = q.b(parcel);
        this.U = q.b(parcel);
        this.V = parcel.createByteArray();
        this.z = parcel.createByteArray();
        this.W = parcel.readString();
        this.X = parcel.readString();
        this.y = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeLong(this.s);
        parcel.writeString(this.t);
        parcel.writeInt(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        q.b(parcel, this.A);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeLong(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.Y);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeLong(this.N);
        parcel.writeByte(this.O ? (byte) 1 : (byte) 0);
        q.b(parcel, this.P);
        q.a(parcel, this.h);
        q.a(parcel, this.i);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        q.b(parcel, this.T);
        q.b(parcel, this.U);
        parcel.writeByteArray(this.V);
        parcel.writeByteArray(this.z);
        parcel.writeString(this.W);
        parcel.writeString(this.X);
        parcel.writeString(this.y);
    }
}
