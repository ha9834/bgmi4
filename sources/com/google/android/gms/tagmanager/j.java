package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class j extends dp {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5144a = com.google.android.gms.internal.gtm.zza.CONTAINS.toString();

    public j() {
        super(f5144a);
    }

    @Override // com.google.android.gms.tagmanager.dp
    protected final boolean a(String str, String str2, Map<String, zzl> map) {
        return str.contains(str2);
    }
}
