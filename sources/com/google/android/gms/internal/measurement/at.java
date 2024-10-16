package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes2.dex */
final class at extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzca f4478a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(zzca zzcaVar, Handler handler) {
        super(null);
        this.f4478a = zzcaVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.f4478a.zzrf();
    }
}
