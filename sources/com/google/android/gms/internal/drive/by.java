package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.events.OpenFileCallback;

/* loaded from: classes2.dex */
final class by implements ListenerHolder.Notifier<OpenFileCallback> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bq f3916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bu buVar, bq bqVar) {
        this.f3916a = bqVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(OpenFileCallback openFileCallback) {
        this.f3916a.a(openFileCallback);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
