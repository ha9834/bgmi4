package com.subao.common.e;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final l f5993a = new l();
    private final com.subao.common.f.c b = com.subao.common.f.d.a(com.subao.common.f.a.a("config.subao"));
    private int c;

    private l() {
        b();
    }

    public static l a() {
        return f5993a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean b() {
        Throwable th;
        JsonReader jsonReader;
        RuntimeException e;
        IOException e2;
        boolean z = false;
        if (!this.b.a()) {
            return false;
        }
        try {
            try {
                jsonReader = new JsonReader(new BufferedReader(new InputStreamReader(this.b.b()), 1024));
                try {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("drsm".equals(jsonReader.nextName())) {
                            this.c = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    z = true;
                } catch (IOException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    com.subao.common.e.a(jsonReader);
                    return z;
                } catch (RuntimeException e4) {
                    e = e4;
                    e.printStackTrace();
                    com.subao.common.e.a(jsonReader);
                    return z;
                }
            } catch (Throwable th2) {
                th = th2;
                com.subao.common.e.a((Closeable) null);
                throw th;
            }
        } catch (IOException e5) {
            jsonReader = null;
            e2 = e5;
        } catch (RuntimeException e6) {
            jsonReader = null;
            e = e6;
        } catch (Throwable th3) {
            th = th3;
            com.subao.common.e.a((Closeable) null);
            throw th;
        }
        com.subao.common.e.a(jsonReader);
        return z;
    }

    public int c() {
        return this.c;
    }

    public void a(int i) {
        if (this.c != i) {
            this.c = i;
            d();
        }
    }

    private void d() {
        AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: com.subao.common.e.l.1
            @Override // java.lang.Runnable
            public void run() {
                JsonWriter jsonWriter;
                JsonWriter jsonWriter2 = null;
                try {
                    try {
                        jsonWriter = new JsonWriter(new BufferedWriter(new OutputStreamWriter(l.this.b.c()), 1024));
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e) {
                    e = e;
                } catch (RuntimeException e2) {
                    e = e2;
                }
                try {
                    jsonWriter.beginObject();
                    jsonWriter.name("drsm").value(l.this.c);
                    jsonWriter.endObject();
                    com.subao.common.e.a(jsonWriter);
                } catch (IOException e3) {
                    e = e3;
                    jsonWriter2 = jsonWriter;
                    e.printStackTrace();
                    com.subao.common.e.a(jsonWriter2);
                } catch (RuntimeException e4) {
                    e = e4;
                    jsonWriter2 = jsonWriter;
                    e.printStackTrace();
                    com.subao.common.e.a(jsonWriter2);
                } catch (Throwable th2) {
                    th = th2;
                    jsonWriter2 = jsonWriter;
                    com.subao.common.e.a(jsonWriter2);
                    throw th;
                }
            }
        });
    }
}
