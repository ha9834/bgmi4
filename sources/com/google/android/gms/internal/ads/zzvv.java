package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@zzard
@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzvv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvv> CREATOR = new zzvw();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 3)
    private final long f3764a;

    @SafeParcelable.Field(id = 4)
    private final String b;

    @SafeParcelable.Field(id = 5)
    private final String c;

    @SafeParcelable.Field(id = 6)
    private final String d;

    @SafeParcelable.Field(id = 7)
    private final Bundle e;

    @SafeParcelable.Field(id = 2)
    public final String url;

    @SafeParcelable.Field(id = 8)
    public final boolean zzbwx;

    @SafeParcelable.Field(id = 9)
    public long zzbwy;

    public static zzvv zzbo(String str) {
        return zze(Uri.parse(str));
    }

    public static zzvv zze(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzawz.zzep(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            zzk.zzli();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzvv(queryParameter, parseLong, host, str, str2, bundle, equals, 0L);
        } catch (NullPointerException | NumberFormatException e) {
            zzawz.zzd("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzvv(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2) {
        this.url = str;
        this.f3764a = j;
        this.b = str2 == null ? "" : str2;
        this.c = str3 == null ? "" : str3;
        this.d = str4 == null ? "" : str4;
        this.e = bundle == null ? new Bundle() : bundle;
        this.zzbwx = z;
        this.zzbwy = j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.f3764a);
        SafeParcelWriter.writeString(parcel, 4, this.b, false);
        SafeParcelWriter.writeString(parcel, 5, this.c, false);
        SafeParcelWriter.writeString(parcel, 6, this.d, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.e, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbwx);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbwy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
