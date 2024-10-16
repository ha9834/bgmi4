package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class DataHolderNotifier<L> implements ListenerHolder.Notifier<L> {

    /* renamed from: a, reason: collision with root package name */
    private final DataHolder f1308a;

    @KeepForSdk
    protected abstract void a(L l, DataHolder dataHolder);

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    @KeepForSdk
    public final void notifyListener(L l) {
        a(l, this.f1308a);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    @KeepForSdk
    public void onNotifyListenerFailed() {
        DataHolder dataHolder = this.f1308a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
