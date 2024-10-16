package com.helpshift.websockets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* loaded from: classes2.dex */
class DeflateCompressor {
    DeflateCompressor() {
    }

    public static byte[] compress(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater(-1, true);
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
        deflaterOutputStream.write(bArr, 0, bArr.length);
        deflaterOutputStream.close();
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }
}
