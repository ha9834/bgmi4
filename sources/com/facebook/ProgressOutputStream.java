package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    private long batchProgress;
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    private long maxProgress;
    private final Map<GraphRequest, RequestProgress> progressMap;
    private final GraphRequestBatch requests;
    private final long threshold;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j) {
        super(outputStream);
        this.requests = graphRequestBatch;
        this.progressMap = map;
        this.maxProgress = j;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    private void addProgress(long j) {
        RequestProgress requestProgress = this.currentRequestProgress;
        if (requestProgress != null) {
            requestProgress.addProgress(j);
        }
        this.batchProgress += j;
        long j2 = this.batchProgress;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportBatchProgress();
        }
    }

    private void reportBatchProgress() {
        if (this.batchProgress > this.lastReportedProgress) {
            for (GraphRequestBatch.Callback callback : this.requests.getCallbacks()) {
                if (callback instanceof GraphRequestBatch.OnProgressCallback) {
                    Handler callbackHandler = this.requests.getCallbackHandler();
                    final GraphRequestBatch.OnProgressCallback onProgressCallback = (GraphRequestBatch.OnProgressCallback) callback;
                    if (callbackHandler == null) {
                        onProgressCallback.onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    } else {
                        callbackHandler.post(new Runnable() { // from class: com.facebook.ProgressOutputStream.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CrashShieldHandler.isObjectCrashing(this)) {
                                    return;
                                }
                                try {
                                    onProgressCallback.onBatchProgress(ProgressOutputStream.this.requests, ProgressOutputStream.this.batchProgress, ProgressOutputStream.this.maxProgress);
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        });
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    long getBatchProgress() {
        return this.batchProgress;
    }

    long getMaxProgress() {
        return this.maxProgress;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        addProgress(bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        addProgress(i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        addProgress(1L);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        Iterator<RequestProgress> it = this.progressMap.values().iterator();
        while (it.hasNext()) {
            it.next().reportProgress();
        }
        reportBatchProgress();
    }
}
