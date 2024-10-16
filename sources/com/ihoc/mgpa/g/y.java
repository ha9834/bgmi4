package com.ihoc.mgpa.g;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, a> f5586a;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f5587a;
        String b;
        int c;
        int d;
        HashMap<String, String> e;

        boolean a(String str, JSONObject jSONObject) {
            try {
                String[] split = str.split("\\|");
                this.f5587a = Integer.parseInt(split[0]);
                this.b = split[1];
                this.c = Integer.parseInt(split[2]);
                this.d = Integer.parseInt(split[3]);
                Iterator<String> keys = jSONObject.keys();
                this.e = new HashMap<>();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.e.put(next, jSONObject.getString(next));
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public HashMap<String, String> a(String str) {
        a aVar;
        HashMap<String, a> hashMap = this.f5586a;
        if (hashMap == null || !hashMap.containsKey(str) || (aVar = this.f5586a.get(str)) == null) {
            return null;
        }
        return aVar.e;
    }

    public boolean a(JSONObject jSONObject) {
        try {
            this.f5586a = new HashMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a aVar = new a();
                if (aVar.a(next, jSONObject.getJSONObject(next))) {
                    this.f5586a.put(next, aVar);
                }
            }
            return this.f5586a.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
