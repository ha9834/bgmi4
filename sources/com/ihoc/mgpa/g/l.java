package com.ihoc.mgpa.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5568a;
    public String b;
    public String c;
    public c d;
    public b e;
    public a f;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String[] f5569a;
        public String[] b;

        public a() {
        }

        public boolean a(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("cpu");
                this.f5569a = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f5569a[i] = jSONArray.getString(i);
                }
                JSONArray jSONArray2 = jSONObject.getJSONArray("gpu");
                this.b = new String[jSONArray2.length()];
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    this.b[i2] = jSONArray2.getString(i2);
                }
                return true;
            } catch (Exception unused) {
                com.ihoc.mgpa.n.m.a("TGPA_deviceCheckConfig", "Hardware:parseJson: exception.");
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<String> f5570a = new ArrayList<>();
        public ArrayList<String> b = new ArrayList<>();

        public b() {
        }

        public boolean a(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("match");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f5570a.add(jSONArray.getString(i));
                }
                JSONArray jSONArray2 = jSONObject.getJSONArray("exsit");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    this.b.add(jSONArray2.getString(i2));
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                com.ihoc.mgpa.n.m.a("TGPA_deviceCheckConfig", "PackageList:parseJson: exception.");
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public HashMap<String, String[]> f5571a = new HashMap<>();
        public HashMap<String, String[]> b = new HashMap<>();

        public c() {
        }

        public boolean a(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("match");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject2.getJSONArray(next);
                    String[] strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.getString(i);
                    }
                    this.f5571a.put(next, strArr);
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("exsit");
                Iterator<String> keys2 = jSONObject3.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    JSONArray jSONArray2 = jSONObject3.getJSONArray(next2);
                    String[] strArr2 = new String[jSONArray2.length()];
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        strArr2[i2] = jSONArray2.getString(i2);
                    }
                    this.b.put(next2, strArr2);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                com.ihoc.mgpa.n.m.a("TGPA_deviceCheckConfig", "Prop:parseJson: exception.");
                return false;
            }
        }
    }

    public boolean a() {
        try {
            JSONObject jSONObject = new JSONObject("{\"available\":false,\"package\":{\"exsit\":[],\"match\":[]},\"brand\":\"common\",\"prop\":{\"exsit\":{},\"match\":{\"ro.product.board\":[],\"ro.build.fingerprint\":[],\"ro.product.manufacturer\":[],\"ro.product.model\":[],\"ro.build.product\":[],\"ro.build.version.release\":[],\"ro.product.device\":[],\"ro.hardware\":[],\"ro.product.brand\":[]}},\"hardware\":{\"gpu\":[],\"cpu\":[]},\"model\":\"common\"}");
            this.b = jSONObject.getString("model");
            this.c = jSONObject.getString("brand");
            this.f5568a = jSONObject.getBoolean("available");
            this.d = new c();
            this.d.a(jSONObject.getJSONObject("prop"));
            this.e = new b();
            this.e.a(jSONObject.getJSONObject("package"));
            this.f = new a();
            this.f.a(jSONObject.getJSONObject("hardware"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA_deviceCheckConfig", "DeviceCheckConfig: parse: exception.");
            return false;
        }
    }

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            this.b = jSONObject.getString("model");
            this.c = jSONObject.getString("brand");
            this.f5568a = jSONObject.getBoolean("available");
            this.d = new c();
            this.d.a(jSONObject.getJSONObject("prop"));
            this.e = new b();
            this.e.a(jSONObject.getJSONObject("package"));
            this.f = new a();
            this.f.a(jSONObject.getJSONObject("hardware"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA_deviceCheckConfig", "DeviceCheckConfig: parse: exception.");
            return false;
        }
    }
}
