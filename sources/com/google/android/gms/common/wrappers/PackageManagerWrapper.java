package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* loaded from: classes.dex */
public class PackageManagerWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1517a;

    public PackageManagerWrapper(Context context) {
        this.f1517a = context;
    }

    @KeepForSdk
    public ApplicationInfo getApplicationInfo(String str, int i) throws PackageManager.NameNotFoundException {
        return this.f1517a.getPackageManager().getApplicationInfo(str, i);
    }

    @KeepForSdk
    public PackageInfo getPackageInfo(String str, int i) throws PackageManager.NameNotFoundException {
        return this.f1517a.getPackageManager().getPackageInfo(str, i);
    }

    public final PackageInfo zza(String str, int i, int i2) throws PackageManager.NameNotFoundException {
        return this.f1517a.getPackageManager().getPackageInfo(str, 64);
    }

    public final String[] getPackagesForUid(int i) {
        return this.f1517a.getPackageManager().getPackagesForUid(i);
    }

    @TargetApi(19)
    public final boolean zzb(int i, String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            try {
                ((AppOpsManager) this.f1517a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f1517a.getPackageManager().getPackagesForUid(i);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @KeepForSdk
    public int checkCallingOrSelfPermission(String str) {
        return this.f1517a.checkCallingOrSelfPermission(str);
    }

    @KeepForSdk
    public int checkPermission(String str, String str2) {
        return this.f1517a.getPackageManager().checkPermission(str, str2);
    }

    @KeepForSdk
    public CharSequence getApplicationLabel(String str) throws PackageManager.NameNotFoundException {
        return this.f1517a.getPackageManager().getApplicationLabel(this.f1517a.getPackageManager().getApplicationInfo(str, 0));
    }

    @KeepForSdk
    public boolean isCallerInstantApp() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp(this.f1517a);
        }
        if (!PlatformVersion.isAtLeastO() || (nameForUid = this.f1517a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f1517a.getPackageManager().isInstantApp(nameForUid);
    }
}
