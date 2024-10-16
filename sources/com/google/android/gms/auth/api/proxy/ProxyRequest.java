package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Patterns;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@KeepForSdkWithMembers
@SafeParcelable.Class(creator = "ProxyRequestCreator")
/* loaded from: classes.dex */
public class ProxyRequest extends AbstractSafeParcelable {
    public static final int VERSION_CODE = 2;

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1000)
    private final int f1245a;

    @SafeParcelable.Field(id = 5)
    private Bundle b;

    @SafeParcelable.Field(id = 4)
    public final byte[] body;

    @SafeParcelable.Field(id = 2)
    public final int httpMethod;

    @SafeParcelable.Field(id = 3)
    public final long timeoutMillis;

    @SafeParcelable.Field(id = 1)
    public final String url;
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza();
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int LAST_CODE = 7;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ProxyRequest(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) Bundle bundle) {
        this.f1245a = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.b = bundle;
    }

    @KeepForSdkWithMembers
    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f1246a;
        private int b = ProxyRequest.HTTP_METHOD_GET;
        private long c = 3000;
        private byte[] d = null;
        private Bundle e = new Bundle();

        public Builder(String str) {
            Preconditions.checkNotEmpty(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.f1246a = str;
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
            sb.append("The supplied url [ ");
            sb.append(str);
            sb.append("] is not match Patterns.WEB_URL!");
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setHttpMethod(int i) {
            Preconditions.checkArgument(i >= 0 && i <= ProxyRequest.LAST_CODE, "Unrecognized http method code.");
            this.b = i;
            return this;
        }

        public Builder setTimeoutMillis(long j) {
            Preconditions.checkArgument(j >= 0, "The specified timeout must be non-negative.");
            this.c = j;
            return this;
        }

        public Builder putHeader(String str, String str2) {
            Preconditions.checkNotEmpty(str, "Header name cannot be null or empty!");
            Bundle bundle = this.e;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.d = bArr;
            return this;
        }

        public ProxyRequest build() {
            if (this.d == null) {
                this.d = new byte[0];
            }
            return new ProxyRequest(2, this.f1246a, this.b, this.c, this.d, this.e);
        }
    }

    public Map<String, String> getHeaderMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.b.size());
        for (String str : this.b.keySet()) {
            linkedHashMap.put(str, this.b.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = this.url;
        int i = this.httpMethod;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(i);
        sb.append(" ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeInt(parcel, 2, this.httpMethod);
        SafeParcelWriter.writeLong(parcel, 3, this.timeoutMillis);
        SafeParcelWriter.writeByteArray(parcel, 4, this.body, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.b, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f1245a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
