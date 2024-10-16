package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.do, reason: invalid class name */
/* loaded from: classes2.dex */
final class Cdo extends dp {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5124a = com.google.android.gms.internal.gtm.zza.STARTS_WITH.toString();

    public Cdo() {
        super(f5124a);
    }

    @Override // com.google.android.gms.tagmanager.dp
    protected final boolean a(String str, String str2, Map<String, zzl> map) {
        return str.startsWith(str2);
    }
}
