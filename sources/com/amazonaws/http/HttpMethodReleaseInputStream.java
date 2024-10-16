package com.amazonaws.http;

import com.amazonaws.internal.SdkInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.methods.AbortableHttpRequest;

/* loaded from: classes.dex */
public class HttpMethodReleaseInputStream extends SdkInputStream {
    private static final Log log = LogFactory.getLog(HttpMethodReleaseInputStream.class);
    private boolean alreadyReleased;
    private HttpEntityEnclosingRequest httpRequest;
    private InputStream in;
    private boolean underlyingStreamConsumed;

    public HttpMethodReleaseInputStream(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        this.httpRequest = httpEntityEnclosingRequest;
        try {
            this.in = httpEntityEnclosingRequest.getEntity().getContent();
        } catch (IOException e) {
            if (log.isWarnEnabled()) {
                log.warn("Unable to obtain HttpMethod's response data stream", e);
            }
            try {
                httpEntityEnclosingRequest.getEntity().getContent().close();
            } catch (Exception unused) {
            }
            this.in = new ByteArrayInputStream(new byte[0]);
        }
    }

    public HttpEntityEnclosingRequest getHttpRequest() {
        return this.httpRequest;
    }

    protected void releaseConnection() throws IOException {
        if (this.alreadyReleased) {
            return;
        }
        if (!this.underlyingStreamConsumed) {
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = this.httpRequest;
            if (httpEntityEnclosingRequest instanceof AbortableHttpRequest) {
                ((AbortableHttpRequest) httpEntityEnclosingRequest).abort();
            }
        }
        this.in.close();
        this.alreadyReleased = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            int read = this.in.read();
            if (read == -1) {
                this.underlyingStreamConsumed = true;
                if (!this.alreadyReleased) {
                    releaseConnection();
                    if (log.isDebugEnabled()) {
                        log.debug("Released HttpMethod as its response data stream is fully consumed");
                    }
                }
            }
            return read;
        } catch (IOException e) {
            releaseConnection();
            if (log.isDebugEnabled()) {
                log.debug("Released HttpMethod as its response data stream threw an exception", e);
            }
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.in.read(bArr, i, i2);
            if (read == -1) {
                this.underlyingStreamConsumed = true;
                if (!this.alreadyReleased) {
                    releaseConnection();
                    if (log.isDebugEnabled()) {
                        log.debug("Released HttpMethod as its response data stream is fully consumed");
                    }
                }
            }
            return read;
        } catch (IOException e) {
            releaseConnection();
            if (log.isDebugEnabled()) {
                log.debug("Released HttpMethod as its response data stream threw an exception", e);
            }
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.in.available();
        } catch (IOException e) {
            releaseConnection();
            if (log.isDebugEnabled()) {
                log.debug("Released HttpMethod as its response data stream threw an exception", e);
            }
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.alreadyReleased) {
            releaseConnection();
            if (log.isDebugEnabled()) {
                log.debug("Released HttpMethod as its response data stream is closed");
            }
        }
        this.in.close();
    }

    protected void finalize() throws Throwable {
        if (!this.alreadyReleased) {
            if (log.isWarnEnabled()) {
                log.warn("Attempting to release HttpMethod in finalize() as its response data stream has gone out of scope. This attempt will not always succeed and cannot be relied upon! Please ensure S3 response data streams are always fully consumed or closed to avoid HTTP connection starvation.");
            }
            releaseConnection();
            if (log.isWarnEnabled()) {
                log.warn("Successfully released HttpMethod in finalize(). You were lucky this time... Please ensure S3 response data streams are always fully consumed or closed.");
            }
        }
        super.finalize();
    }

    @Override // com.amazonaws.internal.SdkInputStream
    protected InputStream getWrappedInputStream() {
        return this.in;
    }
}
