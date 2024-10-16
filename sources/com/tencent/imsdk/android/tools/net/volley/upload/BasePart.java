package com.tencent.imsdk.android.tools.net.volley.upload;

import com.tencent.midas.comm.log.util.APLogFileUtil;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

/* loaded from: classes.dex */
abstract class BasePart implements Part {
    protected static final byte[] CRLF = EncodingUtils.getAsciiBytes(APLogFileUtil.SEPARATOR_LINE);
    private byte[] header;
    protected IHeadersProvider headersProvider;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface IHeadersProvider {
        String getContentDisposition();

        String getContentTransferEncoding();

        String getContentType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] getHeader(Boundary boundary) {
        if (this.header == null) {
            this.header = generateHeader(boundary);
        }
        return this.header;
    }

    private byte[] generateHeader(Boundary boundary) {
        if (this.headersProvider == null) {
            throw new RuntimeException("Uninitialized headersProvider");
        }
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(256);
        append(byteArrayBuffer, boundary.getStartingBoundary());
        append(byteArrayBuffer, this.headersProvider.getContentDisposition());
        append(byteArrayBuffer, CRLF);
        append(byteArrayBuffer, this.headersProvider.getContentType());
        append(byteArrayBuffer, CRLF);
        append(byteArrayBuffer, this.headersProvider.getContentTransferEncoding());
        append(byteArrayBuffer, CRLF);
        append(byteArrayBuffer, CRLF);
        return byteArrayBuffer.toByteArray();
    }

    private static void append(ByteArrayBuffer byteArrayBuffer, String str) {
        append(byteArrayBuffer, EncodingUtils.getAsciiBytes(str));
    }

    private static void append(ByteArrayBuffer byteArrayBuffer, byte[] bArr) {
        byteArrayBuffer.append(bArr, 0, bArr.length);
    }
}
