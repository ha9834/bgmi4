package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zze;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class az<T> extends zze.be<T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zze.q f1660a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(zze.q qVar) {
        super(null);
        this.f1660a = qVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        this.f1660a.a(t);
    }
}
