package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ed extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5134a = com.google.android.gms.internal.gtm.zza.APP_NAME.toString();
    private final Context b;

    public ed(Context context) {
        super(f5134a, new String[0]);
        this.b = context;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        try {
            PackageManager packageManager = this.b.getPackageManager();
            return zzgj.zzi(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.b.getPackageName(), 0)).toString());
        } catch (PackageManager.NameNotFoundException e) {
            zzdi.zza("App name is not found.", e);
            return zzgj.zzkc();
        }
    }
}
