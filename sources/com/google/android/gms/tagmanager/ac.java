package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class ac extends dp {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5069a = com.google.android.gms.internal.gtm.zza.ENDS_WITH.toString();

    public ac() {
        super(f5069a);
    }

    @Override // com.google.android.gms.tagmanager.dp
    protected final boolean a(String str, String str2, Map<String, zzl> map) {
        return str.endsWith(str2);
    }
}
