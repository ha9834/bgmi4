package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.Date;

/* loaded from: classes.dex */
public class zze extends com.google.android.gms.drive.metadata.zzd<Date> {
    public zze(String str, int i) {
        super(str, i);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object a(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ void a(Bundle bundle, Object obj) {
        bundle.putLong(getName(), ((Date) obj).getTime());
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object b(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.getLong(getName(), i, i2));
    }
}
