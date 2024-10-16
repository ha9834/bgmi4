package com.ihoc.mgpa.h;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private n f5595a;
    private ServiceConnection b = new g(this);

    public h(n nVar) {
        this.f5595a = nVar;
    }

    public void a(Context context) {
        String str;
        String str2;
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (context.bindService(intent, this.b, 1)) {
                str = "TGPA_MID";
                str2 = "bind huawei service ok!";
            } else {
                str = "TGPA_MID";
                str2 = "bind huawei service failed!";
            }
            com.ihoc.mgpa.n.m.a(str, str2);
        } catch (Exception e) {
            com.ihoc.mgpa.n.m.a("TGPA_MID", "bind huawei service exception. ");
            e.printStackTrace();
        }
    }
}
