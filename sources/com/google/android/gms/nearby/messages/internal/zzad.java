package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzad extends zzbgl {
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();

    /* renamed from: a, reason: collision with root package name */
    private int f5024a;
    private String b;
    private String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(int i, String str, String str2) {
        this.f5024a = i;
        this.b = str;
        this.c = str2;
    }

    public zzad(String str, String str2) {
        this(1, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzad) && hashCode() == obj.hashCode()) {
            zzad zzadVar = (zzad) obj;
            if (zzbg.equal(this.b, zzadVar.b) && zzbg.equal(this.c, zzadVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final String toString() {
        String str = this.b;
        String str2 = this.c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 17 + String.valueOf(str2).length());
        sb.append("namespace=");
        sb.append(str);
        sb.append(", type=");
        sb.append(str2);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.b, false);
        zzbgo.zza(parcel, 2, this.c, false);
        zzbgo.zzc(parcel, 1000, this.f5024a);
        zzbgo.zzai(parcel, zze);
    }
}
