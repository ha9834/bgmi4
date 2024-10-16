package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class ahd extends ahj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ aha f1875a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private ahd(aha ahaVar) {
        super(ahaVar, null);
        this.f1875a = ahaVar;
    }

    @Override // com.google.android.gms.internal.ads.ahj, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new ahc(this.f1875a, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ahd(aha ahaVar, ahb ahbVar) {
        this(ahaVar);
    }
}
