package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.IOException;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcxq implements zzazf {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f3494a;

    @Nullable
    public final String zzdkn;

    @Nullable
    public final String zzdkp;
    public final JSONObject zzfmo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcxq(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        this.f3494a = zzazc.zzc(jsonReader);
        this.zzdkp = this.f3494a.optString("ad_html", null);
        this.zzdkn = this.f3494a.optString("ad_base_url", null);
        this.zzfmo = this.f3494a.optJSONObject("ad_json");
    }

    @Override // com.google.android.gms.internal.ads.zzazf
    public final void zza(JsonWriter jsonWriter) throws IOException {
        zzazc.zza(jsonWriter, this.f3494a);
    }
}
