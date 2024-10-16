package com.tencent.smtt.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.TbsCoreSettings;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6524a = false;
    public boolean b = false;
    private Map<String, String> c;

    public i() {
        this.c = null;
        this.c = new HashMap();
    }

    public synchronized void a(String str, byte b) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "";
        if (b == 1) {
            str2 = "_begin";
        } else if (b == 2) {
            str2 = "_end";
        }
        this.c.put(str + str2, String.valueOf(System.currentTimeMillis()));
    }

    public synchronized void a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.put(str, String.valueOf(j));
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map = this.c;
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public synchronized boolean a(int i, String str) {
        r a2 = r.a();
        if (!r.b()) {
            return false;
        }
        if ((!this.b || !this.f6524a) && System.currentTimeMillis() % 10 != 0) {
            return true;
        }
        this.b = true;
        this.f6524a = true;
        this.c.put("is_first_init_tbs", String.valueOf(this.b));
        this.c.put("is_first_init_x5", String.valueOf(this.f6524a));
        this.c.put("x5_webview_id", Integer.toString(i));
        this.c.put("current_url", str);
        if (QbSdk.l != null && QbSdk.l.containsKey(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID)) {
            this.c.put(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID, "" + QbSdk.l.get(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID));
        }
        a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[]{Integer.TYPE, Map.class}, Integer.valueOf(i), this.c);
        a(this.c);
        return true;
    }

    private void a(Map<String, String> map) {
        String[] strArr = {"init_all", "tbslog_init", "mtt_trace", "x5_core_engine_init_sync", "tbs_rename_task", "can_load_x5", "read_core_info", "load_tbs_dex", "init_tbs", "init_x5_core", "init_x5_webview", "load_url_gap", "load_url"};
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append("----------------------------start------------------------------");
        sb.append("\n");
        sb.append("is_first_init_x5");
        sb.append(": ");
        sb.append(map.get("is_first_init_x5"));
        sb.append("\n");
        sb.append("is_first_init_tbs");
        sb.append(": ");
        sb.append(map.get("is_first_init_tbs"));
        sb.append("\n");
        sb.append("current_url");
        sb.append(": ");
        sb.append(map.get("current_url"));
        sb.append("\n");
        sb.append("tbs_core_version");
        sb.append(": ");
        sb.append(QbSdk.a());
        sb.append("\n");
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            String str2 = str + "_end";
            String str3 = str + "_begin";
            String str4 = map.get(str2);
            String str5 = map.get(str3);
            if (str4 != null && str5 != null && !str4.isEmpty() && !str5.isEmpty()) {
                long parseLong = Long.parseLong(str4) - Long.parseLong(str5);
                sb.append(str + " duration:\t");
                sb.append(parseLong);
                sb.append("\n");
                if (i == 0) {
                    j = parseLong;
                } else if (i == 11) {
                    j2 = parseLong;
                }
                sb2.append("(" + i + ") ");
                sb2.append(str3);
                sb2.append(" :\t" + map.get(str3));
                sb2.append(";");
                sb2.append("\n");
                sb2.append("(" + i + ") ");
                sb2.append(str2);
                sb2.append(" :\t" + map.get(str2));
                sb2.append(";");
                sb2.append("\n");
            }
        }
        sb.append("\n");
        sb.append("-----------------------start_cost: " + (j - j2) + "-------------------------");
        sb.append("\n");
        sb.append("-------------------------------------------------------------");
        sb.append("\n");
        sb.append(sb2.toString());
        sb.append("----------------------------end------------------------------");
        sb.append("\n");
        Log.e("performance", "" + sb.toString());
    }
}
