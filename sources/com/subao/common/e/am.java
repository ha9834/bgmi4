package com.subao.common.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import com.amazonaws.event.ProgressEvent;
import com.facebook.internal.ServerProtocol;
import com.subao.common.e.e;
import com.subao.common.e.r;
import com.uqm.crashsight.CrashSight;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* loaded from: classes2.dex */
public class am extends q {

    /* renamed from: a, reason: collision with root package name */
    boolean f5969a;
    Integer b;
    e.a c;
    String d;
    an e;
    an f;
    an g;
    an h;
    String i;
    String j;
    Integer k;
    Integer l;
    String m;
    private boolean n;
    private boolean o;
    private String p;

    static int a(int i) {
        if (i < 1) {
            return 1;
        }
        if (i > 5) {
            return 5;
        }
        return i;
    }

    @Override // com.subao.common.e.q
    protected String a() {
        return "com.subao.gamemaster.service.config";
    }

    @Override // com.subao.common.e.q
    protected void a(byte[] bArr) {
        try {
            String str = new String(bArr, "UTF-8");
            a(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr)), ProgressEvent.PART_COMPLETED_EVENT_CODE));
            this.p = str;
            this.o = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.q
    public InputStream b(Context context, r.a aVar) {
        File c = c(context, aVar);
        if (c != null) {
            try {
                return new FileInputStream(c);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return super.b(context, aVar);
    }

    private File c(Context context, r.a aVar) {
        File a2 = a(context);
        if (!a2.exists() || !a2.isDirectory()) {
            return null;
        }
        File file = new File(a2, b(aVar));
        if (file.exists() && file.isFile()) {
            return file;
        }
        return null;
    }

    String b(r.a aVar) {
        return String.format("%s.%s", a(), a(aVar));
    }

    private static File a(Context context) {
        return context.getFilesDir();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void a(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if ("init".equals(nextName)) {
                        this.f5969a = "fail".equals(com.subao.common.n.g.b(jsonReader));
                    } else if ("url_h5".equals(nextName)) {
                        this.d = com.subao.common.n.g.b(jsonReader);
                    } else if ("accel_recommend".equals(nextName)) {
                        this.k = Integer.valueOf(jsonReader.nextInt());
                    } else if ("nodes_info".equals(nextName)) {
                        if (this.c == null) {
                            this.c = a(com.subao.common.n.g.b(jsonReader));
                        }
                    } else if ("nodes_info_v2".equals(nextName)) {
                        this.c = a(jsonReader);
                    } else if ("log_level".equals(nextName)) {
                        this.b = Integer.valueOf(a(jsonReader.nextInt()));
                    } else if ("url_portal".equals(nextName)) {
                        this.e = an.a(com.subao.common.n.g.b(jsonReader));
                    } else if ("url_auth".equals(nextName)) {
                        this.f = an.a(com.subao.common.n.g.b(jsonReader));
                    } else if ("url_hr".equals(nextName)) {
                        this.h = an.a(com.subao.common.n.g.b(jsonReader));
                    } else if ("url_ticket".equals(nextName)) {
                        this.i = com.subao.common.n.g.b(jsonReader);
                    } else if ("url_lashou".equals(nextName)) {
                        this.j = com.subao.common.n.g.b(jsonReader);
                    } else if ("url_message".equals(nextName)) {
                        this.g = an.a(com.subao.common.n.g.b(jsonReader));
                    } else if ("data_refresh_interval".equals(nextName)) {
                        this.l = Integer.valueOf(jsonReader.nextInt());
                    } else if ("url_bonus".equals(nextName)) {
                        this.m = com.subao.common.n.g.b(jsonReader);
                    } else if ("portal_encryption".equals(nextName)) {
                        this.n = com.subao.common.n.g.a(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } finally {
                com.subao.common.e.a(jsonReader);
            }
        } catch (AssertionError | RuntimeException e) {
            throw new IOException(e.getMessage());
        }
    }

    private e.a a(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return new e.a(0, null);
        }
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf < 0) {
                return new e.a(i2, str);
            }
            i2++;
            i = indexOf + 1;
        }
    }

    private e.a a(JsonReader jsonReader) {
        StringBuilder sb = new StringBuilder(4096);
        sb.append('[');
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append('{');
            jsonReader.beginObject();
            int i2 = 0;
            while (jsonReader.hasNext()) {
                if (i2 > 0) {
                    sb.append(',');
                }
                i2++;
                com.subao.common.n.g.a(sb, jsonReader.nextName()).append(':');
                switch (AnonymousClass1.f5970a[jsonReader.peek().ordinal()]) {
                    case 1:
                        com.subao.common.n.g.a(sb, jsonReader.nextString());
                        break;
                    case 2:
                        jsonReader.nextNull();
                        com.subao.common.n.g.a(sb, null);
                        break;
                    case 3:
                        sb.append(jsonReader.nextBoolean() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : CrashSight.SDK_IS_DEV);
                        break;
                    case 4:
                        sb.append(jsonReader.nextLong());
                        break;
                    default:
                        jsonReader.skipValue();
                        Log.w("SubaoData", "Unknown field type in NodeInfoV2");
                        break;
                }
            }
            jsonReader.endObject();
            sb.append('}');
            i++;
        }
        jsonReader.endArray();
        sb.append(']');
        return new e.a(i, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.subao.common.e.am$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5970a = new int[JsonToken.values().length];

        static {
            try {
                f5970a[JsonToken.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5970a[JsonToken.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5970a[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5970a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public boolean b() {
        return this.f5969a;
    }

    public an c() {
        return this.e;
    }

    public e.a d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public Integer f() {
        return this.k;
    }

    public Integer g() {
        return this.l;
    }

    public an h() {
        return this.h;
    }

    public an i() {
        return this.f;
    }

    public an j() {
        return this.g;
    }

    public boolean k() {
        return this.n;
    }
}
