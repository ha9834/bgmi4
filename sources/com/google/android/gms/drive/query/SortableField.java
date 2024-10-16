package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.drive.zzhp;
import com.google.android.gms.internal.drive.zzic;
import java.util.Date;

/* loaded from: classes.dex */
public class SortableField {
    public static final SortableMetadataField<String> TITLE = zzhp.zzkb;
    public static final SortableMetadataField<Date> CREATED_DATE = zzic.zzkn;
    public static final SortableMetadataField<Date> MODIFIED_DATE = zzic.zzkp;
    public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE = zzic.zzkq;
    public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME = zzic.zzko;
    public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE = zzic.zzkr;
    public static final SortableMetadataField<Long> QUOTA_USED = zzhp.zzjy;

    /* renamed from: a, reason: collision with root package name */
    private static final SortableMetadataField<Date> f1564a = zzic.zzks;
}
