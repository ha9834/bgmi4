package com.tencent.imsdk.android.tools.net.volley.upload;

import com.tencent.imsdk.android.tools.net.volley.upload.BasePart;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class StringPart extends BasePart {
    private final byte[] valueBytes;

    public StringPart(String str, String str2, final String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Value may not be null");
        }
        final String encode = UrlEncodingHelper.encode(str, "US-ASCII");
        str3 = str3 == null ? "ISO-8859-1" : str3;
        try {
            this.valueBytes = str2.getBytes(str3);
            this.headersProvider = new BasePart.IHeadersProvider() { // from class: com.tencent.imsdk.android.tools.net.volley.upload.StringPart.1
                @Override // com.tencent.imsdk.android.tools.net.volley.upload.BasePart.IHeadersProvider
                public String getContentTransferEncoding() {
                    return "Content-Transfer-Encoding: 8bit";
                }

                @Override // com.tencent.imsdk.android.tools.net.volley.upload.BasePart.IHeadersProvider
                public String getContentDisposition() {
                    return "Content-Disposition: form-data; name=\"" + encode + '\"';
                }

                @Override // com.tencent.imsdk.android.tools.net.volley.upload.BasePart.IHeadersProvider
                public String getContentType() {
                    return "Content-Type: text/plain; charset=" + str3;
                }
            };
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public StringPart(String str, String str2) {
        this(str, str2, null);
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.upload.Part
    public long getContentLength(Boundary boundary) {
        return getHeader(boundary).length + this.valueBytes.length + CRLF.length;
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.upload.Part
    public void writeTo(OutputStream outputStream, Boundary boundary) throws IOException {
        outputStream.write(getHeader(boundary));
        outputStream.write(this.valueBytes);
        outputStream.write(CRLF);
    }
}
