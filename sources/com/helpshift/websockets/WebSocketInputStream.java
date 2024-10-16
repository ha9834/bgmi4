package com.helpshift.websockets;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class WebSocketInputStream extends FilterInputStream {
    public WebSocketInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public String readLine() throws IOException {
        return Misc.readLine(this, "UTF-8");
    }

    public WebSocketFrame readFrame() throws IOException, WebSocketException {
        byte[] bArr = new byte[8];
        try {
            readBytes(bArr, 2);
            boolean z = (bArr[0] & 128) != 0;
            boolean z2 = (bArr[0] & 64) != 0;
            boolean z3 = (bArr[0] & 32) != 0;
            boolean z4 = (bArr[0] & 16) != 0;
            int i = bArr[0] & 15;
            boolean z5 = (bArr[1] & 128) != 0;
            long j = bArr[1] & Byte.MAX_VALUE;
            if (j == 126) {
                readBytes(bArr, 2);
                j = ((bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            } else if (j == 127) {
                readBytes(bArr, 8);
                if ((bArr[0] & 128) != 0) {
                    throw new WebSocketException(WebSocketError.INVALID_PAYLOAD_LENGTH, "The payload length of a frame is invalid.");
                }
                j = ((bArr[6] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 40) | ((bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 56) | ((bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 48) | ((bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 32) | ((bArr[4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((bArr[5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | (bArr[7] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            }
            byte[] bArr2 = null;
            if (z5) {
                bArr2 = new byte[4];
                readBytes(bArr2, 4);
            }
            if (2147483647L < j) {
                skipQuietly(j);
                throw new WebSocketException(WebSocketError.TOO_LONG_PAYLOAD, "The payload length of a frame exceeds the maximum array size in Java.");
            }
            return new WebSocketFrame().setFin(z).setRsv1(z2).setRsv2(z3).setRsv3(z4).setOpcode(i).setMask(z5).setPayload(readPayload(j, z5, bArr2));
        } catch (InsufficientDataException e) {
            if (e.getReadByteCount() == 0) {
                throw new NoMoreFrameException();
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readBytes(byte[] bArr, int i) throws IOException, WebSocketException {
        int i2 = 0;
        while (i2 < i) {
            int read = read(bArr, i2, i - i2);
            if (read <= 0) {
                throw new InsufficientDataException(i, i2);
            }
            i2 += read;
        }
    }

    private void skipQuietly(long j) {
        try {
            skip(j);
        } catch (IOException unused) {
        }
    }

    private byte[] readPayload(long j, boolean z, byte[] bArr) throws IOException, WebSocketException {
        if (j == 0) {
            return null;
        }
        try {
            byte[] bArr2 = new byte[(int) j];
            readBytes(bArr2, bArr2.length);
            if (z) {
                WebSocketFrame.mask(bArr, bArr2);
            }
            return bArr2;
        } catch (OutOfMemoryError e) {
            skipQuietly(j);
            throw new WebSocketException(WebSocketError.INSUFFICIENT_MEMORY_FOR_PAYLOAD, "OutOfMemoryError occurred during a trial to allocate a memory area for a frame's payload: " + e.getMessage(), e);
        }
    }
}
