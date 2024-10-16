package com.ihoc.mgpa.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private n f5604a;
    private t b;
    private boolean c;
    private ServiceConnection d = new r(this);

    public s(n nVar) {
        this.f5604a = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        if (!a() || !this.c) {
            return "";
        }
        String str2 = "";
        Signature[] signatureArr = null;
        String packageName = context.getPackageName();
        try {
            signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest == null) {
                    return "";
                }
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | 256).substring(1, 3));
                }
                str2 = sb.toString();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
        }
        return this.b.a(packageName, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        PackageManager packageManager;
        PackageInfo packageInfo;
        try {
            packageManager = com.ihoc.mgpa.n.a.a().getPackageManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (packageManager == null || (packageInfo = packageManager.getPackageInfo("com.heytap.openid", 0)) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28 && packageInfo.getLongVersionCode() >= 1) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 28) {
            return packageInfo.versionCode > 1;
        }
        return false;
    }

    public void a(Context context) {
        String str;
        String str2;
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            this.c = context.bindService(intent, this.d, 1);
            if (this.c) {
                str = "TGPA_MID";
                str2 = "bind OPPO service ok!";
            } else {
                str = "TGPA_MID";
                str2 = "bind OPPO service failed!";
            }
            com.ihoc.mgpa.n.m.a(str, str2);
        } catch (Exception e) {
            com.ihoc.mgpa.n.m.a("TGPA_MID", "bind OPPO service exception. ");
            e.printStackTrace();
        }
    }
}
