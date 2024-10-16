package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public final class zzaa extends Metadata {

    /* renamed from: a, reason: collision with root package name */
    private final MetadataBundle f3949a;

    public zzaa(MetadataBundle metadataBundle) {
        this.f3949a = metadataBundle;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Metadata freeze() {
        return new zzaa(this.f3949a.zzax());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return this.f3949a != null;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f3949a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17);
        sb.append("Metadata [mImpl=");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.drive.Metadata
    public final <T> T zza(MetadataField<T> metadataField) {
        return (T) this.f3949a.zza(metadataField);
    }
}
