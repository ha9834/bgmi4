package com.ihoc.mgpa.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private n f5589a;
    private ServiceConnection b = new a(this);

    public b(n nVar) {
        this.f5589a = nVar;
    }

    public void a(Context context) {
        String str;
        String str2;
        try {
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            if (context.bindService(intent2, this.b, 1)) {
                str = "TGPA_MID";
                str2 = "bind ASUS service success!";
            } else {
                str = "TGPA_MID";
                str2 = "bind ASUS service failed!";
            }
            com.ihoc.mgpa.n.m.a(str, str2);
        } catch (Exception e) {
            com.ihoc.mgpa.n.m.a("TGPA_MID", "bind ASUS service exception. ");
            e.printStackTrace();
        }
    }
}
