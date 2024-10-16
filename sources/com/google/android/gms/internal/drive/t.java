package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class t extends TaskApiCall<zzaw, Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ TransferPreferences f3943a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(zzbb zzbbVar, TransferPreferences transferPreferences) {
        this.f3943a = transferPreferences;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgo(new zzei(this.f3943a)), new zzhl(taskCompletionSource));
    }
}
