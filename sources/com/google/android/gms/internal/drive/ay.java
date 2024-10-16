package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class ay extends RegisterListenerMethod<zzaw, bs> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveResource f3891a;
    private final /* synthetic */ bs b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(zzch zzchVar, ListenerHolder listenerHolder, DriveResource driveResource, bs bsVar) {
        super(listenerHolder);
        this.f3891a = driveResource;
        this.b = bsVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzj(1, this.f3891a.getDriveId()), bs.a(this.b), (String) null, new zzhl(taskCompletionSource));
    }
}
