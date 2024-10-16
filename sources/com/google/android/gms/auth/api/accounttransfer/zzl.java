package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AccountTransferMsgCreator")
/* loaded from: classes.dex */
public final class zzl extends zzaz {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f1232a;

    @SafeParcelable.Indicator
    private final Set<Integer> b;

    @SafeParcelable.VersionField(id = 1)
    private final int c;

    @SafeParcelable.Field(getter = "getAuthenticatorDatas", id = 2)
    private ArrayList<zzr> d;

    @SafeParcelable.Field(getter = "getRequestType", id = 3)
    private int e;

    @SafeParcelable.Field(getter = "getProgress", id = 4)
    private zzo f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<zzr> arrayList, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) zzo zzoVar) {
        this.b = set;
        this.c = i;
        this.d = arrayList;
        this.e = i2;
        this.f = zzoVar;
    }

    public zzl() {
        this.b = new HashSet(1);
        this.c = 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.b;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.c);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeTypedList(parcel, 2, this.d, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.e);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeParcelable(parcel, 4, this.f, i, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean a(FastJsonResponse.Field field) {
        return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object b(FastJsonResponse.Field field) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 4) {
            switch (safeParcelableFieldId) {
                case 1:
                    return Integer.valueOf(this.c);
                case 2:
                    return this.d;
                default:
                    int safeParcelableFieldId2 = field.getSafeParcelableFieldId();
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Unknown SafeParcelable id=");
                    sb.append(safeParcelableFieldId2);
                    throw new IllegalStateException(sb.toString());
            }
        }
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.d = arrayList;
            this.b.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(safeParcelableFieldId), arrayList.getClass().getCanonicalName()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 4) {
            this.f = (zzo) t;
            this.b.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(safeParcelableFieldId), t.getClass().getCanonicalName()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return f1232a;
    }

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f1232a = hashMap;
        hashMap.put("authenticatorData", FastJsonResponse.Field.forConcreteTypeArray("authenticatorData", 2, zzr.class));
        f1232a.put("progress", FastJsonResponse.Field.forConcreteType("progress", 4, zzo.class));
    }
}
