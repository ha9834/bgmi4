package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class dp extends zzef {
    public dp(String str) {
        super(str);
    }

    protected abstract boolean a(String str, String str2, Map<String, zzl> map);

    @Override // com.google.android.gms.tagmanager.zzef
    protected final boolean a(zzl zzlVar, zzl zzlVar2, Map<String, zzl> map) {
        String zzc = zzgj.zzc(zzlVar);
        String zzc2 = zzgj.zzc(zzlVar2);
        if (zzc == zzgj.zzkb() || zzc2 == zzgj.zzkb()) {
            return false;
        }
        return a(zzc, zzc2, map);
    }
}
