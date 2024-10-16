package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzhx extends zzhw {

    /* renamed from: a, reason: collision with root package name */
    private final Map<UUID, byte[]> f3650a;

    public zzhx(String str) {
        super(str);
        this.f3650a = new HashMap();
    }

    public final void putAll(Map<UUID, byte[]> map) {
        this.f3650a.putAll(map);
    }
}
