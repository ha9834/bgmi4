package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class zzcxo {
    public final int responseCode;
    public final String zzcep;
    public final List<String> zzdfh;
    public final String zzdoj;
    public final long zzfyb;
    public final int zzgkr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcxo(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<String> emptyList = Collections.emptyList();
        String str = "";
        String str2 = "";
        jsonReader.beginObject();
        int i = 0;
        long j = 0;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("nofill_urls".equals(nextName)) {
                emptyList = zzazc.zza(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if ("response_code".equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j = jsonReader.nextLong();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        this.zzdfh = emptyList;
        this.zzgkr = i;
        this.zzcep = str;
        this.zzdoj = str2;
        this.responseCode = i2;
        this.zzfyb = j;
    }
}
