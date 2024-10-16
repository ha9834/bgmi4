package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import com.tencent.open.SocialOperation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AuthenticatorAnnotatedDataCreator")
/* loaded from: classes.dex */
public class zzr extends zzaz {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f1234a;

    @SafeParcelable.Indicator
    private final Set<Integer> b;

    @SafeParcelable.VersionField(id = 1)
    private final int c;

    @SafeParcelable.Field(getter = "getInfo", id = 2)
    private zzt d;

    @SafeParcelable.Field(getter = "getSignature", id = 3)
    private String e;

    @SafeParcelable.Field(getter = "getPackageName", id = 4)
    private String f;

    @SafeParcelable.Field(getter = "getId", id = 5)
    private String g;

    public zzr() {
        this.b = new HashSet(3);
        this.c = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) zzt zztVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3) {
        this.b = set;
        this.c = i;
        this.d = zztVar;
        this.e = str;
        this.f = str2;
        this.g = str3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.b;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.c);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeParcelable(parcel, 2, this.d, i, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeString(parcel, 3, this.e, true);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeString(parcel, 4, this.f, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeString(parcel, 5, this.g, true);
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
                return this.e;
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
        switch (safeParcelableFieldId) {
            case 3:
                this.e = str2;
                break;
            case 4:
                this.f = str2;
                break;
            default:
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(safeParcelableFieldId)));
        }
        this.b.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.d = (zzt) t;
            this.b.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(safeParcelableFieldId), t.getClass().getCanonicalName()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map getFieldMappings() {
        return f1234a;
    }

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f1234a = hashMap;
        hashMap.put("authenticatorInfo", FastJsonResponse.Field.forConcreteType("authenticatorInfo", 2, zzt.class));
        f1234a.put(SocialOperation.GAME_SIGNATURE, FastJsonResponse.Field.forString(SocialOperation.GAME_SIGNATURE, 3));
        f1234a.put("package", FastJsonResponse.Field.forString("package", 4));
    }
}
