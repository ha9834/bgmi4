package com.tencent.mid.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    static a f6272a;
    private static d d = Util.getLogger();
    private static JSONObject e = null;
    Integer b;
    String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f6273a;
        String b;
        DisplayMetrics c;
        int d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        int l;
        String m;
        Context n;
        private String o;
        private String p;
        private String q;
        private String r;
        private String s;

        private a(Context context) {
            this.b = String.valueOf(4.07f);
            this.d = Build.VERSION.SDK_INT;
            this.e = Build.MODEL;
            this.f = Build.MANUFACTURER;
            this.g = Locale.getDefault().getLanguage();
            this.l = 0;
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = null;
            this.r = null;
            this.s = null;
            this.n = context;
            this.c = DeviceInfos.getDisplayMetrics(context);
            this.f6273a = h.a(context);
            this.i = CustomDeviceInfos.getSimOperator(context);
            this.j = TimeZone.getDefault().getID();
            this.l = DeviceInfos.hasRootAccess(context);
            this.k = DeviceInfos.getExternalStorageInfo(context);
            this.m = context.getPackageName();
            if (this.d >= 14) {
                this.o = DeviceInfos.getSensorsString(context);
            }
            this.p = DeviceInfos.getCpuInfo(context).toString();
            this.q = DeviceInfos.getSystemMemory(context);
            this.r = DeviceInfos.getRomMemory();
            this.s = CustomDeviceInfos.getIp(context);
        }

        void a(JSONObject jSONObject) {
            jSONObject.put("sr", this.c.widthPixels + "*" + this.c.heightPixels);
            Util.jsonPut(jSONObject, "av", this.f6273a);
            Util.jsonPut(jSONObject, "ch", this.h);
            Util.jsonPut(jSONObject, "mf", this.f);
            Util.jsonPut(jSONObject, "sv", this.b);
            Util.jsonPut(jSONObject, "ov", Integer.toString(this.d));
            jSONObject.put("os", 1);
            Util.jsonPut(jSONObject, "op", this.i);
            Util.jsonPut(jSONObject, "lg", this.g);
            Util.jsonPut(jSONObject, "md", this.e);
            Util.jsonPut(jSONObject, "tz", this.j);
            int i = this.l;
            if (i != 0) {
                jSONObject.put("jb", i);
            }
            Util.jsonPut(jSONObject, "sd", this.k);
            Util.jsonPut(jSONObject, "apn", this.m);
            if (Util.isNetworkAvailable(this.n) && DeviceInfos.isWifiNet(this.n)) {
                JSONObject jSONObject2 = new JSONObject();
                Util.jsonPut(jSONObject2, "bs", CustomDeviceInfos.getWiFiBBSID(this.n));
                Util.jsonPut(jSONObject2, "ss", CustomDeviceInfos.getWiFiSSID(this.n));
                if (jSONObject2.length() > 0) {
                    Util.jsonPut(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray wifiTopN = CustomDeviceInfos.getWifiTopN(this.n, 10);
            if (wifiTopN != null && wifiTopN.length() > 0) {
                Util.jsonPut(jSONObject, "wflist", wifiTopN.toString());
            }
            JSONArray sensorsJson = DeviceInfos.getSensorsJson(this.n);
            if (sensorsJson != null && sensorsJson.length() > 0) {
                Util.jsonPut(jSONObject, "sslist", sensorsJson.toString());
            }
            Util.jsonPut(jSONObject, "sen", this.o);
            Util.jsonPut(jSONObject, "cpu", this.p);
            Util.jsonPut(jSONObject, "ram", this.q);
            Util.jsonPut(jSONObject, "rom", this.r);
            Util.jsonPut(jSONObject, "ciip", this.s);
        }
    }

    static synchronized a a(Context context) {
        a aVar;
        synchronized (c.class) {
            if (f6272a == null) {
                f6272a = new a(context.getApplicationContext());
            }
            aVar = f6272a;
        }
        return aVar;
    }

    public c(Context context) {
        this.b = null;
        this.c = null;
        try {
            a(context);
            this.b = DeviceInfos.getTelephonyNetworkType(context.getApplicationContext());
            this.c = DeviceInfos.getLinkedWay(context);
        } catch (Throwable th) {
            d.f(th);
        }
    }

    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f6272a != null) {
                f6272a.a(jSONObject2);
            }
            Util.jsonPut(jSONObject2, "cn", this.c);
            if (this.b != null) {
                jSONObject2.put("tn", this.b);
            }
            jSONObject.put("ev", jSONObject2);
            if (e == null || e.length() <= 0) {
                return;
            }
            jSONObject.put("eva", e);
        } catch (Throwable th) {
            d.f(th);
        }
    }
}
