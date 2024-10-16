package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.OpenFileActivityOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class u extends TaskApiCall<zzaw, IntentSender> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ OpenFileActivityOptions f3944a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(zzbb zzbbVar, OpenFileActivityOptions openFileActivityOptions) {
        this.f3944a = openFileActivityOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<IntentSender> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(((zzeo) zzawVar.getService()).zza(new zzgg(this.f3944a.zzay, this.f3944a.zzaz, this.f3944a.zzbb, this.f3944a.zzbc)));
    }
}
