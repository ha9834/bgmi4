package com.google.android.gms.drive;

import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import java.util.List;

/* loaded from: classes.dex */
public final class OpenFileActivityOptions {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    public final String zzay;
    public final String[] zzaz;
    public final DriveId zzbb;
    public final FilterHolder zzbc;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final OpenFileActivityBuilder f1533a = new OpenFileActivityBuilder();

        public OpenFileActivityOptions build() {
            this.f1533a.e();
            return new OpenFileActivityOptions(this.f1533a.a(), this.f1533a.b(), this.f1533a.c(), this.f1533a.d());
        }

        public Builder setActivityStartFolder(DriveId driveId) {
            this.f1533a.setActivityStartFolder(driveId);
            return this;
        }

        public Builder setActivityTitle(String str) {
            this.f1533a.setActivityTitle(str);
            return this;
        }

        public Builder setMimeType(List<String> list) {
            this.f1533a.setMimeType((String[]) list.toArray(new String[0]));
            return this;
        }

        public Builder setSelectionFilter(Filter filter) {
            this.f1533a.setSelectionFilter(filter);
            return this;
        }
    }

    private OpenFileActivityOptions(String str, String[] strArr, Filter filter, DriveId driveId) {
        this.zzay = str;
        this.zzaz = strArr;
        this.zzbc = filter == null ? null : new FilterHolder(filter);
        this.zzbb = driveId;
    }
}
