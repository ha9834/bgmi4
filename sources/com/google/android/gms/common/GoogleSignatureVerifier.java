package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.CheckReturnValue;

@ShowFirstParty
@KeepForSdk
@CheckReturnValue
/* loaded from: classes.dex */
public class GoogleSignatureVerifier {

    /* renamed from: a, reason: collision with root package name */
    private static GoogleSignatureVerifier f1283a;
    private final Context b;
    private volatile String c;

    private GoogleSignatureVerifier(Context context) {
        this.b = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (f1283a == null) {
                b.a(context);
                f1283a = new GoogleSignatureVerifier(context);
            }
        }
        return f1283a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i) {
        j a2;
        String[] packagesForUid = Wrappers.packageManager(this.b).getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            a2 = j.a("no pkgs");
        } else {
            a2 = null;
            for (String str : packagesForUid) {
                a2 = a(str, i);
                if (a2.f1481a) {
                    break;
                }
            }
        }
        a2.c();
        return a2.f1481a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(String str) {
        j a2 = a(str);
        a2.c();
        return a2.f1481a;
    }

    public static boolean zza(PackageInfo packageInfo, boolean z) {
        d a2;
        if (packageInfo != null && packageInfo.signatures != null) {
            if (z) {
                a2 = a(packageInfo, g.f1422a);
            } else {
                a2 = a(packageInfo, g.f1422a[0]);
            }
            if (a2 != null) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.b)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    private final j a(String str, int i) {
        try {
            PackageInfo zza = Wrappers.packageManager(this.b).zza(str, 64, i);
            boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.b);
            if (zza == null) {
                return j.a("null pkg");
            }
            if (zza.signatures.length != 1) {
                return j.a("single cert required");
            }
            e eVar = new e(zza.signatures[0].toByteArray());
            String str2 = zza.packageName;
            j a2 = b.a(str2, eVar, honorsDebugCertificates, false);
            return (!a2.f1481a || zza.applicationInfo == null || (zza.applicationInfo.flags & 2) == 0 || !b.a(str2, eVar, false, true).f1481a) ? a2 : j.a("debuggable release cert app rejected");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return j.a(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    private final j a(String str) {
        j a2;
        if (str == null) {
            return j.a("null pkg");
        }
        if (str.equals(this.c)) {
            return j.a();
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(this.b).getPackageInfo(str, 64);
            boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.b);
            if (packageInfo == null) {
                a2 = j.a("null pkg");
            } else if (packageInfo.signatures.length != 1) {
                a2 = j.a("single cert required");
            } else {
                e eVar = new e(packageInfo.signatures[0].toByteArray());
                String str2 = packageInfo.packageName;
                j a3 = b.a(str2, eVar, honorsDebugCertificates, false);
                a2 = (!a3.f1481a || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !b.a(str2, eVar, false, true).f1481a) ? a3 : j.a("debuggable release cert app rejected");
            }
            if (a2.f1481a) {
                this.c = str;
            }
            return a2;
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return j.a(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    private static d a(PackageInfo packageInfo, d... dVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        e eVar = new e(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < dVarArr.length; i++) {
            if (dVarArr[i].equals(eVar)) {
                return dVarArr[i];
            }
        }
        return null;
    }
}
