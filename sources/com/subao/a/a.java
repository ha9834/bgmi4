package com.subao.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonReader;
import android.util.Log;
import com.mediatek.npps.sdk.AtRes;
import com.mediatek.npps.sdk.CtRes;
import com.mediatek.npps.sdk.NPPS;
import com.subao.common.e;
import com.subao.common.e.an;
import com.subao.common.g.c;
import com.subao.common.j.b;
import com.subao.common.n.g;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static b f5858a;
    private static Boolean b;
    private static boolean c;
    private static String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.subao.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0159a {

        /* renamed from: a, reason: collision with root package name */
        private final int f5860a;
        private final an b;
        private final String c;
        private final String d;
        private final String e;
        private final com.subao.common.g.c f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.subao.a.a$a$c */
        /* loaded from: classes2.dex */
        public abstract class c {
            int b = 3;

            abstract int a();

            abstract void a(byte[] bArr);

            abstract void b();

            c() {
            }

            void a(b.c cVar) {
                if (cVar == null || cVar.f6066a != a() || cVar.b == null) {
                    b();
                } else {
                    a(cVar.b);
                }
            }

            boolean c() {
                return this.b > 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.subao.a.a$a$b */
        /* loaded from: classes2.dex */
        public class b extends c {
            @Override // com.subao.a.a.C0159a.c
            int a() {
                return 200;
            }

            b() {
                super();
            }

            @Override // com.subao.a.a.C0159a.c
            void a(byte[] bArr) {
                String str;
                if (bArr == null || bArr.length == 0) {
                    b();
                    return;
                }
                JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bArr)));
                String str2 = null;
                try {
                    try {
                        jsonReader.beginObject();
                        str = null;
                        while (jsonReader.hasNext()) {
                            try {
                                String nextName = jsonReader.nextName();
                                if (!TextUtils.isEmpty(nextName)) {
                                    char c = 65535;
                                    int hashCode = nextName.hashCode();
                                    if (hashCode != 106079) {
                                        if (hashCode == 1952399767 && nextName.equals("certificate")) {
                                            c = 0;
                                        }
                                    } else if (nextName.equals("key")) {
                                        c = 1;
                                    }
                                    switch (c) {
                                        case 0:
                                            str2 = g.b(jsonReader);
                                            break;
                                        case 1:
                                            str = g.b(jsonReader);
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                            } catch (IOException | RuntimeException unused) {
                            }
                        }
                        jsonReader.endObject();
                    } catch (Throwable th) {
                        e.a(jsonReader);
                        throw th;
                    }
                } catch (IOException | RuntimeException unused2) {
                    str = null;
                }
                e.a(jsonReader);
                Log.d("SubaoParallel", String.format("parse cert res, certificate = %s, key = %s", str2, str));
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                    b();
                } else {
                    a(Base64.decode(str2, 2), Base64.decode(str, 2), 3);
                }
            }

            @Override // com.subao.a.a.C0159a.c
            void b() {
                if (c()) {
                    Log.d("SubaoParallel", String.format("request certificate failed, do retry, remained retry count = %d", Integer.valueOf(this.b)));
                    C0159a.this.a(this);
                    this.b--;
                    return;
                }
                C0159a.this.a(false);
            }

            void a(byte[] bArr, byte[] bArr2, int i) {
                Log.d("SubaoParallel", "sendMTKCertificate");
                CtRes sCt = NPPS.sCt(bArr, bArr2);
                if (sCt != null && sCt.mError == 0 && sCt.mRnd != null) {
                    boolean unused = a.c = true;
                    int i2 = sCt.mCustId;
                    Log.d("SubaoParallel", String.format("send auth request to XY server, random length = %d, customId = %d", Integer.valueOf(sCt.mRnd.length), Integer.valueOf(i2)));
                    C0159a.this.a(sCt.mRnd, i2, null);
                    return;
                }
                if (sCt != null) {
                    Log.d("SubaoParallel", String.format("call mtk sendCertificate, error = %d, custom id = %d", Integer.valueOf(sCt.mError), Integer.valueOf(sCt.mCustId)));
                }
                if (i > 0) {
                    a(bArr, bArr2, i - 1);
                } else {
                    C0159a.this.a(false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.subao.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0160a extends c {
            private final byte[] d;
            private final int e;

            @Override // com.subao.a.a.C0159a.c
            int a() {
                return 201;
            }

            C0160a(byte[] bArr, int i) {
                super();
                this.d = bArr;
                this.e = i;
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
            
                r0.skipValue();
             */
            @Override // com.subao.a.a.C0159a.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            void a(byte[] r6) {
                /*
                    r5 = this;
                    if (r6 == 0) goto L61
                    int r0 = r6.length
                    if (r0 != 0) goto L6
                    goto L61
                L6:
                    android.util.JsonReader r0 = new android.util.JsonReader
                    java.io.InputStreamReader r1 = new java.io.InputStreamReader
                    java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
                    r2.<init>(r6)
                    r1.<init>(r2)
                    r0.<init>(r1)
                    r6 = 0
                    r0.beginObject()     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L4a
                    java.lang.String r1 = r0.nextName()     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L4a
                    boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L4a
                    if (r2 != 0) goto L41
                    r2 = -1
                    int r3 = r1.hashCode()     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L4a
                    r4 = -1944882398(0xffffffff8c137322, float:-1.1359115E-31)
                    if (r3 == r4) goto L2e
                    goto L37
                L2e:
                    java.lang.String r3 = "encryptedNum"
                    boolean r1 = r1.equals(r3)     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L4a
                    if (r1 == 0) goto L37
                    r2 = 0
                L37:
                    if (r2 == 0) goto L3d
                    r0.skipValue()     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L4a
                    goto L41
                L3d:
                    java.lang.String r6 = com.subao.common.n.g.b(r0)     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L4a
                L41:
                    r0.endObject()     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L4a
                    goto L4a
                L45:
                    r6 = move-exception
                    com.subao.common.e.a(r0)
                    throw r6
                L4a:
                    com.subao.common.e.a(r0)
                    boolean r0 = android.text.TextUtils.isEmpty(r6)
                    if (r0 == 0) goto L57
                    r5.b()
                    return
                L57:
                    int r0 = r5.e
                    r1 = 5459265(0x534d41, float:7.65006E-39)
                    r2 = 3
                    r5.a(r0, r1, r6, r2)
                    return
                L61:
                    r5.b()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.subao.a.a.C0159a.C0160a.a(byte[]):void");
            }

            @Override // com.subao.a.a.C0159a.c
            void b() {
                if (c()) {
                    Log.i("SubaoParallel", String.format("request auth msg failed, do retry, remained retry count = %d", Integer.valueOf(this.b)));
                    C0159a.this.a(this.d, this.e, this);
                    this.b--;
                    return;
                }
                C0159a.this.a(false);
            }

            public byte[] a(int i, int i2, String str) {
                byte[] bArr = new byte[264];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                wrap.putInt(i);
                wrap.putInt(i2);
                byte[] decode = Base64.decode(str, 2);
                Log.d("SubaoParallel", String.format("mtk randomNumberBytes length = %d", Integer.valueOf(decode.length)));
                wrap.put(decode, 0, Math.min(decode.length, 256));
                return bArr;
            }

            void a(int i, int i2, String str, int i3) {
                AtRes sAt = NPPS.sAt(a(i, i2, str));
                if (sAt != null) {
                    Log.d("SubaoParallel", String.format("call mtk sendAuth, error = %d", Integer.valueOf(sAt.mError)));
                } else {
                    Log.d("SubaoParallel", "call mtk sendAuth, result = null");
                }
                if (sAt != null && sAt.mError == 0 && sAt.mDevId != null) {
                    String unused = a.d = Base64.encodeToString(sAt.mDevId, 2);
                    C0159a.this.f.b(0, "key_mtk_device_id", a.d);
                    C0159a.this.a(true);
                } else if (i3 > 0) {
                    a(i, i2, str, i3 - 1);
                } else {
                    C0159a.this.a(false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.subao.a.a$a$d */
        /* loaded from: classes2.dex */
        public static class d extends AsyncTask<Void, Void, b.c> {

            /* renamed from: a, reason: collision with root package name */
            final b.EnumC0172b f5863a;
            private final URL b;
            private final String c;
            private final byte[] d;
            private final c e;

            d(URL url, b.EnumC0172b enumC0172b, String str, byte[] bArr, c cVar) {
                this.b = url;
                this.f5863a = enumC0172b;
                this.c = str;
                this.d = bArr;
                this.e = cVar;
            }

            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(b.c cVar) {
                this.e.a(cVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b.c doInBackground(Void... voidArr) {
                b.c b;
                try {
                    HttpURLConnection a2 = new com.subao.common.j.b(15000, 15000).a(this.b, this.f5863a, b.a.JSON.e);
                    a2.addRequestProperty("Authorization", "Bearer " + this.c);
                    switch (this.f5863a) {
                        case GET:
                        case DELETE:
                            b = com.subao.common.j.b.b(a2);
                            break;
                        default:
                            b = com.subao.common.j.b.a(a2, this.d);
                            break;
                    }
                    return b;
                } catch (IOException | RuntimeException e) {
                    e.printStackTrace();
                    Log.e("SubaoParallel", String.format("http exception: %s", e.getMessage()));
                    return null;
                }
            }
        }

        C0159a(int i, an anVar, String str, String str2, String str3, com.subao.common.g.c cVar) {
            this.f5860a = i;
            this.b = anVar;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = cVar;
        }

        URL a(String str, String str2) {
            return new URL(this.b.f5971a, this.b.b, String.format("/api/%s/%s/mtk/%s", str2, this.d, str));
        }

        public void a(boolean z) {
            Log.d("SubaoParallel", String.format("auth result : %b", Boolean.valueOf(z)));
            this.f.b(this.f5860a, z);
        }

        void a(b bVar) {
            Log.d("SubaoParallel", "send certificate request to XY server");
            boolean unused = a.c = false;
            b.EnumC0172b enumC0172b = b.EnumC0172b.GET;
            if (bVar == null) {
                bVar = new b();
            }
            a("encrypt_key", "v2", enumC0172b, null, bVar);
        }

        public void a(byte[] bArr, int i, C0160a c0160a) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("randomNumber", Base64.encodeToString(bArr, 2));
                jSONObject.put("customerId", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                return;
            }
            b.EnumC0172b enumC0172b = b.EnumC0172b.POST;
            byte[] bytes = jSONObject2.getBytes();
            if (c0160a == null) {
                c0160a = new C0160a(bArr, i);
            }
            a("encrypt_number", "v1", enumC0172b, bytes, c0160a);
        }

        void a(String str, String str2, b.EnumC0172b enumC0172b, byte[] bArr, c cVar) {
            URL url;
            if (TextUtils.isEmpty(str) || cVar == null) {
                return;
            }
            try {
                url = a(str, str2);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                url = null;
            }
            if (url == null) {
                return;
            }
            new d(url, enumC0172b, this.e, bArr, cVar).executeOnExecutor(com.subao.common.m.d.a(), new Void[0]);
        }

        public static void a(int i, an anVar, String str, String str2, String str3, com.subao.common.g.c cVar) {
            new C0159a(i, anVar, str, str2, str3, cVar).a((b) null);
        }
    }

    public static void a(c cVar, boolean z) {
        boolean z2;
        if (z) {
            z2 = b();
        } else {
            b = false;
            z2 = false;
        }
        cVar.a(z2);
        Log.d("SubaoParallel", String.format("NPPS, sdk support: %b", Boolean.valueOf(z2)));
        if (z2) {
            Log.d("SubaoParallel", String.format("NPPS, version: %d", 400));
        }
    }

    public static String a() {
        return d;
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        if (b == null) {
            try {
                b = Boolean.valueOf(NPPS.iSpt());
            } catch (Error | Exception e) {
                e.printStackTrace();
                b = false;
            }
        }
        return b.booleanValue();
    }

    public static void a(int i, an anVar, String str, String str2, String str3, c cVar) {
        C0159a.a(i, anVar, str, str2, str3, cVar);
    }

    public static void a(int i, Context context, int i2, String str, String str2, int i3, c cVar, int i4) {
        int stNLO = NPPS.stNLO(i2, str, a(context, str2), str2, i3);
        Log.d("SubaoParallel", String.format("call startNetworkLatencyOptimization, mode = %d, result = %d", Integer.valueOf(i2), Integer.valueOf(stNLO)));
        boolean z = stNLO == 0;
        if (!z && i4 > 0) {
            a(i, context, i2, str, str2, i3, cVar, i4 - 1);
        } else {
            cVar.c(i, z);
        }
    }

    public static void a(int i, c cVar, int i2) {
        int spNLO = NPPS.spNLO();
        Log.d("SubaoParallel", String.format("call stopNetworkLatencyOptimization, result = %d", Integer.valueOf(spNLO)));
        boolean z = spNLO == 0;
        if (!z && i2 > 0) {
            a(i, cVar, i2 - 1);
        } else {
            cVar.d(i, z);
        }
    }

    public static void b(int i, c cVar, int i2) {
        synchronized (a.class) {
            if (f5858a == null) {
                f5858a = new b(cVar);
            }
        }
        f5858a.a(i, i2);
    }

    public static void c() {
        b bVar = f5858a;
        if (bVar == null) {
            Log.i("SubaoParallel", "disable nddps, processor unavailable!");
        } else {
            bVar.a();
        }
    }

    public static void a(int i, c cVar) {
        b bVar = f5858a;
        if (bVar == null) {
            Log.d("SubaoParallel", "query nddps enable, processor unavailable!");
        } else {
            bVar.a(i);
        }
    }

    public static void a(int i) {
        b bVar = f5858a;
        if (bVar == null) {
            Log.d("SubaoParallel", "stop nddps, processor unavailable!");
        } else {
            bVar.b(i);
        }
    }

    public static void a(int i, String str, int i2, String str2, int i3, int i4) {
        b bVar = f5858a;
        if (bVar == null) {
            Log.d("SubaoParallel", "on link update, processor unavailable!");
        } else {
            bVar.a(i, str, i2, str2, i3, i4);
        }
    }

    public static void b(int i) {
        b bVar = f5858a;
        if (bVar == null) {
            Log.d("SubaoParallel", "stop nddps, processor unavailable!");
        } else {
            bVar.c(i);
        }
    }

    private static int a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return 0;
            }
            return applicationInfo.uid;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
