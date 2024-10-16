package com.twitter.sdk.android.core.internal.scribe;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ScribeEvent {
    private static final String CURRENT_FORMAT_VERSION = "2";

    @SerializedName("_category_")
    final String category;

    @SerializedName("event_namespace")
    final EventNamespace eventNamespace;

    @SerializedName("format_version")
    final String formatVersion;

    @SerializedName("items")
    final List<ScribeItem> items;

    @SerializedName("ts")
    final String timestamp;

    public ScribeEvent(String str, EventNamespace eventNamespace, long j) {
        this(str, eventNamespace, j, Collections.emptyList());
    }

    public ScribeEvent(String str, EventNamespace eventNamespace, long j, List<ScribeItem> list) {
        this.category = str;
        this.eventNamespace = eventNamespace;
        this.timestamp = String.valueOf(j);
        this.formatVersion = "2";
        this.items = Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("event_namespace=");
        sb.append(this.eventNamespace);
        sb.append(", ts=");
        sb.append(this.timestamp);
        sb.append(", format_version=");
        sb.append(this.formatVersion);
        sb.append(", _category_=");
        sb.append(this.category);
        sb.append(", items=");
        sb.append("[" + TextUtils.join(", ", this.items) + "]");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ScribeEvent scribeEvent = (ScribeEvent) obj;
        String str = this.category;
        if (str == null ? scribeEvent.category != null : !str.equals(scribeEvent.category)) {
            return false;
        }
        EventNamespace eventNamespace = this.eventNamespace;
        if (eventNamespace == null ? scribeEvent.eventNamespace != null : !eventNamespace.equals(scribeEvent.eventNamespace)) {
            return false;
        }
        String str2 = this.formatVersion;
        if (str2 == null ? scribeEvent.formatVersion != null : !str2.equals(scribeEvent.formatVersion)) {
            return false;
        }
        String str3 = this.timestamp;
        if (str3 == null ? scribeEvent.timestamp != null : !str3.equals(scribeEvent.timestamp)) {
            return false;
        }
        List<ScribeItem> list = this.items;
        return list == null ? scribeEvent.items == null : list.equals(scribeEvent.items);
    }

    public int hashCode() {
        EventNamespace eventNamespace = this.eventNamespace;
        int hashCode = (eventNamespace != null ? eventNamespace.hashCode() : 0) * 31;
        String str = this.timestamp;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.formatVersion;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.category;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<ScribeItem> list = this.items;
        return hashCode4 + (list != null ? list.hashCode() : 0);
    }

    /* loaded from: classes.dex */
    public static class Transform implements EventTransform<ScribeEvent> {
        private final Gson gson;

        public Transform(Gson gson) {
            this.gson = gson;
        }

        @Override // com.twitter.sdk.android.core.internal.scribe.EventTransform
        public byte[] toBytes(ScribeEvent scribeEvent) throws IOException {
            return this.gson.toJson(scribeEvent).getBytes("UTF-8");
        }
    }
}
