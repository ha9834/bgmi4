package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzbm extends dp {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5163a = com.google.android.gms.internal.gtm.zza.EQUALS.toString();

    public zzbm() {
        super(f5163a);
    }

    @Override // com.google.android.gms.tagmanager.dp
    protected final boolean a(String str, String str2, Map<String, zzl> map) {
        return str.equals(str2);
    }
}
