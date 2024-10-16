package com.tencent.imsdk.android.tools.net.volley.upload;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public interface Part {
    long getContentLength(Boundary boundary);

    void writeTo(OutputStream outputStream, Boundary boundary) throws IOException;
}
