package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import java.util.List;

/* loaded from: classes.dex */
public class SyndicationClientEvent extends ScribeEvent {
    public static final String CLIENT_NAME = "tfw";
    private static final String SCRIBE_CATEGORY = "tfw_client_event";

    @SerializedName("event_info")
    public final String eventInfo;

    @SerializedName("external_ids")
    public final ExternalIds externalIds;

    @SerializedName("language")
    public final String language;

    public SyndicationClientEvent(EventNamespace eventNamespace, String str, long j, String str2, String str3, List<ScribeItem> list) {
        super(SCRIBE_CATEGORY, eventNamespace, j, list);
        this.language = str2;
        this.eventInfo = str;
        this.externalIds = new ExternalIds(str3);
    }

    /* loaded from: classes.dex */
    public class ExternalIds {

        @SerializedName(Constants.VIA_SHARE_TYPE_INFO)
        public final String adId;

        public ExternalIds(String str) {
            this.adId = str;
        }
    }
}
