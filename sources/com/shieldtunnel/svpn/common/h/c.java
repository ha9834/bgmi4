package com.shieldtunnel.svpn.common.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.JsonWriter;
import android.util.Log;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.f.c;
import com.shieldtunnel.svpn.common.f.f;
import com.shieldtunnel.svpn.common.f.q;
import com.shieldtunnel.svpn.common.i.a;
import com.shieldtunnel.svpn.common.k.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f5834a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final com.shieldtunnel.svpn.common.f.d f5835a;
        private final com.shieldtunnel.svpn.common.h.d b;
        private final q c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.shieldtunnel.svpn.common.h.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public abstract class AbstractRunnableC0154a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private byte[] f5836a;
            private URL b;

            AbstractRunnableC0154a() {
            }

            private URL b() {
                if (this.b == null) {
                    String c = c();
                    String str = a.this.c.f5827a;
                    String str2 = a.this.c.b;
                    int i = a.this.c.c;
                    if (c == null) {
                        c = "";
                    }
                    this.b = new URL(str, str2, i, c);
                }
                return this.b;
            }

            final void a(long j) {
                a.this.postDelayed(this, j);
            }

            protected abstract void a(a.c cVar);

            protected abstract byte[] a();

            protected abstract String c();

            protected abstract void d();

            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection a2 = new com.shieldtunnel.svpn.common.i.a(8000, 8000).a(b(), a.b.POST, a.EnumC0156a.JSON.f5839a);
                    try {
                        com.shieldtunnel.svpn.common.i.a.b(a2, a.EnumC0156a.JSON.f5839a);
                        if (this.f5836a == null) {
                            this.f5836a = a();
                        }
                        a(com.shieldtunnel.svpn.common.i.a.a(a2, this.f5836a));
                        a2.disconnect();
                    } catch (Throwable th) {
                        a2.disconnect();
                        throw th;
                    }
                } catch (IOException | RuntimeException unused) {
                    d();
                }
            }
        }

        /* loaded from: classes2.dex */
        private abstract class b extends d {
            b(a aVar) {
                super(aVar, 8, 5000L, 1.2f);
            }

            @Override // com.shieldtunnel.svpn.common.h.c.a.AbstractRunnableC0154a
            protected String c() {
                return "/v3/report/client/event";
            }
        }

        /* renamed from: com.shieldtunnel.svpn.common.h.c$a$c, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0155c extends b {
            private final long h;
            private final String i;
            private final Object j;

            C0155c(long j, String str, Object obj) {
                super(a.this);
                this.h = j;
                this.i = str;
                this.j = obj;
            }

            @Override // com.shieldtunnel.svpn.common.h.c.a.AbstractRunnableC0154a
            protected byte[] a() {
                com.shieldtunnel.svpn.common.h.a a2;
                com.shieldtunnel.svpn.common.h.b bVar = new com.shieldtunnel.svpn.common.h.b(a.this.f5835a, a.this.b);
                Object obj = this.j;
                if (obj == null) {
                    a2 = new com.shieldtunnel.svpn.common.h.a(this.i, this.h, null);
                } else if (obj instanceof byte[]) {
                    a2 = com.shieldtunnel.svpn.common.h.a.a(this.i, this.h / 1000, e.a((byte[]) obj));
                } else {
                    a2 = com.shieldtunnel.svpn.common.h.a.a(this.i, this.h / 1000, obj.toString());
                }
                bVar.a(a2);
                return c.b(bVar);
            }
        }

        /* loaded from: classes2.dex */
        private abstract class d extends AbstractRunnableC0154a {
            private final int d;
            private final float e;
            private long f;
            private int g;

            d(a aVar, int i, long j, float f) {
                super();
                this.d = i;
                this.f = j;
                this.e = f;
            }

            @Override // com.shieldtunnel.svpn.common.h.c.a.AbstractRunnableC0154a
            protected void a(a.c cVar) {
                if (cVar.f5841a == 500) {
                    e();
                }
            }

            @Override // com.shieldtunnel.svpn.common.h.c.a.AbstractRunnableC0154a
            protected void d() {
                e();
            }

            final void e() {
                int i = this.g + 1;
                this.g = i;
                if (i > this.d) {
                    return;
                }
                a(this.f);
                this.f = ((float) this.f) * this.e;
                if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
                    Log.d(LogTag.DATA, String.format(f.b, "Retry after %d milliseconds (%d/%d)", Long.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.d)));
                }
            }
        }

        a(com.shieldtunnel.svpn.common.f.d dVar, com.shieldtunnel.svpn.common.h.d dVar2, q qVar) {
            super(a());
            this.f5835a = dVar;
            this.b = dVar2;
            this.c = qVar == null ? com.shieldtunnel.svpn.common.f.c.b(c.d.DRONE) : qVar;
        }

        private static Looper a() {
            HandlerThread handlerThread = new HandlerThread("xy-mu");
            handlerThread.start();
            return handlerThread.getLooper();
        }
    }

    public c(com.shieldtunnel.svpn.common.f.d dVar, d dVar2, q qVar) {
        this.f5834a = new a(dVar, dVar2, qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(com.shieldtunnel.svpn.common.a aVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(byteArrayOutputStream));
        try {
            aVar.serialize(jsonWriter);
            com.shieldtunnel.svpn.common.c.a(jsonWriter);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            com.shieldtunnel.svpn.common.c.a(jsonWriter);
            throw th;
        }
    }

    public void a(long j, String str, Object obj) {
        a aVar = this.f5834a;
        aVar.getClass();
        aVar.post(new a.C0155c(j, str, obj));
    }
}
