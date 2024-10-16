package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.tagmanager.DataLayer;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@zzard
/* loaded from: classes2.dex */
public final class zzazx {

    /* renamed from: a, reason: collision with root package name */
    private static Object f2846a = new Object();
    private static boolean b = false;
    private static boolean c = false;
    private static Clock d = DefaultClock.getInstance();
    private static final Set<String> e = new HashSet(Arrays.asList(new String[0]));
    private final List<String> f;

    public zzazx() {
        this(null);
    }

    public zzazx(String str) {
        List<String> asList;
        if (!isEnabled()) {
            asList = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            asList = Arrays.asList(strArr);
        }
        this.f = asList;
    }

    public final void zza(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (isEnabled()) {
            a(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void zza(String str, String str2, Map<String, ?> map, byte[] bArr) {
        if (isEnabled()) {
            a(str, str2, map, bArr);
        }
    }

    private final void a(final String str, final String str2, final Map<String, ?> map, final byte[] bArr) {
        a("onNetworkRequest", new gu(str, str2, map, bArr) { // from class: com.google.android.gms.internal.ads.gq

            /* renamed from: a, reason: collision with root package name */
            private final String f2197a;
            private final String b;
            private final Map c;
            private final byte[] d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2197a = str;
                this.b = str2;
                this.c = map;
                this.d = bArr;
            }

            @Override // com.google.android.gms.internal.ads.gu
            public final void a(JsonWriter jsonWriter) {
                zzazx.a(this.f2197a, this.b, this.c, this.d, jsonWriter);
            }
        });
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        if (isEnabled()) {
            String str = null;
            a(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    zzbad.zzep(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                a(str);
            }
        }
    }

    public final void zza(Map<String, ?> map, int i) {
        if (isEnabled()) {
            a(map, i);
            if (i < 200 || i >= 300) {
                a(null);
            }
        }
    }

    private final void a(final Map<String, ?> map, final int i) {
        a("onNetworkResponse", new gu(i, map) { // from class: com.google.android.gms.internal.ads.gr

            /* renamed from: a, reason: collision with root package name */
            private final int f2198a;
            private final Map b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2198a = i;
                this.b = map;
            }

            @Override // com.google.android.gms.internal.ads.gu
            public final void a(JsonWriter jsonWriter) {
                zzazx.a(this.f2198a, this.b, jsonWriter);
            }
        });
    }

    public final void zzek(String str) {
        if (isEnabled() && str != null) {
            zzj(str.getBytes());
        }
    }

    public final void zzj(final byte[] bArr) {
        a("onNetworkResponseBody", new gu(bArr) { // from class: com.google.android.gms.internal.ads.gs

            /* renamed from: a, reason: collision with root package name */
            private final byte[] f2199a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2199a = bArr;
            }

            @Override // com.google.android.gms.internal.ads.gu
            public final void a(JsonWriter jsonWriter) {
                zzazx.a(this.f2199a, jsonWriter);
            }
        });
    }

    private final void a(final String str) {
        a("onNetworkRequestError", new gu(str) { // from class: com.google.android.gms.internal.ads.gt

            /* renamed from: a, reason: collision with root package name */
            private final String f2200a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2200a = str;
            }

            @Override // com.google.android.gms.internal.ads.gu
            public final void a(JsonWriter jsonWriter) {
                zzazx.a(this.f2200a, jsonWriter);
            }
        });
    }

    private static void a(JsonWriter jsonWriter, Map<String, ?> map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it.next();
            String key = next.getKey();
            if (!e.contains(key)) {
                if (next.getValue() instanceof List) {
                    for (String str : (List) next.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(key);
                        jsonWriter.name("value").value(str);
                        jsonWriter.endObject();
                    }
                } else if (next.getValue() instanceof String) {
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(key);
                    jsonWriter.name("value").value((String) next.getValue());
                    jsonWriter.endObject();
                } else {
                    zzbad.zzen("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                    break;
                }
            }
        }
        jsonWriter.endArray();
    }

    private final void a(String str, gu guVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(d.currentTimeMillis());
            jsonWriter.name(DataLayer.EVENT_KEY).value(str);
            jsonWriter.name("components").beginArray();
            Iterator<String> it = this.f.iterator();
            while (it.hasNext()) {
                jsonWriter.value(it.next());
            }
            jsonWriter.endArray();
            guVar.a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e2) {
            zzbad.zzc("unable to log", e2);
        }
        b(stringWriter.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized void b(String str) {
        synchronized (zzazx.class) {
            zzbad.zzeo("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND;
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzbad.zzeo(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i = i2;
            }
            zzbad.zzeo("GMA Debug FINISH");
        }
    }

    public static void zzxa() {
        synchronized (f2846a) {
            b = false;
            c = false;
            zzbad.zzep("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzal(boolean z) {
        synchronized (f2846a) {
            b = true;
            c = z;
        }
    }

    public static boolean zzxb() {
        boolean z;
        synchronized (f2846a) {
            z = b;
        }
        return z;
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (f2846a) {
            z = b && c;
        }
        return z;
    }

    public static boolean zzbk(Context context) {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcqb)).booleanValue()) {
            return false;
        }
        try {
            return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        } catch (Exception e2) {
            zzbad.zzd("Fail to determine debug setting.", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        if (str != null) {
            jsonWriter.name(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION).value(str);
        }
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        int length = bArr.length;
        String encode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(encode);
        } else {
            String zzei = zzazt.zzei(encode);
            if (zzei != null) {
                jsonWriter.name("bodydigest").value(zzei);
            }
        }
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i);
        jsonWriter.endObject();
        a(jsonWriter, (Map<String, ?>) map);
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(ShareConstants.MEDIA_URI).value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        a(jsonWriter, (Map<String, ?>) map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }
}
