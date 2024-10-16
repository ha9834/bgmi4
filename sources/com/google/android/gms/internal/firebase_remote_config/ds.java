package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class ds extends dy {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ dn f4082a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private ds(dn dnVar) {
        super(dnVar, null);
        this.f4082a = dnVar;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new dp(this.f4082a, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ds(dn dnVar, dq dqVar) {
        this(dnVar);
    }
}
