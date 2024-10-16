package com.discord.connect.a;

import com.discord.connect.schema.Activity;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public class c extends TypeAdapter<Activity.b.a> {
    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Activity.b.a aVar) throws IOException {
        jsonWriter.beginArray();
        jsonWriter.value(aVar.f1086a);
        jsonWriter.value(aVar.b);
        jsonWriter.endArray();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Activity.b.a read2(JsonReader jsonReader) throws IOException {
        char c;
        switch (jsonReader.peek()) {
            case BEGIN_ARRAY:
                jsonReader.beginArray();
                Activity.b.a aVar = new Activity.b.a(jsonReader.nextInt(), jsonReader.nextInt());
                jsonReader.endArray();
                return aVar;
            case BEGIN_OBJECT:
                jsonReader.beginObject();
                int i = -1;
                int i2 = -1;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    int hashCode = nextName.hashCode();
                    if (hashCode != 107876) {
                        if (hashCode == 1126940025 && nextName.equals("current")) {
                            c = 0;
                        }
                        c = 65535;
                    } else {
                        if (nextName.equals("max")) {
                            c = 1;
                        }
                        c = 65535;
                    }
                    switch (c) {
                        case 0:
                            i = jsonReader.nextInt();
                            break;
                        case 1:
                            i2 = jsonReader.nextInt();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                return new Activity.b.a(i, i2);
            default:
                throw new IOException("invalid party size gson");
        }
    }
}
