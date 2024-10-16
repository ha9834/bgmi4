package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class p extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5148a = com.google.android.gms.internal.gtm.zza.CUSTOM_VAR.toString();
    private static final String b = zzb.NAME.toString();
    private static final String c = zzb.DEFAULT_VALUE.toString();
    private final DataLayer d;

    public p(DataLayer dataLayer) {
        super(f5148a, b);
        this.d = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        Object obj = this.d.get(zzgj.zzc(map.get(b)));
        if (obj == null) {
            zzl zzlVar = map.get(c);
            return zzlVar != null ? zzlVar : zzgj.zzkc();
        }
        return zzgj.zzi(obj);
    }
}
