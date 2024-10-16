package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.metadata.SearchableMetadataField;

/* loaded from: classes2.dex */
public final class zzhz extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
    public zzhz(String str, int i) {
        super(str, GmsVersion.VERSION_HALLOUMI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.internal.zzb
    /* renamed from: a_ */
    public final Boolean b(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getInteger(getName(), i, i2) != 0);
    }

    @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Boolean b(DataHolder dataHolder, int i, int i2) {
        return b(dataHolder, i, i2);
    }
}
