package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class br extends TaskApiCall<zzaw, DriveFile> {

    /* renamed from: a, reason: collision with root package name */
    private final DriveFolder f3909a;
    private final MetadataChangeSet b;
    private final DriveContents c;
    private ExecutionOptions d;
    private String e = null;
    private com.google.android.gms.drive.metadata.internal.zzk f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(DriveFolder driveFolder, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions, String str) {
        this.f3909a = driveFolder;
        this.b = metadataChangeSet;
        this.c = driveContents;
        this.d = executionOptions;
        Preconditions.checkNotNull(driveFolder, "DriveFolder must not be null");
        Preconditions.checkNotNull(driveFolder.getDriveId(), "Folder's DriveId must not be null");
        Preconditions.checkNotNull(metadataChangeSet, "MetadataChangeSet must not be null");
        Preconditions.checkNotNull(executionOptions, "ExecutionOptions must not be null");
        this.f = com.google.android.gms.drive.metadata.internal.zzk.zze(metadataChangeSet.getMimeType());
        com.google.android.gms.drive.metadata.internal.zzk zzkVar = this.f;
        if (zzkVar != null && zzkVar.isFolder()) {
            throw new IllegalArgumentException("May not create folders using this method. Use DriveFolderManagerClient#createFolder() instead of mime type application/vnd.google-apps.folder");
        }
        if (driveContents != null) {
            if (!(driveContents instanceof zzbi)) {
                throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
            }
            if (driveContents.getDriveId() != null) {
                throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
            }
            if (driveContents.zzj()) {
                throw new IllegalArgumentException("DriveContents are already closed.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveFile> taskCompletionSource) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        this.d.zza(zzawVar2);
        MetadataChangeSet metadataChangeSet = this.b;
        metadataChangeSet.zzp().zza(zzawVar2.getContext());
        int a2 = zzbs.a(this.c, this.f);
        com.google.android.gms.drive.metadata.internal.zzk zzkVar = this.f;
        ((zzeo) zzawVar2.getService()).zza(new zzw(this.f3909a.getDriveId(), metadataChangeSet.zzp(), a2, (zzkVar == null || !zzkVar.zzaz()) ? 0 : 1, this.d), new zzhd(taskCompletionSource));
    }
}
