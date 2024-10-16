package com.twitter.sdk.android.core.models;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class Media {

    @SerializedName("image")
    public final Image image;

    @SerializedName(SDKConstants.PARAM_A2U_MEDIA_ID)
    public final long mediaId;

    @SerializedName("media_id_string")
    public final String mediaIdString;

    @SerializedName("size")
    public final long size;

    public Media(long j, String str, long j2, Image image) {
        this.mediaId = j;
        this.mediaIdString = str;
        this.size = j2;
        this.image = image;
    }
}
