package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class s extends TaskApiCall<zzaw, TransferPreferences> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s(zzbb zzbbVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<TransferPreferences> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zzb(new zzhg(taskCompletionSource));
    }
}
