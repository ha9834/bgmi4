package com.amazonaws.http;

import com.amazonaws.Request;
import com.amazonaws.metrics.MetricInputStreamEntity;
import com.amazonaws.metrics.ServiceMetricType;
import com.amazonaws.metrics.ThroughputMetricType;
import com.amazonaws.metrics.internal.ServiceMetricTypeGuesser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.InputStreamEntity;

/* loaded from: classes.dex */
class RepeatableInputStreamRequestEntity extends BasicHttpEntity {
    private static final Log log = LogFactory.getLog(AmazonHttpClient.class);
    private InputStream content;
    private boolean firstAttempt = true;
    private InputStreamEntity inputStreamRequestEntity;
    private IOException originalException;

    @Override // org.apache.http.entity.AbstractHttpEntity, org.apache.http.HttpEntity
    public boolean isChunked() {
        return false;
    }

    RepeatableInputStreamRequestEntity(Request<?> request) {
        setChunked(false);
        long j = -1;
        try {
            String str = request.getHeaders().get("Content-Length");
            if (str != null) {
                j = Long.parseLong(str);
            }
        } catch (NumberFormatException unused) {
            log.warn("Unable to parse content length from request.  Buffering contents in memory.");
        }
        String str2 = request.getHeaders().get("Content-Type");
        ThroughputMetricType guessThroughputMetricType = ServiceMetricTypeGuesser.guessThroughputMetricType(request, ServiceMetricType.UPLOAD_THROUGHPUT_NAME_SUFFIX, ServiceMetricType.UPLOAD_BYTE_COUNT_NAME_SUFFIX);
        if (guessThroughputMetricType == null) {
            this.inputStreamRequestEntity = new InputStreamEntity(request.getContent(), j);
        } else {
            this.inputStreamRequestEntity = new MetricInputStreamEntity(guessThroughputMetricType, request.getContent(), j);
        }
        this.inputStreamRequestEntity.setContentType(str2);
        this.content = request.getContent();
        setContent(this.content);
        setContentType(str2);
        setContentLength(j);
    }

    @Override // org.apache.http.entity.BasicHttpEntity, org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.content.markSupported() || this.inputStreamRequestEntity.isRepeatable();
    }

    @Override // org.apache.http.entity.BasicHttpEntity, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            if (!this.firstAttempt && isRepeatable()) {
                this.content.reset();
            }
            this.firstAttempt = false;
            this.inputStreamRequestEntity.writeTo(outputStream);
        } catch (IOException e) {
            if (this.originalException == null) {
                this.originalException = e;
            }
            throw this.originalException;
        }
    }
}
