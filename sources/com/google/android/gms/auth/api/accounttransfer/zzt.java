package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AuthenticatorTransferInfoCreator")
/* loaded from: classes.dex */
public class zzt extends zzaz {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f1235a;

    @SafeParcelable.Indicator
    private final Set<Integer> b;

    @SafeParcelable.VersionField(id = 1)
    private final int c;

    @SafeParcelable.Field(getter = "getAccountType", id = 2)
    private String d;

    @SafeParcelable.Field(getter = "getStatus", id = 3)
    private int e;

    @SafeParcelable.Field(getter = "getTransferBytes", id = 4)
    private byte[] f;

    @SafeParcelable.Field(getter = "getPendingIntent", id = 5)
    private PendingIntent g;

    @SafeParcelable.Field(getter = "getDeviceMetaData", id = 6)
    private DeviceMetaData h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzt(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) PendingIntent pendingIntent, @SafeParcelable.Param(id = 6) DeviceMetaData deviceMetaData) {
        this.b = set;
        this.c = i;
        this.d = str;
        this.e = i2;
        this.f = bArr;
        this.g = pendingIntent;
        this.h = deviceMetaData;
    }

    public zzt() {
        this.b = new androidx.b.b(3);
        this.c = 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.b;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.c);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeString(parcel, 2, this.d, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.e);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeByteArray(parcel, 4, this.f, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeParcelable(parcel, 5, this.g, i, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.writeParcelable(parcel, 6, this.h, i, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean a(FastJsonResponse.Field field) {
        return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object b(FastJsonResponse.Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                return Integer.valueOf(this.c);
            case 2:
                return this.d;
            case 3:
                return Integer.valueOf(this.e);
            case 4:
                return this.f;
            default:
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(safeParcelableFieldId);
                throw new IllegalStateException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.d = str2;
            this.b.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(safeParcelableFieldId)));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, int i) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 3) {
            this.e = i;
            this.b.add(Integer.valueOf(safeParcelableFieldId));
        } else {
            StringBuilder sb = new StringBuilder(52);
            sb.append("Field with id=");
            sb.append(safeParcelableFieldId);
            sb.append(" is not known to be an int.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 4) {
            this.f = bArr;
            this.b.add(Integer.valueOf(safeParcelableFieldId));
        } else {
            StringBuilder sb = new StringBuilder(59);
            sb.append("Field with id=");
            sb.append(safeParcelableFieldId);
            sb.append(" is not known to be an byte array.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map getFieldMappings() {
        return f1235a;
    }

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f1235a = hashMap;
        hashMap.put("accountType", FastJsonResponse.Field.forString("accountType", 2));
        f1235a.put("status", FastJsonResponse.Field.forInteger("status", 3));
        f1235a.put("transferBytes", FastJsonResponse.Field.forBase64("transferBytes", 4));
    }
}
