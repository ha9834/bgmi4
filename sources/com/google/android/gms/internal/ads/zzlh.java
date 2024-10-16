package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzlh implements Parcelable {
    public static final Parcelable.Creator<zzlh> CREATOR = new akz();

    /* renamed from: a, reason: collision with root package name */
    private final String f3678a;
    private final zzpo b;
    private final String c;
    private final int d;
    private final byte[] e;
    private final zztb f;
    private final int g;
    private final int h;
    public final int height;
    private final int i;
    private int j;
    public final int width;
    public final int zzafs;
    public final float zzaft;
    public final int zzafu;
    public final int zzafv;
    public final List<byte[]> zzafw;
    public final int zzatm;
    public final String zzatn;
    public final String zzatq;
    public final zzne zzatr;
    public final float zzats;
    public final int zzatt;
    public final int zzatx;
    public final long zzaua;
    public final int zzaub;
    public final String zzauc;

    public static zzlh zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zztb zztbVar, zzne zzneVar) {
        return new zzlh(str, null, str2, null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zztbVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, zzneVar, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public static zzlh zza(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzne zzneVar, int i5, String str4) {
        return zza(str, str2, null, -1, -1, i3, i4, -1, null, zzneVar, 0, str4);
    }

    public static zzlh zza(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzne zzneVar, int i6, String str4) {
        return new zzlh(str, null, str2, null, -1, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, zzneVar, null);
    }

    public static zzlh zza(String str, String str2, String str3, int i, int i2, String str4, zzne zzneVar) {
        return zza(str, str2, null, -1, i2, str4, -1, zzneVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static zzlh zza(String str, String str2, String str3, int i, int i2, String str4, int i3, zzne zzneVar, long j, List<byte[]> list) {
        return new zzlh(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzneVar, null);
    }

    public static zzlh zza(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzne zzneVar) {
        return new zzlh(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzneVar, null);
    }

    public static zzlh zza(String str, String str2, String str3, int i, zzne zzneVar) {
        return new zzlh(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    private zzlh(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zztb zztbVar, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzne zzneVar, zzpo zzpoVar) {
        this.f3678a = str;
        this.c = str2;
        this.zzatq = str3;
        this.zzatn = str4;
        this.zzatm = i;
        this.zzafs = i2;
        this.width = i3;
        this.height = i4;
        this.zzats = f;
        this.zzatt = i5;
        this.zzaft = f2;
        this.e = bArr;
        this.d = i6;
        this.f = zztbVar;
        this.zzafu = i7;
        this.zzafv = i8;
        this.zzatx = i9;
        this.g = i10;
        this.h = i11;
        this.zzaub = i12;
        this.zzauc = str5;
        this.i = i13;
        this.zzaua = j;
        this.zzafw = list == null ? Collections.emptyList() : list;
        this.zzatr = zzneVar;
        this.b = zzpoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlh(Parcel parcel) {
        this.f3678a = parcel.readString();
        this.c = parcel.readString();
        this.zzatq = parcel.readString();
        this.zzatn = parcel.readString();
        this.zzatm = parcel.readInt();
        this.zzafs = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzats = parcel.readFloat();
        this.zzatt = parcel.readInt();
        this.zzaft = parcel.readFloat();
        this.e = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.d = parcel.readInt();
        this.f = (zztb) parcel.readParcelable(zztb.class.getClassLoader());
        this.zzafu = parcel.readInt();
        this.zzafv = parcel.readInt();
        this.zzatx = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.zzaub = parcel.readInt();
        this.zzauc = parcel.readString();
        this.i = parcel.readInt();
        this.zzaua = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzafw = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.zzafw.add(parcel.createByteArray());
        }
        this.zzatr = (zzne) parcel.readParcelable(zzne.class.getClassLoader());
        this.b = (zzpo) parcel.readParcelable(zzpo.class.getClassLoader());
    }

    public final zzlh zzae(int i) {
        return new zzlh(this.f3678a, this.c, this.zzatq, this.zzatn, this.zzatm, i, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.e, this.d, this.f, this.zzafu, this.zzafv, this.zzatx, this.g, this.h, this.zzaub, this.zzauc, this.i, this.zzaua, this.zzafw, this.zzatr, this.b);
    }

    public final zzlh zzed(long j) {
        return new zzlh(this.f3678a, this.c, this.zzatq, this.zzatn, this.zzatm, this.zzafs, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.e, this.d, this.f, this.zzafu, this.zzafv, this.zzatx, this.g, this.h, this.zzaub, this.zzauc, this.i, j, this.zzafw, this.zzatr, this.b);
    }

    public final zzlh zzc(int i, int i2) {
        return new zzlh(this.f3678a, this.c, this.zzatq, this.zzatn, this.zzatm, this.zzafs, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.e, this.d, this.f, this.zzafu, this.zzafv, this.zzatx, i, i2, this.zzaub, this.zzauc, this.i, this.zzaua, this.zzafw, this.zzatr, this.b);
    }

    public final zzlh zza(zzpo zzpoVar) {
        return new zzlh(this.f3678a, this.c, this.zzatq, this.zzatn, this.zzatm, this.zzafs, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.e, this.d, this.f, this.zzafu, this.zzafv, this.zzatx, this.g, this.h, this.zzaub, this.zzauc, this.i, this.zzaua, this.zzafw, this.zzatr, zzpoVar);
    }

    public final int zzhc() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat zzen() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzatq);
        String str = this.zzauc;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        a(mediaFormat, "max-input-size", this.zzafs);
        a(mediaFormat, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.width);
        a(mediaFormat, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.height);
        float f = this.zzats;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        a(mediaFormat, "rotation-degrees", this.zzatt);
        a(mediaFormat, "channel-count", this.zzafu);
        a(mediaFormat, "sample-rate", this.zzafv);
        a(mediaFormat, "encoder-delay", this.g);
        a(mediaFormat, "encoder-padding", this.h);
        for (int i = 0; i < this.zzafw.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzafw.get(i)));
        }
        zztb zztbVar = this.f;
        if (zztbVar != null) {
            a(mediaFormat, "color-transfer", zztbVar.zzbbp);
            a(mediaFormat, "color-standard", zztbVar.zzbbo);
            a(mediaFormat, "color-range", zztbVar.zzbbq);
            byte[] bArr = zztbVar.zzbnt;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        String str = this.f3678a;
        String str2 = this.c;
        String str3 = this.zzatq;
        int i = this.zzatm;
        String str4 = this.zzauc;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.zzats;
        int i4 = this.zzafu;
        int i5 = this.zzafv;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.j == 0) {
            String str = this.f3678a;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.c;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzatq;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzatn;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.zzatm) * 31) + this.width) * 31) + this.height) * 31) + this.zzafu) * 31) + this.zzafv) * 31;
            String str5 = this.zzauc;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.i) * 31;
            zzne zzneVar = this.zzatr;
            int hashCode6 = (hashCode5 + (zzneVar == null ? 0 : zzneVar.hashCode())) * 31;
            zzpo zzpoVar = this.b;
            this.j = hashCode6 + (zzpoVar != null ? zzpoVar.hashCode() : 0);
        }
        return this.j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzlh zzlhVar = (zzlh) obj;
        if (this.zzatm != zzlhVar.zzatm || this.zzafs != zzlhVar.zzafs || this.width != zzlhVar.width || this.height != zzlhVar.height || this.zzats != zzlhVar.zzats || this.zzatt != zzlhVar.zzatt || this.zzaft != zzlhVar.zzaft || this.d != zzlhVar.d || this.zzafu != zzlhVar.zzafu || this.zzafv != zzlhVar.zzafv || this.zzatx != zzlhVar.zzatx || this.g != zzlhVar.g || this.h != zzlhVar.h || this.zzaua != zzlhVar.zzaua || this.zzaub != zzlhVar.zzaub || !zzsy.zza(this.f3678a, zzlhVar.f3678a) || !zzsy.zza(this.zzauc, zzlhVar.zzauc) || this.i != zzlhVar.i || !zzsy.zza(this.c, zzlhVar.c) || !zzsy.zza(this.zzatq, zzlhVar.zzatq) || !zzsy.zza(this.zzatn, zzlhVar.zzatn) || !zzsy.zza(this.zzatr, zzlhVar.zzatr) || !zzsy.zza(this.b, zzlhVar.b) || !zzsy.zza(this.f, zzlhVar.f) || !Arrays.equals(this.e, zzlhVar.e) || this.zzafw.size() != zzlhVar.zzafw.size()) {
            return false;
        }
        for (int i = 0; i < this.zzafw.size(); i++) {
            if (!Arrays.equals(this.zzafw.get(i), zzlhVar.zzafw.get(i))) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3678a);
        parcel.writeString(this.c);
        parcel.writeString(this.zzatq);
        parcel.writeString(this.zzatn);
        parcel.writeInt(this.zzatm);
        parcel.writeInt(this.zzafs);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzats);
        parcel.writeInt(this.zzatt);
        parcel.writeFloat(this.zzaft);
        parcel.writeInt(this.e != null ? 1 : 0);
        byte[] bArr = this.e;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.d);
        parcel.writeParcelable(this.f, i);
        parcel.writeInt(this.zzafu);
        parcel.writeInt(this.zzafv);
        parcel.writeInt(this.zzatx);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.zzaub);
        parcel.writeString(this.zzauc);
        parcel.writeInt(this.i);
        parcel.writeLong(this.zzaua);
        int size = this.zzafw.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzafw.get(i2));
        }
        parcel.writeParcelable(this.zzatr, 0);
        parcel.writeParcelable(this.b, 0);
    }
}
