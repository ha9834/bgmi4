package com.ihoc.mgpa.h;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;

/* loaded from: classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private n f5607a;
    private w b = null;
    private ServiceConnection c = new u(this);

    public v(n nVar) {
        this.f5607a = nVar;
    }

    public void a(Context context) {
        String str;
        String str2;
        try {
            context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (context.bindService(intent, this.c, 1)) {
                str = "TGPA_MID";
                str2 = "bind Sumsung service ok.";
            } else {
                str = "TGPA_MID";
                str2 = "bind Sumsung service failed.";
            }
            Log.d(str, str2);
        } catch (Exception e) {
            com.ihoc.mgpa.n.m.a("TGPA_MID", "bind Sumsung service exception. ");
            e.printStackTrace();
        }
    }
}
