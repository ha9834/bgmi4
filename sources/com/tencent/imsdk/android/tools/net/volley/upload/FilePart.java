package com.tencent.imsdk.android.tools.net.volley.upload;

import com.tencent.imsdk.android.tools.net.volley.VolleyLog;
import com.tencent.imsdk.android.tools.net.volley.upload.BasePart;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class FilePart extends BasePart {
    private final File file;

    public FilePart(String str, File file, String str2, final String str3) {
        if (file == null) {
            throw new IllegalArgumentException("File may not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.file = file;
        final String encode = UrlEncodingHelper.encode(str, "US-ASCII");
        final String encode2 = UrlEncodingHelper.encode(str2 == null ? file.getName() : str2, "US-ASCII");
        str3 = str3 == null ? "application/octet-stream" : str3;
        this.headersProvider = new BasePart.IHeadersProvider() { // from class: com.tencent.imsdk.android.tools.net.volley.upload.FilePart.1
            @Override // com.tencent.imsdk.android.tools.net.volley.upload.BasePart.IHeadersProvider
            public String getContentTransferEncoding() {
                return "Content-Transfer-Encoding: binary";
            }

            @Override // com.tencent.imsdk.android.tools.net.volley.upload.BasePart.IHeadersProvider
            public String getContentDisposition() {
                String str4 = "Content-Disposition: form-data; name=\"" + encode + "\"; filename=\"" + encode2 + '\"';
                VolleyLog.d("contentDisposition = " + str4, new Object[0]);
                return str4;
            }

            @Override // com.tencent.imsdk.android.tools.net.volley.upload.BasePart.IHeadersProvider
            public String getContentType() {
                return "Content-Type: " + str3;
            }
        };
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.upload.Part
    public long getContentLength(Boundary boundary) {
        return getHeader(boundary).length + this.file.length() + CRLF.length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.imsdk.android.tools.net.volley.upload.Part
    public void writeTo(OutputStream outputStream, Boundary boundary) throws IOException {
        outputStream.write(getHeader(boundary));
        FileInputStream fileInputStream = new FileInputStream(this.file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    outputStream.write(CRLF);
                    return;
                }
            }
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }
}
