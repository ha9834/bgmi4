package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
final class q<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f4105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Object obj) {
        this.f4105a = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        return new r(this);
    }
}
