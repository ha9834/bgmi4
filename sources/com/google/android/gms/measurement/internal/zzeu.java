package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzf;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzeu {

    /* renamed from: a, reason: collision with root package name */
    final zzfj f4936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeu(zzfj zzfjVar) {
        this.f4936a = zzfjVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            this.f4936a.zzab().zzgq().zzao("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.f4936a.zzaa().zzo();
        if (!a()) {
            this.f4936a.zzab().zzgq().zzao("Install Referrer Reporter is not available");
            return;
        }
        this.f4936a.zzab().zzgq().zzao("Install Referrer Reporter is initializing");
        zzex zzexVar = new zzex(this, str);
        this.f4936a.zzaa().zzo();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f4936a.getContext().getPackageManager();
        if (packageManager == null) {
            this.f4936a.zzab().zzgn().zzao("Failed to obtain Package Manager to verify binding conditions");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str2 = resolveInfo.serviceInfo.packageName;
                if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str2) && a()) {
                    try {
                        this.f4936a.zzab().zzgq().zza("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.f4936a.getContext(), new Intent(intent), zzexVar, 1) ? "available" : "not available");
                        return;
                    } catch (Exception e) {
                        this.f4936a.zzab().zzgk().zza("Exception occurred while binding to Install Referrer Service", e.getMessage());
                        return;
                    }
                }
                this.f4936a.zzab().zzgq().zzao("Play Store missing or incompatible. Version 8.3.73 or later required");
                return;
            }
            return;
        }
        this.f4936a.zzab().zzgq().zzao("Play Service for fetching Install Referrer is unavailable on device");
    }

    @VisibleForTesting
    private final boolean a() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.f4936a.getContext());
            if (packageManager != null) {
                return packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f4936a.zzab().zzgq().zzao("Failed to retrieve Package Manager to check Play Store compatibility");
            return false;
        } catch (Exception e) {
            this.f4936a.zzab().zzgq().zza("Failed to retrieve Play Store version", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Bundle a(String str, zzf zzfVar) {
        this.f4936a.zzaa().zzo();
        if (zzfVar == null) {
            this.f4936a.zzab().zzgn().zzao("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle zza = zzfVar.zza(bundle);
            if (zza != null) {
                return zza;
            }
            this.f4936a.zzab().zzgk().zzao("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.f4936a.zzab().zzgk().zza("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }
}
