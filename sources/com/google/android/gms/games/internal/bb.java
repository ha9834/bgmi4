package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class bb<T> extends zze.be<T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zze.w f1662a;
    private final /* synthetic */ DataHolder b;
    private final /* synthetic */ ArrayList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(zze.w wVar, DataHolder dataHolder, ArrayList arrayList) {
        super(null);
        this.f1662a = wVar;
        this.b = dataHolder;
        this.c = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        Room b;
        zze.w wVar = this.f1662a;
        b = zze.b(this.b);
        wVar.a(t, b, this.c);
    }
}
