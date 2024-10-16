package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.drive.zzbi;

@Deprecated
/* loaded from: classes.dex */
public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.drive.zzt f1521a = new com.google.android.gms.internal.drive.zzt(0);
    private DriveContents b;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.f1521a.getRequestId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MetadataChangeSet b() {
        return this.f1521a.zzb();
    }

    public IntentSender build(GoogleApiClient googleApiClient) {
        Preconditions.checkState(googleApiClient.isConnected(), "Client must be connected");
        f();
        return this.f1521a.build(googleApiClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DriveId c() {
        return this.f1521a.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f1521a.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e() {
        com.google.android.gms.internal.drive.zzt zztVar = this.f1521a;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        Preconditions.checkState(this.c, "Must call setInitialDriveContents.");
        DriveContents driveContents = this.b;
        if (driveContents != null) {
            driveContents.zzi();
        }
        this.f1521a.zzf();
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.f1521a.zza(driveId);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String str) {
        this.f1521a.zzc(str);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            this.f1521a.zzd(1);
        } else {
            if (!(driveContents instanceof zzbi)) {
                throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
            }
            if (driveContents.getDriveId() != null) {
                throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
            }
            if (driveContents.zzj()) {
                throw new IllegalArgumentException("DriveContents are already closed.");
            }
            this.f1521a.zzd(driveContents.zzh().f1520a);
            this.b = driveContents;
        }
        this.c = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.f1521a.zza(metadataChangeSet);
        return this;
    }
}
