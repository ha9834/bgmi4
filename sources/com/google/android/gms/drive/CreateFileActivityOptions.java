package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzq;

/* loaded from: classes.dex */
public final class CreateFileActivityOptions extends zzq {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        protected final CreateFileActivityBuilder f1522a = new CreateFileActivityBuilder();

        public CreateFileActivityOptions build() {
            this.f1522a.f();
            return new CreateFileActivityOptions(this.f1522a.b().zzp(), Integer.valueOf(this.f1522a.a()), this.f1522a.d(), this.f1522a.c(), this.f1522a.e());
        }

        public Builder setActivityStartFolder(DriveId driveId) {
            this.f1522a.setActivityStartFolder(driveId);
            return this;
        }

        public Builder setActivityTitle(String str) {
            this.f1522a.setActivityTitle(str);
            return this;
        }

        public Builder setInitialDriveContents(DriveContents driveContents) {
            this.f1522a.setInitialDriveContents(driveContents);
            return this;
        }

        public Builder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
            this.f1522a.setInitialMetadata(metadataChangeSet);
            return this;
        }
    }

    private CreateFileActivityOptions(MetadataBundle metadataBundle, Integer num, String str, DriveId driveId, int i) {
        super(metadataBundle, num, str, driveId, i);
    }
}
