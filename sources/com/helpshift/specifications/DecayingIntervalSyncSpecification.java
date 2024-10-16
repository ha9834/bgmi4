package com.helpshift.specifications;

import com.helpshift.util.ErrorReportProvider;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DecayingIntervalSyncSpecification implements SyncSpecification {
    private final String dataType;
    private long elapsedTimeThreshold;
    private long maxTimeThresholdLimit = ErrorReportProvider.BATCH_TIME;

    public DecayingIntervalSyncSpecification(int i, TimeUnit timeUnit, String str) {
        this.elapsedTimeThreshold = TimeUnit.MILLISECONDS.convert(i, timeUnit);
        this.dataType = str;
    }

    @Override // com.helpshift.specifications.SyncSpecification
    public String getDataType() {
        return this.dataType;
    }

    @Override // com.helpshift.specifications.SyncSpecification
    public boolean isSatisfied(int i, long j) {
        return i > 0 && Math.abs(j) > this.elapsedTimeThreshold;
    }

    public void decayElapsedTimeThreshold() {
        double d = this.elapsedTimeThreshold;
        Double.isNaN(d);
        this.elapsedTimeThreshold = (long) (d * 1.618d);
        long j = this.elapsedTimeThreshold;
        long j2 = this.maxTimeThresholdLimit;
        if (j > j2) {
            this.elapsedTimeThreshold = j2;
        }
    }
}
