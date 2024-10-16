package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class at extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5080a = com.google.android.gms.internal.gtm.zza.INSTALL_REFERRER.toString();
    private static final String b = zzb.COMPONENT.toString();
    private final Context c;

    public at(Context context) {
        super(f5080a, new String[0]);
        this.c = context;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String zze = zzcw.zze(this.c, map.get(b) != null ? zzgj.zzc(map.get(b)) : null);
        return zze != null ? zzgj.zzi(zze) : zzgj.zzkc();
    }
}
