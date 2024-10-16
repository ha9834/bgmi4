package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class zzhw extends com.google.android.gms.drive.metadata.internal.zzl<DriveSpace> {
    public zzhw(int i) {
        super("spaces", Arrays.asList("inDriveSpace", "isAppData", "inGooglePhotosSpace"), Collections.emptySet(), GmsVersion.VERSION_ORLA);
    }

    @Override // com.google.android.gms.drive.metadata.zzb, com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object b(DataHolder dataHolder, int i, int i2) {
        return b(dataHolder, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zzb
    /* renamed from: b_ */
    public final Collection<DriveSpace> b(DataHolder dataHolder, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (dataHolder.getBoolean("inDriveSpace", i, i2)) {
            arrayList.add(DriveSpace.zzaf);
        }
        if (dataHolder.getBoolean("isAppData", i, i2)) {
            arrayList.add(DriveSpace.zzag);
        }
        if (dataHolder.getBoolean("inGooglePhotosSpace", i, i2)) {
            arrayList.add(DriveSpace.zzah);
        }
        return arrayList;
    }
}
