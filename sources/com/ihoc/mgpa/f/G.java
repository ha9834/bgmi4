package com.ihoc.mgpa.f;

import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class G {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f5520a = new D();
    private static HashMap<String, String> b = new E();

    public static String a(int i, String str, com.ihoc.mgpa.j.A a2) {
        StringBuilder sb;
        String str2;
        int b2;
        if (!a(i, str)) {
            com.ihoc.mgpa.n.m.a("TGPA", "Game data need't send to vendor server. key: " + i + " , value: " + str);
            return "";
        }
        if (i == com.ihoc.mgpa.a.e.SCENE.a()) {
            String a3 = C0237c.a(str, a2);
            com.ihoc.mgpa.n.m.a("TGPA", "Game data scene need transform, last: " + str + " , new: " + a3);
            com.ihoc.mgpa.i.f.g(a3);
            str = a3;
        }
        String a4 = a(String.valueOf(i), a2);
        if (a4 == null) {
            return "";
        }
        if (a2 == com.ihoc.mgpa.j.A.HUAWEI && (b2 = com.ihoc.mgpa.a.d.b(a4)) >= 0) {
            return "{\"" + a4 + "\":\"" + str + "\", \"MessageType\":" + b2 + "}";
        }
        if (b(i, str, a2)) {
            sb = new StringBuilder();
            sb.append("{\"");
            sb.append(a4);
            sb.append("\":\"");
            sb.append(str);
            str2 = "\"}";
        } else {
            sb = new StringBuilder();
            sb.append("{\"");
            sb.append(a4);
            sb.append("\":");
            sb.append(str);
            str2 = "}";
        }
        sb.append(str2);
        return sb.toString();
    }

    private static String a(String str, com.ihoc.mgpa.j.A a2) {
        HashMap<String, String> hashMap;
        switch (F.f5519a[a2.ordinal()]) {
            case 1:
                return com.ihoc.mgpa.a.d.a(str);
            case 2:
                hashMap = b;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                hashMap = f5520a;
                break;
            case 7:
            case 8:
            case 9:
            default:
                return str;
        }
        return a(str, hashMap);
    }

    private static String a(String str, HashMap<String, String> hashMap) {
        if (!hashMap.containsKey(str)) {
            return str;
        }
        String str2 = hashMap.get(str);
        if (str2 == null) {
            return null;
        }
        return str2;
    }

    public static String a(HashMap<String, String> hashMap, com.ihoc.mgpa.j.A a2) {
        int parseInt;
        String str;
        StringBuilder sb;
        String str2;
        StringBuilder sb2 = new StringBuilder("{");
        int i = -1;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            try {
                parseInt = Integer.parseInt(key);
            } catch (Exception unused) {
                com.ihoc.mgpa.n.m.a("TGPA", "game data for vendor transform exception. key: " + String.valueOf(key));
            }
            if (a(parseInt, value)) {
                if (parseInt == com.ihoc.mgpa.a.e.SCENE.a()) {
                    String a3 = C0237c.a(value, a2);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Game data scene need transform, last: ");
                    sb3.append(value);
                    sb3.append(" , new: ");
                    sb3.append(a3);
                    com.ihoc.mgpa.n.m.a("TGPA", sb3.toString());
                    com.ihoc.mgpa.i.f.g(a3);
                    value = a3;
                }
                String a4 = a(String.valueOf(parseInt), a2);
                if (a4 == null) {
                    str = "TGPA";
                    sb = new StringBuilder();
                    sb.append("Game data key do not found for vendor key. key: ");
                    sb.append(parseInt);
                    sb.append(" , value: ");
                } else {
                    if (b(parseInt, value, a2)) {
                        sb2.append("\"");
                        sb2.append(a4);
                        sb2.append("\":\"");
                        sb2.append(value);
                        str2 = "\",";
                    } else {
                        sb2.append("\"");
                        sb2.append(a4);
                        sb2.append("\":");
                        sb2.append(value);
                        str2 = ",";
                    }
                    sb2.append(str2);
                    i = com.ihoc.mgpa.a.d.b(a4);
                }
            } else {
                str = "TGPA";
                sb = new StringBuilder();
                sb.append("Game data need't send to vendor server. key: ");
                sb.append(parseInt);
                sb.append(" , value: ");
            }
            sb.append(value);
            com.ihoc.mgpa.n.m.a(str, sb.toString());
        }
        if (a2 == com.ihoc.mgpa.j.A.HUAWEI && i >= 0) {
            sb2.append("\"MessageType\":");
            sb2.append(i);
        }
        if (sb2.charAt(sb2.length() - 1) == ',') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        sb2.append("}");
        return sb2.toString();
    }

    public static void a() {
        com.ihoc.mgpa.i.f.b(1);
        com.ihoc.mgpa.i.f.c(1);
        com.ihoc.mgpa.i.f.d(1);
        com.ihoc.mgpa.i.f.e(1);
        com.ihoc.mgpa.i.f.f(1);
        com.ihoc.mgpa.i.f.g(1);
        com.ihoc.mgpa.i.f.h(1);
        com.ihoc.mgpa.i.f.i(1);
    }

    public static void a(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("VendorSpecialTool: strategy json: ");
            sb.append(String.valueOf(str));
            com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
            a(new JSONObject(str));
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "VendorSpecialTool:checkVendorSupportStrategy: parse json exception");
        }
    }

    public static void a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("IsSupport")) {
                jSONObject.getString(JsonDocumentFields.VERSION);
                if (jSONObject.getInt("IsSupport") == 1) {
                    if (jSONObject.has("SupportFunc")) {
                        String string = jSONObject.getString("SupportFunc");
                        if (!com.ihoc.mgpa.n.p.b(string)) {
                            c(string);
                            b(jSONObject.getString("SupportScene"));
                        }
                    }
                    a();
                    b(jSONObject.getString("SupportScene"));
                } else {
                    a();
                }
            }
            if (jSONObject.has("5")) {
                c(jSONObject.getString("5"));
                if (jSONObject.has(Constants.VIA_SHARE_TYPE_INFO)) {
                    b(jSONObject.getString(Constants.VIA_SHARE_TYPE_INFO));
                }
            }
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "VendorSpecialTool:checkVendorSupportStrategy: exception.");
        }
        com.ihoc.mgpa.i.f.ta();
    }

    private static boolean a(int i, String str) {
        if (i == com.ihoc.mgpa.a.e.SCENE.a() && !com.ihoc.mgpa.i.f.da()) {
            return false;
        }
        if (i == com.ihoc.mgpa.a.e.THREAD_TID.a() && !com.ihoc.mgpa.i.f.ja()) {
            return false;
        }
        if ((i == com.ihoc.mgpa.a.e.LIGHT_THREAD_TID.a() && !com.ihoc.mgpa.i.f.S()) || i == com.ihoc.mgpa.a.e.RESET_THREAD_TID.a()) {
            return false;
        }
        if (i == com.ihoc.mgpa.a.e.USERS_COUNT.a() && !com.ihoc.mgpa.i.f.pa()) {
            return false;
        }
        if (i == com.ihoc.mgpa.a.e.NET_LATENCY.a() && !com.ihoc.mgpa.i.f.T()) {
            return false;
        }
        if (i == com.ihoc.mgpa.a.e.CPU_LEVEL.a() && !com.ihoc.mgpa.i.f.K()) {
            return false;
        }
        if ((i == com.ihoc.mgpa.a.e.GPU_LEVEL.a() && !com.ihoc.mgpa.i.f.Q()) || i == com.ihoc.mgpa.a.e.OPEN_ID.a()) {
            return false;
        }
        if (com.ihoc.mgpa.g.o.b().c.d == null || !com.ihoc.mgpa.g.o.b().c.d.a(String.valueOf(i), str)) {
            return true;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "VendorSpecialTool:checkKeyNeedSend: key value is limited. ");
        return false;
    }

    public static void b(String str) {
        for (String str2 : str.split(",")) {
            com.ihoc.mgpa.i.f.c(str2);
        }
    }

    private static boolean b(int i, String str, com.ihoc.mgpa.j.A a2) {
        switch (F.f5519a[a2.ordinal()]) {
            case 1:
            case 2:
            case 7:
            case 8:
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return (i == com.ihoc.mgpa.a.e.FPS.a() || i == com.ihoc.mgpa.a.e.SCENE.a() || i == com.ihoc.mgpa.a.e.THREAD_TID.a()) ? false : true;
            default:
                return true;
        }
    }

    public static void c(String str) {
        char c;
        for (String str2 : str.split(",")) {
            switch (str2.hashCode()) {
                case 49:
                    if (str2.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str2.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str2.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
                case 52:
                    if (str2.equals("4")) {
                        c = 3;
                        break;
                    }
                    break;
                case 53:
                    if (str2.equals("5")) {
                        c = 4;
                        break;
                    }
                    break;
                case 54:
                    if (str2.equals(Constants.VIA_SHARE_TYPE_INFO)) {
                        c = 5;
                        break;
                    }
                    break;
                case 55:
                    if (str2.equals("7")) {
                        c = 6;
                        break;
                    }
                    break;
                case 56:
                    if (str2.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        c = 7;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    com.ihoc.mgpa.i.f.b(1);
                    break;
                case 1:
                    com.ihoc.mgpa.i.f.c(1);
                    break;
                case 2:
                    com.ihoc.mgpa.i.f.d(1);
                    break;
                case 3:
                    com.ihoc.mgpa.i.f.e(1);
                    break;
                case 4:
                    com.ihoc.mgpa.i.f.f(1);
                    break;
                case 5:
                    com.ihoc.mgpa.i.f.g(1);
                    break;
                case 6:
                    com.ihoc.mgpa.i.f.h(1);
                    break;
                case 7:
                    com.ihoc.mgpa.i.f.i(1);
                    break;
            }
        }
    }

    public static String d(String str) {
        String a2 = C0237c.a(str);
        if (a2 == null) {
            com.ihoc.mgpa.n.m.a("TGPA", "vendor callback: ssp callback setting value is null, value: " + String.valueOf(str));
            return null;
        }
        return (("{\"" + com.ihoc.mgpa.a.h.SPA_PERF_CONFIG.a() + "\":\"" + a2 + "\",") + "\"" + com.ihoc.mgpa.a.h.SPA_PERF_LEVEL.a() + "\":\"" + str + "\"") + "}";
    }
}
