package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@KeepForSdkWithMembers
@SafeParcelable.Class(creator = "ProxyResponseCreator")
/* loaded from: classes.dex */
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzb();
    public static final int STATUS_CODE_NO_CONNECTION = -1;

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1000)
    private final int f1247a;

    @SafeParcelable.Field(id = 4)
    private final Bundle b;

    @SafeParcelable.Field(id = 5)
    public final byte[] body;

    @SafeParcelable.Field(id = 1)
    public final int googlePlayServicesStatusCode;

    @SafeParcelable.Field(id = 2)
    public final PendingIntent recoveryAction;

    @SafeParcelable.Field(id = 3)
    public final int statusCode;

    public static ProxyResponse createErrorProxyResponse(int i, PendingIntent pendingIntent, int i2, Map<String, String> map, byte[] bArr) {
        return new ProxyResponse(1, i, pendingIntent, i2, a(map), bArr);
    }

    private static Bundle a(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (map == null) {
            return bundle;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ProxyResponse(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) PendingIntent pendingIntent, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) Bundle bundle, @SafeParcelable.Param(id = 5) byte[] bArr) {
        this.f1247a = i;
        this.googlePlayServicesStatusCode = i2;
        this.statusCode = i3;
        this.b = bundle;
        this.body = bArr;
        this.recoveryAction = pendingIntent;
    }

    public ProxyResponse(int i, PendingIntent pendingIntent, int i2, Bundle bundle, byte[] bArr) {
        this(1, i, pendingIntent, i2, bundle, bArr);
    }

    private ProxyResponse(int i, Bundle bundle, byte[] bArr) {
        this(1, 0, null, i, bundle, bArr);
    }

    public ProxyResponse(int i, Map<String, String> map, byte[] bArr) {
        this(i, a(map), bArr);
    }

    public Map<String, String> getHeaders() {
        if (this.b == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (String str : this.b.keySet()) {
            hashMap.put(str, this.b.getString(str));
        }
        return hashMap;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.googlePlayServicesStatusCode);
        SafeParcelWriter.writeParcelable(parcel, 2, this.recoveryAction, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeBundle(parcel, 4, this.b, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.body, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f1247a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
