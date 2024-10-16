package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.drive.events.OpenFileCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class be extends UnregisterListenerMethod<zzaw, OpenFileCallback> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzg f3898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(zzch zzchVar, ListenerHolder.ListenerKey listenerKey, zzg zzgVar) {
        super(listenerKey);
        this.f3898a = zzgVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(Boolean.valueOf(this.f3898a.cancel()));
    }
}
