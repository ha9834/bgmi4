package com.subao.common.e;

import android.text.TextUtils;
import android.util.JsonReader;
import com.subao.common.e.ad;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public abstract class y extends ad {

    /* renamed from: a, reason: collision with root package name */
    private final com.subao.common.g.c f6014a;

    /* loaded from: classes2.dex */
    public interface a {
        y a(ad.a aVar, com.subao.common.g.c cVar);
    }

    protected abstract String f();

    /* JADX INFO: Access modifiers changed from: protected */
    public y(ad.a aVar, com.subao.common.g.c cVar) {
        super(aVar);
        this.f6014a = cVar;
    }

    public static String a(ad.a aVar, com.subao.common.g.c cVar, a aVar2) {
        y a2 = aVar2.a(aVar, cVar);
        ae k = a2.k();
        a2.e(k);
        if (a2.d(k)) {
            return b(k);
        }
        return null;
    }

    static String b(ae aeVar) {
        byte[] a2;
        if (aeVar == null || (a2 = aeVar.a()) == null || a2.length == 0) {
            return null;
        }
        JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(a2)));
        try {
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if ("list".equals(jsonReader.nextName())) {
                        String nextString = jsonReader.nextString();
                        if (!TextUtils.isEmpty(nextString) && nextString.charAt(nextString.length() - 1) != ',') {
                            nextString = nextString + ',';
                        }
                        return nextString;
                    }
                    jsonReader.skipValue();
                }
            } finally {
                com.subao.common.e.a(jsonReader);
            }
        } catch (IOException | AssertionError | RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ad
    public void a(ae aeVar) {
        super.a(aeVar);
        if (aeVar == null || !aeVar.d) {
            return;
        }
        this.f6014a.b(0, f(), b(aeVar));
    }
}
