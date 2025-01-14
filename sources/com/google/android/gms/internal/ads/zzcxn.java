package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzcxn {
    public final int height;
    public final int width;
    public final boolean zzgkq;

    public zzcxn(int i, int i2, boolean z) {
        this.width = i;
        this.height = i2;
        this.zzgkq = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<zzcxn> a(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (ViewHierarchyConstants.DIMENSION_WIDTH_KEY.equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if (ViewHierarchyConstants.DIMENSION_HEIGHT_KEY.equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzcxn(i, i2, z));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
