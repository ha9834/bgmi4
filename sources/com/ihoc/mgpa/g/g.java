package com.ihoc.mgpa.g;

import android.os.Build;
import com.helpshift.analytics.AnalyticsEventKey;
import com.ihoc.mgpa.BuildConfig;
import com.ihoc.mgpa.f.C0243i;
import com.tdatamaster.tdm.device.DeviceInfoName;
import com.tencent.connect.common.Constants;
import com.tencent.midas.oversea.api.CocosPayHelper;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static String f5562a;
    private a b;
    private String c;
    private String d;
    private HashMap<String, String> e;
    private String f;

    /* loaded from: classes2.dex */
    public enum a {
        CloudContrl("cloudctrl"),
        OptimizeConfig("optimize"),
        SSPConfig("ssp"),
        PDControl("pd_control");

        private String f;

        a(String str) {
            this.f = str;
        }

        public String a() {
            return this.f;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    public g(a aVar) {
        StringBuilder sb;
        String str;
        this.d = a();
        this.b = aVar;
        switch (f.f5561a[aVar.ordinal()]) {
            case 1:
                this.e = b();
                this.c = ".tgpacloud";
                sb = new StringBuilder();
                sb.append(this.d);
                str = "/cloudctrl/cloud_ctrl";
                sb.append(str);
                this.d = sb.toString();
                return;
            case 2:
                this.e = b();
                this.c = ".tgpaspa";
                sb = new StringBuilder();
                sb.append(this.d);
                str = "/cloudctrl/spa";
                sb.append(str);
                this.d = sb.toString();
                return;
            case 3:
                this.e = b();
                sb = new StringBuilder();
                sb.append(this.d);
                str = "/cloudctrl/optimize";
                sb.append(str);
                this.d = sb.toString();
                return;
            case 4:
                this.e = c();
                this.c = ".tgpapdcloud";
                sb = new StringBuilder();
                sb.append(this.d);
                str = "/predown/pd_control";
                sb.append(str);
                this.d = sb.toString();
                return;
            default:
                return;
        }
    }

    private com.ihoc.mgpa.i.g a(String str) {
        try {
            com.ihoc.mgpa.n.m.a("%s download config response content: %s", this.b.a(), String.valueOf(str));
            if (str == null) {
                com.ihoc.mgpa.n.m.a("download config is null, ple check!", new Object[0]);
                return com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_EMPTY;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("ret")) {
                com.ihoc.mgpa.n.m.a("download config has no ret, ple check!", new Object[0]);
                return com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_HAS_NO_RET;
            }
            int i = jSONObject.getInt("ret");
            if (i != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("download config ret is not zero, ple check ret: ");
                sb.append(i);
                com.ihoc.mgpa.n.m.a(sb.toString(), new Object[0]);
                return com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_RET_IS_NOT_0;
            }
            if (jSONObject.has("data")) {
                this.f = jSONObject.getString("data");
                return com.ihoc.mgpa.i.g.VMP_SUCCESS;
            }
            com.ihoc.mgpa.n.m.a("download config has no data, ple check! ", new Object[0]);
            return com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_HAS_NO_DATA;
        } catch (JSONException e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("download config parse json exception, ple check content! ", new Object[0]);
            return com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_CONTENT_JSON_ERROR;
        } catch (Exception e2) {
            e2.printStackTrace();
            com.ihoc.mgpa.n.m.a("download config parse exception, ple check! ", new Object[0]);
            return com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_CONTENT_ERROR;
        }
    }

    public static String a() {
        String b = C0243i.a().b("TGPA_CLOUD_URL");
        if (com.ihoc.mgpa.i.f.M()) {
            return "https://testcloud.vmp.onezapp.com";
        }
        String a2 = com.ihoc.mgpa.n.a.a("TGPA.Domain");
        if (a2 != null) {
            return a2;
        }
        String str = f5562a;
        return str != null ? str : b != null ? b : "https://cloud.vmp.onezapp.com";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, m mVar) {
        String str2;
        try {
            com.ihoc.mgpa.i.g gVar = com.ihoc.mgpa.i.g.VMP_FAILED;
            switch (f.f5561a[this.b.ordinal()]) {
                case 1:
                    if (mVar.a(a(str), this.f)) {
                        com.ihoc.mgpa.b.f.f5489a = System.currentTimeMillis() / 1000;
                        str2 = this.f;
                        break;
                    } else {
                        return;
                    }
                case 2:
                    if (mVar.a(a(str), this.f)) {
                        str2 = this.f;
                        break;
                    } else {
                        return;
                    }
                case 3:
                    if (mVar.a(a(str), this.f)) {
                        str2 = this.f;
                        break;
                    } else {
                        return;
                    }
                case 4:
                    com.ihoc.mgpa.i.g a2 = a(str);
                    this.f = str;
                    if (mVar.a(a2, this.f)) {
                        v.f5583a = System.currentTimeMillis() / 1000;
                        str2 = this.f;
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
            a(str2, this.c);
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("async download config, parse response content exception.", new Object[0]);
        }
    }

    private void a(String str, String str2) {
        if (str2 == null) {
            com.ihoc.mgpa.n.m.a("%s config download success, but don't need to save in file.", this.b.a());
            return;
        }
        try {
            String str3 = com.ihoc.mgpa.n.a.e() + File.separator + str2;
            com.ihoc.mgpa.n.m.a("%s download config success, save file: %s", this.b.a(), str2);
            com.ihoc.mgpa.n.i.c(str3, str);
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.b("download config save to file exception, ple check!", new Object[0]);
        }
    }

    private HashMap<String, String> b() {
        String a2 = com.ihoc.mgpa.n.a.a("GCloud.GCloud.GameId");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sdk_type", "tgpa");
        hashMap.put("plat_type", "Android");
        hashMap.put("ver_code", String.valueOf(BuildConfig.VERSION_CODE));
        hashMap.put("ver_name", BuildConfig.VERSION_NAME);
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put("os_sdk", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", com.ihoc.mgpa.n.f.d());
        hashMap.put(Constants.PARAM_PKG_NAME, com.ihoc.mgpa.n.a.c());
        hashMap.put("pkg_version", com.ihoc.mgpa.i.f.i());
        if (a2 == null) {
            a2 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
        }
        hashMap.put("gcloud_id", a2);
        hashMap.put(DeviceInfoName.XID_STRING, com.ihoc.mgpa.c.r.c());
        hashMap.put(Constants.JumpUrlConstants.URL_KEY_OPENID, com.ihoc.mgpa.n.o.a("TGPAOID", ""));
        return hashMap;
    }

    private HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap<>();
        String a2 = com.ihoc.mgpa.n.a.a("GCloud.GCloud.GameId");
        String valueOf = String.valueOf(com.ihoc.mgpa.n.f.a(com.ihoc.mgpa.n.a.a()));
        String b = com.ihoc.mgpa.n.f.b(com.ihoc.mgpa.n.a.a());
        String valueOf2 = String.valueOf(com.ihoc.mgpa.i.f.j());
        String valueOf3 = String.valueOf(com.ihoc.mgpa.i.f.u());
        if (com.ihoc.mgpa.n.p.a(valueOf2)) {
            valueOf2 = com.ihoc.mgpa.n.o.a("main_version_code", "");
        }
        if (com.ihoc.mgpa.n.p.a(valueOf3)) {
            valueOf3 = com.ihoc.mgpa.n.o.a("sub_version_code", "");
        }
        hashMap.put("app_version", String.valueOf(com.ihoc.mgpa.i.f.i()));
        hashMap.put("vc", valueOf);
        hashMap.put("vn", b);
        hashMap.put(AnalyticsEventKey.SMART_INTENT_MODEL_VERSION, valueOf2);
        hashMap.put("sv", valueOf3);
        hashMap.put("channel_id", com.ihoc.mgpa.i.f.f());
        hashMap.put("app_name", com.ihoc.mgpa.n.a.c());
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put("model", com.ihoc.mgpa.n.f.d());
        hashMap.put(Constants.JumpUrlConstants.URL_KEY_SDK_VERSION, BuildConfig.VERSION_NAME);
        hashMap.put("sdk_code", String.valueOf(BuildConfig.VERSION_CODE));
        hashMap.put(DeviceInfoName.XID_STRING, com.ihoc.mgpa.c.r.c());
        if (a2 == null) {
            a2 = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
        }
        hashMap.put("gcloud_id", a2);
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put("os_sdk", String.valueOf(Build.VERSION.SDK_INT));
        return hashMap;
    }

    public void a(int i, int i2, m mVar) {
        com.ihoc.mgpa.n.m.a("sync type: %s , url: %s , data: %s", this.b.a(), this.d, this.e.toString());
        com.ihoc.mgpa.n.l.a(i);
        com.ihoc.mgpa.n.l.b(i2);
        a(com.ihoc.mgpa.n.l.b(this.d, this.e), mVar);
    }

    public void a(m mVar) {
        com.ihoc.mgpa.n.m.a("sync type: %s , url: %s , data: %s", this.b.a(), this.d, this.e.toString());
        new com.ihoc.mgpa.n.c(new C0248e(this, mVar)).a(this.d, this.e);
    }

    public void b(m mVar) {
        com.ihoc.mgpa.n.m.a("sync type: %s , url: %s , data: %s", this.b.a(), this.d, this.e.toString());
        com.ihoc.mgpa.n.l.a(5000);
        com.ihoc.mgpa.n.l.b(5000);
        a(com.ihoc.mgpa.n.l.b(this.d, this.e), mVar);
    }
}
