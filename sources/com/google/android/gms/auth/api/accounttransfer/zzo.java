package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SafeParcelable.Class(creator = "AccountTransferProgressCreator")
/* loaded from: classes.dex */
public class zzo extends zzaz {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.b.a<String, FastJsonResponse.Field<?, ?>> f1233a;

    @SafeParcelable.VersionField(id = 1)
    private final int b;

    @SafeParcelable.Field(getter = "getRegisteredAccountTypes", id = 2)
    private List<String> c;

    @SafeParcelable.Field(getter = "getInProgressAccountTypes", id = 3)
    private List<String> d;

    @SafeParcelable.Field(getter = "getSuccessAccountTypes", id = 4)
    private List<String> e;

    @SafeParcelable.Field(getter = "getFailedAccountTypes", id = 5)
    private List<String> f;

    @SafeParcelable.Field(getter = "getEscrowedAccountTypes", id = 6)
    private List<String> g;

    public zzo() {
        this.b = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean a(FastJsonResponse.Field field) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) List<String> list, @SafeParcelable.Param(id = 3) List<String> list2, @SafeParcelable.Param(id = 4) List<String> list3, @SafeParcelable.Param(id = 5) List<String> list4, @SafeParcelable.Param(id = 6) List<String> list5) {
        this.b = i;
        this.c = list;
        this.d = list2;
        this.e = list3;
        this.f = list4;
        this.g = list5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.b);
        SafeParcelWriter.writeStringList(parcel, 2, this.c, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.d, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.e, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.f, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.g, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        return f1233a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object b(FastJsonResponse.Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                return Integer.valueOf(this.b);
            case 2:
                return this.c;
            case 3:
                return this.d;
            case 4:
                return this.e;
            case 5:
                return this.f;
            case 6:
                return this.g;
            default:
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(safeParcelableFieldId);
                throw new IllegalStateException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.c = arrayList;
                return;
            case 3:
                this.d = arrayList;
                return;
            case 4:
                this.e = arrayList;
                return;
            case 5:
                this.f = arrayList;
                return;
            case 6:
                this.g = arrayList;
                return;
            default:
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(safeParcelableFieldId)));
        }
    }

    static {
        androidx.b.a<String, FastJsonResponse.Field<?, ?>> aVar = new androidx.b.a<>();
        f1233a = aVar;
        aVar.put("registered", FastJsonResponse.Field.forStrings("registered", 2));
        f1233a.put("in_progress", FastJsonResponse.Field.forStrings("in_progress", 3));
        f1233a.put("success", FastJsonResponse.Field.forStrings("success", 4));
        f1233a.put("failed", FastJsonResponse.Field.forStrings("failed", 5));
        f1233a.put("escrowed", FastJsonResponse.Field.forStrings("escrowed", 6));
    }
}
