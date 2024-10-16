package com.subao.common.b;

import android.util.JsonReader;
import android.util.JsonWriter;
import com.amazonaws.event.ProgressEvent;
import com.tencent.mid.api.MidEntity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class h {
    public static byte[] a(g gVar, long j) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(ProgressEvent.PART_COMPLETED_EVENT_CODE);
        JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(byteArrayOutputStream));
        jsonWriter.beginObject();
        jsonWriter.name(MidEntity.TAG_VER).value(1L);
        jsonWriter.name("birth").value(j);
        jsonWriter.name("data");
        gVar.serialize(jsonWriter);
        jsonWriter.endObject();
        jsonWriter.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static g a(long j, byte[] bArr) {
        return a(j, bArr, 0, bArr.length);
    }

    public static g a(long j, byte[] bArr, int i, int i2) {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bArr, i, i2)));
        try {
            jsonReader.beginObject();
            long j2 = -1;
            g gVar = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("birth".equals(nextName)) {
                    j2 = jsonReader.nextLong();
                } else if ("data".equals(nextName)) {
                    gVar = g.a(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            jsonReader.close();
            if (gVar != null && j2 > 0) {
                return gVar.a(((gVar.b * 1000) - (j - j2)) / 1000);
            }
            return null;
        } catch (IOException | RuntimeException unused) {
            return null;
        }
    }
}
