package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class zzcrc {
    public final String zzgfw;
    public String zzgfx;

    public zzcrc(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        String str = "";
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName = nextName == null ? "" : nextName;
            char c = 65535;
            if (nextName.hashCode() == -995427962 && nextName.equals(NativeProtocol.WEB_DIALOG_PARAMS)) {
                c = 0;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        this.zzgfw = str;
        jsonReader.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcrc a(Bundle bundle) {
        try {
            this.zzgfx = zzk.zzlg().zzd(bundle).toString();
        } catch (JSONException unused) {
            this.zzgfx = "{}";
        }
        return this;
    }
}
