package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

@zzard
@SafeParcelable.Class(creator = "HttpRequestParcelCreator")
/* loaded from: classes2.dex */
public final class zzaia extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaia> CREATOR = new zzaib();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final String f2737a;

    @SafeParcelable.Field(id = 2)
    private final String[] b;

    @SafeParcelable.Field(id = 3)
    private final String[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzaia(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) String[] strArr2) {
        this.f2737a = str;
        this.b = strArr;
        this.c = strArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f2737a, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.b, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static zzaia zzh(zzr zzrVar) throws zza {
        Map<String, String> headers = zzrVar.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        return new zzaia(zzrVar.getUrl(), strArr, strArr2);
    }
}
