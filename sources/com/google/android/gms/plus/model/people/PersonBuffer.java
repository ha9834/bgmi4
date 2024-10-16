package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.plus.zzac;
import com.google.android.gms.internal.plus.zzr;

@VisibleForTesting
@Deprecated
/* loaded from: classes2.dex */
public final class PersonBuffer extends AbstractDataBuffer<Person> {
    private final DataBufferSafeParcelable<zzr> b;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.getMetadata() == null || !dataHolder.getMetadata().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.b = null;
        } else {
            this.b = new DataBufferSafeParcelable<>(dataHolder, zzr.CREATOR);
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @Deprecated
    public final Person get(int i) {
        DataBufferSafeParcelable<zzr> dataBufferSafeParcelable = this.b;
        return dataBufferSafeParcelable != null ? dataBufferSafeParcelable.get(i) : new zzac(this.f1413a, i);
    }
}
