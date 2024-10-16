package com.tencent.midas.comm.log.util.compressor;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class CachedByteArrayStream extends OutputStream {
    private final int BUFFER_SIZE;
    private final byte[] _bytes;
    protected byte[] buf;
    protected int count;

    public CachedByteArrayStream() {
        this.BUFFER_SIZE = 512;
        this._bytes = new byte[512];
        this.buf = this._bytes;
    }

    public CachedByteArrayStream(int i) {
        this.BUFFER_SIZE = 512;
        this._bytes = new byte[512];
        if (i >= 0) {
            this.buf = new byte[i];
            return;
        }
        throw new IllegalArgumentException("size < 0");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
    }

    private void expand(int i) {
        int i2 = this.count;
        int i3 = i2 + i;
        byte[] bArr = this.buf;
        if (i3 <= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[(i + i2) * 2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.buf = bArr2;
    }

    public synchronized void reset() {
        this.buf = this._bytes;
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    public synchronized byte[] toByteArray() {
        byte[] bArr;
        bArr = new byte[this.count];
        System.arraycopy(this.buf, 0, bArr, 0, this.count);
        return bArr;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Deprecated
    public String toString(int i) {
        char[] cArr = new char[size()];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = (char) (((i & 255) << 8) | (this.buf[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
        }
        return new String(cArr);
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.buf, 0, this.count, str);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        checkOffsetAndCount(bArr.length, i, i2);
        if (i2 == 0) {
            return;
        }
        expand(i2);
        System.arraycopy(bArr, i, this.buf, this.count, i2);
        this.count += i2;
    }

    private static void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException("arrayLength: " + i + ", offset: " + i2 + ", count: " + i3);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.count == this.buf.length) {
            expand(1);
        }
        byte[] bArr = this.buf;
        int i2 = this.count;
        this.count = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public synchronized void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.buf, 0, this.count);
    }
}
