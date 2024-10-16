package com.ihoc.mgpa.g;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, ArrayList<String>> f5580a;
    public HashMap<String, a> b;
    public boolean c = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f5581a;
        public long b;
        public String c;
        public long d;
        public int e;

        public a(String str, long j, String str2, long j2, int i) {
            this.f5581a = str;
            this.b = j;
            this.c = str2;
            this.d = j2;
            this.e = i;
        }
    }

    public boolean a(JSONObject jSONObject) {
        String str;
        String str2;
        int i = 0;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            this.f5580a = new HashMap<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2.has("channel_id") && jSONObject2.has("channel_name") && jSONObject2.has("predown_path")) {
                    String string = jSONObject2.getString("channel_name");
                    String string2 = jSONObject2.getString("predown_path");
                    StringBuilder sb = new StringBuilder();
                    sb.append("PD:parseCloudConfig: add map channel  ");
                    sb.append(String.valueOf(string));
                    sb.append("  path ");
                    sb.append(String.valueOf(string2));
                    com.ihoc.mgpa.n.m.a("TGPA_PDCloudConfig", sb.toString());
                    if (this.f5580a.containsKey(string)) {
                        this.f5580a.get(string).add(string2);
                    } else {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(string2);
                        this.f5580a.put(string, arrayList);
                    }
                } else {
                    com.ihoc.mgpa.n.m.a("TGPA_PDCloudConfig", "PD:parseCloudConfig: pase cloud config data exception, can not find id & channel & path.");
                }
            }
            if (jSONObject.has("file_list")) {
                this.b = new HashMap<>();
                JSONArray jSONArray2 = jSONObject.getJSONArray("file_list");
                int i3 = 0;
                while (i3 < jSONArray2.length()) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                    if (jSONObject3.has("file_name") && jSONObject3.has("file_md5")) {
                        String string3 = jSONObject3.getString("file_name");
                        this.b.put(string3, new a(string3, jSONObject3.optInt("file_size", i), jSONObject3.optString("file_md5"), jSONObject3.optLong("offset"), jSONObject3.optInt("size")));
                    } else {
                        com.ihoc.mgpa.n.m.a("TGPA_PDCloudConfig", "PreDownloadHelper: maybe fileinfo's format in file_list is not corrent.");
                    }
                    i3++;
                    i = 0;
                }
            }
            if (jSONObject.has("is_copy_prefile")) {
                this.c = jSONObject.getBoolean("is_copy_prefile");
            }
            if (this.f5580a.size() > 0) {
                return true;
            }
            com.ihoc.mgpa.n.m.a("TGPA_PDCloudConfig", "PD:parseCloudConfig: pase cloud config data failed, can not find channel & path.");
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            str = "TGPA_PDCloudConfig";
            str2 = "PreDownloadHelper:parseCloudConfig: parse cloud config to json exception.";
            com.ihoc.mgpa.n.m.a(str, str2);
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "TGPA_PDCloudConfig";
            str2 = "PD:parseCloudConfig: pase cloud config data exception.";
            com.ihoc.mgpa.n.m.a(str, str2);
            return false;
        }
    }
}
