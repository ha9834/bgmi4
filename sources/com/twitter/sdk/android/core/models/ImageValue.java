package com.twitter.sdk.android.core.models;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class ImageValue {

    @SerializedName("alt")
    public final String alt;

    @SerializedName(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    public final int height;

    @SerializedName("url")
    public final String url;

    @SerializedName(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)
    public final int width;

    public ImageValue(int i, int i2, String str, String str2) {
        this.height = i;
        this.width = i2;
        this.url = str;
        this.alt = str2;
    }
}
