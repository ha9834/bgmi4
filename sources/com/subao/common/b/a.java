package com.subao.common.b;

import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final com.subao.common.f.c f5909a;
    private Map<String, g> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.subao.common.f.c cVar) {
        this.f5909a = cVar;
        this.b = a(cVar);
    }

    private static String a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return com.subao.common.n.c.a(calendar, 7);
    }

    private static byte[] a() {
        ByteBuffer allocate = ByteBuffer.allocate(64);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putShort((short) 2016).put("SuBao".getBytes()).put((byte) 8).put("GameMaster".getBytes());
        return Arrays.copyOf(allocate.array(), allocate.position());
    }

    static void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    private static void a(byte[] bArr, int i, int i2) {
        byte[] a2 = a();
        int length = a2.length;
        int i3 = 0;
        while (i < i2) {
            byte b = bArr[i];
            int i4 = i3 + 1;
            byte b2 = a2[i3];
            if (i4 == length) {
                i4 = 0;
            }
            bArr[i] = (byte) (b2 ^ b);
            i++;
            i3 = i4;
        }
    }

    private static Map<String, g> a(JsonReader jsonReader) {
        HashMap hashMap = new HashMap(4);
        jsonReader.beginArray();
        while (true) {
            String str = null;
            if (!jsonReader.hasNext()) {
                break;
            }
            jsonReader.beginObject();
            g gVar = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("user".equals(nextName)) {
                    str = jsonReader.nextString();
                } else if ("data".equals(nextName)) {
                    gVar = g.a(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (!TextUtils.isEmpty(str) && gVar != null) {
                hashMap.put(str, gVar);
            }
        }
        jsonReader.endArray();
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    private static Map<String, g> b(byte[] bArr) {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bArr)));
        try {
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if ("list".equals(jsonReader.nextName())) {
                        return a(jsonReader);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
            } finally {
                com.subao.common.e.a(jsonReader);
            }
        } catch (IOException | RuntimeException unused) {
        }
        com.subao.common.e.a(jsonReader);
        return null;
    }

    private static Map<String, g> a(com.subao.common.f.c cVar) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (cVar == null || !cVar.a()) {
            return null;
        }
        byte[] bArr = new byte[4096];
        try {
            inputStream = cVar.b();
            try {
                int read = inputStream.read(bArr);
                com.subao.common.e.a((Closeable) inputStream);
                a(bArr, 0, read);
                Map<String, g> b = b(bArr);
                if (b == null) {
                    cVar.d();
                }
                return b;
            } catch (IOException unused) {
                com.subao.common.e.a((Closeable) inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                com.subao.common.e.a((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static void a(com.subao.common.f.c cVar, Map<String, g> map) {
        if (cVar == null) {
            return;
        }
        if (map == null || map.isEmpty()) {
            cVar.d();
            return;
        }
        try {
            StringWriter stringWriter = new StringWriter(1024);
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("list");
                jsonWriter.beginArray();
                for (Map.Entry<String, g> entry : map.entrySet()) {
                    jsonWriter.beginObject();
                    jsonWriter.name("user").value(entry.getKey());
                    jsonWriter.name("data");
                    entry.getValue().serialize(jsonWriter);
                    jsonWriter.endObject();
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
                com.subao.common.e.a(jsonWriter);
                byte[] bytes = stringWriter.toString().getBytes();
                a(bytes);
                OutputStream c = cVar.c();
                try {
                    c.write(bytes);
                    com.subao.common.e.a(c);
                } catch (Throwable th) {
                    com.subao.common.e.a(c);
                    throw th;
                }
            } catch (Throwable th2) {
                com.subao.common.e.a(jsonWriter);
                throw th2;
            }
        } catch (IOException unused) {
            cVar.d();
        }
    }

    public g a(String str) {
        return a(str, System.currentTimeMillis());
    }

    g a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            if (this.b == null) {
                return null;
            }
            g gVar = this.b.get(str);
            if (gVar == null) {
                return null;
            }
            if (gVar.b - 300000 > j) {
                if (com.subao.common.d.a("SubaoAuth")) {
                    Log.d("SubaoAuth", String.format("Cache of '%s' found, expire = %s", str, a(gVar.b)));
                }
                return gVar.a((gVar.b - j) / 1000);
            }
            if (com.subao.common.d.a("SubaoAuth")) {
                Log.d("SubaoAuth", String.format("Cache of '%s' found, but expired (%s)", str, a(gVar.b)));
            }
            this.b.remove(str);
            a(this.f5909a, this.b);
            return null;
        }
    }

    public void a(String str, g gVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = true;
        if (gVar == null) {
            synchronized (this) {
                if (this.b == null || this.b.remove(str) == null) {
                    z = false;
                } else {
                    a(this.f5909a, this.b);
                }
            }
            if (z && com.subao.common.d.a("SubaoAuth")) {
                Log.d("SubaoAuth", "User info remove from cache: " + str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() + (gVar.b * 1000);
        g a2 = gVar.a(currentTimeMillis);
        synchronized (this) {
            if (this.b == null) {
                this.b = new HashMap(4);
            }
            this.b.put(str, a2);
            a(this.f5909a, this.b);
        }
        if (com.subao.common.d.a("SubaoAuth")) {
            Log.d("SubaoAuth", String.format("User info put into cache, '%s', cache-expire = %s", str, a(currentTimeMillis)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            if (this.b == null) {
                return;
            }
            boolean z = false;
            Iterator<Map.Entry<String, g>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                g value = it.next().getValue();
                if (value != null && str.equals(value.f5925a)) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                a(this.f5909a, this.b);
            }
        }
    }
}
