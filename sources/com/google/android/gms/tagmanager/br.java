package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class br extends zzef {
    public br(String str) {
        super(str);
    }

    protected abstract boolean a(zzgi zzgiVar, zzgi zzgiVar2, Map<String, zzl> map);

    @Override // com.google.android.gms.tagmanager.zzef
    protected final boolean a(zzl zzlVar, zzl zzlVar2, Map<String, zzl> map) {
        zzgi zzd = zzgj.zzd(zzlVar);
        zzgi zzd2 = zzgj.zzd(zzlVar2);
        if (zzd == zzgj.zzka() || zzd2 == zzgj.zzka()) {
            return false;
        }
        return a(zzd, zzd2, map);
    }
}
