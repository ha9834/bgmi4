package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class az extends UnregisterListenerMethod<zzaw, bs> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveResource f3892a;
    private final /* synthetic */ bs b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(zzch zzchVar, ListenerHolder.ListenerKey listenerKey, DriveResource driveResource, bs bsVar) {
        super(listenerKey);
        this.f3892a = driveResource;
        this.b = bsVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgm(this.f3892a.getDriveId(), 1), bs.a(this.b), (String) null, new zzhk(taskCompletionSource));
    }
}
