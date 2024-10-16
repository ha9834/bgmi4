package com.ihoc.mgpa.h;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private n f5598a;
    private ServiceConnection b = new k(this);

    public l(n nVar) {
        this.f5598a = nVar;
    }

    public void a(Context context) {
        String str;
        String str2;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (context.bindService(intent, this.b, 1)) {
                str = "TGPA_MID";
                str2 = "bind Lenovo service success!";
            } else {
                str = "TGPA_MID";
                str2 = "bind Lenovo service failed!";
            }
            com.ihoc.mgpa.n.m.a(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA_MID", "bind Lenovo service exception. ");
        }
    }
}
