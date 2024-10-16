package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public abstract class SdkInputStream extends InputStream implements MetricAware {
    protected void abort() throws IOException {
    }

    protected abstract InputStream getWrappedInputStream();

    @Override // com.amazonaws.internal.MetricAware
    @Deprecated
    public final boolean isMetricActivated() {
        Closeable wrappedInputStream = getWrappedInputStream();
        if (wrappedInputStream instanceof MetricAware) {
            return ((MetricAware) wrappedInputStream).isMetricActivated();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void abortIfNeeded() {
        if (Thread.interrupted()) {
            try {
                abort();
            } catch (IOException e) {
                LogFactory.getLog(getClass()).debug("FYI", e);
            }
            throw new AbortedException();
        }
    }
}
