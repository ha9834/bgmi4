package com.helpshift.specifications;

import android.annotation.TargetApi;
import com.helpshift.model.InfoModelFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DailyFrequencyBasedSyncSpecification implements SyncSpecification {
    private final String dataType;
    private final long elapsedTimeThreshold;

    @TargetApi(9)
    public DailyFrequencyBasedSyncSpecification(int i, String str) {
        this.elapsedTimeThreshold = TimeUnit.MILLISECONDS.convert(24 / i, TimeUnit.HOURS);
        this.dataType = str;
    }

    @Override // com.helpshift.specifications.SyncSpecification
    public String getDataType() {
        return this.dataType;
    }

    @Override // com.helpshift.specifications.SyncSpecification
    public boolean isSatisfied(int i, long j) {
        return InfoModelFactory.getInstance().sdkInfoModel.getDevicePropertiesSyncImmediately().booleanValue() || (i > 0 && Math.abs(j) > this.elapsedTimeThreshold);
    }
}
