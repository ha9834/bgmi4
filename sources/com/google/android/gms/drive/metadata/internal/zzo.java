package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class zzo extends zzl<DriveId> implements SearchableCollectionMetadataField<DriveId> {
    public static final zzg zziu = new a();

    public zzo(int i) {
        super("parents", Collections.emptySet(), Arrays.asList("parentsExtra", "dbInstanceId", "parentsExtraHolder"), GmsVersion.VERSION_HALLOUMI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(DataHolder dataHolder) {
        Bundle metadata = dataHolder.getMetadata();
        if (metadata == null) {
            return;
        }
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) metadata.getParcelable("parentsExtraHolder");
            if (dataHolder2 != null) {
                dataHolder2.close();
                metadata.remove("parentsExtraHolder");
            }
        }
    }

    @Override // com.google.android.gms.drive.metadata.internal.zzl, com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object a(Bundle bundle) {
        return a(bundle);
    }

    @Override // com.google.android.gms.drive.metadata.zzb, com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object b(DataHolder dataHolder, int i, int i2) {
        return b(dataHolder, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.internal.zzl
    /* renamed from: b */
    public final Collection<DriveId> a(Bundle bundle) {
        Collection a2 = super.a(bundle);
        if (a2 == null) {
            return null;
        }
        return new HashSet(a2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zzb
    /* renamed from: b_ */
    public final Collection<DriveId> b(DataHolder dataHolder, int i, int i2) {
        Bundle metadata = dataHolder.getMetadata();
        ArrayList parcelableArrayList = metadata.getParcelableArrayList("parentsExtra");
        if (parcelableArrayList == null) {
            if (metadata.getParcelable("parentsExtraHolder") != null) {
                synchronized (dataHolder) {
                    DataHolder dataHolder2 = (DataHolder) dataHolder.getMetadata().getParcelable("parentsExtraHolder");
                    if (dataHolder2 != null) {
                        try {
                            int count = dataHolder.getCount();
                            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(count);
                            HashMap hashMap = new HashMap(count);
                            for (int i3 = 0; i3 < count; i3++) {
                                int windowIndex = dataHolder.getWindowIndex(i3);
                                ParentDriveIdSet parentDriveIdSet = new ParentDriveIdSet();
                                arrayList.add(parentDriveIdSet);
                                hashMap.put(Long.valueOf(dataHolder.getLong("sqlId", i3, windowIndex)), parentDriveIdSet);
                            }
                            Bundle metadata2 = dataHolder2.getMetadata();
                            String string = metadata2.getString("childSqlIdColumn");
                            String string2 = metadata2.getString("parentSqlIdColumn");
                            String string3 = metadata2.getString("parentResIdColumn");
                            int count2 = dataHolder2.getCount();
                            for (int i4 = 0; i4 < count2; i4++) {
                                int windowIndex2 = dataHolder2.getWindowIndex(i4);
                                ParentDriveIdSet parentDriveIdSet2 = (ParentDriveIdSet) hashMap.get(Long.valueOf(dataHolder2.getLong(string, i4, windowIndex2)));
                                parentDriveIdSet2.f1554a.add(new zzq(dataHolder2.getString(string3, i4, windowIndex2), dataHolder2.getLong(string2, i4, windowIndex2), 1));
                            }
                            dataHolder.getMetadata().putParcelableArrayList("parentsExtra", arrayList);
                        } finally {
                            dataHolder2.close();
                            dataHolder.getMetadata().remove("parentsExtraHolder");
                        }
                    }
                }
                parcelableArrayList = metadata.getParcelableArrayList("parentsExtra");
            }
            if (parcelableArrayList == null) {
                return null;
            }
        }
        long j = metadata.getLong("dbInstanceId");
        ParentDriveIdSet parentDriveIdSet3 = (ParentDriveIdSet) parcelableArrayList.get(i);
        HashSet hashSet = new HashSet();
        for (zzq zzqVar : parentDriveIdSet3.f1554a) {
            hashSet.add(new DriveId(zzqVar.f1558a, zzqVar.b, j, zzqVar.c));
        }
        return hashSet;
    }
}
