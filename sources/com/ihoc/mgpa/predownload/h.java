package com.ihoc.mgpa.predownload;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import com.amazonaws.http.HttpHeader;
import com.helpshift.analytics.AnalyticsEventKey;
import com.ihoc.mgpa.BuildConfig;
import com.ihoc.mgpa.c.r;
import com.ihoc.mgpa.n.i;
import com.ihoc.mgpa.n.l;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.n.o;
import com.ihoc.mgpa.predownload.b;
import com.intlgame.webview.WebViewManager;
import com.tdatamaster.tdm.device.DeviceInfoName;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private String f5699a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private GameCallback g;

    /* loaded from: classes2.dex */
    private static class a extends AsyncTask<String, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private final String f5700a;
        private final HashMap<String, String> b;
        private final c c;

        public a(String str, c cVar) {
            this.f5700a = str;
            this.b = new HashMap<>();
            this.c = cVar;
        }

        public a(String str, HashMap<String, String> hashMap, c cVar) {
            this.f5700a = str;
            this.b = hashMap;
            this.c = cVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            Object[] objArr;
            String str;
            try {
                HashMap<String, String> b = this.c.b();
                HashMap<String, String> a2 = this.c.a();
                if (this.b != null) {
                    a2.putAll(this.b);
                }
                for (Map.Entry<String, String> entry : a2.entrySet()) {
                    if (entry.getValue() == null) {
                        a2.put(entry.getKey(), "");
                    }
                }
                m.a("start to request server, url: %s, header: %s , form data: %s", this.f5700a, b.toString(), a2.toString());
                this.c.a(l.a(this.f5700a, a2, b));
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                objArr = new Object[]{this.f5700a};
                str = "http request exception, ple check! url: %s";
                m.b(str, objArr);
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                objArr = new Object[0];
                str = "request data code run exception, ple check!";
                m.b(str, objArr);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private String f5701a;
        private String f;
        private String b = com.huawei.game.gamekit.b.a.f5471a;
        private GameCallback g = null;
        private String c = "https://version.tgpa.qq.com";
        private String d = null;
        private String e = null;

        public b a(String str) {
            this.d = str;
            return this;
        }

        public b a(boolean z) {
            this.c = z ? "https://testversion.tgpa.qq.com" : "https://version.tgpa.qq.com";
            return this;
        }

        public h a() {
            return new h(this);
        }

        public b b(String str) {
            this.e = str;
            return this;
        }

        public b c(String str) {
            this.b = str;
            return this;
        }

        public b d(String str) {
            this.f5701a = str;
            return this;
        }

        public b e(String str) {
            this.f = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface c {
        HashMap<String, String> a();

        void a(String str);

        HashMap<String, String> b();
    }

    /* loaded from: classes2.dex */
    public enum d {
        GetPredownloadInfo("pd_pkg_ver"),
        ReportChannelDownloadStatus("pd_data_report"),
        GetCombineConfig("pd_combine_pkg");

        private final String e;

        d(String str) {
            this.e = str;
        }

        public String a() {
            return this.e;
        }
    }

    public h(b bVar) {
        this.f5699a = bVar.f5701a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        b.d dVar;
        if (str == null) {
            m.a("onResponse: request predownload info failed!", new Object[0]);
            dVar = b.d.NetworkException;
        } else {
            try {
                m.a("onResponse: request version response data: %s", str);
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("ret") || !jSONObject.has("data")) {
                    m.b("OnResponse: request failed, json format is not correct! please check the data: %s", str);
                    return b.d.ResponseDataJsonFormatException.a();
                }
                if (jSONObject.getInt("ret") != 0) {
                    m.b("OnResponse: request failed, ret is not 0! please check response: %s", str);
                    return jSONObject.toString();
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                        jSONObject3.put("path", Environment.getExternalStorageDirectory() + File.separator + jSONObject3.getString("path") + File.separator);
                    } catch (Exception e) {
                        e.printStackTrace();
                        StringBuilder sb = new StringBuilder();
                        sb.append("onResponse: check game predownload info exception. game: ");
                        sb.append(next);
                        m.b(sb.toString(), new Object[0]);
                    }
                }
                return jSONObject.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                m.b("OnResponse: network response content parse to json exception.", new Object[0]);
                dVar = b.d.ResponseDataIsNotJson;
            }
        }
        return dVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        hashMap.put("X-Requested-With", "XMLHttpRequest");
        hashMap.put(HttpHeader.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < arrayList.size(); i++) {
            String str = arrayList.get(i);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("vc", String.valueOf(com.ihoc.mgpa.n.f.a(context, str))).put("vn", com.ihoc.mgpa.n.f.b(context, str));
                String j = com.ihoc.mgpa.i.f.j();
                if ("".equals(j)) {
                    j = o.a("main_version_code", "");
                }
                String u = com.ihoc.mgpa.i.f.u();
                if ("".equals(u)) {
                    u = o.a("sub_version_code", "");
                }
                jSONObject2.put(AnalyticsEventKey.SMART_INTENT_MODEL_VERSION, j).put("sv", u);
                jSONObject.put(str, jSONObject2);
            } catch (JSONException unused) {
                m.a("get game local version info exception! pkg: %s", str);
            }
        }
        return jSONObject.toString();
    }

    public h a(GameCallback gameCallback) {
        this.g = gameCallback;
        return this;
    }

    public String a(String str, com.ihoc.mgpa.predownload.a aVar) {
        String str2 = this.c + "/" + d.GetCombineConfig.a();
        HashMap<String, String> a2 = a();
        a2.put("app_name", str);
        String valueOf = String.valueOf(System.currentTimeMillis());
        String f = i.f(aVar.c);
        String str3 = aVar.b;
        if (str3 == null) {
            str3 = "";
        }
        String format = String.format("time_stamp=%s&api_key=%s&api_secret=%s&cdn_url=%s&cdn_md5=%s&game_package=%s&predownload_file=%s", valueOf, this.d, this.e, aVar.f5686a, str3, aVar.e, f);
        HashMap hashMap = new HashMap();
        hashMap.put("time_stamp", valueOf);
        hashMap.put("api_key", this.d);
        hashMap.put("api_sign", String.valueOf(com.ihoc.mgpa.n.g.a(format)));
        hashMap.put("model", com.ihoc.mgpa.n.f.d());
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put(WebViewManager.KEY_JS_CHANNEL, this.b);
        hashMap.put("sdk_code", String.valueOf(BuildConfig.VERSION_CODE));
        hashMap.put(Constants.JumpUrlConstants.URL_KEY_SDK_VERSION, BuildConfig.VERSION_NAME);
        hashMap.put("cdn_url", aVar.f5686a);
        String str4 = aVar.b;
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("cdn_md5", str4);
        hashMap.put("game_package", aVar.e);
        hashMap.put("predownload_file", f);
        hashMap.put("predownfile_md5", aVar.d);
        hashMap.put("app_name", str);
        hashMap.put(DeviceInfoName.XID_STRING, r.c());
        String str5 = this.f;
        if (str5 == null) {
            str5 = "";
        }
        hashMap.put("oaid", str5);
        try {
            m.a("request combine config, data: %s , header: %s", hashMap.toString(), a2.toString());
            return l.a(str2, hashMap, a2);
        } catch (IOException e) {
            e.printStackTrace();
            m.b("request predownload combine config exception.", new Object[0]);
            return null;
        }
    }

    public void a(Context context, ArrayList<String> arrayList) {
        new a(this.c + "/" + d.GetPredownloadInfo.a(), new f(this, context, arrayList)).execute(new String[0]);
    }

    public void a(HashMap<String, String> hashMap) {
        new a(this.c + "/" + d.ReportChannelDownloadStatus.a(), hashMap, new g(this)).execute(new String[0]);
    }
}
