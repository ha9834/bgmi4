package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "WebImageCreator")
/* loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zae();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f1429a;

    @SafeParcelable.Field(getter = "getUrl", id = 2)
    private final Uri b;

    @SafeParcelable.Field(getter = "getWidth", id = 3)
    private final int c;

    @SafeParcelable.Field(getter = "getHeight", id = 4)
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public WebImage(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Uri uri, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3) {
        this.f1429a = i;
        this.b = uri;
        this.c = i2;
        this.d = i3;
    }

    public WebImage(Uri uri, int i, int i2) throws IllegalArgumentException {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    @KeepForSdk
    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(a(jSONObject), jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0), jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0));
    }

    private static Uri a(JSONObject jSONObject) {
        if (jSONObject.has("url")) {
            try {
                return Uri.parse(jSONObject.getString("url"));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final Uri getUrl() {
        return this.b;
    }

    public final int getWidth() {
        return this.c;
    }

    public final int getHeight() {
        return this.d;
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.c), Integer.valueOf(this.d), this.b.toString());
    }

    @KeepForSdk
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.b.toString());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.c);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.d);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return Objects.equal(this.b, webImage.b) && this.c == webImage.c && this.d == webImage.d;
    }

    public final int hashCode() {
        return Objects.hashCode(this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f1429a);
        SafeParcelWriter.writeParcelable(parcel, 2, getUrl(), i, false);
        SafeParcelWriter.writeInt(parcel, 3, getWidth());
        SafeParcelWriter.writeInt(parcel, 4, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
