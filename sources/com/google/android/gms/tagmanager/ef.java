package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ef extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5136a = com.google.android.gms.internal.gtm.zza.APP_VERSION_NAME.toString();
    private final Context b;

    public ef(Context context) {
        super(f5136a, new String[0]);
        this.b = context;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        try {
            return zzgj.zzi(this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            String packageName = this.b.getPackageName();
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 25 + String.valueOf(message).length());
            sb.append("Package name ");
            sb.append(packageName);
            sb.append(" not found. ");
            sb.append(message);
            zzdi.zzav(sb.toString());
            return zzgj.zzkc();
        }
    }
}
