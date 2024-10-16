package com.twitter.sdk.android.core.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class VideoInfo implements Serializable {

    @SerializedName("aspect_ratio")
    public final List<Integer> aspectRatio;

    @SerializedName("duration_millis")
    public final long durationMillis;

    @SerializedName("variants")
    public final List<Variant> variants;

    private VideoInfo() {
        this(null, 0L, null);
    }

    public VideoInfo(List<Integer> list, long j, List<Variant> list2) {
        this.aspectRatio = ModelUtils.getSafeList(list);
        this.durationMillis = j;
        this.variants = ModelUtils.getSafeList(list2);
    }

    /* loaded from: classes.dex */
    public static class Variant implements Serializable {

        @SerializedName("bitrate")
        public final long bitrate;

        @SerializedName(FirebaseAnalytics.Param.CONTENT_TYPE)
        public final String contentType;

        @SerializedName("url")
        public final String url;

        public Variant(long j, String str, String str2) {
            this.bitrate = j;
            this.contentType = str;
            this.url = str2;
        }
    }
}
