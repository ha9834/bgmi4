package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public abstract class zzef extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5168a = zzb.ARG0.toString();
    private static final String b = zzb.ARG1.toString();

    public zzef(String str) {
        super(str, f5168a, b);
    }

    protected abstract boolean a(zzl zzlVar, zzl zzlVar2, Map<String, zzl> map);

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        Iterator<zzl> it = map.values().iterator();
        do {
            boolean z = false;
            if (!it.hasNext()) {
                zzl zzlVar = map.get(f5168a);
                zzl zzlVar2 = map.get(b);
                if (zzlVar != null && zzlVar2 != null) {
                    z = a(zzlVar, zzlVar2, map);
                }
                return zzgj.zzi(Boolean.valueOf(z));
            }
        } while (it.next() != zzgj.zzkc());
        return zzgj.zzi(false);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ Set zzig() {
        return super.zzig();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ String zzif() {
        return super.zzif();
    }
}
