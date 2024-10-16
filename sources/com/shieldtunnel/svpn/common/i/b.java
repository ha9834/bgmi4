package com.shieldtunnel.svpn.common.i;

import android.util.JsonReader;
import com.shieldtunnel.svpn.common.i.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final com.shieldtunnel.svpn.common.jni.b f5842a;
    private final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5843a;

        static {
            int[] iArr = new int[a.b.values().length];
            f5843a = iArr;
            try {
                iArr[a.b.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5843a[a.b.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.shieldtunnel.svpn.common.i.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0157b {

        /* renamed from: a, reason: collision with root package name */
        private static final byte[][] f5844a = {new byte[]{71, 69, 84}, new byte[]{80, 79, 83, 84}, new byte[]{80, 85, 84}, new byte[]{68, 69, 76, 69, 84, 69}};
        private static final a.b[] b = {a.b.GET, a.b.POST, a.b.PUT, a.b.DELETE};

        static a.b a(byte[] bArr) {
            int length = f5844a.length;
            for (int i = 0; i < length; i++) {
                if (com.shieldtunnel.svpn.common.k.e.a(f5844a[i], bArr)) {
                    return b[i];
                }
            }
            return null;
        }
    }

    public b(com.shieldtunnel.svpn.common.jni.b bVar, int i) {
        this.f5842a = bVar;
        this.b = i;
    }

    public void a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        com.shieldtunnel.svpn.common.j.c.a(new c(i, bArr, bArr2, bArr3, bArr4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, byte[] bArr) {
        this.f5842a.a(this.b, i, bArr, null, null);
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final int f5845a;
        private final byte[] b;
        private final byte[] c;
        private final byte[] d;
        private final byte[] e;

        c(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            this.f5845a = i;
            this.b = bArr;
            this.c = bArr2;
            this.d = bArr3;
            this.e = bArr4;
        }

        private a.c a(a.b bVar) {
            int i = this.f5845a;
            HttpURLConnection a2 = new com.shieldtunnel.svpn.common.i.a(i, i).a(com.shieldtunnel.svpn.common.i.a.a(com.shieldtunnel.svpn.common.k.e.a(this.b)), bVar, (String) null);
            a(a2, this.e);
            int i2 = a.f5843a[bVar.ordinal()];
            if (i2 != 1 && i2 != 2) {
                return com.shieldtunnel.svpn.common.i.a.a(a2, this.d);
            }
            return com.shieldtunnel.svpn.common.i.a.a(a2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.shieldtunnel.svpn.common.k.e.c(this.b) || com.shieldtunnel.svpn.common.k.e.c(this.c)) {
                b.this.a(-2, null);
                return;
            }
            a.b a2 = C0157b.a(this.c);
            if (a2 == null) {
                b.this.a(-2, null);
                return;
            }
            try {
                a.c a3 = a(a2);
                b.this.a(a3.f5841a, a3.b);
            } catch (IOException unused) {
                b.this.a(-1, null);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void a(HttpURLConnection httpURLConnection, byte[] bArr) {
            if (com.shieldtunnel.svpn.common.k.e.c(bArr)) {
                return;
            }
            JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bArr)));
            try {
                try {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        httpURLConnection.addRequestProperty(jsonReader.nextName(), jsonReader.nextString());
                    }
                    jsonReader.endObject();
                } finally {
                    com.shieldtunnel.svpn.common.c.a(jsonReader);
                }
            } catch (Error | RuntimeException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
