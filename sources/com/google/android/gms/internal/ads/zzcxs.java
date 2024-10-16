package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.common.util.IOUtils;
import com.helpshift.db.conversation.tables.ActionTable;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class zzcxs {
    public final List<zzcxm> zzgkt;
    public final zzcxo zzgku;
    public final List<zzcxt> zzgkv;

    public static zzcxs zza(Reader reader) throws zzcxp {
        try {
            try {
                return new zzcxs(new JsonReader(reader));
            } finally {
                IOUtils.closeQuietly(reader);
            }
        } catch (IOException | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzcxp("unable to parse ServerResponse", e);
        }
    }

    private zzcxs(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<zzcxm> emptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzcxo zzcxoVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        emptyList = new ArrayList<>();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            emptyList.add(new zzcxm(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (nextName2.equals("common")) {
                        zzcxoVar = new zzcxo(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (nextName.equals(ActionTable.TABLE_NAME)) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    Map<String, String> map = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if ("name".equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if (NetworkManager.CMD_INFO.equals(nextName3)) {
                            map = zzazc.zzb(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList.add(new zzcxt(str, map));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.zzgkv = arrayList;
        this.zzgkt = emptyList;
        this.zzgku = zzcxoVar == null ? new zzcxo(new JsonReader(new StringReader("{}"))) : zzcxoVar;
    }
}
