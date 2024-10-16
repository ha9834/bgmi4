package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AdResponseParcelCreator")
/* loaded from: classes.dex */
public final class zzari extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzari> CREATOR = new zzarj();

    @SafeParcelable.Field(id = 31)
    private final boolean A;

    @SafeParcelable.Field(id = 32)
    private final boolean B;

    @SafeParcelable.Field(id = 33)
    private final zzato C;

    @SafeParcelable.Field(id = 34)
    private final List<String> D;

    @SafeParcelable.Field(id = 35)
    private final List<String> E;

    @SafeParcelable.Field(id = 36)
    private final boolean F;

    @SafeParcelable.Field(id = 37)
    private final zzark G;

    @SafeParcelable.Field(id = 38)
    private final boolean H;

    @SafeParcelable.Field(id = 39)
    private String I;

    @SafeParcelable.Field(id = 40)
    private final List<String> J;

    @SafeParcelable.Field(id = 42)
    private final boolean K;

    @SafeParcelable.Field(id = 43)
    private final String L;

    @SafeParcelable.Field(id = 44)
    private final zzauy M;

    @SafeParcelable.Field(id = 45)
    private final String N;

    @SafeParcelable.Field(id = 46)
    private final boolean O;

    @SafeParcelable.Field(id = 47)
    private final boolean P;

    @SafeParcelable.Field(id = 48)
    private Bundle Q;

    @SafeParcelable.Field(id = 49)
    private final boolean R;

    @SafeParcelable.Field(id = 50)
    private final int S;

    @SafeParcelable.Field(id = 51)
    private final boolean T;

    @SafeParcelable.Field(id = 52)
    private final List<String> U;

    @SafeParcelable.Field(id = 53)
    private final boolean V;

    @SafeParcelable.Field(id = 54)
    private final String W;

    @SafeParcelable.Field(id = 55)
    private String X;

    @SafeParcelable.Field(id = 56)
    private boolean Y;

    @SafeParcelable.Field(id = 57)
    private boolean Z;

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final int f2787a;

    @SafeParcelable.Field(id = 2)
    private final String b;

    @SafeParcelable.Field(id = 3)
    private String c;

    @SafeParcelable.Field(id = 4)
    private final List<String> d;

    @SafeParcelable.Field(id = 5)
    private final int e;

    @SafeParcelable.Field(id = 6)
    private final List<String> f;

    @SafeParcelable.Field(id = 7)
    private final long g;

    @SafeParcelable.Field(id = 8)
    private final boolean h;

    @SafeParcelable.Field(id = 9)
    private final long i;

    @SafeParcelable.Field(id = 10)
    private final List<String> j;

    @SafeParcelable.Field(id = 11)
    private final long k;

    @SafeParcelable.Field(id = 12)
    private final int l;

    @SafeParcelable.Field(id = 13)
    private final String m;

    @SafeParcelable.Field(id = 14)
    private final long n;

    @SafeParcelable.Field(id = 15)
    private final String o;

    @SafeParcelable.Field(id = 18)
    private final boolean p;

    @SafeParcelable.Field(id = 19)
    private final String q;

    @SafeParcelable.Field(id = 21)
    private final String r;

    @SafeParcelable.Field(id = 22)
    private final boolean s;

    @SafeParcelable.Field(id = 23)
    private final boolean t;

    @SafeParcelable.Field(id = 24)
    private final boolean u;

    @SafeParcelable.Field(id = 25)
    private final boolean v;

    @SafeParcelable.Field(id = 26)
    private final boolean w;

    @SafeParcelable.Field(id = 28)
    private zzaru x;

    @SafeParcelable.Field(id = 29)
    private String y;

    @SafeParcelable.Field(id = 30)
    private final String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzari(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) List<String> list, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) List<String> list2, @SafeParcelable.Param(id = 7) long j, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2, @SafeParcelable.Param(id = 10) List<String> list3, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) int i3, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) long j4, @SafeParcelable.Param(id = 15) String str4, @SafeParcelable.Param(id = 18) boolean z2, @SafeParcelable.Param(id = 19) String str5, @SafeParcelable.Param(id = 21) String str6, @SafeParcelable.Param(id = 22) boolean z3, @SafeParcelable.Param(id = 23) boolean z4, @SafeParcelable.Param(id = 24) boolean z5, @SafeParcelable.Param(id = 25) boolean z6, @SafeParcelable.Param(id = 26) boolean z7, @SafeParcelable.Param(id = 28) zzaru zzaruVar, @SafeParcelable.Param(id = 29) String str7, @SafeParcelable.Param(id = 30) String str8, @SafeParcelable.Param(id = 31) boolean z8, @SafeParcelable.Param(id = 32) boolean z9, @SafeParcelable.Param(id = 33) zzato zzatoVar, @SafeParcelable.Param(id = 34) List<String> list4, @SafeParcelable.Param(id = 35) List<String> list5, @SafeParcelable.Param(id = 36) boolean z10, @SafeParcelable.Param(id = 37) zzark zzarkVar, @SafeParcelable.Param(id = 38) boolean z11, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 40) List<String> list6, @SafeParcelable.Param(id = 42) boolean z12, @SafeParcelable.Param(id = 43) String str10, @SafeParcelable.Param(id = 44) zzauy zzauyVar, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) boolean z13, @SafeParcelable.Param(id = 47) boolean z14, @SafeParcelable.Param(id = 48) Bundle bundle, @SafeParcelable.Param(id = 49) boolean z15, @SafeParcelable.Param(id = 50) int i4, @SafeParcelable.Param(id = 51) boolean z16, @SafeParcelable.Param(id = 52) List<String> list7, @SafeParcelable.Param(id = 53) boolean z17, @SafeParcelable.Param(id = 54) String str12, @SafeParcelable.Param(id = 55) String str13, @SafeParcelable.Param(id = 56) boolean z18, @SafeParcelable.Param(id = 57) boolean z19) {
        boolean z20;
        zzaru zzaruVar2;
        this.f2787a = i;
        this.b = str;
        this.c = str2;
        this.d = list != null ? Collections.unmodifiableList(list) : null;
        this.e = i2;
        this.f = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.g = j;
        this.h = z;
        this.i = j2;
        this.j = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.k = j3;
        this.l = i3;
        this.m = str3;
        this.n = j4;
        this.o = str4;
        this.p = z2;
        this.q = str5;
        this.r = str6;
        this.s = z3;
        this.t = z4;
        this.u = z5;
        this.v = z6;
        this.O = z13;
        this.w = z7;
        this.x = zzaruVar;
        this.y = str7;
        this.z = str8;
        if (this.c != null || (zzaruVar2 = this.x) == null) {
            z20 = z8;
        } else {
            zzarz zzarzVar = (zzarz) zzaruVar2.zza(zzarz.CREATOR);
            if (zzarzVar == null) {
                z20 = z8;
            } else if (TextUtils.isEmpty(zzarzVar.f2789a)) {
                z20 = z8;
            } else {
                this.c = zzarzVar.f2789a;
                z20 = z8;
            }
        }
        this.A = z20;
        this.B = z9;
        this.C = zzatoVar;
        this.D = list4;
        this.E = list5;
        this.F = z10;
        this.G = zzarkVar;
        this.H = z11;
        this.I = str9;
        this.J = list6;
        this.K = z12;
        this.L = str10;
        this.M = zzauyVar;
        this.N = str11;
        this.P = z14;
        this.Q = bundle;
        this.R = z15;
        this.S = i4;
        this.T = z16;
        this.U = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.V = z17;
        this.W = str12;
        this.X = str13;
        this.Y = z18;
        this.Z = z19;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f2787a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.e);
        SafeParcelWriter.writeStringList(parcel, 6, this.f, false);
        SafeParcelWriter.writeLong(parcel, 7, this.g);
        SafeParcelWriter.writeBoolean(parcel, 8, this.h);
        SafeParcelWriter.writeLong(parcel, 9, this.i);
        SafeParcelWriter.writeStringList(parcel, 10, this.j, false);
        SafeParcelWriter.writeLong(parcel, 11, this.k);
        SafeParcelWriter.writeInt(parcel, 12, this.l);
        SafeParcelWriter.writeString(parcel, 13, this.m, false);
        SafeParcelWriter.writeLong(parcel, 14, this.n);
        SafeParcelWriter.writeString(parcel, 15, this.o, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.p);
        SafeParcelWriter.writeString(parcel, 19, this.q, false);
        SafeParcelWriter.writeString(parcel, 21, this.r, false);
        SafeParcelWriter.writeBoolean(parcel, 22, this.s);
        SafeParcelWriter.writeBoolean(parcel, 23, this.t);
        SafeParcelWriter.writeBoolean(parcel, 24, this.u);
        SafeParcelWriter.writeBoolean(parcel, 25, this.v);
        SafeParcelWriter.writeBoolean(parcel, 26, this.w);
        SafeParcelWriter.writeParcelable(parcel, 28, this.x, i, false);
        SafeParcelWriter.writeString(parcel, 29, this.y, false);
        SafeParcelWriter.writeString(parcel, 30, this.z, false);
        SafeParcelWriter.writeBoolean(parcel, 31, this.A);
        SafeParcelWriter.writeBoolean(parcel, 32, this.B);
        SafeParcelWriter.writeParcelable(parcel, 33, this.C, i, false);
        SafeParcelWriter.writeStringList(parcel, 34, this.D, false);
        SafeParcelWriter.writeStringList(parcel, 35, this.E, false);
        SafeParcelWriter.writeBoolean(parcel, 36, this.F);
        SafeParcelWriter.writeParcelable(parcel, 37, this.G, i, false);
        SafeParcelWriter.writeBoolean(parcel, 38, this.H);
        SafeParcelWriter.writeString(parcel, 39, this.I, false);
        SafeParcelWriter.writeStringList(parcel, 40, this.J, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.K);
        SafeParcelWriter.writeString(parcel, 43, this.L, false);
        SafeParcelWriter.writeParcelable(parcel, 44, this.M, i, false);
        SafeParcelWriter.writeString(parcel, 45, this.N, false);
        SafeParcelWriter.writeBoolean(parcel, 46, this.O);
        SafeParcelWriter.writeBoolean(parcel, 47, this.P);
        SafeParcelWriter.writeBundle(parcel, 48, this.Q, false);
        SafeParcelWriter.writeBoolean(parcel, 49, this.R);
        SafeParcelWriter.writeInt(parcel, 50, this.S);
        SafeParcelWriter.writeBoolean(parcel, 51, this.T);
        SafeParcelWriter.writeStringList(parcel, 52, this.U, false);
        SafeParcelWriter.writeBoolean(parcel, 53, this.V);
        SafeParcelWriter.writeString(parcel, 54, this.W, false);
        SafeParcelWriter.writeString(parcel, 55, this.X, false);
        SafeParcelWriter.writeBoolean(parcel, 56, this.Y);
        SafeParcelWriter.writeBoolean(parcel, 57, this.Z);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
