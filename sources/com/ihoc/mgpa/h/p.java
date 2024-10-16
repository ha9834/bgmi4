package com.ihoc.mgpa.h;

import android.content.Context;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.tdatamaster.tdm.device.DeviceInfoName;

/* loaded from: classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static String f5601a = "-10";

    public static String b() {
        return !com.ihoc.mgpa.i.f.qa() ? "-13" : f5601a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str = f5601a;
        if (str != null && str.length() > 4) {
            com.ihoc.mgpa.n.o.b(DeviceInfoName.OAID_STRING, f5601a);
            com.ihoc.mgpa.i.l.a().a(DeviceInfoName.OAID_STRING, f5601a);
            return;
        }
        String a2 = com.ihoc.mgpa.n.o.a(DeviceInfoName.OAID_STRING, null);
        com.ihoc.mgpa.i.l a3 = com.ihoc.mgpa.i.l.a();
        if (a2 == null) {
            a2 = "-11";
        }
        a3.a(DeviceInfoName.OAID_STRING, a2);
    }

    public void a() {
        String a2;
        com.ihoc.mgpa.n.m.a("TGPA_MID", "start to get vendor oaid.");
        Context a3 = com.ihoc.mgpa.n.a.a();
        if (a3 == null) {
            Log.e("TGPA_MID", "OAID get failed, context is null.");
            return;
        }
        o oVar = new o(this);
        String lowerCase = com.ihoc.mgpa.n.f.c().toLowerCase();
        char c = 65535;
        try {
            switch (lowerCase.hashCode()) {
                case -1619859642:
                    if (lowerCase.equals("blackshark")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1320380160:
                    if (lowerCase.equals("oneplus")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1206476313:
                    if (lowerCase.equals(Constants.REFERRER_API_HUAWEI)) {
                        c = 5;
                        break;
                    }
                    break;
                case -1106355917:
                    if (lowerCase.equals("lenovo")) {
                        c = 7;
                        break;
                    }
                    break;
                case -759499589:
                    if (lowerCase.equals("xiaomi")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3003984:
                    if (lowerCase.equals("asus")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3418016:
                    if (lowerCase.equals("oppo")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3620012:
                    if (lowerCase.equals("vivo")) {
                        c = 2;
                        break;
                    }
                    break;
                case 99462250:
                    if (lowerCase.equals("honor")) {
                        c = 6;
                        break;
                    }
                    break;
                case 103777484:
                    if (lowerCase.equals("meizu")) {
                        c = 3;
                        break;
                    }
                    break;
                case 105170387:
                    if (lowerCase.equals("nubia")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1864941562:
                    if (lowerCase.equals("samsung")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    a2 = com.ihoc.mgpa.d.a.a(1);
                    break;
                case 2:
                    a2 = com.ihoc.mgpa.d.a.a(2);
                    break;
                case 3:
                    a2 = com.ihoc.mgpa.d.a.a(3);
                    break;
                case 4:
                    new b(oVar).a(a3);
                    return;
                case 5:
                case 6:
                    new h(oVar).a(a3);
                    return;
                case 7:
                    new l(oVar).a(a3);
                    return;
                case '\b':
                case '\t':
                    new s(oVar).a(a3);
                    return;
                case '\n':
                    new v(oVar).a(a3);
                    return;
                case 11:
                    new q(oVar).a(a3);
                    return;
                default:
                    new f(oVar).a(a3);
                    return;
            }
            f5601a = a2;
            c();
        } catch (Exception e) {
            Log.e("TGPA_MID", "OAID get exception, ple call sdk provider.");
            e.printStackTrace();
        }
    }
}
