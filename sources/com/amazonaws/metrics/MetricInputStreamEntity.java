package com.amazonaws.metrics;

import com.amazonaws.internal.MetricAware;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.InputStreamEntity;

/* loaded from: classes.dex */
public class MetricInputStreamEntity extends InputStreamEntity {
    private static final int BUFFER_SIZE = 2048;
    private final ByteThroughputHelper helper;

    public MetricInputStreamEntity(ThroughputMetricType throughputMetricType, InputStream inputStream, long j) {
        super(inputStream, j);
        this.helper = new ByteThroughputHelper(throughputMetricType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.http.entity.InputStreamEntity, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if ((outputStream instanceof MetricAware) && ((MetricAware) outputStream).isMetricActivated()) {
            super.writeTo(outputStream);
        } else {
            writeToWithMetrics(outputStream);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void writeToWithMetrics(OutputStream outputStream) throws IOException {
        int read;
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream content = getContent();
        long contentLength = getContentLength();
        try {
            byte[] bArr = new byte[2048];
            if (contentLength < 0) {
                while (true) {
                    int read2 = content.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    long startTiming = this.helper.startTiming();
                    outputStream.write(bArr, 0, read2);
                    this.helper.increment(read2, startTiming);
                }
            } else {
                while (contentLength > 0 && (read = content.read(bArr, 0, (int) Math.min(2048L, contentLength))) != -1) {
                    long startTiming2 = this.helper.startTiming();
                    outputStream.write(bArr, 0, read);
                    this.helper.increment(read, startTiming2);
                    contentLength -= read;
                }
            }
        } finally {
            this.helper.reportMetrics();
            content.close();
        }
    }
}
