package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class bn extends TaskApiCall<zzaw, Metadata> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ MetadataChangeSet f3906a;
    private final /* synthetic */ DriveResource b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(zzch zzchVar, MetadataChangeSet metadataChangeSet, DriveResource driveResource) {
        this.f3906a = metadataChangeSet;
        this.b = driveResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Metadata> taskCompletionSource) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        this.f3906a.zzp().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzgz(this.b.getDriveId(), this.f3906a.zzp()), new zzhj(taskCompletionSource));
    }
}
