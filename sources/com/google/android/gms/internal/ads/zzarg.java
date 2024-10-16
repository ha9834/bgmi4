package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
/* loaded from: classes.dex */
public final class zzarg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarg> CREATOR = new zzarh();

    @SafeParcelable.Field(id = 31)
    private final long A;

    @SafeParcelable.Field(id = 33)
    private final String B;

    @SafeParcelable.Field(id = 34)
    private final float C;

    @SafeParcelable.Field(id = 35)
    private final int D;

    @SafeParcelable.Field(id = 36)
    private final int E;

    @SafeParcelable.Field(id = 37)
    private final boolean F;

    @SafeParcelable.Field(id = 38)
    private final boolean G;

    @SafeParcelable.Field(id = 39)
    private final String H;

    @SafeParcelable.Field(id = 40)
    private final boolean I;

    @SafeParcelable.Field(id = 41)
    private final String J;

    @SafeParcelable.Field(id = 42)
    private final boolean K;

    @SafeParcelable.Field(id = 43)
    private final int L;

    @SafeParcelable.Field(id = 44)
    private final Bundle M;

    @SafeParcelable.Field(id = 45)
    private final String N;

    @SafeParcelable.Field(id = 46)
    private final zzaax O;

    @SafeParcelable.Field(id = 47)
    private final boolean P;

    @SafeParcelable.Field(id = 48)
    private final Bundle Q;

    @SafeParcelable.Field(id = 49)
    private final String R;

    @SafeParcelable.Field(id = 50)
    private final String S;

    @SafeParcelable.Field(id = 51)
    private final String T;

    @SafeParcelable.Field(id = 52)
    private final boolean U;

    @SafeParcelable.Field(id = 53)
    private final List<Integer> V;

    @SafeParcelable.Field(id = 54)
    private final String W;

    @SafeParcelable.Field(id = 55)
    private final List<String> X;

    @SafeParcelable.Field(id = 56)
    private final int Y;

    @SafeParcelable.Field(id = 57)
    private final boolean Z;

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final int f2786a;

    @SafeParcelable.Field(id = 58)
    private final boolean aa;

    @SafeParcelable.Field(id = 59)
    private final boolean ab;

    @SafeParcelable.Field(id = 60)
    private final ArrayList<String> ac;

    @SafeParcelable.Field(id = 61)
    private final String ad;

    @SafeParcelable.Field(id = 63)
    private final zzaiy ae;

    @SafeParcelable.Field(id = 64)
    private final String af;

    @SafeParcelable.Field(id = 65)
    private final Bundle ag;

    @SafeParcelable.Field(id = 2)
    private final Bundle b;

    @SafeParcelable.Field(id = 3)
    private final zzxz c;

    @SafeParcelable.Field(id = 4)
    private final zzyd d;

    @SafeParcelable.Field(id = 5)
    private final String e;

    @SafeParcelable.Field(id = 6)
    private final ApplicationInfo f;

    @SafeParcelable.Field(id = 7)
    private final PackageInfo g;

    @SafeParcelable.Field(id = 8)
    private final String h;

    @SafeParcelable.Field(id = 9)
    private final String i;

    @SafeParcelable.Field(id = 10)
    private final String j;

    @SafeParcelable.Field(id = 11)
    private final zzbai k;

    @SafeParcelable.Field(id = 12)
    private final Bundle l;

    @SafeParcelable.Field(id = 13)
    private final int m;

    @SafeParcelable.Field(id = 14)
    private final List<String> n;

    @SafeParcelable.Field(id = 15)
    private final Bundle o;

    @SafeParcelable.Field(id = 16)
    private final boolean p;

    @SafeParcelable.Field(id = 18)
    private final int q;

    @SafeParcelable.Field(id = 19)
    private final int r;

    @SafeParcelable.Field(id = 20)
    private final float s;

    @SafeParcelable.Field(id = 21)
    private final String t;

    @SafeParcelable.Field(id = 25)
    private final long u;

    @SafeParcelable.Field(id = 26)
    private final String v;

    @SafeParcelable.Field(id = 27)
    private final List<String> w;

    @SafeParcelable.Field(id = 28)
    private final String x;

    @SafeParcelable.Field(id = 29)
    private final zzady y;

    @SafeParcelable.Field(id = 30)
    private final List<String> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzarg(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Bundle bundle, @SafeParcelable.Param(id = 3) zzxz zzxzVar, @SafeParcelable.Param(id = 4) zzyd zzydVar, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 7) PackageInfo packageInfo, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) String str4, @SafeParcelable.Param(id = 11) zzbai zzbaiVar, @SafeParcelable.Param(id = 12) Bundle bundle2, @SafeParcelable.Param(id = 13) int i2, @SafeParcelable.Param(id = 14) List<String> list, @SafeParcelable.Param(id = 15) Bundle bundle3, @SafeParcelable.Param(id = 16) boolean z, @SafeParcelable.Param(id = 18) int i3, @SafeParcelable.Param(id = 19) int i4, @SafeParcelable.Param(id = 20) float f, @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 25) long j, @SafeParcelable.Param(id = 26) String str6, @SafeParcelable.Param(id = 27) List<String> list2, @SafeParcelable.Param(id = 28) String str7, @SafeParcelable.Param(id = 29) zzady zzadyVar, @SafeParcelable.Param(id = 30) List<String> list3, @SafeParcelable.Param(id = 31) long j2, @SafeParcelable.Param(id = 33) String str8, @SafeParcelable.Param(id = 34) float f2, @SafeParcelable.Param(id = 40) boolean z2, @SafeParcelable.Param(id = 35) int i5, @SafeParcelable.Param(id = 36) int i6, @SafeParcelable.Param(id = 37) boolean z3, @SafeParcelable.Param(id = 38) boolean z4, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 41) String str10, @SafeParcelable.Param(id = 42) boolean z5, @SafeParcelable.Param(id = 43) int i7, @SafeParcelable.Param(id = 44) Bundle bundle4, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) zzaax zzaaxVar, @SafeParcelable.Param(id = 47) boolean z6, @SafeParcelable.Param(id = 48) Bundle bundle5, @SafeParcelable.Param(id = 49) String str12, @SafeParcelable.Param(id = 50) String str13, @SafeParcelable.Param(id = 51) String str14, @SafeParcelable.Param(id = 52) boolean z7, @SafeParcelable.Param(id = 53) List<Integer> list4, @SafeParcelable.Param(id = 54) String str15, @SafeParcelable.Param(id = 55) List<String> list5, @SafeParcelable.Param(id = 56) int i8, @SafeParcelable.Param(id = 57) boolean z8, @SafeParcelable.Param(id = 58) boolean z9, @SafeParcelable.Param(id = 59) boolean z10, @SafeParcelable.Param(id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(id = 61) String str16, @SafeParcelable.Param(id = 63) zzaiy zzaiyVar, @SafeParcelable.Param(id = 64) String str17, @SafeParcelable.Param(id = 65) Bundle bundle6) {
        List<String> unmodifiableList;
        List<String> unmodifiableList2;
        this.f2786a = i;
        this.b = bundle;
        this.c = zzxzVar;
        this.d = zzydVar;
        this.e = str;
        this.f = applicationInfo;
        this.g = packageInfo;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = zzbaiVar;
        this.l = bundle2;
        this.m = i2;
        this.n = list;
        if (list3 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list3);
        }
        this.z = unmodifiableList;
        this.o = bundle3;
        this.p = z;
        this.q = i3;
        this.r = i4;
        this.s = f;
        this.t = str5;
        this.u = j;
        this.v = str6;
        if (list2 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            unmodifiableList2 = Collections.unmodifiableList(list2);
        }
        this.w = unmodifiableList2;
        this.x = str7;
        this.y = zzadyVar;
        this.A = j2;
        this.B = str8;
        this.C = f2;
        this.I = z2;
        this.D = i5;
        this.E = i6;
        this.F = z3;
        this.G = z4;
        this.H = str9;
        this.J = str10;
        this.K = z5;
        this.L = i7;
        this.M = bundle4;
        this.N = str11;
        this.O = zzaaxVar;
        this.P = z6;
        this.Q = bundle5;
        this.R = str12;
        this.S = str13;
        this.T = str14;
        this.U = z7;
        this.V = list4;
        this.W = str15;
        this.X = list5;
        this.Y = i8;
        this.Z = z8;
        this.aa = z9;
        this.ab = z10;
        this.ac = arrayList;
        this.ad = str16;
        this.ae = zzaiyVar;
        this.af = str17;
        this.ag = bundle6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f2786a);
        SafeParcelWriter.writeBundle(parcel, 2, this.b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.c, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.d, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.e, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.g, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.h, false);
        SafeParcelWriter.writeString(parcel, 9, this.i, false);
        SafeParcelWriter.writeString(parcel, 10, this.j, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.k, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.l, false);
        SafeParcelWriter.writeInt(parcel, 13, this.m);
        SafeParcelWriter.writeStringList(parcel, 14, this.n, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.o, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.p);
        SafeParcelWriter.writeInt(parcel, 18, this.q);
        SafeParcelWriter.writeInt(parcel, 19, this.r);
        SafeParcelWriter.writeFloat(parcel, 20, this.s);
        SafeParcelWriter.writeString(parcel, 21, this.t, false);
        SafeParcelWriter.writeLong(parcel, 25, this.u);
        SafeParcelWriter.writeString(parcel, 26, this.v, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.w, false);
        SafeParcelWriter.writeString(parcel, 28, this.x, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.y, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.z, false);
        SafeParcelWriter.writeLong(parcel, 31, this.A);
        SafeParcelWriter.writeString(parcel, 33, this.B, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.C);
        SafeParcelWriter.writeInt(parcel, 35, this.D);
        SafeParcelWriter.writeInt(parcel, 36, this.E);
        SafeParcelWriter.writeBoolean(parcel, 37, this.F);
        SafeParcelWriter.writeBoolean(parcel, 38, this.G);
        SafeParcelWriter.writeString(parcel, 39, this.H, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.I);
        SafeParcelWriter.writeString(parcel, 41, this.J, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.K);
        SafeParcelWriter.writeInt(parcel, 43, this.L);
        SafeParcelWriter.writeBundle(parcel, 44, this.M, false);
        SafeParcelWriter.writeString(parcel, 45, this.N, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.O, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.P);
        SafeParcelWriter.writeBundle(parcel, 48, this.Q, false);
        SafeParcelWriter.writeString(parcel, 49, this.R, false);
        SafeParcelWriter.writeString(parcel, 50, this.S, false);
        SafeParcelWriter.writeString(parcel, 51, this.T, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.U);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.V, false);
        SafeParcelWriter.writeString(parcel, 54, this.W, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.X, false);
        SafeParcelWriter.writeInt(parcel, 56, this.Y);
        SafeParcelWriter.writeBoolean(parcel, 57, this.Z);
        SafeParcelWriter.writeBoolean(parcel, 58, this.aa);
        SafeParcelWriter.writeBoolean(parcel, 59, this.ab);
        SafeParcelWriter.writeStringList(parcel, 60, this.ac, false);
        SafeParcelWriter.writeString(parcel, 61, this.ad, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.ae, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.af, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.ag, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
