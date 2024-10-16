package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public class zzhb<T> extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private TaskCompletionSource<T> f3993a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhb(TaskCompletionSource<T> taskCompletionSource) {
        this.f3993a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.f3993a.setException(new ApiException(status));
    }

    public final TaskCompletionSource<T> zzap() {
        return this.f3993a;
    }
}
