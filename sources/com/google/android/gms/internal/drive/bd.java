package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.events.OpenFileCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class bd extends RegisterListenerMethod<zzaw, OpenFileCallback> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveFile f3897a;
    private final /* synthetic */ int b;
    private final /* synthetic */ zzg c;
    private final /* synthetic */ ListenerHolder d;
    private final /* synthetic */ zzch e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(zzch zzchVar, ListenerHolder listenerHolder, DriveFile driveFile, int i, zzg zzgVar, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.e = zzchVar;
        this.f3897a = driveFile;
        this.b = i;
        this.c = zzgVar;
        this.d = listenerHolder2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.c.setCancelToken(ICancelToken.Stub.asInterface(((zzeo) zzawVar.getService()).zza(new zzgd(this.f3897a.getDriveId(), this.b, 0), new bu(this.e, this.c, this.d)).f3957a));
        taskCompletionSource.setResult(null);
    }
}
