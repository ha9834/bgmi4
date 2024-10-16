package com.tencent.open.a;

import android.os.Build;
import android.text.TextUtils;
import com.amazonaws.http.HttpHeader;
import com.helpshift.common.domain.network.NetworkConstants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.k;
import okhttp3.q;
import okhttp3.u;
import okhttp3.v;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f6357a;
    private x b;
    private h c;

    protected a() {
        b();
    }

    private void b() {
        x.a a2 = new x.a().a(Arrays.asList(k.b, k.c)).a(15000L, TimeUnit.MILLISECONDS).b(30000L, TimeUnit.MILLISECONDS).c(30000L, TimeUnit.MILLISECONDS).a((okhttp3.c) null).a(new C0209a("AndroidSDK_" + Build.VERSION.SDK + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + f.a().a(g.a()) + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + Build.VERSION.RELEASE));
        a(a2);
        this.b = a2.a();
    }

    public static a a() {
        if (f6357a == null) {
            synchronized (a.class) {
                if (f6357a == null) {
                    f6357a = new a();
                }
            }
        }
        f6357a.c();
        return f6357a;
    }

    public void a(h hVar) {
        this.c = hVar;
        c();
    }

    private void c() {
        h hVar = this.c;
        if (hVar == null) {
            return;
        }
        int a2 = hVar.a("Common_HttpConnectionTimeout");
        if (a2 == 0) {
            a2 = 15000;
        }
        int a3 = this.c.a("Common_SocketConnectionTimeout");
        if (a3 == 0) {
            a3 = NetworkConstants.UPLOAD_CONNECT_TIMEOUT;
        }
        a(a2, a3);
    }

    public void a(long j, long j2) {
        if (this.b.b() == j && this.b.c() == j2) {
            return;
        }
        SLog.i("openSDK_LOG.OpenHttpService", "setTimeout changed.");
        this.b = this.b.A().a(j, TimeUnit.MILLISECONDS).b(j2, TimeUnit.MILLISECONDS).c(j2, TimeUnit.MILLISECONDS).a();
    }

    public b a(String str, Map<String, String> map) throws IOException {
        if (map == null || map.isEmpty()) {
            return a(str, "");
        }
        StringBuilder sb = new StringBuilder("");
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            if (str3 != null) {
                sb.append(URLEncoder.encode(str2, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(str3, "UTF-8"));
                sb.append("&");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return a(str, sb.toString());
    }

    public b a(String str, String str2) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "get.");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = str + "?";
            } else if (indexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return new b(this.b.a(new z.a().a(str).a().b()).a(), str2.length());
    }

    public b b(String str, Map<String, String> map) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "post data");
        q.a aVar = new q.a();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    aVar.a(str2, str3);
                }
            }
        }
        q a2 = aVar.a();
        return new b(this.b.a(new z.a().a(str).a(a2).b()).a(), (int) a2.c());
    }

    public b a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 == null || map2.size() == 0) {
            return b(str, map);
        }
        SLog.i("openSDK_LOG.OpenHttpService", "post data, has byte data");
        w.a aVar = new w.a();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    aVar.a(str2, str3);
                }
            }
        }
        for (String str4 : map2.keySet()) {
            byte[] bArr = map2.get(str4);
            if (bArr != null && bArr.length > 0) {
                aVar.a(str4, str4, aa.a(v.a("content/unknown"), bArr));
                SLog.w("openSDK_LOG.OpenHttpService", "post byte data.");
            }
        }
        w a2 = aVar.a();
        return new b(this.b.a(new z.a().a(str).a(a2).b()).a(), (int) a2.c());
    }

    private void a(x.a aVar) {
        if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT >= 21) {
            return;
        }
        try {
            c cVar = new c();
            TrustManager a2 = cVar.a();
            if (a2 == null) {
                return;
            }
            aVar.a(cVar, (X509TrustManager) a2);
            SLog.i("openSDK_LOG.OpenHttpService", "enableTls2: enabled.");
        } catch (KeyManagementException e) {
            SLog.e("openSDK_LOG.OpenHttpService", "enableTls2: failed.", e);
        } catch (KeyStoreException e2) {
            SLog.e("openSDK_LOG.OpenHttpService", "enableTls2: failed.", e2);
        } catch (NoSuchAlgorithmException e3) {
            SLog.e("openSDK_LOG.OpenHttpService", "enableTls2: failed.", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0209a implements u {

        /* renamed from: a, reason: collision with root package name */
        private final String f6359a;

        public C0209a(String str) {
            this.f6359a = str;
        }

        @Override // okhttp3.u
        public ab intercept(u.a aVar) throws IOException {
            return aVar.a(aVar.a().e().a(HttpHeader.USER_AGENT, this.f6359a).b());
        }
    }
}
