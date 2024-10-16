package com.tencent.imsdk.android.tools.net.volley.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.entity.AbstractHttpEntity;

/* loaded from: classes.dex */
public class MultipartEntity extends AbstractHttpEntity implements Cloneable {
    static final String CRLF = "\r\n";
    private Boundary boundary;
    private List<Part> parts;

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        return null;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    public MultipartEntity(String str) {
        this.parts = new ArrayList();
        this.boundary = new Boundary(str);
        setContentType("multipart/form-data; boundary=\"" + this.boundary.getBoundary() + '\"');
    }

    public MultipartEntity() {
        this(null);
    }

    public void addPart(Part part) {
        this.parts.add(part);
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        Iterator<Part> it = this.parts.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().getContentLength(this.boundary);
        }
        return j + this.boundary.getClosingBoundary().length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        Iterator<Part> it = this.parts.iterator();
        while (it.hasNext()) {
            it.next().writeTo(outputStream, this.boundary);
        }
        outputStream.write(this.boundary.getClosingBoundary());
        outputStream.flush();
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("MultipartEntity does not support cloning");
    }
}
