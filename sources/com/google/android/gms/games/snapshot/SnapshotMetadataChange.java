package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

/* loaded from: classes.dex */
public interface SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f1738a;
        private Long b;
        private Long c;
        private BitmapTeleporter d;
        private Uri e;

        public final Builder setDescription(String str) {
            this.f1738a = str;
            return this;
        }

        public final Builder setPlayedTimeMillis(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        public final Builder setProgressValue(long j) {
            this.c = Long.valueOf(j);
            return this;
        }

        public final Builder setCoverImage(Bitmap bitmap) {
            this.d = new BitmapTeleporter(bitmap);
            this.e = null;
            return this;
        }

        public final Builder fromMetadata(SnapshotMetadata snapshotMetadata) {
            this.f1738a = snapshotMetadata.getDescription();
            this.b = Long.valueOf(snapshotMetadata.getPlayedTime());
            this.c = Long.valueOf(snapshotMetadata.getProgressValue());
            if (this.b.longValue() == -1) {
                this.b = null;
            }
            this.e = snapshotMetadata.getCoverImageUri();
            if (this.e != null) {
                this.d = null;
            }
            return this;
        }

        public final SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.f1738a, this.b, this.d, this.e, this.c);
        }
    }

    Bitmap getCoverImage();

    String getDescription();

    Long getPlayedTimeMillis();

    Long getProgressValue();

    BitmapTeleporter zzdt();
}
