package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveFolder;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzk {

    /* renamed from: a, reason: collision with root package name */
    private String f1557a;

    private zzk(String str) {
        this.f1557a = str.toLowerCase(Locale.US);
    }

    public static zzk zze(String str) {
        Preconditions.checkArgument(str == null || !str.isEmpty());
        if (str == null) {
            return null;
        }
        return new zzk(str);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.f1557a.equals(((zzk) obj).f1557a);
    }

    public final int hashCode() {
        return this.f1557a.hashCode();
    }

    public final boolean isFolder() {
        return this.f1557a.equals(DriveFolder.MIME_TYPE);
    }

    public final String toString() {
        return this.f1557a;
    }

    public final boolean zzaz() {
        return this.f1557a.startsWith("application/vnd.google-apps");
    }
}
