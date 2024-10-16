package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class aj extends br {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5073a = com.google.android.gms.internal.gtm.zza.GREATER_THAN.toString();

    public aj() {
        super(f5073a);
    }

    @Override // com.google.android.gms.tagmanager.br
    protected final boolean a(zzgi zzgiVar, zzgi zzgiVar2, Map<String, zzl> map) {
        return zzgiVar.compareTo(zzgiVar2) > 0;
    }
}
