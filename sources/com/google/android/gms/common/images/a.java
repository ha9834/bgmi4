package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f1430a;

    public a(Uri uri) {
        this.f1430a = uri;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f1430a);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Objects.equal(((a) obj).f1430a, this.f1430a);
    }
}
