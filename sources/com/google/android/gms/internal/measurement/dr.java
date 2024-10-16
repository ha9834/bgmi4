package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class dr extends dx {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ dq f4521a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private dr(dq dqVar) {
        super(dqVar, null);
        this.f4521a = dqVar;
    }

    @Override // com.google.android.gms.internal.measurement.dx, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new ds(this.f4521a, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dr(dq dqVar, dp dpVar) {
        this(dqVar);
    }
}
