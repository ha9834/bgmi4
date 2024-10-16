package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class dg extends dm {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ dd f4346a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private dg(dd ddVar) {
        super(ddVar, null);
        this.f4346a = ddVar;
    }

    @Override // com.google.android.gms.internal.gtm.dm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new df(this.f4346a, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dg(dd ddVar, de deVar) {
        this(ddVar);
    }
}
