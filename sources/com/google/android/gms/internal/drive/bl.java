package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class bl extends TaskApiCall<zzaw, DriveFolder> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ MetadataChangeSet f3904a;
    private final /* synthetic */ DriveFolder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(zzch zzchVar, MetadataChangeSet metadataChangeSet, DriveFolder driveFolder) {
        this.f3904a = metadataChangeSet;
        this.b = driveFolder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveFolder> taskCompletionSource) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        this.f3904a.zzp().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzy(this.b.getDriveId(), this.f3904a.zzp()), new zzhe(taskCompletionSource));
    }
}
