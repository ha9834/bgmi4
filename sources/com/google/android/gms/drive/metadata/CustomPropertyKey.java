package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "CustomPropertyKeyCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class CustomPropertyKey extends AbstractSafeParcelable {
    public static final int PRIVATE = 1;
    public static final int PUBLIC = 0;

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final String f1550a;

    @SafeParcelable.Field(id = 3)
    private final int b;
    public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new zzc();
    private static final Pattern c = Pattern.compile("[\\w.!@$%^&*()/-]+");

    @SafeParcelable.Constructor
    public CustomPropertyKey(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i) {
        Preconditions.checkNotNull(str, "key");
        Preconditions.checkArgument(c.matcher(str).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        Preconditions.checkArgument(z, "visibility must be either PUBLIC or PRIVATE");
        this.f1550a = str;
        this.b = i;
    }

    public static CustomPropertyKey fromJson(JSONObject jSONObject) throws JSONException {
        return new CustomPropertyKey(jSONObject.getString("key"), jSONObject.getInt(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
            if (customPropertyKey.getKey().equals(this.f1550a) && customPropertyKey.getVisibility() == this.b) {
                return true;
            }
        }
        return false;
    }

    public String getKey() {
        return this.f1550a;
    }

    public int getVisibility() {
        return this.b;
    }

    public int hashCode() {
        String str = this.f1550a;
        int i = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11);
        sb.append(str);
        sb.append(i);
        return sb.toString().hashCode();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", getKey());
        jSONObject.put(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, getVisibility());
        return jSONObject;
    }

    public String toString() {
        String str = this.f1550a;
        int i = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 31);
        sb.append("CustomPropertyKey(");
        sb.append(str);
        sb.append(",");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f1550a, false);
        SafeParcelWriter.writeInt(parcel, 3, this.b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
