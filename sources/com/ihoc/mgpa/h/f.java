package com.ihoc.mgpa.h;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private n f5593a;
    private ServiceConnection b = new e(this);

    public f(n nVar) {
        this.f5593a = nVar;
    }

    private static void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (context.startService(intent) == null) {
                Log.d("TGPA_MID", "start msa kl service error");
            }
        } catch (Throwable th) {
            Log.d("TGPA_MID", "start msa kl service exception", th);
        }
    }

    private static boolean b(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.mdid.msa", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public void a(Context context) {
        String str;
        String str2;
        if (b(context)) {
            String c = com.ihoc.mgpa.n.a.c();
            a(context, c);
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", c);
            if (context.bindService(intent, this.b, 1)) {
                str = "TGPA_MID";
                str2 = "Common ID Service bind ok!";
            } else {
                str = "TGPA_MID";
                str2 = "Common ID Service bind failed!";
            }
        } else {
            str = "TGPA_MID";
            str2 = "Common ID Service not supported";
        }
        Log.d(str, str2);
    }
}
