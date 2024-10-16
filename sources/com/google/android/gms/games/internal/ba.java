package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class ba<T> extends zze.be<T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zze.x f1661a;
    private final /* synthetic */ DataHolder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(zze.x xVar, DataHolder dataHolder) {
        super(null);
        this.f1661a = xVar;
        this.b = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        Room b;
        zze.x xVar = this.f1661a;
        b = zze.b(this.b);
        xVar.a(t, b);
    }
}
