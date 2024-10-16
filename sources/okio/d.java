package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface d extends WritableByteChannel, p {
    d b(String str) throws IOException;

    d b(ByteString byteString) throws IOException;

    c c();

    d c(byte[] bArr) throws IOException;

    d c(byte[] bArr, int i, int i2) throws IOException;

    @Override // okio.p, java.io.Flushable
    void flush() throws IOException;

    d g(int i) throws IOException;

    d h(int i) throws IOException;

    d i(int i) throws IOException;

    d l(long j) throws IOException;

    d m(long j) throws IOException;

    d w() throws IOException;
}
