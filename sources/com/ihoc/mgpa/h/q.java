package com.ihoc.mgpa.h;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private Uri f5602a = Uri.parse("content://cn.nubia.identity/identity");
    private n b;

    public q(n nVar) {
        this.b = nVar;
    }

    public void a(Context context) {
        ContentProviderClient acquireUnstableContentProviderClient;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 17 && (acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(this.f5602a)) != null) {
                Bundle call = acquireUnstableContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireUnstableContentProviderClient.close();
                } else {
                    acquireUnstableContentProviderClient.release();
                }
                if (call != null && call.getInt("code", -1) == 0) {
                    str = call.getString("id");
                }
            }
        } catch (Exception e) {
            Log.d("TGPA_MID", "MSA Nubia get oaid exception.");
            e.printStackTrace();
        }
        n nVar = this.b;
        if (nVar != null) {
            nVar.a(str);
        } else {
            Log.d("TGPA_MID", "MSA oaid callback is null.");
        }
    }
}
