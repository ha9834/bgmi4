package com.discord.connect.schema;

import com.discord.connect.schema.Activity;
import com.google.gson.stream.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
class b extends com.discord.connect.a.a<Activity.Type> {
    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Activity.Type read2(JsonReader jsonReader) throws IOException {
        int nextInt = jsonReader.nextInt();
        for (Activity.Type type : Activity.Type.values()) {
            if (type.a() == nextInt) {
                return type;
            }
        }
        return Activity.Type.Unknown;
    }
}
