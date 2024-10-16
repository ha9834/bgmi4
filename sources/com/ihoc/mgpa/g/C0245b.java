package com.ihoc.mgpa.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ihoc.mgpa.g.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0245b {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<a> f5556a = new ArrayList<>();

    /* renamed from: com.ihoc.mgpa.g.b$a */
    /* loaded from: classes2.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        String f5557a;
        boolean b;
        boolean c;
        HashMap<String, String> d;

        private a() {
            this.b = false;
            this.c = false;
            this.d = new HashMap<>();
        }

        public boolean a(JSONObject jSONObject) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    char c = 65535;
                    int hashCode = valueOf.hashCode();
                    if (hashCode != 106079) {
                        if (hashCode != 114983) {
                            if (hashCode == 114994 && valueOf.equals("toM")) {
                                c = 1;
                            }
                        } else if (valueOf.equals("toB")) {
                            c = 2;
                        }
                    } else if (valueOf.equals("key")) {
                        c = 0;
                    }
                    if (c == 0) {
                        this.f5557a = jSONObject.optString("key", null);
                    } else if (c == 1) {
                        this.b = jSONObject.optBoolean(valueOf);
                    } else if (c != 2) {
                        this.d.put(valueOf, jSONObject.optString(valueOf, null));
                    } else {
                        this.c = jSONObject.optBoolean(valueOf);
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public HashMap<String, String> a(String str) {
        if (str == null || str.length() <= 0) {
            com.ihoc.mgpa.n.m.b("TGPA_APMKeys", "VmpHandler:handleAPMKey: get apmkey arr failed , or length is not matched.");
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        int length = str.length();
        int size = this.f5556a.size();
        for (int i = 0; i < length && i < size; i++) {
            int i2 = length - i;
            String substring = str.substring(i2 - 1, i2);
            a aVar = this.f5556a.get(i);
            String str2 = aVar.f5557a;
            String str3 = aVar.d.get(substring);
            if (str3 == null) {
                com.ihoc.mgpa.n.m.a("TGPA_APMKeys", "VmpHandler:handleAPMKey: can not find key's transform value, use apm's value. key: " + str2);
            } else {
                substring = str3;
            }
            if (aVar.b) {
                hashMap.put(str2, substring);
            }
        }
        return hashMap;
    }

    public boolean a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                    if (jSONObject != null) {
                        a aVar = new a();
                        aVar.a(jSONObject);
                        this.f5556a.add(aVar);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }
}
