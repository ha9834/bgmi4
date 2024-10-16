package com.subao.common.b;

import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.helpshift.util.ErrorReportProvider;
import com.subao.common.e.an;
import com.subao.common.e.r;
import com.subao.common.intf.QueryThirdPartyAuthInfoCallback;
import com.subao.common.intf.ThirdPartyAuthInfo;
import com.subao.common.intf.UserInfo;
import com.subao.common.j.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/* loaded from: classes2.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final String f5930a;
    private final an b;
    private final String c;
    private final int d;
    private final UserInfo e;
    private final QueryThirdPartyAuthInfoCallback f;

    public l(String str, an anVar, String str2, UserInfo userInfo, int i, QueryThirdPartyAuthInfoCallback queryThirdPartyAuthInfoCallback) {
        this.f5930a = str;
        this.b = anVar == null ? r.c : anVar;
        this.c = str2;
        this.d = i;
        this.e = userInfo;
        this.f = queryThirdPartyAuthInfoCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a(com.subao.common.j.b.a(new com.subao.common.j.b(this.d, this.d).a(a(), b.EnumC0172b.POST, b.a.JSON.e), b()));
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
            a((b.c) null);
        }
    }

    private void a(b.c cVar) {
        int i = 1008;
        ThirdPartyAuthInfo thirdPartyAuthInfo = null;
        if (cVar == null) {
            i = 1006;
        } else if (cVar.f6066a == 201) {
            try {
                thirdPartyAuthInfo = a(cVar.b);
                i = 0;
            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
            }
        }
        if (com.subao.common.d.a("SubaoAuth")) {
            a(thirdPartyAuthInfo);
        }
        this.f.onThirdPartyAuthInfoResult(i, thirdPartyAuthInfo);
    }

    private static void a(ThirdPartyAuthInfo thirdPartyAuthInfo) {
        if (thirdPartyAuthInfo == null) {
            Log.d("SubaoAuth", "Third party auth info is null");
        } else {
            Log.d("SubaoAuth", String.format(r.f6001a, "Third party auth info: %s, %s, openId=%s, expiresIn=%d", thirdPartyAuthInfo.getAccessToken(), thirdPartyAuthInfo.getRefreshToken(), thirdPartyAuthInfo.getOpenId(), Long.valueOf(thirdPartyAuthInfo.getExpiresIn())));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ThirdPartyAuthInfo a(byte[] bArr) {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bArr), "UTF-8"));
        try {
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            long j = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (SDKConstants.PARAM_ACCESS_TOKEN.equals(nextName)) {
                    str = com.subao.common.n.g.b(jsonReader);
                } else if ("expiresIn".equals(nextName)) {
                    j = jsonReader.nextLong();
                } else if ("refreshToken".equals(nextName)) {
                    str2 = com.subao.common.n.g.b(jsonReader);
                } else if ("openId".equals(nextName)) {
                    str3 = com.subao.common.n.g.b(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            return TextUtils.isEmpty(str) ? null : new ThirdPartyAuthInfo(str, str2, str3, j);
        } finally {
            com.subao.common.e.a(jsonReader);
        }
    }

    private URL a() {
        return new URL(this.b.f5971a, this.b.b, this.b.c, String.format("/api/v1/%s/sessions?grant_type=client_credentials&version=%s", com.subao.common.e.a(this.f5930a), com.subao.common.e.a(this.c)));
    }

    private byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(byteArrayOutputStream, "UTF-8"));
        try {
            jsonWriter.beginObject();
            jsonWriter.name("token").value(this.e.getToken());
            jsonWriter.name("authType").value(1L);
            com.subao.common.n.g.a(jsonWriter, "userId", this.e.getUserId());
            com.subao.common.n.g.a(jsonWriter, ErrorReportProvider.KEY_APP_ID, this.e.getAppId());
            jsonWriter.endObject();
            com.subao.common.e.a(jsonWriter);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            com.subao.common.e.a(jsonWriter);
            throw th;
        }
    }
}
