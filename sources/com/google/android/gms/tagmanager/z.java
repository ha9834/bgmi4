package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class z extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5158a = com.google.android.gms.internal.gtm.zza.DEVICE_NAME.toString();

    public z() {
        super(f5158a, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (!str2.startsWith(str) && !str.equals("unknown")) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            str2 = sb.toString();
        }
        return zzgj.zzi(str2);
    }
}
