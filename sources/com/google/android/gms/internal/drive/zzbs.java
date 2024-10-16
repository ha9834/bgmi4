package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

/* loaded from: classes2.dex */
public final class zzbs extends zzdp implements DriveFolder {
    public zzbs(DriveId driveId) {
        super(driveId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(DriveContents driveContents, com.google.android.gms.drive.metadata.internal.zzk zzkVar) {
        if (driveContents == null) {
            return (zzkVar == null || !zzkVar.zzaz()) ? 1 : 0;
        }
        int requestId = driveContents.zzh().getRequestId();
        driveContents.zzi();
        return requestId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Query a(Query query, DriveId driveId) {
        Query.Builder addFilter = new Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, driveId));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        com.google.android.gms.drive.metadata.internal.zzk zze = com.google.android.gms.drive.metadata.internal.zzk.zze(metadataChangeSet.getMimeType());
        if (zze != null) {
            if (!((zze.zzaz() || zze.isFolder()) ? false : true)) {
                throw new IllegalArgumentException("May not create shortcut files using this method. Use DriveFolder.createShortcutFile() instead.");
            }
        }
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public final PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents) {
        return createFile(googleApiClient, metadataChangeSet, driveContents, null);
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public final PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new ExecutionOptions.Builder().build();
        }
        ExecutionOptions executionOptions2 = executionOptions;
        if (executionOptions2.zzm() != 0) {
            throw new IllegalStateException("May not set a conflict strategy for new file creation.");
        }
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        com.google.android.gms.drive.metadata.internal.zzk zze = com.google.android.gms.drive.metadata.internal.zzk.zze(metadataChangeSet.getMimeType());
        if (zze != null && zze.isFolder()) {
            throw new IllegalArgumentException("May not create folders using this method. Use DriveFolder.createFolder() instead of mime type application/vnd.google-apps.folder");
        }
        if (executionOptions2 == null) {
            throw new IllegalArgumentException("ExecutionOptions must be provided");
        }
        executionOptions2.zza(googleApiClient);
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
        a(metadataChangeSet);
        int a2 = a(driveContents, com.google.android.gms.drive.metadata.internal.zzk.zze(metadataChangeSet.getMimeType()));
        com.google.android.gms.drive.metadata.internal.zzk zze2 = com.google.android.gms.drive.metadata.internal.zzk.zze(metadataChangeSet.getMimeType());
        return googleApiClient.execute(new ae(this, googleApiClient, metadataChangeSet, a2, (zze2 == null || !zze2.zzaz()) ? 0 : 1, executionOptions2));
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public final PendingResult<DriveFolder.DriveFolderResult> createFolder(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        if (metadataChangeSet.getMimeType() == null || metadataChangeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return googleApiClient.execute(new af(this, googleApiClient, metadataChangeSet));
        }
        throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public final PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient googleApiClient) {
        return queryChildren(googleApiClient, null);
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public final PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient googleApiClient, Query query) {
        return new zzaf().query(googleApiClient, a(query, getDriveId()));
    }
}
